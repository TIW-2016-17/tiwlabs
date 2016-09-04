# Lab 1. Web development

<!-- MarkdownTOC -->

- [First project](#first-project)
- [Exercise1. HellowWorld](#exercise1-helloworld)
- [Exercise2. Cabeceras](#ejercicio2-cabeceras)
- [Exercise3. Parametros](#ejercicio3-parametros)
- [Exercise4. Parametros por POST](#ejercicio4-parametros-por-post)
- [Exercise5. JSP](#ejercicio5-jsp)
- [Exercise6. ServletConfig y atributos](#ejercicio6-servletconfig-y-atributos)
- [Exercise7. Sesiones](#ejercicio7-sesiones)
- [Exercise8. Filtro logger](#ejercicio8-filtro-logger)
- [Exercise9. Filtros, Sesiones, Peticiones y Contexto](#ejercicio9-filtros-sesiones-peticiones-y-contexto)
- [Exercise10. Taglibs, Lenguaje de Expresiones y dominios](#ejercicio10-taglibs-lenguaje-de-expresiones-y-dominios)

<!-- /MarkdownTOC -->


## First project

1. Open a command console ( __Ctrl + Alt + t__ )
2. Create a directory called _tiwlabs_ : ( __mkdir tiwlabs__ )
3. __cd tiwlabs__
4. Enter the following command :

```shell
  mvn archetype:generate -DarchetypeGroupId=org.codehaus.mojo.archetypes -DarchetypeArtifactId=webapp-javaee7
```
 
Answer the questions that appear as follows (press enter to move to the next question):

        Define value for property 'groupId': : es.uc3m.tiw
        Define value for property 'artifactId': : laboratorios
        Define value for property 'version':  1.0-SNAPSHOT: :  (press Enter to accept)
        Define value for property 'package':  es.uc3m.tiw: :   (Enter)
        Confirm properties configuration:
        groupId: es.uc3m.tiw
        artifactId: laboratorios
        version: 1.0-SNAPSHOT
        package: es.uc3m.tiw
         Y: :  (write Y and press Enter)
 

After the following successful message appears :

```

[INFO] ----------------------------------------------------------------------------
[INFO] Using following parameters for creating project from Archetype: webapp-javaee7:1.1
[INFO] ----------------------------------------------------------------------------
[INFO] Parameter: groupId, Value: es.uc3m.tiw
[INFO] Parameter: artifactId, Value: laboratorios
[INFO] Parameter: version, Value: 1.0-SNAPSHOT
[INFO] Parameter: package, Value: es.uc3m.tiw
[INFO] Parameter: packageInPathFormat, Value: es/uc3m/tiw
[INFO] Parameter: package, Value: es.uc3m.tiw
[INFO] Parameter: version, Value: 1.0-SNAPSHOT
[INFO] Parameter: groupId, Value: es.uc3m.tiw
[INFO] Parameter: artifactId, Value: laboratorios
[INFO] project created from Archetype in dir: /home/tiw/tiwlabs/laboratorios
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------


```  


You'll have already a project created.

### Import the project in eclipse


1. Open STS
2. Open the maven's console  in the tab at the bottom  :
3. ![](images/Imagen1.png)
4. File -> Import -> Maven -> Existing Maven projects -> Next
5. Browse button . Locate the generated project  (/home/tiw/tiwlabs/laboratorios) -> Finish
6. You will see how maven download all the necessary dependencies to configure the project .
7. When finished you will see a structure created with the M of mave and the J of java
8. ![](images/Imagen2.png)


## Exercise1. HelloWorld

Let's get started with the development of Servlets with a first example :



1. First change the perspective :
    2. Click on the upper right corner in the _Open perspective_ button
    3. ![](images/Imagen3.png)
    4. Select __Java EE__
    5. ![](images/Imagen4.png)
2. Right click on _laboratorios->Java Resources->src/main/java->es.uc3m.tiw_ and select __New Package__
3. Enter the following package name: __es.uc3m.tiw.lab1__
4. On the new package (_es.uc3m.tiw.lab1_) right click and select __New -> Servlet__ and call it __Exercise1Servlet__
5. ![](images/Imagen5.png)
6. Change the __URL mapping__ in the following screen:
7. ![](images/Imagen6.png)
8. On the next screen select only the __doGet__ method and click Finish
9. ![](images/Imagen7.png)
10. Remove the auto-generated code within the __doGet__ method and type the following :

```java
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("Hi");
        out.close();
    }

```


11. Save the changes and start the Glassfish server
12. Right-click on the project __laboratorios__ and select __Run As -> Run on Server__
13. Select the __Glassfish__ server on the next screen, click _Next_ and _Finish_
14. After a few moments the default browser will open and you will see a message __Hello World__ , but that's not the message we have written:
15. Enter the following URL in your browser: __http://localhost:8080/laboratorios/hi__ and see the actual message.
16. You just finished the first year.

## Ejercicio2. Cabeceras

> Partimos de los conocimientos adquiridos en el ejercicio anterior. En esta ocasión vamos a extraer y mostrar toda la información que se encuentran en las cabeceras del cliente.

> Primero arreglaremos un problema que aparece en la pestaña inferior _"Problems"_ indicando que la versión del proyecto usa java 1.7 y nosotros tenemos java 1.8 instalado.

- Abre la consola de eclipse: __Menu Window->Show View->Console__
- En la pestaña console, muestra la consola de maven como hiciste en el ejercicio anterior.
- Abre el fichero __pom.xml__ del proyecto laboratorios (_doble click sobre el fichero_)
- En el editor que aparece haz clic sobre la __pestaña inferior pom.xml__ para ver el código fuente.
- Localiza el siguiente código:

```xml
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.1</version>
                <configuration>
                    <source>1.7</source>
                    <target>1.7</target>
                    <compilerArguments>
                        <endorseddirs>${endorsed.dir}</endorseddirs>
                    </compilerArguments>
                </configuration>
            </plugin>
```

- Cambia los valores _source y target_ de 1.7 a 1.8

```xml
                    <source>1.8</source>
                    <target>1.8</target>
```

- En este momento eclipse mostrará un error con un aspa roja.
- Selecciona el proyecto laboratorios con el botón derecho del ratón y elige __Maven->Update Project->Ok__
- Se eliminarán todos los errores y el proyecto estará configurado con JDK 1.8
- Puedes cerrar el fichero pom.xml

>Ahora comenzaremos con el desarrollo del ejercicio.


1. Crea un nuevo servlet en el paquete _es.uc3m.tiw.lab1_ que se llame __Ejercicio2Servlet__ 
2. En el _URL mapping_ cambia el string por __cabeceras__
3. Selecciona el método __doGet__
4. Escribe el código necesario para sacar todas las cabeceras del cliente que se conecta con el navegador.
5. Extrae también información relativa a su dirección de conexión, la url solicitada, el protocolo que ha usado, el servidor al que se ha conectado y el idioma usado.

> Para extraer toda esa información necesitarás la documentación del API servlet de Java en concreto ServletRequest [^1] y HttpServletRequest [^2]

## Ejercicio3. Parametros

> En esta ocasión vamos a reutilizar el código del ejercicio 1

1. Crea un nuevo servlet en el paquete _lab1_ que se llame __Ejercicio3Servlet__
2. En el _URL mapping_ cambia la cadena por __/parametros__
2. Copia el código del ejercicio 1
3. Crea el código necesario para que ahora el servlet imprima el mensaje: _Hola nombre_ donde _nombre_ será dinámicamente insertado por *QUERY_STRING*[^3]
4. La URL de acceso será: `http://localhost:8080/laboratorios/parametros?nombre=Juan` En este caso el servlet responderá: _Hola Juan_.

> Para este ejercicio necesitarás la documentación de la clase HttpServletRequest[^2]

## Ejercicio4. Parametros por POST

1. Crea un nuevo servlet con nombre __Ejercicio4Servlet__
2. __URL Mapping__: __/login__
3. Selecciona __doPost__ y __doGet__
4. Crea el código de un formulario que envíe los datos al servlet login. Hazlo dentro del método __doGet__

```html
    <form action="login" method="post">
        <fieldset>
            <legend>Login</legend>
            <label for="nom">Nombre:</label>
            <input type="text" id="nom" name="nombre"/> 
            <br>
            <label for="password">Clave</label>
            <input type="password" id="password" name="clave"/>
            <br>
            
        </fieldset>
        <input type="submit" value="Enviar">
    </form>
```

5. El servlet debe validar al usuario y clave enviado emitiendo una respuesta en caso favorable y otra en caso de error en el método__doPost__.
    6. Las respuestas deben ser con cabecera __text/html__ y código formateado
    7. El usuario válido es: __usuario1__ con __password1__
    8. La respuesta válida debe saludar al usuario con su nombre de usuario
    9. La respuesta inválida debe mostrar un mensaje indicando que no tiene acceso y un enlace para volver al formulario de login


> Documentación necesaria _HttpServletRequest_[^2]

## Ejercicio5. JSP

> Incorporar html dentro del propio servlet no es muy adecuado. En este ejercicio sacaremos el código html y lo serviremos desde páginas dinámicas.

1. Crea una página JSP llamada __login.jsp__ dentro de __laboratorios->Deployed Resources->webapp__ con __botón derecho->new->JSP File__
2. Incopora el código html de la página _login.html_
3. Crea dos páginas jsp más:
    4. __listado.jsp__: contendrá el código que muestra el __Ejercicio4Servlet__ en caso de que exista el usuario
    5. __error.jsp__: mostrará el mensaje de error actual del __Ejercicio4Servlet__
6. Borra el código que has incorporado a las jsps del _Ejercicio4Servlet_ y susitúyelo por un _RequestDispatcher_ haciendo un __forward__
7. Renombra el Ejercicio4Servlet a __LoginServlet__ (Pulsa con el botón derecho sobre la clase Ejercicio4Servlet y selecciona _Refactor->Rename_)

> Con esto conseguimos separar la lógica de negocio de la presentación. Para Este ejercicio necesitarás la documentación de RequestDispatcher[^4]

## Ejercicio6. ServletConfig y atributos

> En este ejercicio el servlet _LoginServlet_ cargará una lista de nombres de usuario en el método _init()_ y la hará disponible mediante el objeto _request_ a la página _listado.jsp_ que recorrerá la lista y pintará en una tabla los nombres de los usuarios.

1. Crear un `ArrayList` de tipo String en el método `init(ServletConfig config)` y llénalo con varios nombre de usuarios.
2. Cuando el usuario sea válido envíale a la página de listado junto con los datos de usuario.
    3. Necesitarás modificar el objeto request para añadir atributos.
4. En la página __listado.jsp__ recupera el atributo de la lista y escribe una tabla dinámica con los datos del ArrayList

> Para este ejercicio necesitarás la documentación de ServletRequest [^1] en concreto `getAttribute` y `setAttribute`

## Ejercicio7. Sesiones

> El objetivo de este ejercicio es que el usuario no tenga que pasar una y otra vez por el formulario de login para acceder al listado de nombres si ya se ha autenticado.

1. Crea un `HttpSession` en el __LoginServlet__ y añade un token a la sesión con el valor `autenticado=true` si el usuario es correcto y `autenticado=false` en caso contrario
2. LoginServlet debe controlar que si el usuario ya se ha autenticado puede acceder directamente o devolverle al formulario de login en caso contrario.
    3. En este caso, añade un atributo _"mensaje"_ al request y dicho mensaje debe ser leído en la página _login.jsp_.
    4. El mensaje debe poner que el usuario no es válido

> La documentación en este ejercicio será el API HttpSession[^5]

## Ejercicio8. Filtro logger

> Vamos a crear un filtro que permita controlar y trazar todos los pasos del usuario. Reutilizaremos parte del código del servlet de las cabeceras.

1. Crea un nuevo paquete en `es.uc3m.tiw.lab1.filters` 
2. Crea un nuevo Filtro en dicho paquete (New->Filter)
3. Pon de Nombre: __LoggerFilter__
4. ![](images/Imagen8.png)
5. Pulsa __Next__ y en la siguiente pantalla cambia el _URL pattern_ por __/*__
6. ![](images/Imagen9.png)
7. __Next->Finish__
8. Dentro del método `doFilter` pon el código necesario y termina con `chain.doFilter(request,response)`

> El filtro debe mostrar por consola un registro de navegación del usuario del tipo: `<fecha> - <ip> - <protocolo> - <método> - <url> `. Un filtro avanzado registraría estos datos en un log del sistema, pero simplemente lo sacamos por consola por propósitos del laboratorio.


> Ahora al navegar normalmente verás por consola todos tus movimientos del tipo:

```
26-08-2016 11:28:37 - 0:0:0:0:0:0:0:1 - HTTP/1.1 - GET - http://localhost8080/laboratorios/login
26-08-2016 11:28:50 - 0:0:0:0:0:0:0:1 - HTTP/1.1 - POST - http://localhost8080/laboratorios/login
26-08-2016 11:29:32 - 0:0:0:0:0:0:0:1 - HTTP/1.1 - GET - http://localhost8080/laboratorios/cabeceras
```

## Ejercicio9. Filtros, Sesiones, Peticiones y Contexto

> Aunque permitimos que el usuario no necesite volver a pasar por el formulario de login mediante sesiones, eso no impide que un usuario que conozca la página _listado.jsp_ pueda acceder directamente a ella sin autenticarse. 
> 
> Por lo que en este ejercicio se propone controlar el acceso a la página _listado.jsp_ mediante un filtro que compruebe si el usuario dispone del token de autenticación en sesión.
> 
> __NOTA:__ aunque el usuario pueda acceder directamente al _listado.jsp_ esta página devolverá un _NullPointerException_ al no poder leer la lista de usuarios que el _LoginServlet_ le envía por request. Por lo que se propone como mejora del código controlar este error, o bien incorporar la lista de usuarios en _contexto_.
> 
> En este ejercicio se pueden apreciar las diferencias entre:
> - peticiones (request)
> - sesiones
> - filtros
> - contexto

1. Crea un nuevo filtro en el paquete _filters_
2. Nombre: __SecurityFilter__
3. URL pattern: __/listado.jsp__
4. Pon el código necesario en el método __doFilter__ para controlar si el usuario dispone de sesión para acceder, en caso contrario redirigirle al login.

## Ejercicio10. Taglibs, Lenguaje de Expresiones y dominios

> En este ejercicio vamos a refactorizar nuestras vistas añadiendo Expression Language (__EL__)[^6] y usando Taglibs __JSTL__[^7] para mejorarlas.
> También vamos a sacar los datos del array de usuarios para hacerlo más dinámico y funcional mediante una capa de objetos de dominio.

1. Modifica el código de __login.jsp__ sustituyendo todo el código java por jstl y EL
2. Haz lo mismo con la página __listado.jsp__
3. Crea una __clase java normal__ llamada __Usuario__ en un nuevo paquete _es.uc3m.tiw.lab1.dominios_ que tenga las siguiente propiedades y sus correspondientes métodos get/set:

```java
    String nombre;
    String apellidos;
    String usuario;
    String password;

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    ...
```

4. Modifica el código del __LoginServlet__ para que ahora:
    5. Contenga una lista de objetos Usuario ya creados
    6. Que tenga una lógica nueva que permita acceder a cualquier usuario/password definidos en esa lista
    7. Que pase al objeto usuario autenticado en sesión para que sea recibido por cualquier página a la que tenga acceso.



[^1]: [ServletRequest](http://docs.oracle.com/javaee/7/api/javax/servlet/ServletRequest.html)
[^2]: [HttpServletRequest](http://docs.oracle.com/javaee/7/api/javax/servlet/http/HttpServletRequest.html)
[^3]: [Query_string](https://es.wikipedia.org/wiki/Query_string)
[^4]: [RequestDispatcher](https://docs.oracle.com/javaee/7/api/javax/servlet/RequestDispatcher.html)
[^5]: [HttpSession](https://docs.oracle.com/javaee/7/api/javax/servlet/http/HttpSession.html)
[^6]: [Expression Language](https://uel.java.net/)
[^7]: [JSP Standard Tag Library (JSTL)](https://jstl.java.net/)

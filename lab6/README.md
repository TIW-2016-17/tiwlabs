# Lab6. RESTful Services

<!-- MarkdownTOC -->

- [REST Software](#rest-software)
- [Exercise1. Configuration](#exercise1-configuration)
- [Exercise2. Service creation](#exercise2-service-creation)
- [Exercise3. Paso de parámetros](#exercise3-paso-de-parámetros)
- [Exercise4. POST y documentos](#exercise4-post-y-documentos)
- [Exercise5. JSON](#exercise5-json)
- [Forge](#forge)

<!-- /MarkdownTOC -->

## REST Software

>You need a software that allow you to use connection methods different to GET and POST, therefor you can use the third party software __REStClient__ from [http://www.wiztools.org]() either install the Chromium plugin __Advanced REST Client__

1. Open Chromium and access to the webstore [https://chrome.google.com/webstore/category/extensions?hl=en-US]()
2. Find the __Advanced REST Client__ extension and install it.
3. ![](images/Imagen1.png)

## Exercise1. Configuration

> In this exercise we are going to create the REST infrastructure using the  __jersey__([https://jersey.java.net/]()) library that is already installed in the project dependencies and in Glassfish/Payara.
> 
> - First, it is necessary to create a configuracion class that stablish the query path to return documents with  GET, POST, PUT y DELETE petitions.
> - The Url according to this configuration will be `http://localhost:8080/laboratorios/rest/`

1. Create a new package structure:

```
    es.uc3m.tiw.lab6
                  ../config
                  ../rest
```

2. Create a new `es.uc3m.tiw.lab6.config.ApplicationConfig` class than inherit from`import javax.ws.rs.core.Application`
3. The code it should contain is as follows

```java
@ApplicationPath("rest")
public class ApplicationConfig extends Application {

    public Set<Class<?>> getClasses() {
        return getRestClasses();
    }
    
    //Auto-generated from RESTful web service wizard
    private Set<Class<?>> getRestClasses() {
        Set<Class<?>> resources = new java.util.HashSet<Class<?>>();
        
        resources.add(es.uc3m.tiw.lab6.rest.EjemploService.class);
        return resources;    
    }
}
```

## Exercise2. Service creation

> In the previous configuration class we passed the  `ServiceExample.class` class, in this exercise we are going to create it.
> 
> this class will define access to the service by setting the URLs
> 
> - the URL will be: `http://localhost:8080/laboratorios/rest/example/test/...`
> 

1. Create a new `es.uc3m.tiw.lab6.rest.ServiceExample` class
2. Incorporate the _path_ notation with the path _example_
    3. `@Path("example")`
4. Create a  `getText()` method that return a `String` that only can be access by `GET`, the return content is a `plain text` and the access path will be `/test`. The code should resemble the following:


```java
@GET
        @Path("test")
        @Produces(MediaType.TEXT_PLAIN)
        public String getText() {
            return "Eveything OK";
        }
```
5. Launch the browser to the URL: [http://localhost:8080/laboratorios/rest/example/test() and the response obtained should be: __Eveything Ok__

## Exercise3. Parameter passing

> en este ejercicio hay que hacer uso de las anotaciones `@PathParam` y `@QueryParam` para permitir el paso de parámetros mediante la URL.

1. Crea un nuevo método que admita dos parámetros por URI y devuelva un mensaje con dichos parámetros en texto plano. La URL de acceso será: [http://localhost:8080/laboratorios/rest/ejemplo/prueba/10/hola]()
2. Crea otro método que admita dos parámetros pero de una forma más clásica mediante `QUERY_STRING` y devuelva un mensaje en texto plano con dichos parámetros. La URL será: [http://localhost:8080/laboratorios/rest/ejemplo/prueba/query?numero=10&palabra=hola]()

## Exercise4. POST y documentos

> En este ejercicio vamos a probar a usar otros métodos de conexión distintos del `GET`, en concreto `POST`. 
> El ejercicio consistirá en escribir un método que admita 2 parámetros mediante POST, lo reciba y cree un objeto `Usuario` con dichos parámetros y deluelva el objeto Usuario como documento `XML`.
> 
> La URL será del tipo: [http://localhost:8080/laboratorios/rest/ejemplo/usuario/10/david/xml]()
> 
> Observa que la URL termina con /xml por lo que los parámetros pueden ir en cualquier parte de la URL.

1. Crea un nuevo método que tenga lo siguiente:
    2. admita POST como método de conexión 
    3. reciba 2 parámetros (__String nombre__ y __int edad__) por URL mediante `@PathParam`  
    4. Cree un nuevo Usuario con esos parámetros
    5. Devuelva el usuario creado.
    6. Acepte `texto plano` como entrada
    7. Devuelva `xml` como salida
6.  Modifica la clase `Usuario` para añadirle la edad.
7.  Anota la clase `Usuario` con la anotación `@XmlRootElement` para que sea convertida explícitamente en xml al devolverla el servicio.
8.  Abre la extensión de Chromium:__Advanced Rest Client__
    9.  Invoca la dirección de acceso estableciendo el método como `POST`
    10.  ![](images/Imagen2.png)
11.  Cuando pulses sobre el botón <kbd>SEND</kbd> obtendrás una respuesta en formato XML
    12.  ![](images/Imagen3.png)

## Exercise5. JSON

> En este ejercicio se propone devolver un documento JSON del `Usuario` con los mismos valores (edad y nombre) pero esta vez pasados por un formulario.
> 

1. Crea un nuevo método que contenga:
    2. `POST` como método de conexión
    3. Consuma `APPLICATION_FORM_URLENCODED`
    4. Devuelva `APPLICATION_JSON`
5. Abre la extensión __Advanced REST Client__
6. Configúrala para que envíe los datos codificados como un formulario
    7. ![](images/Imagen4.png)
8. Obtendrás una respuesta como esta:
    9. ![](images/Imagen5.png)

## Forge

> JBoss Forge dispone de comandos para configurar y generar servicios REST automáticamente y de manera simple.
> 
>  __Propuesta:__
>  - Observa el código creado en el proyecto _registroUsuarios_ y verás código REST
>  - Investiga los comandos necesarios para crear un nuevo servicio REST.



# Lab5. JBoss Forge

> JBoss Forge allows  accelerate the construction of JEE projects and although there are graphics plugins for various environments, this time we will use the console because is faster.
>
> Once acquired the necessary knowledge to work with JEE components we can use tools like [JBoss Forge](https://forge.jboss.org) that accelerate our work.

<!-- MarkdownTOC -->

- [Project creation](#project-creation)
- [Setting the persistence](#setting-the-persistence)
- [Generation of views. Scaffolding](#generation-of-views-scaffolding)
- [Deploy in the server](#deploy-in-the-server)
- [Using Eclipse](#using-eclipse)
- [Observe](#observe)
- [References](#references)

<!-- /MarkdownTOC -->


## Project creation

1. Open a terminal  _( <kbd>CTRL + ALT + T</kbd> if you use the image)_ and create a new directory:
    2. `mkdir forgelab`
    3. `cd forgelab`
3. Type the command `forge` in the terminal window and wait for the JBoss Forge console. .
4. ![](images/Imagen1.png)
5.  Enter the following command (you can use the <kbd>TAB</kbd> key to assist you and commands and parameters will start showing up):

```
 project-new --named userRegistration --final userregistration --version 1.0 --top-level-package es.uc3m.tiw.forge --stack JAVA_EE_7
```

6. Once the project is completed,  a success message will appear and the prompt will be placed in the project:. 
7. ![](images/Imagen2Eng.png)


## Setting the persistence

1. Type the following command (use <kbd>TAB</kbd> key to assist you):

```
jpa-setup --jpa-provider Eclipse\ Link --db-type MYSQL_INNODB --data-source-name jdbc/tiw --persistence-unit-name forgelabPU 
```

2. Then:

```
jpa-new-entity --named User --idStrategy AUTO
```

3. Note that the prompt is now located in the User.java class.
4. Enter the following command to add a property `String name` with get/set methods

```
[User.java]$ jpa-new-field --named name --type String --length 20 --not-nullable 
```

5. Create another property `String lastName`

```
[User.java]$ jpa-new-field --named lastName --type String

```

## Generation of views. Scaffolding

6. Type the command `cd ..` to go up one level to the `model` package and then write the followinf command to generate views:
    7. You can choose between  __Faces or AngularJS__

```
[model]$ scaffold-generate --provider AngularJS --targets es.uc3m.tiw.forge.model.*  
```
8. ![](images/Imagen3.png)
9. When finished, type `build` press <kbd>ENTER</kbd> and wait until you see the following message: `***SUCCESS*** Build Success`
> __Build__ will generate a file _userregistration.war_ in the path _target_ that you can use to deploy from the Glassfish/Payara's console.
> 

## Despliegue en el servidor

1. Abre la consola de administración de Glassfish/Payara Server ([https://localhost:4848](https://localhost:4848))
2. En el menú lateral selecciona __Applications__
3. Pulsa el botón __Deploy__
4. Botón __Choose File__ y selecciona el fichero registrousuarios.war _(./forgelab/registroUsuarios/target/registrousuarios.war)_
    5. __NOTA:__ Posiblemente el servidor de un `warning` debido a que la tabla `SEQUENCE` ya estaba creada por otro proyecto.
5. Navega a la dirección [http://localhost:8080/registroUsuarios](http://localhost:8080/registroUsuarios) y verás la aplicación generada:
6. ![](images/Imagen4.png)
7. ![](images/Imagen5.png)
8. ![](images/Imagen6.png)

> La aplicación está configurada para aplicar validación en función de los campos y contiene un buscador de usuarios. 
> Prueba a crear algunos usuarios y comprobar en MySQL como se ha creado una tabla `USUARIO` que contiene los usuarios creados.

## Usando Eclipse

1. Elimina la aplicación del servidor Glassfish/Payara
    2. __Consola de administración->Applications->Marca "registroUsuarios"->Botón undeploy__
3. En eclipse:
    4. __File->Import->Maven->Existing Maven projects__
    5. .../forgelabs/registrousuarios
    6. Acepta
7. Si tienes activada la consola de maven verás como se descargan todas las dependencias para configurar el proyecto.
8. Al finalizar dispondrás de un proyecto JEE muy similar al que hemos estado construyendo
9. ![](images/Imagen7.png)

## Observa

>
> Puedes comprobar como se ha generado el código y la estructura. Los dominios van en un paquete `model` los ejbs en `service`.
> 
> Mira también el fichero `persistence.xml` no será muy diferente del que hemos creado.
> 
> Puedes probar a crear también un ejb, para ello escribe en el terminal `ejb-setup` y a continuación `ejb-new-bean` si pulsas <kbd>TAB</kbd> te dará opciones y si eliges `--type` y vuelves a pulsar <kbd>TAB</kbd> te dirá los tipos de EJBs que puedes usar (algo que ya debería ser familiar).
> 

         [registroUsuarios]$ ejb-new-bean --type
            MESSAGEDRIVEN  SINGLETON  STATEFUL  STATELESS

Prueb otras opciones, como hacer relaciones entre entidades, usar servicios, crear servlets, usar JSF, etc. Puedes encontrar muchos ejemplos en la documentación oficial[^2]

---
## Referencias

[^1]: 
[^2]: [https://forge.jboss.org/documentation](https://forge.jboss.org/documentation)

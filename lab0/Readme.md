# Lab0. Configuration

Installation and configuration tools for the development of the course can be done in two ways: manually or automatically.

1. __Manually:__ Useful if the student wishes to acquire a deeper knowledge of necessary, or if you need a clean installation tools in their own environment.
2. __Automatically:__ An image is provided with the tools already installed. This option is a "_ready-to-go_" which eliminates inaccuracies when manual installation.

<!-- MarkdownTOC depth=3 -->

- [Automatically](#automatically)
  - [Step 1. Installation tools](#step-1-installation-tools)
  - [Step 2. Vagrant init](#step-2-vagrant-init)
  - [Step 3. Modify Vagrantfile](#step-3-modify-vagrantfile)
  - [Step 4. Start the image](#step-4-start-the-image)
  - [Change of language](#change-of-language)
  - [Step 5. Configuración de eclipse y Glassfish/Payara Server](#paso-5-configuración-de-eclipse-y-glassfishpayara-server)
- [Manual](#manual)

<!-- /MarkdownTOC -->


> Automatic installation shown in the first instance


## Automatically

### Step 1. Installation tools

For this scenario you need to install the following tools:

- VirtualBox ([http://www.virtualbox.org](http://www.virtualbox.org))
- Vagrant ([http://www.vagrantup.com](http://www.vagrantup.com)).
- Git bash: ([http://git-scm.com](http://git-scm.com)) __Only in the case of windows__
- Optional: VmWare, Parallels
- Optional but recommended in case of using VirtualBox
  - After installing vagrant bash open a console and type: `vagrant plugin install vagrant-vbguest`

### Step 2. Vagrant init

- After the installation is finished (Windows will require a reboot)
- Create a directory called _uc3mtiw_
- Open a bash console  (Git bash in windows) and type the following command in the created directory :
```ruby
vagrant init dpalomar/uc3mTiw
```

### Step 3. Modify Vagrantfile 

Open the generated file (__Vagrantfile__) and uncomment the following lines of code:

```ruby

   config.vm.provider "virtualbox" do |vb|
  #   # Display the VirtualBox GUI when booting the machine
     vb.gui = true
  #
  #   # Customize the amount of memory on the VM:
     vb.memory = "2048"
   end
```

__ATENTION:__ Notice how in `vb.memory` has been changed the value of __1024__ to __2048__ This will increase the memory in the RAM on your computer.

> We recommend using 3072 or 4096. Try never exceed half the RAM on your computer.

### Step 4. Start the image

- Save the changes to the file and close the editor.
- Run again with the console by typing `vagrant up` and waits for the image graphically rises.
- Once started, you can enter user __tiw__ _ ( "IT technologies for the Web") _ and in the field _password_ introduces __tiw__.

> If you're out of the picture making a shutdown, you can always started again retyping __Vagrant up__ from the directory where is the file Vagrantfile

### Change of language

The default system language is American English, if you want to change the language to other follow these steps:

1. Right click on the bottom bar of the screen and select _Add/Remove Panel Items_  ![](images/Imagen1.png)
2. Press the button __add__ ![](images/Imagen1-1.png)
2. Select _Keyboard layout handler_! [] (Images / Imagen1-2.png) and accepts
3. Right click the flag icon and _"Keyboard layout handler settings"_ ![](images/Imagen2.png)
3. In the new dialog follows the image: ![](images/Imagen3.png)
4. Look in the box that appears your language and click OK
5. Returning to the previous box moves the code language to the first position! [] (Images / Imagen4.png)
6. You have already translated the system.

### Step 5. Configure eclipse and Glassfish/Payara Server

1. Open Eclipse from  __menú inicio -> programming -> STS__
2. Crea o acepta el directorio de trabajo (se recomienda llamarlo _workspace_ en un directorio con permisos).
3. Pulsa con el botón derecho del ratón dentro de la pestaña _Servers_ y elige __New -> Server__ ![](images/Imagen5.png)
4. Selecciona __Oracle -> Glassfish Tools__ y acepta. Comenzará la descarga tras aceptar una licencia
5. Cuando finalice la descarga aparecerá un diálogo indicando que es necesario reiniciar eclipse, pulsa __YES__.
6. Repite el paso 3 y elige esta vez __Glassfish -> Glassfish4 -> Next__
7. En el siguiente diálogo buscar esta ruta en:
    8. __Glassfish location:__ /opt/glassfish/payara41/glassfish
    9. __Java Location:__ /usr/lib/jvm/java-8-oracle
    10. __Next__
    11. ![](images/Imagen6.png)
10. En la sigiuente pantalla, escribe:
    11. __Admin Name:__ admin
    12. __Admin Password:__ admin
    13. __Next__
14. __Finish__

#### Probando Glassfish

> Vamos a probar que todo funcione:

1. Selecciona el servidor Glassfish y pulsa el botón verde (Start) ![](images/Imagen7.png)
2. Cuando aparezca al lado del servidor _(Started/Synchronized)_ abre un navegador a la dirección __http://localhost:8080__ y verás la página de bienvenida de _Payara Server_
3. Pulsa el botón rojo para detener el servidor
4. Sal de eclipse/STS con __File->Exit__

## Manual

Para la instalación manual será necesario los siguientes pasos:

1. Instalar JDK8[^1]
    2. Crear la variable de entorno *JAVA_HOME* apuntando al directorio _bin_ de la instalación
2. Instalar maven[^2] 
    3. Crear la variable de entorno *M2_HOME* apuntando al directorio _bin_ de maven
3. Instalar Springsource ToolSuite[^3]
4. Instalar MySQL[^4]
    5. Usuario _root_ password _admin_
5. Instalar MySqlWorkbench[^5]
6. Instalar Payara Server[^6]
    7. Usuario _admin_ password _admin_
7. Instalar MySql ConnectorJ[^7]
    8. Descomprimir y poner el fichero _mysql-connector-5.1.x-bin.jar_ en el directorio *$PAYARA_INSTALACION/glassfish/domains/domain1/lib*
9. _Opcional:_ instalar Docker[^8]

> Se recomienda un mínimo de 3Gb RAM libres para poder funcionar correctamente.



[^1]: 
[^2]: [http://maven.apache.org](http://maven.apache.org)
[^3]: [http://spring.io/tools](http://maven.apache.org)
[^4]: [http://www.mysql.com](http://www.mysql.com)
[^5]: [http://www.mysql.com](http://www.mysql.com)
[^6]: [http://www.payara.fish/](http://www.payara.fish/)
[^7]: [http://www.mysql.com](http://www.mysql.com)
[^8]: [http://www.docker.com](http://www.docker.com)

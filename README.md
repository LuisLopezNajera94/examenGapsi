# Descripcción

Este es un proyecto de examen practico realizado por mi Luis Eduardo Lopez Najera para la empresa Gapsi.
El proyecto esta echo en 2 partes una parte front y una parte back.

## Tecnologias
- Springboot 3.0.2.
- Java 17.
- Angular : 16.0.6
- Node: 18.16.0

# Back
Primer debemos clonar el proyecto con el comando `git clone`.

Para utilizar el back utilice el IDE STS disponible aqui : 
`<Spring Tools Suite>` : <https://spring.io/tools>

1. Cuando tengamos abierto nuestro IDE daremos en la opcion
File -> Import -> Maven -> Existing Maven Pojects , buscamos la ruta en donde tengamos nuestro proyecto, seleccionamos e importamos.

2. En cuanto tengamos nuestro proyecto en nuestro ide daremos click derecho a nuestro peroyecto y ejecutaremos el comando  `maven clean` y  `maven install` con esto el proyecto se compilara y descargara las dependencias.

3. Ya el ultimo paso para echar correr nuestro proyecto daremos click derecho y ejecutaremos la opcion Run As - > Spring boot App ya con esto nuestro proyecto estara disponible en el servidor 8080.

## Documentacion

Para poder ver la documentacion de las apis primero tenemos que tener nuestro proyecto back corriendo y posteriormente ingresar a esta liga.

`<Documentacion>` : <http://localhost:8080/swagger-ui/index.html>

# Front
Para programar el front utilizce el IDE VSC disponible aqui: 
`<Visual Studio Code>` : <https://code.visualstudio.com/>

1. Para ejecutar el front solamente vamos a abrir vsc y realizamos lo siguiente
    File -> Open Folder y seleccionamos el folder de nuestro proyecto.

2. Abrimos un terminal y ejecutamos el comando `npm install` para que las dependencias de nuestro proyecto se carguen.

3. Ya que termino de cargarse las dependencias de nuestro proyecto ejecutamos el comando `ng serve` y nuestro proyecto estara ejecutandose en la siguiente ruta.

`<Ruta>` : <http://localhost:4200/bienvenido>

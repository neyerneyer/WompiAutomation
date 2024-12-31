# **PRUEBA TECNICA PARA DESARROLLADOR QA WOMPI**

## Introducción 📖
Automatización desarrollada para cumplir con el reto técnico para ingresar al equipo de QA en WOMPI.
La automatización se realizó para el endpoint [wompi](https://api-sandbox.co.uat.wompi.dev).

En este proyecto podras visualizar 1 carpeta:

```WompiAutomation``` donde está alojada la automatización

## Pre-requisitos 📋
- Java version 21 o superior y JDK (variables de entorno configuradas)
- IntelliJ IDEA 
- Gradle version 8.8 o superior (variables de entorno configuradas)
- Cucumber


## Instalación 🛠️🔩
- Descomprimir el archivo comprimido:
- Importar el proyecto desde IntelliJ IDE bajo la estructura de un proyecto Gradle existente
- Configurar JRE System Library con Java corretto-21

## Compilar El Proyecto y Generar Wrapper 🚧⚒️
- Para compilar el proyecto se debe ejecutar el comando:
  ```gradle clean build -x test```
- Si actualizas la url de la distribución de gradle-wrapper, se recomienda ejecutar luego las pruebas en la terminal local con el comando:
  ```gradlew clean test aggregate -i```

## Detalles Generales De La Implementación  💻
Los escenarios de pruebas se crean en el feature con lenguaje Gherkin, se conectan con un método de las clases StepDefinitions con la ayuda de anotaciones @Given, @When y @Then, los métodos de la definición de los pasos se conectan con clases tipo Task para el Given y el When, donde se realizan las acciones de alto nivel y desde las cuales se pueden invocar clases tipo Interactions en las cuales se realizan acciones de bajo nivel, pero para el Then se comunica con clases tipo Questions para hacer las validaciones.


🚧 **_La estructura completa del proyecto se verá así:_**

   ```bash
   📦NameProject(WompiAutomation)
   ┣ 📂src
   ┃ ┣ 📂main
   ┃ ┃ ┣ 📂java
   ┃ ┃ ┃ ┗ 📦[package](co.com.tyba.reto.advantageonlineshopping)
   ┃ ┃ ┃   ┣ 📂exceptions (Clases que capturan excepciones personalizadas cuando falla la automatización y no encuentra un campo esperado.
   ┃ ┃ ┃   ┣ 📂interactions (Clases que realizan las acciones de bajo nivel, como el envio de peticiones Get, Post, etc.) 
   ┃ ┃ ┃   ┣ 📂models (Clases con las que se construyen los modelos de datos) 
   ┃ ┃ ┃   ┣ 📂questions (Clases en las que se realizan las validaciones de los escenarios)
   ┃ ┃ ┃   ┣ 📂tasks (Clases que realizan las acciones de alto nivel.)
   ┃ ┃ ┃   ┗ 📂utils (Clases que contienen funcionalidades en común.)
   ┃ ┃ ┗ 📂resources
   ┃ ┃ 
   ┃ ┗ 📂test
   ┃ ┃ ┣ 📂java
   ┃ ┃ ┃ ┗ 📦[package](co.com.tyba.reto.advantageonlineshoppin) 
   ┃ ┃ ┃   ┣ 📂stepdefinitions (Clases donde se definen los pasos de los escenarios a ejecutar en la automatización.
   ┃ ┃ ┃   ┃ ┗📜Hooks(Configuraciones iniciales como preparar el escenario y como la definicion de datos) 
   ┃ ┃ ┃   ┗  📂runners(Clases para ejecutar la automatización con los escenarios indicados en el feature.)
   ┃ ┃ ┗ 📂resources
   ┃ ┃   ┗ 📂features (Se almacenar los archivos con extensión.feature, donde se redactan las historias de usuario.)
   ┣ 📂target
   ┣ 📜.gitignore
   ┣ 📜build.gradle
   ┣ 📜gradlew
   ┣ 📜gradle.bat
   ┣ 📜README.md
   ┣ 📜serenity.properties
   ┗ 📜settings.gradle
```

##Construido con 👨🏻‍💻
La automatización fue desarrollada con:
- Java - Lenguaje de programación.
- BDD - Estrategia de desarrollo
- Screenplay - Patron de diseño
- Gradle - Gestor de dependencias
- SerenityRest - Para hacer peticiones a los servicios backend
- Cucumber - Framework para automatizar pruebas BDD
- Serenity BDD - Biblioteca de código abierto para la generación de reportes
- Gherkin - Lenguaje Business Readable DSL (Lenguaje especifico de dominio legible por el negocio)

## Autor ✒️👨🏻‍
**©️ Brandon Neyer Quevedo Funez** - *Creación de proyecto.* - [funezneyer@gmail.com](#bquevedo)
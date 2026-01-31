# POSTFIX-CALCULATOR

Calculadora de expresiones en notación Postfix (polaca inversa) desarrollada en Java.

## Descripción

Este proyecto implementa:
- **ADT Stack** (Pila genérica) usando ArrayList
- **Calculadora Postfix** que evalúa expresiones aritméticas
- **Generador de reportes PDF** con iText7
- Operadores soportados: `+`, `-`, `*`, `/`
- Manejo de errores: división por cero, operandos insuficientes, caracteres inválidos

## Estructura del Proyecto

```
POSTFIX-CALCULATOR/
├── README.md
├── .gitignore
└── demo/                           ← TRABAJAR SIEMPRE DESDE AQUÍ
    ├── pom.xml
    ├── src/
    │   ├── main/
    │   │   ├── java/
    │   │   │   └── org/postfix/
    │   │   │       ├── Calc.java
    │   │   │       ├── Stack.java
    │   │   │       ├── StackVector.java
    │   │   │       ├── PostfixCalculator.java
    │   │   │       ├── PDFGenerator.java
    │   │   │       └── Main.java
    │   │   └── resources/
    │   │       └── datos.txt
    │   └── test/
    │       └── java/
    │           └── org/postfix/
    │               ├── CalculatorTest.java
    │               └── StackOperation.java
    └── target/
        └── classes/
```

## Requisitos

- **Java 17 o superior**
- **Maven 3.6+** (recomendado)

## Instalación

### 1. Clonar el repositorio

```bash
git clone https://github.com/mjimevm/POSTFIX-CALCULATOR
cd POSTFIX-CALCULATOR
```

### 2. Verificar instalación de Java

```bash
java -version
```

Debe mostrar Java 17 o superior.

## 3. Instalación de Maven

```bash
mvn clean install
```

## Compilación y Ejecución

### Opción 1

1. Ve a la carpeta demo
cd demo

2. Compila el proyecto
```
mvn clean install
```

3. Ejecuta desde la raíz del proyecto
cd ..
```
java -cp demo/target/classes org.postfix.Main
```
### Opción 2

1. Ve a la carpeta demo.

2. Compila el código:
```
javac -d out src/main/java/org/postfix/*.java
```

**Nota:** La opción sin Maven **NO generará el PDF** porque requiere las librerías de iText7.

## Archivo de Datos

El programa lee expresiones desde `src/main/resources/datos.txt`

**Formato:**
- Operandos y operadores separados por espacios
- Una expresión por línea
- Operadores: `+` `-` `*` `/`


## Reporte PDF

El programa genera automáticamente un archivo `reporte_postfix.pdf` en la raíz del proyecto con:

- ✅ **Tabla de resultados** con todas las expresiones evaluadas
- ✅ **Errores resaltados** en color rosa
- ✅ **Resumen estadístico** (total, exitosos, errores)
- ✅ **Fecha y hora** de generación
- ✅ **Información del curso** y autores

**Ubicación del PDF generado:**
```
POSTFIX-CALCULATOR/
└── reporte_postfix.pdf  ← Se genera aquí
```


## Pruebas JUnit

Ejecutar todas las pruebas:

```bash
cd demo
mvn test
```

**Pruebas incluidas:**
- `StackOperation.java` - Pruebas del ADT Stack
- `CalculatorTest.java` - Pruebas de la calculadora Postfix

## Dependencias

El proyecto utiliza las siguientes librerías (gestionadas automáticamente por Maven):

- **JUnit 5.10.1** - Framework de pruebas
- **iText7 7.2.5** - Generación de documentos PDF
  - `kernel` - Núcleo de iText
  - `layout` - Diseño y formato
  - `io` - Entrada/salida

## Solución de Problemas

### Error: "cannot find symbol" al compilar

**Solución:** Asegúrate de compilar con Maven para descargar las dependencias de iText:

```bash
cd demo
mvn clean install
```


### El PDF no se genera

1. Verifica que compilaste con Maven: `mvn clean install`
2. Verifica que las dependencias se descargaron: `mvn dependency:tree`
3. Ejecuta desde la raíz del proyecto, no desde `demo/`

## Tecnologías Utilizadas

- **Java 17** - Lenguaje de programación
- **Maven** - Gestión de dependencias y construcción
- **JUnit 5** - Pruebas unitarias
- **iText7** - Generación de reportes PDF
- **Git/GitHub** - Control de versiones

## Autores

- **Jimena Vásquez** - vas25092@uvg.edu.gt
- **Alejandro Sagastume** - sag25257@uvg.edu.gt

## Curso

**CC2003 - Sección 20 - Algoritmos y Estructura de Datos**  
Universidad del Valle de Guatemala  
Hoja de Trabajo No. 2

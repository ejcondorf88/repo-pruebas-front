# 🎭 Serenity BDD con Screenplay Pattern

Proyecto de pruebas automatizadas usando **Serenity BDD**, **Screenplay Pattern** y **Maven**.

## 📋 Índice

- [Arquitectura](#-arquitectura)
- [Screenplay Pattern](#-screenplay-pattern)
- [Estructura del Proyecto](#-estructura-del-proyecto)
- [Instalación](#-instalación)
- [Cómo Ejecutar](#-cómo-ejecutar)
- [Comandos Útiles](#-comandos-útiles)
- [Conceptos Clave](#-conceptos-clave)

---

## 🏗️ Arquitectura

```
┌─────────────────────────────────────────────────────────────┐
│                    FEATURE FILES (.feature)                  │
│         "El usuario estándar puede iniciar sesión"           │
└─────────────────────────┬───────────────────────────────────┘
                          │
┌─────────────────────────▼───────────────────────────────────┐
│              STEP DEFINITIONS (Glue Code)                   │
│    Conecta Gherkin con código Java - ORQUESTA escenarios     │
└─────────────────────────┬───────────────────────────────────┘
                          │
┌─────────────────────────▼───────────────────────────────────┐
│                     SCREENPLAY LAYER                        │
│  ┌──────────┐  ┌──────────┐  ┌──────────┐  ┌──────────┐  │
│  │  Tasks   │  │ Questions│  │  Actor   │  │  Targets │  │
│  │(Negocio) │  │(Verificar│  │ (Usuario)│  │(Locators)│  │
│  └──────────┘  └──────────┘  └──────────┘  └──────────┘  │
└─────────────────────────┬───────────────────────────────────┘
                          │
┌─────────────────────────▼───────────────────────────────────┐
│                     MODELS (Dominio)                          │
│              Usuario, Producto, TestDataFactory              │
└─────────────────────────────────────────────────────────────┘
```

---

## 🎭 Screenplay Pattern

Screenplay Pattern es una **arquitectura de pruebas** que organiza el código en capas siguiendo el principio de **separación de responsabilidades**.

### Conceptos Fundamentales

| Concepto | Descripción | Analogía Teatro |
|----------|-------------|-----------------|
| **Actor** | Representa un usuario que interactúa con el sistema | 🎭 El actor en escena |
| **Task** | Acción de negocio de alto nivel | 📝 El guion que sigue el actor |
| **Action** | Interacción atómica con la UI | 👆 Un gesto o movimiento |
| **Question** | Consulta sobre el estado del sistema | ❓ "¿Qué ves en el escenario?" |
| **Target** | Localizador de elementos UI | 🎯 El objeto con el que interactúa |
| **Ability** | Capacidad del actor (ej: navegar la web) | 💪 Lo que el actor SABE hacer |

### Flujo de Ejecución

```
Feature (Gherkin)
    ↓
Step Definition (orquesta)
    ↓
Actor.attemptsTo(Task)  →  Task usa Actions + Targets
    ↓
Question.answeredBy(Actor)  →  Verificación
    ↓
Assert (Serenity maneja automáticamente)
```

### Ejemplo Visual

```java
// 1. EL ACTOR (Usuario)
Actor carlos = Actor.named("Carlos");

// 2. INTENTA REALIZAR (Task de negocio)
carlos.attemptsTo(
    IniciarSesion.con(usuario)  // ← Task
);

// 3. LA TASK USA Actions + Targets
actor.attemptsTo(
    Enter.theValue(email).into(CAMPO_USUARIO),  // Action + Target
    Click.on(BOTON_LOGIN)                       // Action + Target
);

// 4. VERIFICAMOS CON Questions
carlos.should(
    seeThat(LaPaginaDeInicio.esVisible())  // ← Question
);
```

---

## 📁 Estructura del Proyecto

```
serenity-screenplay/
├── pom.xml                           ← Configuración Maven + dependencias
├── serenity.properties               ← Configuración Serenity
├── README.md                         ← Este archivo
└── src/
    └── test/
        ├── java/
        │   ├── models/               ← 📦 Objetos de dominio
        │   │   ├── Usuario.java      ← Modelo Usuario con Builder
        │   │   ├── Producto.java     ← Modelo Producto con Builder
        │   │   └── TestDataFactory.java  ← Datos de prueba reutilizables
        │   │
        │   ├── targets/              ← 🎯 Localizadores UI
        │   │   ├── LoginTargets.java ← Elementos de página login
        │   │   └── HomeTargets.java  ← Elementos de página home
        │   │
        │   ├── tasks/                ← ✅ Acciones de negocio
        │   │   ├── IniciarSesion.java
        │   │   ├── Navegar.java
        │   │   └── CerrarSesion.java
        │   │
        │   ├── questions/            ← ❓ Verificaciones
        │   │   ├── ElMensajeDeError.java
        │   │   ├── LaPaginaDeInicio.java
        │   │   └── ElTituloDeLaPagina.java
        │   │
        │   ├── stepdefinitions/      ← 🔗 Glue de Cucumber
        │   │   ├── Hooks.java        ← Configuración Actor
        │   │   └── LoginSteps.java   ← Steps de login
        │   │
        │   └── runners/              ← 🏃 Suite de ejecución
        │       └── SerenityRunnerTest.java
        │
        └── resources/
            └── features/               ← 📝 Archivos Gherkin
                └── login.feature       ← Escenarios de prueba
```

---

## 🚀 Instalación

### Requisitos Previos

- **Java 17** o superior
- **Maven 3.8+**
- **Chrome** (navegador)
- Conexión a Internet (para descargar WebDriver automáticamente)

### 1. Clonar o Crear el Proyecto

```bash
# Si tienes el proyecto en git
git clone <url-del-repositorio>
cd serenity-screenplay

# O crea la estructura manualmente siguiendo este README
```

### 2. Verificar Instalación

```bash
# Verificar Java
java -version

# Verificar Maven
mvn -version
```

### 3. Descargar Dependencias

```bash
# Descarga todas las dependencias de Maven
mvn clean install -DskipTests
```

---

## ▶️ Cómo Ejecutar

### Opción 1: Ejecutar Todos los Tests

```bash
mvn clean verify
```

Esto:
1. Compila el código
2. Ejecuta los tests
3. Genera el reporte de Serenity en `target/site/serenity/`

### Opción 2: Ejecutar un Feature Específico

```bash
mvn clean verify -Dcucumber.features=src/test/resources/features/login.feature
```

### Opción 3: Ejecutar por Tag

```bash
# Ejecutar solo tests marcados con @smoke
mvn clean verify -Dcucumber.filter.tags="@smoke"

# Ejecutar tests excluyendo @wip (work in progress)
mvn clean verify -Dcucumber.filter.tags="not @wip"

# Combinar tags
mvn clean verify -Dcucumber.filter.tags="@login and @regression"
```

### Opción 4: Solo Compilar (sin ejecutar)

```bash
mvn clean compile
```

---

## 📊 Ver el Reporte

Después de ejecutar `mvn clean verify`:

```bash
# Generar reporte (si no se generó automáticamente)
mvn serenity:aggregate

# Abrir reporte (Windows)
start target/site/serenity/index.html

# Abrir reporte (Mac/Linux)
open target/site/serenity/index.html
# o
xdg-open target/site/serenity/index.html
```

### Contenido del Reporte

- ✅ **Resumen de ejecución** (pass/fail)
- 📸 **Screenshots** de cada paso
- 📝 **Steps ejecutados** con sus detalles
- ⏱️ **Tiempos de ejecución**
- 📊 **Estadísticas** por feature

---

## 🛠️ Comandos Útiles

| Comando | Descripción |
|---------|-------------|
| `mvn clean` | Borra archivos compilados previos |
| `mvn compile` | Compila el código fuente |
| `mvn test` | Ejecuta tests (fase test de Maven) |
| `mvn verify` | Ejecuta tests + genera reportes |
| `mvn clean verify` | Limpia + compila + test + reporte |
| `mvn serenity:aggregate` | Genera solo el reporte HTML |
| `mvn dependency:tree` | Muestra árbol de dependencias |

### Ejecución en Modo Debug

```bash
# Ver output detallado
mvn clean verify -X

# O con logging de Serenity
mvn clean verify -Dserenity.logging=VERBOSE
```

---

## 🧩 Conceptos Clave

### 1. Models (Builder Pattern)

```java
// Crear usuario con Builder - LIMPIO y LEGIBLE
Usuario usuario = Usuario.conEmail("test@email.com")
    .yPassword("secret123")
    .yNombre("Juan Pérez")
    .build();

// vs. el modo tradicional - CONFUSO
Usuario usuario = new Usuario("test@email.com", "secret123", "Juan Pérez");
// ¿Qué es cada parámetro? 🤔
```

### 2. Tasks vs Actions

```java
// TASK = Acción de NEGOCIO (qué hace el usuario)
public class IniciarSesion implements Task {
    // Representa: "El usuario inicia sesión"
}

// ACTION = Interacción TÉCNICA (cómo lo hace)
Click.on(BOTON_LOGIN)           // ← Action
Enter.theValue("text").into(X)  // ← Action
```

### 3. Questions para Verificaciones

```java
// ❌ MAL: Assertions directos en Steps
assertEquals("Bienvenido", driver.findElement(By.id("msg")).getText());

// ✅ BIEN: Question que expresa la intención
actor.should(
    seeThat(ElMensajeDeBienvenida.mostrado(), equalTo("Bienvenido"))
);
```

### 4. Targets con Descripciones

```java
// Cada Target tiene un nombre descriptivo para los reportes
public static final Target CAMPO_USUARIO = Target.the("campo de email")
    .locatedBy("#username");

// En el reporte verás: "Enter 'test@email.com' into campo de email"
```

---

## 📝 Flujo de Trabajo Recomendado

1. **Escribe el Feature** (Gherkin) → Define el comportamiento esperado
2. **Crea los Models** → Objetos de dominio necesarios
3. **Define los Targets** → Localizadores de elementos UI
4. **Crea las Tasks** → Acciones de negocio
5. **Crea las Questions** → Verificaciones necesarias
6. **Implementa Steps** → Conecta Gherkin con Screenplay
7. **Ejecuta y Refactoriza** → Corre los tests y mejora

---

## 🐛 Troubleshooting

### Error: WebDriver no encontrado

```bash
# Solución: WebDriverManager se encarga automáticamente
# Verifica que tengas internet para la primera ejecución
```

### Error: Elemento no encontrado

```bash
# Verifica los selectores CSS/XPath en los Targets
# Usa el navegador DevTools (F12) para verificar selectores
```

### Error: Timeouts

```bash
# Aumenta el timeout en serenity.properties:
webdriver.wait.for.timeout=15000
```

---

## 📚 Recursos Adicionales

- [Serenity BDD Documentation](https://serenity-bdd.github.io/)
- [Screenplay Pattern Guide](https://serenity-bdd.github.io/docs/screenplay/screenplay-introduction)
- [Cucumber Documentation](https://cucumber.io/docs/cucumber/)

---

## ✅ Checklist para Nuevos Tests

- [ ] Feature escrito en Gherkin (archivo `.feature`)
- [ ] Models creados si son necesarios
- [ ] Targets definidos para elementos UI
- [ ] Tasks implementadas con `Tasks.instrumented()`
- [ ] Questions creadas con factory method estático
- [ ] Step Definitions que orquestan (sin lógica UI)
- [ ] Ejecutar `mvn clean verify` sin errores
- [ ] Reporte generado en `target/site/serenity/`

---

**¡Listo para empezar!** 🚀

Ejecuta `mvn clean verify` para correr los tests y ver el reporte.

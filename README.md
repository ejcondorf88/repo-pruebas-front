# 🎭 Serenity BDD con Screenplay Pattern

Proyecto de pruebas automatizadas usando **Serenity BDD**, **Screenplay Pattern** y **Maven**.

> **⚡ Herramientas Utilizadas:**
> - **OpenCode** - IDE con IA integrado
> - **GentleAI** - Plugin MCP (Model Context Protocol) para agent orchestration
> - **Engram** - Memoria persistente entre sesiones
> - **SDD (Spec-Driven Development)** - Metodología de desarrollo basada en especificaciones

---

## 📋 Índice

- [Arquitectura](#-arquitectura)
- [Screenplay Pattern](#-screenplay-pattern)
- [SDD - Spec-Driven Development](#-sdd---spec-driven-development)
- [OpenCode + GentleAI + Engram](#-opencode--gentleai--engram)
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

---

## 📖 SDD - Spec-Driven Development

SDD es una metodología para gestionar cambios sustanciales en el proyecto mediante especificaciones formales.

### Flujo SDD

```
┌────────────┐    ┌─────────┐    ┌────────┐    ┌─────────┐    ┌─────────┐
│ PROPOSAL   │ →  │ SPECS   │ →  │ DESIGN │ →  │  TASKS  │ →  │ APPLY   │
│ Propuesta  │    │ Specs   │    │ Design │    │ Tasks   │    │ Implement│
└────────────┘    └─────────┘    └────────┘    └─────────┘    └─────────┘
       │                                    │                        │
       │                                    │                        ↓
       │                                    │                   ┌─────────┐
       │                                    └─────────────────→│ VERIFY  │
       │                                         Verificación  │ Validar │
       │                                                        └─────────┘
       │                                                              │
       └──────────────────────────────────────────────────────────────┘
                                            ┌─────────┐
                                            │ ARCHIVE │ → Cerrar cambio
                                            └─────────┘
```

### Comandos SDD

| Comando | Descripción |
|---------|-------------|
| `/sdd-init` | Inicializar contexto SDD |
| `/sdd-explore <tema>` | Investigar idea antes de comprometer |
| `/sdd-new <nombre>` | Crear propuesta de cambio |
| `/sdd-propose` | Escribir propuesta |
| `/sdd-spec` | Escribir especificaciones |
| `/sdd-design` | Crear diseño técnico |
| `/sdd-tasks` | Descomponer en tareas |
| `/sdd-apply` | Implementar tareas |
| `/sdd-verify` | Validar contra specs |
| `/sdd-archive` | Archivar cambio completado |
| `/sdd-continue` | Continuar siguiente fase |
| `/sdd-ff` | Fast-forward: proposal → specs → design → tasks |

### Artefactos SDD

Los artefactos se almacenan en **Engram** (memoria persistente):

| Fase | Topic Key | Descripción |
|------|-----------|-------------|
| Inicial | `sdd-init/{project}` | Contexto del proyecto |
| Explore | `sdd/{change}/explore` | Investigación |
| Proposal | `sdd/{change}/proposal` | Propuesta de cambio |
| Spec | `sdd/{change}/spec` | Especificaciones |
| Design | `sdd/{change}/design` | Diseño técnico |
| Tasks | `sdd/{change}/tasks` | Lista de tareas |
| Apply | `sdd/{change}/apply-progress` | Progreso de implementación |
| Verify | `sdd/{change}/verify-report` | Reporte de verificación |

---

## 🤖 OpenCode + GentleAI + Engram

Este proyecto utiliza **OpenCode** con el plugin de **GentleAI** para orchestration de agentes.

### OpenCode

OpenCode es un IDE moderno con IA integrada que permite:
- 🤖 Agentes de IA para automatización de tareas
- 🔄 Ejecución de código y tests
- 📁 Exploración de proyecto
- 🔧 Herramientas de refactoring

### GentleAI - MCP Skills

GentleAI proporciona **MCP (Model Context Protocol)** skills que se cargan automáticamente según el contexto:

| Skill | Trigger | Descripción |
|-------|---------|-------------|
| `serenity-bdd` | Escribir tests con Screenplay Pattern | Patrones de Serenity BDD |
| `sdd-*` | Comandos SDD | Workflow de Spec-Driven Development |
| `go-testing` | Tests en Go | Testing con Bubbletea TUI |
| `k6` | Tests de carga | Tests de rendimiento con k6 |
| `karate-framework` | Tests API | Framework Karate para API testing |

#### Cómo se resuelven los skills

1. **Detección de contexto**: El orquestador busca en el registro de skills
2. **Inyección automática**: Las reglas compactas se insertan en el prompt del sub-agente
3. **Ejecución**: El agente sigue los patrones definidos

```java
// Ejemplo: Skill de Serenity BDD proporciona:
// - Convenciones de naming
// - Estructura de paquetes recomendada
// - Patrones de Page Object
// - Best practices de Screenplay
```

### Engram - Memoria Persistente

**Engram** es el sistema de memoria persistente que survive entre sesiones y compactaciones.

#### Cuándo Guardar (PROACTIVELY)

Llama `mem_save` después de:
- ✅ Decisiones de arquitectura o diseño
- ✅ Bugs corregidos (incluye causa raíz)
- ✅ Descubrimientos no obvios del codebase
- ✅ Cambios de configuración o setup
- ✅ Patrones establecidos (naming, estructura)
- ✅ Preferencias del usuario aprendidas

#### Formato de Observación

```java
// Título: Verbo + qué — corto, buscable
title: "Fixed N+1 query in UserList"

// Tipo: decision | architecture | bugfix | pattern | config | discovery
type: "bugfix"

content:
  **What**: Corregido el problema de N+1 en UserList
  **Why**: Los tests tardaban 30s por la consulta N+1
  **Where**: src/dao/UserDao.java
  **Learned**: Siempre usar JOIN en queries que retornan listas
```

#### Cuándo Buscar

En cualquier variación de:
- "remember", "recall", "what did we do"
- "cómo resolvimos", "qué hicimos"
- Referencias a trabajo pasado

#### Recuperación Post-Compactación

1. `mem_session_summary` - Guarda contexto de la sesión
2. `mem_context` - Recupera historial reciente
3. Continuar trabajando con contexto recuperado

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
        │   │   ├── LoginSteps.java   ← Steps de login
        │   │   └── CommonSteps.java  ← Steps compartidos
        │   │
        │   ├── runners/              ← 🏃 Suite de ejecución
        │   │   └── CucumberTestSuite.java
        │   │
        │   └── questions/            ← ❓ Questions (verificaciones)
        │
        └── resources/
            └── features/               ← 📝 Archivos Gherkin
                └── login/
                    └── login.feature   ← Escenarios de prueba
```

---

## 🚀 Instalación

### Requisitos Previos

- **Java 17** o superior
- **Maven 3.8+**
- **Chrome** (navegador)
- Conexión a Internet (para descargar WebDriver automáticamente)
- **OpenCode** con plugin GentleAI instalado (opcional)

### 1. Clonar o Crear el Proyecto

```bash
# Si tienes el proyecto en git
git clone <url-del-repositorio>
cd serenity-screenplay
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

# Ejecutar solo tests de error
mvn clean verify -Dcucumber.filter.tags="@error"
```

### Opción 4: Desde OpenCode

```bash
# Ejecutar desde la terminal integrada de OpenCode
mvn test
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
```

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

---

## 🐛 Bug Lifecycle

Este proyecto documenta bugs encontrados durante las pruebas E2E con un formato estructurado.

### Formato de Bug Report

```markdown
## Bug: [Título corto]

### Información General
| Campo | Valor |
|-------|-------|
| **Estado** | Open / In Progress / Resolved / Won't Fix |
| **Severidad** | Critical / High / Medium / Low |
| **Tipo** | Backend / Frontend / Validación / UI |
| **Fecha Reporte** | YYYY-MM-DD |
| **Tags** | @bug, @severidad-tipo |

### Descripción
Descripción clara del problema.

### Pasos para Reproducir
1. Paso 1
2. Paso 2
3. Paso 3

### Resultado Esperado
Qué debería pasar.

### Resultado Actual
Qué está pasando actualmente.

### Evidencia
- Logs de error
- Screenshots
- Mensajes de la consola

### Análisis
- Posible causa raíz
- Dónde ocurre el problema

### Solución Propuesta
Cómo debería arreglarse.

### Notas Adicionales
- Workarounds temporales
- Notas de contexto
```

---

## 🐛 Bugs Registrados

### BUG-001: Falta validación de fecha de nacimiento futura

| Campo | Valor |
|-------|-------|
| **Estado** | Open |
| **Severidad** | Medium |
| **Tipo** | Validación / Backend |
| **Fecha Reporte** | 2026-04-07 |
| **Tags** | @bug, @validacion, @fecha |

#### Descripción
El sistema no valida que la fecha de nacimiento de la mascota no sea futura. Permite registrar mascotas con fecha de nacimiento en el futuro (ej: 2030-01-01).

#### Pasos para Reproducir
1. Iniciar sesión como admin
2. Navegar a `/mascotas/nueva`
3. Completar información básica con fecha de nacimiento futura (ej: 2030-01-01)
4. Hacer click en "Siguiente"
5. Observar que NO aparece mensaje de error

#### Resultado Esperado
El sistema debería mostrar mensaje de error: "La fecha no puede ser futura"

#### Resultado Actual
El sistema permite avanzar al siguiente paso sin validar la fecha.

#### Evidencia
- Test: `registrar_mascota.feature` - Escenario `@negative`
- Step: `intenta ir al siguiente paso`
- Error: `no matching element found by [mensaje de error]`

#### Análisis
- La validación de fecha futura no está implementada ni en frontend ni en backend
- El campo `fecha_nacimiento` acepta cualquier valor incluyendo fechas futuras
- Se requiere agregar validación tanto en el form (React) como en la API (backend)

#### Solución Propuesta
1. **Frontend**: Agregar validación en el componente de registro de mascota
   ```javascript
   // Validar que la fecha no sea futura
   if (new Date(fechaNacimiento) > new Date()) {
     setError('La fecha no puede ser futura');
   }
   ```

2. **Backend**: Agregar validación en el endpoint de creación de mascota
   ```java
   if (fechaNacimiento.isAfter(LocalDate.now())) {
     throw new ValidationException("La fecha no puede ser futura");
   }
   ```

#### Notas Adicionales
- Test skipeado con tag `@skip` hasta que se corrija
- Ubicación del test: `src/test/resources/features/mascota/registrar_mascota.feature:36`

---

## 🧩 Conceptos Clave

### 1. Models (Builder Pattern)

```java
// Crear usuario con Builder - LIMPIO y LEGIBLE
Usuario usuario = Usuario.conEmail("test@email.com")
    .yPassword("secret123")
    .yNombre("Juan Pérez")
    .build();
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

---

## 📝 Flujo de Trabajo Recomendado

### Con SDD (Spec-Driven Development)

1. **Explora** `/sdd-explore <tema>` - Investiga antes de comprometer
2. **Propón** `/sdd-new <nombre>` - Crea propuesta de cambio
3. **Especifica** `/sdd-spec` - Escribe specs detalladas
4. **Diseña** `/sdd-design` - Crea diseño técnico
5. **Descompón** `/sdd-tasks` - Crea checklist de tareas
6. **Implementa** `/sdd-apply` - Implementa las tareas
7. **Valida** `/sdd-verify` - Verifica contra specs
8. **Archiva** `/sdd-archive` - CIerra el cambio

### Tradicional (sin SDD)

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
webdriver.wait.for.timeout=30000
```

---

## 📚 Recursos Adicionales

- [Serenity BDD Documentation](https://serenity-bdd.github.io/)
- [Screenplay Pattern Guide](https://serenity-bdd.github.io/docs/screenplay/screenplay-introduction)
- [Cucumber Documentation](https://cucumber.io/docs/cucumber/)
- [OpenCode Documentation](https://opencode.ai)
- [GentleAI MCP Skills](https://gentle.ai)

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

## 🎯 Integración con OpenCode + GentleAI

### Skills Disponibles

El proyecto tiene configurados los siguientes skills que se cargan automáticamente según el contexto:

```yaml
# Activados para este proyecto:
- serenity-bdd: Para escribir tests de Serenity
- sdd-*: Para gestionar cambios mediante SDD
```

### Ejemplo de Uso con SDD

```bash
# Inicializar contexto SDD
/sdd-init

# Investigar una idea antes de implementar
/sdd-explore "cómo hacer tests de login con token JWT"

# Crear un nuevo cambio
/sdd-new "tests-login-jwt"

# Continuar con la siguiente fase
/sdd-continue
```

### Memoria Engram

Este proyecto usa Engram para guardar:
- Decisiones de arquitectura de tests
- Bugs encontrados y sus soluciones
- Patrones establecidos
- Convenciones del equipo

```java
// Guardar automáticamente después de decisiones importantes
mem_save(
  title: "Elegido Screenplay sobre Page Object",
  type: "architecture",
  content: "**What**: Screenplay Pattern para tests\n**Why**: Mayor mantenibilidad y legibilidad\n**Where**: Arquitectura completa"
)
```

---

**¡Listo para empezar!** 🚀

Ejecuta `mvn clean verify` para correr los tests y ver el reporte.
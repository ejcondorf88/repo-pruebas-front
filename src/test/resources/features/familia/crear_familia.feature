# language: es

@familia @regression
Característica: Crear familia adoptante
  Como usuario autenticado
  Quiero crear mi familia
  Para poder postularme a adopciones

  Background:
    Dado que "Carlos" ha iniciado sesión correctamente

  @smoke @happy-path
  Escenario: Crear familia exitosamente
    Dado que está en el módulo de familias
    Cuando selecciona "Crear nueva familia"
    Y completa el formulario con datos válidos
      | nombre      | Familia Pérez              |
      | direccion   | Calle Principal 123        |
      | telefono    | 555-1234                   |
      | email       | familia.perez@email.com      |
    Y presiona el botón "Guardar familia"
    Entonces debería ver el mensaje de confirmación "Familia creada exitosamente"
    Y la familia debería aparecer en la lista de familias

  @error @regression
  Escenario: Intentar crear familia sin autenticación
    Dado que el token de sesión ha expirado
    Cuando intenta acceder al módulo de familias
    Entonces debería ser redirigido a la página de login

  @error @regression
  Escenario: Crear familia con datos inválidos
    Dado que está en el módulo de familias
    Cuando selecciona "Crear nueva familia"
    Y completa el formulario con datos inválidos
      | nombre      |                              |
      | direccion   |                              |
      | telefono    | abcdef                     |
    Y presiona el botón "Guardar familia"
    Entonces debería ver mensajes de error en los campos inválidos

  @error @regression
  Escenario: Intentar crear familia duplicada
    Dado que ya existe una familia "Familia Pérez"
    Y está en el módulo de familias
    Cuando intenta crear una familia con nombre "Familia Pérez"
    Entonces debería ver el mensaje "Ya existe una familia con ese nombre"

  @outline @regression
  Esquema del escenario: Validaciones de campos obligatorios
    Dado que está en el formulario de crear familia
    Cuando completa el campo nombre con "<nombre>"
    Y completa el campo dirección con "<direccion>"
    Y completa el campo teléfono con "<telefono>"
    Y presiona el botón "Guardar familia"
    Entonces debería ver el mensaje de error "<mensaje>"

    Ejemplos:
      | nombre         | direccion         | telefono | mensaje                           |
      |                | Calle 123         | 555-0000 | El nombre es obligatorio          |
      | Familia Test   |                   | 555-0000 | La dirección es obligatoria       |
      | Familia Test   | Calle 123         |          | El teléfono es obligatorio        |
      |                |                   |          | Todos los campos son obligatorios |

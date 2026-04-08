# language: es

@perfil @regression
Característica: Completar perfil de adoptante
  Como usuario con familia creada
  Quiero completar mi perfil personal
  Para poder postularme a adopciones

  Background:
    Dado que "Carlos" ha iniciado sesión correctamente
    Y tiene una familia creada

  @smoke @happy-path
  Escenario: Completar perfil exitosamente
    Dado que está en la página de perfil
    Cuando completa la información personal
      | nombre_completo | Carlos Pérez                    |
      | fecha_nacimiento| 1990-05-15                      |
      | ocupacion       | Ingeniero de Software           |
      | biografia       | Amante de los animales...       |
    Y completa la información de vivienda
      | tipo_vivienda   | Casa con jardín                 |
      | tiene_patio     | true                            |
      | permite_mascotas| true                            |
    Y completa la información de experiencia
      | tiene_mascotas_previas | true                   |
      | tipo_mascotas_previas  | Perros, gatos            |
    Y presiona en perfil "Guardar perfil"
    Entonces debería ver el mensaje de confirmación "Perfil completado exitosamente"
    Y el perfil debería marcarse como "100% completo"

  @regression
  Escenario: Perfil muestra progreso parcial
    Dado que está en la página de perfil
    Cuando completa solo la información personal
    Y presiona en perfil "Guardar borrador"
    Entonces debería ver el mensaje de confirmación "Progreso guardado"
    Y el perfil debería mostrar "33% completado"

  @error @regression
  Escenario: Validar campos obligatorios del perfil
    Dado que está en la página de perfil
    Cuando intenta guardar sin completar campos obligatorios
    Entonces debería ver mensajes de error indicando los campos faltantes

  @regression
  Escenario: Subir foto de perfil
    Dado que está editando su perfil
    Cuando selecciona "Subir foto"
    Y selecciona un archivo de imagen válido
    Entonces la foto debería previsualizarse
    Y al guardar debería ver el mensaje de confirmación "Foto actualizada"

  @error @regression
  Escenario: Intentar subir archivo inválido como foto
    Dado que está editando su perfil
    Cuando intenta subir un archivo PDF como foto
    Entonces debería ver mensajes de error indicando los campos faltantes

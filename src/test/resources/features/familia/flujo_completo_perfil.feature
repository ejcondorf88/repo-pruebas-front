# language: es

@perfil @flujo-completo @regression
Característica: Flujo completo de completar perfil de adoptante
  Como usuario familia que ya tiene una cuenta registrada
  Quiero completar mi perfil de adoptante desde el dashboard
  Para poder postularme a adoptar una mascota

  @smoke @happy-path
  Escenario: Usuario familia completa el perfil desde el dashboard
    Dado que el usuario familia está logueado en el dashboard
    Cuando completa la información básica con nombre "Familia García", cédula "1234567890", teléfono "3001234567", ciudad "Bogotá"
    Y hace clic en Continuar
    Entonces debería ver la página de Hogar y experiencia
    Cuando completa el formulario de hogar con tipo "Apartamento", propiedad "Alquilada", personas "3"
    Y marca la opción de responsabilidad
    Y hace clic en el botón "Guardar perfil"
    Entonces debería ver el perfil completado

  @negative
  Escenario: Usuario intenta guardar sin marcar acuerdo de responsabilidad
    Dado que el usuario familia está logueado en el dashboard
    Cuando completa la información básica con nombre "Familia Prueba", cédula "9876543210", teléfono "3109876543", ciudad "Medellín"
    Y hace clic en Continuar
    Y completa el formulario de hogar con tipo "Casa", propiedad "Propia", personas "4"
    Y hace clic en el botón "Guardar perfil"
    Entonces debería ver mensaje de error de validación

  @edge
  Escenario: Usuario puede volver del paso 3 al paso 2
    Dado que el usuario familia está logueado en el dashboard
    Cuando completa la información básica con nombre "Familia Rodríguez", cédula "5555555555", teléfono "3205555555", ciudad "Cali"
    Y hace clic en Continuar
    Y hace clic en el botón Atrás
    Entonces debería estar en la página de información básica
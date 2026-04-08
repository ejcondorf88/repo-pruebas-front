# language: es

@perfil @informacion-basica @regression
Característica: Completar Información básica (Step 2) - Perfil adoptante
  Como usuario que ha completado el registro de cuenta
  Quiero completar la información básica de mi perfil
  Para continuar con el proceso de adopción de mascotas

  @smoke @happy-path
  Escenario: Usuario completa toda la información básica correctamente
    Dado que el usuario está en el paso "Información básica" del perfil
    Cuando completa el formulario con nombre "Familia García", cédula "1234567890", fecha "1990-05-15"
    Y teléfono "3001234567", ciudad "Bogotá", departamento "Cundinamarca"
    Y redes sociales "@familiagarcia"
    Y hace clic en el botón "Continuar"
    Entonces debería avanzar al paso "Hogar y experiencia"

  @negative
  Escenario: Usuario intenta continuar sin completar campos obligatorios
    Dado que el usuario está en el paso "Información básica" del perfil
    Cuando completa el formulario con nombre "", cédula "", fecha ""
    Y teléfono "", ciudad "", departamento ""
    Y redes sociales ""
    Y hace clic en el botón "Continuar"
    Entonces debería ver mensaje de error de validación

  @negative
  Escenario: Usuario intenta continuar solo con algunos campos completados
    Dado que el usuario está en el paso "Información básica" del perfil
    Cuando completa el formulario con nombre "Familia Pérez", cédula "9876543210"
    Y teléfono "3109876543", ciudad "Medellín"
    Y deja vacíos departamento y redes sociales
    Y hace clic en el botón "Continuar"
    Entonces debería ver mensaje de error de validación

  @edge
  Escenario: Usuario ingresa número de cédula muy corto
    Dado que el usuario está en el paso "Información básica" del perfil
    Cuando completa el formulario con nombre "Familia López", cédula "123"
    Y fecha "1985-03-20", teléfono "3014567890", ciudad "Cali", departamento "Valle"
    Y hace clic en el botón "Continuar"
    Entonces debería ver mensaje de error de validación

  @edge
  Escenario: Usuario ingresa número de cédula muy largo
    Dado que el usuario está en el paso "Información básica" del perfil
    Cuando completa el formulario con nombre "Familia Martínez", cédula "12345678901234567890"
    Y fecha "1992-08-10", teléfono "3001234567", ciudad "Barranquilla", departamento "Atlántico"
    Y hace clic en el botón "Continuar"
    Entonces debería ver mensaje de error de validación

  @edge
  Escenario: Usuario ingresa fecha de nacimiento futura
    Dado que el usuario está en el paso "Información básica" del perfil
    Cuando completa el formulario con nombre "Familia Díaz", cédula "5555555555"
    Y fecha "2030-01-01", teléfono "3201234567", ciudad "Cartagena", departamento "Bolívar"
    Y hace clic en el botón "Continuar"
    Entonces debería ver mensaje de error de validación

  @edge
  Escenario: Usuario ingresa redes sociales con texto muy largo
    Dado que el usuario está en el paso "Información básica" del perfil
    Cuando completa el formulario con nombre "Familia Rodríguez", cédula "6666666666"
    Y fecha "1988-11-25", teléfono "3105555555", ciudad "Bucaramanga", departamento "Santander"
    Y redes sociales "Esta es una descripción muy larga de redes sociales que excede el límite permitido para el campo"
    Y hace clic en el botón "Continuar"
    Entonces debería ver mensaje de error de validación

  @edge
  Escenario: Usuario intenta subir archivo con tipo no válido
    Dado que el usuario está en el paso "Información básica" del perfil
    Cuando completa los campos válidos y selecciona archivo "documento.pdf"
    Y hace clic en el botón "Continuar"
    Entonces debería ver mensaje de error de validación

  @edge
  Escenario: Usuario intenta subir archivo demasiado grande
    Dado que el usuario está en el paso "Información básica" del perfil
    Cuando completa los campos válidos y selecciona imagen mayor a 5MB
    Y hace clic en el botón "Continuar"
    Entonces debería ver mensaje de error de validación

  @smoke
  Escenario: Usuario puede volver al paso anterior
    Dado que el usuario está en el paso "Información básica" del perfil
    Cuando hace clic en el botón "Atrás"
    Entonces debería volver al paso "Cuenta"
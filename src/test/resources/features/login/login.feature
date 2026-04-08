# language: es

@login @regression
Característica: Login de usuario
  Como usuario de PetTech
  Quiero poder iniciar sesión
  Para acceder a las funcionalidades del sistema

  @smoke @happy-path
  Escenario: Administrador puede iniciar sesión exitosamente
    Dado que "Admin" está en la página de login
    Cuando ingresa su email "admin@pettech.com" y password "Admin1234!"
    Entonces debería ser redirigido a la página principal

  @error @regression
  Escenario: Usuario con credenciales inválidas ve mensaje de error
    Dado que "Juan" está en la página de login
    Cuando intenta iniciar sesión con credenciales inválidas
    Entonces debería ver el mensaje de error "Las credenciales son incorrectas, vuelve a intentarlo."
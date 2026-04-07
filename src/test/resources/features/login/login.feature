# language: es

@login @regression
Característica: Login de usuario
  Como usuario de PetTech
  Quiero poder iniciar sesión
  Para acceder a las funcionalidades del sistema

  @error @regression
  Escenario: Usuario con credenciales inválidas ve mensaje de error
    Dado que "Juan" está en la página de login
    Cuando intenta iniciar sesión con credenciales inválidas
    Entonces debería ver el mensaje de error "Las credenciales son incorrectas, vuelve a intentarlo."

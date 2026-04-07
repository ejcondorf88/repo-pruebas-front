# language: es

@login @regression
Característica: Login de usuario
  Como usuario de la aplicación
  Quiero poder iniciar sesión
  Para acceder a las funcionalidades protegidas

  @smoke @happy-path
  Escenario: Usuario válido puede iniciar sesión
    Dado que "Carlos" está en la página de login
    Cuando intenta iniciar sesión con credenciales válidas
    Entonces debería ver la página de inicio

  @admin
  Escenario: Administrador puede iniciar sesión
    Dado que "Admin" está en la página de login
    Cuando intenta iniciar sesión como administrador
    Entonces debería ver la página de inicio

  @negative @error
  Escenario: Usuario inválido ve mensaje de error
    Dado que "Inválido" está en la página de login
    Cuando intenta iniciar sesión con credenciales inválidas
    Entonces debería ver un mensaje de error

  @negative @wip
  Escenario: Usuario ve mensaje específico de error
    Dado que "Carlos" está en la página de login
    Cuando intenta iniciar sesión con credenciales inválidas
    Entonces debería ver el mensaje "Credenciales incorrectas"

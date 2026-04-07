# language: es

@registro @familia @regression
Característica: Registro de nueva familia (cuenta)
  Como usuario potencial de PetTech
 Quiero registrarme en la plataforma
  Para poder adoptar una mascota

  @smoke @happy-path
  Escenario: Usuario registra una cuenta exitosamente
    Dado que el usuario está en la página de registro
    Cuando registra una cuenta con email "nuevo+test123@test.com" y password "Password123!" y confirmación "Password123!"
    Entonces debería ser redirigido al dashboard

  @negative @skip
  Escenario: Usuario intenta registrar con email existente
    Dado que el usuario está en la página de registro
    Cuando registra una cuenta con email "admin@pettech.com" y password "Password123!" y confirmación "Password123!"
    Entonces debería ver mensaje de error de registro "El correo ya está registrado"

  @negative
  Escenario: Usuario intenta registrar con passwords que no coinciden
    Dado que el usuario está en la página de registro
    Cuando registra una cuenta con email "otro+test456@test.com" y password "Password123!" y confirmación "Password456!"
    Entonces debería ver mensaje de error de registro "Las contraseñas no coinciden"

  @edge
  Escenario: Usuario intenta registrar con password débil
    Dado que el usuario está en la página de registro
    Cuando registra una cuenta con email "test+debil789@test.com" y password "12345678" y confirmación "12345678"
   Entonces debería ver mensaje de error de registro "Mínimo 8 caracteres"
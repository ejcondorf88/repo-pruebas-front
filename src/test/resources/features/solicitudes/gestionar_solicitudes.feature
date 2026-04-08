# language: es

@login @solicitudes @regression
Característica: Gestionar solicitudes de adopción
  Como administrador de PetTech
  Quiero aprobar o rechazar solicitudes de adopción
  Para gestionar el proceso de adopción de mascotas

  @smoke @happy-path
  Escenario: Administrador aprueba una solicitud pendiente
    Dado que "Admin" está en la página de login
    Cuando inicia sesión como admin y navega a solicitudes
    Y hace clic en la primera solicitud pendiente
    Y approve the solicitud con notas "Solicitud aprobada"
    Entonces debería ver mensaje de éxito de solicitud "Solicitud aprobada"

  @happy-path
  Escenario: Administrador rechaza una solicitud
    Dado que "Admin" está en la página de login
    Cuando inicia sesión como admin y navega a solicitudes
    Y hace clic en la primera solicitud pendiente
    Y reject the solicitud con notas "No cumple requisitos"
    Entonces debería ver mensaje de éxito de solicitud "Solicitud rechazada"
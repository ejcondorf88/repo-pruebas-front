# language: es

@login @mascota @regression
Característica: Registrar mascota
  Como administrador de PetTech
  Quiero registrar una nueva mascota en el sistema
  Para que esté disponible para adopción

  @smoke @happy-path
  Escenario: Administrador registra una mascota exitosamente
    Dado que "Admin" está en la página de login
    Cuando inicia sesión como admin y navega a registrar mascota
    Y completa la información básica:
      | nombre       | Luna                      |
      | especie      | PERRO                     |
      | raza         | Labrador Retriever        |
      | estado       | DISPONIBLE                |
      | edad         | 3                         |
      | unidadEdad   | ANIOS                     |
      | fechaNac     | 2022-05-15                |
      | tamano       | MEDIANO                   |
      | peso         | 25.5                      |
      | sexo         | HEMBRA                    |
    Y completa la información de salud:
      | nivelEnergia     | MEDIO                    |
      | nivelIndependencia | MEDIO                 |
      | nivelComplejidad | BAJO                     |
      | nivelSociabilidad | ALTO                    |
      | aptaNinos        | SI                       |
      | costoEstimado    | 1_2SMLV                  |
      | historia         | Luna es una perrita muy juguetona y amigable |
      | infoAdicional    | Desparasitada al día    |
    Entonces debería ver el mensaje de éxito "Mascota registrada exitosamente"

  @negative @regression @skip
  Escenario: Administrador intenta registrar con fecha de nacimiento futura
    Dado que "Admin" está en la página de login
    Cuando inicia sesión como admin y navega a registrar mascota
    Y completa la información básica sin avanzar:
      | nombre       | Rocky                     |
      | especie      | PERRO                     |
      | raza         | Golden Retriever         |
      | estado       | DISPONIBLE                |
      | edad         | 2                         |
      | unidadEdad   | ANIOS                     |
      | fechaNac     | 2030-01-01                |
      | tamano       | GRANDE                    |
      | peso         | 30.0                      |
      | sexo         | MACHO                     |
    Y intenta ir al siguiente paso
    Entonces debería ver mensaje de error "La fecha no puede ser futura"

  @edge @regression
  Escenario: Administrador intenta registrar con peso muy bajo (hamster)
    Dado que "Admin" está en la página de login
    Cuando inicia sesión como admin y navega a registrar mascota
    Y completa la información básica:
      | nombre       | Mini                      |
      | especie      | HAMSTER                  |
      | raza         | Siberiano                 |
      | estado       | DISPONIBLE                |
      | edad         | 1                         |
      | unidadEdad   | MESES                     |
      | fechaNac     | 2025-03-01                |
      | tamano       | PEQUENO                   |
      | peso         | 0.05                      |
      | sexo         | HEMBRA                    |
    Y completa la información de salud:
      | nivelEnergia     | ALTO                     |
      | nivelIndependencia | ALTO                  |
      | nivelComplejidad | BAJO                     |
      | nivelSociabilidad | MEDIO                   |
      | aptaNinos        | NO                       |
      | costoEstimado    | MENOS_1SMLV              |
      | historia         | Hamster muy activa       |
      | infoAdicional    | Requiere ruedas          |
    Entonces debería ver el mensaje de éxito "Mascota registrada exitosamente"
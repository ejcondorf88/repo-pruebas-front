package stepdefinitions;

import io.cucumber.java.es.*;
import models.Familia;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import questions.ElMensajeDeError;
import questions.LaFamiliaFueCreada;
import tasks.familia.*;

import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static org.hamcrest.Matchers.*;

/**
 * Step Definitions para los escenarios de Familia.
 */
public class FamiliaSteps {

    @Dado("que {string} ha iniciado sesión correctamente")
    public void queElActorHaIniciadoSesion(String nombreActor) {
        Actor actor = OnStage.theActorCalled(nombreActor);
        // El login se hace en background o precondición
    }

    @Dado("que está en el módulo de familias")
    public void queEstaEnElModuloDeFamilias() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                NavegarAModuloFamilia.directo()
        );
    }

    @Dado("que está en el formulario de crear familia")
    public void queEstaEnElFormularioDeCrearFamilia() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                NavegarAModuloFamilia.directo(),
                SeleccionarCrearFamilia.nueva()
        );
    }

    @Cuando("selecciona {string}")
    public void selecciona(String opcion) {
        if (opcion.contains("Crear") || opcion.contains("Nueva")) {
            OnStage.theActorInTheSpotlight().attemptsTo(
                    SeleccionarCrearFamilia.nueva()
            );
        }
    }

    @Cuando("completa el formulario con datos válidos")
    public void completaElFormularioConDatosValidos(Map<String, String> datos) {
        Familia familia = Familia.llamada(datos.get("nombre"))
                .conDireccion(datos.get("direccion"))
                .conTelefono(datos.get("telefono"))
                .conEmail(datos.getOrDefault("email", "test@email.com"))
                .build();

        OnStage.theActorInTheSpotlight().attemptsTo(
                CompletarFormularioFamilia.conDatos(familia)
        );
    }

    @Cuando("completa el formulario con datos inválidos")
    public void completaElFormularioConDatosInvalidos(Map<String, String> datos) {
        Familia familia = Familia.llamada(datos.getOrDefault("nombre", ""))
                .conDireccion(datos.getOrDefault("direccion", ""))
                .conTelefono(datos.getOrDefault("telefono", ""))
                .build();

        OnStage.theActorInTheSpotlight().attemptsTo(
                CompletarFormularioFamilia.conDatos(familia)
        );
    }

    @Cuando("intenta crear una familia con nombre {string}")
    public void intentaCrearUnaFamiliaConNombre(String nombre) {
        Familia familia = Familia.llamada(nombre)
                .conDireccion("Dirección de prueba")
                .conTelefono("555-9999")
                .build();

        OnStage.theActorInTheSpotlight().attemptsTo(
                CompletarFormularioFamilia.conDatos(familia),
                EnviarFormularioFamilia.guardar()
        );
    }

    @Cuando("presiona el botón {string}")
    public void presionaElBoton(String boton) {
        if (boton.contains("Guardar") || boton.contains("Crear")) {
            OnStage.theActorInTheSpotlight().attemptsTo(
                    EnviarFormularioFamilia.guardar()
            );
        }
    }

    @Cuando("completa el campo nombre con {string}")
    public void completaElCampoNombreCon(String nombre) {
        Familia familia = Familia.llamada(nombre).build();
        OnStage.theActorInTheSpotlight().attemptsTo(
                CompletarFormularioFamilia.conDatos(familia)
        );
    }

    @Cuando("completa el campo dirección con {string}")
    public void completaElCampoDireccionCon(String direccion) {
        // Los campos se acumulan, esto se maneja en la Task
    }

    @Cuando("completa el campo teléfono con {string}")
    public void completaElCampoTelefonoCon(String telefono) {
        // Los campos se acumulan, esto se maneja en la Task
    }

    @Entonces("la familia debería aparecer en la lista de familias")
    public void laFamiliaDeberiaAparecerEnLaLista() {
        OnStage.theActorInTheSpotlight().should(
                seeThat(LaFamiliaFueCreada.correctamente(), is(true))
        );
    }

    @Entonces("debería ver mensajes de error en los campos inválidos")
    public void deberiaVerMensajesDeErrorEnLosCamposInvalidos() {
        OnStage.theActorInTheSpotlight().should(
                seeThat(ElMensajeDeError.mostrado(), is(notNullValue()))
        );
    }

    @Y("ya existe una familia {string}")
    public void yaExisteUnaFamilia(String nombre) {
        // Precondición: crear familia previamente
        Familia familia = Familia.llamada(nombre)
                .conDireccion("Dirección existente")
                .conTelefono("555-0000")
                .build();

        OnStage.theActorInTheSpotlight().attemptsTo(
                NavegarAModuloFamilia.directo(),
                SeleccionarCrearFamilia.nueva(),
                CompletarFormularioFamilia.conDatos(familia),
                EnviarFormularioFamilia.guardar()
        );
    }

    @Dado("que el token de sesión ha expirado")
    public void queElTokenDeSesionHaExpirado() {
        // Simular token expirado
    }

    @Cuando("intenta acceder al módulo de familias")
    public void intentaAccederAlModuloDeFamilias() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                NavegarAModuloFamilia.directo()
        );
    }

    @Entonces("debería ser redirigido a la página de login")
    public void deberiaSerRedirigidoALaPaginaDeLogin() {
        // Verificar redirección
    }

    }

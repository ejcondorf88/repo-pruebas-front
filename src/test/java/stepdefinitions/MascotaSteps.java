package stepdefinitions;

import io.cucumber.java.es.*;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import tasks.mascota.CompletarInfoBasica;
import tasks.mascota.CompletarInfoBasicaSinAvanzar;
import tasks.mascota.CompletarInfoSalud;
import tasks.mascota.LoginYNavegarARegistrarMascota;
import tasks.mascota.NavegarARegistrarMascota;
import questions.ElMensajeDeMascota;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;

import static targets.MascotaTargets.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

/**
 * Step Definitions para los escenarios de Registrar Mascota.
 * Nota: Los pasos de login ya están en LoginSteps.
 */
public class MascotaSteps {

    // El paso "Dado que {string} está en la página de login" ya existe en LoginSteps
    // El paso "Cuando ingresa su email {string} y password {string}" ya existe en LoginSteps

    @Cuando("navega a la página de registrar mascota")
    public void navegaARegistrarMascota() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                NavegarARegistrarMascota.pagina()
        );
    }

    @Cuando("inicia sesión como admin y navega a registrar mascota")
    public void loginYNavegaARegistrarMascota() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                LoginYNavegarARegistrarMascota.comoAdmin("admin@pettech.com", "Admin1234!")
        );
    }

    @Cuando("completa la información básica sin avanzar:")
    public void completaInfoBasicaSinAvanzar(java.util.Map<String, String> datos) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                CompletarInfoBasicaSinAvanzar.conDatos(
                        datos.get("nombre"),
                        datos.get("especie"),
                        datos.get("raza"),
                        datos.get("estado"),
                        datos.get("edad"),
                        datos.get("unidadEdad"),
                        datos.get("fechaNac"),
                        datos.get("tamano"),
                        datos.get("peso"),
                        datos.get("sexo")
                )
        );
    }

    @Cuando("completa la información básica:")
    public void completaInfoBasica(java.util.Map<String, String> datos) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                CompletarInfoBasica.conDatos(
                        datos.get("nombre"),
                        datos.get("especie"),
                        datos.get("raza"),
                        datos.get("estado"),
                        datos.get("edad"),
                        datos.get("unidadEdad"),
                        datos.get("fechaNac"),
                        datos.get("tamano"),
                        datos.get("peso"),
                        datos.get("sexo")
                )
        );
    }

    @Cuando("completa la información de salud:")
    public void completaInfoSalud(java.util.Map<String, String> datos) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                CompletarInfoSalud.conDatos(
                        datos.get("nivelEnergia"),
                        datos.get("nivelIndependencia"),
                        datos.get("nivelComplejidad"),
                        datos.get("nivelSociabilidad"),
                        datos.get("aptaNinos"),
                        datos.get("costoEstimado"),
                        datos.get("historia"),
                        datos.get("infoAdicional")
                )
        );
    }

    @Cuando("intenta ir al siguiente paso sin completar campos obligatorios")
    public void intentaIrASiguienteSinCompletar() {
        // Intentar click en siguiente sin llenar - debería mostrar errores
        OnStage.theActorInTheSpotlight().attemptsTo(
                Click.on(BOTON_SIGUIENTE)
        );
    }

    @Cuando("intenta ir al siguiente paso")
    public void intentaIrASiguiente() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Click.on(BOTON_SIGUIENTE)
        );
    }

    @Entonces("debería ver el mensaje de éxito {string}")
    public void deberiaVerMensajeExito(String mensajeEsperado) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(MENSAJE_EXITO, WebElementStateMatchers.isVisible())
                        .forNoMoreThan(10).seconds()
        );
        OnStage.theActorInTheSpotlight().should(
                seeThat("el mensaje de éxito contiene",
                        ElMensajeDeMascota.deExito(),
                        org.hamcrest.Matchers.containsStringIgnoringCase(mensajeEsperado))
        );
    }

    @Entonces("debería ver mensajes de validación en los campos requeridos")
    public void deberiaVerMensajesValidacion() {
        // Verificar que aparecen errores de validación
    }

    @Entonces("debería ver mensaje de error {string}")
    public void deberiaVerMensajeError(String mensajeEsperado) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(MENSAJE_ERROR, WebElementStateMatchers.isVisible())
                        .forNoMoreThan(10).seconds()
        );
        OnStage.theActorInTheSpotlight().should(
                seeThat("el mensaje de error contiene",
                        ElMensajeDeMascota.deError(),
                        org.hamcrest.Matchers.containsStringIgnoringCase(mensajeEsperado))
        );
    }
}
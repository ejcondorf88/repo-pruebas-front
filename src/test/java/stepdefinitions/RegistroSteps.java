package stepdefinitions;

import io.cucumber.java.es.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import tasks.registro.RegistrarCuenta;
import questions.ElMensajeDeRegistro;
import static targets.RegistroTargets.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import org.hamcrest.Matchers;

/**
 * Step Definitions para los escenarios de Registro de Cuenta.
 */
public class RegistroSteps {

    @Dado("que el usuario está en la página de registro")
    public void usuarioEnPaginaDeRegistro() {
        Actor actor = OnStage.theActorCalled("Usuario");
        actor.attemptsTo(
                RegistrarCuenta.conDatos("", "", "")
        );
    }

    @Cuando("registra una cuenta con email {string} y password {string} y confirmación {string}")
    public void registraCuentaConDatos(String email, String password, String confirm) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                RegistrarCuenta.conDatos(email, password, confirm)
        );
    }

    @Entonces("debería ser redirigido al dashboard")
    public void deberiaSerRedirigidoAlDashboard() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(DASHBOARD, WebElementStateMatchers.isVisible())
                        .forNoMoreThan(15).seconds()
        );
    }

    @Entonces("debería ver mensaje de error de registro {string}")
    public void deberiaVerMensajeError(String mensajeEsperado) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(MENSAJE_ERROR, WebElementStateMatchers.isVisible())
                        .forNoMoreThan(10).seconds()
        );
        OnStage.theActorInTheSpotlight().should(
                seeThat("el mensaje de error contiene",
                        ElMensajeDeRegistro.deError(),
                        Matchers.containsStringIgnoringCase(mensajeEsperado))
        );
    }
}
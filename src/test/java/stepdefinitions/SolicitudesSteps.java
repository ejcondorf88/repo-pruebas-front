package stepdefinitions;

import io.cucumber.java.es.*;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import tasks.solicitudes.LoginYNavegarASolicitudes;
import tasks.solicitudes.SeleccionarSolicitudPendiente;
import tasks.solicitudes.AprobarSolicitud;
import tasks.solicitudes.RechazarSolicitud;
import questions.ElMensajeDeSolicitud;
import static targets.SolicitudesTargets.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import org.hamcrest.Matchers;

/**
 * Step Definitions para los escenarios de Solicitudes.
 */
public class SolicitudesSteps {

    @Cuando("inicia sesión como admin y navega a solicitudes")
    public void loginYNavegaASolicitudes() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                LoginYNavegarASolicitudes.comoAdmin("admin@pettech.com", "Admin1234!")
        );
    }

    @Cuando("hace clic en la primera solicitud pendiente")
    public void haceClickEnPrimeraSolicitudPendiente() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                SeleccionarSolicitudPendiente.primera()
        );
    }

    @Cuando("aproba la solicitud con notas {string}")
    public void apruebaLaSolicitud(String notas) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                AprobarSolicitud.conNotas(notas)
        );
    }

    @Cuando("approve the solicitud con notas {string}")
    public void approveTheSolicitud(String notas) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                AprobarSolicitud.conNotas(notas)
        );
    }

    @Cuando("reject the solicitud con notas {string}")
    public void rejectTheSolicitud(String notas) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                RechazarSolicitud.conNotas(notas)
        );
    }

    @Cuando("rechaza la solicitud sin ingresar notas")
    public void rechazaSinNotas() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                RechazarSolicitud.sinNotas()
        );
    }

    @Entonces("debería ver mensaje de éxito de solicitud {string}")
    public void deberiaVerMensajeExito(String mensajeEsperado) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(MENSAJE_EXITO, WebElementStateMatchers.isVisible())
                        .forNoMoreThan(10).seconds()
        );
        OnStage.theActorInTheSpotlight().should(
                seeThat("el mensaje de éxito contiene",
                        ElMensajeDeSolicitud.deExito(),
                        Matchers.containsStringIgnoringCase(mensajeEsperado))
        );
    }

    @Entonces("debería ver mensaje de error de solicitud {string}")
    public void deberiaVerMensajeError(String mensajeEsperado) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(MENSAJE_ERROR, WebElementStateMatchers.isVisible())
                        .forNoMoreThan(10).seconds()
        );
        OnStage.theActorInTheSpotlight().should(
                seeThat("el mensaje de error contiene",
                        ElMensajeDeSolicitud.deError(),
                        Matchers.containsStringIgnoringCase(mensajeEsperado))
        );
    }
}
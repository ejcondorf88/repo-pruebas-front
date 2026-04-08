package tasks.solicitudes;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import static targets.SolicitudesTargets.*;

/**
 * Task para hacer clic en la primera solicitud pendiente.
 */
public class SeleccionarSolicitudPendiente implements Task {

    public static SeleccionarSolicitudPendiente primera() {
        return Tasks.instrumented(SeleccionarSolicitudPendiente.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                // Esperar que cargue la lista de solicitudes
                WaitUntil.the(SOLICITUD_PENDIENTE, WebElementStateMatchers.isVisible())
                        .forNoMoreThan(15).seconds(),
                
                // Click en la solicitud pendiente
                Click.on(SOLICITUD_PENDIENTE),
                
                // Esperar que se expanda el detalle
                WaitUntil.the(BOTON_APROBAR, WebElementStateMatchers.isVisible())
                        .forNoMoreThan(10).seconds()
        );
    }
}
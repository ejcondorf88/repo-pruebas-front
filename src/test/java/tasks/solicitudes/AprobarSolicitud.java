package tasks.solicitudes;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import static targets.SolicitudesTargets.*;

/**
 * Task para aprobar una solicitud con notas.
 */
public class AprobarSolicitud implements Task {

    private final String notas;

    public static AprobarSolicitud conNotas(String notas) {
        return Tasks.instrumented(AprobarSolicitud.class, notas);
    }

    public AprobarSolicitud(String notas) {
        this.notas = notas;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                // Ingresar notas (opcional para aprobar)
                WaitUntil.the(CAMPO_NOTAS, WebElementStateMatchers.isVisible())
                        .forNoMoreThan(5).seconds(),
                
                Enter.theValue(notas).into(CAMPO_NOTAS),
                
                // Click en aprobar
                Click.on(BOTON_APROBAR)
        );
        // Nota: No esperamos mensaje de éxito - el test verificará el cambio de estado
    }
}
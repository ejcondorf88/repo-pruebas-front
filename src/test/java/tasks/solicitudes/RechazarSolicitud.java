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
 * Task para rechazar una solicitud.
 */
public class RechazarSolicitud implements Task {

    private final String notas;

    public static RechazarSolicitud sinNotas() {
        return Tasks.instrumented(RechazarSolicitud.class, "");
    }

    public static RechazarSolicitud conNotas(String notas) {
        return Tasks.instrumented(RechazarSolicitud.class, notas);
    }

    public RechazarSolicitud(String notas) {
        this.notas = notas;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                // Esperar campo de notas
                WaitUntil.the(CAMPO_NOTAS, WebElementStateMatchers.isVisible())
                        .forNoMoreThan(5).seconds(),
                
                // Ingresar notas
                Enter.theValue(notas).into(CAMPO_NOTAS),
                
                // Click en rechazar
                Click.on(BOTON_RECHAZAR)
        );
    }
}
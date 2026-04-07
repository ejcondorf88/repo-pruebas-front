package tasks.perfil;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static targets.CommonTargets.OVERLAY_CARGANDO;
import static targets.PerfilTargets.BOTON_GUARDAR_PERFIL;

/**
 * Task para guardar el perfil completado.
 */
public class GuardarPerfil implements Task {

    public static GuardarPerfil completo() {
        return Tasks.instrumented(GuardarPerfil.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BOTON_GUARDAR_PERFIL),

// Esperar a que termine la carga
 WaitUntil.the(OVERLAY_CARGANDO, WebElementStateMatchers.isNotVisible())
 .forNoMoreThan(10).seconds()
        );
    }
}

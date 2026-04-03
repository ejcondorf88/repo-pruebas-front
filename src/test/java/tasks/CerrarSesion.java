package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import static targets.HomeTargets.BOTON_LOGOUT;

/**
 * Task para cerrar sesión del usuario.
 */
public class CerrarSesion implements Task {

    public static CerrarSesion delSistema() {
        return Tasks.instrumented(CerrarSesion.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BOTON_LOGOUT)
        );
    }
}

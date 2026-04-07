package tasks.perfil;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import static targets.PerfilTargets.BOTON_GUARDAR_BORRADOR;

/**
 * Task para guardar el perfil como borrador.
 */
public class GuardarBorrador implements Task {

    public static GuardarBorrador delPerfil() {
        return Tasks.instrumented(GuardarBorrador.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BOTON_GUARDAR_BORRADOR)
        );
    }
}

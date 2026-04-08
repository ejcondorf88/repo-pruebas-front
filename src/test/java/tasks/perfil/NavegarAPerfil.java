package tasks.perfil;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;

import static targets.PerfilTargets.MENU_PERFIL;

/**
 * Task para navegar a la página de perfil.
 */
public class NavegarAPerfil implements Task {

    private final boolean usarMenu;

    public static NavegarAPerfil desdeElMenu() {
        return Tasks.instrumented(NavegarAPerfil.class, true);
    }

    public static NavegarAPerfil directo() {
        return Tasks.instrumented(NavegarAPerfil.class, false);
    }

    public NavegarAPerfil(boolean usarMenu) {
        this.usarMenu = usarMenu;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        if (usarMenu) {
            actor.attemptsTo(
                    Click.on(MENU_PERFIL)
            );
        } else {
            actor.attemptsTo(
                    Open.url("http://localhost/perfil")
            );
        }
    }
}

package tasks.familia;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static targets.FamiliaTargets.*;

/**
 * Task para navegar al módulo de familias.
 */
public class NavegarAModuloFamilia implements Task {

    private final boolean usarMenu;

    public static NavegarAModuloFamilia desdeElMenu() {
        return Tasks.instrumented(NavegarAModuloFamilia.class, true);
    }

    public static NavegarAModuloFamilia directo() {
        return Tasks.instrumented(NavegarAModuloFamilia.class, false);
    }

    public NavegarAModuloFamilia(boolean usarMenu) {
        this.usarMenu = usarMenu;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        if (usarMenu) {
            actor.attemptsTo(
                    Click.on(MENU_FAMILIAS),
                    WaitUntil.the(BOTON_NUEVA_FAMILIA, WebElementStateMatchers.isVisible())
                            .forNoMoreThan(10).seconds()
            );
        } else {
            actor.attemptsTo(
                    Open.url("http://localhost/familias")
            );
        }
    }
}

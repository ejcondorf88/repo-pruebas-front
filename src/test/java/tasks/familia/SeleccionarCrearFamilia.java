package tasks.familia;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static targets.FamiliaTargets.*;

/**
 * Task para seleccionar "Crear nueva familia".
 */
public class SeleccionarCrearFamilia implements Task {

    public static SeleccionarCrearFamilia nueva() {
        return Tasks.instrumented(SeleccionarCrearFamilia.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BOTON_NUEVA_FAMILIA),
                WaitUntil.the(CAMPO_NOMBRE_FAMILIA, WebElementStateMatchers.isVisible())
                        .forNoMoreThan(10).seconds()
        );
    }
}

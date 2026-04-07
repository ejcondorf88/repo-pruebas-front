package tasks.familia;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static targets.CommonTargets.OVERLAY_CARGANDO;
import static targets.FamiliaTargets.BOTON_GUARDAR_FAMILIA;

/**
 * Task para enviar/guardar el formulario de familia.
 */
public class EnviarFormularioFamilia implements Task {

    public static EnviarFormularioFamilia guardar() {
        return Tasks.instrumented(EnviarFormularioFamilia.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BOTON_GUARDAR_FAMILIA),

// Esperar a que termine la carga
 WaitUntil.the(OVERLAY_CARGANDO, WebElementStateMatchers.isNotVisible())
 .forNoMoreThan(10).seconds()
        );
    }
}

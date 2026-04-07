package tasks.perfil;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static targets.PerfilTargets.*;

/**
 * Task para iniciar la edición del perfil.
 */
public class IniciarEdicionPerfil implements Task {

    public static IniciarEdicionPerfil paraEditar() {
        return Tasks.instrumented(IniciarEdicionPerfil.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BOTON_EDITAR_PERFIL),
                WaitUntil.the(CAMPO_NOMBRE_COMPLETO, WebElementStateMatchers.isVisible())
                        .forNoMoreThan(10).seconds()
        );
    }
}

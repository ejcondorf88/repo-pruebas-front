package tasks.perfil;

import models.Perfil;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;

import static targets.PerfilTargets.*;

/**
 * Task para completar la información de vivienda.
 */
public class CompletarInformacionVivienda implements Task {

    private final Perfil perfil;

    public static CompletarInformacionVivienda delPerfil(Perfil perfil) {
        return Tasks.instrumented(CompletarInformacionVivienda.class, perfil);
    }

    public CompletarInformacionVivienda(Perfil perfil) {
        this.perfil = perfil;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        // Seleccionar tipo de vivienda
        if (perfil.getTipoVivienda() != null) {
            actor.attemptsTo(
                    SelectFromOptions.byVisibleText(perfil.getTipoVivienda())
                            .from(SELECT_TIPO_VIVIENDA)
            );
        }

        // Checkbox tiene patio
        if (perfil.isTienePatio()) {
            actor.attemptsTo(
                    Click.on(CHECKBOX_TIENE_PATIO)
            );
        }

        // Checkbox permite mascotas
        if (perfil.isPermiteMascotas()) {
            actor.attemptsTo(
                    Click.on(CHECKBOX_PERMITE_MASCOTAS)
            );
        }
    }
}

package tasks.perfil;

import models.Perfil;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static targets.PerfilTargets.*;

/**
 * Task para completar la información de experiencia con mascotas.
 */
public class CompletarExperienciaMascotas implements Task {

    private final Perfil perfil;

    public static CompletarExperienciaMascotas delPerfil(Perfil perfil) {
        return Tasks.instrumented(CompletarExperienciaMascotas.class, perfil);
    }

    public CompletarExperienciaMascotas(Perfil perfil) {
        this.perfil = perfil;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        // Checkbox mascotas previas
        if (perfil.isTieneMascotasPrevias()) {
            actor.attemptsTo(
                    Click.on(CHECKBOX_MASCOTAS_PREVIAS)
            );

            // Si tiene mascotas previas, especificar tipos
            if (perfil.getTipoMascotasPrevias() != null) {
                actor.attemptsTo(
                        Enter.theValue(perfil.getTipoMascotasPrevias())
                                .into(CAMPO_TIPO_MASCOTAS_PREVIAS)
                );
            }
        }
    }
}

package tasks.perfil;

import models.Perfil;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;

import java.time.format.DateTimeFormatter;

import static targets.PerfilTargets.*;

/**
 * Task para completar la información personal del perfil.
 */
public class CompletarInformacionPersonal implements Task {

    private final Perfil perfil;

    public static CompletarInformacionPersonal delPerfil(Perfil perfil) {
        return Tasks.instrumented(CompletarInformacionPersonal.class, perfil);
    }

    public CompletarInformacionPersonal(Perfil perfil) {
        this.perfil = perfil;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        if (perfil.getNombreCompleto() != null) {
            actor.attemptsTo(
                    Enter.theValue(perfil.getNombreCompleto()).into(CAMPO_NOMBRE_COMPLETO)
            );
        }

        if (perfil.getFechaNacimiento() != null) {
            String fechaFormateada = perfil.getFechaNacimiento()
                    .format(DateTimeFormatter.ISO_LOCAL_DATE);
            actor.attemptsTo(
                    Enter.theValue(fechaFormateada).into(CAMPO_FECHA_NACIMIENTO)
            );
        }

        if (perfil.getOcupacion() != null) {
            actor.attemptsTo(
                    Enter.theValue(perfil.getOcupacion()).into(CAMPO_OCUPACION)
            );
        }

        if (perfil.getBiografia() != null) {
            actor.attemptsTo(
                    Enter.theValue(perfil.getBiografia()).into(CAMPO_BIOGRAFIA)
            );
        }
    }
}

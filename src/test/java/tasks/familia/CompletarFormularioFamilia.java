package tasks.familia;

import models.Familia;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Enter;

import static targets.FamiliaTargets.*;

/**
 * Task para completar el formulario de creación de familia.
 */
public class CompletarFormularioFamilia implements Task {

    private final Familia familia;
    private final boolean limpiarCampos;

    public static CompletarFormularioFamilia conDatos(Familia familia) {
        return Tasks.instrumented(CompletarFormularioFamilia.class, familia, false);
    }

    public static CompletarFormularioFamilia conDatosLimpiando(Familia familia) {
        return Tasks.instrumented(CompletarFormularioFamilia.class, familia, true);
    }

    public CompletarFormularioFamilia(Familia familia, boolean limpiarCampos) {
        this.familia = familia;
        this.limpiarCampos = limpiarCampos;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        if (limpiarCampos) {
            actor.attemptsTo(
                    Clear.field(CAMPO_NOMBRE_FAMILIA),
                    Clear.field(CAMPO_DIRECCION),
                    Clear.field(CAMPO_TELEFONO)
            );
        }

        if (familia.getNombre() != null) {
            actor.attemptsTo(
                    Enter.theValue(familia.getNombre()).into(CAMPO_NOMBRE_FAMILIA)
            );
        }

        if (familia.getDireccion() != null) {
            actor.attemptsTo(
                    Enter.theValue(familia.getDireccion()).into(CAMPO_DIRECCION)
            );
        }

        if (familia.getTelefono() != null) {
            actor.attemptsTo(
                    Enter.theValue(familia.getTelefono()).into(CAMPO_TELEFONO)
            );
        }

        if (familia.getEmail() != null) {
            actor.attemptsTo(
                    Enter.theValue(familia.getEmail()).into(CAMPO_EMAIL_FAMILIA)
            );
        }
    }
}

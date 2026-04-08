package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import static targets.MascotaTargets.MENSAJE_EXITO;
import static targets.MascotaTargets.MENSAJE_ERROR;

/**
 * Question para obtener mensajes de éxito/error en el flujo de registrar mascota.
 */
public class ElMensajeDeMascota implements Question<String> {

    private final boolean esExito;

    public static ElMensajeDeMascota deExito() {
        return new ElMensajeDeMascota(true);
    }

    public static ElMensajeDeMascota deError() {
        return new ElMensajeDeMascota(false);
    }

    public ElMensajeDeMascota(boolean esExito) {
        this.esExito = esExito;
    }

    @Override
    public String answeredBy(Actor actor) {
        if (esExito) {
            return Text.of(MENSAJE_EXITO).answeredBy(actor);
        } else {
            return Text.of(MENSAJE_ERROR).answeredBy(actor);
        }
    }
}
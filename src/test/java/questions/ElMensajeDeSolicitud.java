package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import static targets.SolicitudesTargets.MENSAJE_EXITO;
import static targets.SolicitudesTargets.MENSAJE_ERROR;

/**
 * Question para obtener mensajes de éxito/error en solicitudes.
 */
public class ElMensajeDeSolicitud implements Question<String> {

    private final boolean esExito;

    public static ElMensajeDeSolicitud deExito() {
        return new ElMensajeDeSolicitud(true);
    }

    public static ElMensajeDeSolicitud deError() {
        return new ElMensajeDeSolicitud(false);
    }

    public ElMensajeDeSolicitud(boolean esExito) {
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
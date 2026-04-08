package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import static targets.RegistroTargets.MENSAJE_EXITO;
import static targets.RegistroTargets.MENSAJE_ERROR;

/**
 * Question para obtener mensajes de error/éxito en registro.
 */
public class ElMensajeDeRegistro implements Question<String> {

    private final boolean esExito;

    public static ElMensajeDeRegistro deExito() {
        return new ElMensajeDeRegistro(true);
    }

    public static ElMensajeDeRegistro deError() {
        return new ElMensajeDeRegistro(false);
    }

    public ElMensajeDeRegistro(boolean esExito) {
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
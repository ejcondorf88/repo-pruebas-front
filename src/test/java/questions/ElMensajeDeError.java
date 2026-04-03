package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import static targets.LoginTargets.MENSAJE_ERROR;

/**
 * Question para obtener el mensaje de error mostrado.
 * Las Questions consultan el estado del sistema para verificaciones.
 */
public class ElMensajeDeError implements Question<String> {

    /**
     * Factory method con nombre expresivo.
     */
    public static ElMensajeDeError mostrado() {
        return new ElMensajeDeError();
    }

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(MENSAJE_ERROR).answeredBy(actor);
    }
}

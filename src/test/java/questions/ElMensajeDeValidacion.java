package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import static targets.PerfilAdoptanteTargets.MENSAJE_ERROR;

/**
 * Question para obtener mensajes de validación en el formulario
 * de Información básica del perfil del adoptante.
 */
public class ElMensajeDeValidacion implements Question<String> {

    public static ElMensajeDeValidacion desplegado() {
        return new ElMensajeDeValidacion();
    }

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(MENSAJE_ERROR).answeredBy(actor);
    }
}
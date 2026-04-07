package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import static targets.CommonTargets.TOAST_EXITO;
import static targets.FamiliaTargets.MENSAJE_EXITO_FAMILIA;
import static targets.PerfilTargets.MENSAJE_EXITO_PERFIL;

/**
 * Question para obtener mensajes de confirmación/éxito.
 */
public class ElMensajeDeConfirmacion implements Question<String> {

    private final String contexto;

    public static ElMensajeDeConfirmacion mostrado() {
        return new ElMensajeDeConfirmacion("general");
    }

    public static ElMensajeDeConfirmacion deFamilia() {
        return new ElMensajeDeConfirmacion("familia");
    }

    public static ElMensajeDeConfirmacion dePerfil() {
        return new ElMensajeDeConfirmacion("perfil");
    }

    public ElMensajeDeConfirmacion(String contexto) {
        this.contexto = contexto;
    }

    @Override
    public String answeredBy(Actor actor) {
        switch (contexto) {
            case "familia":
                return Text.of(MENSAJE_EXITO_FAMILIA).answeredBy(actor);
            case "perfil":
                return Text.of(MENSAJE_EXITO_PERFIL).answeredBy(actor);
            default:
                return Text.of(TOAST_EXITO).answeredBy(actor);
        }
    }
}

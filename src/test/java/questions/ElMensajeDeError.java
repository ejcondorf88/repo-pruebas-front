package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;

/**
 * Question para obtener el mensaje de error mostrado.
 */
public class ElMensajeDeError implements Question<String> {

    // Buscar cualquier elemento que contenga el texto del error
    private static final Target TOAST_ERROR = Target.the("toast de error")
            .locatedBy("//*[contains(text(), 'incorrectas')]");

    public static ElMensajeDeError mostrado() {
        return new ElMensajeDeError();
    }

    @Override
    public String answeredBy(Actor actor) {
        try {
            // Intentar obtener el texto del toast de error
            var elemento = TOAST_ERROR.resolveFor(actor);
            if (elemento != null && elemento.isDisplayed()) {
                return elemento.getText();
            }
            return "";
        } catch (Exception e) {
            // Si no encuentra el toast, devolver string vacío
            return "";
        }
    }
}

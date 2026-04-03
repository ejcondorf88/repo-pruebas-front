package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;

import static targets.HomeTargets.TITULO_PAGINA;

/**
 * Question para verificar si la página de inicio es visible.
 * Devuelve true si el indicador de página de inicio está presente.
 */
public class LaPaginaDeInicio implements Question<Boolean> {

    /**
     * Factory method con nombre expresivo.
     */
    public static LaPaginaDeInicio esVisible() {
        return new LaPaginaDeInicio();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return Visibility.of(TITULO_PAGINA).answeredBy(actor);
    }
}

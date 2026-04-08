package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;
import net.serenitybdd.screenplay.targets.Target;

/**
 * Question para verificar si la página de inicio (dashboard) es visible.
 */
public class LaPaginaDeInicio implements Question<Boolean> {

    // Verificar que estamos en el dashboard buscando el h1
    private static final Target TITULO_DASHBOARD = Target.the("título del dashboard")
            .locatedBy("//h1[contains(text(), 'Hola')]");

    public static LaPaginaDeInicio esVisible() {
        return new LaPaginaDeInicio();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return Visibility.of(TITULO_DASHBOARD).answeredBy(actor);
    }
}

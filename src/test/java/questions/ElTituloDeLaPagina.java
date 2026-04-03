package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.page.TheWebPage;

/**
 * Question para obtener el título de la página actual.
 */
public class ElTituloDeLaPagina implements Question<String> {

    public static ElTituloDeLaPagina mostrado() {
        return new ElTituloDeLaPagina();
    }

    @Override
    public String answeredBy(Actor actor) {
        return TheWebPage.title().answeredBy(actor);
    }
}

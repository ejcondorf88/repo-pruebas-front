package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.page.TheWebPage;

/**
 * Question para obtener el título de la página.
 */
public class ElTituloEs implements Question<String> {

    public static ElTituloEs deLaPagina() {
        return new ElTituloEs();
    }

    @Override
    public String answeredBy(Actor actor) {
        return TheWebPage.title().answeredBy(actor);
    }
}

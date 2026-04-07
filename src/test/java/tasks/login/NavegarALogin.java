package tasks.login;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static targets.LoginTargets.CAMPO_EMAIL;

/**
 * Task para navegar a la página de login.
 * Nota: Usa URL absoluta porque el test no tiene sesión
 */
public class NavegarALogin implements Task {

    private static final String URL_LOGIN = "http://localhost/login";

    public static NavegarALogin pagina() {
        return Tasks.instrumented(NavegarALogin.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.url(URL_LOGIN),
                WaitUntil.the(CAMPO_EMAIL, WebElementStateMatchers.isVisible())
                        .forNoMoreThan(30).seconds()
        );
    }
}

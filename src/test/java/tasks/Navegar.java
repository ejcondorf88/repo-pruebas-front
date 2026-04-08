package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;

/**
 * Task para navegar a una URL específica.
 * Envuelve la acción de abrir el navegador en un concepto de negocio.
 */
public class Navegar implements Task {

    private final String url;

    /**
     * Factory method para navegar a una URL.
     */
    public static Navegar a(String url) {
        return Tasks.instrumented(Navegar.class, url);
    }

    /**
     * Factory method conveniente para la página de login.
     */
    public static Navegar aLaPaginaDeLogin() {
        return Tasks.instrumented(Navegar.class, "https://tu-app.com/login");
    }

    public Navegar(String url) {
        this.url = url;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.url(url)
        );
    }
}

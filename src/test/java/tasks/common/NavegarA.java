package tasks.common;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;

/**
 * Task genérica para navegar a cualquier URL.
 * Útil para reusabilidad entre diferentes páginas.
 */
public class NavegarA implements Task {

    private final String url;

    public static NavegarA laUrl(String url) {
        return Tasks.instrumented(NavegarA.class, url);
    }

    public static NavegarA laPaginaDeLogin() {
        return laUrl("http://localhost/login");
    }

    public static NavegarA laPaginaDeRegistro() {
        return laUrl("http://localhost/registro");
    }

    public static NavegarA laPaginaPrincipal() {
        return laUrl("http://localhost/");
    }

    public static NavegarA elModuloDeFamilias() {
        return laUrl("http://localhost/familias");
    }

    public static NavegarA laPaginaDePerfil() {
        return laUrl("http://localhost/perfil");
    }

    public NavegarA(String url) {
        this.url = url;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.url(url)
        );
    }
}

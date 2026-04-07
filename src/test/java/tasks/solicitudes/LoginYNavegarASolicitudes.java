package tasks.solicitudes;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import tasks.login.IniciarSesion;
import static targets.LoginTargets.*;
import static targets.SolicitudesTargets.*;

/**
 * Task compuesto: Login como admin y navega al módulo de solicitudes.
 * Mantiene la sesión del navegador para evitar pérdida de cookies.
 */
public class LoginYNavegarASolicitudes implements Task {

    private final String email;
    private final String password;

    public static LoginYNavegarASolicitudes comoAdmin(String email, String password) {
        return Tasks.instrumented(LoginYNavegarASolicitudes.class, email, password);
    }

    public LoginYNavegarASolicitudes(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        // Login + navegación en UNA sola sesión para mantener cookies
        actor.attemptsTo(
                // 1. Ir a la página de login
                Open.url("http://localhost"),

                // 2. Esperar que cargue el campo de email
                WaitUntil.the(CAMPO_EMAIL, WebElementStateMatchers.isVisible())
                        .forNoMoreThan(20).seconds(),

                // 3. Completar credenciales
                SendKeys.of(email).into(CAMPO_EMAIL),
                SendKeys.of(password).into(CAMPO_PASSWORD),

                // 4. Click en botón login
                Click.on(BOTON_LOGIN),

                // 5. Esperar que redireccione al dashboard
                WaitUntil.the(LINK_SOLICITUDES, WebElementStateMatchers.isVisible())
                        .forNoMoreThan(15).seconds(),

                // 6. Click en链接 "Solicitudes" del menú
                Click.on(LINK_SOLICITUDES),

                // 7. Esperar que cargue la página de solicitudes
                WaitUntil.the(TITULO_PAGINA, WebElementStateMatchers.isVisible())
                        .forNoMoreThan(10).seconds()
        );
    }
}
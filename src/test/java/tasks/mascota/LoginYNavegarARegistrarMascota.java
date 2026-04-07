package tasks.mascota;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static targets.LoginTargets.*;
import static targets.MascotaTargets.CAMPO_NOMBRE;

/**
 * Task compound: Login + Navegar a registrar mascota.
 * Mantiene la sesión del navegador porque hace todo en una sola cadena.
 */
public class LoginYNavegarARegistrarMascota implements Task {

    private final String email;
    private final String password;
    private static final String URL_LOGIN = "http://localhost/login";
    private static final String URL_MASCOTAS_NUEVA = "http://localhost/mascotas/nueva";

    public static LoginYNavegarARegistrarMascota comoAdmin(String email, String password) {
        return Tasks.instrumented(LoginYNavegarARegistrarMascota.class, email, password);
    }

    public LoginYNavegarARegistrarMascota(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        // Todo en una sola cadena - mantiene la misma sesión
        actor.attemptsTo(
                // 1. Ir a login
                Open.url(URL_LOGIN),
                WaitUntil.the(CAMPO_EMAIL, WebElementStateMatchers.isVisible())
                        .forNoMoreThan(30).seconds(),
                
                // 2. Ingresar credenciales
                Enter.theValue(email).into(CAMPO_EMAIL),
                Enter.theValue(password).into(CAMPO_PASSWORD),
                
                // 3. Click en login
                Click.on(BOTON_LOGIN),
                
                // 4. Esperar a que redirija al dashboard y luego navegar
                WaitUntil.the(BOTON_LOGIN, WebElementStateMatchers.isNotVisible())
                        .forNoMoreThan(15).seconds(),
                
                // 5. Navegar a registrar mascota
                Open.url(URL_MASCOTAS_NUEVA),
                WaitUntil.the(CAMPO_NOMBRE, WebElementStateMatchers.isVisible())
                        .forNoMoreThan(45).seconds()
        );
    }
}
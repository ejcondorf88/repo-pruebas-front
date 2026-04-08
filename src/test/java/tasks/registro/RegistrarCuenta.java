package tasks.registro;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import static targets.RegistroTargets.*;

/**
 * Task para registrar una nueva cuenta.
 */
public class RegistrarCuenta implements Task {

    private final String email;
    private final String password;
    private final String confirmPassword;

    public static RegistrarCuenta conDatos(String email, String password, String confirmPassword) {
        return Tasks.instrumented(RegistrarCuenta.class, email, password, confirmPassword);
    }

    public RegistrarCuenta(String email, String password, String confirmPassword) {
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                // Ir a la página de registro
                Open.url("http://localhost/registro"),
                
                // Esperar que cargue el formulario
                WaitUntil.the(CAMPO_EMAIL, WebElementStateMatchers.isVisible())
                        .forNoMoreThan(20).seconds(),
                
                // Completar formulario
                Enter.theValue(email).into(CAMPO_EMAIL),
                Enter.theValue(password).into(CAMPO_PASSWORD),
                Enter.theValue(confirmPassword).into(CAMPO_CONFIRMAR_PASSWORD),
                
                // Click en siguiente
                Click.on(BOTON_SIGUIENTE)
        );
    }
}
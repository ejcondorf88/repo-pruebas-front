package tasks.login;

import models.Usuario;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static targets.LoginTargets.*;

/**
 * Task para iniciar sesión con credenciales de usuario.
 */
public class IniciarSesion implements Task {

    private final Usuario usuario;

    public static IniciarSesion con(Usuario usuario) {
        return Tasks.instrumented(IniciarSesion.class, usuario);
    }

    public static IniciarSesion conCredenciales(String email, String password) {
        Usuario usuario = Usuario.conEmail(email)
                .yPassword(password)
                .yNombre("Usuario Temporal")
                .build();
        return Tasks.instrumented(IniciarSesion.class, usuario);
    }

    public IniciarSesion(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(CAMPO_EMAIL, WebElementStateMatchers.isVisible())
                        .forNoMoreThan(30).seconds(),
                
                Enter.theValue(usuario.getEmail())
                        .into(CAMPO_EMAIL),
                Enter.theValue(usuario.getPassword())
                        .into(CAMPO_PASSWORD),

                Click.on(BOTON_LOGIN)
        );
    }
}

package tasks;

import models.Usuario;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static targets.LoginTargets.*;

/**
 * Task para iniciar sesión con credenciales de usuario.
 * Representa una acción de negocio de alto nivel.
 */
public class IniciarSesion implements Task {

    private final Usuario usuario;

    /**
     * Factory method para crear la task con un objeto Usuario.
     * Siempre usar Tasks.instrumented() para permitir reportes de Serenity.
     */
    public static IniciarSesion con(Usuario usuario) {
        return Tasks.instrumented(IniciarSesion.class, usuario);
    }

    /**
     * Constructor que recibe el modelo de usuario.
     */
    public IniciarSesion(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
Enter.theValue(usuario.getEmail())
 .into(CAMPO_EMAIL),
                Enter.theValue(usuario.getPassword())
                        .into(CAMPO_PASSWORD),
                Click.on(BOTON_LOGIN)
        );
    }
}

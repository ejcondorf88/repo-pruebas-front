package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Presence;
import net.serenitybdd.screenplay.questions.Text;

import static targets.CommonTargets.BOTON_LOGOUT;
import static targets.CommonTargets.NOMBRE_USUARIO_LOGUEADO;

/**
 * Question para verificar si el usuario está autenticado.
 */
public class ElUsuarioEstaLogueado implements Question<Boolean> {

    private final String nombreEsperado;

    public static ElUsuarioEstaLogueado enElSistema() {
        return new ElUsuarioEstaLogueado(null);
    }

    public static ElUsuarioEstaLogueado conNombre(String nombre) {
        return new ElUsuarioEstaLogueado(nombre);
    }

    public ElUsuarioEstaLogueado(String nombreEsperado) {
        this.nombreEsperado = nombreEsperado;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        // Verificar que existe el botón de logout o el nombre de usuario
        boolean logoutVisible = Presence.of(BOTON_LOGOUT).answeredBy(actor);
        boolean usuarioVisible = Presence.of(NOMBRE_USUARIO_LOGUEADO).answeredBy(actor);

        if (nombreEsperado != null && usuarioVisible) {
            String nombreActual = Text.of(NOMBRE_USUARIO_LOGUEADO).answeredBy(actor);
            return nombreActual.contains(nombreEsperado);
        }

        return logoutVisible || usuarioVisible;
    }
}

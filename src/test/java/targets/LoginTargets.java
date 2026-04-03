package targets;

import net.serenitybdd.screenplay.targets.Target;

/**
 * Localizadores de elementos UI para la página de Login.
 * Cada Target tiene un nombre descriptivo para los reportes.
 */
public class LoginTargets {

    public static final Target CAMPO_USUARIO = Target.the("campo de email")
            .locatedBy("#username");

    public static final Target CAMPO_PASSWORD = Target.the("campo de contraseña")
            .locatedBy("#password");

    public static final Target BOTON_LOGIN = Target.the("botón de inicio de sesión")
            .locatedBy("button[type='submit']");

    public static final Target MENSAJE_ERROR = Target.the("mensaje de error")
            .locatedBy(".error-message");

    public static final Target LINK_REGISTRO = Target.the("enlace de registro")
            .locatedBy("a[href*='register']");

    // Constructor privado para evitar instanciación
    private LoginTargets() {
        throw new UnsupportedOperationException("Clase de constantes - no instanciar");
    }
}

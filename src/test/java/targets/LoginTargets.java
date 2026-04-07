package targets;

import net.serenitybdd.screenplay.targets.Target;

/**
 * Localizadores de elementos UI para la página de Login de PetTech.
 */
public class LoginTargets {

    // Campos del formulario - usando XPath
    public static final Target CAMPO_EMAIL = Target.the("campo de email")
            .locatedBy("//input[@type='email']");

    public static final Target CAMPO_PASSWORD = Target.the("campo de contraseña")
            .locatedBy("//input[@type='password']");

    // Botón de envío
    public static final Target BOTON_LOGIN = Target.the("botón de iniciar sesión")
            .locatedBy("//button[@type='submit']");

    // Mensaje de error 
    public static final Target MENSAJE_ERROR = Target.the("mensaje de error")
            .locatedBy("//*[contains(@class, 'text-red-500')]");

    // Enlace a registro
    public static final Target LINK_REGISTRO = Target.the("enlace a registro")
            .locatedBy("//a[@href='/registro']");

    // Indicadores de estado
    public static final Target SPINNER_CARGANDO = Target.the("spinner de carga")
            .locatedBy("//*[contains(@class, 'animate-spin')]");

    private LoginTargets() {
        throw new UnsupportedOperationException();
    }
}

package targets;

import net.serenitybdd.screenplay.targets.Target;

/**
 * Localizadores de elementos UI para la página principal (Home).
 */
public class HomeTargets {

    public static final Target TITULO_PAGINA = Target.the("título de la página")
            .locatedBy(".dashboard h1, .home h1, #welcome-message");

    public static final Target MENU_USUARIO = Target.the("menú de usuario")
            .locatedBy(".user-menu");

    public static final Target BOTON_LOGOUT = Target.the("botón de cerrar sesión")
            .locatedBy(".logout-button, a[href*='logout']");

    public static final Target LISTA_PRODUCTOS = Target.the("lista de productos")
            .locatedBy(".product-list");

    // Constructor privado
    private HomeTargets() {
        throw new UnsupportedOperationException("Clase de constantes - no instanciar");
    }
}

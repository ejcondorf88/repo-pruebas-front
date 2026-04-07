package targets;

import net.serenitybdd.screenplay.targets.Target;

/**
 * Localizadores comunes reutilizables en toda la aplicación.
 */
public class CommonTargets {

    // Navegación general
    public static final Target MENU_PRINCIPAL = Target.the("menú principal de navegación")
            .locatedBy("nav, .navbar, [role='navigation'], [data-testid='main-nav']");

    public static final Target BOTON_LOGOUT = Target.the("botón de cerrar sesión")
            .locatedBy("button.logout, a[href='/logout'], [data-testid='logout'], .btn-logout");

    public static final Target NOMBRE_USUARIO_LOGUEADO = Target.the("nombre del usuario logueado")
            .locatedBy(".user-name, .username, [data-testid='user-name']");

    // Mensajes globales
    public static final Target TOAST_EXITO = Target.the("toast de éxito")
            .locatedBy(".toast-success, .notification-success, [data-testid='toast-success']");

    public static final Target TOAST_ERROR = Target.the("toast de error")
            .locatedBy(".toast-error, .notification-error, [data-testid='toast-error']");

    // Estados de carga
    public static final Target OVERLAY_CARGANDO = Target.the("overlay de carga")
            .locatedBy(".loading-overlay, .overlay-loading, [data-testid='loading-overlay']");

    // Modales
    public static final Target MODAL_CONFIRMAR = Target.the("modal de confirmación")
            .locatedBy(".modal, .dialog, [role='dialog'], [data-testid='modal']");

    public static final Target BOTON_CONFIRMAR_MODAL = Target.the("botón confirmar en modal")
            .locatedBy(".modal .btn-confirm, .modal .confirm-button, [data-testid='confirmar']");

    public static final Target BOTON_CANCELAR_MODAL = Target.the("botón cancelar en modal")
            .locatedBy(".modal .btn-cancel, .modal .cancel-button, [data-testid='cancelar-modal']");

    // Headers y títulos
    public static final Target TITULO_PAGINA = Target.the("título de la página")
            .locatedBy("h1, .page-title, [data-testid='page-title']");

    // Constructor privado
    private CommonTargets() {
        throw new UnsupportedOperationException("Clase de constantes - no instanciar");
    }
}

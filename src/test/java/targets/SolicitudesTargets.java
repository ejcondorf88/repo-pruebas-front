package targets;

import net.serenitybdd.screenplay.targets.Target;

/**
 * Localizadores de elementos UI para la página de Solicitudes.
 */
public class SolicitudesTargets {

    // ==========================================
    // Navegación
    // ==========================================
    
    // Link de navegación a solicitudes en el menú
    public static final Target LINK_SOLICITUDES = Target.the("link de navegación a solicitudes")
            .locatedBy("//a[@href='/solicitudes']");
    
    // ==========================================
    // Filtros
    // ==========================================
    
    // Selector de filtro por estado
    public static final Target SELECT_ESTADO = Target.the("selector de estado")
            .locatedBy("//select[@class='input-field' and contains(@class, 'w-auto')]");
    
    // ==========================================
    // Lista de solicitudes
    // ==========================================
    
    // Tarjeta de solicitud (primera en la lista)
    public static final Target PRIMERA_SOLICITUD = Target.the("primera solicitud en la lista")
            .locatedBy("(//div[contains(@class, 'card') and contains(@class, 'overflow-hidden')])[1]");
    
    // Tarjeta de solicitud pendiente
    public static final Target SOLICITUD_PENDIENTE = Target.the("solicitud con estado pendiente")
            .locatedBy("//span[contains(@class, 'bg-yellow-100') and contains(text(), 'Pendiente')]/ancestor::div[contains(@class, 'card')]");
    
    // ==========================================
    // Detalle de solicitud (expandido)
    // ==========================================
    
    // Botón Aprobar
    public static final Target BOTON_APROBAR = Target.the("botón aprobar solicitud")
            .locatedBy("//button[contains(text(), 'Aprobar')]");
    
    // Botón Rechazar
    public static final Target BOTON_RECHAZAR = Target.the("botón rechazar solicitud")
            .locatedBy("//button[contains(text(), 'Rechazar')]");
    
    // Campo de notas
    public static final Target CAMPO_NOTAS = Target.the("campo de notas")
            .locatedBy("//textarea[@placeholder='Justificación de la decisión...']");
    
    // ==========================================
    // Mensajes
    // ==========================================
    
    // Mensaje de éxito
    public static final Target MENSAJE_EXITO = Target.the("mensaje de éxito")
            .locatedBy("//div[contains(@class, 'toast')] | //div[contains(@role, 'alert')] | //*[contains(text(), 'aprobada') or contains(text(), 'Adoptado') or contains(text(), 'rechazada')]");
    
    // Mensaje de error
    public static final Target MENSAJE_ERROR = Target.the("mensaje de error")
            .locatedBy("//div[contains(@class, 'text-red-500')] | //*[contains(@class, 'error')] | //*[contains(@role, 'alert') and contains(@class, 'red')]");
    
    // Título de la página
    public static final Target TITULO_PAGINA = Target.the("título de la página de solicitudes")
            .locatedBy("//h1[contains(text(), 'Solicitudes')]");
    
    private SolicitudesTargets() {
        throw new UnsupportedOperationException("Clase de constantes - no instanciar");
    }
}
package targets;

import net.serenitybdd.screenplay.targets.Target;

/**
 * Localizadores de elementos UI para la página de Registro (Cuenta).
 */
public class RegistroTargets {

    // ==========================================
    // Campos del formulario
    // ==========================================
    
    // Campo email
    public static final Target CAMPO_EMAIL = Target.the("campo de email")
            .locatedBy("//input[@name='email']");
    
    // Campo password
    public static final Target CAMPO_PASSWORD = Target.the("campo de password")
            .locatedBy("//input[@name='password']");
    
    // Campo confirmar password
    public static final Target CAMPO_CONFIRMAR_PASSWORD = Target.the("campo de confirmar password")
            .locatedBy("//input[@name='password_confirm']");
    
    // Botón siguiente
    public static final Target BOTON_SIGUIENTE = Target.the("botón siguiente")
            .locatedBy("//button[@type='submit']");
    
    // ==========================================
    // Título y navegación
    // ==========================================
    
    // Título de la página
    public static final Target TITULO_REGISTRO = Target.the("título de registro")
            .locatedBy("//h2[contains(text(), 'Crea tu cuenta')] | //h1[contains(text(), 'Crea tu cuenta')]");
    
    // Link a login
    public static final Target LINK_LOGIN = Target.the("link a login")
            .locatedBy("//a[contains(@href, '/login')]");
    
    // ==========================================
    // Mensajes
    // ==========================================
    
    // Mensaje de error
    public static final Target MENSAJE_ERROR = Target.the("mensaje de error")
            .locatedBy("//div[contains(@class, 'text-red-500')] | //p[contains(@class, 'text-red-500')] | //span[contains(@class, 'text-red-500')]");
    
    // Mensaje de éxito
    public static final Target MENSAJE_EXITO = Target.the("mensaje de éxito")
            .locatedBy("//div[contains(@class, 'toast')] | //div[contains(@role, 'alert')]");
    
    // Dashboard - indica que el registro fue exitoso
    public static final Target DASHBOARD = Target.the("dashboard")
            .locatedBy("//main[@class] | //div[contains(@class, 'max-w-')] | //a[contains(@href, '/perfil') or contains(@href, '/familia')] | //button[contains(text(), 'Siguiente')]");

    private RegistroTargets() {
        throw new UnsupportedOperationException("Clase de constantes - no instanciar");
    }
}
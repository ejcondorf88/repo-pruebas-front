package targets;

import net.serenitybdd.screenplay.targets.Target;

/**
 * Localizadores de elementos UI para el módulo de Familias.
 */
public class FamiliaTargets {

    // Navegación
    public static final Target MENU_FAMILIAS = Target.the("menú de familias")
            .locatedBy("a[href*='familia'], [data-testid='menu-familias']");

    public static final Target BOTON_NUEVA_FAMILIA = Target.the("botón crear nueva familia")
            .locatedBy("button[data-testid='btn-nueva-familia'], .btn-new-family");

    // Formulario de familia
    public static final Target CAMPO_NOMBRE_FAMILIA = Target.the("campo nombre de familia")
            .locatedBy("input[name='nombre'], input#nombre, [data-testid='nombre-familia']");

    public static final Target CAMPO_DIRECCION = Target.the("campo dirección")
            .locatedBy("input[name='direccion'], textarea[name='direccion'], #direccion, [data-testid='direccion']");

    public static final Target CAMPO_TELEFONO = Target.the("campo teléfono")
            .locatedBy("input[name='telefono'], input[type='tel'], #telefono, [data-testid='telefono']");

    public static final Target CAMPO_EMAIL_FAMILIA = Target.the("campo email de familia")
            .locatedBy("input[name='email'], input[type='email'], #email-familia, [data-testid='email-familia']");

    // Botones del formulario
    public static final Target BOTON_GUARDAR_FAMILIA = Target.the("botón guardar familia")
            .locatedBy("button[type='submit'], #btn-guardar-familia, [data-testid='guardar-familia']");

    public static final Target BOTON_CANCELAR = Target.the("botón cancelar")
            .locatedBy("button[data-testid='cancelar'], .btn-cancel");

    // Mensajes
    public static final Target MENSAJE_EXITO_FAMILIA = Target.the("mensaje de éxito al crear familia")
            .locatedBy(".success-message, .alert-success, [role='alert'], [data-testid='mensaje-exito']");

    public static final Target MENSAJE_ERROR_FAMILIA = Target.the("mensaje de error en familia")
            .locatedBy(".error-message, .alert-error, .text-danger, [data-testid='mensaje-error']");

    // Lista de familias
    public static final Target LISTA_FAMILIAS = Target.the("lista de familias")
            .locatedBy(".familia-list, .list-group, [data-testid='lista-familias']");

    public static final Target ITEM_FAMILIA = Target.the("item de familia en lista")
            .locatedBy(".familia-item, .list-group-item");

    // Constructor privado
    private FamiliaTargets() {
        throw new UnsupportedOperationException("Clase de constantes - no instanciar");
    }
}

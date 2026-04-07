package targets;

import net.serenitybdd.screenplay.targets.Target;

/**
 * Localizadores de elementos UI para el módulo de Perfil.
 */
public class PerfilTargets {

    // Navegación
    public static final Target MENU_PERFIL = Target.the("menú de perfil")
            .locatedBy("a[href*='perfil'], [data-testid='menu-perfil']");

    public static final Target BOTON_EDITAR_PERFIL = Target.the("botón editar perfil")
            .locatedBy("button[data-testid='editar-perfil'], a[data-testid='editar-perfil']");

    // Información Personal
    public static final Target CAMPO_NOMBRE_COMPLETO = Target.the("campo nombre completo")
            .locatedBy("input[name='nombreCompleto'], input#nombreCompleto, [data-testid='nombre-completo']");

    public static final Target CAMPO_FECHA_NACIMIENTO = Target.the("campo fecha de nacimiento")
            .locatedBy("input[name='fechaNacimiento'], input[type='date'], #fechaNacimiento, [data-testid='fecha-nacimiento']");

    public static final Target CAMPO_OCUPACION = Target.the("campo ocupación")
            .locatedBy("input[name='ocupacion'], #ocupacion, [data-testid='ocupacion']");

    public static final Target CAMPO_BIOGRAFIA = Target.the("campo biografía")
            .locatedBy("textarea[name='biografia'], #biografia, [data-testid='biografia']");

    // Información de Vivienda
    public static final Target SELECT_TIPO_VIVIENDA = Target.the("selector tipo de vivienda")
            .locatedBy("select[name='tipoVivienda'], #tipoVivienda, [data-testid='tipo-vivienda']");

    public static final Target CHECKBOX_TIENE_PATIO = Target.the("checkbox tiene patio")
            .locatedBy("input[name='tienePatio'], input#tienePatio, [data-testid='tiene-patio']");

    public static final Target CHECKBOX_PERMITE_MASCOTAS = Target.the("checkbox permite mascotas")
            .locatedBy("input[name='permiteMascotas'], input#permiteMascotas, [data-testid='permite-mascotas']");

    // Experiencia con mascotas
    public static final Target CHECKBOX_MASCOTAS_PREVIAS = Target.the("checkbox mascotas previas")
            .locatedBy("input[name='tieneMascotasPrevias'], input#tieneMascotasPrevias, [data-testid='mascotas-previas']");

    public static final Target CAMPO_TIPO_MASCOTAS_PREVIAS = Target.the("campo tipo de mascotas previas")
            .locatedBy("input[name='tipoMascotasPrevias'], #tipoMascotasPrevias, [data-testid='tipo-mascotas']");

    // Foto de perfil
    public static final Target BOTON_SUBIR_FOTO = Target.the("botón subir foto")
            .locatedBy("button[data-testid='subir-foto'], input[type='file']");

    public static final Target PREVIEW_FOTO = Target.the("previsualización de foto")
            .locatedBy(".foto-preview, img.profile-pic, [data-testid='foto-preview']");

    // Botones
    public static final Target BOTON_GUARDAR_PERFIL = Target.the("botón guardar perfil")
            .locatedBy("button[type='submit'], #btn-guardar-perfil, [data-testid='guardar-perfil']");

    public static final Target BOTON_GUARDAR_BORRADOR = Target.the("botón guardar borrador")
            .locatedBy("button[data-testid='guardar-borrador'], .btn-save-draft");

    // Indicadores de progreso
    public static final Target BARRA_PROGRESO = Target.the("barra de progreso del perfil")
            .locatedBy(".progress-bar, .progress, [data-testid='progreso-perfil']");

    public static final Target TEXTO_PORCENTAJE = Target.the("texto de porcentaje completado")
            .locatedBy(".porcentaje-completado, .progress-text, [data-testid='porcentaje']");

    public static final Target INDICADOR_PERFIL_COMPLETO = Target.the("indicador de perfil completo")
            .locatedBy(".perfil-completo, [data-testid='perfil-completo']");

    // Mensajes
    public static final Target MENSAJE_EXITO_PERFIL = Target.the("mensaje de éxito del perfil")
            .locatedBy(".success-message, .alert-success, [data-testid='exito-perfil']");

    public static final Target MENSAJE_ERROR_VALIDACION = Target.the("mensaje de error de validación")
            .locatedBy(".error-message, .validation-error, .text-danger, [data-testid='error-validacion']");

    // Constructor privado
    private PerfilTargets() {
        throw new UnsupportedOperationException("Clase de constantes - no instanciar");
    }
}

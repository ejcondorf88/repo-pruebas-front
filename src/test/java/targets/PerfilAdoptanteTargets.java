package targets;

import net.serenitybdd.screenplay.targets.Target;

/**
 * Localizadores de elementos UI para la página de Información básica
 * del perfil del adoptante (Step 2 - PerfilAdoptante).
 */
public class PerfilAdoptanteTargets {

    // ==========================================
    // Campos del formulario - Información básica
    // ==========================================
    
    // Campo nombre completo de la familia
    public static final Target CAMPO_NOMBRE_FAMILIA = Target.the("campo nombre completo de familia")
            .locatedBy("//input[@name='nombre_familia']");
    
    // Campo número de cédula
    public static final Target CAMPO_CEDULA = Target.the("campo número de cédula")
            .locatedBy("//input[@name='cedula']");
    
    // Campo fecha de nacimiento
    public static final Target CAMPO_FECHA_NACIMIENTO = Target.the("campo fecha de nacimiento")
            .locatedBy("//input[@name='fecha_nacimiento']");
    
    // Campo teléfono
    public static final Target CAMPO_TELEFONO = Target.the("campo teléfono")
            .locatedBy("//input[@name='telefono']");
    
    // Campo ciudad
    public static final Target CAMPO_CIUDAD = Target.the("campo ciudad")
            .locatedBy("//input[@name='ciudad']");
    
    // Campo departamento
    public static final Target CAMPO_DEPARTAMENTO = Target.the("campo departamento")
            .locatedBy("//input[@name='departamento']");
    
    // Campo redes sociales
    public static final Target CAMPO_REDES_SOCIALES = Target.the("campo redes sociales")
            .locatedBy("//input[@name='redes_sociales']");
    
    // Campo foto de perfil
    public static final Target CAMPO_FOTO_PERFIL = Target.the("campo foto de perfil")
            .locatedBy("//input[@type='file'][@name='foto']");
    
    // ==========================================
    // Botones
    // ==========================================
    
    // Botón Continuar
    public static final Target BOTON_CONTINUAR = Target.the("botón continuar")
            .locatedBy("//button[@type='button'][contains(text(), 'Continuar')]");
    
    // Botón Atrás
    public static final Target BOTON_ATRAS = Target.the("botón atrás")
            .locatedBy("//button[contains(text(), 'Atrás')] | //a[contains(text(), 'Atrás')]");
    
    // ==========================================
    // Indicadores de paso (Step indicator)
    // ==========================================
    
    // Step 1 - Cuenta (completado)
    public static final Target STEP_CUENTA = Target.the("step 1 - Cuenta")
            .locatedBy("//div[contains(@class, 'step') or contains(@class, ' Steps')]//*[contains(text(), 'Cuenta')]");
    
    // Step 2 - Información básica (actual)
    public static final Target STEP_INFORMACION_BASICA = Target.the("step 2 - Información básica")
            .locatedBy("//div[contains(@class, 'step') or contains(@class, ' Steps')]//*[contains(text(), 'Información básica')]");
    
    // Step 3 - Hogar y experiencia (pendiente)
    public static final Target STEP_HOGAR_EXPERIENCIA = Target.the("step 3 - Hogar y experiencia")
            .locatedBy("//div[contains(@class, 'step') or contains(@class, ' Steps')]//*[contains(text(), 'Hogar y experiencia')]");
    
    // ==========================================
    // Mensajes de validación
    // ==========================================
    
    // Mensaje de error general
    public static final Target MENSAJE_ERROR = Target.the("mensaje de error")
            .locatedBy("//div[contains(@class, 'text-red-500')] | //p[contains(@class, 'text-red-500')] | //span[contains(@class, 'text-red-500')] | //div[contains(@class, 'error')]");
    
    // Mensaje de error por campo específico
    public static final Target ERROR_CAMPO_NOMBRE = Target.the("error campo nombre")
            .locatedBy("//input[@name='nombre_familia']/following-sibling::div[contains(@class, 'error')] | //input[@name='nombre_familia']/../span[contains(@class, 'error')]");
    
    public static final Target ERROR_CAMPO_CEDULA = Target.the("error campo cédula")
            .locatedBy("//input[@name='cedula']/following-sibling::div[contains(@class, 'error')] | //input[@name='cedula']/../span[contains(@class, 'error')]");
    
    public static final Target ERROR_CAMPO_FECHA = Target.the("error campo fecha")
            .locatedBy("//input[@name='fecha_nacimiento']/following-sibling::div[contains(@class, 'error')] | //input[@name='fecha_nacimiento']/../span[contains(@class, 'error')]");
    
    public static final Target ERROR_CAMPO_TELEFONO = Target.the("error campo teléfono")
            .locatedBy("//input[@name='telefono']/following-sibling::div[contains(@class, 'error')] | //input[@name='telefono']/../span[contains(@class, 'error')]");
    
    public static final Target ERROR_CAMPO_CIUDAD = Target.the("error campo ciudad")
            .locatedBy("//input[@name='ciudad']/following-sibling::div[contains(@class, 'error')] | //input[@name='ciudad']/../span[contains(@class, 'error')]");
    
    public static final Target ERROR_CAMPO_DEPARTAMENTO = Target.the("error campo departamento")
            .locatedBy("//input[@name='departamento']/following-sibling::div[contains(@class, 'error')] | //input[@name='departamento']/../span[contains(@class, 'error')]");
    
    // ==========================================
    // Página y navegación
    // ==========================================
    
    // Título de la página
    public static final Target TITULO_PAGINA = Target.the("título de información básica")
            .locatedBy("//h2[contains(text(), 'Información básica')] | //h1[contains(text(), 'Información básica')] | //h2[contains(text(), 'Datos personales')]");
    
    // Página de destino (Step 3 - Hogar y experiencia)
    public static final Target PAGINA_HOGAR_EXPERIENCIA = Target.the("página hogar y experiencia")
            .locatedBy("//h2[contains(text(), 'Hogar')] | //h1[contains(text(), 'Hogar')] | //div[contains(@class, 'step')]//*[contains(text(), 'Hogar y experiencia')][contains(@class, 'active')]");
    
    // ==========================================
    // Step 3: Hogar y experiencia
    // ==========================================
    
    // Tipo de vivienda
    public static final Target SELECT_TIPO_VIVIENDA = Target.the("selector tipo de vivienda")
            .locatedBy("//select[@name='tipo_vivienda']");
    
    // Propiedad de la vivienda
    public static final Target SELECT_PROPIEDAD = Target.the("selector propiedad")
            .locatedBy("//select[@name='propiedad_vivienda']");
    
    // Tamaño del hogar
    public static final Target SELECT_TAMANO_HOGAR = Target.the("selector tamaño del hogar")
            .locatedBy("//select[@name='tamano_hogar']");
    
    // Número de personas
    public static final Target CAMPO_NUMERO_PERSONAS = Target.the("campo número de personas")
            .locatedBy("//input[@name='numero_personas']");
    
    // Ingresos estimados
    public static final Target SELECT_INGRESOS = Target.the("selector ingresos estimados")
            .locatedBy("//select[@name='ingresos_estimados']");
    
    // Horas solo
    public static final Target CAMPO_HORAS_SOLO = Target.the("campo horas solo")
            .locatedBy("//input[@name='tiempo_solo_horas']");
    
    // Checkboxes
    public static final Target CHECKBOX_PATIO = Target.the("checkbox tiene patio")
            .locatedBy("//input[@name='tiene_patio']");
    
    public static final Target CHECKBOX_NINOS = Target.the("checkbox tiene niños")
            .locatedBy("//input[@name='tiene_ninos']");
    
    public static final Target CHECKBOX_MASCOTAS_ACT = Target.the("checkbox tiene mascotas actualmente")
            .locatedBy("//input[@name='tiene_mascotas_actualmente']");
    
    // Textareas
    public static final Target AREA_EXPERIENCIA = Target.the("textarea experiencia con mascotas")
            .locatedBy("//textarea[@name='experiencia_mascotas']");
    
    public static final Target AREA_MOTIVACION = Target.the("textarea motivación")
            .locatedBy("//textarea[@name='motivacion']");
    
    // Checkbox acuerdo de responsabilidad - usar label para hacer click
    public static final Target CHECKBOX_ACUERDO = Target.the("checkbox acuerdo de responsabilidad")
            .locatedBy("//input[@name='acuerdo_responsabilidad'] | //label[@for='acuerdo'] | //div[contains(@class, 'checkbox')]//label[contains(text(), 'acuerdo')]");
    
    // Botón guardar perfil (Step 3)
    public static final Target BOTON_GUARDAR_PERFIL = Target.the("botón guardar perfil")
            .locatedBy("//button[@type='submit'][contains(text(), 'Guardar')] | //button[contains(text(), 'Guardar')]");
    
    // ==========================================
    // Dashboard - Completar perfil
    // ==========================================
    
    // Mensaje de bienvenida en dashboard
    public static final Target MENSAJE_BIENVENIDA = Target.the("mensaje de bienvenida")
            .locatedBy("//h1[contains(@class, 'text-3xl')] | //h1[contains(text(), 'Hola')] | //div[contains(@class, 'bienvenido')]");
    
    // Botón "Completar ahora" en dashboard
    public static final Target BOTON_COMPLETAR_PERFIL = Target.the("botón completar perfil")
            .locatedBy("//a[contains(@href, '/perfil-adoptante/registrar')] | //a[contains(text(), 'Completar ahora')]");
    
    // Mensaje de éxito al guardar perfil (crear o actualizar)
    public static final Target MENSAJE_EXITO_PERFIL = Target.the("mensaje de éxito del perfil")
            .locatedBy("//main//h1 | //main//h2 | //div[contains(@class, 'card')]//h1 | //div[contains(@class, 'card')]//h2 | //*[contains(text(), 'Perfil')] | //*[contains(text(), 'completado')] | //*[contains(text(), 'actualizado')] | //*[contains(text(), 'creado')]");

    private PerfilAdoptanteTargets() {
        throw new UnsupportedOperationException("Clase de constantes - no instanciar");
    }
}
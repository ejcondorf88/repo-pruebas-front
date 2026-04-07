package targets;

import net.serenitybdd.screenplay.targets.Target;

/**
 * Localizadores de elementos UI para la página de Registrar Mascota.
 */
public class MascotaTargets {

    // ==========================================
    // Paso 1 - Información básica
    // ==========================================
    
    // Campo nombre
    public static final Target CAMPO_NOMBRE = Target.the("campo de nombre")
            .locatedBy("//input[@name='nombre']");
    
    // Selector especie
    public static final Target SELECT_ESPECIE = Target.the("selector de especie")
            .locatedBy("//select[@name='especie']");
    
    // Campo raza
    public static final Target CAMPO_RAZA = Target.the("campo de raza")
            .locatedBy("//input[@name='raza']");
    
    // Selector estado
    public static final Target SELECT_ESTADO = Target.the("selector de estado")
            .locatedBy("//select[@name='estado']");
    
    // Campo edad número
    public static final Target CAMPO_EDAD = Target.the("campo de edad")
            .locatedBy("//input[@name='edad']");
    
    // Selector unidad de edad
    public static final Target SELECT_UNIDAD_EDAD = Target.the("selector de unidad de edad")
            .locatedBy("//select[@name='edad_unidad']");
    
    // Campo fecha nacimiento
    public static final Target CAMPO_FECHA_NACIMIENTO = Target.the("campo de fecha de nacimiento")
            .locatedBy("//input[@name='fecha_nacimiento']");
    
    // Selector tamaño
    public static final Target SELECT_TAMANO = Target.the("selector de tamaño")
            .locatedBy("//select[@name='tamano']");
    
    // Campo peso
    public static final Target CAMPO_PESO = Target.the("campo de peso")
            .locatedBy("//input[@name='peso']");
    
    // Selector sexo
    public static final Target SELECT_SEXO = Target.the("selector de sexo")
            .locatedBy("//select[@name='sexo']");
    
    // Botón siguiente
    public static final Target BOTON_SIGUIENTE = Target.the("botón siguiente")
            .locatedBy("//button[contains(text(), 'Siguiente')]");

    // ==========================================
    // Paso 2 - Información de salud
    // ==========================================
    
    // Selector nivel energía
    public static final Target SELECT_NIVEL_ENERGIA = Target.the("selector de nivel de energía")
            .locatedBy("//select[@name='nivel_energia']");
    
    // Selector nivel independencia
    public static final Target SELECT_NIVEL_INDEPENDENCIA = Target.the("selector de nivel de independencia")
            .locatedBy("//select[@name='nivel_independencia']");
    
    // Selector nivel complejidad
    public static final Target SELECT_NIVEL_COMPLEJIDAD = Target.the("selector de nivel de complejidad")
            .locatedBy("//select[@name='nivel_complejidad']");
    
    // Selector sociabilidad
    public static final Target SELECT_NIVEL_SOCIALIDAD = Target.the("selector de sociabilidad")
            .locatedBy("//select[@name='nivel_sociabilidad']");
    
    // Selector apta para niños
    public static final Target SELECT_APTA_NINOS = Target.the("selector apta para niños")
            .locatedBy("//select[@name='apta_ninos']");
    
    // Selector costo estimado
    public static final Target SELECT_COSTO_ESTIMADO = Target.the("selector de costo estimado")
            .locatedBy("//select[@name='costo_estimado_mensual']");
    
    // Campo historia
    public static final Target CAMPO_HISTORIA = Target.the("campo de historia")
            .locatedBy("//textarea[@name='historia_mascota']");
    
    // Campo información adicional
    public static final Target CAMPO_INFO_ADICIONAL = Target.the("campo de información adicional")
            .locatedBy("//textarea[@name='info_adicional']");
    
    // Botón registrar
    public static final Target BOTON_REGISTRAR = Target.the("botón registrar mascota")
            .locatedBy("//button[contains(text(), 'Registrar mascota')]");
    
    // Botón anterior
    public static final Target BOTON_ANTERIOR = Target.the("botón anterior")
            .locatedBy("//button[contains(text(), 'Anterior')]");
    
    // ==========================================
    // Vacunas (requerido)
    // ==========================================
    
    // Botón agregar vacuna
    public static final Target BOTON_AGREGAR_VACUNA = Target.the("botón agregar vacuna")
            .locatedBy("//button[contains(text(), 'Agregar vacuna')]");
    
    // Campo nombre de vacuna
    public static final Target CAMPO_NOMBRE_VACUNA = Target.the("campo de nombre de vacuna")
            .locatedBy("(//input[@name='vacunas.0.nombre'])[1]");
    
    // Campo fecha de vacuna
    public static final Target CAMPO_FECHA_VACUNA = Target.the("campo de fecha de aplicación")
            .locatedBy("(//input[@name='vacunas.0.fecha_aplicacion'])[1]");

    // ==========================================
    // stepper
    // ==========================================
    
    // Step 1 activo
    public static final Target STEP_1 = Target.the("step 1 información básica")
            .locatedBy("//div[contains(@class, 'stepper')]//button[1]");
    
    // Step 2 activo
    public static final Target STEP_2 = Target.the("step 2 información de salud")
            .locatedBy("//div[contains(@class, 'stepper')]//button[2]");

    // ==========================================
    // Mensajes
    // ==========================================
    
    // Mensaje de éxito - busca en toast o alert
    public static final Target MENSAJE_EXITO = Target.the("mensaje de éxito")
            .locatedBy("//div[contains(@class, 'toast')] | //div[contains(@role, 'alert')] | //*[contains(text(), 'exitosamente')]");
    
    // Mensaje de error
    public static final Target MENSAJE_ERROR = Target.the("mensaje de error")
            .locatedBy("//div[contains(@class, 'text-red-500')] | //*[contains(@class, 'error')] | //*[contains(@role, 'alert')]");

    private MascotaTargets() {
        throw new UnsupportedOperationException("Clase de constantes - no instanciar");
    }
}
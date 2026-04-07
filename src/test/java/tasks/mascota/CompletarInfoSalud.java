package tasks.mascota;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static targets.MascotaTargets.*;

/**
 * Task para completar el formulario de registrar mascota - Paso 2
 */
public class CompletarInfoSalud implements Task {

    private final String nivelEnergia;
    private final String nivelIndependencia;
    private final String nivelComplejidad;
    private final String nivelSociabilidad;
    private final String aptaNinos;
    private final String costoEstimado;
    private final String historia;
    private final String infoAdicional;

    public static CompletarInfoSalud conDatos(
            String nivelEnergia, String nivelIndependencia,
            String nivelComplejidad, String nivelSociabilidad,
            String aptaNinos, String costoEstimado,
            String historia, String infoAdicional) {
        return Tasks.instrumented(CompletarInfoSalud.class,
                nivelEnergia, nivelIndependencia, nivelComplejidad,
                nivelSociabilidad, aptaNinos, costoEstimado,
                historia, infoAdicional);
    }

    public CompletarInfoSalud(
            String nivelEnergia, String nivelIndependencia,
            String nivelComplejidad, String nivelSociabilidad,
            String aptaNinos, String costoEstimado,
            String historia, String infoAdicional) {
        this.nivelEnergia = nivelEnergia;
        this.nivelIndependencia = nivelIndependencia;
        this.nivelComplejidad = nivelComplejidad;
        this.nivelSociabilidad = nivelSociabilidad;
        this.aptaNinos = aptaNinos;
        this.costoEstimado = costoEstimado;
        this.historia = historia;
        this.infoAdicional = infoAdicional;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                // Esperar que cargue el paso 2
                WaitUntil.the(SELECT_NIVEL_ENERGIA, WebElementStateMatchers.isVisible())
                        .forNoMoreThan(20).seconds(),

                // Paso 2 - Información de salud
                SelectFromOptions.byValue(nivelEnergia).from(SELECT_NIVEL_ENERGIA),
                SelectFromOptions.byValue(nivelIndependencia).from(SELECT_NIVEL_INDEPENDENCIA),
                SelectFromOptions.byValue(nivelComplejidad).from(SELECT_NIVEL_COMPLEJIDAD),
                SelectFromOptions.byValue(nivelSociabilidad).from(SELECT_NIVEL_SOCIALIDAD),
                SelectFromOptions.byValue(aptaNinos).from(SELECT_APTA_NINOS),
                SelectFromOptions.byValue(costoEstimado).from(SELECT_COSTO_ESTIMADO),

                // Vacunas (requerido) - click en agregar vacuna primero
                Click.on(BOTON_AGREGAR_VACUNA),
                WaitUntil.the(CAMPO_NOMBRE_VACUNA, WebElementStateMatchers.isVisible())
                        .forNoMoreThan(5).seconds(),
                Enter.theValue("Rabia").into(CAMPO_NOMBRE_VACUNA),
                Enter.theValue("2025-01-15").into(CAMPO_FECHA_VACUNA),

                // Campos opcionales
                Enter.theValue(historia).into(CAMPO_HISTORIA),
                Enter.theValue(infoAdicional).into(CAMPO_INFO_ADICIONAL),

                // Click en registrar
                Click.on(BOTON_REGISTRAR)
        );
    }
}
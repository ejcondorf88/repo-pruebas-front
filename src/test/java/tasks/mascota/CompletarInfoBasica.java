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
 * Task para completar el formulario de registrar mascota - Paso 1
 */
public class CompletarInfoBasica implements Task {

    private final String nombre;
    private final String especie;
    private final String raza;
    private final String estado;
    private final String edad;
    private final String unidadEdad;
    private final String fechaNacimiento;
    private final String tamano;
    private final String peso;
    private final String sexo;

    public static CompletarInfoBasica conDatos(
            String nombre, String especie, String raza, String estado,
            String edad, String unidadEdad, String fechaNacimiento,
            String tamano, String peso, String sexo) {
        return Tasks.instrumented(CompletarInfoBasica.class,
                nombre, especie, raza, estado, edad, unidadEdad,
                fechaNacimiento, tamano, peso, sexo);
    }

    public CompletarInfoBasica(
            String nombre, String especie, String raza, String estado,
            String edad, String unidadEdad, String fechaNacimiento,
            String tamano, String peso, String sexo) {
        this.nombre = nombre;
        this.especie = especie;
        this.raza = raza;
        this.estado = estado;
        this.edad = edad;
        this.unidadEdad = unidadEdad;
        this.fechaNacimiento = fechaNacimiento;
        this.tamano = tamano;
        this.peso = peso;
        this.sexo = sexo;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                // Esperar que cargue el formulario
                WaitUntil.the(CAMPO_NOMBRE, WebElementStateMatchers.isVisible())
                        .forNoMoreThan(20).seconds(),

                // Paso 1 - Información básica
                Enter.theValue(nombre).into(CAMPO_NOMBRE),
                SelectFromOptions.byValue(especie).from(SELECT_ESPECIE),
                Enter.theValue(raza).into(CAMPO_RAZA),
                SelectFromOptions.byValue(estado).from(SELECT_ESTADO),
                Enter.theValue(edad).into(CAMPO_EDAD),
                SelectFromOptions.byValue(unidadEdad).from(SELECT_UNIDAD_EDAD),
                Enter.theValue(fechaNacimiento).into(CAMPO_FECHA_NACIMIENTO),
                SelectFromOptions.byValue(tamano).from(SELECT_TAMANO),
                Enter.theValue(peso).into(CAMPO_PESO),
                SelectFromOptions.byValue(sexo).from(SELECT_SEXO),

                // Ir al paso 2
                Click.on(BOTON_SIGUIENTE)
        );
    }
}
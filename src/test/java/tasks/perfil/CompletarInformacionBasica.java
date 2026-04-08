package tasks.perfil;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;

import static targets.PerfilAdoptanteTargets.*;

/**
 * Task para completar el formulario de Información básica (Step 2)
 * en el proceso de completar el perfil del adoptante.
 */
public class CompletarInformacionBasica implements Task {

    private final String nombreFamilia;
    private final String cedula;
    private final String fechaNacimiento;
    private final String telefono;
    private final String ciudad;
    private final String departamento;
    private final String redesSociales;

    public static CompletarInformacionBasica conDatos(
            String nombreFamilia, 
            String cedula, 
            String fechaNacimiento, 
            String telefono, 
            String ciudad, 
            String departamento, 
            String redesSociales) {
        return Tasks.instrumented(
                CompletarInformacionBasica.class,
                nombreFamilia, cedula, fechaNacimiento, telefono, ciudad, departamento, redesSociales
        );
    }

    public CompletarInformacionBasica(
            String nombreFamilia, 
            String cedula, 
            String fechaNacimiento, 
            String telefono, 
            String ciudad, 
            String departamento, 
            String redesSociales) {
        this.nombreFamilia = nombreFamilia;
        this.cedula = cedula;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.ciudad = ciudad;
        this.departamento = departamento;
        this.redesSociales = redesSociales;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                // Esperar que el formulario esté visible
                WaitUntil.the(CAMPO_NOMBRE_FAMILIA, WebElementStateMatchers.isVisible())
                        .forNoMoreThan(20).seconds()
        );

        // Completar campos si se proporcionan valores
        if (nombreFamilia != null && !nombreFamilia.isEmpty()) {
            actor.attemptsTo(
                    Clear.field(CAMPO_NOMBRE_FAMILIA),
                    Enter.theValue(nombreFamilia).into(CAMPO_NOMBRE_FAMILIA)
            );
        }

        if (cedula != null && !cedula.isEmpty()) {
            actor.attemptsTo(
                    Clear.field(CAMPO_CEDULA),
                    Enter.theValue(cedula).into(CAMPO_CEDULA)
            );
        }

        if (fechaNacimiento != null && !fechaNacimiento.isEmpty()) {
            actor.attemptsTo(
                    Clear.field(CAMPO_FECHA_NACIMIENTO),
                    Enter.theValue(fechaNacimiento).into(CAMPO_FECHA_NACIMIENTO)
            );
        }

        if (telefono != null && !telefono.isEmpty()) {
            actor.attemptsTo(
                    Clear.field(CAMPO_TELEFONO),
                    Enter.theValue(telefono).into(CAMPO_TELEFONO)
            );
        }

        if (ciudad != null && !ciudad.isEmpty()) {
            actor.attemptsTo(
                    Clear.field(CAMPO_CIUDAD),
                    Enter.theValue(ciudad).into(CAMPO_CIUDAD)
            );
        }

        if (departamento != null && !departamento.isEmpty()) {
            actor.attemptsTo(
                    Clear.field(CAMPO_DEPARTAMENTO),
                    Enter.theValue(departamento).into(CAMPO_DEPARTAMENTO)
            );
        }

        if (redesSociales != null && !redesSociales.isEmpty()) {
            actor.attemptsTo(
                    Clear.field(CAMPO_REDES_SOCIALES),
                    Enter.theValue(redesSociales).into(CAMPO_REDES_SOCIALES)
            );
        }
    }

    /**
     * Método estático para hacer clic en el botón Continuar.
     * Separado para permitir flujos donde se llame después de completar.
     */
    public static net.serenitybdd.screenplay.actions.ClickInteraction clickContinuar() {
        return Click.on(BOTON_CONTINUAR);
    }
}
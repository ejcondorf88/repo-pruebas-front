package tasks.perfil;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;

import static targets.PerfilAdoptanteTargets.*;

/**
 * Task para completar el formulario de Hogar y experiencia (Step 3)
 * en el proceso de completar el perfil del adoptante.
 */
public class CompletarHogarYExperiencia implements Task {

    private final String tipoVivienda;
    private final String propiedad;
    private final String tamanoHogar;
    private final String numeroPersonas;
    private final String ingresos;
    private final String horasSolo;
    private final boolean tienePatio;
    private final boolean tieneNinos;
    private final boolean tieneMascotasAct;
    private final String experiencia;
    private final String motivacion;

    public static CompletarHogarYExperiencia conDatos(
            String tipoVivienda, 
            String propiedad,
            String tamanoHogar,
            String numeroPersonas,
            String ingresos,
            String horasSolo,
            boolean tienePatio,
            boolean tieneNinos,
            boolean tieneMascotasAct,
            String experiencia,
            String motivacion) {
        return Tasks.instrumented(
                CompletarHogarYExperiencia.class,
                tipoVivienda, propiedad, tamanoHogar, numeroPersonas,
                ingresos, horasSolo, tienePatio, tieneNinos, tieneMascotasAct,
                experiencia, motivacion
        );
    }

    public CompletarHogarYExperiencia(
            String tipoVivienda, 
            String propiedad,
            String tamanoHogar,
            String numeroPersonas,
            String ingresos,
            String horasSolo,
            boolean tienePatio,
            boolean tieneNinos,
            boolean tieneMascotasAct,
            String experiencia,
            String motivacion) {
        this.tipoVivienda = tipoVivienda;
        this.propiedad = propiedad;
        this.tamanoHogar = tamanoHogar;
        this.numeroPersonas = numeroPersonas;
        this.ingresos = ingresos;
        this.horasSolo = horasSolo;
        this.tienePatio = tienePatio;
        this.tieneNinos = tieneNinos;
        this.tieneMascotasAct = tieneMascotasAct;
        this.experiencia = experiencia;
        this.motivacion = motivacion;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(SELECT_TIPO_VIVIENDA, WebElementStateMatchers.isVisible())
                        .forNoMoreThan(20).seconds()
        );

        // Mapeo de valores visibles a valores del option
        String tipoValor = mapTipoVivienda(tipoVivienda);
        String propiedadValor = mapPropiedad(propiedad);
        String tamanoValor = mapTamanoHogar(tamanoHogar);
        String ingresosValor = mapIngresos(ingresos);

        if (tipoValor != null) {
            actor.attemptsTo(SelectFromOptions.byValue(tipoValor).from(SELECT_TIPO_VIVIENDA));
        }

        if (propiedadValor != null) {
            actor.attemptsTo(SelectFromOptions.byValue(propiedadValor).from(SELECT_PROPIEDAD));
        }

        if (tamanoValor != null) {
            actor.attemptsTo(SelectFromOptions.byValue(tamanoValor).from(SELECT_TAMANO_HOGAR));
        }

        if (numeroPersonas != null && !numeroPersonas.isEmpty()) {
            actor.attemptsTo(Enter.theValue(numeroPersonas).into(CAMPO_NUMERO_PERSONAS));
        }

        if (ingresosValor != null) {
            actor.attemptsTo(SelectFromOptions.byValue(ingresosValor).from(SELECT_INGRESOS));
        }

        if (horasSolo != null && !horasSolo.isEmpty()) {
            actor.attemptsTo(Enter.theValue(horasSolo).into(CAMPO_HORAS_SOLO));
        }

        if (experiencia != null && !experiencia.isEmpty()) {
            actor.attemptsTo(Enter.theValue(experiencia).into(AREA_EXPERIENCIA));
        }

        if (motivacion != null && !motivacion.isEmpty()) {
            actor.attemptsTo(Enter.theValue(motivacion).into(AREA_MOTIVACION));
        }
    }

    private String mapTipoVivienda(String tipo) {
        if (tipo == null) return null;
        switch (tipo.toLowerCase()) {
            case "casa": return "CASA";
            case "apartamento": return "APARTAMENTO";
            case "finca": return "FINCA";
            case "otro": return "OTRO";
            default: return tipo.toUpperCase();
        }
    }

    private String mapPropiedad(String propiedad) {
        if (propiedad == null) return null;
        switch (propiedad.toLowerCase()) {
            case "propia": return "PROPIA";
            case "alquilada": return "ALQUILADA";
            default: return propiedad.toUpperCase();
        }
    }

    private String mapTamanoHogar(String tamano) {
        if (tamano == null) return null;
        switch (tamano.toLowerCase()) {
            case "pequeno": return "PEQUENO";
            case "mediano": return "MEDIANO";
            case "grande": return "GRANDE";
            default: return tamano.toUpperCase();
        }
    }

    private String mapIngresos(String ingresos) {
        if (ingresos == null) return null;
        switch (ingresos.toLowerCase()) {
            case "menos de 1 smlv":
            case "menos de 1": return "MENOS_1SMLV";
            case "1-2 smlv":
            case "1–2 smlv": return "1_2SMLV";
            case "2-4 smlv":
            case "2–4 smlv": return "2_4SMLV";
            case "mas de 4 smlv":
            case "más de 4 smlv": return "MAS_4SMLV";
            default: return ingresos;
        }
    }

    public static net.serenitybdd.screenplay.actions.ClickInteraction clickGuardarPerfil() {
        return Click.on(BOTON_GUARDAR_PERFIL);
    }

    public static net.serenitybdd.screenplay.actions.ClickInteraction clickAtras() {
        return Click.on(BOTON_ATRAS);
    }
}
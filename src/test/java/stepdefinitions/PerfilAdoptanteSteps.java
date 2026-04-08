package stepdefinitions;

import io.cucumber.java.es.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import tasks.perfil.CompletarInformacionBasica;
import tasks.perfil.CompletarHogarYExperiencia;
import tasks.perfil.LoginYNavegarACompletarPerfil;
import tasks.perfil.LoginComoFamiliaYNavegarAPerfil;
import questions.ElMensajeDeValidacion;
import static targets.PerfilAdoptanteTargets.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import org.hamcrest.Matchers;

/**
 * Step Definitions para los escenarios de completar el perfil del adoptante
 * en el paso "Información básica" (Step 2).
 */
public class PerfilAdoptanteSteps {

    @Dado("que el usuario está en el paso {string} del perfil")
    public void usuarioEstaEnElPasoDelPerfil(String paso) {
        Actor actor = OnStage.theActorCalled("Usuario");
        // Navegar directamente al paso 2 - Información básica
        actor.attemptsTo(
                net.serenitybdd.screenplay.actions.Open.url("http://localhost/perfil-adoptante/registrar"),
                WaitUntil.the(CAMPO_NOMBRE_FAMILIA, WebElementStateMatchers.isVisible())
                        .forNoMoreThan(20).seconds()
        );
    }

    @Cuando("completa el formulario con nombre {string}, cédula {string}, fecha {string}")
    public void completaFormularioConDatosBasicos(String nombre, String cedula, String fecha) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                CompletarInformacionBasica.conDatos(
                        nombre, cedula, fecha, null, null, null, null
                )
        );
    }

    @Y("teléfono {string}, ciudad {string}, departamento {string}")
    public void completaCamposDireccion(String telefono, String ciudad, String departamento) {
        // Completar campos adicionales de dirección
        OnStage.theActorInTheSpotlight().attemptsTo(
                CompletarInformacionBasica.conDatos(
                        "", "", "",
                        telefono != null && !telefono.isEmpty() ? telefono : null,
                        ciudad != null && !ciudad.isEmpty() ? ciudad : null,
                        departamento != null && !departamento.isEmpty() ? departamento : null,
                        null
                )
        );
    }

    @Y("teléfono {string}, ciudad {string}")
    public void completaTelefonoYCiudad(String telefono, String ciudad) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                CompletarInformacionBasica.conDatos(
                        "", "", "",
                        telefono != null && !telefono.isEmpty() ? telefono : null,
                        ciudad != null && !ciudad.isEmpty() ? ciudad : null,
                        null,
                        null
                )
        );
    }

    @Y("redes sociales {string}")
    public void completaRedesSociales(String redes) {
        // Completar redes sociales
        if (redes != null && !redes.isEmpty()) {
            OnStage.theActorInTheSpotlight().attemptsTo(
                    net.serenitybdd.screenplay.actions.Enter.theValue(redes).into(CAMPO_REDES_SOCIALES)
            );
        }
    }

    @Y("hace clic en el botón {string}")
    public void haceClickEnElBoton(String boton) {
        if (boton.equals("Continuar")) {
            OnStage.theActorInTheSpotlight().attemptsTo(
                    Click.on(BOTON_CONTINUAR)
            );
        } else if (boton.equals("Atrás")) {
            OnStage.theActorInTheSpotlight().attemptsTo(
                    Click.on(BOTON_ATRAS)
            );
        } else if (boton.equals("Guardar perfil")) {
            OnStage.theActorInTheSpotlight().attemptsTo(
                    Click.on(BOTON_GUARDAR_PERFIL)
            );
        }
    }

    @Entonces("debería avanzar al paso {string}")
    public void deberiaAvanzarAlPaso(String paso) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(PAGINA_HOGAR_EXPERIENCIA, WebElementStateMatchers.isVisible())
                        .forNoMoreThan(15).seconds()
        );
    }

    @Entonces("debería ver mensaje de error de validación")
    public void deberiaVerMensajeDeValidacion() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(MENSAJE_ERROR, WebElementStateMatchers.isVisible())
                        .forNoMoreThan(10).seconds()
        );
        OnStage.theActorInTheSpotlight().should(
                seeThat("el mensaje de validación",
                        ElMensajeDeValidacion.desplegado(),
                        Matchers.notNullValue())
        );
    }

    @Entonces("debería volver al paso {string}")
    public void deberiaVolverAlPaso(String paso) {
        // Verificar que回到了 paso anterior (Step 1 - Cuenta)
        // Verificar que el indicador de paso muestra "Cuenta" como activo
        OnStage.theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(STEP_CUENTA, WebElementStateMatchers.isVisible())
                        .forNoMoreThan(10).seconds()
        );
    }

    @Cuando("completa el formulario con nombre {string}, cédula {string}")
    public void completaFormularioParcial(String nombre, String cedula) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                CompletarInformacionBasica.conDatos(
                        nombre, cedula, null, null, null, null, null
                )
        );
    }

    @Y("deja vacíos departamento y redes sociales")
    public void dejaCamposVacios() {
        // Los campos quedan vacíos intencionalmente
    }

    @Y("fecha {string}, teléfono {string}, ciudad {string}, departamento {string}")
    public void completaDatosDireccion(String fecha, String telefono, String ciudad, String departamento) {
        // Solo completar fecha - teléfono y ciudad se completan en otro paso
        if (fecha != null && !fecha.isEmpty()) {
            OnStage.theActorInTheSpotlight().attemptsTo(
                    net.serenitybdd.screenplay.actions.Enter.theValue(fecha).into(CAMPO_FECHA_NACIMIENTO)
            );
        }
    }

    @Cuando("completa los campos válidos y selecciona archivo {string}")
    public void completaCamposYSeleccionaArchivo(String archivo) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                CompletarInformacionBasica.conDatos(
                        "Familia Prueba", "1234567890", "1990-01-01",
                        "3001234567", "Bogotá", "Cundinamarca", "@familia"
                )
        );
    }

    @Cuando("completa los campos válidos y selecciona imagen mayor a {string}")
    public void completaCamposYSeleccionaArchivoGrande(String tamano) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                CompletarInformacionBasica.conDatos(
                        "Familia Prueba", "1234567890", "1990-01-01",
                        "3001234567", "Bogotá", "Cundinamarca", "@familia"
                )
        );
    }

    // ===============================================
    // Steps para el flujo completo (Login -> Perfil)
    // ===============================================

    @Dado("que el usuario está logueado como familia")
    public void usuarioLogueadoComoFamilia() {
        Actor actor = OnStage.theActorCalled("Usuario");
        actor.attemptsTo(
                net.serenitybdd.screenplay.actions.Open.url("http://localhost/perfil-adoptante/registrar"),
                WaitUntil.the(CAMPO_NOMBRE_FAMILIA, WebElementStateMatchers.isVisible())
                        .forNoMoreThan(20).seconds()
        );
    }

    @Cuando("completa la información básica con nombre {string}, cédula {string}, teléfono {string}, ciudad {string}")
    public void completaInfoBasica(String nombre, String cedula, String telefono, String ciudad) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                CompletarInformacionBasica.conDatos(
                        nombre, cedula, "1990-01-01", telefono, ciudad, "Cundinamarca", "@test"
                )
        );
    }

    @Y("hace clic en Continuar")
    public void haceClickContinuar() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Click.on(BOTON_CONTINUAR)
        );
    }

    @Entonces("debería ver la página de Hogar y experiencia")
    public void deberiaVerHogarYExperiencia() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(PAGINA_HOGAR_EXPERIENCIA, WebElementStateMatchers.isVisible())
                        .forNoMoreThan(15).seconds()
        );
    }

    @Cuando("completa el formulario de hogar con tipo {string}, propiedad {string}, personas {string}")
    public void completaFormularioHogar(String tipo, String propiedad, String personas) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                CompletarHogarYExperiencia.conDatos(
                        tipo, propiedad, "MEDIANO", personas, "2_4SMLV", "4",
                        true, false, false, "Tengo experiencia con perros", "Quiero dar amor a una mascota"
                )
        );
    }

    @Y("marca la opción de responsabilidad")
    public void marcaOpcionResponsabilidad() {
        // El checkbox puede estar ya marcado (al actualizar perfil) o desmarcado (al crear)
        // Necesitamos asegurarnos de que esté marcado
        OnStage.theActorInTheSpotlight().attemptsTo(
                // Intentar hacer click - si ya está marcado, no importa porque seguirá marcado
                // O podemos verificar si ya está marcado antes
                Click.on(CHECKBOX_ACUERDO)
        );
    }

    @Y("guarda el perfil")
    public void guardaElPerfil() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Click.on(BOTON_GUARDAR_PERFIL)
        );
    }

    @Entonces("debería ver el perfil completado")
    public void deberiaVerPerfilCompletado() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(MENSAJE_EXITO_PERFIL, WebElementStateMatchers.isVisible())
                        .forNoMoreThan(15).seconds()
        );
    }

    // ===============================================
    // Flujo completo: Login -> Dashboard -> Perfil
    // ===============================================

    @Dado("que el usuario familia está logueado en el dashboard")
    public void usuarioFamiliaLogueadoEnDashboard() {
        Actor actor = OnStage.theActorCalled("Usuario Familia");
        // Login como familia con cuenta NUEVA
        actor.attemptsTo(
                LoginComoFamiliaYNavegarAPerfil.conCredenciales("eliansote@hotmail.es", "Pigo0173!")
        );
    }

    @Dado("que el usuario está en el dashboard como familia")
    public void usuarioEnDashboardComoFamilia() {
        Actor actor = OnStage.theActorCalled("Usuario");
        // Login + navegar al perfil en UNA sola sesión para mantener cookies
        actor.attemptsTo(
                LoginYNavegarACompletarPerfil.comoFamilia("admin@pettech.com", "Admin1234!")
        );
    }

    @Cuando("hace clic en Completar ahora")
    public void haceClickCompletarAhora() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Click.on(BOTON_COMPLETAR_PERFIL)
        );
    }

    @Entonces("debería estar en la página de información básica")
    public void deberiaEstarEnInformacionBasica() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(CAMPO_NOMBRE_FAMILIA, WebElementStateMatchers.isVisible())
                        .forNoMoreThan(10).seconds()
        );
    }

    @Y("hace clic en el botón Atrás")
    public void haceClickAtrasEnHogar() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Click.on(BOTON_ATRAS)
        );
    }
}
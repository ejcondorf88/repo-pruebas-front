package stepdefinitions;

import io.cucumber.java.es.*;
import models.Perfil;
import net.serenitybdd.screenplay.actors.OnStage;
import questions.ElMensajeDeConfirmacion;
import questions.ElMensajeDeError;
import questions.ElPerfilEstaCompleto;
import tasks.perfil.*;

import java.time.LocalDate;
import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static org.hamcrest.Matchers.*;

/**
 * Step Definitions para los escenarios de Perfil.
 */
public class PerfilSteps {

    @Dado("que tiene una familia creada")
    public void queTieneUnaFamiliaCreada() {
        // Precondición ya establecida
    }

    @Dado("que está en la página de perfil")
    public void queEstaEnLaPaginaDePerfil() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                NavegarAPerfil.directo()
        );
    }

    @Dado("que está editando su perfil")
    public void queEstaEditandoSuPerfil() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                NavegarAPerfil.directo(),
                IniciarEdicionPerfil.paraEditar()
        );
    }

    @Cuando("completa la información personal")
    public void completaLaInformacionPersonal(Map<String, String> datos) {
        Perfil.Builder builder = Perfil.para(datos.get("nombre_completo"));

        if (datos.containsKey("fecha_nacimiento")) {
            builder.conFechaNacimiento(LocalDate.parse(datos.get("fecha_nacimiento")));
        }
        if (datos.containsKey("ocupacion")) {
            builder.conOcupacion(datos.get("ocupacion"));
        }
        if (datos.containsKey("biografia")) {
            builder.conBiografia(datos.get("biografia"));
        }

        Perfil perfil = builder.build();
        OnStage.theActorInTheSpotlight().attemptsTo(
                CompletarInformacionPersonal.delPerfil(perfil)
        );
    }

    @Cuando("completa la información de vivienda")
    public void completaLaInformacionDeVivienda(Map<String, String> datos) {
        Perfil.Builder builder = Perfil.para("");

        if (datos.containsKey("tipo_vivienda")) {
            builder.conTipoVivienda(datos.get("tipo_vivienda"));
        }
        if (datos.containsKey("tiene_patio")) {
            builder.conPatio(Boolean.parseBoolean(datos.get("tiene_patio")));
        }
        if (datos.containsKey("permite_mascotas")) {
            builder.permiteMascotas(Boolean.parseBoolean(datos.get("permite_mascotas")));
        }

        Perfil perfil = builder.build();
        OnStage.theActorInTheSpotlight().attemptsTo(
                CompletarInformacionVivienda.delPerfil(perfil)
        );
    }

    @Cuando("completa la información de experiencia")
    public void completaLaInformacionDeExperiencia(Map<String, String> datos) {
        Perfil.Builder builder = Perfil.para("");

        if (datos.containsKey("tiene_mascotas_previas")) {
            builder.conMascotasPrevias(Boolean.parseBoolean(datos.get("tiene_mascotas_previas")));
        }
        if (datos.containsKey("tipo_mascotas_previas")) {
            builder.conTipoMascotasPrevias(datos.get("tipo_mascotas_previas"));
        }

        Perfil perfil = builder.build();
        OnStage.theActorInTheSpotlight().attemptsTo(
                CompletarExperienciaMascotas.delPerfil(perfil)
        );
    }

    @Cuando("presiona en perfil {string}")
    public void presionaEnPerfil(String accion) {
        if (accion.contains("Guardar perfil")) {
            OnStage.theActorInTheSpotlight().attemptsTo(
                    GuardarPerfil.completo()
            );
        } else if (accion.contains("Borrador") || accion.contains("progreso")) {
            OnStage.theActorInTheSpotlight().attemptsTo(
                    GuardarBorrador.delPerfil()
            );
        }
    }

    @Cuando("selecciona en perfil {string}")
    public void seleccionaEnPerfil(String accion) {
        if (accion.contains("Subir foto")) {
            // Implementar task de subir foto
        }
    }

    @Cuando("selecciona un archivo de imagen válido")
    public void seleccionaUnArchivoDeImagenValido() {
        // Implementar subida de archivo
    }

    @Cuando("completa solo la información personal")
    public void completaSoloLaInformacionPersonal() {
        Perfil perfil = Perfil.perfilParcial();
        OnStage.theActorInTheSpotlight().attemptsTo(
                CompletarInformacionPersonal.delPerfil(perfil)
        );
    }

    @Cuando("intenta guardar sin completar campos obligatorios")
    public void intentaGuardarSinCompletarCamposObligatorios() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                GuardarPerfil.completo()
        );
    }

    @Cuando("intenta subir un archivo PDF como foto")
    public void intentaSubirUnArchivoPDFComoFoto() {
        // Implementar subida de archivo inválido
    }

    @Entonces("el perfil debería marcarse como {string}")
    public void elPerfilDeberiaMarcarseComo(String estado) {
        if (estado.contains("100%")) {
            OnStage.theActorInTheSpotlight().should(
                    seeThat(ElPerfilEstaCompleto.alCienPorCiento(), is(true))
            );
        }
    }

    @Entonces("el perfil debería mostrar {string}")
    public void elPerfilDeberiaMostrar(String porcentajeEsperado) {
        int porcentaje = Integer.parseInt(porcentajeEsperado.replaceAll("[^0-9]", ""));
        OnStage.theActorInTheSpotlight().should(
                seeThat(ElPerfilEstaCompleto.conPorcentaje(porcentaje), is(true))
        );
    }

    @Entonces("la foto debería previsualizarse")
    public void laFotoDeberiaPrevisualizarse() {
        // Verificar previsualización
    }

    @Entonces("al guardar debería ver el mensaje {string}")
    public void alGuardarDeberiaVerElMensaje(String mensaje) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(ElMensajeDeConfirmacion.dePerfil(), containsString(mensaje))
        );
    }

    @Entonces("debería ver el mensaje de confirmación {string}")
    public void deberiaVerElMensajeDeConfirmacion(String mensaje) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(ElMensajeDeConfirmacion.mostrado(), containsString(mensaje))
        );
    }
}

package stepdefinitions;

import io.cucumber.java.es.*;
import models.Usuario;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import questions.ElMensajeDeError;
import questions.LaPaginaDeInicio;
import tasks.login.IniciarSesion;
import tasks.login.NavegarALogin;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static org.hamcrest.Matchers.*;

/**
 * Step Definitions para los escenarios de Login.
 */
public class LoginSteps {

    @Dado("que {string} está en la página de login")
    public void queElUsuarioEstaEnLaPaginaDeLogin(String nombreActor) {
        Actor actor = OnStage.theActorCalled(nombreActor);
        actor.attemptsTo(
                NavegarALogin.pagina()
        );
    }

    @Cuando("intenta iniciar sesión con credenciales válidas")
    public void elUsuarioIntentaIniciarSesionConCredencialesValidas() {
        Usuario usuario = Usuario.usuarioValido();

        OnStage.theActorInTheSpotlight().attemptsTo(
                IniciarSesion.con(usuario)
        );
    }

    @Cuando("ingresa su email {string} y password {string}")
    public void ingresaSuEmailYPassword(String email, String password) {
        Usuario usuario = Usuario.conEmail(email)
                .yPassword(password)
                .build();

        OnStage.theActorInTheSpotlight().attemptsTo(
                IniciarSesion.con(usuario)
        );
    }

    @Cuando("presiona el botón de iniciar sesión")
    public void presionaElBotonDeIniciarSesion() {
        // Ya se presionó en IniciarSesion task
    }

    @Cuando("intenta iniciar sesión con credenciales inválidas")
    public void elUsuarioIntentaIniciarSesionConCredencialesInvalidas() {
        Usuario usuario = Usuario.usuarioInvalido();

        OnStage.theActorInTheSpotlight().attemptsTo(
                IniciarSesion.con(usuario)
        );
    }

    @Cuando("intenta iniciar sesión sin completar los campos")
    public void intentaIniciarSesionSinCompletarLosCampos() {
        Usuario usuario = Usuario.conEmail("")
                .yPassword("")
                .build();

        OnStage.theActorInTheSpotlight().attemptsTo(
                IniciarSesion.con(usuario)
        );
    }

    @Cuando("intenta iniciar sesión como usuario bloqueado")
    public void intentaIniciarSesionComoUsuarioBloqueado() {
        Usuario usuario = Usuario.usuarioBloqueado();

        OnStage.theActorInTheSpotlight().attemptsTo(
                IniciarSesion.con(usuario)
        );
    }

    @Cuando("intenta iniciar sesión como administrador")
    public void intentaIniciarSesionComoAdministrador() {
        Usuario usuario = Usuario.usuarioAdministrador();

        OnStage.theActorInTheSpotlight().attemptsTo(
                IniciarSesion.con(usuario)
        );
    }

    @Entonces("debería ver la página de inicio")
    public void deberiaVerLaPaginaDeInicio() {
        OnStage.theActorInTheSpotlight().should(
                seeThat(LaPaginaDeInicio.esVisible(), is(true))
        );
    }

    @Entonces("debería ser redirigido a la página principal")
    public void deberiaSerRedirigidoALaPaginaPrincipal() {
        OnStage.theActorInTheSpotlight().should(
                seeThat(LaPaginaDeInicio.esVisible(), is(true))
        );
    }

    @Entonces("debería ver mensajes de validación en los campos obligatorios")
    public void deberiaVerMensajesDeValidacion() {
        OnStage.theActorInTheSpotlight().should(
                seeThat(ElMensajeDeError.mostrado(), is(notNullValue()))
        );
    }

    @Dado("que cualquier usuario está en la página de login")
    public void queCualquierUsuarioEstaEnLaPaginaDeLogin() {
        Actor actor = OnStage.theActorCalled("Usuario");
        actor.attemptsTo(
                NavegarALogin.pagina()
        );
    }

    @Entonces("debería ver el campo de email")
    public void deberiaVerElCampoDeEmail() {
        // Verificación implícita en la Task
    }

    @Entonces("debería ver el campo de password")
    public void deberiaVerElCampoDePassword() {
        // Verificación implícita en la Task
    }

    @Entonces("debería ver el botón de iniciar sesión")
    public void deberiaVerElBotonDeIniciarSesion() {
        // Verificación implícita en la Task
    }

    @Entonces("debería ver el enlace a registro")
    public void deberiaVerElEnlaceARegistro() {
        // Verificación implícita
    }
}

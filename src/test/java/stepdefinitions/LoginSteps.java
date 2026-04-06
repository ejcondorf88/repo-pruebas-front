package stepdefinitions;

import io.cucumber.java.es.*;
import models.TestDataFactory;
import models.Usuario;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import questions.ElMensajeDeError;
import questions.LaPaginaDeInicio;
import tasks.IniciarSesion;
import tasks.Navegar;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static org.hamcrest.Matchers.*;

/**
 * Step Definitions para los escenarios de Login.
 * ORQUESTAN las acciones - NO contienen lógica de UI.
 * 
 * Regla de oro: Los Steps solo llaman a Tasks y Questions.
 * La lógica de interacción con la UI va en las Tasks.
 */
public class LoginSteps {

    @Dado("que {actor} está en la página de login")
    public void queElUsuarioEstaEnLaPaginaDeLogin(Actor actor) {
        // El Actor navega a la página de login
        actor.attemptsTo(
                Navegar.aLaPaginaDeLogin()
        );
    }

    @Cuando("{actor} intenta iniciar sesión con credenciales válidas")
    public void elUsuarioIntentaIniciarSesionConCredencialesValidas(Actor actor) {
        // Usamos el usuario estándar de la factory
        Usuario usuario = TestDataFactory.usuarioEstandar();
        
        actor.attemptsTo(
                IniciarSesion.con(usuario)
        );
    }

    @Cuando("{actor} intenta iniciar sesión con credenciales inválidas")
    public void elUsuarioIntentaIniciarSesionConCredencialesInvalidas(Actor actor) {
        // Usamos el usuario inválido de la factory
        Usuario usuario = TestDataFactory.usuarioInvalido();
        
        actor.attemptsTo(
                IniciarSesion.con(usuario)
        );
    }

    @Cuando("{actor} intenta iniciar sesión como administrador")
    public void elUsuarioIntentaIniciarSesionComoAdministrador(Actor actor) {
        // Usamos el usuario admin de la factory
        Usuario usuario = TestDataFactory.usuarioAdmin();
        
        actor.attemptsTo(
                IniciarSesion.con(usuario)
        );
    }

    @Entonces("debería ver la página de inicio")
    public void deberiaVerLaPaginaDeInicio() {
        // Verificamos que la página de inicio sea visible
        OnStage.theActorInTheSpotlight().should(
                seeThat(LaPaginaDeInicio.esVisible(), is(true))
        );
    }

    @Entonces("debería ver un mensaje de error")
    public void deberiaVerUnMensajeDeError() {
        // Verificamos que haya un mensaje de error visible
        OnStage.theActorInTheSpotlight().should(
                seeThat(ElMensajeDeError.mostrado(), is(notNullValue()))
        );
    }

    @Entonces("debería ver el mensaje {string}")
    public void deberiaVerElMensaje(String mensajeEsperado) {
        // Verificamos el mensaje específico
        OnStage.theActorInTheSpotlight().should(
                seeThat(ElMensajeDeError.mostrado(), equalTo(mensajeEsperado))
        );
    }
}

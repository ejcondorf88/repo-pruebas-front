package stepdefinitions;

import io.cucumber.java.es.*;
import net.serenitybdd.screenplay.actors.OnStage;
import questions.ElMensajeDeError;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static org.hamcrest.Matchers.*;

/**
 * Step Definitions COMUNES compartidos entre múltiples features.
 */
public class CommonSteps {

    @Entonces("debería ver el mensaje {string}")
    public void deberiaVerElMensaje(String mensajeEsperado) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(ElMensajeDeError.mostrado(), equalTo(mensajeEsperado))
        );
    }

    @Entonces("debería ver un mensaje de error")
    public void deberiaVerUnMensajeDeError() {
        OnStage.theActorInTheSpotlight().should(
                seeThat(ElMensajeDeError.mostrado(), is(notNullValue()))
        );
    }

    @Entonces("debería ver el mensaje de error {string}")
    public void deberiaVerElMensajeDeError(String mensajeEsperado) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(ElMensajeDeError.mostrado(), equalTo(mensajeEsperado))
        );
    }
}

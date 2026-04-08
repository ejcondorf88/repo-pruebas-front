package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

/**
 * Hooks de Cucumber para configuración global.
 * Se ejecutan antes y después de cada escenario.
 */
public class Hooks {

    @Before
    public void configurarEscenario() {
        // Configura el "escenario" con actores online
        // Cada escenario tiene sus propios actores aislados
        OnStage.setTheStage(new OnlineCast());
    }

    @After
    public void finalizarEscenario() {
        // Los actores salen del escenario (cierran navegadores, etc.)
        OnStage.drawTheCurtain();
    }
}

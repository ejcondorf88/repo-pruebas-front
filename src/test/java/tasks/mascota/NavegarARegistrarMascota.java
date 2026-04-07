package tasks.mascota;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.WebDriver;

import static targets.MascotaTargets.CAMPO_NOMBRE;

/**
 * Task para navegar a la página de registrar mascota.
 * Usa el WebDriver existente para mantener la sesión.
 */
public class NavegarARegistrarMascota implements Task {

    private static final String URL_REGISTRAR_MASCOTA = "http://localhost/mascotas/nueva";

    public static NavegarARegistrarMascota pagina() {
        return Tasks.instrumented(NavegarARegistrarMascota.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        // Usar el WebDriver existente del actor para mantener cookies
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        driver.get(URL_REGISTRAR_MASCOTA);
        
        // Esperar a que cargue
        WaitUntil.the(CAMPO_NOMBRE, WebElementStateMatchers.isVisible())
                .forNoMoreThan(60).seconds();
    }
}
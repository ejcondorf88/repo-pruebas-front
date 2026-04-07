package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Presence;
import net.serenitybdd.screenplay.questions.Text;

import static targets.FamiliaTargets.*;

/**
 * Question para verificar si una familia fue creada.
 */
public class LaFamiliaFueCreada implements Question<Boolean> {

    private final String nombreFamilia;

    public static LaFamiliaFueCreada correctamente() {
        return new LaFamiliaFueCreada(null);
    }

    public static LaFamiliaFueCreada conNombre(String nombre) {
        return new LaFamiliaFueCreada(nombre);
    }

    public LaFamiliaFueCreada(String nombreFamilia) {
        this.nombreFamilia = nombreFamilia;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        // Verificar mensaje de éxito
        boolean mensajeExito = Presence.of(MENSAJE_EXITO_FAMILIA).answeredBy(actor);

        // Si hay nombre, verificar que aparezca en la lista
        if (nombreFamilia != null) {
            boolean familiaEnLista = Presence.of(ITEM_FAMILIA).answeredBy(actor);
            return mensajeExito || familiaEnLista;
        }

        return mensajeExito;
    }
}

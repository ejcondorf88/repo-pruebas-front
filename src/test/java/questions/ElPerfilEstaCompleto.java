package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Presence;
import net.serenitybdd.screenplay.questions.Text;

import static targets.PerfilTargets.*;

/**
 * Question para verificar el estado del perfil.
 */
public class ElPerfilEstaCompleto implements Question<Boolean> {

    private final int porcentajeMinimo;

    public static ElPerfilEstaCompleto alCienPorCiento() {
        return new ElPerfilEstaCompleto(100);
    }

    public static ElPerfilEstaCompleto conPorcentaje(int porcentaje) {
        return new ElPerfilEstaCompleto(porcentaje);
    }

    public ElPerfilEstaCompleto(int porcentajeMinimo) {
        this.porcentajeMinimo = porcentajeMinimo;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        // Si es 100%, verificar indicador específico
        if (porcentajeMinimo == 100) {
            return Presence.of(INDICADOR_PERFIL_COMPLETO).answeredBy(actor);
        }

        // Verificar porcentaje en texto
        try {
            String textoPorcentaje = Text.of(TEXTO_PORCENTAJE).answeredBy(actor);
            String numero = textoPorcentaje.replaceAll("[^0-9]", "");
            int porcentajeActual = Integer.parseInt(numero);
            return porcentajeActual >= porcentajeMinimo;
        } catch (Exception e) {
            return false;
        }
    }
}

package runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberSerenityRunner;
import org.junit.runner.RunWith;

/**
 * Runner principal de Cucumber con Serenity.
 * 
 * Este runner:
 * - Busca features en src/test/resources/features
 * - Busca step definitions en el package "stepdefinitions"
 * - Genera reportes automáticamente con Serenity
 * 
 * Ejecutar con: mvn clean verify
 */
@RunWith(CucumberSerenityRunner.class)
@CucumberOptions(
        // Ruta a los archivos .feature
        features = "src/test/resources/features",
        
        // Package donde están los step definitions
        glue = "stepdefinitions",
        
        // Plugins para output
        plugin = {
                "pretty",                    // Output legible en consola
                "html:target/cucumber-report.html",
                "json:target/cucumber-report.json"
        },
        
        // Formato de snippets (métodos generados automáticamente)
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        
        // Solo escenarios con estos tags (descomentar para filtrar)
        // tags = "@login",
        
        // Si true: falla si hay steps sin implementar
        strict = true,
        
        // Monochrome para consolas que no soportan colores
        monochrome = true
)
public class SerenityRunnerTest {
    // Esta clase está vacía intencionalmente
    // La configuración está en las anotaciones
}

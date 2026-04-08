package models;

import java.math.BigDecimal;

/**
 * Factory para crear datos de prueba reutilizables.
 * Centraliza la creación de objetos de dominio para los tests.
 */
public class TestDataFactory {

    // Usuarios predefinidos
    public static Usuario usuarioEstandar() {
        return Usuario.conEmail("usuario@email.com")
                .yPassword("password123")
                .yNombre("Usuario Estándar")
                .build();
    }

    public static Usuario usuarioAdmin() {
        return Usuario.conEmail("admin@email.com")
                .yPassword("admin123")
                .yNombre("Administrador")
                .build();
    }

    public static Usuario usuarioInvalido() {
        return Usuario.conEmail("invalido@email.com")
                .yPassword("wrongpass")
                .yNombre("Inválido")
                .build();
    }

    // Productos predefinidos
    public static Producto productoEjemplo() {
        return Producto.llamado("Laptop Dell XPS")
                .conPrecio(new BigDecimal("1299.99"))
                .enCategoria("Tecnología")
                .conDescripcion("Laptop de alto rendimiento")
                .build();
    }

    public static Producto productoEconomico() {
        return Producto.llamado("Mouse Inalámbrico")
                .conPrecio(new BigDecimal("29.99"))
                .enCategoria("Accesorios")
                .conDescripcion("Mouse ergonómico")
                .build();
    }

    // Constructor privado para evitar instanciación
    private TestDataFactory() {
        throw new UnsupportedOperationException("Clase utilitaria - no instanciar");
    }
}

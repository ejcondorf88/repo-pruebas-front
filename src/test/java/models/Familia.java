package models;

/**
 * Modelo de dominio para Familia.
 * Representa una familia adoptante con patrón Builder.
 */
public class Familia {
    private final String nombre;
    private final String direccion;
    private final String telefono;
    private final String email;
    private final String id;

    private Familia(Builder builder) {
        this.nombre = builder.nombre;
        this.direccion = builder.direccion;
        this.telefono = builder.telefono;
        this.email = builder.email;
        this.id = builder.id;
    }

    // Factory method
    public static Builder llamada(String nombre) {
        return new Builder(nombre);
    }

    // Factory conveniencia
    public static Familia familiaValida() {
        return llamada("Familia Pérez")
                .conDireccion("Calle Principal 123")
                .conTelefono("555-1234")
                .conEmail("familia.perez@email.com")
                .build();
    }

    public static Familia familiaDuplicada() {
        return llamada("Familia Pérez")
                .conDireccion("Otra Dirección 456")
                .conTelefono("555-9999")
                .conEmail("otro@email.com")
                .build();
    }

    public static Familia familiaDatosInvalidos() {
        return llamada("")
                .conDireccion("")
                .conTelefono("invalido")
                .conEmail("no-es-email")
                .build();
    }

    // Getters
    public String getNombre() { return nombre; }
    public String getDireccion() { return direccion; }
    public String getTelefono() { return telefono; }
    public String getEmail() { return email; }
    public String getId() { return id; }

    public boolean tieneDatosCompletos() {
        return nombre != null && !nombre.isEmpty() &&
               direccion != null && !direccion.isEmpty() &&
               telefono != null && !telefono.isEmpty();
    }

    @Override
    public String toString() {
        return "Familia{" +
                "nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }

    // Builder
    public static class Builder {
        private final String nombre;
        private String direccion;
        private String telefono;
        private String email;
        private String id;

        private Builder(String nombre) {
            this.nombre = nombre;
        }

        public Builder conDireccion(String direccion) {
            this.direccion = direccion;
            return this;
        }

        public Builder conTelefono(String telefono) {
            this.telefono = telefono;
            return this;
        }

        public Builder conEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder conId(String id) {
            this.id = id;
            return this;
        }

        public Familia build() {
            return new Familia(this);
        }
    }
}

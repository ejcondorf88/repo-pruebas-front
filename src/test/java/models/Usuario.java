package models;

/**
 * Modelo de dominio para representar un Usuario.
 * Utiliza el patrón Builder para construcción limpia e inmutable.
 */
public class Usuario {
    private final String email;
    private final String password;
    private final String nombre;

    private Usuario(Builder builder) {
        this.email = builder.email;
        this.password = builder.password;
        this.nombre = builder.nombre;
    }

    public static Builder conEmail(String email) {
        return new Builder(email);
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "email='" + email + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }

    public static class Builder {
        private final String email;
        private String password;
        private String nombre;

        private Builder(String email) {
            this.email = email;
        }

        public Builder yPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder yNombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public Usuario build() {
            return new Usuario(this);
        }
    }
}

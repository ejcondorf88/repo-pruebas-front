package models;

/**
 * Modelo de dominio para Usuario.
 * Representa un usuario del sistema con patrón Builder.
 */
public class Usuario {
    private final String email;
    private final String password;
    private final String nombre;
    private final String tipoUsuario; // estandar, admin, bloqueado
    private final String token;

    private Usuario(Builder builder) {
        this.email = builder.email;
        this.password = builder.password;
        this.nombre = builder.nombre;
        this.tipoUsuario = builder.tipoUsuario;
        this.token = builder.token;
    }

    // Factory method principal
    public static Builder conEmail(String email) {
        return new Builder(email);
    }

    // Factory conveniencia para datos de prueba
    public static Usuario usuarioValido() {
        return conEmail("usuario@pettech.com")
                .yPassword("password123")
                .yNombre("Usuario Válido")
                .deTipo("estandar")
                .build();
    }

    public static Usuario usuarioAdmin() {
        return conEmail("admin@pettech.com")
                .yPassword("admin123")
                .yNombre("Administrador")
                .deTipo("admin")
                .build();
    }

    public static Usuario usuarioInvalido() {
        return conEmail("invalido@pettech.com")
                .yPassword("wrongpass")
                .yNombre("Inválido")
                .deTipo("estandar")
                .build();
    }

    public static Usuario usuarioBloqueado() {
        return conEmail("bloqueado@pettech.com")
                .yPassword("password123")
                .yNombre("Usuario Bloqueado")
                .deTipo("bloqueado")
                .build();
    }

    public static Usuario usuarioAdministrador() {
        return conEmail("admin@pettech.com")
                .yPassword("admin123")
                .yNombre("Administrador")
                .deTipo("admin")
                .build();
    }

    // Getters
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public String getNombre() { return nombre; }
    public String getTipoUsuario() { return tipoUsuario; }
    public String getToken() { return token; }

    public boolean esBloqueado() {
        return "bloqueado".equals(tipoUsuario);
    }

    public boolean esAdmin() {
        return "admin".equals(tipoUsuario);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "email='" + email + '\'' +
                ", nombre='" + nombre + '\'' +
                ", tipo='" + tipoUsuario + '\'' +
                '}';
    }

    // Builder
    public static class Builder {
        private final String email;
        private String password;
        private String nombre;
        private String tipoUsuario = "estandar";
        private String token;

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

        public Builder deTipo(String tipoUsuario) {
            this.tipoUsuario = tipoUsuario;
            return this;
        }

        public Builder conToken(String token) {
            this.token = token;
            return this;
        }

        public Usuario build() {
            return new Usuario(this);
        }
    }
}

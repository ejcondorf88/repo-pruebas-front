package models;

import java.time.LocalDate;

/**
 * Modelo de dominio para Perfil de Adoptante.
 * Representa la información personal del adoptante.
 */
public class Perfil {
    private final String nombreCompleto;
    private final LocalDate fechaNacimiento;
    private final String ocupacion;
    private final String biografia;
    private final String tipoVivienda;
    private final boolean tienePatio;
    private final boolean permiteMascotas;
    private final boolean tieneMascotasPrevias;
    private final String tipoMascotasPrevias;
    private final String fotoPerfil;

    private Perfil(Builder builder) {
        this.nombreCompleto = builder.nombreCompleto;
        this.fechaNacimiento = builder.fechaNacimiento;
        this.ocupacion = builder.ocupacion;
        this.biografia = builder.biografia;
        this.tipoVivienda = builder.tipoVivienda;
        this.tienePatio = builder.tienePatio;
        this.permiteMascotas = builder.permiteMascotas;
        this.tieneMascotasPrevias = builder.tieneMascotasPrevias;
        this.tipoMascotasPrevias = builder.tipoMascotasPrevias;
        this.fotoPerfil = builder.fotoPerfil;
    }

    // Factory method
    public static Builder para(String nombreCompleto) {
        return new Builder(nombreCompleto);
    }

    // Factory conveniencia
    public static Perfil perfilCompleto() {
        return para("Carlos Pérez")
                .conFechaNacimiento(LocalDate.of(1990, 5, 15))
                .conOcupacion("Ingeniero de Software")
                .conBiografia("Amante de los animales desde pequeño")
                .conTipoVivienda("Casa con jardín")
                .conPatio(true)
                .permiteMascotas(true)
                .conMascotasPrevias(true)
                .conTipoMascotasPrevias("Perros, gatos")
                .build();
    }

    public static Perfil perfilParcial() {
        return para("María López")
                .conFechaNacimiento(LocalDate.of(1985, 8, 20))
                .conOcupacion("Doctora")
                .build();
    }

    // Getters
    public String getNombreCompleto() { return nombreCompleto; }
    public LocalDate getFechaNacimiento() { return fechaNacimiento; }
    public String getOcupacion() { return ocupacion; }
    public String getBiografia() { return biografia; }
    public String getTipoVivienda() { return tipoVivienda; }
    public boolean isTienePatio() { return tienePatio; }
    public boolean isPermiteMascotas() { return permiteMascotas; }
    public boolean isTieneMascotasPrevias() { return tieneMascotasPrevias; }
    public String getTipoMascotasPrevias() { return tipoMascotasPrevias; }
    public String getFotoPerfil() { return fotoPerfil; }

    /**
     * Calcula el porcentaje de completitud del perfil.
     * @return porcentaje entre 0 y 100
     */
    public int calcularPorcentajeCompletitud() {
        int camposTotales = 9;
        int camposCompletos = 0;

        if (nombreCompleto != null && !nombreCompleto.isEmpty()) camposCompletos++;
        if (fechaNacimiento != null) camposCompletos++;
        if (ocupacion != null && !ocupacion.isEmpty()) camposCompletos++;
        if (biografia != null && !biografia.isEmpty()) camposCompletos++;
        if (tipoVivienda != null && !tipoVivienda.isEmpty()) camposCompletos++;
        if (tienePatio) camposCompletos++; // bool siempre tiene valor
        if (permiteMascotas) camposCompletos++;
        if (tieneMascotasPrevias) camposCompletos++;
        if (tipoMascotasPrevias != null && !tipoMascotasPrevias.isEmpty()) camposCompletos++;

        return (camposCompletos * 100) / camposTotales;
    }

    public boolean estaCompleto() {
        return calcularPorcentajeCompletitud() == 100;
    }

    @Override
    public String toString() {
        return "Perfil{" +
                "nombre='" + nombreCompleto + '\'' +
                ", completitud=" + calcularPorcentajeCompletitud() + "%" +
                '}';
    }

    // Builder
    public static class Builder {
        private final String nombreCompleto;
        private LocalDate fechaNacimiento;
        private String ocupacion;
        private String biografia;
        private String tipoVivienda;
        private boolean tienePatio;
        private boolean permiteMascotas;
        private boolean tieneMascotasPrevias;
        private String tipoMascotasPrevias;
        private String fotoPerfil;

        private Builder(String nombreCompleto) {
            this.nombreCompleto = nombreCompleto;
        }

        public Builder conFechaNacimiento(LocalDate fecha) {
            this.fechaNacimiento = fecha;
            return this;
        }

        public Builder conOcupacion(String ocupacion) {
            this.ocupacion = ocupacion;
            return this;
        }

        public Builder conBiografia(String biografia) {
            this.biografia = biografia;
            return this;
        }

        public Builder conTipoVivienda(String tipo) {
            this.tipoVivienda = tipo;
            return this;
        }

        public Builder conPatio(boolean tiene) {
            this.tienePatio = tiene;
            return this;
        }

        public Builder permiteMascotas(boolean permite) {
            this.permiteMascotas = permite;
            return this;
        }

        public Builder conMascotasPrevias(boolean tiene) {
            this.tieneMascotasPrevias = tiene;
            return this;
        }

        public Builder conTipoMascotasPrevias(String tipos) {
            this.tipoMascotasPrevias = tipos;
            return this;
        }

        public Builder conFotoPerfil(String ruta) {
            this.fotoPerfil = ruta;
            return this;
        }

        public Perfil build() {
            return new Perfil(this);
        }
    }
}

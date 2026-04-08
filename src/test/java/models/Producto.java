package models;

import java.math.BigDecimal;

/**
 * Modelo de dominio para representar un Producto.
 * Utiliza el patrón Builder para construcción limpia.
 */
public class Producto {
    private final String nombre;
    private final BigDecimal precio;
    private final String categoria;
    private final String descripcion;

    private Producto(Builder builder) {
        this.nombre = builder.nombre;
        this.precio = builder.precio;
        this.categoria = builder.categoria;
        this.descripcion = builder.descripcion;
    }

    public static Builder llamado(String nombre) {
        return new Builder(nombre);
    }

    public String getNombre() {
        return nombre;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", categoria='" + categoria + '\'' +
                '}';
    }

    public static class Builder {
        private final String nombre;
        private BigDecimal precio;
        private String categoria;
        private String descripcion;

        private Builder(String nombre) {
            this.nombre = nombre;
        }

        public Builder conPrecio(BigDecimal precio) {
            this.precio = precio;
            return this;
        }

        public Builder enCategoria(String categoria) {
            this.categoria = categoria;
            return this;
        }

        public Builder conDescripcion(String descripcion) {
            this.descripcion = descripcion;
            return this;
        }

        public Producto build() {
            return new Producto(this);
        }
    }
}

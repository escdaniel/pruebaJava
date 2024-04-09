package Entity;

import java.util.Date;

public class Contratacion {
    public int id;
    public String fecha_aplicacion;
    public String estado;
    public Float salario;

    public Contratacion(String fecha_aplicacion, String estado, Float salario) {
        this.fecha_aplicacion = fecha_aplicacion;
        this.estado = estado;
        this.salario = salario;
    }

    public Contratacion() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public java.sql.Date getFecha_aplicacion() {
        return java.sql.Date.valueOf(fecha_aplicacion);
    }

    public void setFecha_aplicacion(Date fecha_aplicacion) {
        this.fecha_aplicacion = String.valueOf(fecha_aplicacion);
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Float getSalario() {
        return salario;
    }

    public void setSalario(Float salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Contratacion{" +
                "id=" + id +
                ", fecha_aplicacion=" + fecha_aplicacion +
                ", estado='" + estado + '\'' +
                ", salario=" + salario +
                '}';
    }
}

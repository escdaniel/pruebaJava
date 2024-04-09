package Entity;
public class Codedr {
    public int id;
    public String nombre;
    public String apellidos;
    public String documento;
    public String cv;

    public Codedr( String nombre, String apellidos, String documento, String cv) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.documento = documento;
        this.cv = cv;
    }

    public Codedr() {

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    @Override
    public String toString() {
        return "Codedr{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", documento='" + documento + '\'' +
                ", cv='" + cv + '\'' +
                '}';
    }
}
public class Juguete{
    private String nombre;

    public Juguete(String nombre){
        this.nombre=nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String toString(){
        return "Nombre: "+this.nombre;
    }
}
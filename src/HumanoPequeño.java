public class HumanoPequeño {
    private String id;
    private String nombre;
    private int edad;
    private ListaJuguetes juguetes;

    public HumanoPequeño(String id, String nombre, int edad){
        juguetes = new ListaJuguetes(5);
        this.id=id;
        this.nombre=nombre;
        this.edad=edad;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public ListaJuguetes getJuguetes() {
        return juguetes;
    }

    public void setJuguetes(ListaJuguetes juguetes) {
        this.juguetes = juguetes;
    }
    
    @Override
    public String toString(){
        return "ID: "+this.id+", Nombre: "+this.nombre+", Edad: "+this.edad;
    }
}

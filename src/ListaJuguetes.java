public class ListaJuguetes {
    private int cant;
    private int max;
    private Juguete [] juguetes;

    public ListaJuguetes(int max){
        this.max = max;
        cant = 0;
        juguetes = new Juguete[max];
    }

    public boolean agregarJuguete(Juguete j){
        if(cant<max){
            juguetes[cant]=j;
            cant++;
            return true;
        }
        return false;
    }

    public void vaciar(){
        juguetes = new Juguete[max];
    }

    public boolean eliminarJuguete(String nombre){
        int indice = indexJuguete(nombre);
        if (indice==-1){
            return false;
        }
        else{
            for (int i = indice; i < cant-1; i++) {
                juguetes[i]=juguetes[i+1];
            }
            cant--;
            return true;
        }
    }

    public Juguete buscarJuguete(String name){
        for (int i = 0; i < cant; i++) {
            if (juguetes[i].getNombre().equals(name)){
                return juguetes[i];
            }
        }
        return null;
    }


    public int indexJuguete(String nombre){
        for (int i = 0; i < cant; i++) {
            if (juguetes[i]!=null){
                if (juguetes[i].getNombre().equals(nombre)){
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public String toString(){
        String text = "";
        for (int i = 0; i < cant; i++) {
            text+=juguetes[i].toString()+"\n";
        }
        return text;
    }
}

public class ListaHumanosPequeños {
    private int cant;
    private int max;
    private HumanoPequeño [] lista;

    public ListaHumanosPequeños(int max){
        this.max = max;
        cant = 0;
        lista = new HumanoPequeño[max];
    }

    public boolean agregarHumanoPequeño(HumanoPequeño j){
        if(cant<max){
            lista[cant]=j;
            cant++;
            return true;
        }
        return false;
    }

    public HumanoPequeño buscarHumanoPequeño(String id){
        for (int i = 0; i < cant; i++) {
            if (lista[i].getId().equals(id)){
                return lista[i];
            }
        }
        return null;
    }

    public int getCant(){
        return cant;
    }

    public HumanoPequeño getHumanoPequeñoI(int i){
        return lista[i];
    }

    @Override
    public String toString(){
        String text = "";
        for (int i = 0; i < cant; i++) {
            text+= lista[i].toString()+"\n";
        }
        return text;
    }
}

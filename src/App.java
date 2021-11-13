import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main (String[] args) throws IOException{
        
        ListaHumanosPequeños lhp = new ListaHumanosPequeños(100);
        ListaJuguetes lj = new ListaJuguetes(100);

        Lectura(lhp,lj);

        desplegarHumanoPequeño(lhp);
        
        eliminacionJuguete(lhp,lj);

        vaciarJuguetes(lhp);
    }

    private static void vaciarJuguetes(ListaHumanosPequeños lhp) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Humanos pequeños: ");
        System.out.println(lhp.toString());
        System.out.println("Ingresa el ID del pequeño humano al que lo buscan sus padres: ");
        String id = scan.nextLine();
        HumanoPequeño humano = lhp.buscarHumanoPequeño(id);
        while (humano==null){
            System.out.println("Ingresa correctamente el ID del pequeño humano al que lo buscan sus padres: ");
            id = scan.nextLine();
            humano = lhp.buscarHumanoPequeño(id);
        }
        humano.getJuguetes().vaciar();
        System.out.println("Juguetes de "+id+" vaciados.");
        System.out.println("Humanos pequeños: ");
        System.out.println(lhp.toString());
        System.out.println("Ingresa el ID del pequeño humano al que le quitaras un juguete: ");
        id = scan.nextLine();
        HumanoPequeño humano2 = lhp.buscarHumanoPequeño(id);
        while (humano2==null){
            System.out.println("Ingresa correctamente el ID del pequeño humano al que le quitaras un juguete: ");
            id = scan.nextLine();
            humano2 = lhp.buscarHumanoPequeño(id);
        }
        System.out.println(humano2.getJuguetes().toString());
        System.out.println("Escoge un juguete a quitar: ");
        String nombre = scan.nextLine();
        Juguete j = humano2.getJuguetes().buscarJuguete(nombre);
        while (j==null){
            System.out.println("Escoge bien un juguete a quitar: ");
            nombre = scan.nextLine();
            j = humano2.getJuguetes().buscarJuguete(nombre);
        }
        if (humano.getJuguetes().agregarJuguete(j)){
            if (humano2.getJuguetes().eliminarJuguete(nombre)){
                System.out.println("Proceso terminado, se le quitó el juguete "+nombre+" a "+humano.getId()+" para darselo a "+humano2.getId());
            }
        }
    }

    private static void eliminacionJuguete(ListaHumanosPequeños lhp, ListaJuguetes lj) {
        System.out.println("Juguetes: ");
        Scanner scan = new Scanner(System.in);
        System.out.println(lj.toString());
        System.out.println("Ingrese un nombre de juguete a eliminar: ");
        String nombre_juguete = scan.nextLine();

        while(!lj.eliminarJuguete(nombre_juguete)){
            System.out.println("Ingrese un nombre correcto de juguete a eliminar: ");
            nombre_juguete = scan.nextLine();
        }
        for (int i = 0; i < lhp.getCant() ; i++){
            HumanoPequeño current = lhp.getHumanoPequeñoI(i);
            if (current.getJuguetes().eliminarJuguete(nombre_juguete)){
                System.out.println(nombre_juguete+" eliminado de la posesión de Humano ID:"+current.getId());
            }
        }
        System.out.println();
        System.out.println("Juguete: "+nombre_juguete+", eliminado de la faz del sistema.");
    }

    private static void desplegarHumanoPequeño(ListaHumanosPequeños lhp) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Humanos Pequeños: ");
        System.out.println(lhp.toString());
        System.out.println("Ingrese un id: ");
        String id = scan.nextLine();
        HumanoPequeño h = lhp.buscarHumanoPequeño(id);
        System.out.println(h.toString());
        System.out.println(h.getJuguetes().toString());
    }

    private static void Lectura(ListaHumanosPequeños lhp, ListaJuguetes lj) throws IOException {
        Scanner scan = new Scanner(new File("humanospequeños.txt"));
        while (scan.hasNextLine()){
            String linea = scan.nextLine();
            String [] partes= linea.split(",");
            String id = partes[0];
            String nombre = partes[1];
            int edad = Integer.parseInt(partes[2]);
            int cant_juguetes = Integer.parseInt(partes[3]);

            HumanoPequeño nuevoPequeño = new HumanoPequeño(id, nombre, edad);
            if (!lhp.agregarHumanoPequeño(nuevoPequeño)){
                break;
            }

            for (int i = 4; i < (cant_juguetes+4) ; i++){
                String nombrejuguete = partes[i];
                Juguete juguete = lj.buscarJuguete(nombrejuguete);
                if (juguete==null){
                    Juguete nuevojuguete = new Juguete(nombrejuguete);
                    lj.agregarJuguete(nuevojuguete);
                    nuevoPequeño.getJuguetes().agregarJuguete(nuevojuguete);
                }
                else{
                    nuevoPequeño.getJuguetes().agregarJuguete(juguete);
                }
            }   
        }
    }
}

//import javax.xml.namespace.QName;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AddressBook {
    private static HashMap<String,String> directorio;
    final private static String fileName = "directorio.txt";
    static Scanner sc = new Scanner(System.in);
    static String newNum = sc.nextLine();
    static Scanner scn = new Scanner(System.in);
    static int selectedOpt = sc.nextInt();

    //======================================= Constructor =======================================
    public AddressBook(HashMap<String, String> directorio) {
        this.directorio = directorio;
    }

    /*
    //======================================= Setters =======================================
    public void setDirectorio(HashMap<String, String> directorio) {
        this.directorio = directorio;
    }

    //======================================= Getters =======================================
    public HashMap<String, String> getDirectorio() {
        return directorio;
    }

     */

    //======================================= Methods =======================================

    public static void load() throws IOException {
        System.out.println("Esta entrando al load");
        FileReader fr =  new FileReader(fileName);
        BufferedReader br = new BufferedReader (fr);
        String currLine;
        while((currLine = br.readLine()) != null){
            System.out.println("La linea que leyo dice: " + currLine);
            String [] rec = currLine.split(",",0);
            if (rec.length == 2){
                directorio.put(rec[0], rec[1]);
            }
        }
    }

    public static void save(){
        try(FileWriter fw = new FileWriter(fileName, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw))
        {
            for (Map.Entry<String, String> entry : directorio.entrySet()) {
                String k = entry.getKey();
                String v = entry.getValue();
                out.println(k + ", " + v + "\r\n");
            }
        } catch (IOException e) {
            //exception handling left as an exercise for the reader
        }

    }

    //======================================= Methods del Menu =======================================
    public static void list() throws IOException {
        if (directorio.isEmpty()){
            try {
                load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Contactos:");
        directorio.forEach((k,v) -> System.out.println("Numero: { " + k + "} , " + "Nombre: { " + v + " }"));
    }

    public static void create() {
        if (directorio.isEmpty()){
            try {
                load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Ingrese el numero telefonico del nuevo contacto: ");

        System.out.println("Ingrese el nombre del nuevo contacto: ");
        String newName = sc.nextLine();
        directorio.put(newNum, newName);
        System.out.println("Se creara el nuevo contacto de " + newName + ", esta de acuerdo?" );
        System.out.println("Eliga 1 para confirmar" );
        selectedOpt = scn.nextInt();
        if(selectedOpt == 1){
            save();
        } else {
            System.out.println("No se guardo el contacto de " + newName);
        }
    }

    public static void delete(){
        if (directorio.isEmpty()){
            try {
                load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Ingrese el numero del contacto que desea borrar: " );
        String delNum = sc.nextLine();
        if(directorio.containsKey(delNum)){
            System.out.printf("Se borro el contacto de %s%n", directorio.get(delNum));
            directorio.remove(delNum);
            save();
        }





    }

}

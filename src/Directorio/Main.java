package Directorio;
import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static HashMap<String,String> directorio = new HashMap<>();
    static String[] menuOpt = {"1. Desplegar Lista de Contactos", "2. Crear Nuevo Contacto", "3. Borrar contacto Existente", "5. Salir"};

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        boolean mVal = true;

        System.out.println("Directorio, por favor selecciona una opcion: ");
        printMenu();
        AddressBook.load();
        int selectedOpt = 0;

        while (selectedOpt != 5) {
            selectedOpt = sc.nextInt();
            switch (selectedOpt){
                case 1:
                    AddressBook.list();
                    break;
                case 2:
                    AddressBook.create();
                    break;
                case 3:
                    AddressBook.delete();
                    break;
                case 5:
                    System.out.println("Fin del programa");
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opcion invalida, selecciona otra opcion");
                    printMenu();
                    break;
            }
        }
    }

    public static void printMenu() {
        for (int i = 0; i <= 3; i++) {
            System.out.println(menuOpt[i]);
        }
    }
}
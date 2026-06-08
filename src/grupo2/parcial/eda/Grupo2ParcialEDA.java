package grupo2.parcial.eda;

import java.util.Scanner;

public class Grupo2ParcialEDA {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        ArbolPalabras arbol = new ArbolPalabras();

        int opcion;
        String texto;

        do {

            System.out.println("\n===== MENU =====");
            System.out.println("1 - Ingresar texto");
            System.out.println("2 - Cantidad de palabras usadas");
            System.out.println("3 - Palabra mas repetida");
            System.out.println("4 - Cantidad de palabras negativas");
            System.out.println("5 - Mostrar palabras");
            System.out.println("0 - Salir");
            System.out.print("Opcion: ");

            opcion = teclado.nextInt();
            teclado.nextLine();
            System.out.println();

            switch (opcion) {

                case 1:

                    System.out.println("Ingrese un texto:");
                    texto = teclado.nextLine();

                    if (texto.trim().isEmpty()) {
                        System.out.println("No ingresó ningún texto.");
                    } else {
                        arbol.limpiar();
                        arbol.ingresarTexto(texto);
                        System.out.println("Texto cargado.");
                    }

                    break;

                case 2:

                    if (arbol.estaVacio()) {
                        System.out.println("Primero debe ingresar un texto.");
                    } else {
                        System.out.println(
                                "Cantidad total de palabras: "
                                + arbol.cantidadPalabrasUsadas());
                    }

                    break;

                case 3:

                    if (arbol.estaVacio()) {
                        System.out.println("Primero debe ingresar un texto.");
                    } else {
                        Palabra mayor = arbol.palabraMasRepetida();

                        if (mayor != null) {
                            System.out.println(
                                "Palabra mas repetida: "
                                + mayor.getTexto()
                                + " (" + mayor.getCantidad() + " veces)");
                        } else {
                            System.out.println("No se encontró una palabra válida.");
                        }
                    }

                    break;

                case 4:

                    if (arbol.estaVacio()) {
                        System.out.println("Primero debe ingresar un texto.");
                    } else {
                        System.out.println(
                            "Cantidad de palabras negativas: "
                            + arbol.contarNegativas());
                    }

                    break;

                case 5:

                    if (arbol.estaVacio()) {
                        System.out.println("Primero debe ingresar un texto.");
                    } else {
                        System.out.println("Palabras almacenadas:");
                        arbol.mostrarPalabras();
                    }

                    break;

                case 0:

                    System.out.println("Fin del programa.");
                    break;

                default:

                    System.out.println("Opcion invalida.");
            }

        } while (opcion != 0);

        teclado.close();
    }
}
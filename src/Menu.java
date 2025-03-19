import java.io.IOException;
import java.util.Scanner;


public class Menu {
    public static boolean vaciar = true;
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        
        Restaurante res = new Restaurante();

        Scanner sc = new Scanner(System.in);
        String opcion;
        vaciar_consola();
        System.out.println("Bienvenido al Gestor del Restaurante");
        do {
            System.out.println("Elija qué quiere manejar:");
            System.out.println("1. Mesas");
            System.out.println("2. Platos");
            System.out.println("3. Pedidos");
            System.out.println("4. Descuentos");
            System.out.println("5. Datos");
            System.out.println("0. Salir");
            System.out.print(">>> ");
            opcion = sc.next();
            vaciar_consola();
            
            switch (opcion) {
                case "1", "mesas", "MESAS" -> {
                    vaciar_consola();
                    System.out.println("¿Qué quiere hacer con las mesas?");
                    System.out.println("1. Registrar Mesa");
                    System.out.println("2. Modificar Mesa");
                    System.out.println("3. Eliminar Mesa");
                    System.out.println("0. Salir");
                    System.out.print(">>> ");
                    opcion = sc.next();
                    vaciar_consola();
                }
                case "2", "platos", "PLATOS" -> {
                    vaciar_consola();
                    System.out.println("¿Qué quiere hacer con los platos?");
                    System.out.println("1. Registrar Plato");
                    System.out.println("2. Modificar Plato");
                    System.out.println("3. Eliminar Plato");
                    System.out.println("0. Salir");
                    System.out.print(">>> ");
                    opcion = sc.next();
                    vaciar_consola();
                }
                case "3", "pedidos", "PEDIDOS" -> {
                    vaciar_consola();
                    System.out.println("¿Qué quiere hacer con las pedidos?");
                    System.out.println("1. Registrar Pedido");
                    System.out.println("2. Modificar Pedido");
                    System.out.println("3. Eliminar Pedido");
                    System.out.println("0. Salir");
                    System.out.print(">>> ");
                    opcion = sc.next();
                    vaciar_consola();
                }
                case "4" -> {
                    //TODO: Todo el funcionamiento de descuentos
                }
                case "5" -> {
                    vaciar_consola();
                    System.out.println("");
                    res.mostrarMesas();
                    System.out.println("");
                    res.mostrarPlatos();
                    System.out.println("");
                    res.mostrarPedidos();
                    System.out.println("");
                }
                case "0" -> {
                    //salir
                }
                default -> {
                    System.out.println("ERR0R: Comando no reconocido");
                }
            }
            
        } while (!opcion.equals("0"));
        sc.close();
    }

    public static void vaciar_consola() {
        String os = System.getProperty("os.name");

        if (vaciar) {
            try {
                if (os.contains("Windows")) {
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                } else {
                    System.out.println("\033[H\033[2J");
                    System.out.flush();
                }
            } catch (IOException | InterruptedException e) {
                vaciar = false;
                System.err.println("ERR0R al vaciar la consola: " + e.getMessage());
            }
        }
    }
}

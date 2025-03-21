import java.io.IOException;
import java.util.Scanner;


public class Menu {
    public static boolean vaciar = true;
    public static Scanner sc = new Scanner(System.in);
    public static Restaurante res = new Restaurante();
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        

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
                    menu_mesas();
                }
                case "2", "platos", "PLATOS" -> {
                    menu_platos();
                }
                case "3", "pedidos", "PEDIDOS" -> {
                    menu_pedidos();
                }
                case "4" -> {
                    //TODO: Todo el funcionamiento de descuentos
                    //Empleados envés de descuentos?
                }
                case "5" -> {
                    res.mostrarTodo();
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

    public static void menu_mesas() {
        String opcion;
        do {
            System.out.println("");
            System.out.println("¿Qué quiere hacer con las mesas?");
            System.out.println("1. Registrar Mesa");
            System.out.println("2. Modificar Mesa");
            System.out.println("3. Eliminar Mesa");
            System.out.println("4. Mostrar Mesas");
            System.out.println("0. Atrás");
            System.out.print(">>> ");
            opcion = sc.next();
            vaciar_consola();
            switch (opcion) {
                case "1", "registrar", "REGISTRAR" -> {
                    res.registrarMesa();
                }
                case "2", "modificar", "MODIFICAR" -> {
                    res.modificarMesa();
                }
                case "3", "eliminar", "ELIMINAR" -> {
                    //res.eliminarMesa();
                }
                case "4", "mostrar", "MOSTRAR" -> {
                    res.mostrarMesas();
                }
                case "0" -> {
                    //salir
                }
                default -> {
                    System.out.println("ERR0R: Comando no reconocido");
                }
            }
        } while (!opcion.equals("0"));
    }

    public static void menu_platos() {
        String opcion;
        do {
            System.out.println("¿Qué quiere hacer con las platos?");
            System.out.println("1. Registrar Plato");
            System.out.println("2. Modificar Plato");
            System.out.println("3. Eliminar Plato");
            System.out.println("4. Mostrar Platos");
            System.out.println("0. Atrás");
            System.out.print(">>> ");
            opcion = sc.next();
            vaciar_consola();
            switch (opcion) {
                case "1", "registrar", "REGISTRAR" -> {
                    res.registrarPlato();
                }
                case "2", "modificar", "MODIFICAR" -> {
                    res.modificarPlato();
                }
                case "3", "eliminar", "ELIMINAR" -> {
                    //res.eliminarPlato();
                }
                case "4", "mostrar", "MOSTRAR" -> {
                    res.mostrarPlatos();
                }
                case "0" -> {
                    //salir
                }
                default -> {
                    System.out.println("ERR0R: Comando no reconocido");
                }
            }
        } while (!opcion.equals("0"));
    }

    public static void menu_pedidos() {
        String opcion;
        do {
            System.out.println("¿Qué quiere hacer con los pedidos?");
            System.out.println("1. Registrar Pedidos");
            System.out.println("2. Modificar Pedidos");
            System.out.println("3. Eliminar Pedidos");
            System.out.println("4. Mostrar Pedidos");
            System.out.println("0. Atrás");
            System.out.print(">>> ");
            opcion = sc.next();
            vaciar_consola();
            switch (opcion) {
                case "1", "registrar", "REGISTRAR" -> {
                    res.registrarPedido();
                }
                case "2", "modificar", "MODIFICAR" -> {
                    //res.modificarPedido();
                }
                case "3", "eliminar", "ELIMINAR" -> {
                    //res.eliminarPedido();
                }
                case "4", "mostrar", "MOSTRAR" -> {
                    res.mostrarPedidos();
                }
                case "0" -> {
                    //salir
                }
                default -> {
                    System.out.println("ERR0R: Comando no reconocido");
                }
            }
        } while (!opcion.equals("0"));
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

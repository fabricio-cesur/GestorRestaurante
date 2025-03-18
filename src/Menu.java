import java.util.Scanner;


public class Menu {
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        
        Restaurante res = new Restaurante();

        Scanner sc = new Scanner(System.in);
        int opcion;

        do { 
            
            System.out.println("\nBienvenido al Gestor del Restaurante");
            System.out.println("Elija lo que quiere hacer:");
            System.out.println("1. Registrar Mesa");
            System.out.println("2. Registrar Plato");
            System.out.println("3. Registrar Pedido");
            System.out.println("4. Modificar Platos");
            System.out.println("5. Modificar Mesas");
            System.out.println("6. Modificar Pedidos");
            System.out.println("7. Cargar Datos");
            System.out.println("8. Guardar Datos");
            System.out.println("9. Mostrar los Datos");
            System.out.println("0. Salir");
            System.out.print(">>> ");
            opcion = sc.nextInt();
            
            switch (opcion) {
                case 1 -> {
                    res.registrarMesa();
                }
                case 2 -> {
                    res.registrarPlato();
                }
                case 3 -> {
                    res.registrarPedido();
                }
                case 4 -> {
                    //res.modificarMesas();
                }
                case 5 -> {
                    //res.modificarPlatos();
                }
                case 6 -> {
                    //res.modificarPedidos();
                }
                case 7 -> {
                    //res.cargarDatos();
                }
                case 8 -> {
                    //res.guardarDatos();
                }
                case 9 -> {
                    res.mostrarMesas();
                    System.out.println("\n");
                    res.mostrarPlatos();
                    System.out.println("\n");
                    res.mostrarPedidos();
                    System.out.println("\n");
                }
                case 0 -> {
                    //salir
                }
                default -> {}
            }
            
        } while (opcion > 0);
        sc.close();
    }
}

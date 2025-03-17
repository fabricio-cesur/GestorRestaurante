import java.util.LinkedList;
import java.util.Scanner;

public class Restaurante {
    Scanner sc = new Scanner(System.in);

    LinkedList<Mesa> lista_mesas = new LinkedList<>();
    LinkedList<Plato> lista_platos = new LinkedList<>();
    
    public void registrarMesa() {
        int numero_mesa;
        int capacidad_mesa;

        do {
            System.out.print("Ingresa el número de mesa: ");
            numero_mesa = sc.nextInt();
        } while (numero_mesa <= 0);
        do { 
            System.out.print("Ingresa la capacidad de la mesa: ");
            capacidad_mesa = sc.nextInt();
        } while (capacidad_mesa <= 0);

        Mesa mesa = new Mesa(numero_mesa, capacidad_mesa);
        lista_mesas.add(mesa);
    }

    public void registrarPlato() {
        String codigo_plato;
        String nombre_plato;
        float precio_plato;

        System.out.print("Ingresa el código del plato: ");
        codigo_plato = sc.nextLine();
        sc.nextLine();
        
        System.out.print("Ingresa el nombre del plato: ");
        nombre_plato = sc.nextLine();
        sc.nextLine();
        
        do { 
            System.out.print("Ingresa el precio del plato: ");
            precio_plato = sc.nextFloat();
        } while (precio_plato <= 0);

        Plato plato = new Plato(codigo_plato, nombre_plato, precio_plato);
        lista_platos.add(plato);
    }
    
    // public void registrarPedido() {
    //     int mesa_pedido;
    //     LinkedList<Plato> platos_pedido = new LinkedList<>();
    //     String estado_plato;
    //     float precio_plato;

    //     System.out.print("Ingresa el código del plato: ");
    //     codigo_plato = sc.nextLine();
    //     sc.nextLine();
        
    //     System.out.print("Ingresa el nombre del plato: ");
    //     nombre_plato = sc.nextLine();
    //     sc.nextLine();
        
    //     do { 
    //         System.out.print("Ingresa el precio del plato: ");
    //         precio_plato = sc.nextFloat();
    //     } while (precio_plato <= 0);

    //     Plato plato = new Plato(codigo_plato, nombre_plato, precio_plato);
    //     lista_platos.add(plato);
    // }

    


}

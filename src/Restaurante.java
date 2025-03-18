import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Restaurante {
    Scanner sc = new Scanner(System.in);

    LinkedList<Mesa> lista_mesas = new LinkedList<>();
    HashMap<String, Plato> lista_platos = new HashMap<>();
    LinkedList<Pedido> lista_pedidos = new LinkedList<>();
    
    public void registrarMesa() {
        int numero_mesa;
        int capacidad_mesa;

        //TODO: Validar que el número de mesa no se repita
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
        double precio_plato = 0.00;

        boolean seguir;

        //TODO: Crear validación para el formato del código del plato (Como que solo tenga 4 carácteres en mayúsculas)
        System.out.print("Ingresa el código del plato: ");
        codigo_plato = sc.nextLine();
        
        System.out.print("Ingresa el nombre del plato: ");
        nombre_plato = sc.nextLine();
        
        do {
            try {
                System.out.print("Ingresa el precio del plato: ");
                precio_plato = sc.nextDouble();
                seguir = true;
            } catch (java.util.InputMismatchException e) {
                System.err.println("ERR0R el precio debe ser decimal");
                sc.nextLine();
                seguir = false;
            }
        } while (!seguir);

        Plato plato = new Plato(codigo_plato, nombre_plato, precio_plato);
        lista_platos.put(codigo_plato, plato);
    }
    
    public void registrarPedido() {
        //TODO: Agregar número ID del pedido
        Mesa mesa_pedido;
        LinkedList<Plato> platos_pedido = new LinkedList<>();

        int numero_mesa_pedido;
        String codigo_plato_pedido;

        //TODO: Validar que el número de la mesa existe
        do {
            System.out.print("Ingresa el número de la mesa: ");
            numero_mesa_pedido = sc.nextInt();
            sc.nextLine();
            mesa_pedido = lista_mesas.get(numero_mesa_pedido);
        } while (numero_mesa_pedido >= 0);

        //TODO: Validar que el código del plato exista y poder pedir todos los platos que se requiera
        do {
            System.out.print("Ingresa el código del plato: ");
            codigo_plato_pedido = sc.nextLine();
            platos_pedido.add(lista_platos.get(codigo_plato_pedido));
            sc.nextLine();
        } while (false);
        
        Pedido pedido = new Pedido(mesa_pedido, platos_pedido);
        lista_pedidos.add(pedido);
    }

    
    public void mostrarMesas() {
        for (Mesa mesa : lista_mesas) {
            System.out.println("Mesa Nº" + mesa.getNumero() + " capacidad: " + mesa.getCapacidad());
        }
    }

    public void mostrarPlatos() {
        for (String cod_plato : lista_platos.keySet()) {
            Plato plato = lista_platos.get(cod_plato);
            System.out.println("Plato " + plato.getCodigo() + ": '" + plato.getNombre() + "' precio: " + plato.getPrecio());
        }
    }

    public void mostrarPedidos() {
        for (Pedido pedido : lista_pedidos) {
            System.out.println("Pedido mesa Nº" + pedido.getNumeroMesa() + " platos: " + pedido.getListaPlatos().get(0).getNombre() + " estado: " + pedido.getEstadoCompletado() + " total: " + pedido.getPrecioTotal());
        }
    }


}

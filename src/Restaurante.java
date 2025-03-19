import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Restaurante {
    Scanner sc = new Scanner(System.in);

    HashMap<Integer, Mesa> lista_mesas = new HashMap<>();
    HashMap<String, Plato> lista_platos = new HashMap<>();
    HashMap<Integer, Pedido> lista_pedidos = new HashMap<>();
    
    public void registrarMesa() {
        int numero_mesa;
        int capacidad_mesa;
        boolean terminar;

        do {
            terminar = true;
            System.out.print("Ingresa el número de mesa: ");
            numero_mesa = sc.nextInt();
            sc.nextLine();
            if (numero_mesa < 0) {
                System.out.println("ERR0R: El número debe ser mayor entero positivo");
                terminar = false;
            } else if (lista_mesas.containsKey(numero_mesa)) {
                System.out.println("ERR0R: Otra mesa ya tiene ese número");
                terminar = false;
            }
        } while (!terminar);
        do {
            System.out.print("Ingresa la capacidad de la mesa: ");
            capacidad_mesa = sc.nextInt();
            sc.nextLine();
        } while (capacidad_mesa <= 0);

        Mesa mesa = new Mesa(numero_mesa, capacidad_mesa);
        lista_mesas.put(numero_mesa, mesa);
    }

    public void registrarPlato() {
        String codigo_plato;
        String nombre_plato;
        double precio_plato = 0.00;

        boolean terminar;

        //TODO: Crear validación para el formato del código del plato (Como que solo tenga 4 carácteres en mayúsculas)
        System.out.print("Ingresa el código del plato: ");
        codigo_plato = sc.nextLine();
        
        System.out.print("Ingresa el nombre del plato: ");
        nombre_plato = sc.nextLine();
        
        do {
            try {
                System.out.print("Ingresa el precio del plato: $");
                precio_plato = sc.nextDouble();
                terminar = true;
                sc.nextLine();
            } catch (java.util.InputMismatchException e) {
                System.err.println("ERR0R el precio debe ser decimal");
                sc.nextLine();
                terminar = false;
            }
        } while (!terminar);

        Plato plato = new Plato(codigo_plato, nombre_plato, precio_plato);
        lista_platos.put(codigo_plato, plato);
    }
    
    public void registrarPedido() {

        boolean terminar;

        int id = lista_pedidos.size() + 1;
        Mesa mesa_pedido = lista_mesas.get(0);
        LinkedList<Plato> platos_pedido = new LinkedList<>();

        int numero_mesa_pedido;
        String codigo_plato_pedido;

        do {
            System.out.print("Ingresa el número de la mesa: ");
            numero_mesa_pedido = sc.nextInt();
            sc.nextLine();

            if (lista_mesas.containsKey(numero_mesa_pedido)) {
                terminar = true;
                mesa_pedido = lista_mesas.get(numero_mesa_pedido);
            } else {
                System.out.println("ERR0R: No se encontró esa mesa");
                terminar = false;
            }
        } while (!terminar);

        terminar = false;
        System.out.println("Introduzca un 0 o SALIR para dejar de introducir platos");
        do {
            System.out.print("Ingresa el código del plato: ");
            codigo_plato_pedido = sc.nextLine();
            switch (codigo_plato_pedido) {
                case "0", "SALIR", "salir" -> { terminar = true; }
                default -> {
                    if (lista_platos.containsKey(codigo_plato_pedido)) {
                        platos_pedido.add(lista_platos.get(codigo_plato_pedido));
                    } else {
                        System.out.println("ERR0R: Plato no encontrado");
                    }
                }
            }
        } while (!terminar);
        
        Pedido pedido = new Pedido(id, mesa_pedido, platos_pedido);
        lista_pedidos.put(id, pedido);
    }


    public void modificarMesa() {
        boolean terminar;
        int numero_mesa;

        int nuevo_numero = 0;
        int nueva_capacidad = 0;

        Mesa mesa_modificada = null;

        do { 
            System.out.print("Número de la mesa a modificar: ");
            numero_mesa = sc.nextInt();
            sc.nextLine();
            if (lista_mesas.containsKey(numero_mesa)) {
                mesa_modificada = lista_mesas.get(numero_mesa);
                System.out.println("Mesa Nº" + mesa_modificada.getNumero() + " con capacidad: " + mesa_modificada.getCapacidad());
                do {
                    System.out.print("Nuevo número: ");
                    nuevo_numero = sc.nextInt();
                    sc.nextLine();
                    if (nuevo_numero <= 0) {
                        System.out.println("ERR0R: El número de la mesa debe ser entero positivo");
                    } else if (lista_mesas.containsKey(nuevo_numero)) {
                        System.out.println("ERR0R: Ese número de mesa ya existe");
                    }
                } while (nuevo_numero <= 0 || lista_mesas.containsKey(nuevo_numero));
                do {
                    System.out.print("Nueva capacidad: ");
                    nueva_capacidad = sc.nextInt();
                    sc.nextLine();
                    if (nueva_capacidad <= 0) {
                        System.out.println("ERR0R: La capacidad de la mesa debe ser entero positivo");
                    }
                } while (nueva_capacidad <= 0);
                terminar = true;
            } else {
                System.out.println("ERR0R: No se encontró la mesa");
                terminar = false;
            }
        } while (!terminar);

        if (mesa_modificada != null) {
            mesa_modificada.setNumero(nuevo_numero);
            mesa_modificada.setCapacidad(nueva_capacidad);
        } else {
            System.out.println("ERR0R: No se pudo establecer la mesa a modificar");
        }
    }

    
    public void mostrarMesas() {
        Mesa mesa;
        for (int numero_mesa : lista_mesas.keySet()) {
            mesa = lista_mesas.get(numero_mesa);
            System.out.println("Mesa Nº" + mesa.getNumero() + " capacidad: " + mesa.getCapacidad() + " personas");
        }
    }

    public void mostrarPlatos() {
        for (String cod_plato : lista_platos.keySet()) {
            Plato plato = lista_platos.get(cod_plato);
            System.out.println("Plato " + plato.getCodigo() + ": '" + plato.getNombre() + "' precio: $" + plato.getPrecio());
        }
    }

    public void mostrarPedidos() {
        Pedido pedido;
        for (int id_pedido : lista_pedidos.keySet()) {
            pedido = lista_pedidos.get(id_pedido);
            System.out.println("Pedido " + pedido.getID() + " para mesa Nº" + pedido.getNumeroMesa());
            System.out.println("Platos: ");
            for (Plato plato : pedido.getListaPlatos()) {
                System.out.println("\t" + plato.getNombre() + " $" + plato.getPrecio());
            }
            System.out.print("Estado: ");
            if (!pedido.getEstadoCompletado()) {
                System.out.println("pendiente");
            } else {
                System.out.println("completado");
            }
            System.out.println("Total: $" + pedido.getPrecioTotal());
            System.out.println();
        }
    }
}

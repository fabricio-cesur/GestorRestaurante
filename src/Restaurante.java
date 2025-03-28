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
        System.out.println("Mesa registrada con éxito!");
    }

    public void registrarPlato() {
        String codigo_plato;
        String nombre_plato;
        double precio_plato = 0.00;

        boolean terminar;

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
        System.out.println("Plato registrado con éxito!");
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
        System.out.println("Pedido registrado con éxito!");
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

    public void modificarPlato() {
        boolean terminar;
        String codigo_plato;

        String nuevo_codigo = "";
        String nuevo_nombre = "";
        double nuevo_precio = 0.0;

        Plato plato_modificado = null;

        do { 
            System.out.print("Código del plato a modificar: ");
            codigo_plato = sc.nextLine();
            if (lista_platos.containsKey(codigo_plato)) {
                plato_modificado = lista_platos.get(codigo_plato);
                do { 
                    System.out.print("Nuevo código: ");
                    nuevo_codigo = sc.nextLine();
                    if (lista_platos.containsKey(nuevo_codigo)) {
                        System.out.println("ERR0R: Otro plato ya tiene este código");
                    }
                } while (lista_platos.containsKey(nuevo_codigo));
                System.out.println("Nuevo nombre: ");
                nuevo_nombre = sc.nextLine();
                do { 
                    System.out.println("Nuevo precio: $");
                    nuevo_precio = sc.nextDouble();
                    if (nuevo_precio <= 0) {
                        System.out.println("ERR0R: El precio debe ser un decimal positivo");
                    }
                } while (nuevo_precio <= 0);
                terminar = true;
            } else {
                System.out.println("ERR0R: No se encontró el plato");
                terminar = false;
            }
        } while (!terminar);

        if (plato_modificado != null) {
            plato_modificado.setCodigo(nuevo_codigo);
            plato_modificado.setNombre(nuevo_nombre);
            plato_modificado.setPrecio(nuevo_precio);
        } else {
            System.out.println("ERR0R: El plato a modificar no se pudo encontrar");
        }
    }
    
    public void modificarPedido() {
        boolean terminar;
        int id;
        String opcion;

        int nuevo_num_mesa = 0;
        Mesa nueva_Mesa = null;
        LinkedList<Plato> platos = null;
        boolean nuevo_completado;
        double nuevo_total;
        
        Pedido pedido_modificado = null; 
        do {
            System.out.print("ID del Pedido a modificar: ");
            id = sc.nextInt();
            sc.nextLine();
            if (lista_pedidos.containsKey(id)) {
                pedido_modificado = lista_pedidos.get(id);
                do { 
                    System.out.print("Número de la nueva mesa: ");
                    nuevo_num_mesa = sc.nextInt();
                    if (!lista_mesas.containsKey(nuevo_num_mesa)) {
                        System.out.println("ERR0R: Esa mesa no existe");
                    }
                } while (!lista_mesas.containsKey(nuevo_num_mesa));
                nueva_Mesa = lista_mesas.get(nuevo_num_mesa);
                platos = pedido_modificado.getListaPlatos();
                do { 
                    System.out.println("Estado del pedido:");
                    System.out.println("1. Completado");
                    System.out.println("2. Pendiente");
                    opcion = sc.nextLine();
                    switch (opcion) {
                        case "1", "Completado" -> {}
                        case "2", "Pendiente" -> {}
                        default -> {}
                    }
                    //TODO: Terminar método de modificarPedido
                } while (false);
                terminar = true;
            } else {
                System.out.println("ERR0R: No se encontró el pedido.");
                terminar = false;
            }
        } while (!terminar);
    }
    
    
    public void mostrarMesas() {
        Mesa mesa;
        System.out.print("Mesas: ");
        if (lista_mesas.isEmpty()) {
            System.out.println("No hay mesas registradas");
        } else {
            System.out.println("");
            for (int numero_mesa : lista_mesas.keySet()) {
                mesa = lista_mesas.get(numero_mesa);
                System.out.println("Mesa Nº" + mesa.getNumero() + " capacidad: " + mesa.getCapacidad() + " personas");
            }
        }
        System.out.println("");
    }

    public void mostrarPlatos() {
        Plato plato;
        System.out.print("Platos: ");
        if (lista_platos.isEmpty()) {
            System.out.println("No hay platos registrados");
        } else {
            System.out.println();
            for (String cod_plato : lista_platos.keySet()) {
                plato = lista_platos.get(cod_plato);
                System.out.println("Plato " + plato.getCodigo() + ": '" + plato.getNombre() + "' precio: $" + plato.getPrecio());
            }
        }
        System.out.println("");
    }

    public void mostrarPedidos() {
        Pedido pedido;
        System.out.print("Pedidos: ");
        if (lista_pedidos.isEmpty()) {
            System.out.println("No hay pedidos registrados");
        } else {
            System.out.println("");
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
        System.out.println("");
    }

    public void mostrarTodo() {
        System.out.println("");
        mostrarMesas();
        mostrarPlatos();
        mostrarPedidos();
    }
}

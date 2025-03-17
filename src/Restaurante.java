import java.util.HashMap;
import java.util.Scanner;

public class Restaurante {
    Scanner sc = new Scanner(System.in);

    HashMap<Integer, Mesa> lista_mesas = new HashMap<>();
    
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
        lista_mesas.put(numero_mesa, mesa);
    }

    public void mostrarMesas() {
        for (int num : lista_mesas.keySet()) {
            mostrarMesa(num);
        }
    }
    public void mostrarMesa(int numero) {
        System.out.print("Mesa Nº" + numero);
        System.out.println("| capacidad: " + lista_mesas.get(numero).capacidad);
    }

}

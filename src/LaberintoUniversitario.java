import java.util.Random;

public class LaberintoUniversitario {

    public static void main(String[] args) {
        int[][] laberinto = generarMatriz(5); // Generar matriz de 5x5

        System.out.println("=== LABERINTO UNIVERSITARIO ===");
        mostrarMatriz(laberinto);

        try {
            System.out.println("\n➡ Números pares mayores a 4: " + contarParesMayoresA4(laberinto));
            System.out.println("➡ Promedio de impares: " + promedioImpares(laberinto));
            System.out.println("➡ Suma por fila:");
            sumarFilas(laberinto);
        } catch (Exception e) {
            System.out.println(" Error al analizar el laberinto.");
        }
    }

  
    public static int[][] generarMatriz(int tamaño) {
        Random random = new Random();
        int[][] matriz = new int[tamaño][tamaño];
        for (int i = 0; i < tamaño; i++) {
            for (int j = 0; j < tamaño; j++) {
                matriz[i][j] = random.nextInt(9) + 1;
            }
        }
        return matriz;
    }

    public static void mostrarMatriz(int[][] matriz) {
        for (int[] fila : matriz) {
            for (int num : fila) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

   
    public static int contarParesMayoresA4(int[][] matriz) {
        int contador = 0;
        for (int[] fila : matriz) {
            for (int num : fila) {
                if (num % 2 == 0 && num > 4) {
                    contador++;
                }
            }
        }
        return contador;
    }


    public static double promedioImpares(int[][] matriz) {
        int suma = 0;
        int cantidad = 0;
        for (int[] fila : matriz) {
            for (int num : fila) {
                if (num % 2 != 0) {
                    suma += num;
                    cantidad++;
                }
            }
        }
        if (cantidad == 0) return 0;
        return (double) suma / cantidad;
    }

    public static void sumarFilas(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            int suma = 0;
            for (int j = 0; j < matriz[i].length; j++) {
                suma += matriz[i][j];
            }
            System.out.println("Fila " + (i + 1) + ": " + suma);
        }
    }
}
package proyecto_final_ingrid_claudia;

/**
 *
 * @author 1234
 */
public class Asientos_Disponibles {

    public static boolean Asientos(boolean condicion) {
        boolean con;
        con = condicion;
        if (condicion == true) {
            con = false;
        } else {
            con = true;
        }

        return con;
    }// booleanos (evaluan la condicon del asiento)

    public String[][] Matriz() {
        String matrizAsientos[][] = new String[7][8];
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 8; j++) {
                switch (i) {
                    case 0:
                        matrizAsientos[i][j] = "G-" + (j + 1);
                        break;
                    case 1:
                        matrizAsientos[i][j] = "F-" + (j + 1);
                        break;
                    case 2:
                        matrizAsientos[i][j] = "E-" + (j + 1);
                        break;
                    case 3:
                        matrizAsientos[i][j] = "D-" + (j + 1);
                        break;
                    case 4:
                        matrizAsientos[i][j] = "C-" + (j + 1);
                        break;
                    case 5:
                        matrizAsientos[i][j] = "B-" + (j + 1);
                        break;
                    case 6:
                        matrizAsientos[i][j] = "A-" + (j + 1);
                        break;
                }// fin del caso
            }// for columnas
        }//for filas

        //System.out.println("Segunda matriz");
        imprimir(matrizAsientos);

        return matrizAsientos;
    }// fin del metodo de la matriz de los asientos

    public String asiento(String matriz[][], int i, int j) {
        String asiento = "";
        for (int k = 0; k < matriz.length; k++) {
            for (int l = 0; l < matriz[i].length; l++) {
                if (i == k && l == j) {
                    asiento += matriz[k][j];
                    return asiento;
                }
            }// for coumnas
        }// for filas

        return asiento;
    }// fin del metodo que retorna el nombre del asiento

    public String QuitarAsiento(String asiento, String asientos) {
        asientos = asientos.replace("\n" + (asiento), "");
        return asientos;

    }// fin del meotodo que quita el asiento

    public void imprimir(String[][] matriz) {
        System.out.println("\033[32m→CARGANDO ASIENTOS←");
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(matriz[i][j] + " ");
            }// for columnas
            System.out.println("");
        }// for filas
    }// fin del metodo

}// fin de la clase

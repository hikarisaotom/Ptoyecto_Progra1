package proyecto_final_ingrid_claudia;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
//import static proyecto_final_prueba.AsientosDisponibles.cont;

public class PanelImagen extends JPanel{
    
    
    
    @Override
    public void paintComponent(Graphics g ){
        Dimension  tamano = getSize();
        ImageIcon  imagen = new ImageIcon(new ImageIcon(getClass().getResource("/Imagenes/Fondo.jpg")).getImage());
        g.drawImage(imagen.getImage(),0,0,tamano.width,tamano.height,null);
    }
    
    public static boolean Asientos(boolean condicion){
       boolean con;
       con = condicion;
        if(condicion == true){
            con = false;
        }else{
            con = true;
        }
        
        return con;
    }// booleanos
    
     public static String [][] Matriz(){
       String matrizAsientos [][] = new String[7][8];
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 8; j++) {
                switch(i){
                        case 0:
                            matrizAsientos[i][j] = "G-"+(j+1);
                            break;
                        case 1:
                            matrizAsientos[i][j] = "F-"+(j+1);
                            break;
                        case 2:
                            matrizAsientos[i][j] = "E-"+(j+1);
                            break;
                        case 3:
                            matrizAsientos[i][j] ="D-"+(j+1);
                            break;
                        case 4:
                            matrizAsientos[i][j] ="C-"+(j+1);
                            break;
                        case 5:
                            matrizAsientos[i][j] ="B-"+(j+1);
                            break;
                        case 6:
                            matrizAsientos[i][j] ="A-"+(j+1);
                            break;
                    }// fin del caso
            }// for columnas
        }//for filas
        
        System.out.println("Segunda matriz");
        imprimir(matrizAsientos);
        
        return matrizAsientos;
    }// fin del metodo dde la segunda matriz (la definitiva)
    
    public static String asiento(String matriz [][], int i, int j){
        String asiento= "";
        for (int k = 0; k < matriz.length; k++) {
            for (int l = 0; l < matriz[i].length; l++) {
               if(i == k && l ==j){
                   asiento += matriz[k][j];
                   return asiento;
               }
            }// for coumnas
        }// for filas
    
        return asiento;
    }// fin del metodo 
    
    public static String QuitarAsiento(String asiento, String asientos){
        asientos = asientos.replace((asiento+" "), "");
        return asientos;
        
    }// fin del meotodo 
    
    
    public static void imprimir(String [][] matriz){
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(matriz[i][j]+ " ");
            }
            System.out.println("");
        }
    }
}// fin de la clase
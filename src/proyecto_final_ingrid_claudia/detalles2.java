package proyecto_final_ingrid_claudia;

import java.util.Timer;
import java.util.TimerTask;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author 1234
 */
public class detalles2 {

    static int contador = 0;

    /*public static void main(String[] args) {
        // para cambiar la imagen (bandera)
       jaja();
    }*/
    public static void CambioImagen2() {
        cartelera2 cartelera = new cartelera2();

        cartelera.setVisible(true);
        int velocidad = 2; // los segundos *para que cambien la imagen
        int velocidad_Mls = velocidad * 1000; //EL timer funciona solo con milisegundos
        Timer timer; // variable de instanciamiento
        TimerTask proceso; // lo que vas hacer, cambiar la imagen

        System.out.println("entre al proceso!");

        proceso = new TimerTask() {
            @Override
            public void run() { // metodo para el proceso
                Icon icono; //variable instanciamiento
                switch (contador) {
                    case 0:
                        contador = 1;
                        icono = new ImageIcon(getClass().getResource("/Imagenes/ana_3.jpg"));
                        cartelera.lblANA.setIcon(icono); // cambiamos la imagen del lbl
                        break;
                    case 1:
                        contador = 2;
                        icono = new ImageIcon(getClass().getResource("/Imagenes/ana_1.jpg"));
                        cartelera.lblANA.setIcon(icono); // cambiamos la imagen del lbl
                        break;
                    case 2:
                        contador = 0;
                        icono = new ImageIcon(getClass().getResource("/Imagenes/ana_2.jpg"));
                        cartelera.lblANA.setIcon(icono); // cambiamos la imagen del lbl
                        break;
                }// fin del caso
            }// fin del metodo que corre las imagenes

        };// fin del proceso

        timer = new Timer();
        timer.scheduleAtFixedRate(proceso, velocidad_Mls, velocidad_Mls);
        /* para que se repita periodicamente , el primero es el proceso que se creo, 
                                                    el segundo cuando se va a inicializar*/

    }
}// fin de la clase

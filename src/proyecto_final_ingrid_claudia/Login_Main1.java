package proyecto_final_ingrid_claudia;

import java.awt.BorderLayout;
import java.util.Random;
import javax.swing.JOptionPane;
//import static proyecto_final_ingrid_claudia.FrameImagen2.Panel_Muestra;

/**
 *
 * @author Claudia Cortes
 */
public class Login_Main1 extends javax.swing.JFrame {

    //static   MENUS_PRINCIPALES IMP = new MENUS_PRINCIPALES(); //Genera conflicto si se llama antes
    static Validaciones_Textos Usuario = new Validaciones_Textos();
    public String NickName = "";
    public int Acceso = 1;
    static int[] Promocion = new int[2];
    static Random ran = new Random();
    boolean Ganador = false;

    public Login_Main1() {
        initComponents();
        cargar();

    }

    public void cargar() {
        System.out.println("/********DATOS DE VALIDACION******/*");
        System.out.println("→Administrador" + Usuario.getUsuario());
        System.out.println("→Contraseña" + Usuario.getContra());
        System.out.println("/************************************/");
        this.setLocationRelativeTo(null);
        this.setSize(400, 300);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        OpUsuario.setVisible(true);
        lblcartel.setVisible(false);
        txtUsuario.setVisible(false);
        txtContra.setVisible(false);
        lblUsuario.setVisible(false);
        lblContra.setVisible(false);
        btningresar.setVisible(false);
        btningresar.setVisible(false);
        btningresar_Normal.setVisible(false);
        jLabel4.setVisible(false);
        btnregresar.setVisible(false);
        Loteria();
    }

    public void Loteria() {
        Promocion[0] = ran.nextInt(10) + 1;
        Promocion[1] = ran.nextInt(10) + 1;
        System.out.println("Numero de la Computadora: " + Promocion[0]);
        System.out.println("Numero del usuario : " + Promocion[1]);
        if (Promocion[0] == Promocion[1]) {
            System.out.println("Gana Descuento");
            Ganador = true;
        }
    }

    public void Ocultar() {
        this.setVisible(false);
        //System.out.println("OCULTAR LOG ");
    }

    public void ingresar() {
        MENUS_PRINCIPALES IMP = new MENUS_PRINCIPALES();
        if (Usuario.getUsuario().equals(txtUsuario.getText()) && Usuario.getContra().equals(txtContra.getText())) {
            System.out.println("\033[32m→Usuario Valido←"); //Flechas ↑↓→←
            Comprar_Ticket COMP = new Comprar_Ticket();
            IMP.opcion(Usuario.getNombre()); //MANDA EL NOMBRE PARA QUE PODAMOS VERLO EN LA PANTALLA.
            COMP.opcion(Usuario.getNombre());//MANDA EL NOMBRE PARA QUE PODAMOS IMPRIMIRLO EN LA FACTURA
            IMP.opcionTipo((String) OpUsuario.getSelectedItem());//MANDA EL TIPO DE USUARIO
            COMP.opcionTipo((String) OpUsuario.getSelectedItem());//MANDA EL TIPO DE USUARIO
            if (Ganador) {
                JOptionPane.showMessageDialog(null, "¡Felicidades, usted gano! se le aplicara un descuento del 30% y si es un usuario frecuente del 45%", "Ganador Loteria", JOptionPane.INFORMATION_MESSAGE);
            }
            COMP.Loteria(Ganador);//Manda la bandera para evaluar si gano un descuento
            IMP.setSize(700, 500); //Carga lo siguiente vista
            IMP.setLocation(300, 100);
            IMP.setVisible(true);
            this.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(null, "Usuario no valido", "Error de autenticación", JOptionPane.WARNING_MESSAGE);
        }
        String categoria1 = (String) OpUsuario.getSelectedItem();
        switch (categoria1) {
            case "Vendedor":
                IMP.btnAnular_Menu.setVisible(true);
                break;
            case "Frecuente":
                IMP.btnAnular_Menu.setVisible(false);
                break;
        }
    }

    public void Visitante() {
        this.setSize(400, 300);
        lblInicio.setVisible(false);

        lblcartel.setVisible(true);
        // System.out.println("Entra Visitante");
        OpUsuario.setVisible(false);
        txtUsuario.setVisible(false);
        txtContra.setVisible(false);
        lblUsuario.setVisible(false);
        lblContra.setVisible(false);
        btningresar.setVisible(false);
        btnregresar.setVisible(true);
        jLabel4.setVisible(false);
        btningresar_Normal.setVisible(true);
    }

    public void Otros() {
        Acceso = 0;
        this.setSize(400, 300);
        jLabel4.setVisible(true);
        OpUsuario.setVisible(false);
        txtUsuario.setVisible(true);
        txtContra.setVisible(true);
        lblUsuario.setVisible(true);
        lblContra.setVisible(true);
        btningresar.setVisible(true);
        btnregresar.setVisible(true);
        lblInicio.setVisible(false);

        /*this.setSize(400, 300);
            System.out.println("Entra Frecuente");
            OpUsuario.setVisible(false);
            txtUsuario.setVisible(true);
            txtContra.setVisible(true);
            lblUsuario.setVisible(true);
            lblContra.setVisible(true);
            btningresar.setVisible(true);
            btnregresar.setVisible(true);
            jLabel4.setVisible(true);*/
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblUsuario = new javax.swing.JLabel();
        txtContra = new javax.swing.JPasswordField();
        lblContra = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        OpUsuario = new javax.swing.JComboBox<>();
        btnregresar = new javax.swing.JButton();
        btningresar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btningresar_Normal = new javax.swing.JButton();
        lblTipo = new javax.swing.JLabel();
        lblInicio = new javax.swing.JLabel();
        lblcartel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        jLabel1.setBackground(new java.awt.Color(0, 204, 204));
        jLabel1.setForeground(new java.awt.Color(0, 153, 153));
        jLabel1.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Inicio de sesión");
        setBackground(new java.awt.Color(0, 153, 153));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFont(new java.awt.Font("Segoe UI Black", 0, 10)); // NOI18N
        setForeground(java.awt.Color.cyan);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 110, 150, 90));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblUsuario.setFont(new java.awt.Font("AR BONNIE", 1, 18)); // NOI18N
        lblUsuario.setText("Usuario");
        jPanel1.add(lblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 80, -1));

        txtContra.setFont(new java.awt.Font("AR BONNIE", 1, 18)); // NOI18N
        jPanel1.add(txtContra, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, 160, 30));

        lblContra.setFont(new java.awt.Font("AR BONNIE", 1, 18)); // NOI18N
        lblContra.setText("Contraseña");
        jPanel1.add(lblContra, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 110, 30));

        txtUsuario.setFont(new java.awt.Font("AR BONNIE", 1, 18)); // NOI18N
        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });
        jPanel1.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 160, 32));

        OpUsuario.setFont(new java.awt.Font("AR BONNIE", 1, 18)); // NOI18N
        OpUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Visitante", "Frecuente", "Vendedor" }));
        OpUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpUsuarioActionPerformed(evt);
            }
        });
        jPanel1.add(OpUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 250, 60));

        btnregresar.setBackground(new java.awt.Color(255, 255, 255));
        btnregresar.setFont(new java.awt.Font("AR BONNIE", 1, 18)); // NOI18N
        btnregresar.setText("Regresar");
        btnregresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregresarActionPerformed(evt);
            }
        });
        jPanel1.add(btnregresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 120, 40));

        btningresar.setBackground(new java.awt.Color(255, 255, 255));
        btningresar.setFont(new java.awt.Font("AR BONNIE", 1, 18)); // NOI18N
        btningresar.setText("Ingresar");
        btningresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btningresarActionPerformed(evt);
            }
        });
        jPanel1.add(btningresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, 130, 40));

        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\Claudia Cortes\\Documents\\NetBeansProjects\\Proyecto_Final_Ingrid_Claudia\\src\\Imagenes\\pic5.gif")); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 120, 100));

        btningresar_Normal.setBackground(new java.awt.Color(255, 255, 255));
        btningresar_Normal.setFont(new java.awt.Font("AR BONNIE", 1, 18)); // NOI18N
        btningresar_Normal.setText("Ingresar");
        btningresar_Normal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btningresar_NormalActionPerformed(evt);
            }
        });
        jPanel1.add(btningresar_Normal, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, 130, 40));

        lblTipo.setFont(new java.awt.Font("AR BONNIE", 1, 14)); // NOI18N
        jPanel1.add(lblTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, 20));

        lblInicio.setFont(new java.awt.Font("AR BONNIE", 1, 24)); // NOI18N
        lblInicio.setText("Seleccione el tipo de usuario.");
        jPanel1.add(lblInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 260, 40));

        lblcartel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/bienvenido1.png"))); // NOI18N
        jPanel1.add(lblcartel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 240, 150));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 270, 280));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondito.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 460, 290));

        getAccessibleContext().setAccessibleName("LOGIN");
        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btningresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btningresarActionPerformed
        /*    System.out.println("Cajas de Texto");
        System.out.println("NOMBRE"+txtUsuario.getText());
        System.out.println("CONTRASEÑA"+txtContra.getText());*/
        ingresar();
    }//GEN-LAST:event_btningresarActionPerformed

    private void OpUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpUsuarioActionPerformed
        String categoria1 = (String) OpUsuario.getSelectedItem();
        //System.out.println("Se ha seleccionado"+categoria1);
        if (categoria1 == "Visitante") {
            lblTipo.setText("Visitante");
            Visitante();
        } else if (categoria1 == "Frecuente") {
            lblTipo.setText("Frecuente");
            Otros();
        } else {
            lblTipo.setText("Vendedor");
            Otros();
        }

    }//GEN-LAST:event_OpUsuarioActionPerformed

    private void btnregresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregresarActionPerformed
        lblTipo.setText("");
        lblInicio.setVisible(true);
        lblInicio.setText("Seleccione el tipo de usuario");
        OpUsuario.setVisible(true);
        btningresar_Normal.setVisible(false);
        this.setSize(400, 300);
        jLabel4.setVisible(false);
        lblcartel.setVisible(false);
        txtUsuario.setVisible(false);
        txtContra.setVisible(false);
        lblUsuario.setVisible(false);
        lblContra.setVisible(false);
        btningresar.setVisible(false);
        btnregresar.setVisible(false);
    }//GEN-LAST:event_btnregresarActionPerformed

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void btningresar_NormalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btningresar_NormalActionPerformed
        NickName = JOptionPane.showInputDialog("Ingrese su Nombre Porfavor");
        if (Ganador) {
            JOptionPane.showMessageDialog(null, "¡Felicidades, usted gano! se le aplicara un descuento del 30%", "Ganador Loteria", JOptionPane.INFORMATION_MESSAGE);

        }
        Usuario.SetNombre(NickName);
        //  System.out.println("El nuevo nombre del usuario es:" + NickName);
        MENUS_PRINCIPALES IMP = new MENUS_PRINCIPALES();
        Comprar_Ticket COMP = new Comprar_Ticket();
        IMP.opcion(NickName);
        COMP.opcion(NickName);
        COMP.Loteria(Ganador);
        String Rol = "Visitante";

        IMP.opcionTipo(Rol);
        IMP.btnAnular_Menu.setVisible(false);

        IMP.setSize(700, 500); //Varible de referencia.
        IMP.setLocation(300, 100);
        IMP.setVisible(true);
        this.setVisible(false);


    }//GEN-LAST:event_btningresar_NormalActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login_Main1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login_Main1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login_Main1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login_Main1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login_Main1().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> OpUsuario;
    private javax.swing.JButton btningresar;
    private javax.swing.JButton btningresar_Normal;
    private javax.swing.JButton btnregresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblContra;
    private javax.swing.JLabel lblInicio;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JLabel lblcartel;
    private javax.swing.JPasswordField txtContra;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}

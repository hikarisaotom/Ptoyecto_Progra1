package proyecto_final_ingrid_claudia;

import java.awt.BorderLayout;
import javax.swing.JOptionPane;
import java.util.Scanner;

/**
 *
 * @author Claudia Cortes
 */
public class MENUS_PRINCIPALES extends javax.swing.JFrame {

    static Scanner Lec = new Scanner(System.in);
    static Validaciones_Textos Usuario = new Validaciones_Textos();
    // static Login_Main1 LOGIN = new  Login_Main1();
    static AsientosDisponibles ASI = new AsientosDisponibles();
    static Comprar_Ticket COMP = new Comprar_Ticket();
    public int boletos = 0;
    static String op = "";
    static String Tip = "";
    static boolean Banderita;
    // static AsientosDisponibles ASI = new AsientosDisponibles();
    // public javax.swing.JButton btnAnular_Menu;

    public MENUS_PRINCIPALES() {
        initComponents();
        cargarPanel();
    }//Fin de la clase principal.

    public void cargarPanel() {
        lblAcceso.setVisible(false);
        btnCambiarContra.setVisible(false);
        txtcontraNueva.setVisible(false);
        ContraNueva.setVisible(false);
        Comprar_Ticket COMP = new Comprar_Ticket();
        Imprimir_Ticket CART = new Imprimir_Ticket();
        CART.setSize(900, 1000);
        CART.setLocation(0, 0);
        panelCartelera.removeAll();
        panelCartelera.add(CART, BorderLayout.CENTER);
        panelCartelera.revalidate();
        panelCartelera.repaint();
        ASI.setSize(900, 1000);
        ASI.setLocation(0, 0);
        PanelAsientos.removeAll();
        PanelAsientos.add(ASI, BorderLayout.CENTER);
        PanelAsientos.revalidate();
        PanelAsientos.repaint();
        COMP.setSize(9000, 1000);
        COMP.setLocation(0, 0);
        PanelComprar.removeAll();
        PanelComprar.add(COMP, BorderLayout.CENTER);
        PanelComprar.revalidate();
        PanelComprar.repaint();
    }

    public void desbloquearVendedor() {
        lblRestringido.setVisible(false);
        lblAcceso.setVisible(true);
        btnCambiarContra.setVisible(true);
        txtcontraNueva.setVisible(true);
        ContraNueva.setVisible(true);
    }

    public void ocultar(boolean opcion) {
        Banderita = opcion;
        //System.out.println("CAMBIO LA VARIABLE");
    }

    public void opcion(String opcion) {
        op = opcion;
        // System.out.println("El nombre que recibo" + op);
        lblnombre_usuario.setText(op);
        Usuario.SetNombre(opcion);
        // System.out.println("NOMBRE CAMBIADO: " + Usuario.getNombre());
    }

    public void opcionTipo(String opcion) {
        Tip = opcion;
        // System.out.println("El Tipo que recibo" + Tip);
        Usuario.SetTipo(Tip);
        if (Tip == "Vendedor") {
            desbloquearVendedor();
        }

        // System.out.println("TIPO CAMBIADO: " + Usuario.getTipo());
    }

    public void Desbloquear() {
        //Validaciones_Textos Usuario = new Validaciones_Textos();
        this.hide();
        boolean Bandera = true;
        do {
            System.out.printf("%s\n%s\n", "ENTRANDO AL MODO SUPERUSUARIO", "DIGITE LA CLAVE MAESTRA");
            String Contra = Lec.next();
            if (Contra.equals(Usuario.getContraMaestra())) {
                System.out.println("\033[32mACCESO PERMITIDO");
                System.out.printf("%s\n%s\n%s\n", "→Ingrese la opcion que desea ", "[1]Eliminar completamente la factura", "[2]Modificar la Factura");
                int opcion = Lec.nextInt();
                if (opcion == 1) {
                    ASI.setSize(900, 1000);
                    ASI.setLocation(0, 0);
                    PanelAsientos.removeAll();
                    PanelAsientos.add(ASI, BorderLayout.CENTER);
                    PanelAsientos.revalidate();
                    PanelAsientos.repaint();
                    COMP.setSize(900, 1000);
                    COMP.setLocation(0, 0);
                    PanelComprar.removeAll();
                    PanelComprar.add(COMP, BorderLayout.CENTER);
                    PanelComprar.revalidate();
                    PanelComprar.repaint();
                    this.show();
                    Bandera = false;
                } else if (opcion == 2) {
                    boolean mostrar = true;
                    Comprar_Ticket X = new Comprar_Ticket();
                    X.MOSTRAR(mostrar);
                    this.show();
                    Bandera = false;
                } else {
                    System.out.println("\033[31m OPCION INVALIDA....REINICIANDO MODO SUPER USUARIO");
                }

            } else {
                System.out.println("\033[31mACCESO DENEGADO");
            }
        } while (Bandera);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        panelCartelera = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        MOSTRARVENTAS = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        PanelComprar = new javax.swing.JPanel();
        PanelAsientos = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        btnCambiarContra = new javax.swing.JToggleButton();
        jLabel4 = new javax.swing.JLabel();
        btnCambiarNombre1 = new javax.swing.JToggleButton();
        txtnuevoNombre = new javax.swing.JTextField();
        ContraNueva = new javax.swing.JLabel();
        txtcontraNueva = new javax.swing.JPasswordField();
        lblAcceso = new javax.swing.JLabel();
        lblRestringido = new javax.swing.JLabel();
        btnSalir = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();
        lblnombre_usuario = new javax.swing.JLabel();
        btnAnular_Menu = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("FRAMEPRINCIPAL"); // NOI18N
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setForeground(new java.awt.Color(0, 204, 204));
        jTabbedPane1.setFont(new java.awt.Font("AR BONNIE", 1, 24)); // NOI18N
        jTabbedPane1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPane1StateChanged(evt);
            }
        });
        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        panelCartelera.setBackground(new java.awt.Color(255, 255, 255));
        panelCartelera.setMaximumSize(new java.awt.Dimension(900, 500));

        javax.swing.GroupLayout panelCarteleraLayout = new javax.swing.GroupLayout(panelCartelera);
        panelCartelera.setLayout(panelCarteleraLayout);
        panelCarteleraLayout.setHorizontalGroup(
            panelCarteleraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1039, Short.MAX_VALUE)
        );
        panelCarteleraLayout.setVerticalGroup(
            panelCarteleraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 417, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Cartelera", panelCartelera);

        jTabbedPane2.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane2.setForeground(new java.awt.Color(0, 204, 204));
        jTabbedPane2.setFont(new java.awt.Font("AR BONNIE", 1, 24)); // NOI18N
        jTabbedPane2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPane2StateChanged(evt);
            }
        });
        jTabbedPane2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane2MouseClicked(evt);
            }
        });
        jTabbedPane2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTabbedPane2KeyPressed(evt);
            }
        });

        PanelComprar.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout PanelComprarLayout = new javax.swing.GroupLayout(PanelComprar);
        PanelComprar.setLayout(PanelComprarLayout);
        PanelComprarLayout.setHorizontalGroup(
            PanelComprarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1034, Short.MAX_VALUE)
        );
        PanelComprarLayout.setVerticalGroup(
            PanelComprarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 375, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("Boletos", PanelComprar);

        PanelAsientos.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout PanelAsientosLayout = new javax.swing.GroupLayout(PanelAsientos);
        PanelAsientos.setLayout(PanelAsientosLayout);
        PanelAsientosLayout.setHorizontalGroup(
            PanelAsientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1034, Short.MAX_VALUE)
        );
        PanelAsientosLayout.setVerticalGroup(
            PanelAsientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 375, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("Asientos", PanelAsientos);

        javax.swing.GroupLayout MOSTRARVENTASLayout = new javax.swing.GroupLayout(MOSTRARVENTAS);
        MOSTRARVENTAS.setLayout(MOSTRARVENTASLayout);
        MOSTRARVENTASLayout.setHorizontalGroup(
            MOSTRARVENTASLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );
        MOSTRARVENTASLayout.setVerticalGroup(
            MOSTRARVENTASLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MOSTRARVENTASLayout.createSequentialGroup()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MOSTRARVENTAS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(MOSTRARVENTAS, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 46, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Boletos", jPanel3);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCambiarContra.setBackground(new java.awt.Color(255, 255, 255));
        btnCambiarContra.setFont(new java.awt.Font("AR BONNIE", 1, 18)); // NOI18N
        btnCambiarContra.setText("Cambiar");
        btnCambiarContra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarContraActionPerformed(evt);
            }
        });
        jPanel4.add(btnCambiarContra, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 174, 136, 35));

        jLabel4.setFont(new java.awt.Font("AR BONNIE", 1, 18)); // NOI18N
        jLabel4.setText("Nuevo Nombre");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 120, 35));

        btnCambiarNombre1.setBackground(new java.awt.Color(255, 255, 255));
        btnCambiarNombre1.setFont(new java.awt.Font("AR BONNIE", 1, 18)); // NOI18N
        btnCambiarNombre1.setText("Cambiar");
        btnCambiarNombre1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarNombre1ActionPerformed(evt);
            }
        });
        jPanel4.add(btnCambiarNombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 80, 136, 35));

        txtnuevoNombre.setFont(new java.awt.Font("AR BONNIE", 1, 18)); // NOI18N
        jPanel4.add(txtnuevoNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, 214, -1));

        ContraNueva.setFont(new java.awt.Font("AR BONNIE", 1, 18)); // NOI18N
        ContraNueva.setText("Nueva Contra");
        jPanel4.add(ContraNueva, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 174, 120, 35));

        txtcontraNueva.setFont(new java.awt.Font("AR BONNIE", 0, 18)); // NOI18N
        jPanel4.add(txtcontraNueva, new org.netbeans.lib.awtextra.AbsoluteConstraints(213, 177, 219, -1));

        lblAcceso.setFont(new java.awt.Font("AR BONNIE", 0, 36)); // NOI18N
        lblAcceso.setForeground(new java.awt.Color(0, 204, 0));
        lblAcceso.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAcceso.setText("Acceso Total");
        jPanel4.add(lblAcceso, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, 530, 110));

        lblRestringido.setFont(new java.awt.Font("AR BONNIE", 0, 36)); // NOI18N
        lblRestringido.setForeground(new java.awt.Color(204, 0, 0));
        lblRestringido.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRestringido.setText("Permisos Restringidos");
        jPanel4.add(lblRestringido, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 530, 110));

        btnSalir.setBackground(new java.awt.Color(255, 255, 255));
        btnSalir.setFont(new java.awt.Font("AR BONNIE", 0, 18)); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel4.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 90, 30));

        jTabbedPane1.addTab("Configuraciones", jPanel4);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, -1, 460));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("AR BONNIE", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Bienvenido/a:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 250, 40));
        jLabel1.getAccessibleContext().setAccessibleName("Bienvenido/A: ");

        lblnombre_usuario.setFont(new java.awt.Font("AR BONNIE", 1, 48)); // NOI18N
        lblnombre_usuario.setForeground(new java.awt.Color(255, 255, 255));
        lblnombre_usuario.setToolTipText("");
        getContentPane().add(lblnombre_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 233, 39));

        btnAnular_Menu.setBackground(new java.awt.Color(255, 255, 255));
        btnAnular_Menu.setFont(new java.awt.Font("AR DARLING", 1, 24)); // NOI18N
        btnAnular_Menu.setText("</Root>");
        btnAnular_Menu.setActionCommand("btnAnular_Menu");
        btnAnular_Menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnular_MenuActionPerformed(evt);
            }
        });
        getContentPane().add(btnAnular_Menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(532, 2, -1, -1));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 930, 440));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondito.png"))); // NOI18N
        jLabel3.setText("jLabel3");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 710, 420));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        /*
        ASI.setSize(900, 1000);
        ASI.setLocation(0, 0);
        PanelAsientos.removeAll();
        PanelAsientos.add(ASI, BorderLayout.CENTER);
        PanelAsientos.revalidate();
        PanelAsientos.repaint();
       Comprar_Ticket COMP = new Comprar_Ticket();
        COMP.setSize(900, 1000);
        COMP.setLocation(0, 0);
        PanelComprar.removeAll();
        PanelComprar.add(COMP, BorderLayout.CENTER);
        PanelComprar.revalidate();
        PanelComprar.repaint();
         */
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void jTabbedPane2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane2MouseClicked
        /* Comprar_Ticket Men =new Comprar_Ticket();
    /*  AsientosDisponibles Asientos = new AsientosDisponibles();
      int Personas=Integer.parseInt(Men.txtPersona.getText());
        System.out.println("LE DI CLICK A ASIENTOS");
        System.out.println("LO QUE ENVIO"+Personas);
     Asientos.opcion(Personas);
        System.out.println("EL VALO DE LA CAJA DE TEXTO"+Integer.parseInt(Men.txtPersona.getText()));*/
    }//GEN-LAST:event_jTabbedPane2MouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

    }//GEN-LAST:event_formWindowOpened

    private void btnAnular_MenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnular_MenuActionPerformed

        int Respuesta = JOptionPane.showConfirmDialog(null, "Desea anular la transaccion");
        if (Respuesta == 0) {
            //this.setVisible(false);
            this.hide();
            System.out.println("\033[32mOCULTANDO");//El codigo extraño del inicio le pone color a la impresion,
            Desbloquear();
            Comprar_Ticket COMP = new Comprar_Ticket();
            COMP.OpBoleto.hide();
            //COMP.Descloquear(true);
        }

    }//GEN-LAST:event_btnAnular_MenuActionPerformed

    private void jTabbedPane2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTabbedPane2KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTabbedPane2KeyPressed

    private void jTabbedPane1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane1StateChanged


    }//GEN-LAST:event_jTabbedPane1StateChanged

    private void jTabbedPane2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane2StateChanged
        if (jTabbedPane2.getSelectedIndex() == 1) {
            ASI.setSize(900, 1000);
            ASI.setLocation(0, 0);
            PanelAsientos.removeAll();
            PanelAsientos.add(ASI, BorderLayout.CENTER);
            PanelAsientos.revalidate();
            PanelAsientos.repaint();
        }
    }//GEN-LAST:event_jTabbedPane2StateChanged

    private void btnCambiarContraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarContraActionPerformed

        if (txtcontraNueva.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Ingrese una contraseña", "DATOS NO VALIDOS", JOptionPane.ERROR_MESSAGE);

        } else {
            Usuario.SetMaes(txtcontraNueva.getText());
            txtcontraNueva.setText(null);
        }
    }//GEN-LAST:event_btnCambiarContraActionPerformed

    private void btnCambiarNombre1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarNombre1ActionPerformed
        if (txtnuevoNombre.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Ingrese un Nombre", "DATOS NO VALIDOS", JOptionPane.ERROR_MESSAGE);

        } else {
            //System.out.println("INGRESE UN VALOR");
            opcion(txtnuevoNombre.getText());
            COMP.opcion(txtnuevoNombre.getText());
            txtnuevoNombre.setText(null);
        }
    }//GEN-LAST:event_btnCambiarNombre1ActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        int Respuesta = JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea salir?");
        if (Respuesta == 0) {
            JOptionPane.showMessageDialog(null, "¡Saliendo del sistema¡\nGracias por Preferirnos", "Ganador Loteria", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("\033[32mSALIENDO DEL SISTEMA");
            System.exit(0);

        }

    }//GEN-LAST:event_btnSalirActionPerformed

    /**
     * @param args the command line arguments
     */
    // public static void main() {
    /* Set the Nimbus look and feel */
    //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
    /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
     */
 /*  try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MENUS_PRINCIPALES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MENUS_PRINCIPALES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MENUS_PRINCIPALES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MENUS_PRINCIPALES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
    // java.awt.EventQueue.invokeLater(new Runnable() {
    // public void run() {
    //   new MENUS_PRINCIPALES().setVisible(true);
    //}
    //});
    //}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ContraNueva;
    private javax.swing.JPanel MOSTRARVENTAS;
    private javax.swing.JPanel PanelAsientos;
    private javax.swing.JPanel PanelComprar;
    public javax.swing.JButton btnAnular_Menu;
    private javax.swing.JToggleButton btnCambiarContra;
    private javax.swing.JToggleButton btnCambiarNombre1;
    private javax.swing.JToggleButton btnSalir;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JLabel lblAcceso;
    private javax.swing.JLabel lblRestringido;
    private javax.swing.JLabel lblnombre_usuario;
    private javax.swing.JPanel panelCartelera;
    private javax.swing.JPasswordField txtcontraNueva;
    private javax.swing.JTextField txtnuevoNombre;
    // End of variables declaration//GEN-END:variables
}
//System.out.println("LO QUE ME ESTA LLEGANDO"+Usuario.getNombre());
//
//  System.out.println("el acceso: "+Acceso);

// Validaciones_Textos Usuario = new Validaciones_Textos();
// String NickName = JOptionPane.showInputDialog("Ingrese su Nombre Porfavor");
// Usuario.SetNombre(NickName);
       // System.out.println("Nuevo Nombre: "+Usuario.getNombre());

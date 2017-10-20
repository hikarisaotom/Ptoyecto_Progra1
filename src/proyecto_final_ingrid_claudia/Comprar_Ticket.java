package proyecto_final_ingrid_claudia;

import java.util.Random;
import javax.swing.JOptionPane;

public class Comprar_Ticket extends javax.swing.JPanel {

    //VARIABLES GLOBALES Y DE TRANSACCION CON LOS DEMAS FRAMES.
    //static int[] Promocion = new int[2];
    static Random ran = new Random();
    /*Arreglos con los valores de los ComboBox*/
    static String[] Peliculas = {"-Seleccione-", "IT", "Anabelle", "Luz de Luna"};
    static String[] Horario = {"-Seleccione-", "8:00 AM", "1:00PM", "9:00PM"};
    static String[] Sala = {"-Seleccione-", "3D", "XD", "2D", "Normal"};
    static String[] Boleto = {"-Seleccione-", "Normal", "VIP"};
    /*Fin d elos arreglos  */
 /*Arreglo de validacion  y alamacenamiento de los datos.*/
    static String[] Factura = new String[4];
    /*Arreglo de Almacenamiento de los valores numericos*/
    static double[] Valores = new double[4];
    /*Variables  Globales  que controlan  los asientos.*/
    static int Personas = 1;
    static int NumeroAsientos = 0;
    static String ListaAsientos = "";
    /*Variables que Controlan los descuentos,acceso a funciones  y el nombre */
    static String Nombreusser = "";
    static String Tip = "";
    /*Variables Bandera que permiten los accesos  */
    static boolean Acceso = false;
    static boolean Ganador = false;
    /* */
 /*Variables de referencia para los demas constructores*/
    static Validaciones_Textos Validaciones = new Validaciones_Textos();
    Transaaciones Tran = new Transaaciones();//Llamado de la clase.

    public Comprar_Ticket() {
        initComponents();
        Llenar(Peliculas.length - 1, Sala.length - 1, Boleto.length - 1);
        Llenar();
        //btnAnularFactura.setVisible(false);
    }

    public void Loteria(boolean gano) {
        Ganador = gano;
    }

    public void Descloquear() {
        btnimprimir.setVisible(true);
        OpPelis.enable();
        Ophorario.enable();
        Opsala.enable();
        OpBoleto.enable();
        txtPersona.enable();
        btnAnularFactura.setVisible(false);

    }

    public void MOSTRAR(boolean Banderita) {
        Acceso = Banderita;
        // System.out.println("SE VOLVIO TRUE");
        Descloquear();
    }

    /*METODOS SOBRECARGADOS DE VALIDACION*/
//Validacion de Combobox
    public boolean Validacion(String[] Arreglito) {
        boolean banderita = false;
        Factura[0] = (String) OpPelis.getSelectedItem();
        Factura[1] = (String) OpBoleto.getSelectedItem();
        Factura[2] = (String) Ophorario.getSelectedItem();
        Factura[3] = (String) Opsala.getSelectedItem();

        for (int i = 0; i < Factura.length; i++) {
           // System.out.println(Factura[i]);
            if (Factura[i] == "-Seleccione-") {
                banderita = true;
                break;
            }

        }
        return banderita;
    }

//Validacion de asientos
    public boolean Validacion() {
        boolean banderita = false;
        AsientosDisponibles ASIENTO = new AsientosDisponibles();
        //System.out.println("PERSONAS EN EL MAIN" + Personas);
        NumeroAsientos = ASIENTO.opcion(Personas);
        //System.out.println("EL CONTADOR DE LOS ASIENTOS FUE" + NumeroAsientos);
        if (NumeroAsientos < Personas) {
            ListaAsientos = ASIENTO.getAsientos();
            banderita = true;
        }

        /*  if (Personas<NumeroAsientos) {
                                  JOptionPane.showMessageDialog(null, "Se ha producido un error, Asientos Marcados mayores  a los de la factura\n Se asignara el numero mayor a la factura\npara Solucionar desmarque los asientos sobrantes", "DATOS NO VALIDOS", JOptionPane.ERROR_MESSAGE);
                                  System.out.println("ERROR");
                                   banderita=true;
                                  txtPersona.setText(""+NumeroAsientos);
            }*/
        return banderita;
    }

    //Valida la caja de texto
    public char Validacion(int Letra) {
        char Resp = 'n';
        //Se pone 8 por que el cogido ascii  backspage y el 127 es Delete
        if ((Letra <= 47 | Letra >= 58) && Letra != 8 && Letra != 127) {
            Resp = 's';
        }
        return Resp;
    }

    //Metodo Sobrecargado Recursivo que llena los ComboBox
    public void Llenar(int x, int y, int z) {
        if (x >= 0 || y >= 0 || z >= 0) {
            if (x >= 0) {
                Llenar(x - 1, y - 1, z - 1);
                OpPelis.addItem(Peliculas[x]);
                Ophorario.addItem(Horario[x]);
            }
            if (y >= 0) {
                Opsala.addItem(Sala[y]);

            }
            if (z >= 0) {
                OpBoleto.addItem(Boleto[z]);
            }

        }//Fin del if principal
    }//Fin del metodo Recursivo 

//Metodo Sobrecargado que caga los valores de las labels
    public void Llenar() {
        lblDescuento.setVisible(false);
        btnAnularFactura.setVisible(false);
        txtPersona.setText("1");
        lblBoleto1.setText("LPS.0");
        lblHorario1.setText("LPS.0");
        lblPersonas1.setText("1");
        lblpelicula1.setText("LPS.0");
        lblsala1.setText("LPS.0");
        lblTotal.setText("LPS.0");
    }

    /*FIN DE METODOS SOBRECARGADOS DE VALIDACION*/

 /*Metodos que reciben  datos de otra clase y los vuelve globales en esta*/
    public void opcion(String opcion) {
        Nombreusser = opcion;
    }

    public static void opcionTipo(String opcion) {
        Tip = opcion;
    }

    public int opcion() {
        int personita = Personas;
        return personita;
    }

    /*FIN de los Metodos*/

 /*Metodo que calcula el valor monetario de la factura.*/
    public void TOTAL() {
        if (Tip.equals("Frecuente") || Ganador) {
            if (Tip.equals("Frecuente") && Ganador) { //45 descuento
                lblTotal.setText("LPS. " + Tran.Total(Valores, Personas, 3));
                lblDescuento.setVisible(true);
                lblDescuento.setText("Descuento " + Tran.getPorcentaje() + " rebaja: LPS." + Tran.getDescuento());
            } else if (Tip != "Frecuente" && Ganador) {//Ganador del 30
                lblTotal.setText("LPS. " + Tran.Total(Valores, Personas, 2));
                lblDescuento.setVisible(true);
                lblDescuento.setText("Descuento " + Tran.getPorcentaje() + " rebaja: LPS." + Tran.getDescuento());
            } else {//Descuentousuario frecuente de 15%
                lblTotal.setText("LPS. " + Tran.Total(Valores, Personas, 1));
                lblDescuento.setVisible(true);
                lblDescuento.setText("Descuento " + Tran.getPorcentaje() + " rebaja: LPS." + Tran.getDescuento());
            }//FIN DE LAS DECICIONES DE DESCUENTOS.
        } else {//precio normal de las entradas.
            lblTotal.setText("LPS. " + Tran.Total(Valores, Personas, 0));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        OpPelis = new javax.swing.JComboBox<>();
        Ophorario = new javax.swing.JComboBox<>();
        Opsala = new javax.swing.JComboBox<>();
        OpBoleto = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        lbl_Valorentrada = new javax.swing.JLabel();
        lbl_Valorpeli = new javax.swing.JLabel();
        lbl_Valorsala = new javax.swing.JLabel();
        lbl_ValorBoleto = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblPersonas = new javax.swing.JLabel();
        lblpelicula = new javax.swing.JLabel();
        lblsala = new javax.swing.JLabel();
        lblBoleto = new javax.swing.JLabel();
        lblHorario = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        lblPersonas1 = new javax.swing.JLabel();
        lblpelicula1 = new javax.swing.JLabel();
        lblsala1 = new javax.swing.JLabel();
        lblBoleto1 = new javax.swing.JLabel();
        lblHorario1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnimprimir = new javax.swing.JButton();
        btnAnularFactura = new javax.swing.JButton();
        Subtotales = new javax.swing.JLabel();
        Subtotales1 = new javax.swing.JLabel();
        txtPersona = new javax.swing.JTextField();
        lblDescuento = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 204));
        setToolTipText("");
        addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentRemoved(java.awt.event.ContainerEvent evt) {
                formComponentRemoved(evt);
            }
        });
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                formFocusLost(evt);
            }
        });
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("AR BONNIE", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Pelicula");
        jLabel2.setToolTipText("");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 90, -1));

        jLabel3.setFont(new java.awt.Font("AR BONNIE", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Horario");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 70, -1));

        jLabel4.setFont(new java.awt.Font("AR BONNIE", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Sala");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 60, -1));

        jLabel5.setFont(new java.awt.Font("AR BONNIE", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Boleto");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 60, -1));

        OpPelis.setFont(new java.awt.Font("AR BONNIE", 0, 18)); // NOI18N
        OpPelis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpPelisActionPerformed(evt);
            }
        });
        add(OpPelis, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 150, 40));

        Ophorario.setFont(new java.awt.Font("AR BONNIE", 0, 18)); // NOI18N
        Ophorario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OphorarioActionPerformed(evt);
            }
        });
        add(Ophorario, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, 150, 40));

        Opsala.setFont(new java.awt.Font("AR BONNIE", 0, 18)); // NOI18N
        Opsala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpsalaActionPerformed(evt);
            }
        });
        add(Opsala, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, 150, 40));

        OpBoleto.setFont(new java.awt.Font("AR BONNIE", 0, 18)); // NOI18N
        OpBoleto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpBoletoActionPerformed(evt);
            }
        });
        add(OpBoleto, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, 150, 40));

        jLabel6.setFont(new java.awt.Font("AR BONNIE", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("#Personas");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 130, -1));
        add(lbl_Valorentrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(326, 66, 120, -1));
        add(lbl_Valorpeli, new org.netbeans.lib.awtextra.AbsoluteConstraints(326, 96, -1, -1));
        add(lbl_Valorsala, new org.netbeans.lib.awtextra.AbsoluteConstraints(326, 126, 34, -1));
        add(lbl_ValorBoleto, new org.netbeans.lib.awtextra.AbsoluteConstraints(326, 156, -1, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblPersonas.setFont(new java.awt.Font("AR BONNIE", 1, 18)); // NOI18N
        lblPersonas.setText("Personas");
        jPanel1.add(lblPersonas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        lblpelicula.setFont(new java.awt.Font("AR BONNIE", 1, 18)); // NOI18N
        lblpelicula.setText("Pelicula");
        jPanel1.add(lblpelicula, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        lblsala.setFont(new java.awt.Font("AR BONNIE", 1, 18)); // NOI18N
        lblsala.setText("Sala");
        jPanel1.add(lblsala, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        lblBoleto.setFont(new java.awt.Font("AR BONNIE", 1, 18)); // NOI18N
        lblBoleto.setText("Boleto");
        jPanel1.add(lblBoleto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        lblHorario.setFont(new java.awt.Font("AR BONNIE", 1, 18)); // NOI18N
        lblHorario.setText("Horario");
        jPanel1.add(lblHorario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        lblTotal.setFont(new java.awt.Font("AR BONNIE", 1, 18)); // NOI18N
        lblTotal.setText("Total");
        jPanel1.add(lblTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, 90, -1));

        lblPersonas1.setFont(new java.awt.Font("AR BONNIE", 1, 18)); // NOI18N
        lblPersonas1.setText("Personas");
        jPanel1.add(lblPersonas1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, -1, -1));

        lblpelicula1.setFont(new java.awt.Font("AR BONNIE", 1, 18)); // NOI18N
        lblpelicula1.setText("Pelicula");
        jPanel1.add(lblpelicula1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, -1, -1));

        lblsala1.setFont(new java.awt.Font("AR BONNIE", 1, 18)); // NOI18N
        lblsala1.setText("Sala");
        jPanel1.add(lblsala1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, -1, -1));

        lblBoleto1.setFont(new java.awt.Font("AR BONNIE", 1, 18)); // NOI18N
        lblBoleto1.setText("Boleto");
        jPanel1.add(lblBoleto1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, -1, -1));

        lblHorario1.setFont(new java.awt.Font("AR BONNIE", 1, 18)); // NOI18N
        lblHorario1.setText("Horario");
        jPanel1.add(lblHorario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, -1, -1));

        jLabel7.setFont(new java.awt.Font("AR BONNIE", 1, 18)); // NOI18N
        jLabel7.setText("Total");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 90, -1));

        btnimprimir.setBackground(new java.awt.Color(255, 255, 255));
        btnimprimir.setFont(new java.awt.Font("AR BONNIE", 1, 18)); // NOI18N
        btnimprimir.setText("Imprimir Ticket ");
        btnimprimir.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentRemoved(java.awt.event.ContainerEvent evt) {
                btnimprimirComponentRemoved(evt);
            }
        });
        btnimprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnimprimirActionPerformed(evt);
            }
        });
        jPanel1.add(btnimprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 161, 50));

        btnAnularFactura.setBackground(new java.awt.Color(255, 255, 255));
        btnAnularFactura.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        btnAnularFactura.setText("Eliminar Factura Vieja");
        btnAnularFactura.setActionCommand("Anular Ticket");
        btnAnularFactura.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                btnAnularFacturaFocusLost(evt);
            }
        });
        btnAnularFactura.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                btnAnularFacturaComponentHidden(evt);
            }
        });
        btnAnularFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnularFacturaActionPerformed(evt);
            }
        });
        jPanel1.add(btnAnularFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 160, 50));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 30, 229, 300));

        Subtotales.setFont(new java.awt.Font("AR BONNIE", 1, 18)); // NOI18N
        Subtotales.setForeground(new java.awt.Color(255, 255, 255));
        Subtotales.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Subtotales.setText("Selección.");
        add(Subtotales, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 150, 40));

        Subtotales1.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        Subtotales1.setForeground(new java.awt.Color(255, 255, 255));
        Subtotales1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Subtotales1.setText("Subtotales");
        add(Subtotales1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 0, 170, 40));

        txtPersona.setFont(new java.awt.Font("AR BONNIE", 0, 18)); // NOI18N
        txtPersona.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPersonaFocusLost(evt);
            }
        });
        txtPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPersonaActionPerformed(evt);
            }
        });
        txtPersona.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPersonaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPersonaKeyTyped(evt);
            }
        });
        add(txtPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 150, 30));

        lblDescuento.setBackground(new java.awt.Color(255, 255, 255));
        lblDescuento.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        lblDescuento.setForeground(new java.awt.Color(255, 255, 255));
        add(lblDescuento, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 310, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondito.png"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-80, 0, 850, 420));
    }// </editor-fold>//GEN-END:initComponents

    private void OpPelisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpPelisActionPerformed
        String categoria1 = (String) OpPelis.getSelectedItem();
        Valores[0] = Tran.Precio(categoria1);
        lblpelicula1.setText("Lps." + Tran.Precio(categoria1));
        //  System.out.println(categoria1);
        TOTAL();

    }//GEN-LAST:event_OpPelisActionPerformed

    private void OphorarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OphorarioActionPerformed
        String categoria1 = (String) Ophorario.getSelectedItem();
        Valores[1] = Tran.Horario(categoria1);
        lblHorario1.setText("Lps." + Tran.Horario(categoria1));
        //    System.out.println(categoria1);
        TOTAL();
    }//GEN-LAST:event_OphorarioActionPerformed

    private void OpsalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpsalaActionPerformed
        String categoria1 = (String) Opsala.getSelectedItem();
        Valores[2] = Tran.Sala(categoria1);
        lblsala1.setText("LPS." + Tran.Sala(categoria1));
        // System.out.println(categoria1);
        TOTAL();
    }//GEN-LAST:event_OpsalaActionPerformed

    private void OpBoletoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpBoletoActionPerformed
        String categoria1 = (String) OpBoleto.getSelectedItem();
        Valores[3] = Tran.Boleto(categoria1);
        lblBoleto1.setText("LPS." + Tran.Boleto(categoria1));
        TOTAL();
    }//GEN-LAST:event_OpBoletoActionPerformed

    private void btnimprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnimprimirActionPerformed
        MENUS_PRINCIPALES IMP = new MENUS_PRINCIPALES();
        AsientosDisponibles ASIENTO = new AsientosDisponibles();
        ListaAsientos = ASIENTO.getAsientos();
        //  System.out.println("LOS ASIENTOS SON" + ListaAsientos);
        // IMP.btnAnular_Menu.setVisible(true);
        boolean Bandera = false;
        if (Validacion(Factura) || Validacion()) {
            if (Validacion(Factura)) {
                JOptionPane.showMessageDialog(null, "Valores no validos, por favor revise las entradas", "DATOS NO VALIDOS", JOptionPane.ERROR_MESSAGE);
            }

            if (Validacion()) {
                JOptionPane.showMessageDialog(null, "Asientos de la Factura: " + Personas + " Asientos Marcados: " + NumeroAsientos, "FALTA DE DATOS", JOptionPane.ERROR_MESSAGE);
            }
        } else {

            btnimprimir.setVisible(false);
            if (Tip == "Vendedor") {
                btnAnularFactura.setVisible(true);
                btnAnularFactura.disable();
            }
            //  
            // btnimprimir.setVisible(false);
            //this.setVisible(false);
            //Validaciones_Textos Usuario = new Validaciones_Textos();
            OpPelis.disable();
            Ophorario.disable();
            Opsala.disable();
            OpBoleto.disable();
            txtPersona.disable();
            JOptionPane.showMessageDialog(null, "Factura emitida a :\n" + Nombreusser + "\nCantidad de personas:" + Tran.getPersonas() + "\nSala: " + Tran.getSala() + "\n Horario: " + Tran.getHorario() + "\n Tipo de Boleto: " + Tran.getBoleto() + "\n Pelicula: " + Tran.getPelicula() + "\n El Total es LPS." + Tran.getTotal() + "\nLa lista de los Asientos  es:  \n" + ListaAsientos + "\n¡Gracias por su compra!");
        }
    }//GEN-LAST:event_btnimprimirActionPerformed

    private void txtPersonaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPersonaKeyPressed

    }//GEN-LAST:event_txtPersonaKeyPressed

    private void txtPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPersonaActionPerformed


    }//GEN-LAST:event_txtPersonaActionPerformed

    private void txtPersonaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPersonaFocusLost
        if (txtPersona.getText().length() == 0 || Integer.parseInt(txtPersona.getText()) == 0|| Integer.parseInt(txtPersona.getText()) >56) {
            JOptionPane.showMessageDialog(null, "Se ha producido un error con los datos,Se asignara 1 por defecto", "DATOS NO VALIDOS", JOptionPane.ERROR_MESSAGE);
            txtPersona.setText("1");
        }
        lblPersonas1.setText(txtPersona.getText());
        Personas = Integer.parseInt(txtPersona.getText());

        TOTAL();
        AsientosDisponibles ASIENTO = new AsientosDisponibles();
        //  System.out.println("PERSONAS EN EL MAIN" + Personas);
        NumeroAsientos = ASIENTO.opcion(Personas);
        //System.out.println("EL CONTADOR DE LOS ASIENTOS FUE" + NumeroAsientos);
        if (Personas < NumeroAsientos) {
            JOptionPane.showMessageDialog(null, "Se ha producido un error, Asientos Marcados mayores  a los de la factura\n Se asignara el numero mayor a la factura\npara Solucionar desmarque los asientos sobrantes", "DATOS NO VALIDOS", JOptionPane.ERROR_MESSAGE);
            // System.out.println("ERROR");
            txtPersona.setText("" + NumeroAsientos);
        }


    }//GEN-LAST:event_txtPersonaFocusLost

    private void btnAnularFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnularFacturaActionPerformed
        Descloquear();
        //  System.out.println("Desbloquear");
    }//GEN-LAST:event_btnAnularFacturaActionPerformed

    private void btnimprimirComponentRemoved(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_btnimprimirComponentRemoved
        /* btnimprimir.setVisible(true);
            OpPelis.enable();
            Ophorario.enable();
            Opsala.enable();
            OpBoleto.enable();
            txtPersona.enable();
            System.out.println("Desbloquear");*/
    }//GEN-LAST:event_btnimprimirComponentRemoved

    private void formFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusLost

    }//GEN-LAST:event_formFocusLost

    private void formComponentRemoved(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_formComponentRemoved

    }//GEN-LAST:event_formComponentRemoved

    private void btnAnularFacturaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btnAnularFacturaFocusLost
        // System.out.println("FOCUS LOST");
        if (Tip == "Vendedor") {
            btnAnularFactura.enable();
        }
    }//GEN-LAST:event_btnAnularFacturaFocusLost

    private void btnAnularFacturaComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_btnAnularFacturaComponentHidden
        //  System.out.println("HIDDE");
        if (Tip == "Vendedor") {
            btnAnularFactura.enable();

        }
    }//GEN-LAST:event_btnAnularFacturaComponentHidden

    private void txtPersonaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPersonaKeyTyped
        char Letra = evt.getKeyChar();
        /* Character.isLetter(Letra); SOLO FUNCIONABA CON LETRAS, NO CON CARCATERES ESPECIALES*/
        if (Validacion((int) Letra) == 's') { //Valida que no sean Caracteres especiales
            getToolkit().beep();//Genera el sonido de error.
            evt.consume(); //Evita que se escriba en la caja de texto
            JOptionPane.showMessageDialog(null, "Solamente se aceptan Numeros", "DATOS NO VALIDOS", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_txtPersonaKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JComboBox<String> OpBoleto;
    public javax.swing.JComboBox<String> OpPelis;
    public javax.swing.JComboBox<String> Ophorario;
    public javax.swing.JComboBox<String> Opsala;
    private javax.swing.JLabel Subtotales;
    private javax.swing.JLabel Subtotales1;
    public javax.swing.JButton btnAnularFactura;
    public javax.swing.JButton btnimprimir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    public javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblBoleto;
    private javax.swing.JLabel lblBoleto1;
    private javax.swing.JLabel lblDescuento;
    private javax.swing.JLabel lblHorario;
    private javax.swing.JLabel lblHorario1;
    private javax.swing.JLabel lblPersonas;
    private javax.swing.JLabel lblPersonas1;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lbl_ValorBoleto;
    private javax.swing.JLabel lbl_Valorentrada;
    private javax.swing.JLabel lbl_Valorpeli;
    private javax.swing.JLabel lbl_Valorsala;
    private javax.swing.JLabel lblpelicula;
    private javax.swing.JLabel lblpelicula1;
    private javax.swing.JLabel lblsala;
    private javax.swing.JLabel lblsala1;
    public javax.swing.JTextField txtPersona;
    // End of variables declaration//GEN-END:variables
}

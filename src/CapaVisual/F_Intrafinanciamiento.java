
package CapaVisual;

import java.awt.GraphicsEnvironment;
import javax.swing.JOptionPane;

public class F_Intrafinanciamiento extends javax.swing.JFrame {
    private A_Gestor_Visual objGestorV;

    public F_Intrafinanciamiento(A_Gestor_Visual pobjGestorV) {
        objGestorV=pobjGestorV;
        initComponents();
         GraphicsEnvironment env =GraphicsEnvironment.getLocalGraphicsEnvironment();
        this.setMaximizedBounds(env.getMaximumWindowBounds());
        this.setExtendedState(this.getExtendedState() | this.MAXIMIZED_BOTH);
        
        txtUser.setText(objGestorV.getDatosNombre_UsuarioIU());
        txtNombreContacto.setText(objGestorV.getContactos()[1]);
        txtCedulacontacto.setText(objGestorV.getContactos()[0]);
        txtTarjetaContacto.setText(objGestorV.getContactos()[3]);

        try{
        String[] encabezados ={"Cédula","Nombre","Producto","Tipo","Cierre"};
        tblResumen.setModel(new javax.swing.table.DefaultTableModel(objGestorV.getFormularioPAresumen(objGestorV.getContactos()[0]),encabezados));
        }catch (Exception ex){
            System.out.println("Sin formularios anteriores: "+ex);
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        txtNombreContacto = new javax.swing.JTextField();
        txtCedulacontacto = new javax.swing.JTextField();
        txtTarjetaContacto = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtmonto = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        cmbTipoProducto1 = new javax.swing.JComboBox();
        cmbTipoProducto2 = new javax.swing.JComboBox();
        cmbmonedaFinanc = new javax.swing.JComboBox();
        cmbplazo = new javax.swing.JComboBox();
        txtseguro = new javax.swing.JTextField();
        txtTasa = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        txtcuota = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        txtcomision = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        txtBanco = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        txtSinpe = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        cmbMonedab = new javax.swing.JComboBox();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        txtVencimiento = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblResumen = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("FORMULARIO DE PRODUCTOS ADICIONALES");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setText("Asesor: ");

        jLabel4.setText("Nombre del Contacto: ");

        jLabel5.setText("Cédula del Contacto: ");

        jLabel6.setText("Tarjeta del Contacto: ");

        jLabel13.setText("Producto: ");

        jLabel28.setText("Número de Teléfono: ");

        jLabel30.setForeground(new java.awt.Color(255, 0, 0));
        jLabel30.setText("*");

        jLabel31.setForeground(new java.awt.Color(255, 0, 0));
        jLabel31.setText("*");

        jLabel32.setForeground(new java.awt.Color(255, 0, 0));
        jLabel32.setText("*");

        jLabel33.setForeground(new java.awt.Color(255, 0, 0));
        jLabel33.setText("*");

        jLabel34.setForeground(new java.awt.Color(255, 0, 0));
        jLabel34.setText("*");

        jLabel15.setText("Monto Desembolso: ");

        jLabel35.setForeground(new java.awt.Color(255, 0, 0));
        jLabel35.setText("*");

        cmbTipoProducto1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "INTRA", "EXTRA" }));

        cmbTipoProducto2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "TRADICIONAL", "BALCON" }));

        cmbmonedaFinanc.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "COLONES", "DOLARES" }));

        cmbplazo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "03", "06", "12", "24", "36" }));

        jLabel14.setText("Tipo: ");

        jLabel16.setText("moneda: ");

        jLabel37.setText("Seguro Saldo Deudor: ");

        jLabel38.setText("Tasa de interés: ");

        jLabel39.setText("Cuota: ");

        jLabel42.setText("Comisión por Desembolso");

        jLabel43.setText("Banco Destino:");

        jLabel44.setText("Cuenta Cliente Destino: ");

        cmbMonedab.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "COLONES", "DOLARES" }));

        jLabel45.setText("Moneda Destino: ");

        jLabel46.setForeground(new java.awt.Color(255, 0, 0));
        jLabel46.setText("*");

        jLabel47.setForeground(new java.awt.Color(255, 0, 0));
        jLabel47.setText("*");

        jCheckBox1.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox1.setText("Cuenta Propia");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jCheckBox2.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox2.setText("Cuenta Activa");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });

        jLabel48.setForeground(new java.awt.Color(255, 0, 0));
        jLabel48.setText("*");

        jLabel49.setForeground(new java.awt.Color(255, 0, 0));
        jLabel49.setText("*");

        jLabel17.setText("Plazo: ");

        jButton3.setText("Calcular");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel29.setText("Vencimiento: ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel28)
                    .addComponent(jLabel43)
                    .addComponent(jLabel44)
                    .addComponent(jLabel45)
                    .addComponent(jLabel29))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTelefono)
                    .addComponent(txtCedulacontacto)
                    .addComponent(txtUser)
                    .addComponent(txtNombreContacto, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                    .addComponent(txtTarjetaContacto)
                    .addComponent(txtBanco)
                    .addComponent(txtSinpe)
                    .addComponent(cmbMonedab, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jCheckBox1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel48)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckBox2))
                    .addComponent(txtVencimiento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel32)
                            .addComponent(jLabel31)
                            .addComponent(jLabel33)
                            .addComponent(jLabel30)
                            .addComponent(jLabel34))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(116, 116, 116)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel17)
                                .addGap(9, 9, 9))))
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel39, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel47)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel37))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel46)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel42))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel35)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel38)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTasa, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbTipoProducto1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbTipoProducto2, 0, 220, Short.MAX_VALUE)
                            .addComponent(cmbmonedaFinanc, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbplazo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtmonto))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel49))
                    .addComponent(txtcomision, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtseguro, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jButton3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtcuota, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)))
                .addContainerGap(214, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel30))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombreContacto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel31))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCedulacontacto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel32))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTarjetaContacto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel33))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel28)
                            .addComponent(jLabel34))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtVencimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel29))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtBanco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel43)
                            .addComponent(jLabel46)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(txtmonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel49))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(cmbTipoProducto1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(cmbTipoProducto2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(cmbmonedaFinanc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbplazo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTasa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel38))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtcomision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel42))))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtSinpe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel47)
                        .addComponent(jLabel44))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtseguro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel37)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbMonedab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel45)
                    .addComponent(jLabel39)
                    .addComponent(txtcuota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jCheckBox1)
                    .addComponent(jLabel48)
                    .addComponent(jCheckBox2)
                    .addComponent(jLabel35))
                .addGap(32, 32, 32))
        );

        tblResumen.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Cédula", "Nombre", "Producto", "Cierre"
            }
        ));
        jScrollPane1.setViewportView(tblResumen);

        jLabel1.setText("RESUMEN");

        jButton2.setText("Regresar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("Obligatorio *");

        jButton1.setText("Salvar Formulario");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(82, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1066, Short.MAX_VALUE))
                .addContainerGap(223, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(667, 667, 667)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

String pproducto=cmbTipoProducto1.getSelectedItem().toString();
String ptipo=cmbTipoProducto2.getSelectedItem().toString();
String pcod_usuario= objGestorV.getDatosCod_UsuarioIU();
String  ptarjeta= txtTarjetaContacto.getText();
String  pnombre_contacto= txtNombreContacto.getText();
String  pcedula= txtCedulacontacto.getText();
String  pmonto_d= txtmonto.getText();
String  pmoneda_d=cmbmonedaFinanc.getSelectedItem().toString();
String  pcomision= txtcomision.getText();
String  ptasa= txtTasa.getText();
String  pseguro= txtseguro.getText();
String  psinpe= txtSinpe.getText();
String  ptelefono= txtTelefono.getText();
String  pbanco= txtBanco.getText();
String  pmoneda_banco=cmbMonedab.getSelectedItem().toString();
String  pvencimiento=txtVencimiento.getText();
String  pcuota= txtcuota.getText();
String  pplazo= cmbplazo.getSelectedItem().toString();

        String[] datos = {pproducto, ptipo, pcod_usuario, ptarjeta, pnombre_contacto, pcedula, pmonto_d, pmoneda_d, pcomision, ptasa, pseguro, psinpe, ptelefono, pbanco, pmoneda_banco, pcuota, pplazo};
        try{
            boolean datosLlenos=true;
            for(int i=0;i<datos.length;i++){
                if(datos[i].equals("")||!jCheckBox1.isSelected()||!jCheckBox2.isSelected()){
                    System.out.println("dato vacio: "+i);
                    datosLlenos=false;
                }
            }
            if(datosLlenos){
                if(objGestorV.validaDuplicadosFinanciamiento(ptarjeta,ptipo)){
                        objGestorV.guardaFormularioFinanciamientosV(pproducto, ptipo, pcod_usuario, ptarjeta, pnombre_contacto, pcedula, pmonto_d, pmoneda_d, pcomision, ptasa, pseguro, psinpe, ptelefono, pbanco, pmoneda_banco, pvencimiento, pcuota, pplazo);
                        String[] encabezados ={"PRODUCTO","TIPO","COD_USUARIO","NOMBRE_CONTACTO","MONTO_DESEMBOLSO","MONEDA_DESEMBOLSO","BANCO_DESTINO","PLAZO"};
                        tblResumen.setModel(new javax.swing.table.DefaultTableModel(objGestorV.getResumenFinanciamiento(pcod_usuario, pcedula),encabezados));
                        JOptionPane.showMessageDialog(rootPane, "FORMULARIO SALVADO CON ÉXITO", "SALVAR FORMULARIO", JOptionPane.INFORMATION_MESSAGE); 

                }else{
                    JOptionPane.showMessageDialog(rootPane, "Ya existe este registro", "FORMULARIO DE FINANCIAMIENTOS", JOptionPane.WARNING_MESSAGE);
                }
          
            }else{
                JOptionPane.showMessageDialog(rootPane, "Hay campos obligatorios en blanco", "FORMULARIO DE FINANCIAMIENTOS", JOptionPane.WARNING_MESSAGE);
            }
        }catch (Exception ex){
            System.out.println(ex);
        }
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        objGestorV.btn_Regresar_a_Llamadas(this);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void calculaMontos(){
        try{
        double monto=0,tasa=0,cuota=0,comision=0,seguro=0;
        String producto, tipo, moneda;
        int plazo=-1;
        
        producto=cmbTipoProducto1.getSelectedItem().toString();
        tipo=cmbTipoProducto2.getSelectedItem().toString();
        plazo=cmbplazo.getSelectedIndex();
        moneda=cmbmonedaFinanc.getSelectedItem().toString();
        String simbolo="";
        if(moneda.equals("COLONES")){
            simbolo="₡ ";
        }else{
            simbolo="$ ";
        }
        monto=Double.parseDouble(txtmonto.getText());
        
        seguro=monto*0.00181;
        if(tipo.equals("TRADICIONAL")){
            if(moneda.equals("COLONES")){
                comision=monto*0.03;
            }else{
                comision=monto*0.02;
            }
        }else{
            comision=0;
        }
        
        //tasa depende de tipo moneda
        
        /*TRADICIONAL*/if(tipo.equals("TRADICIONAL")){
            if(moneda.equals("COLONES")){
                switch (plazo){
                    case 0:
                        tasa=0.0275;
                        cuota=-1*DownPMT(tasa, 3.0,monto, 0.0,false);
                        break;
                    case 1:
                        tasa=0.03;
                        cuota=-1*DownPMT(tasa, 6.0,monto, 0.0,false);
                        break;
                    case 2:
                        tasa=0.037;
                        cuota=-1*DownPMT(tasa, 12.0,monto, 0.0,false);
                        break;
                    case 3:
                        tasa=0.037;
                        cuota=-1*DownPMT(tasa, 24.0,monto, 0.0,false);
                        break;
                    case 4:
                        tasa=0.037;
                        cuota=-1*DownPMT(tasa, 36.0,monto, 0.0,false);
                        break;
                }
            }else{
                switch (plazo){
                    case 0:
                        tasa=0.015833333;
                        cuota=-1*DownPMT(tasa, 3.0,monto, 0.0,false);
                        break;
                    case 1:
                        tasa=0.018333333;
                        cuota=-1*DownPMT(tasa, 6.0,monto, 0.0,false);
                        break;
                    case 2:
                        tasa=0.026;
                        cuota=-1*DownPMT(tasa, 12.0,monto, 0.0,false);
                        break;
                    case 3:
                        tasa=0.026;
                        cuota=-1*DownPMT(tasa, 24.0,monto, 0.0,false);
                        break;
                    case 4:
                        tasa=0.026;
                        cuota=-1*DownPMT(tasa, 36.0,monto, 0.0,false);
                        break;
                }
            }
            
        /*BALCON*/}else{
            if(moneda.equals("COLONES")){
                switch (plazo){
                    case 0:
                        tasa=0.016;
                        cuota=-1*DownPMT(tasa, 3.0,monto, 0.0,false);
                        break;
                    case 1:
                        tasa=0.0185;
                        cuota=-1*DownPMT(tasa, 6.0,monto, 0.0,false);
                        break;
                    case 2:
                        tasa=0.021;
                        cuota=-1*DownPMT(tasa, 12.0,monto, 0.0,false);
                        break;
                    case 3:
                        tasa=0.021;
                        cuota=-1*DownPMT(tasa, 24.0,monto, 0.0,false);
                        break;
                    case 4:
                        tasa=0.021;
                        cuota=-1*DownPMT(tasa, 36.0,monto, 0.0,false);
                        break;
                }
            }else{
                switch (plazo){
                    case 0:
                        tasa=0.0075;
                        cuota=-1*DownPMT(tasa, 3.0,monto, 0.0,false);
                        break;
                    case 1:
                        tasa=0.01;
                        cuota=-1*DownPMT(tasa, 6.0,monto, 0.0,false);
                        break;
                    case 2:
                        tasa=0.0125;
                        cuota=-1*DownPMT(tasa, 12.0,monto, 0.0,false);
                        break;
                    case 3:
                        tasa=0.0125;
                        cuota=-1*DownPMT(tasa, 24.0,monto, 0.0,false);
                        break;
                    case 4:
                        tasa=0.0125;
                        cuota=-1*DownPMT(tasa, 36.0,monto, 0.0,false);
                        break;
                }
            }
        }
        
        txtTasa.setText((Math.round((tasa*100)*100.0)/100.0)+"%");
        txtcomision.setText(simbolo+round(comision,2));
        txtseguro.setText(simbolo+round(seguro,2));
        txtcuota.setText(simbolo+round(cuota,2));
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
    
    public double round(double value, int places) {
    if (places < 0) throw new IllegalArgumentException();

    long factor = (long) Math.pow(10, places);
    value = value * factor;
    long tmp = Math.round(value);
    return (double) tmp / factor;
}
    
    public double DownPMT(double r, double n, double p, double f, boolean t) {
        /**
     * Future value of an amount given the number of payments, rate, amount
     * of individual payment, present value and boolean value indicating whether
     * payments are due at the beginning of period
     * (false => payments are due at end of period)
     * @param r rate
     * @param n num of periods
     * @param y pmt per period
     * @param p future value
     * @param t type (true=pmt at end of period, false=pmt at begining of period)
     */
        double retval = 0;
        if (r == 0) {
            retval = -1*(f+p)/n;
        }
        else {
        double r1 = r + 1;
        retval = ( f + p * Math.pow(r1, n) ) * r
                  /
               ((t ? r1 : 1) * (1 - Math.pow(r1, n)));
        }
        return retval;
    }
    
    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        calculaMontos();
    }//GEN-LAST:event_jButton3ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cmbMonedab;
    private javax.swing.JComboBox cmbTipoProducto1;
    private javax.swing.JComboBox cmbTipoProducto2;
    private javax.swing.JComboBox cmbmonedaFinanc;
    private javax.swing.JComboBox cmbplazo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblResumen;
    private javax.swing.JTextField txtBanco;
    private javax.swing.JTextField txtCedulacontacto;
    private javax.swing.JTextField txtNombreContacto;
    private javax.swing.JTextField txtSinpe;
    private javax.swing.JTextField txtTarjetaContacto;
    private javax.swing.JTextField txtTasa;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtUser;
    private javax.swing.JTextField txtVencimiento;
    private javax.swing.JTextField txtcomision;
    private javax.swing.JTextField txtcuota;
    private javax.swing.JTextField txtmonto;
    private javax.swing.JTextField txtseguro;
    // End of variables declaration//GEN-END:variables
}


package CapaVisual;

import java.awt.GraphicsEnvironment;

public class V_QA_CD extends javax.swing.JFrame {

    private A_Gestor_Visual objGestorV;
    private int tipo;

    public V_QA_CD(A_Gestor_Visual pobjGestorV,int pTipo) {
        tipo=pTipo;
        objGestorV=pobjGestorV;
        
        initComponents();
        
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        
        GraphicsEnvironment env =GraphicsEnvironment.getLocalGraphicsEnvironment();
        this.setMaximizedBounds(env.getMaximumWindowBounds());
        this.setExtendedState(this.getExtendedState() | this.MAXIMIZED_BOTH);
        
        llenaFechas();
    try{
        cmbFechasCD.setSelectedIndex(0);
    }catch(Exception ex){
        System.out.println(ex);
    }
        llenaDatosLista();

    }

    private void llenaFechas(){
        
        try{
         if(tipo==1){
         cmbFechasCD.setModel(new javax.swing.DefaultComboBoxModel(objGestorV.getFechasPPT()));
         }
         if(tipo==2){
         cmbFechasCD.setModel(new javax.swing.DefaultComboBoxModel(objGestorV.getFechasCAU()));
         }
         if(tipo==4){
         cmbFechasCD.setModel(new javax.swing.DefaultComboBoxModel(objGestorV.buscaFechasFinanc()));
         }
         
        }catch (Exception ex){
            System.out.println("llenaFechasCD"+ex);
        }
        
    }

    private void llenaDatosLista(){
try{

    String fecha=cmbFechasCD.getSelectedItem().toString();
        if(tipo==1){
            String[] encabezadoA={"COD_CUENTA","TARJETA_CONTACTO","PLAN_TARJETA","CEDULA_CONTACTO","NOMBRE_CONTACTO","PRODUCTO","TIPO_PRODUCTO","NOMBRE_USUARIO","FECHA_VENTA","FECHA_NACIMIENTO","TELEFONO_CONTACTO"};
            String[][] contenidoA;
            contenidoA=objGestorV.traer_Todo_CD_PPT(fecha);
            tblcd.setModel(new javax.swing.table.DefaultTableModel(contenidoA,encabezadoA));
            tblcd.getColumnModel().getColumn(0).setPreferredWidth(200);
            tblcd.getColumnModel().getColumn(1).setPreferredWidth(200);
            tblcd.getColumnModel().getColumn(2).setPreferredWidth(200);
            tblcd.getColumnModel().getColumn(3).setPreferredWidth(200);
            tblcd.getColumnModel().getColumn(4).setPreferredWidth(400);
            tblcd.getColumnModel().getColumn(5).setPreferredWidth(200);
            tblcd.getColumnModel().getColumn(6).setPreferredWidth(200);
            tblcd.getColumnModel().getColumn(7).setPreferredWidth(200);
            tblcd.getColumnModel().getColumn(8).setPreferredWidth(200);
            tblcd.getColumnModel().getColumn(9).setPreferredWidth(200);
            tblcd.getColumnModel().getColumn(10).setPreferredWidth(200);
        }
          if(tipo==2){
            String[] encabezadoB={"NOMBRE_USUARIO","HORA_VENTA","NOMBRE_CONTACTO","CEDULA_CONTACTO","TARJETA_CONTACTO","NOMBRE_SUBSCRICTOR","UBICACION_SERVICIO","CODIGO_SERVICIO","TELEFONO_CONTACTO","TIPO_PRODUCTO"};
            String[][] contenidoB;
            contenidoB=objGestorV.traer_Todo_CD_CAU(fecha);
            tblcd.setModel(new javax.swing.table.DefaultTableModel(contenidoB,encabezadoB));
            tblcd.getColumnModel().getColumn(0).setPreferredWidth(200);
            tblcd.getColumnModel().getColumn(1).setPreferredWidth(200);
            tblcd.getColumnModel().getColumn(2).setPreferredWidth(200);
            tblcd.getColumnModel().getColumn(3).setPreferredWidth(200);
            tblcd.getColumnModel().getColumn(4).setPreferredWidth(200);
            tblcd.getColumnModel().getColumn(5).setPreferredWidth(200);
            tblcd.getColumnModel().getColumn(6).setPreferredWidth(200);
            tblcd.getColumnModel().getColumn(7).setPreferredWidth(200);
            tblcd.getColumnModel().getColumn(8).setPreferredWidth(200);
            tblcd.getColumnModel().getColumn(9).setPreferredWidth(200);
            
          }
            if(tipo==4){
            String[] encabezadoD={"FECHA_VENTA","NOMBRE_USUARIO","USUARIO","TARJETA_CONTACTO","NOMBRE_CONTACTO","CEDULA_CONTACTO","MONTO_DESEMBOLSO","MONEDA_DESEMBOLSO","PLAZO","SIGMA_7","SINPE","BANCO","VENCIMIENTO","TIPO"};
            String[][] contenidoD;
            contenidoD=objGestorV.getCD_E_I(fecha);
            tblcd.setModel(new javax.swing.table.DefaultTableModel(contenidoD,encabezadoD));
            tblcd.getColumnModel().getColumn(0).setPreferredWidth(200);
            tblcd.getColumnModel().getColumn(1).setPreferredWidth(200);
            tblcd.getColumnModel().getColumn(2).setPreferredWidth(200);
            tblcd.getColumnModel().getColumn(3).setPreferredWidth(200);
            tblcd.getColumnModel().getColumn(4).setPreferredWidth(200);
            tblcd.getColumnModel().getColumn(5).setPreferredWidth(200);
            tblcd.getColumnModel().getColumn(6).setPreferredWidth(200);
            tblcd.getColumnModel().getColumn(7).setPreferredWidth(200);
            tblcd.getColumnModel().getColumn(8).setPreferredWidth(200);
            tblcd.getColumnModel().getColumn(9).setPreferredWidth(200);
            tblcd.getColumnModel().getColumn(10).setPreferredWidth(200);
            tblcd.getColumnModel().getColumn(11).setPreferredWidth(200);
            tblcd.getColumnModel().getColumn(12).setPreferredWidth(200);
            tblcd.getColumnModel().getColumn(13).setPreferredWidth(200);
            
          }
            }catch(Exception ex){
                System.out.println("objGestorV.getDatosAuditarPPT:"+ex);
            }
        
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblcd = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        cmbFechasCD = new javax.swing.JComboBox();
        btnBuscarFechaCD = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("información Para enviar en el CD");

        jScrollPane2.setPreferredSize(new java.awt.Dimension(10, 10));

        tblcd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        tblcd.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblcd.setPreferredSize(new java.awt.Dimension(2000, 10000));
        jScrollPane2.setViewportView(tblcd);

        jButton1.setText("Regresar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnBuscarFechaCD.setText("Búsqueda por fecha");
        btnBuscarFechaCD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarFechaCDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(38, 38, 38)
                        .addComponent(cmbFechasCD, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscarFechaCD, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1279, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbFechasCD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarFechaCD))
                .addGap(58, 58, 58)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
                .addComponent(jButton1)
                .addContainerGap(152, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       objGestorV.btn_Regresar_a_MenuQA(this);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnBuscarFechaCDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarFechaCDActionPerformed
        llenaDatosLista();
    }//GEN-LAST:event_btnBuscarFechaCDActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarFechaCD;
    private javax.swing.JComboBox cmbFechasCD;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblcd;
    // End of variables declaration//GEN-END:variables
}

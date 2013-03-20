
package CapaVisual;

import java.awt.GraphicsEnvironment;

public class V_Auditar extends javax.swing.JFrame {
private A_Gestor_Visual objGestorV;
private int tipo;
private String fecha_tabla;

    public V_Auditar(A_Gestor_Visual pobjGestorV,int pTipo) {
        objGestorV=pobjGestorV;
        tipo = pTipo;
        initComponents();
        
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        
        GraphicsEnvironment env =GraphicsEnvironment.getLocalGraphicsEnvironment();
        this.setMaximizedBounds(env.getMaximumWindowBounds());
        this.setExtendedState(this.getExtendedState() | this.MAXIMIZED_BOTH);
        
        llenaDatosLista("");
        llenaFechas();
        
    }

    private void llenaDatosLista(String fecha){
        fecha_tabla=fecha;
            try{
            if(tipo==1){
            String[] encabezadoA={"HORA_VENTA","COD_CUENTA","TARJETA_CONTACTO","PLAN_TARJETA","FECHA_NACIMIENTO","CEDULA_CONTACTO","NOMBRE_CONTACTO","PRODUCTO","TIPO_PRODUCTO","NOMBRE_USUARIO","TELEFONO_CONTACTO","CIERRE","REVISADA_POR","ESTATUS_CONTROL","FECHA_DEVOLUCION_POR_CONTROL","FECHA_ENTREGADO_A_CONTROL"};;
            String[][] contenidoA;
            contenidoA=objGestorV.getDatosAuditarPPT(fecha_tabla);
            tblAuditar.setModel(new javax.swing.table.DefaultTableModel(contenidoA,encabezadoA));
            tblAuditar.getColumnModel().getColumn(0).setPreferredWidth(200);
            tblAuditar.getColumnModel().getColumn(1).setPreferredWidth(200);
            tblAuditar.getColumnModel().getColumn(2).setPreferredWidth(200);
            tblAuditar.getColumnModel().getColumn(3).setPreferredWidth(400);
            tblAuditar.getColumnModel().getColumn(4).setPreferredWidth(200);
            tblAuditar.getColumnModel().getColumn(5).setPreferredWidth(200);
            tblAuditar.getColumnModel().getColumn(6).setPreferredWidth(400);
            tblAuditar.getColumnModel().getColumn(7).setPreferredWidth(400);
            tblAuditar.getColumnModel().getColumn(8).setPreferredWidth(400);
            tblAuditar.getColumnModel().getColumn(9).setPreferredWidth(200);
            tblAuditar.getColumnModel().getColumn(10).setPreferredWidth(200);
            tblAuditar.getColumnModel().getColumn(11).setPreferredWidth(200);
            tblAuditar.getColumnModel().getColumn(12).setPreferredWidth(200);
            tblAuditar.getColumnModel().getColumn(13).setPreferredWidth(200);
            tblAuditar.getColumnModel().getColumn(14).setPreferredWidth(400);
            tblAuditar.getColumnModel().getColumn(15).setPreferredWidth(400);
            }
            if(tipo==2){
            String[] encabezadoB={"HORA_VENTA","NOMBRE_USUARIO","NOMBRE_CONTACTO","CEDULA_CONTACTO","TARJETA_CONTACTO","NOMBRE_SUBSCRICTOR","UBICACION_SERVICIO","CODIGO_SERVICIO","TELEFONO_CONTACTO","TIPO_PRODUCTO","REVISADA_POR","ESTATUS_CONTROL","FECHA_DEVOLUCION_POR_CONTROL","FECHA_ENTREGADO_A_CONTROL"};
            String[][] contenidoB;
            System.out.println("busca formularios ppt");
            contenidoB=objGestorV.getDatosAuditarCAU(fecha_tabla);
            tblAuditar.setModel(new javax.swing.table.DefaultTableModel(contenidoB,encabezadoB));
            tblAuditar.getColumnModel().getColumn(0).setPreferredWidth(200);
            tblAuditar.getColumnModel().getColumn(1).setPreferredWidth(200);
            tblAuditar.getColumnModel().getColumn(2).setPreferredWidth(200);
            tblAuditar.getColumnModel().getColumn(3).setPreferredWidth(200);
            tblAuditar.getColumnModel().getColumn(4).setPreferredWidth(200);
            tblAuditar.getColumnModel().getColumn(5).setPreferredWidth(200);
            tblAuditar.getColumnModel().getColumn(6).setPreferredWidth(200);
            tblAuditar.getColumnModel().getColumn(7).setPreferredWidth(200);
            tblAuditar.getColumnModel().getColumn(8).setPreferredWidth(200);
            tblAuditar.getColumnModel().getColumn(9).setPreferredWidth(200);
            tblAuditar.getColumnModel().getColumn(10).setPreferredWidth(200);
            tblAuditar.getColumnModel().getColumn(11).setPreferredWidth(200);
            tblAuditar.getColumnModel().getColumn(12).setPreferredWidth(400);
            tblAuditar.getColumnModel().getColumn(13).setPreferredWidth(400);
      
                
            }
            
            if(tipo==4){
            String[] encabezadoD={"HORA_VENTA","CANAL_VENTA","PRODUCTO","TIPO","SUPERVISOR","COD_USUARIO","TARJETA_CONTACTO","NOMBRE_CONTACTO","CEDULA_CONTACTO","MONTO_DESEMBOLSO","MONEDA_DESEMBOLSO","COMISION_DESEMBOLSO","TASA_INTERES","SEGURO_SALDO_DEUDOR","CUENTA_CLIENTE_SINPE","TELEFONO_CONTACTO","BANCO_DESTINO","MONEDA_DESTINO","VENCIMIENTO","CUOTA","PLAZO","REVISADA_POR","ESTATUS_CONTROL","FECHA_DEVOLUCION","FECHA_ENTREGA2"};
            String[][] contenidoD;
            System.out.println("busca formularios Extra-Intra");
            contenidoD=objGestorV.getAuditarIntraExtra(fecha_tabla);
            tblAuditar.setModel(new javax.swing.table.DefaultTableModel(contenidoD,encabezadoD));
            tblAuditar.getColumnModel().getColumn(0).setPreferredWidth(200);
            tblAuditar.getColumnModel().getColumn(1).setPreferredWidth(200);
            tblAuditar.getColumnModel().getColumn(2).setPreferredWidth(200);
            tblAuditar.getColumnModel().getColumn(3).setPreferredWidth(200);
            tblAuditar.getColumnModel().getColumn(4).setPreferredWidth(200);
            tblAuditar.getColumnModel().getColumn(5).setPreferredWidth(200);
            tblAuditar.getColumnModel().getColumn(6).setPreferredWidth(200);
            tblAuditar.getColumnModel().getColumn(7).setPreferredWidth(400);
            tblAuditar.getColumnModel().getColumn(8).setPreferredWidth(200);
            tblAuditar.getColumnModel().getColumn(9).setPreferredWidth(200);
            tblAuditar.getColumnModel().getColumn(10).setPreferredWidth(250);
            tblAuditar.getColumnModel().getColumn(11).setPreferredWidth(250);
            tblAuditar.getColumnModel().getColumn(12).setPreferredWidth(200);
            tblAuditar.getColumnModel().getColumn(13).setPreferredWidth(300);
            tblAuditar.getColumnModel().getColumn(14).setPreferredWidth(250);
            tblAuditar.getColumnModel().getColumn(15).setPreferredWidth(250);
            tblAuditar.getColumnModel().getColumn(16).setPreferredWidth(200);
            tblAuditar.getColumnModel().getColumn(17).setPreferredWidth(200);
            tblAuditar.getColumnModel().getColumn(18).setPreferredWidth(200);
            tblAuditar.getColumnModel().getColumn(19).setPreferredWidth(200);                
            tblAuditar.getColumnModel().getColumn(20).setPreferredWidth(200);
            tblAuditar.getColumnModel().getColumn(21).setPreferredWidth(200);
            tblAuditar.getColumnModel().getColumn(22).setPreferredWidth(200);
            tblAuditar.getColumnModel().getColumn(23).setPreferredWidth(200);
            tblAuditar.getColumnModel().getColumn(24).setPreferredWidth(200);
           
            }
            }catch(Exception ex){
                System.out.println("objGestorV.LLENA DATOS LISTA:"+ex);
            }       
    }
    
    private void llenaFechas(){
        
        try{
         if(tipo==1){
         cmbFechasAuditoria.setModel(new javax.swing.DefaultComboBoxModel(objGestorV.getFechasPPT()));
         }
         if(tipo==2){
         cmbFechasAuditoria.setModel(new javax.swing.DefaultComboBoxModel(objGestorV.getFechasCAU()));
         }
         if(tipo==4){
         cmbFechasAuditoria.setModel(new javax.swing.DefaultComboBoxModel(objGestorV.buscaFechasFinanc()));
         }
         
        }catch (Exception ex){
            System.out.println("llenaFechas"+ex);
        }
        
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cmbFechasAuditoria = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblAuditar = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("AUDITAR LLAMADAS");

        jScrollPane2.setPreferredSize(new java.awt.Dimension(10, 10));

        tblAuditar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        tblAuditar.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblAuditar.setPreferredSize(new java.awt.Dimension(3500, 10000));
        jScrollPane2.setViewportView(tblAuditar);

        jButton1.setText("Salvar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Regresar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Buscar por Fecha");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel2.setText("Revisado por:");

        jLabel3.setText("Status:");

        jLabel4.setText("Fecha devolucion:");

        jLabel5.setText("Fecha devuelto a control");

        jButton4.setText("Enviar a Disco");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(cmbFechasAuditoria, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 508, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField1)
                            .addComponent(jLabel2)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                            .addComponent(jTextField3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5)
                            .addComponent(jTextField4)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE))))
                .addGap(111, 111, 111))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbFechasAuditoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addGap(55, 55, 55)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(116, 116, 116)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton4))
                .addGap(169, 169, 169))
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

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String fecha=cmbFechasAuditoria.getSelectedItem().toString();
        llenaDatosLista(fecha);
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        objGestorV.btn_Regresar_a_MenuQA(this);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        //salva llamada auditada
                
       //seleccionó algo?
        try{
        if(tipo==1){
            int linea = tblAuditar.getSelectedRow();
            String [][] datos=objGestorV.getDatosAuditarPPT(fecha_tabla);
        
            String pfecha=datos[linea][0];
            String pcod_cue=datos[linea][1];
            String previsada_por=jTextField1.getText();
            String pstatus_control=jTextField2.getText();
            String pdevolucion=jTextField3.getText();
            String pregreso=jTextField4.getText();
            
            objGestorV.salvar_Llamada_Auditada_PPT(pfecha, pcod_cue, previsada_por, pstatus_control, pdevolucion, pregreso);
        }
        if(tipo==2){
            int linea = tblAuditar.getSelectedRow();
            String [][] datos=objGestorV.getDatosAuditarCAU(fecha_tabla);

            String pfecha=datos[linea][0];
            String ptarjeta=datos[linea][4];
            String previsada_por=jTextField1.getText();
            String pstatus_control=jTextField2.getText();
            String pdevolucion=jTextField3.getText();
            String pregreso=jTextField4.getText();
            
            objGestorV.salvar_Llamada_Auditada_CAU(pfecha, ptarjeta, previsada_por, pstatus_control, pdevolucion, pregreso);
        }
            if(tipo==4){
            int linea = tblAuditar.getSelectedRow();
            String [][] datos=objGestorV.getAuditarIntraExtra(fecha_tabla);

            String pfecha=datos[linea][0];
            String ptarjeta=datos[linea][6];
            String previsada_por=jTextField1.getText();
            String pstatus_control=jTextField2.getText();
            String pdevolucion=jTextField3.getText();
            String pregreso=jTextField4.getText();
            
            objGestorV.salvar_Llamada_Auditada_E_I(pfecha, ptarjeta, previsada_por, pstatus_control, pdevolucion, pregreso);
        }
            llenaDatosLista(fecha_tabla);
            
        }catch (Exception ex){
            System.out.println(ex);
        }
        //envielo al cd

            
            
            
                
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try{
            
            
            
            if(tipo==1){
               int linea = tblAuditar.getSelectedRow();
                String [][] datos=objGestorV.getDatosAuditarPPT(fecha_tabla); 
                String pfecha=datos[linea][0];
                String pcod_cue=datos[linea][1];
                objGestorV.enviar_CD_PPT(pfecha, pcod_cue);
            }
            if(tipo==2){
               int linea = tblAuditar.getSelectedRow();
                String [][] datos=objGestorV.getDatosAuditarCAU(fecha_tabla); 
                String pfecha=datos[linea][0];
                String ptarjeta=datos[linea][4];
                objGestorV.enviar_CD_CAU(pfecha, ptarjeta);
            }
            if(tipo==4){
               int linea = tblAuditar.getSelectedRow();
                String [][] datos=objGestorV.getAuditarIntraExtra(fecha_tabla); 
                String pfecha=datos[linea][0];
                String ptarjeta=datos[linea][6];
                objGestorV.setCD_FINANC(pfecha, ptarjeta);
            }
  
            
        }catch (Exception ex){
            System.out.println(ex);
        }
        
        
    }//GEN-LAST:event_jButton4ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cmbFechasAuditoria;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTable tblAuditar;
    // End of variables declaration//GEN-END:variables
}

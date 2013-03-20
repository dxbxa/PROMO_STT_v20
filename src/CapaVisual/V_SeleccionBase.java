
package CapaVisual;

import java.awt.GraphicsEnvironment;

public class V_SeleccionBase extends javax.swing.JFrame {
private A_Gestor_Visual objGestorV;

    public V_SeleccionBase(A_Gestor_Visual pobjGestorV) {
        objGestorV=pobjGestorV;
        initComponents();
        
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        
        GraphicsEnvironment env =GraphicsEnvironment.getLocalGraphicsEnvironment();
        this.setMaximizedBounds(env.getMaximumWindowBounds());
        this.setExtendedState(this.getExtendedState() | this.MAXIMIZED_BOTH);
        
        llenaDatosLista();
        
    }

    public void llenaDatosLista(){

            try{

            String[] encabezadoA={"CEDULA","NOMBRE","PLAN","METAL","LIMITE","VENCIMIENTO","PROMESA GENERAL","FECHA PROMESA","ESTATUS"};
            String[][] contenidoA;
            contenidoA=objGestorV.getBaseAsesor();
            tblSeleccionBase.setModel(new javax.swing.table.DefaultTableModel(contenidoA,encabezadoA));
            tblSeleccionBase.getColumnModel().getColumn(0).setPreferredWidth(100);
            tblSeleccionBase.getColumnModel().getColumn(1).setPreferredWidth(250);
            tblSeleccionBase.getColumnModel().getColumn(2).setPreferredWidth(100);
            tblSeleccionBase.getColumnModel().getColumn(3).setPreferredWidth(250);
            tblSeleccionBase.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblSeleccionBase.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblSeleccionBase.getColumnModel().getColumn(6).setPreferredWidth(250);
            tblSeleccionBase.getColumnModel().getColumn(7).setPreferredWidth(150);
            tblSeleccionBase.getColumnModel().getColumn(8).setPreferredWidth(100);

          
            }catch(Exception ex){
                System.out.println("objGestorV.getDatosAuditarPPT:"+ex);
            }       
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSeleccionBase = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane2.setPreferredSize(new java.awt.Dimension(10, 10));

        tblSeleccionBase.setAutoCreateRowSorter(true);
        tblSeleccionBase.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        tblSeleccionBase.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblSeleccionBase.setPreferredSize(new java.awt.Dimension(1350, 11000));
        jScrollPane2.setViewportView(tblSeleccionBase);

        jButton2.setText("Regresar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setText("Consultar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel1.setText("CARTERA DE CLIENTES");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(111, 111, 111))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(580, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(584, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel1)
                .addGap(38, 38, 38)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton4))
                .addGap(47, 47, 47))
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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        objGestorV.btn_Regresar_a_Menu(this,2);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try{
            int indice=tblSeleccionBase.getSelectedRow();
            String cedula = tblSeleccionBase.getValueAt(indice, 0).toString();
            //String[][] datos = objGestorV.getBaseAsesor();
            objGestorV.btn_BuscarsELECCION(1, cedula);
            
        }catch(Exception ex){
            System.out.println(ex);
        }
        
        
    }//GEN-LAST:event_jButton4ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblSeleccionBase;
    // End of variables declaration//GEN-END:variables
}

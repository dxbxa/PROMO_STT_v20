
package CapaVisual;
import java.awt.GraphicsEnvironment;
import java.awt.*;
import javax.swing.*;

public class V_Llamadas extends javax.swing.JFrame {
    
    A_Gestor_Visual objGestorV;
    int papa;
    
public V_Llamadas(A_Gestor_Visual pobjGestorV,int TipoArranque,String pvalorBuscado,int ppapa) {
    objGestorV=pobjGestorV;
    papa=ppapa;
    initComponents();

        GraphicsEnvironment env =GraphicsEnvironment.getLocalGraphicsEnvironment();
        this.setMaximizedBounds(env.getMaximumWindowBounds());
        this.setExtendedState(this.getExtendedState() | this.MAXIMIZED_BOTH);
    
    
    
    cmbProductos.setModel(new javax.swing.DefaultComboBoxModel(objGestorV.getDatosProductosIU()));
    cmbProductos.setSelectedIndex(0);
    
    cmbPromesasTelefonos.setModel(new javax.swing.DefaultComboBoxModel(objGestorV.getDatosPromesasIU()));
    cmbPromesasTelefonos.setSelectedIndex(0);
    
    lblNombreProyecto.setText("Nombre del Proyecto: "+objGestorV.getDatosDesc_ProyectoIU());
    lblnombreAsesor.setText("Nombre del Usuario: "+objGestorV.getDatosNombre_UsuarioIU());
    cargaContactos(TipoArranque,pvalorBuscado);

 
}

private void cargaContactos(int TipoArranque,String pvalorBuscado){
     //
    
        try{
if (TipoArranque==0){
    objGestorV.Menu_setContactoBusqueda(TipoArranque, pvalorBuscado, objGestorV.getDatosCod_UsuarioIU());
}else{
    objGestorV.Menu_setContactoBusqueda(TipoArranque, pvalorBuscado, "");
}
            
    llamada = new String[5][objGestorV.getTelefonos().length];
    String cedula=objGestorV.getContactos()[0];
    String[] listaCedulas=new String[objGestorV.getTelefonos().length];
        for(int i=0;i<listaCedulas.length;i++){
            listaCedulas[i]=cedula;
        }
    String usuario=objGestorV.getDatosCod_UsuarioIU();
    String[] listaUsuarios=new String[objGestorV.getTelefonos().length];
        for(int i=0;i<listaUsuarios.length;i++){
            listaUsuarios[i]=usuario;
        }
    llamada[0]=listaCedulas;
    llamada[1]=objGestorV.getTelefonos();
    llamada[2]=objGestorV.getResultados();
    llamada[3]=objGestorV.getComentarios();
    llamada[4]=listaUsuarios;
    
    lblPromesaGeneral.setText("Resultado General");
            int promesaMayor=100;
            for(String resultadoSeleccionado: llamada[2]){
                for(int i=0;i<objGestorV.getDatosPromesasIU().length;i++){
                    if(resultadoSeleccionado.equals(objGestorV.getDatosPromesasIU()[i])){
                        if(i<promesaMayor&&!resultadoSeleccionado.equals("00 INGRESAR")){
                            promesaMayor=i;
                        }
                    }
                }
            }
            
            try{
            lblPromesaGeneral.setText(objGestorV.getDatosPromesasIU()[promesaMayor]);
            }catch (Exception ex){
                
            }
              
    lblNombreContacto.setText(objGestorV.getContactos()[1]);
    lblCedula.setText("Cédula: "+llamada[0][0]);
    lblCodCuenta.setText("COD Cuenta: "+objGestorV.getContactos()[2]);
    lblCuenta.setText("Cuenta: "+objGestorV.getContactos()[3]);
    
    cmbIdentificadores.setModel(new javax.swing.DefaultComboBoxModel(objGestorV.getIdentificadores()));
    
    lstTelefonos.setModel(new javax.swing.AbstractListModel() {
            String[] strings = llamada[1];
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
    lstResultados.setModel(new javax.swing.AbstractListModel(){
            String[] strings = llamada[2];
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
            public void setElementAt(String pelement,int i) { strings[i]=pelement; }
        });
    
     }catch(Exception ex){
        if(ex.getMessage().equals("0")){
            JOptionPane.showMessageDialog(rootPane, "Error al cargar contacto, favor verificar parámetros de búsqueda.", "CARGA CONTACTO", JOptionPane.INFORMATION_MESSAGE); 

        }
     }


}

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jFrame1 = new javax.swing.JFrame();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        lblnombreAsesor = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        lblNombreProyecto = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lblNombreContacto = new javax.swing.JLabel();
        lblCedula = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lblCodCuenta = new javax.swing.JLabel();
        lblCuenta = new javax.swing.JLabel();
        cmbIdentificadores = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstTelefonos = new javax.swing.JList();
        txtTelefonoNuevo = new javax.swing.JTextField();
        btnAgregarTelefono = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        lstResultados = new javax.swing.JList();
        jLabel4 = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        cmbProductos = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtComentarios = new javax.swing.JTextArea();
        lblPeriodicidad1 = new javax.swing.JLabel();
        btnActualizar = new javax.swing.JButton();
        cmbPromesasTelefonos = new javax.swing.JComboBox();
        lblPeriodicidad2 = new javax.swing.JLabel();
        lblPeriodicidad3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        lblPromesaGeneral = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("INFORMACIÓN DE CONTACTO");
        setBackground(new java.awt.Color(255, 255, 255));
        setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        setName("LLAMADAS"); // NOI18N
        setPreferredSize(new java.awt.Dimension(1366, 728));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setMaximumSize(new java.awt.Dimension(1366, 748));
        jPanel2.setMinimumSize(new java.awt.Dimension(1366, 748));
        jPanel2.setPreferredSize(new java.awt.Dimension(1366, 748));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Info Asesor"));

        lblnombreAsesor.setText("Nombre: David Barrantes");

        jLabel16.setText("Llamadas: ");

        jLabel17.setText("Ventas: ");

        jLabel18.setText("Yes Ratio: %");

        jLabel19.setText("Efectividad: %");

        lblNombreProyecto.setText("Proyecto: Grupo Nación");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(lblnombreAsesor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblNombreProyecto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel19)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblnombreAsesor)
                    .addComponent(jLabel16)
                    .addComponent(jLabel18)
                    .addComponent(jLabel17)
                    .addComponent(jLabel19)
                    .addComponent(lblNombreProyecto))
                .addGap(19, 19, 19))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Cliente"));

        lblNombreContacto.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblNombreContacto.setText("INVÁLIDO");
        lblNombreContacto.setToolTipText("nombre del contacto");

        lblCedula.setText("N/A");

        jLabel14.setText("Identificadores: ");

        lblCodCuenta.setText("N/A");

        lblCuenta.setText("N/A");

        lstTelefonos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstTelefonos.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstTelefonosValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(lstTelefonos);

        btnAgregarTelefono.setText("Agregar");
        btnAgregarTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarTelefonoActionPerformed(evt);
            }
        });

        jLabel2.setText("Teléfonos");

        lstResultados.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstResultados.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstResultadosValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(lstResultados);

        jLabel4.setText("Resultados");

        btnSalvar.setText("Siguiente");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNombreContacto, javax.swing.GroupLayout.PREFERRED_SIZE, 882, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCuenta)
                            .addComponent(lblCodCuenta)
                            .addComponent(lblCedula)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbIdentificadores, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(97, 97, 97)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel2)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addComponent(txtTelefonoNuevo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnAgregarTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(btnSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4))))
                .addContainerGap(79, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(lblNombreContacto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(lblCedula)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblCodCuenta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblCuenta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(cmbIdentificadores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTelefonoNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregarTelefono)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Acción"));

        cmbProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbProductosActionPerformed(evt);
            }
        });

        txtComentarios.setColumns(20);
        txtComentarios.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        txtComentarios.setRows(5);
        txtComentarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtComentariosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtComentariosMouseExited(evt);
            }
        });
        txtComentarios.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtComentariosKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(txtComentarios);

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        cmbPromesasTelefonos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbPromesasTelefonosActionPerformed(evt);
            }
        });

        lblPeriodicidad2.setText("Resultado: ");

        lblPeriodicidad3.setText("Producto:");

        jButton1.setText("Formulario");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Poner en Seguimiento");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        lblPromesaGeneral.setBackground(javax.swing.UIManager.getDefaults().getColor("tab_mouse_over_fill_bright_lower"));
        lblPromesaGeneral.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lblPromesaGeneral.setText("Promesa General");
        lblPromesaGeneral.setEnabled(false);

        jLabel1.setText("Comentarios");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPeriodicidad1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblPeriodicidad3)
                            .addComponent(lblPeriodicidad2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbProductos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbPromesasTelefonos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblPromesaGeneral, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE))))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lblPeriodicidad1)
                        .addGap(3, 3, 3)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbPromesasTelefonos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPeriodicidad2)
                            .addComponent(btnActualizar))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPeriodicidad3)
                            .addComponent(jButton1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPromesaGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jButton4.setText("Regresar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(157, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addContainerGap(80, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbProductosActionPerformed


    }//GEN-LAST:event_cmbProductosActionPerformed

    private void lstTelefonosValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstTelefonosValueChanged

    lstResultados.setSelectedIndex(lstTelefonos.getSelectedIndex());
        try{    
                cmbPromesasTelefonos.setSelectedItem(llamada[2][lstTelefonos.getSelectedIndex()]);
                txtComentarios.setText(llamada[3][lstTelefonos.getSelectedIndex()]);

    }catch (Exception ex){
    }
    }//GEN-LAST:event_lstTelefonosValueChanged

    private void lstResultadosValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstResultadosValueChanged
        lstTelefonos.setSelectedIndex(lstResultados.getSelectedIndex());
    }//GEN-LAST:event_lstResultadosValueChanged

    private void btnAgregarTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarTelefonoActionPerformed
try{
        String valor=txtTelefonoNuevo.getText();
        
        if(valor.length()!=8){JOptionPane.showMessageDialog(rootPane, "La longitud de caracteres no corresponde a un número de teléfono nacional", "TELEFONO NUEVO", JOptionPane.WARNING_MESSAGE); txtTelefonoNuevo.setText(""); return;}
        if(llamada[1].length>=10){
            JOptionPane.showMessageDialog(rootPane, "No se pueden agregar más de 10 teléfonos", "TELEFONO NUEVO", JOptionPane.WARNING_MESSAGE); 
            txtTelefonoNuevo.setText("");
            return;}
        for(int i=0;i<llamada[1].length;i++){
                    if(llamada[1][i].contains(valor)){
                        JOptionPane.showMessageDialog(rootPane, "No se pueden agregar teléfonos repetidos", "TELEFONO NUEVO", JOptionPane.WARNING_MESSAGE);
                        txtTelefonoNuevo.setText("");
                        return;
                    }
        }
       try{
        Integer.parseInt(valor);
    } catch(NumberFormatException nfe) {
        JOptionPane.showMessageDialog(rootPane, "Debe ingresar sólo valores numéricos", "TELEFONO NUEVO", JOptionPane.WARNING_MESSAGE);
        txtTelefonoNuevo.setText("");
        return;
    }

       //fin validaciones
    
       
        String[][] tmpLlamada = new String[9][llamada[1].length+1];
        for(int k=0;k<llamada.length;k++){
            for(int i=0;i<llamada[k].length;i++){
                String dato = new String();
                dato = llamada[k][i];
                tmpLlamada[k][i]= dato;
            }
        }
        
        tmpLlamada[0][llamada[1].length]=objGestorV.getContactos()[0];
        tmpLlamada[1][llamada[1].length]=valor;
        tmpLlamada[2][llamada[1].length]="00 INGRESAR";
        tmpLlamada[3][llamada[1].length]="SIN COMENTARIO";
        tmpLlamada[4][llamada[1].length]=objGestorV.getDatosCod_UsuarioIU();

        llamada=tmpLlamada;
        
        lstTelefonos.setModel(new javax.swing.AbstractListModel() {
        String[] strings = llamada[1];
        public int getSize() { return strings.length; }
        public Object getElementAt(int i) { return strings[i]; }
    });
        lstResultados.setModel(new javax.swing.AbstractListModel() {
        String[] strings = llamada[2];
        public int getSize() { return strings.length; }
        public Object getElementAt(int i) { return strings[i]; }
    }); 
        txtTelefonoNuevo.setText("");
        
        }catch (Exception ex){
            JOptionPane.showMessageDialog(rootPane, ex, "AGREGAR TELÉFONO", JOptionPane.WARNING_MESSAGE);
        }
            
    }//GEN-LAST:event_btnAgregarTelefonoActionPerformed

    private void txtComentariosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtComentariosMouseEntered

    }//GEN-LAST:event_txtComentariosMouseEntered

    private void txtComentariosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtComentariosMouseExited

    }//GEN-LAST:event_txtComentariosMouseExited

    private void txtComentariosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtComentariosKeyPressed
           
    }//GEN-LAST:event_txtComentariosKeyPressed
    
    
    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
    
                    try{
        int telefonoSeleccionado = lstResultados.getSelectedIndex();
        if (telefonoSeleccionado>=0){
                    llamada[2][telefonoSeleccionado]=cmbPromesasTelefonos.getSelectedItem().toString();
                    llamada[3][telefonoSeleccionado]=txtComentarios.getText();
                    
                    lstResultados.setModel(new javax.swing.AbstractListModel(){
                    String[] strings = llamada[2];
                    public int getSize() { return strings.length; }
                    public Object getElementAt(int i) { return strings[i]; }});
                    
                    lstResultados.setSelectedIndex(lstTelefonos.getSelectedIndex());
                    
        }else{
            JOptionPane.showMessageDialog(rootPane, "Debe Seleccionar un valor de la lista de resultados", "ASIGNAR RESULTADOS", JOptionPane.WARNING_MESSAGE);
        }
        
        int promesaMayor=100;
            for(String resultadoSeleccionado: llamada[2]){
                for(int i=0;i<objGestorV.getDatosPromesasIU().length;i++){
                    if(resultadoSeleccionado.equals(objGestorV.getDatosPromesasIU()[i])){
                        if(i<promesaMayor&&!resultadoSeleccionado.equals("00 INGRESAR")){
                            promesaMayor=i;
                        }
                    }
                }
            }
            try{
                objGestorV.Llamada_Guardar(llamada);
                lblPromesaGeneral.setText(objGestorV.getDatosPromesasIU()[promesaMayor]);
             }catch (Exception ex){
                
            }
        
        }catch (Exception ex){
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "ACTUALIZAR DATOS", JOptionPane.WARNING_MESSAGE);
        }
        
        
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
//        try{
//            int result = -1;
//            boolean modificado=false;
//            for(String resultado: llamada[2]){
//                if(!resultado.equals("00 INGRESAR")){
//                    modificado=true;
//                }
//            }
//            if(!modificado){
//                JOptionPane pane = new JOptionPane("El contacto no tiene ninguna promesa, desea continuar así?");
//                Object[] options = new String[] { "Continuar", "Cancelar" };
//                pane.setOptions(options);
//                JDialog dialog = pane.createDialog(new JFrame(), "Dilaog");
//                dialog.show();
//                Object obj = pane.getValue(); 
//                for (int k = 0; k < options.length; k++) {
//                    if (options[k].equals(obj)) {
//                        result = k;
//                    }
//                }
//            }
//            
//            if(modificado || result==0){
//                 
//                objGestorV.Llamada_Guardar(llamada);
//            }
//            
            try{
                //si hay base seleccionada
                
//                objGestorV.getBaseSeleccionada();
                objGestorV.Menu_setContactoBusqueda(0, "", objGestorV.getDatosCod_UsuarioIU());
            cargaContactos(0,"");
            }catch(Exception ex){
                JOptionPane.showMessageDialog(rootPane, "Debe seleccionar una base de datos \n de la pantalla de menú.", "CARGAR CONTACTO SIGUIENTE", JOptionPane.INFORMATION_MESSAGE);
            }
            
            
            
       
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
              btn_regresar();  
        
    }//GEN-LAST:event_jButton4ActionPerformed
    private void btn_regresar(){
        objGestorV.btn_Regresar_a_Menu(this,papa);
    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       
        try{
        String cédula, nombre, comentario;
        comentario=JOptionPane.showInputDialog("Ingrese un comentario distintivo para reservar este contacto: ");
        if(!comentario.equals("")){
                   
                        cédula=llamada[0][0];
                        nombre=objGestorV.getContactos()[1];
                        objGestorV.Llamada_Agendar(cédula,nombre,comentario,"");
               
                
                try{
                //si hay base seleccionada
                
                    //objGestorV.getBaseSeleccionada();
                    objGestorV.Menu_setContactoBusqueda(0, "", objGestorV.getDatosCod_UsuarioIU());
                    cargaContactos(0,"");
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(rootPane, "Debe seleccionar una base de datos \n de la pantalla de menú.", "CARGAR CONTACTO SIGUIENTE", JOptionPane.INFORMATION_MESSAGE);
                }
            
            
        }
        
       }catch(Exception ex){
            System.out.println(ex);
       }  
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
        //muestra formulario
        
        int tipoProducto=cmbProductos.getSelectedIndex();
        objGestorV.btn_Formulario(tipoProducto);
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cmbPromesasTelefonosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPromesasTelefonosActionPerformed

        
    }//GEN-LAST:event_cmbPromesasTelefonosActionPerformed
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code variables">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregarTelefono;
    private javax.swing.JButton btnSalvar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox cmbIdentificadores;
    private javax.swing.JComboBox cmbProductos;
    private javax.swing.JComboBox cmbPromesasTelefonos;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblCedula;
    private javax.swing.JLabel lblCodCuenta;
    private javax.swing.JLabel lblCuenta;
    private javax.swing.JLabel lblNombreContacto;
    private javax.swing.JLabel lblNombreProyecto;
    private javax.swing.JLabel lblPeriodicidad1;
    private javax.swing.JLabel lblPeriodicidad2;
    private javax.swing.JLabel lblPeriodicidad3;
    private javax.swing.JButton lblPromesaGeneral;
    private javax.swing.JLabel lblnombreAsesor;
    private javax.swing.JList lstResultados;
    private javax.swing.JList lstTelefonos;
    private javax.swing.JTextArea txtComentarios;
    private javax.swing.JTextField txtTelefonoNuevo;
    // End of variables declaration//GEN-END:variables
    private String[][] llamada; //cedula,telefono,resultado, comentario
    // </editor-fold>
}


package A_Ventas.CapaVisual;

import java.awt.GraphicsEnvironment;

public class A_Auditar extends javax.swing.JFrame {
private A_GestorVisual objGestorV;
private int tipo;
private String fecha_tabla;

    public A_Auditar(A_GestorVisual pobjGestorV,int pTipo){
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
        
        if(objGestorV.getRol().equals("supervisor")){
            pnlControl.setVisible(false);
            btnSalvaAuditar.setVisible(false);
            btnEnviarCD.setVisible(false);
        }else{
            pnlSupervisor.setVisible(false);
        }
        
    }

    private void llenaDatosLista(String fecha){
        fecha_tabla=fecha;
            try{
            if(tipo==1){
            String[] encabezadoA={"HORA_VENTA","COD_CUENTA","TARJETA_CONTACTO","PLAN_TARJETA","FECHA_NACIMIENTO","CEDULA_CONTACTO","NOMBRE_CONTACTO","PRODUCTO","TIPO_PRODUCTO","NOMBRE_USUARIO","TELEFONO_CONTACTO","CIERRE","ENVIADA A CD","REVISION_CONTROL_1","STATUS_CONTROL_1","COMENTARIO_CONTROL_1","FECHA_CONTROL_1","REVISION_CONTROL_2","STATUS_CONTROL_2","COMENTARIO_CONTROL_2","FECHA_CONTROL_2","STATUS_ADMIN","FECHA_ADMIN","STATUS_AFILIACIONES","FECHA_AFILIACIONES"};
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
            tblAuditar.getColumnModel().getColumn(16).setPreferredWidth(200);
            tblAuditar.getColumnModel().getColumn(17).setPreferredWidth(200);
            tblAuditar.getColumnModel().getColumn(18).setPreferredWidth(400);
            tblAuditar.getColumnModel().getColumn(19).setPreferredWidth(400);
            tblAuditar.getColumnModel().getColumn(20).setPreferredWidth(200);
            tblAuditar.getColumnModel().getColumn(21).setPreferredWidth(200);
            tblAuditar.getColumnModel().getColumn(22).setPreferredWidth(400);
            tblAuditar.getColumnModel().getColumn(23).setPreferredWidth(400);
            tblAuditar.getColumnModel().getColumn(24).setPreferredWidth(400);
            }
            if(tipo==2){
            String[] encabezadoB={"HORA_VENTA","NOMBRE_USUARIO","NOMBRE_CONTACTO","CEDULA_CONTACTO","TARJETA_CONTACTO","NOMBRE_SUBSCRICTOR","UBICACION_SERVICIO","CODIGO_SERVICIO","TELEFONO_CONTACTO","TIPO_PRODUCTO","ENVIADA A CD","REVISION_CONTROL_1","STATUS_CONTROL_1","COMENTARIO_CONTROL_1","FECHA_CONTROL_1","REVISION_CONTROL_2","STATUS_CONTROL_2","COMENTARIO_CONTROL_2","FECHA_CONTROL_2","STATUS_ADMIN","FECHA_ADMIN","STATUS_AFILIACIONES","FECHA_AFILIACIONES"};
            String[][] contenidoB;
            System.out.println("busca formularios ppt");
            contenidoB=objGestorV.getDatosAuditarCAU(fecha_tabla);
            tblAuditar.setModel(new javax.swing.table.DefaultTableModel(contenidoB,encabezadoB));
            tblAuditar.getColumnModel().getColumn(0).setPreferredWidth(400);
            tblAuditar.getColumnModel().getColumn(1).setPreferredWidth(200);
            tblAuditar.getColumnModel().getColumn(2).setPreferredWidth(400);
            tblAuditar.getColumnModel().getColumn(3).setPreferredWidth(200);
            tblAuditar.getColumnModel().getColumn(4).setPreferredWidth(400);
            tblAuditar.getColumnModel().getColumn(5).setPreferredWidth(200);
            tblAuditar.getColumnModel().getColumn(6).setPreferredWidth(200);
            tblAuditar.getColumnModel().getColumn(7).setPreferredWidth(200);
            tblAuditar.getColumnModel().getColumn(8).setPreferredWidth(200);
            tblAuditar.getColumnModel().getColumn(9).setPreferredWidth(200);
            tblAuditar.getColumnModel().getColumn(10).setPreferredWidth(200);
            tblAuditar.getColumnModel().getColumn(11).setPreferredWidth(200);
            tblAuditar.getColumnModel().getColumn(12).setPreferredWidth(400);
            tblAuditar.getColumnModel().getColumn(13).setPreferredWidth(400);
            tblAuditar.getColumnModel().getColumn(14).setPreferredWidth(200);
            tblAuditar.getColumnModel().getColumn(15).setPreferredWidth(400);
            tblAuditar.getColumnModel().getColumn(16).setPreferredWidth(400);
            tblAuditar.getColumnModel().getColumn(17).setPreferredWidth(400);
            tblAuditar.getColumnModel().getColumn(18).setPreferredWidth(400);
            tblAuditar.getColumnModel().getColumn(19).setPreferredWidth(400);
            tblAuditar.getColumnModel().getColumn(20).setPreferredWidth(400);
            tblAuditar.getColumnModel().getColumn(21).setPreferredWidth(400);
            tblAuditar.getColumnModel().getColumn(22).setPreferredWidth(400);
            }
            
            if(tipo==4){
            String[] encabezadoD={"HORA_VENTA","CANAL_VENTA","PRODUCTO","TIPO","SUPERVISOR","COD_USUARIO","TARJETA_CONTACTO","NOMBRE_CONTACTO","CEDULA_CONTACTO","MONTO_DESEMBOLSO","MONEDA_DESEMBOLSO","COMISION_DESEMBOLSO","TASA_INTERES","SEGURO_SALDO_DEUDOR","CUENTA_CLIENTE_SINPE","TELEFONO_CONTACTO","BANCO_DESTINO","MONEDA_DESTINO","VENCIMIENTO","CUOTA","PLAZO","ENVIADA A CD","REVISION_CONTROL_1","STATUS_CONTROL_1","COMENTARIO_CONTROL_1","FECHA_CONTROL_1","REVISION_CONTROL_2","STATUS_CONTROL_2","COMENTARIO_CONTROL_2","FECHA_CONTROL_2","STATUS_ADMIN","FECHA_ADMIN","STATUS_AFILIACIONES","FECHA_AFILIACIONES"};
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
            tblAuditar.getColumnModel().getColumn(25).setPreferredWidth(200);
            tblAuditar.getColumnModel().getColumn(26).setPreferredWidth(200);
            tblAuditar.getColumnModel().getColumn(27).setPreferredWidth(200);                
            tblAuditar.getColumnModel().getColumn(28).setPreferredWidth(200);
            tblAuditar.getColumnModel().getColumn(29).setPreferredWidth(200);
            tblAuditar.getColumnModel().getColumn(30).setPreferredWidth(200);
            tblAuditar.getColumnModel().getColumn(31).setPreferredWidth(200);
            tblAuditar.getColumnModel().getColumn(32).setPreferredWidth(200);
            tblAuditar.getColumnModel().getColumn(33).setPreferredWidth(200);
           
            }
            }catch(Exception ex){
                System.out.println("objGestorV.LLENA DATOS LISTA:"+ex);
            }       
    }
    
    private void llenaDatosLista_X_cedula(String pcedula){
            try{
            if(tipo==1){
            String[] encabezadoA={"HORA_VENTA","COD_CUENTA","TARJETA_CONTACTO","PLAN_TARJETA","FECHA_NACIMIENTO","CEDULA_CONTACTO","NOMBRE_CONTACTO","PRODUCTO","TIPO_PRODUCTO","NOMBRE_USUARIO","TELEFONO_CONTACTO","CIERRE","ENVIADA A CD","REVISION_CONTROL_1","STATUS_CONTROL_1","COMENTARIO_CONTROL_1","FECHA_CONTROL_1","REVISION_CONTROL_2","STATUS_CONTROL_2","COMENTARIO_CONTROL_2","FECHA_CONTROL_2","STATUS_ADMIN","FECHA_ADMIN","STATUS_AFILIACIONES","FECHA_AFILIACIONES"};
            String[][] contenidoA;
            contenidoA=objGestorV.getDatosAuditarPPT_X_cedula(pcedula);
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
            tblAuditar.getColumnModel().getColumn(16).setPreferredWidth(200);
            tblAuditar.getColumnModel().getColumn(17).setPreferredWidth(200);
            tblAuditar.getColumnModel().getColumn(18).setPreferredWidth(400);
            tblAuditar.getColumnModel().getColumn(19).setPreferredWidth(400);
            tblAuditar.getColumnModel().getColumn(20).setPreferredWidth(200);
            tblAuditar.getColumnModel().getColumn(21).setPreferredWidth(200);
            tblAuditar.getColumnModel().getColumn(22).setPreferredWidth(400);
            tblAuditar.getColumnModel().getColumn(23).setPreferredWidth(400);
            tblAuditar.getColumnModel().getColumn(24).setPreferredWidth(400);
            }
            if(tipo==2){
            String[] encabezadoB={"HORA_VENTA","NOMBRE_USUARIO","NOMBRE_CONTACTO","CEDULA_CONTACTO","TARJETA_CONTACTO","NOMBRE_SUBSCRICTOR","UBICACION_SERVICIO","CODIGO_SERVICIO","TELEFONO_CONTACTO","TIPO_PRODUCTO","ENVIADA A CD","REVISION_CONTROL_1","STATUS_CONTROL_1","COMENTARIO_CONTROL_1","FECHA_CONTROL_1","REVISION_CONTROL_2","STATUS_CONTROL_2","COMENTARIO_CONTROL_2","FECHA_CONTROL_2","STATUS_ADMIN","FECHA_ADMIN","STATUS_AFILIACIONES","FECHA_AFILIACIONES"};
            String[][] contenidoB;
            System.out.println("busca formularios ppt");
            contenidoB=objGestorV.getDatosAuditarCAU_X_cedula(pcedula);
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
            tblAuditar.getColumnModel().getColumn(14).setPreferredWidth(200);
            tblAuditar.getColumnModel().getColumn(15).setPreferredWidth(200);
            tblAuditar.getColumnModel().getColumn(16).setPreferredWidth(200);
            tblAuditar.getColumnModel().getColumn(17).setPreferredWidth(200);
            tblAuditar.getColumnModel().getColumn(18).setPreferredWidth(200);
            tblAuditar.getColumnModel().getColumn(19).setPreferredWidth(200);
            tblAuditar.getColumnModel().getColumn(20).setPreferredWidth(400);
            tblAuditar.getColumnModel().getColumn(21).setPreferredWidth(400);
            tblAuditar.getColumnModel().getColumn(22).setPreferredWidth(400);
                
            }
            
            if(tipo==4){
            String[] encabezadoD={"HORA_VENTA","CANAL_VENTA","PRODUCTO","TIPO","SUPERVISOR","COD_USUARIO","TARJETA_CONTACTO","NOMBRE_CONTACTO","CEDULA_CONTACTO","MONTO_DESEMBOLSO","MONEDA_DESEMBOLSO","COMISION_DESEMBOLSO","TASA_INTERES","SEGURO_SALDO_DEUDOR","CUENTA_CLIENTE_SINPE","TELEFONO_CONTACTO","BANCO_DESTINO","MONEDA_DESTINO","VENCIMIENTO","CUOTA","PLAZO","ENVIADA A CD","REVISION_CONTROL_1","STATUS_CONTROL_1","COMENTARIO_CONTROL_1","FECHA_CONTROL_1","REVISION_CONTROL_2","STATUS_CONTROL_2","COMENTARIO_CONTROL_2","FECHA_CONTROL_2","STATUS_ADMIN","FECHA_ADMIN","STATUS_AFILIACIONES","FECHA_AFILIACIONES"};
            String[][] contenidoD;
            contenidoD=objGestorV.getAuditarIntraExtra_X_cedula(pcedula);
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
            tblAuditar.getColumnModel().getColumn(25).setPreferredWidth(200);
            tblAuditar.getColumnModel().getColumn(26).setPreferredWidth(200);
            tblAuditar.getColumnModel().getColumn(27).setPreferredWidth(200);                
            tblAuditar.getColumnModel().getColumn(28).setPreferredWidth(200);
            tblAuditar.getColumnModel().getColumn(29).setPreferredWidth(200);
            tblAuditar.getColumnModel().getColumn(30).setPreferredWidth(200);
            tblAuditar.getColumnModel().getColumn(31).setPreferredWidth(200);
            tblAuditar.getColumnModel().getColumn(32).setPreferredWidth(200);
            tblAuditar.getColumnModel().getColumn(33).setPreferredWidth(200);
           
            }
            }catch(Exception ex){
                System.out.println("objGestorV.LLENA DATOS LISTA_X_cedula:"+ex);
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
        btnSalvaAuditar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btnEnviarCD = new javax.swing.JButton();
        txtCedulaBuscada = new javax.swing.JTextField();
        btnBuscarAuditoriaCedula = new javax.swing.JButton();
        pnlControl = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cmbAuditor = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        cmbStatusAuditor = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        txtComentarioControl = new javax.swing.JTextField();
        chkRevision = new javax.swing.JCheckBox();
        pnlSupervisor = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        cmbStatusSupervisor2 = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        cmbStatusSupervisor1 = new javax.swing.JComboBox();
        btnSalvaSalesAdmin = new javax.swing.JButton();
        btnSalvaAfiliaciones = new javax.swing.JButton();

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
        tblAuditar.setPreferredSize(new java.awt.Dimension(7200, 10000));
        jScrollPane2.setViewportView(tblAuditar);

        btnSalvaAuditar.setText("Salvar");
        btnSalvaAuditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvaAuditarActionPerformed(evt);
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

        btnEnviarCD.setText("Enviar a Disco");
        btnEnviarCD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarCDActionPerformed(evt);
            }
        });

        btnBuscarAuditoriaCedula.setText("Buscar por cédula");
        btnBuscarAuditoriaCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarAuditoriaCedulaActionPerformed(evt);
            }
        });

        pnlControl.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setText("Revisado por:");

        cmbAuditor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "KATHYA VARGAS", "VICTORIA ELIAS", "ERROL DUARTE" }));

        jLabel3.setText("Status:");

        cmbStatusAuditor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " ", "ACEPTADA", "ANULADA", "DUPLICADA", "DEVUELTA", "RECHAZADA", "PENDIENTE", "VALIDAR", "OTRO" }));

        jLabel6.setText("Comentario:");

        chkRevision.setBackground(new java.awt.Color(255, 255, 255));
        chkRevision.setSelected(true);
        chkRevision.setText("Primer Revisión por Control");
        chkRevision.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkRevisionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlControlLayout = new javax.swing.GroupLayout(pnlControl);
        pnlControl.setLayout(pnlControlLayout);
        pnlControlLayout.setHorizontalGroup(
            pnlControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlControlLayout.createSequentialGroup()
                .addGroup(pnlControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(cmbAuditor, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(cmbStatusAuditor, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtComentarioControl, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(241, 241, 241))
            .addGroup(pnlControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlControlLayout.createSequentialGroup()
                    .addContainerGap(805, Short.MAX_VALUE)
                    .addComponent(chkRevision)
                    .addGap(34, 34, 34)))
        );
        pnlControlLayout.setVerticalGroup(
            pnlControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlControlLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(pnlControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtComentarioControl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbAuditor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbStatusAuditor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
            .addGroup(pnlControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlControlLayout.createSequentialGroup()
                    .addGap(46, 46, 46)
                    .addComponent(chkRevision)
                    .addContainerGap(28, Short.MAX_VALUE)))
        );

        pnlSupervisor.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setText("Status AFILIACIONES:");

        cmbStatusSupervisor2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " ", "ACEPTADA", "ANULADA", "DUPLICADA", "DEVUELTA", "RECHAZADA", "PENDIENTE", "VALIDAR", "OTRO" }));

        jLabel5.setText("Status SALES_ADMIN:");

        cmbStatusSupervisor1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " ", "ACEPTADA", "ANULADA", "DUPLICADA", "DEVUELTA", "RECHAZADA", "PENDIENTE", "VALIDAR", "OTRO" }));

        btnSalvaSalesAdmin.setText("Salvar");
        btnSalvaSalesAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvaSalesAdminActionPerformed(evt);
            }
        });

        btnSalvaAfiliaciones.setText("Salvar");
        btnSalvaAfiliaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvaAfiliacionesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlSupervisorLayout = new javax.swing.GroupLayout(pnlSupervisor);
        pnlSupervisor.setLayout(pnlSupervisorLayout);
        pnlSupervisorLayout.setHorizontalGroup(
            pnlSupervisorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSupervisorLayout.createSequentialGroup()
                .addGroup(pnlSupervisorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(pnlSupervisorLayout.createSequentialGroup()
                        .addComponent(cmbStatusSupervisor1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSalvaSalesAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                .addGroup(pnlSupervisorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlSupervisorLayout.createSequentialGroup()
                        .addComponent(cmbStatusSupervisor2, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSalvaAfiliaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4)))
        );
        pnlSupervisorLayout.setVerticalGroup(
            pnlSupervisorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSupervisorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSupervisorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlSupervisorLayout.createSequentialGroup()
                        .addGroup(pnlSupervisorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addGap(1, 1, 1)
                        .addGroup(pnlSupervisorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbStatusSupervisor1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSalvaSalesAdmin)))
                    .addGroup(pnlSupervisorLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(pnlSupervisorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSalvaAfiliaciones)
                            .addComponent(cmbStatusSupervisor2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnlSupervisor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlControl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalvaAuditar, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEnviarCD, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCedulaBuscada)
                            .addComponent(cmbFechasAuditoria, 0, 188, Short.MAX_VALUE))
                        .addGap(39, 39, 39)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnBuscarAuditoriaCedula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCedulaBuscada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarAuditoriaCedula))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlControl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlSupervisor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvaAuditar)
                    .addComponent(jButton2)
                    .addComponent(btnEnviarCD))
                .addGap(173, 173, 173))
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

    private void btnSalvaAuditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvaAuditarActionPerformed
        //salva llamada auditada
        int tipo_seleccion=2;
        if(chkRevision.isSelected()){
            tipo_seleccion=1;
        }
       //seleccionó algo?
        try{
        if(tipo==1){
            int indice = tblAuditar.getSelectedRow();
            String pfecha = tblAuditar.getValueAt(indice, 0).toString();
            String pcod_cue= tblAuditar.getValueAt(indice, 1).toString();
            
            String previsada_por=cmbAuditor.getSelectedItem().toString();
            String pstatus_control=cmbStatusAuditor.getSelectedItem().toString();
            String comentario=txtComentarioControl.getText();
            
            objGestorV.salvar_Llamada_Auditada_PPT(pfecha, pcod_cue, previsada_por, pstatus_control, comentario,tipo_seleccion);
        }
        if(tipo==2){
            int indice = tblAuditar.getSelectedRow();
            String pfecha = tblAuditar.getValueAt(indice, 0).toString();
            String ptarjeta=tblAuditar.getValueAt(indice, 4).toString();
            
            String previsada_por=cmbAuditor.getSelectedItem().toString();
            String pstatus_control=cmbStatusAuditor.getSelectedItem().toString();
            String comentario=txtComentarioControl.getText();
            
            objGestorV.salvar_Llamada_Auditada_CAU(pfecha, ptarjeta, previsada_por, pstatus_control, comentario, tipo_seleccion);
        }
            if(tipo==4){
            int indice = tblAuditar.getSelectedRow();
            String pfecha = tblAuditar.getValueAt(indice, 0).toString();
            String ptarjeta=tblAuditar.getValueAt(indice, 6).toString();
            
            String previsada_por=cmbAuditor.getSelectedItem().toString();
            String pstatus_control=cmbStatusAuditor.getSelectedItem().toString();
            String comentario=txtComentarioControl.getText();
            
            objGestorV.salvar_Llamada_Auditada_E_I(pfecha, ptarjeta, previsada_por, pstatus_control, comentario, tipo_seleccion);
        }
            llenaDatosLista(fecha_tabla);
            
        }catch (Exception ex){
            System.out.println(ex);
        }
        //envielo al cd

            
            
            
             
    }//GEN-LAST:event_btnSalvaAuditarActionPerformed

    private void btnEnviarCDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarCDActionPerformed
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
        
        
    }//GEN-LAST:event_btnEnviarCDActionPerformed

    private void chkRevisionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkRevisionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkRevisionActionPerformed

    private void btnBuscarAuditoriaCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarAuditoriaCedulaActionPerformed
        String cedula=txtCedulaBuscada.getText();
        llenaDatosLista_X_cedula(cedula);        
    }//GEN-LAST:event_btnBuscarAuditoriaCedulaActionPerformed

    private void btnSalvaSalesAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvaSalesAdminActionPerformed

     try{
        if(tipo==1){
            int indice = tblAuditar.getSelectedRow();
            String pfecha = tblAuditar.getValueAt(indice, 0).toString();
            String pcod_cue= tblAuditar.getValueAt(indice, 1).toString();
            
            String pstatus_control=cmbStatusSupervisor1.getSelectedItem().toString();
            
            objGestorV.salvar_Llamada_Auditada_PPT_SUPERVISOR(pfecha, pcod_cue, pstatus_control,3);
        }
        if(tipo==2){
            int indice = tblAuditar.getSelectedRow();
            String pfecha = tblAuditar.getValueAt(indice, 0).toString();
            String ptarjeta=tblAuditar.getValueAt(indice, 4).toString();
            
            String pstatus_control=cmbStatusSupervisor1.getSelectedItem().toString();
            
            objGestorV.salvar_Llamada_Auditada_CAU_SUPERVISOR(pfecha, ptarjeta, pstatus_control, 3);
        }
            if(tipo==4){
            int indice = tblAuditar.getSelectedRow();
            String pfecha = tblAuditar.getValueAt(indice, 0).toString();
            String ptarjeta=tblAuditar.getValueAt(indice, 6).toString();
            
            String pstatus_control=cmbStatusSupervisor1.getSelectedItem().toString();
            
            objGestorV.salvar_Llamada_Auditada_E_I_SUPERVISOR(pfecha, ptarjeta, pstatus_control, 3);
        }
            llenaDatosLista(fecha_tabla);
            
        }catch (Exception ex){
            System.out.println(ex);
        }
        
        
        
    }//GEN-LAST:event_btnSalvaSalesAdminActionPerformed

    private void btnSalvaAfiliacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvaAfiliacionesActionPerformed
     try{
        if(tipo==1){
            int indice = tblAuditar.getSelectedRow();
            String pfecha = tblAuditar.getValueAt(indice, 0).toString();
            String pcod_cue= tblAuditar.getValueAt(indice, 1).toString();
            
            String pstatus_control=cmbStatusSupervisor2.getSelectedItem().toString();
            
            objGestorV.salvar_Llamada_Auditada_PPT_SUPERVISOR(pfecha, pcod_cue, pstatus_control,4);
        }
        if(tipo==2){
            int indice = tblAuditar.getSelectedRow();
            String pfecha = tblAuditar.getValueAt(indice, 0).toString();
            String ptarjeta=tblAuditar.getValueAt(indice, 4).toString();
            
            String pstatus_control=cmbStatusSupervisor2.getSelectedItem().toString();
            
            objGestorV.salvar_Llamada_Auditada_CAU_SUPERVISOR(pfecha, ptarjeta, pstatus_control, 4);
        }
            if(tipo==4){
            int indice = tblAuditar.getSelectedRow();
            String pfecha = tblAuditar.getValueAt(indice, 0).toString();
            String ptarjeta=tblAuditar.getValueAt(indice, 6).toString();
            
            String pstatus_control=cmbStatusSupervisor2.getSelectedItem().toString();
            
            objGestorV.salvar_Llamada_Auditada_E_I_SUPERVISOR(pfecha, ptarjeta, pstatus_control, 4);
        }
            llenaDatosLista(fecha_tabla);
            
        }catch (Exception ex){
            System.out.println(ex);
        }
    }//GEN-LAST:event_btnSalvaAfiliacionesActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarAuditoriaCedula;
    private javax.swing.JButton btnEnviarCD;
    private javax.swing.JButton btnSalvaAfiliaciones;
    private javax.swing.JButton btnSalvaAuditar;
    private javax.swing.JButton btnSalvaSalesAdmin;
    private javax.swing.JCheckBox chkRevision;
    private javax.swing.JComboBox cmbAuditor;
    private javax.swing.JComboBox cmbFechasAuditoria;
    private javax.swing.JComboBox cmbStatusAuditor;
    private javax.swing.JComboBox cmbStatusSupervisor1;
    private javax.swing.JComboBox cmbStatusSupervisor2;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel pnlControl;
    private javax.swing.JPanel pnlSupervisor;
    private javax.swing.JTable tblAuditar;
    private javax.swing.JTextField txtCedulaBuscada;
    private javax.swing.JTextField txtComentarioControl;
    // End of variables declaration//GEN-END:variables
}

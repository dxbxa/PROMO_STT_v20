
package CapaVisual;
import CapaLogica.A_Gestor_Logico;

public class A_Gestor_Visual{
    
    private A_Gestor_Logico objGestorL=new A_Gestor_Logico();
    private V_Login ventanaLogin;
    private V_Llamadas ventanaLlamadas;
    //private V_Estadisticas ventanaEstadisticas;
    private V_Menu ventanaMenu;
    private F_Cargos formularioCargos;
    private F_PPT formularioPA;
    private F_Poliza formularioPoliza;
    private F_Intrafinanciamiento formularioFinanciamiento;
    private A_Gestor_Visual objGestorV;
    private V_MenuQA ventanaMenuQA;
    private V_Auditar ventanaAuditar;
    private V_QA_CD ventanaCD;
    private V_SeleccionBase ventanaSeleccionBase;

    public static void main(String [] args){
        A_Gestor_Visual obj=new A_Gestor_Visual();
        obj.inicio(obj);
    }
    
    public void AuditarLlamadas(int pTipo,javax.swing.JFrame ventanaCaller){
        
        ventanaAuditar= new V_Auditar(objGestorV,pTipo);
        ventanaCaller.setVisible(false);
        ventanaAuditar.setVisible(true);
    }
    
    public void LlamadasCD(int pTipo,javax.swing.JFrame ventanaCaller){
        
        ventanaCD= new V_QA_CD(objGestorV,pTipo);
        ventanaCaller.setVisible(false);
        ventanaCD.setVisible(true);
    }
    
    private void Login_setDatosUsuario(String pUserName,String pClave)throws Exception{
        objGestorL.setDatosUsuarioIU(pUserName, pClave);    
    }
        
    public String[] Menu_getEstadisticas(String pCod_Usuario)throws Exception{
        return objGestorL.getEstadisticasIU(pCod_Usuario);
    }
    
    public void Menu_setContactoBusqueda(int tipoBusqueda, String valorBuscado, String pasesor)throws Exception{
        objGestorL.setDatosContactoIU(tipoBusqueda, valorBuscado, pasesor);
    }
    
    public String[] Menu_getBases(String pCod_Proyecto)throws Exception{
        String [][] datos=objGestorL.getDatosBaseIU(pCod_Proyecto);
        String [] resultado= new String[datos.length+1];
        resultado[0]="NINGUNA";
        for(int i=0;i<datos.length;i++){
            resultado[i+1]=datos[i][0]+" - "+datos[i][1]; 
    }
        return resultado;
    }
    
    public String[][] Menu_getAgendados(String pCod_usuario)throws Exception{
        return objGestorL.buscaSeguimientos(pCod_usuario);
    }
    
    public void Agenda_eliminaAgendado(String pcedula, String pCod_usuario)throws Exception{
        objGestorL.eliminaAgendado(pcedula, pCod_usuario);
    }
    
    public void Llamada_Agendar(String pcedula_contacto,String pnombre_contacto,String pcomentario,String pclave_otro)throws Exception{
        objGestorL.agendar(pcedula_contacto, pnombre_contacto, pcomentario, pclave_otro);
        ventanaMenu.actualizaSeguimientos();
    }
    
    public void Llamada_Guardar(String[][] pdatos)throws Exception{
        objGestorL.Guardar(pdatos);
    }
    
    public boolean Llamada_GuardarFormularioPA(String [] pdatos)throws Exception{
        
           objGestorL.GuardarFormularioPA(pdatos);

                
       return true;
    } 
    
    public boolean Llamada_GuardarFormularioPoliza(String [] pdatos)throws Exception{

      
           objGestorL.GuardarFormularioPoliza(pdatos);
       
        
       return true;
    } 
    
    public boolean Llamada_GuardarFormularioCAU(String [] pdatos)throws Exception{

  
           objGestorL.GuardarFormularioCAU(pdatos);
       
                
       return true;
    } 
    
    public String   getDatosCod_UsuarioIU(){
        return objGestorL.getDatosCod_UsuarioIU();
}
    public String   getDatosNombre_UsuarioIU(){
        return objGestorL.getDatosNombre_UsuarioIU();
}
    public String   getDatosCod_ProyectoIU(){
      return objGestorL.getDatosCod_ProyectoIU();
}
    
    public String   getDatosDesc_ProyectoIU(){
      return objGestorL.getDatosDesc_ProyectoIU();
}
    
    public String[] getDatosPromesasIU(){
        return objGestorL.getDatosPromesasIU();
}
    
    public String[] getDatosProductosIU(){
        return objGestorL.getDatosProductosIU();
}
    
    public String[] getDatosTiposProductoIU(String pdesc_Producto){
        return objGestorL.getDatosTiposProductoIU(pdesc_Producto);
}
    
    public String [] getContactos(){
        return objGestorL.getContacto();
    }
    
    public String [] getIdentificadores(){
        return objGestorL.getIdentificadores();
    }
    
    public String [] getTelefonos(){
        return objGestorL.getTelefonos();
    }    
    
    public String [] getResultados(){
        return objGestorL.getResultados();
    }
    
    public String [] getComentarios(){
        return objGestorL.getCOMENTARIOS();
    }
    
    public String[][] getFormularioPAresumen(String pcedula)throws Exception{
        return objGestorL.getFormulariosPA(pcedula);
    }
    public String[][] getFormularioCAUresumen(String pcedula)throws Exception{
        System.out.println("return GV");
        return objGestorL.getFormulariosCAU(pcedula);
    }
    
    public String getBaseSeleccionada(){
        return objGestorL.getBaseSeleccionada();
    }
    
    public void setDatosBaseIU(int BaseSeleccionada)throws Exception{
        objGestorL.setDatosBaseIU(BaseSeleccionada);
    }
    
    public void inicio(A_Gestor_Visual pobjGestorV){
        //inicializa objGestorV
        objGestorV=pobjGestorV;
        //muestra login
        ventanaLogin = new V_Login(objGestorV);
        objGestorV.ventanaLogin.setVisible(true);

    }
    
    public void btn_Ingresar(String pusuario, String pPassword)throws Exception{
        Login_setDatosUsuario(pusuario,pPassword);
        if(objGestorL.getDatosRol_UsuarioIU().equals("asesor")){
            ventanaMenu= new V_Menu(objGestorV);
            ventanaLogin.setVisible(false);
            ventanaMenu.setVisible(true);
        }
        if(objGestorL.getDatosRol_UsuarioIU().equals("QA")){
            ventanaMenuQA= new V_MenuQA(objGestorV);
            ventanaLogin.setVisible(false);
            ventanaMenuQA.setVisible(true);
        }
        
        
    }
    
    public void btn_ConsumirBase(){
        ventanaSeleccionBase= new V_SeleccionBase(objGestorV);
        ventanaMenu.setVisible(false);
        ventanaSeleccionBase.setVisible(true);
    }
    
    public void btn_Buscar(int tipoBusqueda,String valor){
        ventanaLlamadas= new V_Llamadas(objGestorV,tipoBusqueda,valor,2);
        ventanaMenu.setVisible(false);
        ventanaLlamadas.setVisible(true);
    }
        public void btn_BuscarsELECCION(int tipoBusqueda,String valor){
        ventanaLlamadas= new V_Llamadas(objGestorV,tipoBusqueda,valor,1);
        ventanaSeleccionBase.setVisible(false);
        ventanaLlamadas.setVisible(true);
    }
    
    public void btn_Estadisticas(){
        
    }
    
    public void btn_Regresar_a_Menu(javax.swing.JFrame ventanaCaller,int ppapa){
        //1 - seleccion
        //2 - menu
        if (ppapa==1){
                    ventanaCaller.setVisible(false);
                    ventanaSeleccionBase.llenaDatosLista();
                    ventanaSeleccionBase.setVisible(true); 
        }else{
                    ventanaCaller.setVisible(false);
                    ventanaMenu.setVisible(true); 
        }

    }
   
    public void btn_Regresar_a_MenuQA(javax.swing.JFrame ventanaCaller){
        ventanaCaller.setVisible(false);
        ventanaMenuQA.setVisible(true); 
    }
   
    public void btn_Regresar_a_Llamadas(javax.swing.JFrame ventanaCaller){
        ventanaCaller.setVisible(false);
        ventanaLlamadas.setVisible(true);
    }
    
    public void btn_EliminaAgendado(String cedula, String codUsuario)throws Exception{
        objGestorL.eliminaAgendado(cedula, codUsuario);
    }
    
    public void btn_Formulario(int tipoFormulario){
        switch(tipoFormulario)
        {
            case 0:
               formularioPA=new F_PPT(objGestorV);
               formularioPA.setVisible(true);
            break;

            case 1:
               formularioFinanciamiento=new F_Intrafinanciamiento(objGestorV);
               formularioFinanciamiento.setVisible(true);
            break;

            case 2:
               formularioFinanciamiento=new F_Intrafinanciamiento(objGestorV);
               formularioFinanciamiento.setVisible(true);
            break;
            
            case 3:
               formularioPoliza=new F_Poliza(objGestorV);
               formularioPoliza.setVisible(true);
            break;

            case 4:
                formularioCargos=new F_Cargos(objGestorV);
                formularioCargos.setVisible(true);
            break;
                
            case 5:
                formularioPA=new F_PPT(objGestorV);
                formularioPA.setVisible(true);
            break;

        default:

        };
        
        
        
        
        
    
    }
    
    public boolean getValidacionClave(String clave)throws Exception{
        return objGestorL.getValidacionClave(clave);
    }
     
    public void guardaFormularioFinanciamientosV(String pproducto,String ptipo,String pcod_usuario,String ptarjeta,String pnombre_contacto,String pcedula,String pmonto_d,String pmoneda_d,String pcomision,String ptasa,String pseguro,String psinpe,String ptelefono,String pbanco,String pmoneda_banco,String pvencimiento,String pcuota,String pplazo)throws Exception{
        objGestorL.guardaFormularioFinanciamientosL(pproducto, ptipo, pcod_usuario, ptarjeta, pnombre_contacto, pcedula, pmonto_d, pmoneda_d, pcomision, ptasa, pseguro, psinpe, ptelefono, pbanco, pmoneda_banco, pvencimiento, pcuota, pplazo);
    }
     
    public String[][] getResumenFinanciamiento(String pasesor,String pcedula)throws Exception{
         return objGestorL.getResumenFinanciamiento(pasesor, pcedula);
     }
    public String[][] getDatosAuditarPPT(String pfecha)throws Exception{
        return objGestorL.AuditarPPT(pfecha);
    }
    public String[] getFechasPPT()throws Exception{
        return objGestorL.getFechasPPT();
    }
    public String[][] traer_Todo_CD_PPT()throws Exception{
        return objGestorL.traer_Todo_CD_PPT();
    }
    public void enviar_CD_PPT(String phora_venta,String pcodCue)throws Exception{
        objGestorL.enviar_CD_PPT(phora_venta, pcodCue);
    }
    public void salvar_Llamada_Auditada_PPT(String pfecha,String pcod_cue,String previsada_por,String pstatus_control,String pdevolucion,String pregreso)throws Exception{
        objGestorL.salvar_Llamada_Auditada_PPT(pfecha, pcod_cue, previsada_por, pstatus_control, pdevolucion, pregreso);
    }
    public void reset_CD_PPT()throws Exception{
        objGestorL.reset_CD_PPT();
    }
 
    
    public String[][] getDatosAuditarCAU(String pfecha)throws Exception{
        return objGestorL.AuditarCAU(pfecha);
    }
    public String[] getFechasCAU()throws Exception{
        return objGestorL.getFechasCAU();
    }
    public String[][] traer_Todo_CD_CAU()throws Exception{
        return objGestorL.traer_Todo_CD_CAU();
    }
    public void enviar_CD_CAU(String phora_venta,String pcodCue)throws Exception{
        objGestorL.enviar_CD_CAU(phora_venta, pcodCue);
    }
    public void salvar_Llamada_Auditada_CAU(String pfecha,String pcod_cue,String previsada_por,String pstatus_control,String pdevolucion,String pregreso)throws Exception{
        objGestorL.salvar_Llamada_Auditada_CAU(pfecha, pcod_cue, previsada_por, pstatus_control, pdevolucion, pregreso);
    }
    public void reset_CD_CAU()throws Exception{
        objGestorL.reset_CD_CAU();
    }
    
    public String[][] getBaseAsesor()throws Exception{
        return objGestorL.getBaseAsesor();
    }
    
    
    public String[][] getAuditarIntraExtra(String pfecha)throws Exception{
        return objGestorL.getAuditarIntraExtra(pfecha);
    }
    
    public String[] buscaFechasFinanc()throws Exception{
        return objGestorL.buscaFechasFinanc();
    }
    public void setCD_FINANC(String phora_venta,String ptarjeta)throws Exception{
        objGestorL.setCD_FINANC(phora_venta, ptarjeta);
    }
    
      public void salvar_Llamada_Auditada_E_I(String pfecha,String ptarjeta,String previsada_por,String pstatus_control,String pdevolucion,String pregreso)throws Exception{
        objGestorL.salvar_Llamada_Auditada_E_I(pfecha, ptarjeta, previsada_por, pstatus_control, pdevolucion, pregreso);
    }  
    public void reset_CD_FINANC()throws Exception{
        objGestorL.reset_CD_FINANC();
    }
    
    public String[][] getCD_E_I()throws Exception{
        return objGestorL.getCD_E_I();
    }
    
    public boolean validaDuplicadosPPT_Alerta(String ptarjeta)throws Exception{
return objGestorL.validaDuplicadosPPT_Alerta(ptarjeta);    
    }
    
    public boolean validaDuplicadosFinanciamiento(String ptarjeta, String pproducto)throws Exception{
return objGestorL.validaDuplicadosFinanciamiento(ptarjeta, pproducto);     
    }
    
    public boolean validaDuplicadosCAU(String ptarjeta, String pproducto, String pIdProducto)throws Exception{
return objGestorL.validaDuplicadosCAU(ptarjeta, pproducto, pIdProducto);    
    }
    
    public String   getNombre_Base_Contacto(){
      return objGestorL.getNombre_Base_Contacto();
}
    
}

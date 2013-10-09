
package A_Ventas.CapaLogica;
import A_Ventas.CapaBD.A_ConectorBD;

public class A_GestorLogico {
    
    private A_ConectorBD objConexion=new A_ConectorBD();
    private A_Usuario objUsuario;
    private A_Base objBase;
    private A_Contacto objContacto;
    
    // <editor-fold defaultstate="collapsed" desc="METODOS del OBJETO USUARIO, PROYECTO, PROMESA, PRODUCTO, TIPO Y (BASE)">
    public void setDatosUsuarioIU(String pCod_Usuario, String pClave_Usuario)throws Exception{
            try{
                String[] datos=objConexion.getDatosUsuario(pCod_Usuario, pClave_Usuario);
                objUsuario = new A_Usuario(pCod_Usuario,datos[0],datos[1],datos[2],datos[3],pClave_Usuario);
                A_Proyecto objProyecto = setDatosProyecto(datos[4],datos[5]);
                objUsuario.setPROYECTO(objProyecto);
            }catch(Exception ex){
                if (ex.toString().equals("java.lang.NullPointerException")){
                    throw new Exception("Contraseña incorrecta");
                }else{
                    throw ex;
                }
            }
        }
    
      private A_Proyecto  setDatosProyecto(String pcod_Proyecto, String pDesc_Proyecto)throws Exception{
            A_Proyecto objProyecto;

                objProyecto=new A_Proyecto(pcod_Proyecto,pDesc_Proyecto);
                A_Promesa[] arrayPromesas=setDatosPromesa(pcod_Proyecto);
                Producto[] arrayProductos=setDatosProductos(pcod_Proyecto);
                objProyecto.setPROMESAS(arrayPromesas);
                objProyecto.setPRODUCTOS(arrayProductos);

            return objProyecto;
        }
      private A_Promesa[] setDatosPromesa(String pcod_Proyecto)throws Exception{
            A_Promesa[] arrayPromesas;
                String[][] datos=objConexion.getDatosPromesas(pcod_Proyecto);
                arrayPromesas = new A_Promesa[datos.length];
                for(int i=0;i<datos.length;i++){
                    A_Promesa tmp = new A_Promesa(datos[i][0],datos[i][1]);
                    arrayPromesas[i]=tmp;
                }
           return arrayPromesas;
        }
      private Producto[]  setDatosProductos(String pcod_Proyecto)throws Exception{
            Producto[] arrayProductos;
                String[] datos=objConexion.getDatosProducto(pcod_Proyecto);
                arrayProductos = new Producto[datos.length];
                for(int i=0;i<datos.length;i++){
                    Producto tmp = new Producto(datos[i]);
                    A_Tipo[] arrayTiposVenta=setDatosTipoProducto(datos[i]);
                    tmp.setTIPOS(arrayTiposVenta);
                    arrayProductos[i]=tmp;
                }
           return arrayProductos;
        } 
      private A_Tipo[]    setDatosTipoProducto(String pdesc_Producto)throws Exception{
            A_Tipo[] arrayTipoProducto;
                String[] datos=objConexion.getDatosTipoProducto(pdesc_Producto);
                arrayTipoProducto = new A_Tipo[datos.length];
                for(int i=0;i<datos.length;i++){
                    A_Tipo tmp = new A_Tipo(datos[i]);
                    arrayTipoProducto[i]=tmp;
                }
           return arrayTipoProducto;
        } 
      
    public String   getDatosCod_UsuarioIU(){
        return objUsuario.getUSER_NAME();
}
    public String   getDatosNombre_UsuarioIU(){
        return objUsuario.getNOMBRE_USUARIO();
}
    public String   getDatosRol_UsuarioIU(){
        return objUsuario.getROL_USUARIO();
}
    
    
    public String   getDatosCod_ProyectoIU(){
      return objUsuario.getPROYECTO().getCOD_PROYECTO();
}
    public String   getNombre_Base_Contacto(){
      return objContacto.getNOMBRE_BASE();
}
    public String   getDatosDesc_ProyectoIU(){
      return objUsuario.getPROYECTO().getDESC_PROYECTO();
}
    public String[] getDatosPromesasIU(){
      A_Promesa[] promesasObj=objUsuario.objProyecto.getPROMESAS();
            String[] promesasString=new String[promesasObj.length];
            for(int i=0;i<promesasObj.length;i++){
                promesasString[i]=promesasObj[i].getDESC_PROMESA();
            }
            return promesasString;
}
    public String[] getDatosProductosIU(){
      Producto[] productosObj=objUsuario.objProyecto.getPRODUCTOS();
            String[] productosString=new String[productosObj.length];
            for(int i=0;i<productosObj.length;i++){
                productosString[i]=productosObj[i].getDESC_PRODUCTO();
            }
            return productosString;
}
    public String[] getDatosTiposProductoIU(String pdesc_Producto){
       Producto[] productosObj=objUsuario.objProyecto.getPRODUCTOS();
            String[] tiposVentaString=null;
            for(int i=0;i<productosObj.length;i++){
                if(productosObj[i].getDESC_PRODUCTO().equals(pdesc_Producto)){
                    A_Tipo[] tiposVentaObj=productosObj[i].getTIPOS();
                    tiposVentaString=new String[tiposVentaObj.length];
                        for(int j=0;j<tiposVentaObj.length;j++){
                            tiposVentaString[j]=tiposVentaObj[j].getDESC_TIPO();
                        }
                }
            }
            return tiposVentaString;
}
    
    public String[][] getDatosBaseIU(String pCod_Proyecto)throws Exception{
        String[][] datos=objConexion.getDatosBase(pCod_Proyecto);
        return datos;
    }
    public void   setDatosBaseIU(int baseSeleccionada)throws Exception{
        String[][] datos=getDatosBaseIU(objUsuario.getPROYECTO().getCOD_PROYECTO());

        String nombreBase=datos[baseSeleccionada][0];
        int registros=Integer.parseInt(datos[baseSeleccionada][1]);
        objBase = new A_Base(nombreBase,registros);
    }
    public String getBaseSeleccionada(){
        return objBase.getNOMBRE_BASE();
    }
    // </editor-fold>//
            
    // <editor-fold defaultstate="collapsed" desc="METODOS del OBJETO CONTACTO">
    public void setDatosContactoIU(int tipoBusqueda, String valorBuscado, String pasesor)throws Exception{

        String[] datos = objConexion.busquedaContacto(objUsuario.getUSER_NAME(),tipoBusqueda,objUsuario.getPROYECTO().getCOD_PROYECTO(),valorBuscado,pasesor);
        objContacto = new A_Contacto(datos[0],datos[1],datos[2],datos[3],datos[4]);
          A_Telefono[] arrayTelefonos = setDatosTelefonos(datos[0]);
          A_Identificador[] arrayIdentificadores = setDatosIdentificadores(datos[0]);
          
          objContacto.setTELEFONOS(arrayTelefonos);
          objContacto.setIDENTIFICADORES(arrayIdentificadores);
    }
    
        private A_Identificador[] setDatosIdentificadores(String PCEDULA_CONTACTO)throws Exception{
               String[][] datos=objConexion.getDatosIdentificadores(PCEDULA_CONTACTO);
               A_Identificador[] arrayIdentificadores = new A_Identificador[datos.length];
               for(int i=0;i<datos.length;i++){
                A_Identificador tmp = new A_Identificador(datos[i][0],datos[i][1]);
                arrayIdentificadores[i]=tmp;
               }
           return arrayIdentificadores;
        }
        private A_Telefono[] setDatosTelefonos(String PCEDULA_CONTACTO)throws Exception{

           String[][] datos=objConexion.getDatosTelefonos(PCEDULA_CONTACTO);
           A_Telefono[] arrayTelefonos = new A_Telefono[datos.length];
           for(int i=0;i<datos.length;i++){
                arrayTelefonos[i]=new A_Telefono(datos[i][0],datos[i][1],datos[i][2],datos[i][3]);
           }
       return arrayTelefonos;
    }
        
    public String[] getContacto(){
        String[] datosContacto={objContacto.getCEDULA(),objContacto.getNOMBRE_CONTACTO(),objContacto.getCOD_CUENTA(),objContacto.getTARJETA(),objContacto.getNOMBRE_BASE()};
        return datosContacto;
    }
    public String[] getIdentificadores(){
        A_Identificador[] arrayIdentificadores=objContacto.getIDENTIFICADORES();
        String[] identificadoresString=new String[arrayIdentificadores.length];
        for(int i=0;i<arrayIdentificadores.length;i++){
                identificadoresString[i]=arrayIdentificadores[i].getCOD_IDENTIFICADOR()+": "+arrayIdentificadores[i].getDESC_IDENTIFICADOR();  
        }
        return identificadoresString;
    }
    public String[] getTelefonos(){

        A_Telefono[] arrayTelefonos=objContacto.getTELEFONOS();
        String[] TelefonosString=new String[arrayTelefonos.length];
        for(int i=0;i<arrayTelefonos.length;i++){
                TelefonosString[i]=arrayTelefonos[i].getNUMERO_TELEFONO();  
        }
        return TelefonosString;
    }
    public String[] getResultados(){
        A_Telefono[] arrayResultados=objContacto.getTELEFONOS();
        String[] ResultadosString=new String[arrayResultados.length];
        for(int i=0;i<arrayResultados.length;i++){
                ResultadosString[i]=arrayResultados[i].getDESC_PROMESA();  
        }
        return ResultadosString;
    }
    public String[] getCOMENTARIOS(){
        A_Telefono[] arrayResultados=objContacto.getTELEFONOS();
        String[] ResultadosString=new String[arrayResultados.length];
        for(int i=0;i<arrayResultados.length;i++){
                ResultadosString[i]=arrayResultados[i].getCOMENTARIO();  
        }
        return ResultadosString;
    }
    // </editor-fold>//
    
    // <editor-fold defaultstate="collapsed" desc="METODOS SEGUIMIENTO">
    
    
    public void agendar(String pcedula_contacto,String pnombre_contacto,String pcomentario,String pclave_otro)throws Exception{
       objConexion.asignarSeguimiento(pcedula_contacto, pnombre_contacto, pcomentario,objUsuario.getUSER_NAME(),pclave_otro);
    } 
    public String[][] buscaSeguimientos(String pCod_usuario)throws Exception{
        String [][] seguimientos=objConexion.buscaSeguimientos(pCod_usuario);
        return seguimientos;
    }
    
    
    
    
    
    
    public String[] getFechasPPT()throws Exception{
        return objConexion.buscaFechasPPT();
    }
    
    public String[][] AuditarPPT(String pfecha)throws Exception{
        String [][] auditar=objConexion.getAuditarPPT(pfecha);
        return auditar;
    }
    public String[][] AuditarPPT_X_cedula(String pcedula)throws Exception{
        String [][] auditar=objConexion.getAuditarPPT_X_cedula(pcedula);
        return auditar;
    }
    
    public String[][] traer_Todo_CD_PPT(String pfecha)throws Exception{
        return objConexion.getCD_PPT(pfecha);
    }
    public void enviar_CD_PPT(String phora_venta,String pcodCue)throws Exception{
        objConexion.setCD_PPT(phora_venta, pcodCue);
    }
    public void salvar_Llamada_Auditada_PPT(String pfecha,String pcod_cue,String previsada_por,String pstatus_control,String pcomentario,int ptipo)throws Exception{
        objConexion.salvaAuditoriaPPT(pfecha, pcod_cue, previsada_por, pstatus_control, pcomentario,ptipo);
    }
    public void salvar_Llamada_Auditada_CAU(String pfecha,String ptarjeta,String previsada_por,String pstatus_control,String pcomentario,int ptipo)throws Exception{
        objConexion.salvaAuditoriaCAU(pfecha, ptarjeta, previsada_por, pstatus_control, pcomentario, ptipo);
    }
    public void salvar_Llamada_Auditada_E_I(String pfecha,String ptarjeta,String previsada_por,String pstatus_control,String pcomentario,int ptipo)throws Exception{
        objConexion.salvar_Llamada_Auditada_E_I(pfecha, ptarjeta, previsada_por, pstatus_control, pcomentario, ptipo);
    }
    
    public void reset_CD_PPT()throws Exception{
        objConexion.reset_cd_ppt();
    }
    public void setCD_FINANC(String phora_venta,String ptarjeta)throws Exception{
        objConexion.setCD_FINANC(phora_venta, ptarjeta);
    }
    public String[] getFechasCAU()throws Exception{
        return objConexion.buscaFechasCAU();
    }
    public String[][] AuditarCAU(String pfecha)throws Exception{
        String [][] auditar=objConexion.getAuditarCAU(pfecha);
        return auditar;
    }
    public String[][] AuditarCAU_X_cedula(String pcedula)throws Exception{
        String [][] auditar=objConexion.getAuditarCAU_X_CEDULA(pcedula);
        return auditar;
    }
    public String[][] traer_Todo_CD_CAU(String pfecha)throws Exception{
        return objConexion.getCD_CAU(pfecha);
    }
    
    public String[][] getCD_E_I(String pfecha)throws Exception{
        return objConexion.getCD_E_I(pfecha);
    }
    
    
    public void enviar_CD_CAU(String phora_venta,String ptarjeta)throws Exception{
        objConexion.setCD_CAU(phora_venta, ptarjeta);
    }
    public void reset_CD_CAU()throws Exception{
        objConexion.reset_cd_CAU();
    }
    public void reset_CD_FINANC()throws Exception{
        objConexion.reset_cd_FINANC();
    }
    
    
    public String[][] getBaseAsesor()throws Exception{
        String [][] datos=objConexion.getBaseAsesor(objUsuario.getUSER_NAME());
        return datos;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public void eliminaAgendado(String pcedula, String pCod_usuario)throws Exception{
        objConexion.eliminaAgendado(pcedula, pCod_usuario);
    }
    // </editor-fold>//
    
    // <editor-fold defaultstate="collapsed" desc="METODOS ESTADISTICAS">
    public String[] getEstadisticasIU(String pCod_Usuario)throws Exception{
        return null;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="METODOS GUARDAR">
    public boolean Guardar(String [][] pdatos)throws Exception{
       String fecha=objConexion.getFecha();
        
       for(int i=0;i<pdatos[0].length;i++){
           objConexion.GuardarLlamada(pdatos[0][i], pdatos[1][i], pdatos[2][i], pdatos[3][i], objUsuario.getUSER_NAME(),fecha);
       }
       return true;
    } 
    
    public boolean GuardarFormularioPA(String [] pdatos)throws Exception{
        
           objConexion.GuardarFormularioPA(pdatos[0],	pdatos[1],	pdatos[2],	pdatos[3],	pdatos[4],	pdatos[5],	pdatos[6],	pdatos[7],	pdatos[8]);

                
       return true;
    } 
    
    public boolean GuardarFormularioPoliza(String [] pdatos)throws Exception{

      
           objConexion.GuardarFormularioPoliza(pdatos[0],	pdatos[1],	pdatos[2],	pdatos[3],	pdatos[4],	pdatos[5],	pdatos[6],	pdatos[7],	pdatos[8],	pdatos[9],	pdatos[10],	pdatos[11],	pdatos[12],	pdatos[13],	pdatos[14],	pdatos[15],	pdatos[16],	pdatos[17],	pdatos[18],	pdatos[19],	pdatos[20],	pdatos[21],pdatos[22],	pdatos[23]);
       
        
       return true;
    } 
    
    public boolean GuardarFormularioCAU(String [] pdatos)throws Exception{

  
           objConexion.GuardarFormularioCAU(pdatos[0],	pdatos[1],	pdatos[2],	pdatos[3],	pdatos[4],	pdatos[5],	pdatos[6],	pdatos[7],	pdatos[8],	pdatos[9]);
       
                
       return true;
    } 
    
    public String[][] getFormulariosPA(String pcedula)throws Exception{
        return objConexion.buscaFormulariosPA(pcedula);
    }
    public String[][] getFormulariosCAU(String pcedula)throws Exception{
        System.out.println("return GL");
        return objConexion.buscaFormulariosCAU(pcedula);
    }
    
    public boolean getValidacionClave(String clave)throws Exception{
        return objConexion.validaClavesupervisor(clave);
    }
    
    public void guardaFormularioFinanciamientosL(String pproducto,String ptipo,String pcod_usuario,String ptarjeta,String pnombre_contacto,String pcedula,String pmonto_d,String pmoneda_d,String pcomision,String ptasa,String pseguro,String psinpe,String ptelefono,String pbanco,String pmoneda_banco,String pvencimiento,String pcuota,String pplazo)throws Exception{
        objConexion.guardaFormularioFinanciamientos(pproducto, ptipo, pcod_usuario, ptarjeta, pnombre_contacto, pcedula, pmonto_d, pmoneda_d, pcomision, ptasa, pseguro, psinpe, ptelefono, pbanco, pmoneda_banco, pvencimiento, pcuota, pplazo);
    }
    public String[][] getResumenFinanciamiento(String pasesor,String pcedula)throws Exception{
        return objConexion.getResumenFinanciamiento(pasesor, pcedula);
    }
    
    public String[][] getAuditarIntraExtra(String pfecha)throws Exception{
        return objConexion.getAuditarIntraExtra(pfecha);
    }
    public String[][] getAuditarIntraExtra_X_cedula(String pcedula)throws Exception{
        return objConexion.getAuditarIntraExtra_X_CEDULA(pcedula);
    }
    public String[] buscaFechasFinanc()throws Exception{
        return objConexion.buscaFechasFinanc();
    }
    
    // </editor-fold>
    
    public boolean validaDuplicadosPPT_Alerta(String ptarjeta)throws Exception{
return objConexion.validaDuplicadosPPT_Alerta(ptarjeta);    
    }
    
    public boolean validaDuplicadosFinanciamiento(String ptarjeta, String pproducto)throws Exception{
return objConexion.validaDuplicadosFinanciamiento(ptarjeta, pproducto);     
    }
    
    public boolean validaDuplicadosCAU(String ptarjeta, String pproducto, String pIdProducto)throws Exception{
return objConexion.validaDuplicadosCAU(ptarjeta, pproducto, pIdProducto);   
    }
    
    
    public void salvar_Llamada_Auditada_PPT_SUPERVISOR(String pfecha,String pcod_cue,String pstatus_control,int ptipo)throws Exception{
        objConexion.salvaAuditoriaPPT_SUPERVISOR(pfecha, pcod_cue, pstatus_control, ptipo);
    }
    public void salvar_Llamada_Auditada_CAU_SUPERVISOR(String pfecha,String ptarjeta,String pstatus_control,int ptipo)throws Exception{
        objConexion.salvaAuditoriaCAU_SUPERVISOR(pfecha, ptarjeta, pstatus_control, ptipo);
    }
    public void salvar_Llamada_Auditada_E_I_SUPERVISOR(String pfecha,String ptarjeta,String pstatus_control,int ptipo)throws Exception{
        objConexion.salvar_Llamada_Auditada_E_I_SUPERVISOR(pfecha, ptarjeta, pstatus_control, ptipo);
    }
    

}
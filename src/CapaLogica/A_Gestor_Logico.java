
package CapaLogica;
import CapaBD.BD_ConectorBD;

public class A_Gestor_Logico {
    
    private BD_ConectorBD objConexion=new BD_ConectorBD();
    private U_Usuario objUsuario;
    private B_Base objBase;
    private C_Contacto objContacto;
           
    // <editor-fold defaultstate="collapsed" desc="METODOS del OBJETO USUARIO, PROYECTO, PROMESA, PRODUCTO, TIPO Y (BASE)">
    public void setDatosUsuarioIU(String pCod_Usuario, String pClave_Usuario)throws Exception{
            try{
                String[] datos=objConexion.getDatosUsuario(pCod_Usuario, pClave_Usuario);
                objUsuario = new U_Usuario(pCod_Usuario,datos[0],datos[1],datos[2],datos[3],pClave_Usuario);
                P_Proyecto objProyecto = setDatosProyecto(datos[4],datos[5]);
                objUsuario.setPROYECTO(objProyecto);
            }catch(Exception ex){
                if (ex.toString().equals("java.lang.NullPointerException")){
                    throw new Exception("Contraseña incorrecta");
                }else{
                    throw ex;
                }
            }
        }
    
      private P_Proyecto  setDatosProyecto(String pcod_Proyecto, String pDesc_Proyecto)throws Exception{
            P_Proyecto objProyecto;

                objProyecto=new P_Proyecto(pcod_Proyecto,pDesc_Proyecto);
                P_Promesa[] arrayPromesas=setDatosPromesa(pcod_Proyecto);
                Producto[] arrayProductos=setDatosProductos(pcod_Proyecto);
                objProyecto.setPROMESAS(arrayPromesas);
                objProyecto.setPRODUCTOS(arrayProductos);

            return objProyecto;
        }
      private P_Promesa[] setDatosPromesa(String pcod_Proyecto)throws Exception{
            P_Promesa[] arrayPromesas;
                String[][] datos=objConexion.getDatosPromesas(pcod_Proyecto);
                arrayPromesas = new P_Promesa[datos.length];
                for(int i=0;i<datos.length;i++){
                    P_Promesa tmp = new P_Promesa(datos[i][0],datos[i][1]);
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
                    P_Tipo[] arrayTiposVenta=setDatosTipoProducto(datos[i]);
                    tmp.setTIPOS(arrayTiposVenta);
                    arrayProductos[i]=tmp;
                }
           return arrayProductos;
        } 
      private P_Tipo[]    setDatosTipoProducto(String pdesc_Producto)throws Exception{
            P_Tipo[] arrayTipoProducto;
                String[] datos=objConexion.getDatosTipoProducto(pdesc_Producto);
                arrayTipoProducto = new P_Tipo[datos.length];
                for(int i=0;i<datos.length;i++){
                    P_Tipo tmp = new P_Tipo(datos[i]);
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
    public String   getDatosDesc_ProyectoIU(){
      return objUsuario.getPROYECTO().getDESC_PROYECTO();
}
    public String[] getDatosPromesasIU(){
      P_Promesa[] promesasObj=objUsuario.objProyecto.getPROMESAS();
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
                    P_Tipo[] tiposVentaObj=productosObj[i].getTIPOS();
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
        objBase = new B_Base(nombreBase,registros);
    }
    public String getBaseSeleccionada(){
        return objBase.getNOMBRE_BASE();
    }
    // </editor-fold>//
            
    // <editor-fold defaultstate="collapsed" desc="METODOS del OBJETO CONTACTO">
    public void setDatosContactoIU(int tipoBusqueda, String valorBuscado, String pasesor)throws Exception{

        String[] datos = objConexion.busquedaContacto(objUsuario.getUSER_NAME(),tipoBusqueda,objUsuario.getPROYECTO().getCOD_PROYECTO(),valorBuscado,pasesor);
        objContacto = new C_Contacto(datos[0],datos[1],datos[2],datos[3],datos[4]);
          C_Telefono[] arrayTelefonos = setDatosTelefonos(datos[0]);
          C_Identificador[] arrayIdentificadores = setDatosIdentificadores(datos[0]);
          
          objContacto.setTELEFONOS(arrayTelefonos);
          objContacto.setIDENTIFICADORES(arrayIdentificadores);
    }
    
        private C_Identificador[] setDatosIdentificadores(String PCEDULA_CONTACTO)throws Exception{
               String[][] datos=objConexion.getDatosIdentificadores(PCEDULA_CONTACTO);
               C_Identificador[] arrayIdentificadores = new C_Identificador[datos.length];
               for(int i=0;i<datos.length;i++){
                C_Identificador tmp = new C_Identificador(datos[i][0],datos[i][1]);
                arrayIdentificadores[i]=tmp;
               }
           return arrayIdentificadores;
        }
        private C_Telefono[] setDatosTelefonos(String PCEDULA_CONTACTO)throws Exception{

           String[][] datos=objConexion.getDatosTelefonos(PCEDULA_CONTACTO);
           C_Telefono[] arrayTelefonos = new C_Telefono[datos.length];
           for(int i=0;i<datos.length;i++){
                arrayTelefonos[i]=new C_Telefono(datos[i][0],datos[i][1],datos[i][2],datos[i][3]);
           }
       return arrayTelefonos;
    }
        
    public String[] getContacto(){
        String[] datosContacto={objContacto.getCEDULA(),objContacto.getNOMBRE_CONTACTO(),objContacto.getCOD_CUENTA(),objContacto.getTARJETA(),objContacto.getNOMBRE_BASE()};
        return datosContacto;
    }
    public String[] getIdentificadores(){
        C_Identificador[] arrayIdentificadores=objContacto.getIDENTIFICADORES();
        String[] identificadoresString=new String[arrayIdentificadores.length];
        for(int i=0;i<arrayIdentificadores.length;i++){
                identificadoresString[i]=arrayIdentificadores[i].getCOD_IDENTIFICADOR()+": "+arrayIdentificadores[i].getDESC_IDENTIFICADOR();  
        }
        return identificadoresString;
    }
    public String[] getTelefonos(){

        C_Telefono[] arrayTelefonos=objContacto.getTELEFONOS();
        String[] TelefonosString=new String[arrayTelefonos.length];
        for(int i=0;i<arrayTelefonos.length;i++){
                TelefonosString[i]=arrayTelefonos[i].getNUMERO_TELEFONO();  
        }
        return TelefonosString;
    }
    public String[] getResultados(){
        C_Telefono[] arrayResultados=objContacto.getTELEFONOS();
        String[] ResultadosString=new String[arrayResultados.length];
        for(int i=0;i<arrayResultados.length;i++){
                ResultadosString[i]=arrayResultados[i].getDESC_PROMESA();  
        }
        return ResultadosString;
    }
    public String[] getCOMENTARIOS(){
        C_Telefono[] arrayResultados=objContacto.getTELEFONOS();
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
    public String[][] traer_Todo_CD_PPT()throws Exception{
        return objConexion.getCD_PPT();
    }
    public void enviar_CD_PPT(String phora_venta,String pcodCue)throws Exception{
        objConexion.setCD_PPT(phora_venta, pcodCue);
    }
    public void salvar_Llamada_Auditada_PPT(String pfecha,String pcod_cue,String previsada_por,String pstatus_control,String pdevolucion,String pregreso)throws Exception{
        objConexion.salvaAuditoriaPPT(pfecha, pcod_cue, previsada_por, pstatus_control, pdevolucion, pregreso);
    }
    public void salvar_Llamada_Auditada_E_I(String pfecha,String ptarjeta,String previsada_por,String pstatus_control,String pdevolucion,String pregreso)throws Exception{
        objConexion.salvar_Llamada_Auditada_E_I(pfecha, ptarjeta, previsada_por, pstatus_control, pdevolucion, pregreso);
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
    public String[][] traer_Todo_CD_CAU()throws Exception{
        return objConexion.getCD_CAU();
    }
    
    public String[][] getCD_E_I()throws Exception{
        return objConexion.getCD_E_I();
    }
    
    
    public void enviar_CD_CAU(String phora_venta,String ptarjeta)throws Exception{
        objConexion.setCD_CAU(phora_venta, ptarjeta);
    }
    public void salvar_Llamada_Auditada_CAU(String pfecha,String ptarjeta,String previsada_por,String pstatus_control,String pdevolucion,String pregreso)throws Exception{
        objConexion.salvaAuditoriaCAU(pfecha, ptarjeta, previsada_por, pstatus_control, pdevolucion, pregreso);
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
       for(int i=0;i<pdatos[0].length;i++){
           objConexion.GuardarLlamada(pdatos[0][i], pdatos[1][i], pdatos[2][i], pdatos[3][i], objUsuario.getUSER_NAME());
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
    public String[] buscaFechasFinanc()throws Exception{
        return objConexion.buscaFechasFinanc();
    }
    
    // </editor-fold>

}
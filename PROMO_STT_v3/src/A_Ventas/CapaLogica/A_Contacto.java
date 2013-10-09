
package A_Ventas.CapaLogica;

class A_Contacto {
    
    // <editor-fold defaultstate="collapsed" desc="DECLARACION DE LOS ATRIBUTOS DEL OBJETO">
        private String CEDULA;
        private String NOMBRE_CONTACTO;
        private String COD_CUENTA;
        private String Tarjeta;
        private String NOMBRE_BASE;
        
        private A_Telefono[] arrayTelefonos;
        private A_Identificador[] arrayIdentificadores;
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="CONSTRUCTORES DEL OBJETO">

    public A_Contacto(String pCEDULA,String pNOMBRE_CONTACTO,String pCOD_CUENTA,String pTarjeta,String pNOMBRE_BASE){
        CEDULA=pCEDULA;
        NOMBRE_CONTACTO=pNOMBRE_CONTACTO;
        COD_CUENTA=pCOD_CUENTA;
        Tarjeta=pTarjeta;
        NOMBRE_BASE=pNOMBRE_BASE;

    }

    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="PROPIEDADES DEL OBJETO">

    // <editor-fold defaultstate="collapsed" desc="SETs DEL OBJETO">
    public void setCEDULA( String pCEDULA){CEDULA=pCEDULA;}
    public void setNOMBRE_CONTACTO( String pNOMBRE_CONTACTO){NOMBRE_CONTACTO=pNOMBRE_CONTACTO;}
    public void setCOD_CUENTA( String pCOD_CUENTA){COD_CUENTA=pCOD_CUENTA;}
    public void setTARJETA( String pCUENTA){Tarjeta=pCUENTA;}
    public void setNOMBRE_BASE( String pNOMBRE_BASE){NOMBRE_BASE=pNOMBRE_BASE;}
    
    public void setTELEFONOS(A_Telefono[] parrayTelefonos){arrayTelefonos=parrayTelefonos;}
    public void setIDENTIFICADORES(A_Identificador[] parrayIdentificadores){arrayIdentificadores=parrayIdentificadores;}
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="GETs DEL OBJETO">
    public String getCEDULA(){return CEDULA;}
    public String getNOMBRE_CONTACTO(){return NOMBRE_CONTACTO;}
    public String getCOD_CUENTA(){return COD_CUENTA;}
    public String getTARJETA(){return Tarjeta;}
    public String getNOMBRE_BASE(){return NOMBRE_BASE;}
    
    public A_Telefono[] getTELEFONOS(){return arrayTelefonos;}
    public A_Identificador[] getIDENTIFICADORES(){return arrayIdentificadores;}
    // </editor-fold>

    // </editor-fold>

}


package A_Ventas.CapaLogica;

class A_Usuario {

    // <editor-fold defaultstate="collapsed" desc="DECLARACION DE LOS ATRIBUTOS DEL OBJETO">
        private String COD_USUARIO;
        private String CEDULA_USUARIO;
        private String NOMBRE_USUARIO;
        private String EMAIL_USUARIO;
        private String ROL_USUARIO;
        private String CLAVE_USUARIO;
        
        A_Proyecto objProyecto;
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="CONSTRUCTORES DEL OBJETO">

    public A_Usuario(String pCOD_USUARIO,String pCEDULA,String pNOMBRE_USUARIO,	String pEMAIL_USUARIO,String pROL_USUARIO,String pCLAVE_USUARIO){
        COD_USUARIO=pCOD_USUARIO;
        CEDULA_USUARIO=pCEDULA;
        NOMBRE_USUARIO=pNOMBRE_USUARIO;
        EMAIL_USUARIO=pEMAIL_USUARIO;
        ROL_USUARIO=pROL_USUARIO;
        CLAVE_USUARIO=pCLAVE_USUARIO;
    }

    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="PROPIEDADES DEL OBJETO">

    // <editor-fold defaultstate="collapsed" desc="SETs DEL OBJETO">
        public void setUSER_NAME( String pUSER_NAME){COD_USUARIO=pUSER_NAME;}
        public void setCEDULA( String pCEDULA){CEDULA_USUARIO=pCEDULA;}
        public void setNOMBRE_USUARIO( String pNOMBRE_USUARIO){NOMBRE_USUARIO=pNOMBRE_USUARIO;}
        public void setEMAIL_USUARIO( String pEMAIL_USUARIO){EMAIL_USUARIO=pEMAIL_USUARIO;}
        public void setROL_USUARIO( String pROL_USUARIO){ROL_USUARIO=pROL_USUARIO;}
        public void setCLAVE_USUARIO( String pCLAVE_USUARIO){CLAVE_USUARIO=pCLAVE_USUARIO;}
        
        public void setPROYECTO( A_Proyecto pobjProyecto){objProyecto=pobjProyecto;}
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="GETs DEL OBJETO">
        public String getUSER_NAME(){return COD_USUARIO;}
        public String getCEDULA(){return CEDULA_USUARIO;}
        public String getNOMBRE_USUARIO(){return NOMBRE_USUARIO;}
        public String getEMAIL_USUARIO(){return EMAIL_USUARIO;}
        public String getROL_USUARIO(){return ROL_USUARIO;}
        public String getCLAVE_USUARIO(){return CLAVE_USUARIO;}
        
        public A_Proyecto getPROYECTO(){return objProyecto;}
    // </editor-fold>

    // </editor-fold>

}

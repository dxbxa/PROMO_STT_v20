
package A_Ventas.CapaLogica;
class A_Telefono {

    // <editor-fold defaultstate="collapsed" desc="DECLARACION DE LOS ATRIBUTOS DEL OBJETO">
        private String NUMERO_TELEFONO;
        private String DESC_PROMESA;
        private String FECHA_PROMESA;
        private String COMENTARIO;
        

    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="CONSTRUCTORES DEL OBJETO">

    public A_Telefono(String pNUMERO_TELEFONO,String pDESC_PROMESA, String pFECHA_PROMESA, String pCOMENTARIO){
        NUMERO_TELEFONO=pNUMERO_TELEFONO;
        DESC_PROMESA=pDESC_PROMESA;
        FECHA_PROMESA=pFECHA_PROMESA;
        COMENTARIO=pCOMENTARIO;
    }

    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="PROPIEDADES DEL OBJETO">

    // <editor-fold defaultstate="collapsed" desc="SETs DEL OBJETO">
        public void setNUMERO_TELEFONO( String pNUMERO_TELEFONO){NUMERO_TELEFONO=pNUMERO_TELEFONO;}
        public void setCOD_PROMESA( String pCOD_PROMESA){DESC_PROMESA=pCOD_PROMESA;}
        public void setCOMENTARIO( String pCOMENTARIO){COMENTARIO=pCOMENTARIO;}
        public void setFECHA_PROMESA( String pFECHA_PROMESA){FECHA_PROMESA=pFECHA_PROMESA;}
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="GETs DEL OBJETO">
        public String getNUMERO_TELEFONO(){return NUMERO_TELEFONO;}
        public String getDESC_PROMESA(){return DESC_PROMESA;}
        public String getCOMENTARIO(){return COMENTARIO;}
        public String getFECHA_PROMESA(){return FECHA_PROMESA;}
    // </editor-fold>

    // </editor-fold>

}

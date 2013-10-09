
package A_Ventas.CapaLogica;

class A_Identificador {
    
    // <editor-fold defaultstate="collapsed" desc="DECLARACION DE LOS ATRIBUTOS DEL OBJETO">
        private String COD_IDENTIFICADOR;
        private String DESC_IDENTIFICADOR;

    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="CONSTRUCTORES DEL OBJETO">

    public A_Identificador(String pCOD_IDENTIFICADOR,	String pDESC_IDENTIFICADOR){
        COD_IDENTIFICADOR=pCOD_IDENTIFICADOR;
        DESC_IDENTIFICADOR=pDESC_IDENTIFICADOR;

    }

    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="PROPIEDADES DEL OBJETO">

    // <editor-fold defaultstate="collapsed" desc="SETs DEL OBJETO">
        public void setCOD_IDENTIFICADOR( String pCOD_IDENTIFICADOR){COD_IDENTIFICADOR=pCOD_IDENTIFICADOR;}
        public void setDESC_IDENTIFICADOR( String pDESC_IDENTIFICADOR){DESC_IDENTIFICADOR=pDESC_IDENTIFICADOR;}
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="GETs DEL OBJETO">
        public String getCOD_IDENTIFICADOR(){return COD_IDENTIFICADOR;}
        public String getDESC_IDENTIFICADOR(){return DESC_IDENTIFICADOR;}
    // </editor-fold>

    // </editor-fold>

}

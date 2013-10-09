
package A_Ventas.CapaLogica;

class A_Promesa{
    
    // <editor-fold defaultstate="collapsed" desc="DECLARACION DE LOS ATRIBUTOS DEL OBJETO">
    
        private String COD_PROMESA;
        private String DESC_PROMESA;

    
    // </editor-fold>
        
    // <editor-fold defaultstate="collapsed" desc="CONSTRUCTORES DEL OBJETO">
        
    public A_Promesa(String pCOD_PROMESA,String pDESC_PROMESA){
        COD_PROMESA=pCOD_PROMESA;
        DESC_PROMESA=pDESC_PROMESA;
   }
        
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="PROPIEDADES DEL OBJETO">
    
    // <editor-fold defaultstate="collapsed" desc="SETs DEL OBJETO">
    
        public void setCOD_PROMESA( String pCOD_PROMESA){COD_PROMESA=pCOD_PROMESA;}
        public void setDESC_PROMESA( String pDESC_PROMESA){DESC_PROMESA=pDESC_PROMESA;}

    
    // </editor-fold>
        
    // <editor-fold defaultstate="collapsed" desc="GETs DEL OBJETO">
        
        public String getCOD_PROMESA(){return COD_PROMESA;}
        public String getDESC_PROMESA(){return DESC_PROMESA;}

    // </editor-fold>
        
    // </editor-fold>
    
}

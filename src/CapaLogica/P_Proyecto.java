
package CapaLogica;

class P_Proyecto {
    
    // <editor-fold defaultstate="collapsed" desc="DECLARACION DE LOS ATRIBUTOS DEL OBJETO">
    
        private String COD_PROYECTO;
        private String DESC_PROYECTO;
        
        private P_Promesa[] arrayPromesas;
        private Producto[] arrayProductos;

    // </editor-fold>
        
    // <editor-fold defaultstate="collapsed" desc="CONSTRUCTORES DEL OBJETO">
        
    public P_Proyecto(String pCOD_PROYECTO,String pDESC_PROYECTO){
        COD_PROYECTO=pCOD_PROYECTO;
        DESC_PROYECTO=pDESC_PROYECTO;
   }
        
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="PROPIEDADES DEL OBJETO">
    
    // <editor-fold defaultstate="collapsed" desc="SETs DEL OBJETO">
    
        public void setCOD_PROYECTO( String pCOD_PROYECTO){COD_PROYECTO=pCOD_PROYECTO;}
        public void setDESC_PROYECTO( String pDESC_PROYECTO){DESC_PROYECTO=pDESC_PROYECTO;}
        
        public void setPROMESAS(P_Promesa[] parrayPromesas){arrayPromesas=parrayPromesas;}
        public void setPRODUCTOS(Producto[] parrayProductos){arrayProductos=parrayProductos;}

    
    // </editor-fold>
        
    // <editor-fold defaultstate="collapsed" desc="GETs DEL OBJETO">
        
        public String getCOD_PROYECTO(){return COD_PROYECTO;}
        public String getDESC_PROYECTO(){return DESC_PROYECTO;}
        
        public P_Promesa[] getPROMESAS(){return arrayPromesas;}
        public Producto[] getPRODUCTOS(){return arrayProductos;}

    // </editor-fold>
        
    // </editor-fold>
        
}


package A_Ventas.CapaLogica;

class Producto {
    
    // <editor-fold defaultstate="collapsed" desc="DECLARACION DE LOS ATRIBUTOS DEL OBJETO">
    
        
        private String DESC_PRODUCTO;
        private A_Tipo[] arrayTipos;

    
    // </editor-fold>
        
    // <editor-fold defaultstate="collapsed" desc="CONSTRUCTORES DEL OBJETO">
        
    public Producto(String pDESC_PRODUCTO){
        DESC_PRODUCTO=pDESC_PRODUCTO;
   }
        
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="PROPIEDADES DEL OBJETO">
    
    // <editor-fold defaultstate="collapsed" desc="SETs DEL OBJETO">
    
        public void setDESC_PRODUCTO( String pDESC_PRODUCTO){DESC_PRODUCTO=pDESC_PRODUCTO;}
        
        public void setTIPOS(A_Tipo[] parrayTipos){arrayTipos=parrayTipos;}

    
    // </editor-fold>
        
    // <editor-fold defaultstate="collapsed" desc="GETs DEL OBJETO">
        
        public String getDESC_PRODUCTO(){return DESC_PRODUCTO;}
        
        public A_Tipo[] getTIPOS(){return arrayTipos;}

    // </editor-fold>
        
    // </editor-fold>

}

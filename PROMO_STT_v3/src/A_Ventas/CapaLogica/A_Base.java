
package A_Ventas.CapaLogica;

public class A_Base {
    
    // <editor-fold defaultstate="collapsed" desc="DECLARACION DE LOS ATRIBUTOS DEL OBJETO">
    
        private String NOMBRE_BASE;
        private int CANT_REGISTROS;

    // </editor-fold>
        
    // <editor-fold defaultstate="collapsed" desc="CONSTRUCTORES DEL OBJETO">
        
    public A_Base(String pNOMBRE_BASE,int pCANT_REGISTROS){
        NOMBRE_BASE=pNOMBRE_BASE;
        CANT_REGISTROS=pCANT_REGISTROS;
   }
        
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="PROPIEDADES DEL OBJETO">
    
    // <editor-fold defaultstate="collapsed" desc="SETs DEL OBJETO">
    
        public void setNOMBRE_BASE( String pNOMBRE_BASE){NOMBRE_BASE=pNOMBRE_BASE;}
        public void setCANT_REGISTROS( int pDESC_PROYECTO){CANT_REGISTROS=pDESC_PROYECTO;}

    // </editor-fold>
        
    // <editor-fold defaultstate="collapsed" desc="GETs DEL OBJETO">
        
        public String getNOMBRE_BASE(){return NOMBRE_BASE;}
        public int getCANT_REGISTROS(){return CANT_REGISTROS;}

    // </editor-fold>
        
    // </editor-fold>

}


package CapaLogica;

class E_Estadisticas {
    
    // <editor-fold defaultstate="collapsed" desc="DECLARACION DE LOS ATRIBUTOS DEL OBJETO">
    
        private int DATOS_30;
        private int DATOS_7;
        private int DATOS_1;
        private String PROMESA;
        private int CONTACTACION_7;
        private int EFECTIVIDAD_7;
        private int VENTA_7;
        private int CONTACTACION_30;
        private int EFECTIVIDAD_30;
        private int VENTA_30;
        private int CONTACTACION_1;
        private int EFECTIVIDAD_1;
        private int VENTA_1;

    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="CONSTRUCTORES DEL OBJETO">
    public E_Estadisticas(int pDATOS_30,	int pDATOS_7,	int pDATOS_1,	String pPROMESA,	int pCONTACTACION_7,	int pEFECTIVIDAD_7,	int pVENTA_7,	int pCONTACTACION_30,	int pEFECTIVIDAD_30,	int pVENTA_30,	int pCONTACTACION_1,	int pEFECTIVIDAD_1,	int pVENTA_1){
        DATOS_30=pDATOS_30;
        DATOS_7=pDATOS_7;
        DATOS_1=pDATOS_1;
        PROMESA=pPROMESA;
        CONTACTACION_7=pCONTACTACION_7;
        EFECTIVIDAD_7=pEFECTIVIDAD_7;
        VENTA_7=pVENTA_7;
        CONTACTACION_30=pCONTACTACION_30;
        EFECTIVIDAD_30=pEFECTIVIDAD_30;
        VENTA_30=pVENTA_30;
        CONTACTACION_1=pCONTACTACION_1;
        EFECTIVIDAD_1=pEFECTIVIDAD_1;
        VENTA_1=pVENTA_1;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="PROPIEDADES DEL OBJETO">
    
    // <editor-fold defaultstate="collapsed" desc="SETs DEL OBJETO">
    
        public void setDATOS_30( int pDATOS_30){DATOS_30=pDATOS_30;}
        public void setDATOS_7( int pDATOS_7){DATOS_7=pDATOS_7;}
        public void setDATOS_1( int pDATOS_1){DATOS_1=pDATOS_1;}
        public void setPROMESA( String pPROMESA){PROMESA=pPROMESA;}
        public void setCONTACTACION_7( int pCONTACTACION_7){CONTACTACION_7=pCONTACTACION_7;}
        public void setEFECTIVIDAD_7( int pEFECTIVIDAD_7){EFECTIVIDAD_7=pEFECTIVIDAD_7;}
        public void setVENTA_7( int pVENTA_7){VENTA_7=pVENTA_7;}
        public void setCONTACTACION_30( int pCONTACTACION_30){CONTACTACION_30=pCONTACTACION_30;}
        public void setEFECTIVIDAD_30( int pEFECTIVIDAD_30){EFECTIVIDAD_30=pEFECTIVIDAD_30;}
        public void setVENTA_30( int pVENTA_30){VENTA_30=pVENTA_30;}
        public void setCONTACTACION_1( int pCONTACTACION_1){CONTACTACION_1=pCONTACTACION_1;}
        public void setEFECTIVIDAD_1( int pEFECTIVIDAD_1){EFECTIVIDAD_1=pEFECTIVIDAD_1;}
        public void setVENTA_1( int pVENTA_1){VENTA_1=pVENTA_1;}

    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="GETs DEL OBJETO">
        
        public int getDATOS_30(){return DATOS_30;}
        public int getDATOS_7(){return DATOS_7;}
        public int getDATOS_1(){return DATOS_1;}
        public String getPROMESA(){return PROMESA;}
        public int getCONTACTACION_7(){return CONTACTACION_7;}
        public int getEFECTIVIDAD_7(){return EFECTIVIDAD_7;}
        public int getVENTA_7(){return VENTA_7;}
        public int getCONTACTACION_30(){return CONTACTACION_30;}
        public int getEFECTIVIDAD_30(){return EFECTIVIDAD_30;}
        public int getVENTA_30(){return VENTA_30;}
        public int getCONTACTACION_1(){return CONTACTACION_1;}
        public int getEFECTIVIDAD_1(){return EFECTIVIDAD_1;}
        public int getVENTA_1(){return VENTA_1;}
        
    // </editor-fold>
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="METODOS DEL OBJETO">
        
    public String getPORCENTAJE_EFECTIVIDAD(String lapso){
        
        return "PE%";
    }
    
    public String getYES_RATIO(String lapso){
        
        return "YR%";
    }
    
    // </editor-fold>
}

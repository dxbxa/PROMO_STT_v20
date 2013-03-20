
package CapaBD;

import java.sql.*;
import java.util.*;

public class BD_ConectorBD{
    
    public String[] getDatosUsuario(String pUser, String pPassword) throws Exception{

        String query="SELECT \n";
                query+="  U.CEDULA_USUARIO,\n";
                query+="  U.NOMBRE_USUARIO,\n";
                query+="  U.EMAIL_USUARIO,\n";
                query+="  U.ROL_USUARIO,\n";
                query+="  U.COD_PROYECTO,\n";
                query+="  P.DESC_PROYECTO\n";
                query+="FROM\n";
                query+="  T_USUARIO U\n";
                query+="JOIN T_PROYECTO P ON U.COD_PROYECTO=P.COD_PROYECTO \n";
                query+="WHERE\n";
                query+="  COD_USUARIO='"+pUser+"' \n";
                query+="AND\n";
                query+="  CLAVE_USUARIO='"+pPassword+"'\n";
//System.out.println(query);
       String resultado[]=null;
       Class.forName ("oracle.jdbc.OracleDriver");
       Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.5.2:1521:STTCR", "Callcenter", "Call887795zty");
       try {
         Statement stmt = conn.createStatement();
         try {
           ResultSet rs = stmt.executeQuery(query);
           ResultSetMetaData rsMd = rs.getMetaData();
           int columnas = rsMd.getColumnCount();
           resultado=new String[columnas];
           try{
             while (rs.next()){
                     resultado[0]=rs.getObject("CEDULA_USUARIO").toString();
                     resultado[1]=rs.getObject("NOMBRE_USUARIO").toString();
                     resultado[2]=rs.getObject("EMAIL_USUARIO").toString();
                     resultado[3]=rs.getObject("ROL_USUARIO").toString();
                     resultado[4]=rs.getObject("COD_PROYECTO").toString();
                     resultado[5]=rs.getObject("DESC_PROYECTO").toString();

                }
               if(resultado[0]==null){
                   resultado=null;
                   throw new Exception("Usuario Inválido");

               }
           }
           finally { 
                  rs.close(); 
           }
         }
         finally {
               stmt.close(); 
         }
       }
       finally {
             conn.close(); 
       }
       return resultado; 
    }
    
    public String[][] getDatosPromesas(String pcod_Proyecto) throws Exception{

                String query="SELECT\n";
                    query+="  COD_PROMESA,\n";
                    query+="  DESC_PROMESA\n";
                    query+="FROM \n";
                    query+="  T_PROMESA\n";
                    query+="WHERE \n";
                    query+="  COD_PROYECTO='"+pcod_Proyecto+"'\n";
//System.out.println(query);
       String resultado[][]=null;

       Class.forName ("oracle.jdbc.OracleDriver");
       Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.5.2:1521:STTCR", "Callcenter", "Call887795zty");
       try {
         Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
         try {
           ResultSet rs = stmt.executeQuery(query);
           ResultSetMetaData rsMd = rs.getMetaData();

           int columnas = rsMd.getColumnCount();
           rs.last();
           int filas = rs.getRow();
           rs.beforeFirst();
           resultado = new String[filas][columnas];
           int j=0;
           try{
             while (rs.next()){
                 resultado[j][0]=rs.getObject("COD_PROMESA").toString();
                 resultado[j][1]=rs.getObject("DESC_PROMESA").toString();
                 j++;  
             } 
           }
           finally {
                  rs.close(); 
           }
         } 
         finally {
               stmt.close(); 
         }
       } 
       finally {
             conn.close(); 
       }
    return resultado;  
    }   

    public String[] getDatosProducto(String pcod_Proyecto) throws Exception{

            String query="SELECT DISTINCT\n";
                    query+="  DESC_PRODUCTO\n";
                    query+="FROM\n";
                    query+="  T_PRODUCTO\n";
                    query+="WHERE\n";
                    query+="  COD_PROYECTO='"+pcod_Proyecto+"'\n";
//System.out.println(query);
       String resultado[]=null;

       Class.forName ("oracle.jdbc.OracleDriver");
       Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.5.2:1521:STTCR", "Callcenter", "Call887795zty");
       try {
         Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
         try {
           ResultSet rs = stmt.executeQuery(query);
           rs.last();
           int filas = rs.getRow();
           rs.beforeFirst();
           resultado = new String[filas];
           int j=0;
           try{
             while (rs.next()){
                 resultado[j]=rs.getObject("DESC_PRODUCTO").toString();
                 j++;  
             } 
           }
           finally {
                  rs.close(); 
           }
         } 
         finally {
               stmt.close(); 
         }
       } 
       finally {
             conn.close(); 
       }
    return resultado;  
    }  

    public String[] getDatosTipoProducto(String pdesc_producto) throws Exception{

            String query="SELECT DISTINCT\n";
                query+="  TIPO_PRODUCTO\n";
                query+="FROM \n";
                query+="  T_PRODUCTO\n";
                query+="WHERE \n";
                query+="  DESC_PRODUCTO='"+pdesc_producto+"' ORDER BY TIPO_PRODUCTO\n";
//System.out.println(query);

       String resultado[]=null;

       Class.forName ("oracle.jdbc.OracleDriver");
       Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.5.2:1521:STTCR", "Callcenter", "Call887795zty");
       try {
         Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
         try {
           ResultSet rs = stmt.executeQuery(query);           
           rs.last();
           int filas = rs.getRow();
           rs.beforeFirst();
           resultado = new String[filas];
           int j=0;
           try{
             while (rs.next()){
                 resultado[j]=rs.getObject("TIPO_PRODUCTO").toString();
                 j++;  
             } 
           }finally {
                  rs.close(); 
              } 
         }finally {
               stmt.close(); 
         }
       }finally {
             conn.close(); 
         }
    return resultado;  
    }  
    
    public String[][] getDatosBase(String pcod_Proyecto)throws Exception{
String query="SELECT DISTINCT \n";
query+="NOMBRE_BASE,\n";
query+="COUNT(DISTINCT C.CEDULA_CONTACTO) REGISTROS\n";
query+="FROM T_CONTACTO C \n";
query+="RIGHT JOIN T_TELEFONO T\n";
query+="ON C.CEDULA_CONTACTO=T.CEDULA_CONTACTO\n";
query+="WHERE C.COD_PROYECTO='"+pcod_Proyecto+"' \n";
query+="AND T.ESTATUS_TELEFONO='LIBRE'\n";
query+="GROUP BY NOMBRE_BASE\n";

System.out.println(query);
       String resultado[][]=null;
       
       Class.forName ("oracle.jdbc.OracleDriver");
       Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.5.2:1521:STTCR", "Callcenter", "Call887795zty");
       try {
         Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
         try {
           ResultSet rs = stmt.executeQuery(query);
           ResultSetMetaData rsMd = rs.getMetaData();
           
           int columnas = rsMd.getColumnCount();
           rs.last();
           int filas = rs.getRow();
           rs.beforeFirst();
           resultado = new String[filas][columnas];
           int j=0;
           try{
             while (rs.next()){
                 resultado[j][0]=rs.getObject("NOMBRE_BASE").toString();
                 resultado[j][1]=rs.getObject("REGISTROS").toString();
                 j++;  
             } 
           }
           finally {
                  rs.close(); 
           }
         } 
         finally {
               stmt.close(); 
         }
       } 
       finally {
             conn.close(); 
       }
    return resultado; 
    }
    
    public String[] busquedaContacto(String pCOD_USUARIO,int tipoBusqueda,String pcod_proyecto, String valorBuscado, String pNombre_base)throws Exception{
        // 0 busqueda nueva
        // 1 busqueda x cedula
        // 2 busqueda x TARJETA
        // 3 busqueda x nombre
        

String query="";

switch(tipoBusqueda)
{ case 0:
    
            //reservaContacto(pCOD_USUARIO, pcod_proyecto, pNombre_base);
    
                query+="  SELECT DISTINCT\n";
                query+="  CEDULA_CONTACTO,\n";
                query+="  NOMBRE_CONTACTO,\n";
                query+="  COD_CUENTA,\n";
                query+="  TARJETA_CONTACTO,\n";
                query+="  NOMBRE_BASE\n";
                query+="FROM T_CONTACTO WHERE CEDULA_CONTACTO IN (\n";
                query+="SELECT \n";
                query+="MAX(C.CEDULA_CONTACTO) AS CEDULA_CONTACTO\n";
                query+="FROM T_TELEFONO T JOIN T_CONTACTO C ON T.CEDULA_CONTACTO=C.CEDULA_CONTACTO\n";
                query+="WHERE \n";
                query+="ESTATUS_TELEFONO='LIBRE' \n";
//              query+="AND NOMBRE_BASE='"+pNombre_base+"' \n";
                query+="AND COD_USUARIO='"+pCOD_USUARIO+"')\n";

break;

case 1: 
    //
    
            query+="SELECT DISTINCT\n";
            query+="  CEDULA_CONTACTO,\n";
            query+="  NOMBRE_CONTACTO,\n";
            query+="  COD_CUENTA,\n";
            query+="  TARJETA_CONTACTO,\n";
            query+="  NOMBRE_BASE\n";
            query+="FROM T_CONTACTO WHERE CEDULA_CONTACTO IN (\n";
            query+="SELECT\n";
            query+="MAX(CEDULA_CONTACTO) AS CEDULA_CONTACTO\n";
            query+="FROM T_CONTACTO WHERE CEDULA_CONTACTO LIKE '%"+valorBuscado+"%')\n";

break;

case 2: 
    
    
            query+="SELECT DISTINCT\n";
            query+="  CEDULA_CONTACTO,\n";
            query+="  NOMBRE_CONTACTO,\n";
            query+="  COD_CUENTA,\n";
            query+="  TARJETA_CONTACTO,\n";
            query+="  NOMBRE_BASE\n";
            query+="FROM T_CONTACTO WHERE CEDULA_CONTACTO IN (\n";
            query+="SELECT \n";
            query+="MAX(CEDULA_CONTACTO) AS CEDULA_CONTACTO\n";
            query+="FROM T_CONTACTO WHERE TARJETA_CONTACTO LIKE '%"+valorBuscado+"%')\n";
    
break;
    
case 3: 
    
    
    
            query+="SELECT DISTINCT\n";
            query+="  CEDULA_CONTACTO,\n";
            query+="  NOMBRE_CONTACTO,\n";
            query+="  COD_CUENTA,\n";
            query+="  TARJETA_CONTACTO,\n";
            query+="  NOMBRE_BASE\n";
            query+="FROM T_CONTACTO WHERE CEDULA_CONTACTO IN (\n";
    
    
	StringTokenizer tokens=new StringTokenizer(valorBuscado);
        boolean primero=true;
	while(tokens.hasMoreTokens()){
            if(primero){
                    query+="SELECT \n";
                    query+="MAX(CEDULA_CONTACTO) AS CEDULA_CONTACTO\n";
                    query+="FROM T_CONTACTO WHERE NOMBRE_CONTACTO LIKE UPPER('%"+tokens.nextToken()+"%') \n";
                    primero=false;
            }else{
                    query+="AND NOMBRE_CONTACTO LIKE UPPER('%"+tokens.nextToken()+"%') \n";
            }
        }
            query+=")";
        
    
break;

default: throw new Exception("Tipo de búsqueda no permitido");
};  

//System.out.println(query);
       String resultado[]=null;
       
       Class.forName ("oracle.jdbc.OracleDriver");
       Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.5.2:1521:STTCR", "Callcenter", "Call887795zty");
       try {
         Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
         try {
           ResultSet rs = stmt.executeQuery(query);
           ResultSetMetaData rsMd = rs.getMetaData();
           int columnas = rsMd.getColumnCount();
           resultado = new String[columnas];
           int j=0;
           try{
             while (rs.next()){
                 resultado[0]=rs.getObject("CEDULA_CONTACTO").toString();
                 resultado[1]=rs.getObject("NOMBRE_CONTACTO").toString();
                 resultado[2]=rs.getObject("COD_CUENTA").toString();
                 resultado[3]=rs.getObject("TARJETA_CONTACTO").toString();
                 resultado[4]=rs.getObject("NOMBRE_BASE").toString();                 
                 j++;  
             } 
           }
           finally {
                  rs.close(); 
           }
         } 
         finally {
               stmt.close(); 
         }
       } 
       finally {
             conn.close(); 
       }
    return resultado;    
    }
      
    private void reservaContacto(String pCOD_USUARIO, String pCOD_PROYECTO, String pNombre_base)throws Exception{
            String query="DECLARE\n";
                    query+="  VUSUARIO VARCHAR2(200);\n";
                    query+="  VCOD_PROYECTO VARCHAR2(200);\n";
                    query+="  VFECHA_PROMESA VARCHAR2(200);\n";
                    query+="  VNOMBRE_BASE VARCHAR2(200);\n";
                    query+="BEGIN\n";
                    query+="  VUSUARIO := '"+pCOD_USUARIO+"';\n";
                    query+="  VCOD_PROYECTO := '"+pCOD_PROYECTO+"';\n";
                    query+="  VFECHA_PROMESA := to_char(SYSDATE,'dd/mm/yyyy hh:mi am');\n";
                    query+="  VNOMBRE_BASE := '"+pNombre_base+"';\n";
                    query+="\n";
                    query+="  SP_RESERVA_TELEFONO_NEW(\n";
                    query+="    VUSUARIO => VUSUARIO,\n";
                    query+="    VCOD_PROYECTO => VCOD_PROYECTO,\n";
                    query+="    VFECHA_PROMESA => VFECHA_PROMESA,\n";
                    query+="    VNOMBRE_BASE => VNOMBRE_BASE\n";
                    query+="  );\n";
                    query+="END;\n";

                //System.out.println(query);
                
       Class.forName ("oracle.jdbc.OracleDriver");
       Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.5.2:1521:STTCR", "Callcenter", "Call887795zty");
       try {
         Statement stmt = conn.createStatement();
         try {
           stmt.executeQuery(query);
         }
         finally {
               stmt.close(); 
         }
       }
       finally {
             conn.close(); 
       }
        
    }

    public String [][] getDatosIdentificadores(String pCedula)throws Exception{
        String query="SELECT \n";
        query+="COD_IDENTIFICADOR, \n";
        query+="DESC_IDENTIFICADOR\n";
        query+="FROM T_IDENTIFICADOR \n";
        query+="WHERE \n";
        query+="CEDULA_CONTACTO='"+pCedula+"'\n";
        //System.out.println(query);
        String resultado[][]=null;
       
       Class.forName ("oracle.jdbc.OracleDriver");
       Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.5.2:1521:STTCR", "Callcenter", "Call887795zty");
       try {
         Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
         try {
           ResultSet rs = stmt.executeQuery(query);
           ResultSetMetaData rsMd = rs.getMetaData();
           int columnas = rsMd.getColumnCount();
           rs.last();
           int filas = rs.getRow();
           rs.beforeFirst();
           resultado = new String[filas][columnas];
           int j=0;
           try{
             while (rs.next()){
                 resultado[j][0]=rs.getObject("COD_IDENTIFICADOR").toString();
                 resultado[j][1]=rs.getObject("DESC_IDENTIFICADOR").toString();
                 j++;  
             } 
           }
           finally {
                  rs.close(); 
           }
         } 
         finally {
               stmt.close(); 
         }
       } 
       finally {
             conn.close(); 
       }
    return resultado; 
    }
    
    public String[][] getDatosTelefonos(String pCedula) throws Exception{
            
            String query="  SELECT DISTINCT\n";
            query+="  T.NUMERO_TELEFONO,\n";
            query+="  ESTATUS_TELEFONO,\n";
            query+="  CASE WHEN T.FECHA_PROMESA IS NULL THEN to_char(SYSDATE,'dd/mm/yyyy hh:mi am') ELSE T.FECHA_PROMESA  END as FECHA_PROMESA,\n";
            query+="  CASE WHEN P.DESC_PROMESA IS NULL THEN '00 INGRESAR' ELSE P.DESC_PROMESA END as DESC_PROMESA,\n";
            query+="  CASE WHEN T.COMENTARIO IS NULL THEN 'SIN COMENTARIO' ELSE T.COMENTARIO END as COMENTARIO\n";
            query+="FROM T_TELEFONO T\n";
            query+="LEFT JOIN T_PROMESA P\n";
            query+="ON T.COD_PROMESA=P.COD_PROMESA\n";
            query+="WHERE CEDULA_CONTACTO='"+pCedula+"' AND NUMERO_TELEFONO IS NOT NULL\n";

            //System.out.println(query);
       String resultado[][]=null;
       
       Class.forName ("oracle.jdbc.OracleDriver");
       Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.5.2:1521:STTCR", "Callcenter", "Call887795zty");
       try {
         Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
         try {
           ResultSet rs = stmt.executeQuery(query);
           ResultSetMetaData rsMd = rs.getMetaData();
           int columnas = rsMd.getColumnCount();
           rs.last();
           int filas = rs.getRow();
           rs.beforeFirst();
           resultado = new String[filas][columnas];
           int j=0;
           try{
             while (rs.next()){
                 resultado[j][0]=rs.getObject("NUMERO_TELEFONO").toString();
                 resultado[j][1]=rs.getObject("DESC_PROMESA").toString();
                 resultado[j][2]=rs.getObject("FECHA_PROMESA").toString();
                 resultado[j][3]=rs.getObject("COMENTARIO").toString();
                 j++;  
             } 
           }
           finally {
                  rs.close(); 
           }
         } 
         finally {
               stmt.close(); 
         }
       } 
       finally {
             conn.close(); 
       }
    return resultado;  
    }  
    
    public void asignarSeguimiento(String pcedula, String pnombre, String comentario, String pCod_usuario, String pclaveSuperior)throws Exception{
        String query="DECLARE\n";
        query+="  VCEDULA_CONTACTO VARCHAR2(200);\n";
        query+="  VNOMBRE_CONTACTO VARCHAR2(200);\n";
        query+="  VCOMENTARIO_ACTIVIDAD VARCHAR2(200);\n";
        query+="  VCOD_USUARIO_R VARCHAR2(200);\n";
        query+="  VCOD_USUARIO_A VARCHAR2(200);\n";
        query+="BEGIN\n";
        query+="  VCEDULA_CONTACTO := '"+pcedula+"';\n";
        query+="  VNOMBRE_CONTACTO := '"+pnombre+"';\n";
        query+="  VCOMENTARIO_ACTIVIDAD := '"+comentario+"';\n";
        query+="  VCOD_USUARIO_R := '"+pCod_usuario+"';\n";
        query+="  VCOD_USUARIO_A := 'N/A';\n";
        query+="\n";
        query+="  SP_AGENDAR_CONTACTOS(\n";
        query+="    VCEDULA_CONTACTO => VCEDULA_CONTACTO,\n";
        query+="    VNOMBRE_CONTACTO => VNOMBRE_CONTACTO,\n";
        query+="    VCOMENTARIO_ACTIVIDAD => VCOMENTARIO_ACTIVIDAD,\n";
        query+="    VCOD_USUARIO_R => VCOD_USUARIO_R,\n";
        query+="    VCOD_USUARIO_A => VCOD_USUARIO_A\n";
        query+="  );\n";
        query+="END;\n";
// System.out.println(query);
                
       Class.forName ("oracle.jdbc.OracleDriver");
       Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.5.2:1521:STTCR", "Callcenter", "Call887795zty");
       try {
         Statement stmt = conn.createStatement();
         try {
           stmt.executeQuery(query);
         }
         finally {
               stmt.close(); 
         }
       }
       finally {
             conn.close(); 
       }
    }
    
    public String[][] buscaSeguimientos(String pCod_usuario)throws Exception{
        String query="  SELECT DISTINCT \n";
                query+="  CEDULA_CONTACTO,\n";
                query+="  NOMBRE_CONTACTO,\n";
                query+="  COMENTARIO_ACTIVIDAD\n";
                query+="FROM T_SEGUIMIENTO WHERE COD_USUARIO_RESERVA='"+pCod_usuario+"'\n";
//System.out.println(query);
       String resultado[][]=null;
       
       Class.forName ("oracle.jdbc.OracleDriver");
       Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.5.2:1521:STTCR", "Callcenter", "Call887795zty");
       try {
         Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
         try {
           ResultSet rs = stmt.executeQuery(query);
           ResultSetMetaData rsMd = rs.getMetaData();
           int columnas = rsMd.getColumnCount();
           rs.last();
           int filas = rs.getRow();
           rs.beforeFirst();
           resultado = new String[filas][columnas];
           int j=0;
           try{
             while (rs.next()){
                 resultado[j][0]=rs.getObject("CEDULA_CONTACTO").toString();
                 resultado[j][1]=rs.getObject("NOMBRE_CONTACTO").toString();
                 resultado[j][2]=rs.getObject("COMENTARIO_ACTIVIDAD").toString();
                 j++;  
             } 
           }
           finally {
                  rs.close(); 
           }
         } 
         finally {
               stmt.close(); 
         }
       } 
       finally {
             conn.close(); 
       }
    return resultado;  
    }
    
    public void eliminaAgendado(String pcedula, String pCod_usuario)throws Exception{
        String query="DECLARE\n";
        query+="  VCEDULA_AGENDADO VARCHAR2(200);\n";
        query+="  VCOD_USUARIO VARCHAR2(200);\n";
        query+="BEGIN\n";
        query+="  VCEDULA_AGENDADO := '"+pcedula+"';\n";
        query+="  VCOD_USUARIO := '"+pCod_usuario+"';\n";
        query+="\n";
        query+="  SP_ELIMINA_AGENDADO(\n";
        query+="    VCEDULA_AGENDADO => VCEDULA_AGENDADO,\n";
        query+="    VCOD_USUARIO => VCOD_USUARIO\n";
        query+="  );\n";
        query+="END;\n";
//System.out.println(query);
                
       Class.forName ("oracle.jdbc.OracleDriver");
       Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.5.2:1521:STTCR", "Callcenter", "Call887795zty");
       try {
         Statement stmt = conn.createStatement();
         try {
           stmt.executeQuery(query);
         }
         finally {
               stmt.close(); 
         }
       }
       finally {
             conn.close(); 
       }
    }
    
    public void GuardarLlamada(String pCEDULA,String pTELEFONO,String pPROMESA,String pCOMENTARIO, String pCOD_USUARIO) throws Exception{
            String query="DECLARE\n";
            query+="  VCEDULA VARCHAR2(200);\n";
            query+="  VTELEFONO VARCHAR2(200);\n";
            query+="  VDESC_PROMESA VARCHAR2(200);\n";
            query+="  VFECHA_PROMESA VARCHAR2(200);\n";
            query+="  VUSUARIO VARCHAR2(200);\n";
            query+="  VCOMENTARIO VARCHAR2(200);\n";
            query+="BEGIN\n";
            query+="  VCEDULA := '"+pCEDULA+"';\n";
            query+="  VTELEFONO := '"+pTELEFONO+"';\n";
            query+="  VDESC_PROMESA := '"+pPROMESA+"';\n";
            query+="  VFECHA_PROMESA := to_char(SYSDATE,'dd/mm/yyyy hh:mi am');\n";
            query+="  VUSUARIO := '"+pCOD_USUARIO+"';\n";
            query+="  VCOMENTARIO := '"+pCOMENTARIO+"';\n";
            query+="\n";
            query+="  SP_GUARDA_LLAMADA(\n";
            query+="    VCEDULA => VCEDULA,\n";
            query+="    VTELEFONO => VTELEFONO,\n";
            query+="    VDESC_PROMESA => VDESC_PROMESA,\n";
            query+="    VFECHA_PROMESA => VFECHA_PROMESA,\n";
            query+="    VUSUARIO => VUSUARIO,\n";
            query+="    VCOMENTARIO => VCOMENTARIO\n";
            query+="  );\n";
            query+="END;\n";
//            System.out.println(query);
                
       Class.forName ("oracle.jdbc.OracleDriver");
       Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.5.2:1521:STTCR", "Callcenter", "Call887795zty");
       try {
         Statement stmt = conn.createStatement();
         try {
           stmt.executeQuery(query);
         }
         finally {
               stmt.close(); 
         }
       }
       finally {
             conn.close(); 
       }
    }  

    public void GuardarFormularioPA(String pCOD_CUENTA,	String pTARJETA_CONTACTO,	String pCEDULA_CONTACTO,	String pNOMBRE_CONTACTO,	String pPRODUCTO,	String pTIPO_PRODUCTO,	String pCOD_USUARIO,	String pTELEFONO_CONTACTO,	String pCIERRE) throws Exception{
String query="DECLARE\n";
query+="  VHORA_VENTA VARCHAR2(200);\n";
query+="  VCOD_CUENTA VARCHAR2(200);\n";
query+="  VTARJETA_CONTACTO VARCHAR2(200);\n";
query+="  VCEDULA_CONTACTO VARCHAR2(200);\n";
query+="  VNOMBRE_CONTACTO VARCHAR2(200);\n";
query+="  VPRODUCTO VARCHAR2(200);\n";
query+="  VTIPO_PRODUCTO VARCHAR2(200);\n";
query+="  VCOD_USUARIO VARCHAR2(200);\n";
query+="  VTELEFONO_CONTACTO VARCHAR2(200);\n";
query+="  VCIERRE VARCHAR2(200);\n";
query+="BEGIN\n";
query+="  VHORA_VENTA := to_char(SYSDATE,'dd/mm/yyyy hh:mi am');\n";
query+="  VCOD_CUENTA := '"+pCOD_CUENTA+"';\n";
query+="  VTARJETA_CONTACTO := '"+pTARJETA_CONTACTO+"';\n";
query+="  VCEDULA_CONTACTO := '"+pCEDULA_CONTACTO+"';\n";
query+="  VNOMBRE_CONTACTO := '"+pNOMBRE_CONTACTO+"';\n";
query+="  VPRODUCTO := '"+pPRODUCTO+"';\n";
query+="  VTIPO_PRODUCTO := '"+pTIPO_PRODUCTO+"';\n";
query+="  VCOD_USUARIO := '"+pCOD_USUARIO+"';\n";
query+="  VTELEFONO_CONTACTO := '"+pTELEFONO_CONTACTO+"';\n";
query+="  VCIERRE := '"+pCIERRE+"';\n";
query+="\n";
query+="  SP_LLENA_FORMULARIO_PA(\n";
query+="    VHORA_VENTA => VHORA_VENTA,\n";
query+="    VCOD_CUENTA => VCOD_CUENTA,\n";
query+="    VTARJETA_CONTACTO => VTARJETA_CONTACTO,\n";
query+="    VCEDULA_CONTACTO => VCEDULA_CONTACTO,\n";
query+="    VNOMBRE_CONTACTO => VNOMBRE_CONTACTO,\n";
query+="    VPRODUCTO => VPRODUCTO,\n";
query+="    VTIPO_PRODUCTO => VTIPO_PRODUCTO,\n";
query+="    VCOD_USUARIO => VCOD_USUARIO,\n";
query+="    VTELEFONO_CONTACTO => VTELEFONO_CONTACTO,\n";
query+="    VCIERRE => VCIERRE\n";
query+="  );\n";
query+="END;\n";
//System.out.println(query);
                
       Class.forName ("oracle.jdbc.OracleDriver");
       Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.5.2:1521:STTCR", "Callcenter", "Call887795zty");
       try {
         Statement stmt = conn.createStatement();
         try {
           stmt.executeQuery(query);
         }
         finally {
               stmt.close(); 
         }
       }
       finally {
             conn.close(); 
       }
    }  
    
    public void GuardarFormularioPoliza(String pCOD_CUENTA,String pTARJETA_CONTACTO,String pNOMBRE_CONTACTO,	String pCEDULA_CONTACTO,	String pCOD_USUARIO,	String pTIPO_PRODUCTO,	String pCIERRE,	String pALBACEA,String pTELEFONO_1,	String pTELEFONO_2,	String pOCUPACION,	String pDIRECCION,	String pNOMBRE_BENEFICIARIO_1,	String pPARENTESCO_BENEFICIARIO_1,	String pPORCENTAJE_BENEFICIARIO_1,	String pNOMBRE_BENEFICIARIO_2,	String pPARENTESCO_BENEFICIARIO_2,	String pPORCENTAJE_BENEFICIARIO_2,	String pNOMBRE_BENEFICIARIO_3,	String pPARENTESCO_BENEFICIARIO_3,	String pPORCENTAJE_BENEFICIARIO_3,	String pNOMBRE_BENEFICIARIO_4,	String pPARENTESCO_BENEFICIARIO_4,	String pPORCENTAJE_BENEFICIARIO_4) throws Exception{
String query="DECLARE\n";
query+="  VHORA_VENTA VARCHAR2(200);\n";
query+="  VCOD_CUENTA VARCHAR2(200);\n";
query+="  VTARJETA_CONTACTO VARCHAR2(200);\n";
query+="  VNOMBRE_CONTACTO VARCHAR2(200);\n";
query+="  VCEDULA_CONTACTO VARCHAR2(200);\n";
query+="  VCOD_USUARIO VARCHAR2(200);\n";
query+="  VTIPO_PRODUCTO VARCHAR2(200);\n";
query+="  VCIERRE VARCHAR2(200);\n";
query+="  VALBACEA VARCHAR2(200);\n";
query+="  VTELEFONO_1 VARCHAR2(200);\n";
query+="  VTELEFONO_2 VARCHAR2(200);\n";
query+="  VOCUPACION VARCHAR2(200);\n";
query+="  VDIRECCION VARCHAR2(200);\n";
query+="  VNOMBRE_BENEFICIARIO_1 VARCHAR2(200);\n";
query+="  VPARENTESCO_BENEFICIARIO_1 VARCHAR2(200);\n";
query+="  VPORCENTAJE_BENEFICIARIO_1 VARCHAR2(200);\n";
query+="  VNOMBRE_BENEFICIARIO_2 VARCHAR2(200);\n";
query+="  VPARENTESCO_BENEFICIARIO_2 VARCHAR2(200);\n";
query+="  VPORCENTAJE_BENEFICIARIO_2 VARCHAR2(200);\n";
query+="  VNOMBRE_BENEFICIARIO_3 VARCHAR2(200);\n";
query+="  VPARENTESCO_BENEFICIARIO_3 VARCHAR2(200);\n";
query+="  VPORCENTAJE_BENEFICIARIO_3 VARCHAR2(200);\n";
query+="  VNOMBRE_BENEFICIARIO_4 VARCHAR2(200);\n";
query+="  VPARENTESCO_BENEFICIARIO_4 VARCHAR2(200);\n";
query+="  VPORCENTAJE_BENEFICIARIO_4 VARCHAR2(200);\n";
query+="BEGIN\n";
query+="  VHORA_VENTA := to_char(SYSDATE,'dd/mm/yyyy hh:mi am');\n";
query+="  VCOD_CUENTA := '"+pCOD_CUENTA+"';\n";
query+="  VTARJETA_CONTACTO := '"+pTARJETA_CONTACTO+"';\n";
query+="  VNOMBRE_CONTACTO := '"+pNOMBRE_CONTACTO+"';\n";
query+="  VCEDULA_CONTACTO := '"+pCEDULA_CONTACTO+"';\n";
query+="  VCOD_USUARIO := '"+pCOD_USUARIO+"';\n";
query+="  VTIPO_PRODUCTO := '"+pTIPO_PRODUCTO+"';\n";
query+="  VCIERRE := '"+pCIERRE+"';\n";
query+="  VALBACEA := '"+pALBACEA+"';\n";
query+="  VTELEFONO_1 := '"+pTELEFONO_1+"';\n";
query+="  VTELEFONO_2 := '"+pTELEFONO_2+"';\n";
query+="  VOCUPACION := '"+pOCUPACION+"';\n";
query+="  VDIRECCION := '"+pDIRECCION+"';\n";
query+="  VNOMBRE_BENEFICIARIO_1 := '"+pNOMBRE_BENEFICIARIO_1+"';\n";
query+="  VPARENTESCO_BENEFICIARIO_1 := '"+pPARENTESCO_BENEFICIARIO_1+"';\n";
query+="  VPORCENTAJE_BENEFICIARIO_1 := '"+pPORCENTAJE_BENEFICIARIO_1+"';\n";
query+="  VNOMBRE_BENEFICIARIO_2 := '"+pNOMBRE_BENEFICIARIO_2+"';\n";
query+="  VPARENTESCO_BENEFICIARIO_2 := '"+pPARENTESCO_BENEFICIARIO_2+"';\n";
query+="  VPORCENTAJE_BENEFICIARIO_2 := '"+pPORCENTAJE_BENEFICIARIO_2+"';\n";
query+="  VNOMBRE_BENEFICIARIO_3 := '"+pNOMBRE_BENEFICIARIO_3+"';\n";
query+="  VPARENTESCO_BENEFICIARIO_3 := '"+pPARENTESCO_BENEFICIARIO_3+"';\n";
query+="  VPORCENTAJE_BENEFICIARIO_3 := '"+pPORCENTAJE_BENEFICIARIO_3+"';\n";
query+="  VNOMBRE_BENEFICIARIO_4 := '"+pNOMBRE_BENEFICIARIO_4+"';\n";
query+="  VPARENTESCO_BENEFICIARIO_4 := '"+pPARENTESCO_BENEFICIARIO_4+"';\n";
query+="  VPORCENTAJE_BENEFICIARIO_4 := '"+pPORCENTAJE_BENEFICIARIO_4+"';\n";
query+="\n";
query+="  SP_LLENA_FORMULARIO_POLIZA(\n";
query+="    VHORA_VENTA => VHORA_VENTA,\n";
query+="    VCOD_CUENTA => VCOD_CUENTA,\n";
query+="    VTARJETA_CONTACTO => VTARJETA_CONTACTO,\n";
query+="    VNOMBRE_CONTACTO => VNOMBRE_CONTACTO,\n";
query+="    VCEDULA_CONTACTO => VCEDULA_CONTACTO,\n";
query+="    VCOD_USUARIO => VCOD_USUARIO,\n";
query+="    VTIPO_PRODUCTO => VTIPO_PRODUCTO,\n";
query+="    VCIERRE => VCIERRE,\n";
query+="    VALBACEA => VALBACEA,\n";
query+="    VTELEFONO_1 => VTELEFONO_1,\n";
query+="    VTELEFONO_2 => VTELEFONO_2,\n";
query+="    VOCUPACION => VOCUPACION,\n";
query+="    VDIRECCION => VDIRECCION,\n";
query+="    VNOMBRE_BENEFICIARIO_1 => VNOMBRE_BENEFICIARIO_1,\n";
query+="    VPARENTESCO_BENEFICIARIO_1 => VPARENTESCO_BENEFICIARIO_1,\n";
query+="    VPORCENTAJE_BENEFICIARIO_1 => VPORCENTAJE_BENEFICIARIO_1,\n";
query+="    VNOMBRE_BENEFICIARIO_2 => VNOMBRE_BENEFICIARIO_2,\n";
query+="    VPARENTESCO_BENEFICIARIO_2 => VPARENTESCO_BENEFICIARIO_2,\n";
query+="    VPORCENTAJE_BENEFICIARIO_2 => VPORCENTAJE_BENEFICIARIO_2,\n";
query+="    VNOMBRE_BENEFICIARIO_3 => VNOMBRE_BENEFICIARIO_3,\n";
query+="    VPARENTESCO_BENEFICIARIO_3 => VPARENTESCO_BENEFICIARIO_3,\n";
query+="    VPORCENTAJE_BENEFICIARIO_3 => VPORCENTAJE_BENEFICIARIO_3,\n";
query+="    VNOMBRE_BENEFICIARIO_4 => VNOMBRE_BENEFICIARIO_4,\n";
query+="    VPARENTESCO_BENEFICIARIO_4 => VPARENTESCO_BENEFICIARIO_4,\n";
query+="    VPORCENTAJE_BENEFICIARIO_4 => VPORCENTAJE_BENEFICIARIO_4\n";
query+="  );\n";
query+="END;\n";
//System.out.println(query);
                
       Class.forName ("oracle.jdbc.OracleDriver");
       Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.5.2:1521:STTCR", "Callcenter", "Call887795zty");
       try {
         Statement stmt = conn.createStatement();
         try {
           stmt.executeQuery(query);
         }
         finally {
               stmt.close(); 
         }
       }
       finally {
             conn.close(); 
       }
    }  
    
    public void GuardarFormularioCAU(String pCOD_USUARIO,String pCEDULA_CONTACTO,String pFECHA_PAGO,String pCODIGO_SERVICIO,String pNOMBRE_CONTACTO,String pNOMBRE_SUBSCRICTOR,String pTARJETA_CONTACTO,String pTELEFONO_CONTACTO,String pUBICACION_SERVICIO,String pTIPO_PRODUCTO) throws Exception{
String query="DECLARE\n";
query+="  VHORA_VENTA VARCHAR2(200);\n";
query+="  VCOD_USUARIO VARCHAR2(200);\n";
query+="  VNOMBRE_CONTACTO VARCHAR2(200);\n";
query+="  VCEDULA_CONTACTO VARCHAR2(200);\n";
query+="  VTARJETA_CONTACTO VARCHAR2(200);\n";
query+="  VNOMBRE_SUBSCRICTOR VARCHAR2(200);\n";
query+="  VUBICACION_SERVICIO VARCHAR2(200);\n";
query+="  VCODIGO_SERVICIO VARCHAR2(200);\n";
query+="  VFECHA_PAGO VARCHAR2(200);\n";
query+="  VTELEFONO_CONTACTO VARCHAR2(200);\n";
query+="  VTIPO_PRODUCTO VARCHAR2(200);\n";
query+="BEGIN\n";
query+="  VHORA_VENTA := to_char(SYSDATE,'dd/mm/yyyy hh:mi am');\n";
query+="  VCOD_USUARIO := '"+pCOD_USUARIO+"';\n";
query+="  VNOMBRE_CONTACTO := '"+pNOMBRE_CONTACTO+"';\n";
query+="  VCEDULA_CONTACTO := '"+pCEDULA_CONTACTO+"';\n";
query+="  VTARJETA_CONTACTO := '"+pTARJETA_CONTACTO+"';\n";
query+="  VNOMBRE_SUBSCRICTOR := '"+pNOMBRE_SUBSCRICTOR+"';\n";
query+="  VUBICACION_SERVICIO := '"+pUBICACION_SERVICIO+"';\n";
query+="  VCODIGO_SERVICIO := '"+pCODIGO_SERVICIO+"';\n";
query+="  VFECHA_PAGO := '"+pFECHA_PAGO+"';\n";
query+="  VTELEFONO_CONTACTO := '"+pTELEFONO_CONTACTO+"';\n";
query+="  VTIPO_PRODUCTO := '"+pTIPO_PRODUCTO+"';\n";
query+="\n";
query+="  SP_LLENA_FORMULARIO_CARGO_AUTO(\n";
query+="    VHORA_VENTA => VHORA_VENTA,\n";
query+="    VCOD_USUARIO => VCOD_USUARIO,\n";
query+="    VNOMBRE_CONTACTO => VNOMBRE_CONTACTO,\n";
query+="    VCEDULA_CONTACTO => VCEDULA_CONTACTO,\n";
query+="    VTARJETA_CONTACTO => VTARJETA_CONTACTO,\n";
query+="    VNOMBRE_SUBSCRICTOR => VNOMBRE_SUBSCRICTOR,\n";
query+="    VUBICACION_SERVICIO => VUBICACION_SERVICIO,\n";
query+="    VCODIGO_SERVICIO => VCODIGO_SERVICIO,\n";
query+="    VFECHA_PAGO => VFECHA_PAGO,\n";
query+="    VTELEFONO_CONTACTO => VTELEFONO_CONTACTO,\n";
query+="    VTIPO_PRODUCTO => VTIPO_PRODUCTO\n";
query+="  );\n";
query+="END;\n";
//System.out.println(query);
                
       Class.forName ("oracle.jdbc.OracleDriver");
       Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.5.2:1521:STTCR", "Callcenter", "Call887795zty");
       try {
         Statement stmt = conn.createStatement();
         try {
           stmt.executeQuery(query);
         }
         finally {
               stmt.close(); 
         }
       }
       finally {
             conn.close(); 
       }
    }  
    
    public String[][] buscaFormulariosPA(String pcedContacto)throws Exception{
String query="SELECT DISTINCT\n";
query+="  CEDULA_CONTACTO,\n";
query+="  NOMBRE_CONTACTO,\n";
query+="  PRODUCTO,\n";
query+="  TIPO_PRODUCTO,\n";
query+="  CASE WHEN CIERRE IS NULL THEN 'NO' ELSE CIERRE END AS CIERRE\n";
query+="FROM T_F_PRODUCTO_ADICIONAL WHERE CEDULA_CONTACTO='"+pcedContacto+"'\n";

//System.out.println(query);
       String resultado[][]=null;
       
       Class.forName ("oracle.jdbc.OracleDriver");
       Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.5.2:1521:STTCR", "Callcenter", "Call887795zty");
       try {
         Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
         try {
           ResultSet rs = stmt.executeQuery(query);
           ResultSetMetaData rsMd = rs.getMetaData();
           int columnas = rsMd.getColumnCount();
           rs.last();
           int filas = rs.getRow();
           rs.beforeFirst();
           resultado = new String[filas][columnas];
           int j=0;
           try{
             while (rs.next()){
                 resultado[j][0]=rs.getObject("CEDULA_CONTACTO").toString();
                 resultado[j][1]=rs.getObject("NOMBRE_CONTACTO").toString();
                 resultado[j][2]=rs.getObject("PRODUCTO").toString();
                 resultado[j][3]=rs.getObject("TIPO_PRODUCTO").toString();
                 resultado[j][4]=rs.getObject("CIERRE").toString();
                 j++;  
             } 
           }
           finally {
                  rs.close(); 
           }
         } 
         finally {
               stmt.close(); 
         }
       } 
       finally {
             conn.close(); 
       }
    return resultado;  
    }
    
    public String[][] buscaFormulariosCAU(String pcedContacto)throws Exception{
        String query="SELECT DISTINCT \n";
        query+="  CEDULA_CONTACTO,\n";
        query+="  TIPO_PRODUCTO,\n";
        query+="  CODIGO_SERVICIO\n";
        query+="FROM T_F_CARGO_AUTOMATICO WHERE CEDULA_CONTACTO='"+pcedContacto+"'\n";


//System.out.println(query);
String resultado[][]=null;
       
       Class.forName ("oracle.jdbc.OracleDriver");
       Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.5.2:1521:STTCR", "Callcenter", "Call887795zty");
       try {
         Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
         try {
           ResultSet rs = stmt.executeQuery(query);
           ResultSetMetaData rsMd = rs.getMetaData();
           int columnas = rsMd.getColumnCount();
           rs.last();
           int filas = rs.getRow();
           rs.beforeFirst();
           resultado = new String[filas][columnas];
           int j=0;
           try{
             while (rs.next()){
                 resultado[j][0]=rs.getObject("CEDULA_CONTACTO").toString();
                 resultado[j][1]=rs.getObject("TIPO_PRODUCTO").toString();
                 resultado[j][2]=rs.getObject("CODIGO_SERVICIO").toString();
                 j++;  
             } 
           }
           finally {
                  rs.close(); 
           }
         } 
         finally {
               stmt.close(); 
         }
       } 
       finally {
             conn.close(); 
       }
    return resultado;  
    }
    
    public boolean validaClavesupervisor(String Clave)throws Exception{
        String query="SELECT \n";
        query+="CASE \n";
        query+="WHEN CLAVE_USUARIO= '"+Clave+"' THEN 'true' ELSE 'false' END AS RESULTADO\n";
        query+="FROM T_USUARIO WHERE COD_USUARIO='STT32'\n";
        boolean resultado=false;
       Class.forName ("oracle.jdbc.OracleDriver");
       Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.5.2:1521:STTCR", "Callcenter", "Call887795zty");
       try {
         Statement stmt = conn.createStatement();
         try {
           ResultSet rs = stmt.executeQuery(query);
           
           try{
             while (rs.next()){
                     String Sresultado=rs.getObject("RESULTADO").toString();
                     if (Sresultado.equals("true")){
                         resultado=true;
                     }

                }

           }
           finally { 
                  rs.close(); 
           }
         }
         finally {
               stmt.close(); 
         }
       }
       finally {
             conn.close(); 
       }
       return resultado; 

    }

    public String[][] getAuditarPPT(String pfecha)throws Exception{
String query="SELECT DISTINCT \n";
query+="  HORA_VENTA,\n";
query+="  COD_CUENTA,\n";
query+="  TARJETA_CONTACTO,\n";
query+="  CASE \n";
query+="    WHEN IA.COD_IDENTIFICADOR IS NOT NULL THEN IA.DESC_IDENTIFICADOR ELSE 'N/A'\n";
query+="  END AS PLAN_TARJETA,\n";
query+="  CASE \n";
query+="    WHEN IB.COD_IDENTIFICADOR IS NOT NULL THEN IB.DESC_IDENTIFICADOR ELSE 'N/A'\n";
query+="  END AS FECHA_NACIMIENTO,\n";
query+="  CASE WHEN F.CEDULA_CONTACTO IS NULL THEN 'N/A' ELSE F.CEDULA_CONTACTO END AS CEDULA_CONTACTO,\n";
query+="  NOMBRE_CONTACTO,\n";
query+="  PRODUCTO,\n";
query+="  TIPO_PRODUCTO,\n";
query+="  U.NOMBRE_USUARIO,\n";
query+="  TELEFONO_CONTACTO,\n";
query+="  CIERRE,\n";
query+="  CASE WHEN REVISADA_POR IS NULL THEN 'PENDIENTE' ELSE REVISADA_POR END AS REVISADA_POR,\n";
query+="  CASE WHEN ESTATUS_CONTROL IS NULL THEN 'PENDIENTE' ELSE ESTATUS_CONTROL END AS ESTATUS_CONTROL,\n";
query+="  CASE WHEN FECHA_DEVOLUCION_POR_CONTROL IS NULL THEN 'PENDIENTE' ELSE FECHA_DEVOLUCION_POR_CONTROL END AS FECHA_DEVOLUCION_POR_CONTROL,\n";
query+="  CASE WHEN FECHA_ENTREGADO_A_CONTROL IS NULL THEN 'PENDIENTE' ELSE FECHA_ENTREGADO_A_CONTROL END AS FECHA_ENTREGADO_A_CONTROL\n";
query+="FROM T_F_PRODUCTO_ADICIONAL F\n";
query+="LEFT JOIN T_IDENTIFICADOR IA\n";
query+="ON IA.CEDULA_CONTACTO=F.CEDULA_CONTACTO AND IA.COD_IDENTIFICADOR='PLAN'\n";
query+="LEFT JOIN T_IDENTIFICADOR IB\n";
query+="ON IB.CEDULA_CONTACTO=F.CEDULA_CONTACTO AND IB.COD_IDENTIFICADOR='NACIMIENTO'\n";
query+="JOIN T_USUARIO U ON U.COD_USUARIO=F.COD_USUARIO\n";
query+="ORDER BY to_date(HORA_VENTA,'DD/MM/YYYY HH:MI AM'),CEDULA_CONTACTO\n";

System.out.println(query);
String resultado[][]=null;
       
       Class.forName ("oracle.jdbc.OracleDriver");
       Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.5.2:1521:STTCR", "Callcenter", "Call887795zty");
       try {
         Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
         try {
           ResultSet rs = stmt.executeQuery(query);
           ResultSetMetaData rsMd = rs.getMetaData();
           int columnas = rsMd.getColumnCount();
           rs.last();
           int filas = rs.getRow();
           rs.beforeFirst();
           resultado = new String[filas][columnas];
           int j=0;
           try{
             while (rs.next()){
                 resultado[j][0]=rs.getObject("HORA_VENTA").toString();
                 resultado[j][1]=rs.getObject("COD_CUENTA").toString();
                 resultado[j][2]=rs.getObject("TARJETA_CONTACTO").toString();
                 resultado[j][3]=rs.getObject("PLAN_TARJETA").toString();
                 resultado[j][4]=rs.getObject("FECHA_NACIMIENTO").toString();
                 resultado[j][5]=rs.getObject("CEDULA_CONTACTO").toString();
                 resultado[j][6]=rs.getObject("NOMBRE_CONTACTO").toString();
                 resultado[j][7]=rs.getObject("PRODUCTO").toString();
                 resultado[j][8]=rs.getObject("TIPO_PRODUCTO").toString();
                 resultado[j][9]=rs.getObject("NOMBRE_USUARIO").toString();
                 resultado[j][10]=rs.getObject("TELEFONO_CONTACTO").toString();
                 resultado[j][11]=rs.getObject("CIERRE").toString();
                 resultado[j][12]=rs.getObject("REVISADA_POR").toString();
                 resultado[j][13]=rs.getObject("ESTATUS_CONTROL").toString();
                 resultado[j][14]=rs.getObject("FECHA_DEVOLUCION_POR_CONTROL").toString();
                 resultado[j][15]=rs.getObject("FECHA_ENTREGADO_A_CONTROL").toString();
                 j++;  
             } 
           }
           finally {
                  rs.close(); 
           }
         } 
         finally {
               stmt.close(); 
         }
       } 
       finally {
             conn.close(); 
       }
    return resultado;  
    }
    
    public String[] buscaFechasPPT()throws Exception{
       
String query="SELECT DISTINCT \n";
query+="to_char(to_date(HORA_VENTA,'DD/MM/YYYY HH:MI AM'),'DD/MM/YYYY') AS HORA_VENTA\n";
query+="FROM T_F_PRODUCTO_ADICIONAL \n";
query+="ORDER BY to_date(HORA_VENTA,'DD/MM/YYYY HH:MI AM') DESC\n";
  
System.out.println(query);
       String resultado[]=null;
       
       Class.forName ("oracle.jdbc.OracleDriver");
       Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.5.2:1521:STTCR", "Callcenter", "Call887795zty");
       try {
         Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
         try {
           ResultSet rs = stmt.executeQuery(query);
           rs.last();
           int filas = rs.getRow();
           rs.beforeFirst();
           resultado = new String[filas];
           int j=0;
           try{
             while (rs.next()){
                 resultado[j]=rs.getObject("HORA_VENTA").toString();               
                 j++;  
             } 
           }
           finally {
                  rs.close(); 
           }
         } 
         finally {
               stmt.close(); 
         }
       } 
       finally {
             conn.close(); 
       }
    return resultado;    
    }
    
    public String[][] getCD_PPT()throws Exception{
        
String query="SELECT DISTINCT \n";
query+="  COD_CUENTA,\n";
query+="  TARJETA_CONTACTO,\n";
query+="  CASE \n";
query+="    WHEN IA.COD_IDENTIFICADOR IS NULL THEN 'N/A' ELSE IA.DESC_IDENTIFICADOR\n";
query+="  END AS PLAN_TARJETA,\n";
query+="  IA.CEDULA_CONTACTO,\n";
query+="  NOMBRE_CONTACTO,\n";
query+="  PRODUCTO,\n";
query+="  TIPO_PRODUCTO,\n";
query+="  U.NOMBRE_USUARIO,\n";
query+="  to_date(HORA_VENTA,'DD/MM/YYYY HH:MI AM') AS FECHA_VENTA,\n";
query+="  CASE \n";
query+="    WHEN IB.COD_IDENTIFICADOR IS NULL THEN 'N/A' ELSE IB.DESC_IDENTIFICADOR\n";
query+="  END AS FECHA_NACIMIENTO,  \n";
query+="  TELEFONO_CONTACTO\n";
query+="FROM T_F_PRODUCTO_ADICIONAL F\n";
query+="LEFT JOIN T_IDENTIFICADOR IA\n";
query+="ON IA.CEDULA_CONTACTO=F.CEDULA_CONTACTO and IA.COD_IDENTIFICADOR='PLAN' \n";
query+="LEFT JOIN T_IDENTIFICADOR IB\n";
query+="ON IB.CEDULA_CONTACTO=F.CEDULA_CONTACTO AND IB.COD_IDENTIFICADOR='NACIMIENTO'\n";
query+="JOIN T_USUARIO U ON U.COD_USUARIO=F.COD_USUARIO\n";
query+="WHERE\n";
query+=" SALES_ADMINISTRATION='ENVIAR'\n";
query+="ORDER BY to_date(HORA_VENTA,'DD/MM/YYYY HH:MI AM'),IA.CEDULA_CONTACTO\n";
System.out.println(query);
String resultado[][]=null;
       
       Class.forName ("oracle.jdbc.OracleDriver");
       Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.5.2:1521:STTCR", "Callcenter", "Call887795zty");
       try {
         Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
         try {
           ResultSet rs = stmt.executeQuery(query);
           ResultSetMetaData rsMd = rs.getMetaData();
           int columnas = rsMd.getColumnCount();
           rs.last();
           int filas = rs.getRow();
           rs.beforeFirst();
           resultado = new String[filas][columnas];
           int j=0;
           try{
             while (rs.next()){
                 resultado[j][0]=rs.getObject("COD_CUENTA").toString();
                 resultado[j][1]=rs.getObject("TARJETA_CONTACTO").toString();
                 resultado[j][2]=rs.getObject("PLAN_TARJETA").toString();
                 resultado[j][3]=rs.getObject("CEDULA_CONTACTO").toString();
                 resultado[j][4]=rs.getObject("NOMBRE_CONTACTO").toString();
                 resultado[j][5]=rs.getObject("PRODUCTO").toString();
                 resultado[j][6]=rs.getObject("TIPO_PRODUCTO").toString();
                 resultado[j][7]=rs.getObject("NOMBRE_USUARIO").toString();
                 resultado[j][8]=rs.getObject("FECHA_VENTA").toString();
                 resultado[j][9]=rs.getObject("FECHA_NACIMIENTO").toString();
                 resultado[j][10]=rs.getObject("TELEFONO_CONTACTO").toString();

                 j++;  
             } 
           }
           finally {
                  rs.close(); 
           }
         } 
         finally {
               stmt.close(); 
         }
       } 
       finally {
             conn.close(); 
       }
    return resultado;  
    }
    
    public String[][] getCD_E_I()throws Exception{
String query="SELECT DISTINCT\n";
query+="to_date(HORA_VENTA,'DD/MM/YYYY HH:MI AM') AS FECHA_VENTA,\n";
query+="U.NOMBRE_USUARIO,\n";
query+="'-' AS USUARIO,\n";
query+="F.TARJETA_CONTACTO,\n";
query+="F.NOMBRE_CONTACTO,\n";
query+="F.CEDULA_CONTACTO,\n";
query+="F.MONTO_DESEMBOLSO,\n";
query+="F.MONEDA_DESEMBOLSO,\n";
query+="F.PLAZO,\n";
query+="'-' AS SIGMA_7,\n";
query+="F.CUENTA_CLIENTE_SINPE,\n";
query+="F.BANCO_DESTINO,\n";
query+="CASE WHEN F.VENCIMIENTO IS NULL THEN 'N/A' ELSE F.VENCIMIENTO END AS VENCIMIENTO,\n";
query+="F.TIPO\n";
query+="FROM T_F_FINANCIAMIENTO F\n";
query+="LEFT JOIN T_IDENTIFICADOR IA\n";
query+="ON IA.CEDULA_CONTACTO=F.CEDULA_CONTACTO and IA.COD_IDENTIFICADOR='PLAN' \n";
query+="LEFT JOIN T_IDENTIFICADOR IB\n";
query+="ON IB.CEDULA_CONTACTO=F.CEDULA_CONTACTO AND IB.COD_IDENTIFICADOR='NACIMIENTO'\n";
query+="JOIN T_USUARIO U ON U.COD_USUARIO=F.COD_USUARIO\n";
query+="WHERE\n";
query+=" SALES_ADMINISTRATION='ENVIAR'\n";
query+="ORDER BY to_date(HORA_VENTA,'DD/MM/YYYY HH:MI AM'),F.CEDULA_CONTACTO\n";

System.out.println(query);
String resultado[][]=null;
       
       Class.forName ("oracle.jdbc.OracleDriver");
       Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.5.2:1521:STTCR", "Callcenter", "Call887795zty");
       try {
         Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
         try {
           ResultSet rs = stmt.executeQuery(query);
           ResultSetMetaData rsMd = rs.getMetaData();
           int columnas = rsMd.getColumnCount();
           rs.last();
           int filas = rs.getRow();
           rs.beforeFirst();
           resultado = new String[filas][columnas];
           int j=0;
           try{
             while (rs.next()){
                 resultado[j][0]=rs.getObject("FECHA_VENTA").toString();
                 resultado[j][1]=rs.getObject("NOMBRE_USUARIO").toString();
                 resultado[j][2]=rs.getObject("USUARIO").toString();
                 resultado[j][3]=rs.getObject("TARJETA_CONTACTO").toString();
                 resultado[j][4]=rs.getObject("NOMBRE_CONTACTO").toString();
                 resultado[j][5]=rs.getObject("CEDULA_CONTACTO").toString();
                 resultado[j][6]=rs.getObject("MONTO_DESEMBOLSO").toString();
                 resultado[j][7]=rs.getObject("MONEDA_DESEMBOLSO").toString();
                 resultado[j][8]=rs.getObject("PLAZO").toString();
                 resultado[j][9]=rs.getObject("SIGMA_7").toString();
                 resultado[j][10]=rs.getObject("CUENTA_CLIENTE_SINPE").toString();
                 resultado[j][11]=rs.getObject("BANCO_DESTINO").toString();
                 resultado[j][12]=rs.getObject("VENCIMIENTO").toString();
                 resultado[j][13]=rs.getObject("TIPO").toString();

                 j++;  
             } 
           }
           finally {
                  rs.close(); 
           }
         } 
         finally {
               stmt.close(); 
         }
       } 
       finally {
             conn.close(); 
       }
    return resultado;  
    }
    
    public void setCD_PPT(String phora_venta,String pcodCue)throws Exception{
String query="DECLARE\n";
query+="  VHORA_VENTA VARCHAR2(200);\n";
query+="  VCOD_CUE VARCHAR2(200);\n";
query+="BEGIN\n";
query+="  VHORA_VENTA := '"+phora_venta+"';\n";
query+="  VCOD_CUE := '"+pcodCue+"';\n";
query+="\n";
query+="  SP_CD_PPT_ALERTAS(\n";
query+="    VHORA_VENTA => VHORA_VENTA,\n";
query+="    VCOD_CUE => VCOD_CUE\n";
query+="  );\n";
query+="END;\n";

System.out.println(query);
                
       Class.forName ("oracle.jdbc.OracleDriver");
       Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.5.2:1521:STTCR", "Callcenter", "Call887795zty");
       try {
         Statement stmt = conn.createStatement();
         try {
           stmt.executeQuery(query);
         }
         finally {
               stmt.close(); 
         }
       }
       finally {
             conn.close(); 
       }
    }
    
    public void salvaAuditoriaPPT(String pfecha,String pcod_cue,String previsada_por,String pstatus_control,String pdevolucion,String pregreso)throws Exception{
String query="DECLARE\n";
query+="  VFECHA VARCHAR2(200);\n";
query+="  VCOD_CUE VARCHAR2(200);\n";
query+="  VREVISADA_POR VARCHAR2(200);\n";
query+="  VESTATUS_CONTROL VARCHAR2(200);\n";
query+="  VFECHA_DEVOLUCION VARCHAR2(200);\n";
query+="  FECHA_RECEPCION VARCHAR2(200);\n";
query+="BEGIN\n";
query+="  VFECHA := '"+pfecha+"';\n";
query+="  VCOD_CUE := '"+pcod_cue+"';\n";
query+="  VREVISADA_POR := '"+previsada_por+"';\n";
query+="  VESTATUS_CONTROL := '"+pstatus_control+"';\n";
query+="  VFECHA_DEVOLUCION := '"+pdevolucion+"';\n";
query+="  FECHA_RECEPCION := '"+pregreso+"';\n";
query+="\n";
query+="  SP_SALVA_AUDITORIA_PPT(\n";
query+="    VFECHA => VFECHA,\n";
query+="    VCOD_CUE => VCOD_CUE,\n";
query+="    VREVISADA_POR => VREVISADA_POR,\n";
query+="    VESTATUS_CONTROL => VESTATUS_CONTROL,\n";
query+="    VFECHA_DEVOLUCION => VFECHA_DEVOLUCION,\n";
query+="    FECHA_RECEPCION => FECHA_RECEPCION\n";
query+="  );\n";
query+="END;\n";

System.out.println(query);
                
       Class.forName ("oracle.jdbc.OracleDriver");
       Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.5.2:1521:STTCR", "Callcenter", "Call887795zty");
       try {
         Statement stmt = conn.createStatement();
         try {
           stmt.executeQuery(query);
         }
         finally {
               stmt.close(); 
         }
       }
       finally {
             conn.close(); 
       }
    }
     
    public void salvar_Llamada_Auditada_E_I(String pfecha,String ptarjeta,String previsada_por,String pstatus_control,String pdevolucion,String pregreso)throws Exception{
String query="DECLARE\n";
query+="  VFECHA VARCHAR2(200);\n";
query+="  VTARJETA VARCHAR2(200);\n";
query+="  VREVISADA_POR VARCHAR2(200);\n";
query+="  VESTATUS_CONTROL VARCHAR2(200);\n";
query+="  VFECHA_DEVOLUCION VARCHAR2(200);\n";
query+="  FECHA_RECEPCION VARCHAR2(200);\n";
query+="BEGIN\n";
query+="  VFECHA := '"+pfecha+"';\n";
query+="  VTARJETA := '"+ptarjeta+"';\n";
query+="  VREVISADA_POR := '"+previsada_por+"';\n";
query+="  VESTATUS_CONTROL := '"+pstatus_control+"';\n";
query+="  VFECHA_DEVOLUCION := '"+pdevolucion+"';\n";
query+="  FECHA_RECEPCION := '"+pregreso+"';\n";
query+="\n";
query+="  SP_SALVA_AUDITORIA_FINANC(\n";
query+="    VFECHA => VFECHA,\n";
query+="    VTARJETA => VTARJETA,\n";
query+="    VREVISADA_POR => VREVISADA_POR,\n";
query+="    VESTATUS_CONTROL => VESTATUS_CONTROL,\n";
query+="    VFECHA_DEVOLUCION => VFECHA_DEVOLUCION,\n";
query+="    FECHA_RECEPCION => FECHA_RECEPCION\n";
query+="  );\n";
query+="END;\n";


System.out.println(query);
                
       Class.forName ("oracle.jdbc.OracleDriver");
       Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.5.2:1521:STTCR", "Callcenter", "Call887795zty");
       try {
         Statement stmt = conn.createStatement();
         try {
           stmt.executeQuery(query);
         }
         finally {
               stmt.close(); 
         }
       }
       finally {
             conn.close(); 
       }
    }

    public void reset_cd_ppt()throws Exception{
String query="BEGIN\n";
query+="  SP_RESET_CD_PPT();\n";
query+="END;\n";

System.out.println(query);
                
       Class.forName ("oracle.jdbc.OracleDriver");
       Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.5.2:1521:STTCR", "Callcenter", "Call887795zty");
       try {
         Statement stmt = conn.createStatement();
         try {
           stmt.executeQuery(query);
         }
         finally {
               stmt.close(); 
         }
       }
       finally {
             conn.close(); 
       }
    }
    
    public String[][] getAuditarCAU(String pfecha)throws Exception{
String query="SELECT DISTINCT \n";
query+="  HORA_VENTA,\n";
query+="  U.NOMBRE_USUARIO,\n";
query+="  NOMBRE_CONTACTO,\n";
query+="  CEDULA_CONTACTO,\n";
query+="  TARJETA_CONTACTO,\n";
query+="  NOMBRE_SUBSCRICTOR,\n";
query+="  UBICACION_SERVICIO,\n";
query+="  CODIGO_SERVICIO,\n";
query+="  TELEFONO_CONTACTO,\n";
query+="  TIPO_PRODUCTO,\n";
query+="  CASE WHEN REVISADA_POR IS NULL THEN 'PENDIENTE' ELSE REVISADA_POR END AS REVISADA_POR,\n";
query+="  CASE WHEN ESTATUS_CONTROL IS NULL THEN 'PENDIENTE' ELSE ESTATUS_CONTROL END AS ESTATUS_CONTROL,\n";
query+="  CASE WHEN FECHA_DEVOLUCION_POR_CONTROL IS NULL THEN 'PENDIENTE' ELSE FECHA_DEVOLUCION_POR_CONTROL END AS FECHA_DEVOLUCION_POR_CONTROL,\n";
query+="  CASE WHEN FECHA_ENTREGADO_A_CONTROL IS NULL THEN 'PENDIENTE' ELSE FECHA_ENTREGADO_A_CONTROL END AS FECHA_ENTREGADO_A_CONTROL\n";
query+="FROM T_F_CARGO_AUTOMATICO F\n";
query+="JOIN T_USUARIO U ON F.COD_USUARIO=U.COD_USUARIO\n";
if (!pfecha.equals("")){query+="  AND HORA_VENTA LIKE '"+pfecha+"%'\n";}
query+="ORDER BY to_date(HORA_VENTA,'DD/MM/YYYY HH:MI AM'),CEDULA_CONTACTO\n";


System.out.println(query);
String resultado[][]=null;
       
       Class.forName ("oracle.jdbc.OracleDriver");
       Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.5.2:1521:STTCR", "Callcenter", "Call887795zty");
       try {
         Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
         try {
           ResultSet rs = stmt.executeQuery(query);
           ResultSetMetaData rsMd = rs.getMetaData();
           int columnas = rsMd.getColumnCount();
           rs.last();
           int filas = rs.getRow();
           rs.beforeFirst();
           resultado = new String[filas][columnas];
           int j=0;
           try{
             while (rs.next()){
                 resultado[j][0]=rs.getObject("HORA_VENTA").toString();
                 resultado[j][1]=rs.getObject("NOMBRE_USUARIO").toString();
                 resultado[j][2]=rs.getObject("NOMBRE_CONTACTO").toString();
                 resultado[j][3]=rs.getObject("CEDULA_CONTACTO").toString();
                 resultado[j][4]=rs.getObject("TARJETA_CONTACTO").toString();
                 resultado[j][5]=rs.getObject("NOMBRE_SUBSCRICTOR").toString();
                 resultado[j][6]=rs.getObject("UBICACION_SERVICIO").toString();
                 resultado[j][7]=rs.getObject("CODIGO_SERVICIO").toString();
                 resultado[j][8]=rs.getObject("TELEFONO_CONTACTO").toString();
                 resultado[j][9]=rs.getObject("TIPO_PRODUCTO").toString();
                 resultado[j][10]=rs.getObject("REVISADA_POR").toString();
                 resultado[j][11]=rs.getObject("ESTATUS_CONTROL").toString();
                 resultado[j][12]=rs.getObject("FECHA_DEVOLUCION_POR_CONTROL").toString();
                 resultado[j][13]=rs.getObject("FECHA_ENTREGADO_A_CONTROL").toString();
                 j++;  
             } 
           }
           finally {
                  rs.close(); 
           }
         } 
         finally {
               stmt.close(); 
         }
       } 
       finally {
             conn.close(); 
       }
    return resultado;  
    }
    
    public String[] buscaFechasCAU()throws Exception{
       
String query="SELECT DISTINCT \n";
query+="to_char(to_date(HORA_VENTA,'DD/MM/YYYY HH:MI AM'),'DD/MM/YYYY') AS HORA_VENTA\n";
query+="FROM T_F_CARGO_AUTOMATICO\n";
query+="ORDER BY to_date(HORA_VENTA,'DD/MM/YYYY HH:MI AM') DESC\n";
  
System.out.println(query);
       String resultado[]=null;
       
       Class.forName ("oracle.jdbc.OracleDriver");
       Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.5.2:1521:STTCR", "Callcenter", "Call887795zty");
       try {
         Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
         try {
           ResultSet rs = stmt.executeQuery(query);
           rs.last();
           int filas = rs.getRow();
           rs.beforeFirst();
           resultado = new String[filas];
           int j=0;
           try{
             while (rs.next()){
                 resultado[j]=rs.getObject("HORA_VENTA").toString();               
                 j++;  
             } 
           }
           finally {
                  rs.close(); 
           }
         } 
         finally {
               stmt.close(); 
         }
       } 
       finally {
             conn.close(); 
       }
    return resultado;    
    }
    
    public String[][] getCD_CAU()throws Exception{  
String query="SELECT DISTINCT \n";
query+="  --\n";
query+="  U.NOMBRE_USUARIO,\n";
query+="  HORA_VENTA,\n";
query+="  NOMBRE_CONTACTO,\n";
query+="  CEDULA_CONTACTO,\n";
query+="  TARJETA_CONTACTO,\n";
query+="  NOMBRE_SUBSCRICTOR,\n";
query+="  UBICACION_SERVICIO,\n";
query+="  CODIGO_SERVICIO,\n";
query+="  TELEFONO_CONTACTO,\n";
query+="  TIPO_PRODUCTO\n";
query+="FROM T_F_CARGO_AUTOMATICO F\n";
query+="JOIN T_USUARIO U ON F.COD_USUARIO=U.COD_USUARIO\n";
query+="WHERE SALES_ADMINISTRATION='ENVIAR'\n";
query+="ORDER BY to_date(HORA_VENTA,'DD/MM/YYYY HH:MI AM'),CEDULA_CONTACTO\n";

System.out.println(query);
String resultado[][]=null;
       
       Class.forName ("oracle.jdbc.OracleDriver");
       Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.5.2:1521:STTCR", "Callcenter", "Call887795zty");
       try {
         Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
         try {
           ResultSet rs = stmt.executeQuery(query);
           ResultSetMetaData rsMd = rs.getMetaData();
           int columnas = rsMd.getColumnCount();
           rs.last();
           int filas = rs.getRow();
           rs.beforeFirst();
           resultado = new String[filas][columnas];
           int j=0;
           try{
             while (rs.next()){
                 resultado[j][0]=rs.getObject("NOMBRE_USUARIO").toString();
                 resultado[j][1]=rs.getObject("HORA_VENTA").toString();
                 resultado[j][2]=rs.getObject("NOMBRE_CONTACTO").toString();
                 resultado[j][3]=rs.getObject("CEDULA_CONTACTO").toString();
                 resultado[j][4]=rs.getObject("TARJETA_CONTACTO").toString();
                 resultado[j][5]=rs.getObject("NOMBRE_SUBSCRICTOR").toString();
                 resultado[j][6]=rs.getObject("UBICACION_SERVICIO").toString();
                 resultado[j][7]=rs.getObject("CODIGO_SERVICIO").toString();
                 resultado[j][8]=rs.getObject("TELEFONO_CONTACTO").toString();
                 resultado[j][9]=rs.getObject("TIPO_PRODUCTO").toString();

                 j++;  
             } 
           }
           finally {
                  rs.close(); 
           }
         } 
         finally {
               stmt.close(); 
         }
       } 
       finally {
             conn.close(); 
       }
    return resultado;  
    }
    
    public void setCD_CAU(String phora_venta,String ptarjeta)throws Exception{
String query="DECLARE\n";
query+="  VHORA_VENTA VARCHAR2(200);\n";
query+="  VTARJETA VARCHAR2(200);\n";
query+="BEGIN\n";
query+="  VHORA_VENTA := '"+phora_venta+"';\n";
query+="  VTARJETA := '"+ptarjeta+"';\n";
query+="\n";
query+="  SP_CD_CAU(\n";
query+="    VHORA_VENTA => VHORA_VENTA,\n";
query+="    VTARJETA => VTARJETA\n";
query+="  );\n";
query+="END;\n";


System.out.println(query);
                
       Class.forName ("oracle.jdbc.OracleDriver");
       Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.5.2:1521:STTCR", "Callcenter", "Call887795zty");
       try {
         Statement stmt = conn.createStatement();
         try {
           stmt.executeQuery(query);
         }
         finally {
               stmt.close(); 
         }
       }
       finally {
             conn.close(); 
       }
    }
    
    public void setCD_FINANC(String phora_venta,String ptarjeta)throws Exception{
String query="DECLARE\n";
query+="  VHORA_VENTA VARCHAR2(200);\n";
query+="  VTARJETA VARCHAR2(200);\n";
query+="BEGIN\n";
query+="  VHORA_VENTA := '"+phora_venta+"';\n";
query+="  VTARJETA := '"+ptarjeta+"';\n";
query+="\n";
query+="  SP_CD_FINANCIAMIENTOS(\n";
query+="    VHORA_VENTA => VHORA_VENTA,\n";
query+="    VTARJETA => VTARJETA\n";
query+="  );\n";
query+="END;\n";


System.out.println(query);
                
       Class.forName ("oracle.jdbc.OracleDriver");
       Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.5.2:1521:STTCR", "Callcenter", "Call887795zty");
       try {
         Statement stmt = conn.createStatement();
         try {
           stmt.executeQuery(query);
         }
         finally {
               stmt.close(); 
         }
       }
       finally {
             conn.close(); 
       }
    }
 
    public void salvaAuditoriaCAU(String pfecha,String ptarjeta,String previsada_por,String pstatus_control,String pdevolucion,String pregreso)throws Exception{
String query="DECLARE\n";
query+="  VFECHA VARCHAR2(200);\n";
query+="  VTARJETA VARCHAR2(200);\n";
query+="  VREVISADA_POR VARCHAR2(200);\n";
query+="  VESTATUS_CONTROL VARCHAR2(200);\n";
query+="  VFECHA_DEVOLUCION VARCHAR2(200);\n";
query+="  FECHA_RECEPCION VARCHAR2(200);\n";
query+="BEGIN\n";
query+="  VFECHA := '"+pfecha+"';\n";
query+="  VTARJETA := '"+ptarjeta+"';\n";
query+="  VREVISADA_POR := '"+previsada_por+"';\n";
query+="  VESTATUS_CONTROL := '"+pstatus_control+"';\n";
query+="  VFECHA_DEVOLUCION := '"+pdevolucion+"';\n";
query+="  FECHA_RECEPCION := '"+pregreso+"';\n";
query+="\n";
query+="  SP_SALVA_AUDITORIA_CAU(\n";
query+="    VFECHA => VFECHA,\n";
query+="    VTARJETA => VTARJETA,\n";
query+="    VREVISADA_POR => VREVISADA_POR,\n";
query+="    VESTATUS_CONTROL => VESTATUS_CONTROL,\n";
query+="    VFECHA_DEVOLUCION => VFECHA_DEVOLUCION,\n";
query+="    FECHA_RECEPCION => FECHA_RECEPCION\n";
query+="  );\n";
query+="END;\n";


System.out.println(query);
                
       Class.forName ("oracle.jdbc.OracleDriver");
       Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.5.2:1521:STTCR", "Callcenter", "Call887795zty");
       try {
         Statement stmt = conn.createStatement();
         try {
           stmt.executeQuery(query);
         }
         finally {
               stmt.close(); 
         }
       }
       finally {
             conn.close(); 
       }
    }
    
    public void reset_cd_CAU()throws Exception{
String query="BEGIN\n";
query+="  SP_RESET_CD_CAU();\n";
query+="END;\n";

System.out.println(query);
                
       Class.forName ("oracle.jdbc.OracleDriver");
       Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.5.2:1521:STTCR", "Callcenter", "Call887795zty");
       try {
         Statement stmt = conn.createStatement();
         try {
           stmt.executeQuery(query);
         }
         finally {
               stmt.close(); 
         }
       }
       finally {
             conn.close(); 
       }
    }
    
    public void reset_cd_FINANC()throws Exception{
String query="BEGIN\n";
query+="  SP_RESET_CD_FINANC();\n";
query+="END;\n";

System.out.println(query);
                
       Class.forName ("oracle.jdbc.OracleDriver");
       Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.5.2:1521:STTCR", "Callcenter", "Call887795zty");
       try {
         Statement stmt = conn.createStatement();
         try {
           stmt.executeQuery(query);
         }
         finally {
               stmt.close(); 
         }
       }
       finally {
             conn.close(); 
       }
    }
    
    public String[][] getBaseAsesor(String pasesor)throws Exception{  
String query="SELECT DISTINCT \n";
query+="TB.CEDULA_CONTACTO,\n";
query+="C.NOMBRE_CONTACTO,\n";
query+="TB.ESTATUS_TELEFONO,\n";
query+="TB.COD_USUARIO,\n";
query+="CASE WHEN TB.FECHA_PROMESA IS NOT NULL THEN TB.FECHA_PROMESA  ELSE ' ' END AS FECHA_PROMESA,\n";
query+="CASE WHEN IA.desc_identificador IS NOT NULL THEN IA.desc_identificador ELSE ' ' END as plan,\n";
query+="CASE WHEN IB.desc_identificador IS  NOT NULL  THEN  IB.desc_identificador ELSE ' ' END as metal,\n";
query+="CASE WHEN IC.desc_identificador IS  NOT NULL  THEN  IC.desc_identificador ELSE ' ' END as limite,\n";
query+="CASE WHEN ID.desc_identificador IS  NOT NULL  THEN  ID.desc_identificador ELSE ' ' END as vencimiento,\n";
query+="MIN(TA.PRIORIDAD_A) AS PRIORIDAD_PROMESA,\n";
query+="CASE WHEN MIN(TA.PRIORIDAD_A)=1 THEN '01 VENTA' ELSE\n";
query+="  CASE WHEN MIN(TA.PRIORIDAD_A)=2 THEN '04 NO LE INTERESA' ELSE\n";
query+="    CASE WHEN MIN(TA.PRIORIDAD_A)=3 THEN '07 NO APLICA' ELSE\n";
query+="      CASE WHEN MIN(TA.PRIORIDAD_A)=4 THEN '09 CLIENTE MOLESTO' ELSE\n";
query+="        CASE WHEN MIN(TA.PRIORIDAD_A)=5 THEN '06 NUMEROS NO CORRESPONDEN' ELSE\n";
query+="          CASE WHEN MIN(TA.PRIORIDAD_A)=6 THEN '02 SEGUIMIENTO DE VENTA' ELSE\n";
query+="            CASE WHEN MIN(TA.PRIORIDAD_A)=7 THEN '03 VOLVER A LLAMAR' ELSE\n";
query+="              CASE WHEN MIN(TA.PRIORIDAD_A)=8 THEN '05 NO ESTA (REINTENTAR)' ELSE\n";
query+="                CASE WHEN MIN(TA.PRIORIDAD_A)=9 THEN '08 ILOCALIZABLE (POR HORARIO)' ELSE\n";
query+="                  CASE WHEN MIN(TA.PRIORIDAD_A)=10 THEN 'SIN PROMESA' ELSE\n";
query+="                  'N/A'\n";
query+="                  END END END END END END END END END END AS PROMESA_GENERAL\n";
query+="FROM (\n";
query+="        SELECT DISTINCT \n";
query+="        TA.CEDULA_CONTACTO,\n";
query+="        TA.NUMERO_TELEFONO,\n";
query+="        TA.COD_PROMESA,\n";
query+="        TA.COD_USUARIO,\n";
query+="        TO_DATE(TA.FECHA_PROMESA,'DD/MM/YYYY HH:MI AM'),\n";
query+="        MIN(\n";
query+="          CASE WHEN TA.COD_PROMESA='21' THEN 1 ELSE\n";
query+="            CASE WHEN TA.COD_PROMESA='22' THEN 6 ELSE\n";
query+="              CASE WHEN TA.COD_PROMESA='35' OR TA.COD_PROMESA='36' THEN 4 ELSE\n";
query+="                CASE WHEN TA.COD_PROMESA='31' THEN 5  ELSE\n";
query+="                  CASE WHEN TA.COD_PROMESA='23'  THEN 7  ELSE\n";
query+="                    CASE WHEN TA.COD_PROMESA='32' OR TA.COD_PROMESA='33' THEN 3  ELSE\n";
query+="                      CASE WHEN TA.COD_PROMESA='24' OR TA.COD_PROMESA='25'OR TA.COD_PROMESA='26'OR TA.COD_PROMESA='27'OR TA.COD_PROMESA='28'OR TA.COD_PROMESA='29' THEN 2 ELSE \n";
query+="                        CASE WHEN TA.COD_PROMESA='30' THEN 8 ELSE\n";
query+="                          CASE WHEN TA.COD_PROMESA='34' THEN 9 ELSE\n";
query+="                            CASE WHEN TA.COD_PROMESA='20' THEN 10 ELSE \n";
query+="11\n";
query+="                            END END END END END END END END END END \n";
query+="        )AS PRIORIDAD_A\n";
query+="        FROM T_TELEFONO TA\n";
query+="        --WHERE TA.ESTATUS_TELEFONO='COMPLETO'\n";
query+="        --AND TA.CEDULA_CONTACTO IN ('110670812','106210116','106930160','109820344')\n";
query+="        GROUP BY \n";
query+="        TA.CEDULA_CONTACTO,\n";
query+="        TA.NUMERO_TELEFONO,\n";
query+="        TA.COD_PROMESA,\n";
query+="        TA.COD_USUARIO,\n";
query+="        TA.FECHA_PROMESA\n";
query+="        ORDER BY TA.CEDULA_CONTACTO) TA     \n";
query+="JOIN T_TELEFONO TB ON TA.CEDULA_CONTACTO=TB.CEDULA_CONTACTO\n";
query+="left JOIN T_PROMESA P ON TB.COD_PROMESA=P.COD_PROMESA\n";
query+="JOIN T_CONTACTO C ON TB.CEDULA_CONTACTO=C.CEDULA_CONTACTO\n";
query+="left join t_identificador IA on tb.cedula_contacto=ia.cedula_contacto and ia.cod_identificador='PLAN'\n";
query+="left join t_identificador IB on tb.cedula_contacto=ib.cedula_contacto and ib.cod_identificador='METAL'\n";
query+="left join t_identificador IC on tb.cedula_contacto=ic.cedula_contacto and ic.cod_identificador='LIMITE'\n";
query+="left join t_identificador ID on tb.cedula_contacto=id.cedula_contacto and id.cod_identificador='VENCIMIENTO'\n";
query+="where ta.cod_usuario='"+pasesor+"' \n";
query+="GROUP BY\n";
query+="TB.CEDULA_CONTACTO,\n";
query+="C.NOMBRE_CONTACTO,\n";
query+="C.NOMBRE_BASE,\n";
query+="TB.ESTATUS_TELEFONO,\n";
query+="TB.COD_USUARIO,\n";
query+="TB.FECHA_PROMESA,\n";
query+="IA.desc_identificador,\n";
query+="IB.desc_identificador,\n";
query+="IC.desc_identificador,\n";
query+="ID.desc_identificador\n";
query+="ORDER BY TB.CEDULA_CONTACTO\n";



System.out.println(query);
String resultado[][]=null;
       
       Class.forName ("oracle.jdbc.OracleDriver");
       Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.5.2:1521:STTCR", "Callcenter", "Call887795zty");
       try {
         Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
         try {
           ResultSet rs = stmt.executeQuery(query);
           ResultSetMetaData rsMd = rs.getMetaData();
           int columnas = rsMd.getColumnCount();
           rs.last();
           int filas = rs.getRow();
           rs.beforeFirst();
           resultado = new String[filas][columnas];
           int j=0;
           try{
             while (rs.next()){
                 resultado[j][0]=rs.getObject("CEDULA_CONTACTO").toString();
                 resultado[j][1]=rs.getObject("NOMBRE_CONTACTO").toString();
                 resultado[j][2]=rs.getObject("PLAN").toString();
                 resultado[j][3]=rs.getObject("METAL").toString();
                 resultado[j][4]=rs.getObject("LIMITE").toString();
                 resultado[j][5]=rs.getObject("VENCIMIENTO").toString();
                 resultado[j][6]=rs.getObject("PROMESA_GENERAL").toString();
                 resultado[j][7]=rs.getObject("FECHA_PROMESA").toString();
                 resultado[j][8]=rs.getObject("ESTATUS_TELEFONO").toString();
                 
                 j++;  
             } 
           }
           finally {
                  rs.close(); 
           }
         } 
         finally {
               stmt.close(); 
         }
       } 
       finally {
             conn.close(); 
       }
    return resultado;  
    }
    
    public String[][] getResumenFinanciamiento(String pasesor,String pcedula)throws Exception{  
String query="SELECT DISTINCT\n";
query+="  PRODUCTO,\n";
query+="  TIPO,\n";
query+="  COD_USUARIO,\n";
query+="  NOMBRE_CONTACTO,\n";
query+="  MONTO_DESEMBOLSO,\n";
query+="  MONEDA_DESEMBOLSO,\n";
query+="  BANCO_DESTINO,\n";
query+="  PLAZO\n";
query+="FROM T_F_FINANCIAMIENTO\n";
query+="WHERE CEDULA_CONTACTO='"+pcedula+"'\n";
query+="AND COD_USUARIO='"+pasesor+"'\n";




System.out.println(query);
String resultado[][]=null;
       
       Class.forName ("oracle.jdbc.OracleDriver");
       Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.5.2:1521:STTCR", "Callcenter", "Call887795zty");
       try {
         Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
         try {
           ResultSet rs = stmt.executeQuery(query);
           ResultSetMetaData rsMd = rs.getMetaData();
           int columnas = rsMd.getColumnCount();
           rs.last();
           int filas = rs.getRow();
           rs.beforeFirst();
           resultado = new String[filas][columnas];
           int j=0;
           try{
             while (rs.next()){
                 resultado[j][0]=rs.getObject("PRODUCTO").toString();
                 resultado[j][1]=rs.getObject("TIPO").toString();
                 resultado[j][2]=rs.getObject("COD_USUARIO").toString();
                 resultado[j][3]=rs.getObject("NOMBRE_CONTACTO").toString();
                 resultado[j][4]=rs.getObject("MONTO_DESEMBOLSO").toString();
                 resultado[j][5]=rs.getObject("MONEDA_DESEMBOLSO").toString();
                 resultado[j][6]=rs.getObject("BANCO_DESTINO").toString();
                 resultado[j][7]=rs.getObject("PLAZO").toString();
                 
                 j++;  
             } 
           }
           finally {
                  rs.close(); 
           }
         } 
         finally {
               stmt.close(); 
         }
       } 
       finally {
             conn.close(); 
       }
    return resultado;  
    }
    
    public void guardaFormularioFinanciamientos(String pproducto,String ptipo,String pcod_usuario,String ptarjeta,String pnombre_contacto,String pcedula,String pmonto_d,String pmoneda_d,String pcomision,String ptasa,String pseguro,String psinpe,String ptelefono,String pbanco,String pmoneda_banco,String pvencimiento,String pcuota,String pplazo)throws Exception{
String query="DECLARE\n";
query+="  VHORA_VENTA VARCHAR2(200);\n";
query+="  VCANAL_VENTA VARCHAR2(200);\n";
query+="  VPRODUCTO VARCHAR2(200);\n";
query+="  VTIPO VARCHAR2(200);\n";
query+="  VSUPERVISOR VARCHAR2(200);\n";
query+="  VCOD_USUARIO VARCHAR2(200);\n";
query+="  VTARJETA_CONTACTO VARCHAR2(200);\n";
query+="  VNOMBRE_CONTACTO VARCHAR2(200);\n";
query+="  VCEDULA_CONTACTO VARCHAR2(200);\n";
query+="  VMONTO_DESEMBOLSO VARCHAR2(200);\n";
query+="  VMONEDA_DESEMBOLSO VARCHAR2(200);\n";
query+="  VCOMISION_DESEMBOLSO VARCHAR2(200);\n";
query+="  VTASA_INTERES VARCHAR2(200);\n";
query+="  VSEGURO_SALDO_DEUDOR VARCHAR2(200);\n";
query+="  VCUENTA_CLIENTE_SINPE VARCHAR2(200);\n";
query+="  VTELEFONO_CONTACTO VARCHAR2(200);\n";
query+="  VBANCO_DESTINO VARCHAR2(200);\n";
query+="  VMONEDA_DESTINO VARCHAR2(200);\n";
query+="  VVENCIMIENTO VARCHAR2(200);\n";
query+="  VCUOTA VARCHAR2(200);\n";
query+="  VPLAZO VARCHAR2(200);\n";
query+="BEGIN\n";
query+="  VHORA_VENTA := to_char(SYSDATE,'dd/mm/yyyy hh:mi am');\n";
query+="  VCANAL_VENTA := 'STT PA-INTRAS';\n";
query+="  VPRODUCTO := '"+pproducto+"';\n";
query+="  VTIPO := '"+ptipo+"';\n";
query+="  VSUPERVISOR := 'Josue Guido';\n";
query+="  VCOD_USUARIO := '"+pcod_usuario+"';\n";
query+="  VTARJETA_CONTACTO := '"+ptarjeta+"';\n";
query+="  VNOMBRE_CONTACTO := '"+pnombre_contacto+"';\n";
query+="  VCEDULA_CONTACTO := '"+pcedula+"';\n";
query+="  VMONTO_DESEMBOLSO := '"+pmonto_d+"';\n";
query+="  VMONEDA_DESEMBOLSO := '"+pmoneda_d+"';\n";
query+="  VCOMISION_DESEMBOLSO := '"+pcomision+"';\n";
query+="  VTASA_INTERES := '"+ptasa+"';\n";
query+="  VSEGURO_SALDO_DEUDOR := '"+pseguro+"';\n";
query+="  VCUENTA_CLIENTE_SINPE := '"+psinpe+"';\n";
query+="  VTELEFONO_CONTACTO := '"+ptelefono+"';\n";
query+="  VBANCO_DESTINO := '"+pbanco+"';\n";
query+="  VMONEDA_DESTINO := '"+pmoneda_banco+"';\n";
query+="  VVENCIMIENTO := '"+pvencimiento+"';\n";
query+="  VCUOTA := '"+pcuota+"';\n";
query+="  VPLAZO := '"+pplazo+"';\n";
query+="\n";
query+="  SP_LLENA_FORMULARIO_FINANC(\n";
query+="    VHORA_VENTA => VHORA_VENTA,\n";
query+="    VCANAL_VENTA => VCANAL_VENTA,\n";
query+="    VPRODUCTO => VPRODUCTO,\n";
query+="    VTIPO => VTIPO,\n";
query+="    VSUPERVISOR => VSUPERVISOR,\n";
query+="    VCOD_USUARIO => VCOD_USUARIO,\n";
query+="    VTARJETA_CONTACTO => VTARJETA_CONTACTO,\n";
query+="    VNOMBRE_CONTACTO => VNOMBRE_CONTACTO,\n";
query+="    VCEDULA_CONTACTO => VCEDULA_CONTACTO,\n";
query+="    VMONTO_DESEMBOLSO => VMONTO_DESEMBOLSO,\n";
query+="    VMONEDA_DESEMBOLSO => VMONEDA_DESEMBOLSO,\n";
query+="    VCOMISION_DESEMBOLSO => VCOMISION_DESEMBOLSO,\n";
query+="    VTASA_INTERES => VTASA_INTERES,\n";
query+="    VSEGURO_SALDO_DEUDOR => VSEGURO_SALDO_DEUDOR,\n";
query+="    VCUENTA_CLIENTE_SINPE => VCUENTA_CLIENTE_SINPE,\n";
query+="    VTELEFONO_CONTACTO => VTELEFONO_CONTACTO,\n";
query+="    VBANCO_DESTINO => VBANCO_DESTINO,\n";
query+="    VMONEDA_DESTINO => VMONEDA_DESTINO,\n";
query+="    VVENCIMIENTO => VVENCIMIENTO,\n";
query+="    VCUOTA => VCUOTA,\n";
query+="    VPLAZO => VPLAZO\n";
query+="  );\n";
query+="END;\n";


System.out.println(query);
                
       Class.forName ("oracle.jdbc.OracleDriver");
       Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.5.2:1521:STTCR", "Callcenter", "Call887795zty");
       try {
         Statement stmt = conn.createStatement();
         try {
           stmt.executeQuery(query);
         }
         finally {
               stmt.close(); 
         }
       }
       finally {
             conn.close(); 
       }
    }
    
    public String[][] getAuditarIntraExtra(String pfecha)throws Exception{  

String query="SELECT DISTINCT\n";
query+="  HORA_VENTA,\n";
query+="  CANAL_VENTA,\n";
query+="  PRODUCTO,\n";
query+="  TIPO,\n";
query+="  SUPERVISOR,\n";
query+="  COD_USUARIO,\n";
query+="  TARJETA_CONTACTO,\n";
query+="  NOMBRE_CONTACTO,\n";
query+="  CEDULA_CONTACTO,\n";
query+="  MONTO_DESEMBOLSO,\n";
query+="  MONEDA_DESEMBOLSO,\n";
query+="  COMISION_DESEMBOLSO,\n";
query+="  TASA_INTERES,\n";
query+="  SEGURO_SALDO_DEUDOR,\n";
query+="  CUENTA_CLIENTE_SINPE,\n";
query+="  TELEFONO_CONTACTO,\n";
query+="  BANCO_DESTINO,\n";
query+="  MONEDA_DESTINO,\n";
query+="  CASE WHEN VENCIMIENTO IS NULL THEN 'N/A' ELSE VENCIMIENTO END AS VENCIMIENTO,\n";
query+="  CUOTA,\n";
query+="  PLAZO,\n";
query+="  CASE WHEN REVISADA_POR IS NULL THEN 'PENDIENTE' ELSE REVISADA_POR END AS REVISADA_POR,\n";
query+="  CASE WHEN ESTATUS_CONTROL IS NULL THEN 'PENDIENTE' ELSE ESTATUS_CONTROL END AS ESTATUS_CONTROL,\n";
query+="  CASE WHEN FECHA_DEVOLUCION IS NULL THEN 'PENDIENTE' ELSE FECHA_DEVOLUCION END AS FECHA_DEVOLUCION,\n";
query+="  CASE WHEN FECHA_ENTREGA2 IS NULL THEN 'PENDIENTE' ELSE FECHA_ENTREGA2 END AS FECHA_ENTREGA2\n";
query+="FROM T_F_FINANCIAMIENTO\n";
if (!pfecha.equals("")){query+="  WHERE HORA_VENTA LIKE '"+pfecha+"%'\n";}
  
System.out.println(query);
String resultado[][]=null;
       
       Class.forName ("oracle.jdbc.OracleDriver");
       Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.5.2:1521:STTCR", "Callcenter", "Call887795zty");
       try {
         Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
         try {
           ResultSet rs = stmt.executeQuery(query);
           ResultSetMetaData rsMd = rs.getMetaData();
           int columnas = rsMd.getColumnCount();
           rs.last();
           int filas = rs.getRow();
           rs.beforeFirst();
           resultado = new String[filas][columnas];
           int j=0;
           try{
             while (rs.next()){
                 resultado[j][0]=rs.getObject("HORA_VENTA").toString();
                 resultado[j][1]=rs.getObject("CANAL_VENTA").toString();
                 resultado[j][2]=rs.getObject("PRODUCTO").toString();
                 resultado[j][3]=rs.getObject("TIPO").toString();
                 resultado[j][4]=rs.getObject("SUPERVISOR").toString();
                 resultado[j][5]=rs.getObject("COD_USUARIO").toString();
                 resultado[j][6]=rs.getObject("TARJETA_CONTACTO").toString();
                 resultado[j][7]=rs.getObject("NOMBRE_CONTACTO").toString();
                 resultado[j][8]=rs.getObject("CEDULA_CONTACTO").toString();
                 resultado[j][9]=rs.getObject("MONTO_DESEMBOLSO").toString();
                 resultado[j][10]=rs.getObject("MONEDA_DESEMBOLSO").toString();
                 resultado[j][11]=rs.getObject("COMISION_DESEMBOLSO").toString();
                 resultado[j][12]=rs.getObject("TASA_INTERES").toString();
                 resultado[j][13]=rs.getObject("SEGURO_SALDO_DEUDOR").toString();
                 resultado[j][14]=rs.getObject("CUENTA_CLIENTE_SINPE").toString();
                 resultado[j][15]=rs.getObject("TELEFONO_CONTACTO").toString();
                 resultado[j][16]=rs.getObject("BANCO_DESTINO").toString();
                 resultado[j][17]=rs.getObject("MONEDA_DESTINO").toString();
                 resultado[j][18]=rs.getObject("VENCIMIENTO").toString();
                 resultado[j][19]=rs.getObject("CUOTA").toString();
                 resultado[j][20]=rs.getObject("PLAZO").toString();
                 resultado[j][21]=rs.getObject("REVISADA_POR").toString();
                 resultado[j][22]=rs.getObject("ESTATUS_CONTROL").toString();
                 resultado[j][23]=rs.getObject("FECHA_DEVOLUCION").toString();
                 resultado[j][24]=rs.getObject("FECHA_ENTREGA2").toString();


                 j++;  
             } 
           }
           finally {
                  rs.close(); 
           }
         } 
         finally {
               stmt.close(); 
         }
       } 
       finally {
             conn.close(); 
       }
    return resultado;  
    }
    
    public String[] buscaFechasFinanc()throws Exception{
       
String query="SELECT DISTINCT \n";
query+="to_char(to_date(HORA_VENTA,'DD/MM/YYYY HH:MI AM'),'DD/MM/YYYY') AS HORA_VENTA\n";
query+="FROM T_F_FINANCIAMIENTO\n";
query+="ORDER BY to_date(HORA_VENTA,'DD/MM/YYYY HH:MI AM') DESC\n";
  
System.out.println(query);
       String resultado[]=null;
       
       Class.forName ("oracle.jdbc.OracleDriver");
       Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.5.2:1521:STTCR", "Callcenter", "Call887795zty");
       try {
         Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
         try {
           ResultSet rs = stmt.executeQuery(query);
           rs.last();
           int filas = rs.getRow();
           rs.beforeFirst();
           resultado = new String[filas];
           int j=0;
           try{
             while (rs.next()){
                 resultado[j]=rs.getObject("HORA_VENTA").toString();               
                 j++;  
             } 
           }
           finally {
                  rs.close(); 
           }
         } 
         finally {
               stmt.close(); 
         }
       } 
       finally {
             conn.close(); 
       }
    return resultado;    
    }
}
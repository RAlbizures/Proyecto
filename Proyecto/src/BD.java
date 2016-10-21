import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class BD {
	private String url = "jdbc:mysql://localhost/mydb";
 	private String us="root";
 	private String psw= "root";
 	private Connection conn;
 	private draw grafica;
 	
 	public BD (){
 		//conn = null;
	 	getCon();
 	}
 	
 	public Connection getCon(){
 		if (conn == null){
 			try{
 				Class.forName("com.mysql.jdbc.Connection");
 				conn = (Connection)DriverManager.getConnection(url, us, psw);
 				if(conn != null)
 				{
 					System.out.println("Conexion a base de datos "+url+" . . . Ok");
 				}
 			}
 			catch(SQLException ex){
 				System.out.println("Hubo un problema al intentar conecarse a la base de datos"+url);
 			}
 			catch(ClassNotFoundException ex){
 				System.out.println(ex);
 			}	
 		}
 		return conn;
 	}

 	
 	public double[] setDraw(){
 		
 		//* Inicializa statement para la consulta 
 		java.sql.Statement st = null;
 		String s=new String();
 		double[] gasto = new double[4];
 		
 		//* Crea el statement
	 	try {
			st = conn.createStatement();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	 	
	 	//*Extrae la informacion
	 	gasto[0]=getGasto(st,s,"Osio");
	 	gasto[1]=getGasto(st,s,"Estudios");
	 	gasto[2]=getGasto(st,s,"Servicios");
	 	gasto[3]=getGasto(st,s,"Comida");
	 	
	 	//*Crea grafica con los datos extraidos
	 	grafica = new draw(gasto[0],gasto[1],gasto[2],gasto[3]);
	 	
	 	//*Hace el total
	 	grafica.setTotal();
	 	
	 	//*Rescribe gasto con el porcentaje del gasto
	 	for (int i = 0; i<=3; i++){
	 		gasto[i]=grafica.getPorcentaje(gasto[i]);
	 	}
	 	
	 	//*termina la consulta
	 	try {
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 	
	 	return gasto;
	 	
 	}
 	
 	public int getGasto(java.sql.Statement st,String s ,String tipo){
 		int n=0;
 		
 		//* Hace la consulta
	 	try{
		 	s = "Select * from Dinero where Tipo = '"+ tipo +"';";
        	try {
        		ResultSet rs=st.executeQuery(s);
        		while (rs.next())
        	      {
        	        String id = rs.getString("CantDinero");
        	        n = Integer.parseInt(id)+n;
        	        // print the results
        	      }
        		
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	 	} catch (Exception exc){
	 		exc.printStackTrace();
	 	}
 		
 		return n;
 	}
 	
 	public void prueba(){
 		java.sql.Statement st = null;
 		String s=new String();
 		
	 	try {
			st = conn.createStatement();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	 	
	 	try{
		 	s = "Select * from Dinero where idDinero = 16;";
        	try {
        		System.out.println("idDinero");
        		ResultSet rs=st.executeQuery(s);
        		while (rs.next())
        	      {
        	        String id = rs.getString("idDinero");
        	        
        	        // print the results
        	        System.out.format("%s\n", id);
        	      }
        		st.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	 	} catch (Exception exc){
	 		exc.printStackTrace();
	 	}
 	}
}


package util;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;

public class DBHelper {
	//Database Driver
	private static final String driver= "com.mysql.jdbc.Driver";
	//URLaddress for database connection
	private static final String url = "jdbc:mysql://localhost:3306/make_money";

	//Username of database
    private static final String username = "Dream97";
    //password of database
    private static final String password = "1248310717";

    private static Connection conn = null;
    
    //static code for load driver
    static{
         try{
             Class.forName(driver);

         }catch(Exception ex){
             ex.printStackTrace();
         }
    }
    
    //return database connection object via single sample model
    public static Connection getConnection()throws Exception{
        if(conn == null){
            conn = (Connection) DriverManager.getConnection(url,username,password);
            return conn;
        }
        return conn;
    }
    
}
package Persistence;

import java.sql.*;

public class ConfigDB {

    static Connection connection = null;

    //Metodo para abrir
    public static Connection openConnection(){

        try{

            //Instalar drivers
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Credenciales
            String URL = "jdbc:mysql://localhost:3306/simulacroJava";
            String user = "root";
            String password = "";

            //Establecer la conexion
            connection = DriverManager.getConnection(URL, user, password);
            System.out.println("Conexion establecida");

        }catch (ClassNotFoundException e){
            System.out.println("ERROR: Driver no encontrado");
        }catch(SQLException e){
            System.out.println("ERROR: Conexion fallida");
        }

        return connection;

    }

    //Metodo para cerrar

    public static void closeConnection()throws SQLException{

        try{
            if (connection !=null) {
                connection.close();
                System.out.println("Conexion finalizada");
            }
        }catch(SQLException e){
            System.out.println("ERROR: Conexion no finalizada ");
        }

    }

}

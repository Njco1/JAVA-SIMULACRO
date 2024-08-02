package Model;

import java.util.ArrayList;

import javax.management.RuntimeErrorException;
import javax.naming.spi.DirStateFactory.Result;
import javax.swing.JOptionPane;

import java.security.PublicKey;
import java.sql.*;
import Entity.Avion;    
import Persistence.CRUD;
import Persistence.ConfigDB;

public class AvionModel implements CRUD {

    @Override
    public Object create(Object object) {

        //Abrir conexion
        Connection connection = ConfigDB.openConnection();

        //Transformar objeto
        Avion avion = (Avion) object;
        
        try{

            //Crear el SQLQUERY
            String sqlQuery = "INSERT INTO Avion(modelo, capacidad) values(?,?);";

            //Crear prepared Statement
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery, PreparedStatement.RETURN_GENERATED_KEYS);

        //Asignar a ?
        preparedStatement.setString(1, avion.getModelo());
        preparedStatement.setInt(2, avion.getCapacidad());

        //Execute el query
        preparedStatement.execute();

        //Obtener resultado
        ResultSet result = preparedStatement.getGeneratedKeys();

        while (result.next()) {
            avion.setId((result.getInt(1)));
        }

        preparedStatement.close();

        JOptionPane.showMessageDialog(null, "El avion ha sido creado correctamente", sqlQuery, 0);

        }catch (SQLException e){
            System.out.println("No se ha podido crear el avion correctamente");
        }

        try{
            ConfigDB.closeConnection();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }

        return avion;
    }

    @Override
    public Boolean delete(int id) {

        Connection connection = ConfigDB.openConnection();

        try{

            String sqlQuery = "DELETE FROM Avion WHERE id_avion = ?;";

            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);

        preparedStatement.setInt(1, id);

        int idEliminar = preparedStatement.executeUpdate();

        preparedStatement.close();

        if (idEliminar > 0) {
            JOptionPane.showMessageDialog(null, "El avion ha sido eliminado correctamente", sqlQuery, idEliminar);
            return true;
        }else{
            JOptionPane.showMessageDialog(null, "No se encontro el avion con ese Id", sqlQuery, idEliminar);
            return false;
        }

        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "No se ha podido eliminar el avion correctamente", null, id);
            return false;
        }finally{
            try{
                ConfigDB.closeConnection();
            }catch (SQLException e){
                throw new RuntimeException(e);
            }
        }
    }


    @Override
    public Object readById(int id) {

        Connection connection = ConfigDB.openConnection();

        Avion avion = null;

        try{

            String sqlQuery = "SELECT * FROM Avion WHERE id = ?;";

            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String modelo = resultSet.getString("modelo");
                int capacidad = resultSet.getInt("capacidad");

                avion = new Avion(id, modelo, capacidad);
            }

        }catch(SQLException e){
            System.out.println("ERROR: No se pudo consultar el avion: ");
        }

        try{
            ConfigDB.closeConnection();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public Object update(Object Object, int id) {
        return null;
    }

    

}

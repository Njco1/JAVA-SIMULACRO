import java.sql.*;

import Controller.AvionController;
import Entity.Avion;
import Persistence.ConfigDB;

public class Main {
    public static void main(String[] args) throws SQLException {
        
        ConfigDB.openConnection();

        AvionController objAvionController = new AvionController();
        objAvionController.create();
        objAvionController.delete();


        ConfigDB.closeConnection();
    }
}

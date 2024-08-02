package Controller;

import javax.swing.JOptionPane;
import Entity.Avion;
import Model.AvionModel;

public class AvionController {

    //Atributo del modelo
    AvionModel objAvionModel;

    public AvionController(){
        //Crear la instancia del estudiante modelo
        this.objAvionModel = new AvionModel();
    }

    public void create(){

        //Crear la instancia estudiantes

        //Agregar modelo
        String modelo = JOptionPane.showInputDialog("Inserte el modelo del avion: ");

        //Agregar capacidad
        int capacidad = Integer.parseInt(JOptionPane.showInputDialog("Inserte capacidad del avion: "));

        Avion objAvion = new Avion(modelo, capacidad);

        Avion result = (Avion) this.objAvionModel.create(objAvion);

        JOptionPane.showMessageDialog(null, result);
    }
    

    public void delete(){

        int idParaEliminar = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el Id a eliminar: "));
        
        boolean eliminarId = this.objAvionModel.delete(idParaEliminar);

        if (eliminarId == true) {
            JOptionPane.showMessageDialog(null, "El avion se ha eliminado correctamente");
        }else{
            JOptionPane.showMessageDialog(null, "Error al eliminar el avion, revise el id a eliminar", null, idParaEliminar);
        }

    }

    public void readById(){

        int idParaBuscar = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el Id a buscar: "));

    }
}

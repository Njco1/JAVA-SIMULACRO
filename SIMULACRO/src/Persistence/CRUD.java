package Persistence;
import java.util.ArrayList;

public interface CRUD {
    
    public Object create(Object object);
    public Object readById(int id);
    public ArrayList<Object> readAll();
    public Object update(Object Object, int id);
    public Boolean delete(int id);

}

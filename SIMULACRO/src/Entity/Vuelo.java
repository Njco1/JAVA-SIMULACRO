package Entity;
import java.sql.*;

public class Vuelo {
    
    private int id;
    private String destino;
    private Date fecha_salida;
    private Time hora_salida;
    private int id_avion_fk;

    public Vuelo (){}

    public Vuelo(String destino, Date fecha_salida, Time hora_salida, int id_avion_fk){
        this.destino = destino;
        this.fecha_salida = fecha_salida;
        this.hora_salida = hora_salida;
        this.id_avion_fk = id_avion_fk;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Date getFecha_salida() {
        return fecha_salida;
    }

    public void setFecha_salida(Date fecha_salida) {
        this.fecha_salida = fecha_salida;
    }

    public Time getHora_salida() {
        return hora_salida;
    }

    public void setHora_salida(Time hora_salida) {
        this.hora_salida = hora_salida;
    }

    public int getId_avion_fk() {
        return id_avion_fk;
    }

    public void setId_avion_fk(int id_avion_fk) {
        this.id_avion_fk = id_avion_fk;
    }


    @Override

    public String toString(){
        return "Vuelo {"+
                "id" + this.id +
                "destino" + this.destino +
                "fecha_salida" + this.fecha_salida +
                "hora_salida" + this.hora_salida +
                "id_avion_fk" + this.id_avion_fk +
                "}";
    }
    
}

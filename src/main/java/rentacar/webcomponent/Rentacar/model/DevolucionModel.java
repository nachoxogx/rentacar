/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rentacar.webcomponent.Rentacar.model;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Jose
 */
@Entity
@Table(name="Devolucion")
public class DevolucionModel {

    public static List<DevolucionModel> devolucion;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDevolucion;
    
    private String nombreDevolucion;
    private String detalle;
    private String fechaDevolucion;
    private String horaDevolucion;
    private ArriendoModel arriendo;

    public int getIdDevolucion() {
        return idDevolucion;
    }

    public void setIdDevolucion(int idDevolucion) {
        this.idDevolucion = idDevolucion;
    }

    public String getNombreDevolucion() {
        return nombreDevolucion;
    }

    public void setNombreDevolucion(String nombreDevolucion) {
        this.nombreDevolucion = nombreDevolucion;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(String fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public String getHoraDevolucion() {
        return horaDevolucion;
    }

    public void setHoraDevolucion(String horaDevolucion) {
        this.horaDevolucion = horaDevolucion;
    }

    public ArriendoModel getArriendo() {
        return arriendo;
    }

    public void setArriendo(ArriendoModel arriendo) {
        this.arriendo = arriendo;
    }

    public DevolucionModel() {
    }

    public DevolucionModel(String nombreDevolucion, String detalle, String fechaDevolucion, String horaDevolucion, ArriendoModel arriendo) {
        this.nombreDevolucion = nombreDevolucion;
        this.detalle = detalle;
        this.fechaDevolucion = fechaDevolucion;
        this.horaDevolucion = horaDevolucion;
        this.arriendo = arriendo;
    }

    private DevolucionModel(int idDevolucion, String nombreDevolucion, String detalle, String fechaDevolucion, String horaDevolucion, ArriendoModel arriendo) {
        this.idDevolucion = idDevolucion;
        this.nombreDevolucion = nombreDevolucion;
        this.detalle = detalle;
        this.fechaDevolucion = fechaDevolucion;
        this.horaDevolucion = horaDevolucion;
        this.arriendo = arriendo;
    }

  
    

   
    


    
}


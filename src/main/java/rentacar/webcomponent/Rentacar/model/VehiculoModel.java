/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rentacar.webcomponent.Rentacar.model;

import java.util.ArrayList;

/**
 *
 * @author nacho
 */
public class VehiculoModel {

    private int idVehiculo;
    private String patente;
    private int valor;
    private int año;
    private String color;
    private TipoVehiculoModel tipoVehiculo;
    private VersionModel version;

    public static ArrayList<VehiculoModel> vehiculo = new ArrayList<>();

    public int getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(int idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public TipoVehiculoModel getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(TipoVehiculoModel tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public VersionModel getVersion() {
        return version;
    }

    public void setVersion(VersionModel version) {
        this.version = version;
    }

    public static ArrayList<VehiculoModel> getVehiculo() {
        return vehiculo;
    }

    public static void setVehiculo(ArrayList<VehiculoModel> vehiculo) {
        VehiculoModel.vehiculo = vehiculo;
    }

    public VehiculoModel() {
    }

    public VehiculoModel(String patente, int valor, int año, String color, TipoVehiculoModel tipoVehiculo, VersionModel version) {
        this.patente = patente;
        this.valor = valor;
        this.año = año;
        this.color = color;
        this.tipoVehiculo = tipoVehiculo;
        this.version = version;
    }

    private VehiculoModel(int idVehiculo, String patente, int valor, int año, String color, TipoVehiculoModel tipoVehiculo, VersionModel version) {
        this.idVehiculo = idVehiculo;
        this.patente = patente;
        this.valor = valor;
        this.año = año;
        this.color = color;
        this.tipoVehiculo = tipoVehiculo;
        this.version = version;
    }
    
    
    
    
    
   public boolean nuevoVehiculo(VehiculoModel nuevoVehiculo) {

        int id = 0;
        if (!vehiculo.isEmpty()) {

            for (VehiculoModel vehiculos : vehiculo) {

                if (vehiculos.getIdVehiculo() > id) {
                    id = vehiculos.getIdVehiculo();
                }

            }

        }
        id++;
        vehiculo.add(new VehiculoModel(id, nuevoVehiculo.getPatente(), nuevoVehiculo.getValor(), nuevoVehiculo.getAño(), nuevoVehiculo.getColor(), nuevoVehiculo.getTipoVehiculo(), nuevoVehiculo.getVersion()));
        return true;

    }
/*
    esto es para buscar datos en su json para el codigo dejelo asi
    public nombredesuclasemodel buscar"nombredelatablaenlaimagen"(int idBuscar)
    */
    public VehiculoModel buscarVehiculo(int idBuscar) {

        VehiculoModel vehiculoEncontrado = null;

        if (!vehiculo.isEmpty()) {
            for (VehiculoModel vehiculos : vehiculo) {
                if (vehiculos.getIdVehiculo() == idBuscar) {
                    vehiculoEncontrado = vehiculos;
                }
            }
        }
        return vehiculoEncontrado;
    }
/*
    esto es para buscar datos en su json para el codigo dejelo asi
    public nombredesuclasemodel editar"nombredelatablaenlaimagen"(int idEditar, nombredesuclasemodel nombredelatablaenlaimagen"Editar")
    */
    public VehiculoModel editarVehiculo(int idEditar, VehiculoModel vehiculoEditar) {

        VehiculoModel vehiculoEditado = null;

        if (!vehiculo.isEmpty()) {
            for (VehiculoModel vehiculos : vehiculo) {
                if (vehiculos.getIdVehiculo() == idEditar) {
                    vehiculos.setPatente(vehiculoEditar.getPatente());
                    vehiculos.setValor(vehiculoEditar.getValor());
                    vehiculos.setAño(vehiculoEditar.getAño());
                    vehiculos.setColor(vehiculoEditar.getColor());
                    vehiculos.setTipoVehiculo(vehiculoEditar.getTipoVehiculo());
                    vehiculos.setVersion(vehiculoEditar.getVersion());
                    vehiculoEditado = vehiculos;
                }
            }
        }
        return vehiculoEditado;
    }
/*
    esto es para eliminar datos en su json para el codigo dejelo asi
    public boolean eliminar"nombredelatablaenlaimagen"(int idEliminar)
    */
    public boolean eliminarVehiculo(int idEliminar) {

        VehiculoModel vehiculoEliminar = null;

        if (!vehiculo.isEmpty()) {
            for (VehiculoModel vehiculos : vehiculo) {
                if (vehiculos.getIdVehiculo()== idEliminar) {
                    vehiculoEliminar = vehiculos;
                }
            }
        }

        vehiculo.remove(vehiculoEliminar);
        return true;
    }
    

}

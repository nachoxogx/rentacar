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
public class TipoVehiculoModel {

    private int idTipoVehiculo;
    private String nombreTipoVehiculo;
    private String detalle;

    public static ArrayList<TipoVehiculoModel> tipoVehiculo = new ArrayList<>();

    public int getIdTipoVehiculo() {
        return idTipoVehiculo;
    }

    public void setIdTipoVehiculo(int idTipoVehiculo) {
        this.idTipoVehiculo = idTipoVehiculo;
    }

    public String getNombreTipoVehiculo() {
        return nombreTipoVehiculo;
    }

    public void setNombreTipoVehiculo(String nombreTipoVehiculo) {
        this.nombreTipoVehiculo = nombreTipoVehiculo;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public static ArrayList<TipoVehiculoModel> getTipoVeiculo() {
        return tipoVehiculo;
    }

    public static void setTipoVeiculo(ArrayList<TipoVehiculoModel> tipoVehiculo) {
        TipoVehiculoModel.tipoVehiculo = tipoVehiculo;
    }

    public TipoVehiculoModel() {
    }

    public TipoVehiculoModel(String nombreTipoVehiculo, String detalle) {
        this.nombreTipoVehiculo = nombreTipoVehiculo;
        this.detalle = detalle;
    }

    private TipoVehiculoModel(int idTipoVehiculo, String nombreTipoVehiculo, String detalle) {
        this.idTipoVehiculo = idTipoVehiculo;
        this.nombreTipoVehiculo = nombreTipoVehiculo;
        this.detalle = detalle;
    }

    
    
    
    
    public boolean nuevoTipoVehiculo(TipoVehiculoModel nuevoTipoVehiculo) {

        int id = 0;
        if (!tipoVehiculo.isEmpty()) {

            for (TipoVehiculoModel tipoVehiculos : tipoVehiculo) {

                if (tipoVehiculos.getIdTipoVehiculo() > id) {
                    id = tipoVehiculos.getIdTipoVehiculo();
                }

            }

        }
        id++;
        tipoVehiculo.add(new TipoVehiculoModel(id, nuevoTipoVehiculo.getNombreTipoVehiculo(), nuevoTipoVehiculo.getDetalle()));
        return true;

    }

    /*
    esto es para buscar datos en su json para el codigo dejelo asi
    public nombredesuclasemodel buscar"nombredelatablaenlaimagen"(int idBuscar)
     */
    public TipoVehiculoModel buscarTipoVehiculo(int idBuscar) {

        TipoVehiculoModel tipoVehiculoEncontrado = null;

        if (!tipoVehiculo.isEmpty()) {
            for (TipoVehiculoModel tipoVehiculos : tipoVehiculo) {
                if (tipoVehiculos.getIdTipoVehiculo()== idBuscar) {
                    tipoVehiculoEncontrado = tipoVehiculos;
                }
            }
        }
        return tipoVehiculoEncontrado;
    }

    /*
    esto es para buscar datos en su json para el codigo dejelo asi
    public nombredesuclasemodel editar"nombredelatablaenlaimagen"(int idEditar, nombredesuclasemodel nombredelatablaenlaimagen"Editar")
     */
    public TipoVehiculoModel editarTipoVehiculo(int idEditar, TipoVehiculoModel tipoVehiculoEditar) {

        TipoVehiculoModel tipoVehiculoEditado = null;

        if (!tipoVehiculo.isEmpty()) {
            for (TipoVehiculoModel tipoVehiculos : tipoVehiculo) {
                if (tipoVehiculos.getIdTipoVehiculo() == idEditar) {
                    tipoVehiculos.setNombreTipoVehiculo(tipoVehiculoEditar.getNombreTipoVehiculo());
                    tipoVehiculos.setDetalle(tipoVehiculoEditar.getDetalle());
                    tipoVehiculoEditado = tipoVehiculos;
                }
            }
        }
        return tipoVehiculoEditado;
    }

    /*
    esto es para eliminar datos en su json para el codigo dejelo asi
    public boolean eliminar"nombredelatablaenlaimagen"(int idEliminar)
     */
    public boolean eliminarTipoVehiculo(int idEliminar) {

        TipoVehiculoModel tipoVehiculoEliminar = null;

        if (!tipoVehiculo.isEmpty()) {
            for (TipoVehiculoModel tipoVehiculos : tipoVehiculo) {
                if (tipoVehiculos.getIdTipoVehiculo()== idEliminar) {
                    tipoVehiculoEliminar = tipoVehiculos;
                }
            }
        }

        tipoVehiculo.remove(tipoVehiculoEliminar);
        return true;
    }

}

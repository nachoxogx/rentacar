/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rentacar.webcomponent.Rentacar.model;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author nacho
 */
public class ArriendoModel {

    private int idArriendo;
    private Date fechaArriendo;
    private Time horaArriendo;
    private PersonaModel vendedor;
    private PersonaModel cliente;
    private VehiculoModel vehiculo;
    private MediopagoModel medioPago;

    public static ArrayList<ArriendoModel> arriendo = new ArrayList<>();

    public int getIdArriendo() {
        return idArriendo;
    }

    public void setIdArriendo(int idArriendo) {
        this.idArriendo = idArriendo;
    }

    public Date getFechaArriendo() {
        return fechaArriendo;
    }

    public void setFechaArriendo(Date fechaArriendo) {
        this.fechaArriendo = fechaArriendo;
    }

    public Time getHoraArriendo() {
        return horaArriendo;
    }

    public void setHoraArriendo(Time horaArriendo) {
        this.horaArriendo = horaArriendo;
    }

    public PersonaModel getVendedor() {
        return vendedor;
    }

    public void setVendedor(PersonaModel vendedor) {
        this.vendedor = vendedor;
    }

    public PersonaModel getCliente() {
        return cliente;
    }

    public void setCliente(PersonaModel cliente) {
        this.cliente = cliente;
    }

    public VehiculoModel getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(VehiculoModel vehiculo) {
        this.vehiculo = vehiculo;
    }

    public MediopagoModel getMedioPago() {
        return medioPago;
    }

    public void setMedioPago(MediopagoModel medioPago) {
        this.medioPago = medioPago;
    }

    public static ArrayList<ArriendoModel> getArriendo() {
        return arriendo;
    }

    public static void setArriendo(ArrayList<ArriendoModel> arriendo) {
        ArriendoModel.arriendo = arriendo;
    }

    public ArriendoModel() {
    }

    public ArriendoModel(Date fechaArriendo, Time horaArriendo, PersonaModel vendedor, PersonaModel cliente, VehiculoModel vehiculo, MediopagoModel medioPago) {
        this.fechaArriendo = fechaArriendo;
        this.horaArriendo = horaArriendo;
        this.vendedor = vendedor;
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.medioPago = medioPago;
    }

    private ArriendoModel(int idArriendo, Date fechaArriendo, Time horaArriendo, PersonaModel vendedor, PersonaModel cliente, VehiculoModel vehiculo, MediopagoModel medioPago) {
        this.idArriendo = idArriendo;
        this.fechaArriendo = fechaArriendo;
        this.horaArriendo = horaArriendo;
        this.vendedor = vendedor;
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.medioPago = medioPago;
    }

    public boolean nuevoArriendo(ArriendoModel nuevoArriendo) {

        int id = 0;
        if (!arriendo.isEmpty()) {

            for (ArriendoModel arriendos : arriendo) {

                if (arriendos.getIdArriendo()> id) {
                    id = arriendos.getIdArriendo();
                }

            }

        }
        id++;
        int idPago = nuevoArriendo.getMedioPago().getIdMediopago();
        arriendo.add(new ArriendoModel(id, nuevoArriendo.getFechaArriendo(), nuevoArriendo.getHoraArriendo(),
                nuevoArriendo.getVendedor(), nuevoArriendo.getCliente(), nuevoArriendo.getVehiculo(),
                nuevoArriendo.getMedioPago().buscarMediopago(idPago)));
        return true;

    }
/*
    esto es para buscar datos en su json para el codigo dejelo asi
    public nombredesuclasemodel buscar"nombredelatablaenlaimagen"(int idBuscar)
    */
    public ArriendoModel buscarArriendo(int idBuscar) {

        ArriendoModel arriendoEncontrado = null;

        if (!arriendo.isEmpty()) {
            for (ArriendoModel arriendos : arriendo) {
                if (arriendos.getIdArriendo() == idBuscar) {
                    arriendoEncontrado = arriendos;
                }
            }
        }
        return arriendoEncontrado;
    }
/*
    esto es para buscar datos en su json para el codigo dejelo asi
    public nombredesuclasemodel editar"nombredelatablaenlaimagen"(int idEditar, nombredesuclasemodel nombredelatablaenlaimagen"Editar")
    */
    public ArriendoModel editarArriendo(int idEditar, ArriendoModel arriendoEditar) {

        ArriendoModel arriendoEditado = null;

        if (!arriendo.isEmpty()) {
            for (ArriendoModel arriendos : arriendo) {
                if (arriendos.getIdArriendo()== idEditar) {
                    arriendos.setFechaArriendo(arriendoEditar.getFechaArriendo());
                    arriendos.setHoraArriendo(arriendoEditar.getHoraArriendo());
                    arriendos.setVendedor(arriendoEditar.getVendedor());
                    arriendos.setCliente(arriendoEditar.getCliente());
                    arriendos.setVehiculo(arriendoEditar.getVehiculo());
                    arriendos.setMedioPago(arriendoEditar.getMedioPago());
                    arriendoEditado = arriendos;
                }
            }
        }
        return arriendoEditado;
    }
/*
    esto es para eliminar datos en su json para el codigo dejelo asi
    public boolean eliminar"nombredelatablaenlaimagen"(int idEliminar)
    */
    public boolean eliminarArriendo(int idEliminar) {

        ArriendoModel arriendoEliminar = null;

        if (!arriendo.isEmpty()) {
            for (ArriendoModel arriendos : arriendo) {
                if (arriendos.getIdArriendo()== idEliminar) {
                    arriendoEliminar = arriendos;
                }
            }
        }

        arriendo.remove(arriendoEliminar);
        return true;
    }
    

}

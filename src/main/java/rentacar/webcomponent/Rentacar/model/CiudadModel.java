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

public class CiudadModel {

    private int idCiudad;
    private String nombreCiudad;
    private String Detalle;
    private RegionModel region;
    
    
    public static ArrayList<CiudadModel> Ciudad = new ArrayList<>();

    public int getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(int idCiudad) {
        this.idCiudad = idCiudad;
    }

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }

    public String getDetalle() {
        return Detalle;
    }

    public void setDetalle(String Detalle) {
        this.Detalle = Detalle;
    }

    public RegionModel getRegion() {
        return region;
    }

    public void setRegion(RegionModel region) {
        this.region = region;
    }

    public static ArrayList<CiudadModel> getCiudad() {
        return Ciudad;
    }

    public static void setCiudad(ArrayList<CiudadModel> Ciudad) {
        CiudadModel.Ciudad = Ciudad;
    }

    public CiudadModel() {
    }

    public CiudadModel(String nombreCiudad, String Detalle, RegionModel region) {
        this.nombreCiudad = nombreCiudad;
        this.Detalle = Detalle;
        this.region = region;
    }

    private CiudadModel(int idCiudad, String nombreCiudad, String Detalle, RegionModel region) {
        this.idCiudad = idCiudad;
        this.nombreCiudad = nombreCiudad;
        this.Detalle = Detalle;
        this.region = region;
    }
    
/*
    
    public boolean nueva"Ciudad"(Ciudadmodel nueva"Ciudad")
    */
    public boolean nuevaCiudad(CiudadModel nuevaCiudad) {

        int id = 0;
        if (!Ciudad.isEmpty()) {

            for (CiudadModel Ciudad : Ciudad) {

                if (Ciudad.getIdCiudad() > id) {
                    id = Ciudad.getIdCiudad();
                }

            }

        }
        id++;
        Ciudad.add(new CiudadModel(id, nuevaCiudad.getNombreCiudad(), nuevaCiudad.getDetalle(),
                nuevaCiudad.getRegion()));
               
        return true;

    }

    public CiudadModel buscarCiudad(int idCiudad) {

        CiudadModel CiudadEncontrada = null;

        if (!Ciudad.isEmpty()) {
            for (CiudadModel Ciudades : Ciudad) {
                if (Ciudades.getIdCiudad() == idCiudad){
                    CiudadEncontrada = Ciudades;
                }
            }
        }
        return CiudadEncontrada;
    }

    public CiudadModel editarCiudad(int idCiudad, CiudadModel CiudadEditar) {

      CiudadModel CiudadEditada = null;

        if (!Ciudad.isEmpty()) {
            for (CiudadModel Ciudades : Ciudad) {
                if (Ciudades.getIdCiudad()== idCiudad) {
                    Ciudades.setNombreCiudad(CiudadEditar.getNombreCiudad());
                    Ciudades.setDetalle(CiudadEditar.getDetalle());
                    Ciudades.setRegion(CiudadEditar.getRegion());
                    CiudadEditada = Ciudades;
                }
            }
        }
        return CiudadEditada;
    }


    public boolean eliminarCiudad(int idEliminar) {

        CiudadModel CiudadEliminar = null;

        if (!Ciudad.isEmpty()) {
            for (CiudadModel Ciudades : Ciudad) {
                if (Ciudades.getIdCiudad() == idEliminar) {
                    CiudadEliminar = Ciudades;
                }
            }
        }

        Ciudad.remove(CiudadEliminar);
        return true;
    }
}


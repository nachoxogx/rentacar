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
public class VersionModel {

    private int idVersion;
    private String nombre;
    private String detalle;
    private int puertas;
    private int pasajeros;
    private float cilindrada;
    private float rendimiento;
    private int capacidadMaletero;
    private int airbags;
    private boolean aireAcondicionado;
    private boolean cierreCentralizado;
    private boolean alzaVidriosElectricos;
    private boolean camaraRetroceso;
    private CombustibleModel combustible;
    private CarroceriaModel carroceria;
    private TransmisionModel transmision;
    private TraccionModel traccion;
    private ModeloModel modelo;

    public static ArrayList<VersionModel> version = new ArrayList<>();

    public int getIdVersion() {
        return idVersion;
    }

    public void setIdVersion(int idVersion) {
        this.idVersion = idVersion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public int getPuertas() {
        return puertas;
    }

    public void setPuertas(int puertas) {
        this.puertas = puertas;
    }

    public int getPasajeros() {
        return pasajeros;
    }

    public void setPasajeros(int pasajeros) {
        this.pasajeros = pasajeros;
    }

    public float getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(float cilindrada) {
        this.cilindrada = cilindrada;
    }

    public float getRendimiento() {
        return rendimiento;
    }

    public void setRendimiento(float rendimiento) {
        this.rendimiento = rendimiento;
    }

    public int getCapacidadMaletero() {
        return capacidadMaletero;
    }

    public void setCapacidadMaletero(int capacidadMaletero) {
        this.capacidadMaletero = capacidadMaletero;
    }

    public int getAirbags() {
        return airbags;
    }

    public void setAirbags(int airbags) {
        this.airbags = airbags;
    }

    public boolean isAireAcondicionado() {
        return aireAcondicionado;
    }

    public void setAireAcondicionado(boolean aireAcondicionado) {
        this.aireAcondicionado = aireAcondicionado;
    }

    public boolean isCierreCentralizado() {
        return cierreCentralizado;
    }

    public void setCierreCentralizado(boolean cierreCentralizado) {
        this.cierreCentralizado = cierreCentralizado;
    }

    public boolean isAlzaVidriosElectricos() {
        return alzaVidriosElectricos;
    }

    public void setAlzaVidriosElectricos(boolean alzaVidriosElectricos) {
        this.alzaVidriosElectricos = alzaVidriosElectricos;
    }

    public boolean isCamaraRetroceso() {
        return camaraRetroceso;
    }

    public void setCamaraRetroceso(boolean camaraRetroceso) {
        this.camaraRetroceso = camaraRetroceso;
    }

    public CombustibleModel getCombustible() {
        return combustible;
    }

    public void setCombustible(CombustibleModel combustible) {
        this.combustible = combustible;
    }

    public CarroceriaModel getCarroceria() {
        return carroceria;
    }

    public void setCarroceria(CarroceriaModel carroceria) {
        this.carroceria = carroceria;
    }

    public TransmisionModel getTransmision() {
        return transmision;
    }

    public void setTransmision(TransmisionModel transmision) {
        this.transmision = transmision;
    }

    public TraccionModel getTraccion() {
        return traccion;
    }

    public void setTraccion(TraccionModel traccion) {
        this.traccion = traccion;
    }

    public ModeloModel getModelo() {
        return modelo;
    }

    public void setModelo(ModeloModel modelo) {
        this.modelo = modelo;
    }

    public static ArrayList<VersionModel> getVersion() {
        return version;
    }

    public static void setVersion(ArrayList<VersionModel> version) {
        VersionModel.version = version;
    }

    public VersionModel() {
    }

    public VersionModel(String nombre, String detalle, int puertas, int pasajeros, float cilindrada, float rendimiento, int capacidadMaletero, int airbags, boolean aireAcondicionado, boolean cierreCentralizado, boolean alzaVidriosElectricos, boolean camaraRetroceso, CombustibleModel combustible, CarroceriaModel carroceria, TransmisionModel transmision, TraccionModel traccion, ModeloModel modelo) {
        this.nombre = nombre;
        this.detalle = detalle;
        this.puertas = puertas;
        this.pasajeros = pasajeros;
        this.cilindrada = cilindrada;
        this.rendimiento = rendimiento;
        this.capacidadMaletero = capacidadMaletero;
        this.airbags = airbags;
        this.aireAcondicionado = aireAcondicionado;
        this.cierreCentralizado = cierreCentralizado;
        this.alzaVidriosElectricos = alzaVidriosElectricos;
        this.camaraRetroceso = camaraRetroceso;
        this.combustible = combustible;
        this.carroceria = carroceria;
        this.transmision = transmision;
        this.traccion = traccion;
        this.modelo = modelo;
    }

    private VersionModel(int idVersion, String nombre, String detalle, int puertas, int pasajeros, float cilindrada, float rendimiento, int capacidadMaletero, int airbags, boolean aireAcondicionado, boolean cierreCentralizado, boolean alzaVidriosElectricos, boolean camaraRetroceso, CombustibleModel combustible, CarroceriaModel carroceria, TransmisionModel transmision, TraccionModel traccion, ModeloModel modelo) {
        this.idVersion = idVersion;
        this.nombre = nombre;
        this.detalle = detalle;
        this.puertas = puertas;
        this.pasajeros = pasajeros;
        this.cilindrada = cilindrada;
        this.rendimiento = rendimiento;
        this.capacidadMaletero = capacidadMaletero;
        this.airbags = airbags;
        this.aireAcondicionado = aireAcondicionado;
        this.cierreCentralizado = cierreCentralizado;
        this.alzaVidriosElectricos = alzaVidriosElectricos;
        this.camaraRetroceso = camaraRetroceso;
        this.combustible = combustible;
        this.carroceria = carroceria;
        this.transmision = transmision;
        this.traccion = traccion;
        this.modelo = modelo;
    }
    
    
    

    public boolean nuevaVersion(VersionModel nuevaVersion) {

        int id = 0;
        if (!version.isEmpty()) {

            for (VersionModel versiones : version) {

                if (versiones.getIdVersion() > id) {
                    id = versiones.getIdVersion();
                }

            }

        }
        id++;
        nuevaVersion.getModelo();
        version.add(new VersionModel(id , nuevaVersion.getNombre(), nuevaVersion.getDetalle(),
                nuevaVersion.getPuertas(), nuevaVersion.getPasajeros(), nuevaVersion.getCilindrada(), nuevaVersion.getRendimiento(),
                nuevaVersion.getCapacidadMaletero(), nuevaVersion.getAirbags(), nuevaVersion.isAireAcondicionado(),
                nuevaVersion.isCierreCentralizado(), nuevaVersion.isAlzaVidriosElectricos(), nuevaVersion.isCamaraRetroceso(),
                nuevaVersion.getCombustible(), nuevaVersion.getCarroceria(), nuevaVersion.getTransmision(),
                nuevaVersion.getTraccion(), nuevaVersion.getModelo()));
        return true;

    }

    /*
    esto es para buscar datos en su json para el codigo dejelo asi
    public nombredesuclasemodel buscar"nombredelatablaenlaimagen"(int idBuscar)
     */
    public VersionModel buscarVersion(int idBuscar) {

        VersionModel versionEncontrada = null;

        if (!version.isEmpty()) {
            for (VersionModel versiones : version) {
                if (versiones.getIdVersion() == idBuscar) {
                    versionEncontrada = versiones;
                }
            }
        }
        return versionEncontrada;
    }

    /*
    esto es para buscar datos en su json para el codigo dejelo asi
    public nombredesuclasemodel editar"nombredelatablaenlaimagen"(int idEditar, nombredesuclasemodel nombredelatablaenlaimagen"Editar")
     */
    public VersionModel editarVersion(int idEditar, VersionModel versionEditar) {

        VersionModel versionEditada = null;

        if (!version.isEmpty()) {
            for (VersionModel versiones : version) {
                if (versiones.getIdVersion() == idEditar) {
                    versiones.setNombre(versionEditar.getNombre());
                    versiones.setDetalle(versionEditar.getDetalle());
                    versiones.setPuertas(versionEditar.getPuertas());
                    versiones.setPasajeros(versionEditar.getPasajeros());
                    versiones.setCilindrada(versionEditar.getCilindrada());
                    versiones.setRendimiento(versionEditar.getRendimiento());
                    versiones.setCapacidadMaletero(versionEditar.getCapacidadMaletero());
                    versiones.setAirbags(versionEditar.getAirbags());
                    versiones.setAireAcondicionado(versionEditar.isAireAcondicionado());
                    versiones.setCierreCentralizado(versionEditar.isCierreCentralizado());
                    versiones.setAlzaVidriosElectricos(versionEditar.isAlzaVidriosElectricos());
                    versiones.setCamaraRetroceso(versionEditar.isCamaraRetroceso());
                    versiones.setCombustible(versionEditar.getCombustible());
                    versiones.setCarroceria(versionEditar.getCarroceria());
                    versiones.setTraccion(versionEditar.getTraccion());
                    versiones.setModelo(versionEditar.getModelo());

                    versionEditada = versiones;
                }
            }
        }
        return versionEditada;
    }

    /*
    esto es para eliminar datos en su json para el codigo dejelo asi
    public boolean eliminar"nombredelatablaenlaimagen"(int idEliminar)
     */
    public boolean eliminarVersion(int idEliminar) {

        VersionModel versionEliminar = null;

        if (!version.isEmpty()) {
            for (VersionModel versiones : version) {
                if (versiones.getIdVersion()== idEliminar) {
                    versionEliminar = versiones;
                }
            }
        }

        version.remove(versionEliminar);
        return true;
    }

}

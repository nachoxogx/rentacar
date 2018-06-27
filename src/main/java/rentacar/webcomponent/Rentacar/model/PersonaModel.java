/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rentacar.webcomponent.Rentacar.model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author nacho
 */
//RECUERDEN QUE ESTA ES UNA CLASE NORMAL DE JAVA, SE CREA COMO CUALQUIER OTRA
public class PersonaModel {
//se declaran las variables que aparecen en la imagen como privadas
    private int idPersona;
    private String rut;
    private String nombre;
    private String apellido;
    private Date fechaNacimiento;
    private String telefono;
    private String direccion1;
    private String direccion2;
    private CiudadModel ciudad;
    private TipoPersonaModel tipoPersona;
    /*se crea un arraylist de la siguiente forma
    public static ArrayList<nombredelaclasemodelo> nombredelatablaenlaimagen = new ArrayList<>();
    */
    public static ArrayList<PersonaModel> persona = new ArrayList<>();
/*
    se crean los getter y setter
    */
    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion1() {
        return direccion1;
    }

    public void setDireccion1(String direccion1) {
        this.direccion1 = direccion1;
    }

    public String getDireccion2() {
        return direccion2;
    }

    public void setDireccion2(String direccion2) {
        this.direccion2 = direccion2;
    }

    public CiudadModel getCiudad() {
        return ciudad;
    }

    public void setCiudad(CiudadModel ciudad) {
        this.ciudad = ciudad;
    }

    public TipoPersonaModel getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(TipoPersonaModel tipoPersona) {
        this.tipoPersona = tipoPersona;
    }

    public static ArrayList<PersonaModel> getPersona() {
        return persona;
    }

    public static void setPersona(ArrayList<PersonaModel> persona) {
        PersonaModel.persona = persona;
    }
    /*
    se crean los constructores, uno vacio, uno con todos los datos excepto el id, 
    y otro con todos los datos incluyendo el id pero se cambia de publico a privado
    */
    public PersonaModel() {
    }

    public PersonaModel(String rut, String nombre, String apellido, Date fechaNacimiento, String telefono, String direccion1, String direccion2, CiudadModel ciudad, TipoPersonaModel tipoPersona) {
        this.rut = rut;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.direccion1 = direccion1;
        this.direccion2 = direccion2;
        this.ciudad = ciudad;
        this.tipoPersona = tipoPersona;
    }
    /*
    cambiar el tipo de public a private luego de crear el constuctor
    con todos los datos, como se ve aqui
    */
    private PersonaModel(int idPersona, String rut, String nombre, String apellido, Date fechaNacimiento, String telefono, String direccion1, String direccion2, CiudadModel ciudad, TipoPersonaModel tipoPersona) {
        this.idPersona = idPersona;
        this.rut = rut;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.direccion1 = direccion1;
        this.direccion2 = direccion2;
        this.ciudad = ciudad;
        this.tipoPersona = tipoPersona;
    }
/*
    esto es para añadir datos a su json para el codigo dejelo asi
    public boolean nueva"nombredelatablaenlaimagen"(nombredesuclasemodel nueva"nombredelatablaenlaimagen")
    */
    public boolean nuevaPersona(PersonaModel nuevaPersona) {

        int id = 0;
        if (!persona.isEmpty()) {

            for (PersonaModel personas : persona) {

                if (personas.getIdPersona() > id) {
                    id = personas.getIdPersona();
                }

            }

        }
        id++;
        persona.add(new PersonaModel(id, nuevaPersona.getRut(), nuevaPersona.getNombre(),
                nuevaPersona.getApellido(), nuevaPersona.getFechaNacimiento(), nuevaPersona.getTelefono(),
                nuevaPersona.getDireccion1(), nuevaPersona.getDireccion2(), nuevaPersona.getCiudad(), nuevaPersona.getTipoPersona()));
        return true;

    }
/*
    esto es para buscar datos en su json para el codigo dejelo asi
    public nombredesuclasemodel buscar"nombredelatablaenlaimagen"(int idBuscar)
    */
    public PersonaModel buscarPersona(int idBuscar) {

        PersonaModel personaEncontrada = null;

        if (!persona.isEmpty()) {
            for (PersonaModel personas : persona) {
                if (personas.getIdPersona() == idBuscar) {
                    personaEncontrada = personas;
                }
            }
        }
        return personaEncontrada;
    }
/*
    esto es para buscar datos en su json para el codigo dejelo asi
    public nombredesuclasemodel editar"nombredelatablaenlaimagen"(int idEditar, nombredesuclasemodel nombredelatablaenlaimagen"Editar")
    */
    public PersonaModel editarPersona(int idEditar, PersonaModel personaEditar) {

        PersonaModel personaEditada = null;

        if (!persona.isEmpty()) {
            for (PersonaModel personas : persona) {
                if (personas.getIdPersona() == idEditar) {
                    personas.setRut(personaEditar.getRut());
                    personas.setNombre(personaEditar.getNombre());
                    personas.setApellido(personaEditar.getApellido());
                    personas.setFechaNacimiento(personaEditar.getFechaNacimiento());
                    personas.setTelefono(personaEditar.getTelefono());
                    personas.setDireccion1(personaEditar.getDireccion1());
                    personas.setDireccion2(personaEditar.getDireccion2());
                    personas.setCiudad(personaEditar.getCiudad());
                    personas.setTipoPersona(personaEditar.getTipoPersona());
                    personaEditada = personas;
                }
            }
        }
        return personaEditada;
    }
/*
    esto es para eliminar datos en su json para el codigo dejelo asi
    public boolean eliminar"nombredelatablaenlaimagen"(int idEliminar)
    */
    public boolean eliminarPersona(int idEliminar) {

        PersonaModel personaEliminar = null;

        if (!persona.isEmpty()) {
            for (PersonaModel personas : persona) {
                if (personas.getIdPersona() == idEliminar) {
                    personaEliminar = personas;
                }
            }
        }

        persona.remove(personaEliminar);
        return true;
    }
}

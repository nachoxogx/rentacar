/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rentacar.webcomponent.Rentacar.model;

import java.util.ArrayList;

/**
 *
 * @author Sony
 */
public class TransmisionModel {
    
    private int idTransmision;
    
    private String nombreTransmision;
    
    private String detalle;
    
    public static ArrayList<TransmisionModel> transmition = new ArrayList<>();

    public int getIdTransmision() {
        return idTransmision;
    }

    public void setIdTransmision(int idTransmision) {
        this.idTransmision = idTransmision;
    }

    public String getNombreTransmision() {
        return nombreTransmision;
    }

    public void setNombreTransmision(String nombreTransmision) {
        this.nombreTransmision = nombreTransmision;
    }

    public String getdetalle() {
        return detalle;
    }

    public void setdetalle(String detalle) {
        this.detalle = detalle;
    }

    public TransmisionModel() {
    }

    public TransmisionModel(String nombreTransmision, String detalle) {
        this.nombreTransmision = nombreTransmision;
        this.detalle = detalle;
    }

    private TransmisionModel(int idTransmision, String nombreTransmision, String detalle) {
        this.idTransmision = idTransmision;
        this.nombreTransmision = nombreTransmision;
        this.detalle = detalle;
    }
    
    public boolean nuevoTrans(TransmisionModel nuevaTransmision){
            
           int id = 0;
           
           if (!transmition.isEmpty()) {
               
               for (TransmisionModel trans : transmition) {
                   if (trans.getIdTransmision()> id) {
                      id = trans.getIdTransmision();
                       
                   }
                   
               }
            
        }
            
          id++;  
            
        transmition.add(new TransmisionModel(id, nuevaTransmision.getNombreTransmision(),nuevaTransmision.getdetalle() ));
        return true;
    }
    
    public TransmisionModel buscatrans(int idtransBuscado){
        
        TransmisionModel transEncontrado = null;
        
        if (!transmition.isEmpty()) {
            for (TransmisionModel trans : transmition) {
                if(trans.getIdTransmision()== idtransBuscado){
                    
                   transEncontrado = trans;
                    
                    
                    
                    
                }
                
            }
            
        }
        
        return transEncontrado;
    }
    
    
    public TransmisionModel editartrans(int idTransmision, TransmisionModel transEditar){
        
        TransmisionModel transEditado = null;
        
          
        if (!transmition.isEmpty()) {
            for (TransmisionModel trans : transmition) {
                if (trans.getIdTransmision()== idTransmision) {
                    
                    trans.setNombreTransmision(transEditar.getNombreTransmision());
                        trans.setdetalle(transEditar.getdetalle());
                         transEditado = trans;
                    
                    
                    
                    
                }
                
            }
            
        }
        return transEditado;
        
    }
    
    public boolean eliminarTrans(int idEliminar ){
        
        TransmisionModel transEliminado = null;
        
        if (!transmition.isEmpty()) {
            for (TransmisionModel trans : transmition) {
                if (trans.getIdTransmision()== idEliminar) {
                 
                    transEliminado = trans;
                    
                    
                }
                
            }
            
        }
        
        transmition.remove(transEliminado);
        return true;
    }
    
}

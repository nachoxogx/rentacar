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
public class MediopagoModel {
    
    
    
    private int idMediopago;
    private String nombreMediopago;
    private String detalle;
    
    
   public static ArrayList<MediopagoModel> medio = new ArrayList<>();

    public int getIdMediopago() {
        return idMediopago;
    }

    public void setIdMediopago(int idMediopago) {
        this.idMediopago = idMediopago;
    }

    public String getNombreMediopago() {
        return nombreMediopago;
    }

    public void setNombreMediopago(String nombreMediopago) {
        this.nombreMediopago = nombreMediopago;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public MediopagoModel() {
    }

    public MediopagoModel(String nombreMediopago, String detalle) {
        this.nombreMediopago = nombreMediopago;
        this.detalle = detalle;
    }

    private MediopagoModel(int idMediopago, String nombreMediopago, String detalle) {
        this.idMediopago = idMediopago;
        this.nombreMediopago = nombreMediopago;
        this.detalle = detalle;
    }
   
    
    
    public boolean nuevoMediopago(MediopagoModel nuevoMediopago){
        
        int id = 0;
        
        if (!medio.isEmpty()) {
            
            for (MediopagoModel madi : medio) {
                if (madi.getIdMediopago()> id ) {
                  id = madi.getIdMediopago();
                  
                    
                }
                
                
            }
        }
        id = id + 1;
        
        medio.add(new MediopagoModel(id ,nuevoMediopago.getNombreMediopago(),nuevoMediopago.getDetalle()));
        
        return true;
    }
    
    
    
    public MediopagoModel buscarMediopago(int idmedio){
        
        MediopagoModel Encontrado =  null;
        
        if (!medio.isEmpty()) {
            for (MediopagoModel madi : medio) {
                if (madi.getIdMediopago()== idmedio) {
              Encontrado = madi;
                    
                }
                
            }
            
            
        }
        return Encontrado;
    }
    
    
    public MediopagoModel editarMediopago(int idMediopago,MediopagoModel mediopagoEditar ){
        
          MediopagoModel Editado =  null;
        
        if (!medio.isEmpty()) {
            for (MediopagoModel madi : medio) {
                if(madi.getIdMediopago()== idMediopago){
              
                    madi.setNombreMediopago(mediopagoEditar.getNombreMediopago());
                     madi.setDetalle(mediopagoEditar.getDetalle());
                     
                     Editado= madi;
                }
                
            }
            
            
        }
        return Editado;
    }
    
     public boolean aliminarMediopago(int idElimar){
       
         MediopagoModel mediopagoEliminado = null;
         
         if(!medio.isEmpty()){
             for (MediopagoModel madi : medio ) {
                 if (madi.getIdMediopago()== idElimar ) {
                     mediopagoEliminado = madi; 
                     
                 }
  
                 
             }
         }
    medio.remove(mediopagoEliminado);
            return true;
     }
   
   
   
    
}

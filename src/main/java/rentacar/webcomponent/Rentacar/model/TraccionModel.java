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
public class TraccionModel {
    
    
    private int idTraccion;
    private String nombreTraccion;
    private String detalle;
    
    
    public static ArrayList<TraccionModel> trac = new ArrayList<>();

    public int getIdTraccion() {
        return idTraccion;
    }

    public void setIdTraccion(int idTraccion) {
        this.idTraccion = idTraccion;
    }

    public String getNombreTraccion() {
        return nombreTraccion;
    }

    public void setNombreTraccion(String nombreTraccion) {
        this.nombreTraccion = nombreTraccion;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public TraccionModel() {
    }

    public TraccionModel(String nombreTraccion, String detalle) {
        this.nombreTraccion = nombreTraccion;
        this.detalle = detalle;
    }

    private TraccionModel(int idTraccion, String nombreTraccion, String detalle) {
        this.idTraccion = idTraccion;
        this.nombreTraccion = nombreTraccion;
        this.detalle = detalle;
    }

   public boolean nuevoTraccion(TraccionModel nuevoTraccion){
        
        int id = 0;
        
        if (!trac.isEmpty()) {
            
            for (TraccionModel traca : trac) {
                if (traca.getIdTraccion()> id ) {
                  id = traca.getIdTraccion();
                  
                    
                }
                
                
            }
        }
        id = id + 1;
        
        trac.add(new TraccionModel(id ,nuevoTraccion.getNombreTraccion(),nuevoTraccion.getDetalle()));
        
        return true;
    }
    
    
    
    public TraccionModel buscarTraccion(int idtrac){
        
        TraccionModel Encontrado =  null;
        
        if (!trac.isEmpty()) {
            for (TraccionModel traca : trac) {
                if (traca.getIdTraccion()== idtrac) {
              Encontrado = traca;
                    
                }
                
            }
            
            
        }
        return Encontrado;
    }
    
    
    public TraccionModel editarTraccion(int idTraccion,TraccionModel traccionEditar ){
        
          TraccionModel Editado =  null;
        
        if (!trac.isEmpty()) {
            for (TraccionModel trac : trac) {
                if(trac.getIdTraccion()== idTraccion){
              
                    trac.setNombreTraccion(traccionEditar.getNombreTraccion());
                     trac.setDetalle(traccionEditar.getDetalle());
                     
                     Editado= trac;
                }
                
            }
            
            
        }
        return Editado;
    }
    
     public boolean aliminarTraccion(int idEliminar){
       
         TraccionModel traccionEliminado = null;
         
         if(!trac.isEmpty()){
             for (TraccionModel traca : trac) {
                 if (traca.getIdTraccion() == idEliminar ) {
                   traccionEliminado = traca; 
                     
                 }
  
                 
             }
         }
        
    trac.remove(traccionEliminado);
            return true;
     }
    
    
    
}

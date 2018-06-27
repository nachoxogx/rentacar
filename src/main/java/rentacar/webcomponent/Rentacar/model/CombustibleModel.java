/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rentacar.webcomponent.Rentacar.model;


import java.util.ArrayList;
import javax.persistence.Entity;

/**
 *
 * @author Sony
 */

public class CombustibleModel {
    
    private int idCombustible;
    private String tipoCombustible;
    private String detalle;
    
    
    public static ArrayList<CombustibleModel> parafina = new ArrayList<>();
    

    public int getIdCombustible() {
        return idCombustible;
    }

    public void setIdCombustible(int idCombustible) {
        this.idCombustible = idCombustible;
    }

    public String getTipoCombustible() {
        return tipoCombustible;
    }

    public void setTipoCombustible(String tipoCombustible) {
        this.tipoCombustible = tipoCombustible;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public CombustibleModel() {
    }

    public CombustibleModel(String tipoCombustible, String detalle) {
        this.tipoCombustible = tipoCombustible;
        this.detalle = detalle;
    }

    private CombustibleModel(int idCombustible, String tipoCombustible, String detalle) {
        this.idCombustible = idCombustible;
        this.tipoCombustible = tipoCombustible;
        this.detalle = detalle;
    }
    
    
    
    public boolean nuevoCombustible(CombustibleModel nuevoCombustible){
        
        int id = 0;
        
        if (!parafina.isEmpty()) {
            
            for (CombustibleModel comb : parafina) {
                if (comb.getIdCombustible()> id ) {
                  id = comb.getIdCombustible();
                  
                    
                }
                
                
            }
        }
        id = id + 1;
        
        parafina.add(new CombustibleModel(id ,nuevoCombustible.getTipoCombustible(),nuevoCombustible.getDetalle()));
        
        return true;
    }
    
    
    
    public CombustibleModel buscarCombustible(int idComb){
        
        CombustibleModel Encontrado =  null;
        
        if (!parafina.isEmpty()) {
            for (CombustibleModel comb : parafina) {
                if (comb.getIdCombustible() == idComb) {
              Encontrado = comb;
                    
                }
                
            }
            
            
        }
        return Encontrado;
    }
    
    
    public CombustibleModel editarCombustible(int idCombustible,CombustibleModel combustibleEditar ){
        
          CombustibleModel Editado =  null;
        
        if (!parafina.isEmpty()) {
            for (CombustibleModel comb : parafina) {
                if(comb.getIdCombustible() == idCombustible){
              
                    comb.setTipoCombustible(combustibleEditar.getTipoCombustible());
                     comb.setDetalle(combustibleEditar.getDetalle());
                     
                     Editado= comb;
                }
                
            }
            
            
        }
        return Editado;
    }
    
     public boolean aliminarCombustible(int idEliminar){
       
         CombustibleModel CombustibleEliminado = null;
         
         if(!parafina.isEmpty()){
             for (CombustibleModel comb : parafina) {
                 if (comb.getIdCombustible() == idEliminar ) {
                     CombustibleEliminado = comb; 
                     
                 }
  
                 
             }
         }
        
    parafina.remove(CombustibleEliminado);
            return true;
     }
    
    
}

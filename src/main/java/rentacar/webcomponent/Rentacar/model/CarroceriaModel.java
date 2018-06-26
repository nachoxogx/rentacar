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
public class CarroceriaModel {
    
    private int idCarroceria;
    private String nombreCarroceria;
    private String detalle;
    
    public static ArrayList<CarroceriaModel> carro = new ArrayList<>();

    public int getIdCarroceria() {
        return idCarroceria;
    }

    public void setIdCarroceria(int idCarroceria) {
        this.idCarroceria = idCarroceria;
    }

    public String getNombreCarroceria() {
        return nombreCarroceria;
    }

    public void setNombreCarroceria(String nombreCarroceria) {
        this.nombreCarroceria = nombreCarroceria;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public static ArrayList<CarroceriaModel> getCarro() {
        return carro;
    }

    public static void setCarro(ArrayList<CarroceriaModel> carro) {
        CarroceriaModel.carro = carro;
    }

    public CarroceriaModel() {
    }

    public CarroceriaModel(String nombreCarroceria, String detalle) {
        this.nombreCarroceria = nombreCarroceria;
        this.detalle = detalle;
    }

    private CarroceriaModel(int idCarroceria, String nombreCarroceria, String detalle) {
        this.idCarroceria = idCarroceria;
        this.nombreCarroceria = nombreCarroceria;
        this.detalle = detalle;
    }
    
    
     public boolean nuevoCarroceria(CarroceriaModel nuevaCarroceria){
        
        int id = 0;
        
        if (!carro.isEmpty()) {
            
            for (CarroceriaModel car : carro) {
                if (car.getIdCarroceria()> id ) {
                  id = car.getIdCarroceria();
                  
                    
                }
                
                
            }
        }
        id = id + 1;
        
        carro.add(new CarroceriaModel(id ,nuevaCarroceria.getNombreCarroceria(),nuevaCarroceria.getDetalle()));
        
        return true;
    }
    
    
    
    public CarroceriaModel buscarCarroceria(int idCarro){
        
        CarroceriaModel Encontrado =  null;
        
        if (!carro.isEmpty()) {
            for (CarroceriaModel car : carro) {
                if (car.getIdCarroceria()== idCarro) {
              Encontrado = car;
                    
                }
                
            }
            
            
        }
        return Encontrado;
    }
    
    
    public CarroceriaModel editarCarroceria(int idCarroceria,CarroceriaModel carroceriaEditar ){
        
         CarroceriaModel Editado =  null;
        
        if (!carro.isEmpty()) {
            for (CarroceriaModel car : carro) {
                if(car.getIdCarroceria()== idCarroceria){
              
                    car.setNombreCarroceria(carroceriaEditar.getNombreCarroceria());
                     car.setDetalle(carroceriaEditar.getDetalle());
                     
                     Editado= car;
                }
                
            }
            
            
        }
        return Editado;
    }
    
     public boolean aliminarCarroceria(int idEliminar){
       
         CarroceriaModel CarroceriaEliminado = null;
         
         if(!carro.isEmpty()){
             for (CarroceriaModel car : carro) {
                 if (car.getIdCarroceria()== idEliminar ) {
                     CarroceriaEliminado = car; 
                     
                 }
  
                 
             }
         }
        
    carro.remove(CarroceriaEliminado);
            return true;
     }
    
    
    
    
}

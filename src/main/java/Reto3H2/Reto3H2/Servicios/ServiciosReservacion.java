
package Reto3H2.Reto3H2.Servicios;

import Reto3H2.Reto3H2.Repositorio.RepositorioReservacion;
import Reto3H2.Reto3H2.Modelos.Reservation;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiciosReservacion {
    
   @Autowired
   private RepositorioReservacion metodosCrud;
   
   public List<Reservation> getAll(){
       return metodosCrud.getAll();
   }
   
   public Optional <Reservation> getReservation(int idReservation){
       return metodosCrud.getReservation(idReservation);
   }
   
   public Reservation save(Reservation reservation){
    if (reservation.getIdReservation()==null){
        return metodosCrud.save(reservation);
    }else{
        Optional<Reservation> evt =metodosCrud.getReservation(reservation.getIdReservation());
        if (evt.isEmpty()){
            return metodosCrud.save(reservation);
        }else {
            return reservation;
        }
    }
  }
}

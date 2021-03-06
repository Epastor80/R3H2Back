
package Reto3H2.Reto3H2.ControladorWeb;

import Reto3H2.Reto3H2.Servicios.ServiciosReservacion;
import Reto3H2.Reto3H2.Modelos.Reservation;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})

public class WebReservacion {
    
   @Autowired
    private ServiciosReservacion servicios;
   
   @GetMapping("/all")
   public List<Reservation> getReservation(){
        return servicios.getAll();
    }
    @GetMapping("/{id}")
	    public Optional<Reservation> getReservation(@PathVariable("idReservation") int idReservation) {
	        return servicios.getReservation(idReservation);
	    }
	
	    @PostMapping("/save")
	    @ResponseStatus(HttpStatus.CREATED)
	    public Reservation save(@RequestBody Reservation reservation) {
	        return servicios.save(reservation);
	    }
    }

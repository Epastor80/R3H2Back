
package Reto3H2.Reto3H2.Servicios;

import Reto3H2.Reto3H2.Repositorio.RepositorioGames;
import Reto3H2.Reto3H2.Modelos.Game;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiciosGame {
  
    @Autowired
   private RepositorioGames metodosCrud;
   
   public List<Game> getAll(){
       return metodosCrud.getAll();
   }
   
   public Optional <Game> getGame(int idGame){
       return metodosCrud.getGame(idGame);
   }
   
   public Game save(Game game){
    if (game.getId()==null){
        return metodosCrud.save(game);
    }else{
        Optional<Game> evt = metodosCrud.getGame(game.getId());
        if (evt.isEmpty()){
            return metodosCrud.save(game);
        }else {
            return game;
        }
    }
  }
}
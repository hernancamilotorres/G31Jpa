
package com.g31.jpa.service;

import com.g31.jpa.entity.Game;
import com.g31.jpa.repository.GameRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Camilo Torres C
 */

@Service
public class GameService {
    @Autowired
    private GameRepository gameRepository;
    
    public List<Game> getGameList(){
        return gameRepository.findAll();
    }
  
    public Game getGame (Long id){
        return gameRepository.findById(id).get();
    }
    
    public Game saveGame(Game game){
        return gameRepository.save(game);
    }
    
    /*public Game updateGame (Game game){
        return gameRepository.save(game);
    }*/

    public Game updateGame (Game game){
        //Valido si vienen un id en la information de la peticion
        
        //si no viene retorno la entirdad recibida como parametro
        
        if(game.getId()!=null){
        //Valido si la id existe en la base de datos    
        Optional <Game> opcional = gameRepository.findById(game.getId());
        
            if (!opcional.isEmpty()){
                //logica
                Game gameBD = opcional.get();
                
                gameBD.setName(game.getName());
                gameBD.setCategory(game.getCategory());
                gameBD.setDescription(game.getDescription());
                gameBD.setDeveloper(game.getDeveloper());
                gameBD.setYear(game.getYear());
                return gameRepository.save(gameBD);
            }else {
                return game;
            }
        }
        return game;
    }
        
    public void deleteGame(Long id){
        gameRepository.deleteById(id);
    }
}

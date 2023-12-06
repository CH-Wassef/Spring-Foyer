package tn.esprit.sprint.foyer_wassef_chargui.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.sprint.foyer_wassef_chargui.Entites.Foyer;
import tn.esprit.sprint.foyer_wassef_chargui.Services.FoyerService;

import java.util.List;

@RestController
@RequestMapping("/Foyer")
public class FoyerController {

    @Autowired
    FoyerService foyerService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Foyer>> getAllFoyers(){
        List<Foyer> foyers = foyerService.getAllFoyers();
        return new ResponseEntity<>(foyers, HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Foyer> addFoyer(@RequestBody Foyer foyer){
        Foyer addedFoyer = foyerService.addFoyer(foyer);
        return new ResponseEntity<>(addedFoyer, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFoyer(@PathVariable long id){
        foyerService.removeFoyer(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces =  MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Foyer> modifyFoyer(@RequestBody Foyer foyer, @PathVariable long id){
        Foyer modifiedFoyer = foyerService.modifyFoyer(foyer, id);
        return new ResponseEntity<>(modifiedFoyer, HttpStatus.ACCEPTED);
    }
}

package tn.esprit.sprint.foyer_wassef_chargui.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.sprint.foyer_wassef_chargui.Entites.Chambre;
import tn.esprit.sprint.foyer_wassef_chargui.Services.ChambreService;

import java.util.List;

@RestController
@RequestMapping("/Chambre")
public class ChambreController {

    @Autowired
    ChambreService chambreService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Chambre>> getAllChambres(){
        List<Chambre> chambres = chambreService.getAllChambres();
        return new ResponseEntity<>(chambres, HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Chambre> addChambre(@RequestBody Chambre chambre){
        Chambre addedChambre = chambreService.addChambre(chambre);
        return new ResponseEntity<>(addedChambre, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteChambre(@PathVariable long id){
        chambreService.removeChambre(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces =  MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Chambre> modifyChambre(@RequestBody Chambre chambre, @PathVariable long id){
        Chambre modifiedChambre = chambreService.modifyChambre(chambre, id);
        return new ResponseEntity<>(modifiedChambre, HttpStatus.ACCEPTED);
    }
}

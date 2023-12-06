package tn.esprit.sprint.foyer_wassef_chargui.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.sprint.foyer_wassef_chargui.Entites.Etudiant;
import tn.esprit.sprint.foyer_wassef_chargui.Services.EtudiantService;

import java.util.List;

@RestController
@RequestMapping("/Etudiant")
public class EtudiantController {

    @Autowired
    EtudiantService etudiantService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Etudiant>> getAllEtudiant(){
        List<Etudiant> e = etudiantService.getAllEtudiants();
        return new  ResponseEntity<List<Etudiant>>(e,HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Etudiant> ajouterEtudiant(@RequestBody Etudiant e){
        Etudiant etudiantAjouter = etudiantService.addEtudiant(e);
        return new ResponseEntity<Etudiant>(etudiantAjouter,HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteEtudiant(@PathVariable long id){
        etudiantService.removeEtudiant(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces =  MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Etudiant> modiferEudiant(@RequestBody Etudiant e,@PathVariable long id){
        Etudiant etudiant = etudiantService.modifyEtudiant(e,id);
        return new ResponseEntity<Etudiant>(etudiant,HttpStatus.ACCEPTED);
    }
}

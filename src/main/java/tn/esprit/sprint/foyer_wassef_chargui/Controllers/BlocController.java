package tn.esprit.sprint.foyer_wassef_chargui.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.sprint.foyer_wassef_chargui.Entites.Bloc;
import tn.esprit.sprint.foyer_wassef_chargui.Services.IBlockService;

import java.util.List;

@RestController
@RequestMapping("/Block")
public class BlocController {

    @Autowired
    IBlockService blockService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Bloc>> getAllBlocks(){
        List<Bloc> blocks = blockService.getAllBlocks();
        return new ResponseEntity<>(blocks, HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Bloc> addBlock(@RequestBody Bloc block){
        Bloc addedBlock = blockService.addBlock(block);
        return new ResponseEntity<>(addedBlock, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBlock(@PathVariable long id){
        blockService.removeBlock(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces =  MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Bloc> modifyBlock(@RequestBody Bloc block, @PathVariable long id){
        Bloc modifiedBlock = blockService.modifyBlock(block, id);
        return new ResponseEntity<>(modifiedBlock, HttpStatus.ACCEPTED);
    }
}

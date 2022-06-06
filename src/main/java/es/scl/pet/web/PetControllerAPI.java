package es.scl.pet.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import es.scl.pet.model.Pet;
import es.scl.pet.data.PetRepository;

@RestController
@RequestMapping(path = "/rest", produces = "application/json")
public class PetControllerAPI {

    @Autowired
    private PetRepository repo;

    @GetMapping("/{id}")
    public ResponseEntity<Pet> petById(@PathVariable("id") Long id) {
        Optional<Pet> opt = repo.findById(id);

        if (opt.isPresent())
            return new ResponseEntity<>(opt.get(), HttpStatus.OK);
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
   
    @PostMapping(path = "/pets", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Pet pet(@RequestBody Pet pet) {
        return repo.save(pet);
    
    
    }

    @GetMapping("/all")
    public Iterable<Pet> getAll(){
        Iterable<Pet> opt = repo.findAll();

        return opt;
    }



    @GetMapping("/recent")
    public Iterable<Pet> getRecentTPet(){
        PageRequest page = PageRequest.of(0,20,Sort.by("fechanacimiento").ascending());
        return repo.findAll(page).getContent();
    }

}


/*
 * Aplicación para entregar
Crear una API rest para ofrecer servicios sobre adopcion de mascotas. 
Los datos de cada mascota son:  Pet[id, nombre, fecha_nac, raza, peso, tiene_chip]  
Los metodos que va a exponer la API son los siguientes:  
GET (por id) ..----------- OK
POST GET (todos) 
GET (todos paginados de a 20 por pagina los mas viejos primero) --OK
DELETE (por id) -- OK
 */
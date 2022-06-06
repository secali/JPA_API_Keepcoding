package es.scl.pet.data;
import es.scl.pet.model.Pet;

import org.springframework.data.repository.PagingAndSortingRepository;



public interface PetRepository extends PagingAndSortingRepository <Pet, Long>{
    
}
package com.example.WineListProject;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.WineListProject.domain.Category;
import com.example.WineListProject.domain.Wine;
import com.example.WineListProject.domain.WineRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class WineRepositoryTest {

	@Autowired
	private WineRepository repository;
	
	// Testing to find a wine
    @Test
    public void findNameShouldReturnWine() {
        List<Wine> wines = repository.findByName("Chateau Musar");
        
        assertThat(wines).hasSize(1);
        assertThat(wines.get(0).getRegion().contains("France"));
    }
    
	// Testing to create a wine
	 @Test
	    public void createNewWine() {
	    	Wine wine = new Wine("Château d'Aqueria Tavel", "France, Grenache", 2017, 16.9, 14.0, new Category("Rose"), "Hintansa väärti");
	    	repository.save(wine);
	    	assertThat(wine.getId()).isNotNull();
	        assertThat(repository).isNotNull();
	    }   
	

  //Testing to delete a wine
    @Test
    public void deleteWine() {
    	List<Wine> oldWines = (List<Wine>) repository.findAll();
    	Long deletedWineId = oldWines.get(0).getId();
		repository.deleteById(deletedWineId);
		
		List<Wine> newWines = (List<Wine>) repository.findAll();
		for (Wine wine : newWines) {
			assert(wine.getId() != deletedWineId);
		}
    }   

}

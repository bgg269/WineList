package com.example.WineListProject;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.WineListProject.domain.Category;
import com.example.WineListProject.domain.Wine;
import com.example.WineListProject.domain.WineRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
class WineRepositoryTest {

	@Autowired
	private WineRepository repository;
	
	// Testing to create a wine
	 @Test
	    public void createNewWine() {
	    	Wine wine = new Wine("nimi3", "France", 2019, 23, 26, new Category("Rose"), "");
	    	repository.save(wine);
	    	assertThat(wine.getId()).isNotNull();
	        assertThat(repository).isNotNull();
	    }   
	
	// Testing to find a wine
    @Test
    public void findNameShouldReturnWine() {
        List<Wine> wines = (List<Wine>) repository.findAll();
        assertThat(wines).hasSize(1);
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

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

    @Test
    public void findTitleShouldReturnBook() {
        List<Wine> wines = repository.findByName("nimi1");
        
        assertThat(wines).hasSize(1);
        assertThat(wines.get(0).getName()).isEqualTo("nimi3");
    }
    
    @Test
    public void createNewBook() {
    	Wine wine = new Wine("nimi3", "France", 2019, 23, 26, new Category("Rose"));
    	repository.save(wine);
    	assertThat(wine.getId()).isNotNull();
    }   
    @Test
    public void deleteBook() {
    	System.out.println("books" + repository.findAll());
		repository.deleteById((long) 3);
    	System.out.println("books" + repository.findAll());
		repository.deleteById((long) 5);
    }   

}

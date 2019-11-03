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
import com.example.WineListProject.domain.CategoryRepository;


@ExtendWith(SpringExtension.class)
@SpringBootTest
class CategoryRepositoryTest {

	@Autowired
    private CategoryRepository repository;

    //Testing to find a category
    @Test
    public void findNameShouldReturnCategory() {
        List<Category> categories = repository.findByName("red");
        assertThat(categories).hasSize(1);
    }
    
    //Testing to create a category
    @Test
    public void createNewCategory() {
    	Category category = new Category("dessert or sweet");
    	repository.save(category);
    	assertThat(category.getCategoryid()).isNotNull();
    }   
    
    //Testing to delete a category
    @Test
    public void deleteCategory() {
    	List<Category> oldCategories = (List<Category>) repository.findAll();
    	Long deletedCategoryId = oldCategories.get(0).getCategoryid();
		repository.deleteById(deletedCategoryId);
		
		List<Category> newCategories = (List<Category>) repository.findAll();
		for (Category category : newCategories) {
			assert(category.getCategoryid() != deletedCategoryId);
		}
    }   

}

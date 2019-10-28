package com.example.WineListProject.Web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.WineListProject.domain.Category;
import com.example.WineListProject.domain.CategoryRepository;
import com.example.WineListProject.domain.Wine;
import com.example.WineListProject.domain.WineRepository;


@Controller
public class WineController {
	@Autowired
	private WineRepository repository;

	@Autowired
	private CategoryRepository crepository;
	
    @RequestMapping(value="/login")
    public String login() {	
        return "login";
    }

	@RequestMapping(value = "/winelist")
	public String WineList(Model model) {
		model.addAttribute("wines", repository.findAll());
		return "winelist";
	}

	@RequestMapping(value = "/add")
	public String addWine(Model model) {
		model.addAttribute("wine", new Wine());
		model.addAttribute("categorys", crepository.findAll());
		return "addwine";
	}
	
	// RESTful service to get all students
    @RequestMapping(value="/wines", method = RequestMethod.GET)
    public @ResponseBody List<Wine> wineListRest() {	
        return (List<Wine>) repository.findAll();
    }    

	// RESTful service to get student by id
    @RequestMapping(value="/wine/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Wine> findWineRest(@PathVariable("id") Long wineId) {	
    	return repository.findById(wineId);
    }

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Wine wine) {
		repository.save(wine);
		return "redirect:winelist";
	}
	
	@RequestMapping(value = "/find", method = RequestMethod.POST)
	public String findAll() {
		List<Wine> list = (List<Wine>) repository.findAll();
		for (Wine wine : list) {
			System.out.println("id" + wine.getId());
		}
		return null;
	}
	
	@RequestMapping(value = "/findC", method = RequestMethod.POST)
	public String findAllCategories() {
		List<Category> list = (List<Category>) crepository.findAll();
		for (Category category : list) {
			System.out.println("id" + category.getCategoryid());
		}
		return null;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteWine(@PathVariable("id") Long wineId, Model model) {
		repository.deleteById(wineId);
		return "redirect:../winelist";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editWine(@PathVariable("id") Long wineId, Model model) {
		model.addAttribute("wine", repository.findById(wineId));
		model.addAttribute("categorys", crepository.findAll());
		return "editwine";
	}
}

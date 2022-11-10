package com.kodlama.io.Devs.webApi.controllers;

import com.kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import com.kodlama.io.Devs.business.abstracts.TechnologyService;
import com.kodlama.io.Devs.business.requests.CreateProgrammingLanguageRequest;
import com.kodlama.io.Devs.business.requests.CreateTechnologyRequest;
import com.kodlama.io.Devs.business.requests.DeleteTechnologyRequest;
import com.kodlama.io.Devs.business.requests.UpdateTechnologyRequest;
import com.kodlama.io.Devs.business.responses.GetAllProgrammingLanguagesResponse;
import com.kodlama.io.Devs.business.responses.GetAllTechnologiesResponse;
import com.kodlama.io.Devs.entities.concretes.ProgrammingLanguage;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/technologies")
public class TechnologiesController {

	private TechnologyService technologyService;

	@Autowired
	public TechnologiesController(TechnologyService technologyService) {
		this.technologyService = technologyService;
	}

	@GetMapping("/getall")
	public List<GetAllTechnologiesResponse> getAll() {
		return technologyService.getAll();
	}

	@PostMapping("/add")
	public void add(@RequestBody() CreateTechnologyRequest createTechnologyRequest) {
		technologyService.add(createTechnologyRequest);
	}

	@PostMapping("/update")
	public void update(@RequestBody() UpdateTechnologyRequest updateTechnologyRequest) {
		technologyService.update(updateTechnologyRequest);
	}
	
	@PostMapping("/delete")
	public void delete(@RequestBody() DeleteTechnologyRequest deleteTechnologyRequest) {
		technologyService.deleteById(deleteTechnologyRequest);
	}

}

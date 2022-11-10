package com.kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlama.io.Devs.business.abstracts.TechnologyService;
import com.kodlama.io.Devs.business.requests.CreateTechnologyRequest;
import com.kodlama.io.Devs.business.requests.DeleteTechnologyRequest;
import com.kodlama.io.Devs.business.requests.UpdateTechnologyRequest;
import com.kodlama.io.Devs.business.responses.GetAllTechnologiesResponse;
import com.kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import com.kodlama.io.Devs.dataAccess.abstracts.TechnologyRepository;
import com.kodlama.io.Devs.entities.concretes.Technology;

@Service
public class TechnologyManager implements TechnologyService {

	private TechnologyRepository technologyRepository;
	private ProgrammingLanguageRepository programmingLanguageRepository;

	@Autowired
	public TechnologyManager(TechnologyRepository technologyRepository, ProgrammingLanguageRepository programmingLanguageRepository) {
		this.technologyRepository = technologyRepository;
		this.programmingLanguageRepository = programmingLanguageRepository;
	}

	@Override
	public ArrayList<GetAllTechnologiesResponse> getAll() {
		List<Technology> technologies = technologyRepository.findAll();
		ArrayList<GetAllTechnologiesResponse> getAllTechnologiesResponses = new ArrayList<GetAllTechnologiesResponse>();
		
		for(Technology technology : technologies) {
			GetAllTechnologiesResponse getAllTechnologiesResponse = new GetAllTechnologiesResponse() ;
			getAllTechnologiesResponse.setId(technology.getId());
			getAllTechnologiesResponse.setName(technology.getName());
			getAllTechnologiesResponse.setProgrammingLanguageName(technology.getProgrammingLanguage().getName());

			getAllTechnologiesResponses.add(getAllTechnologiesResponse);
		}
		return getAllTechnologiesResponses;
	}

	@Override
	public void add(CreateTechnologyRequest createTechnologyRequest) {
		Technology technology = new Technology();
		technology.setName(createTechnologyRequest.getName());
		technology.setProgrammingLanguage(programmingLanguageRepository.getById(createTechnologyRequest.getProgrammingLanguageId()));
		
		technologyRepository.save(technology);
	}

	@Override
	public void update(UpdateTechnologyRequest updateTechnologyRequest) {
		Technology technology = technologyRepository.getById(updateTechnologyRequest.getTechnologyId());
		technology.setName(updateTechnologyRequest.getName());
		
		technologyRepository.save(technology);

	}

	@Override
	public void deleteById(DeleteTechnologyRequest deleteTechnologyRequest) {
		technologyRepository.deleteById(deleteTechnologyRequest.getTechnologyId());
	}

}

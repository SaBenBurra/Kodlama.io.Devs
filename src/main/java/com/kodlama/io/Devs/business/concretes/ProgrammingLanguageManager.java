package com.kodlama.io.Devs.business.concretes;

import com.kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import com.kodlama.io.Devs.business.requests.CreateProgrammingLanguageRequest;
import com.kodlama.io.Devs.business.responses.GetAllProgrammingLanguagesResponse;
import com.kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import com.kodlama.io.Devs.entities.concretes.ProgrammingLanguage;
import com.kodlama.io.Devs.entities.concretes.Technology;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService {

	private ProgrammingLanguageRepository programmingLanguageRepository;

	@Autowired
	public ProgrammingLanguageManager(ProgrammingLanguageRepository programmingLanguageRepository) {
		this.programmingLanguageRepository = programmingLanguageRepository;
	}

	public ArrayList<GetAllProgrammingLanguagesResponse> getAll() {
		List<ProgrammingLanguage> programmingLanguages = programmingLanguageRepository.findAll();
		ArrayList<GetAllProgrammingLanguagesResponse> programmingLanguagesResponses = new ArrayList<GetAllProgrammingLanguagesResponse>();

		for (ProgrammingLanguage programmingLanguage : programmingLanguages) {
			GetAllProgrammingLanguagesResponse response = new GetAllProgrammingLanguagesResponse();
			response.setId(programmingLanguage.getId());
			response.setName(programmingLanguage.getName());
			Set<Technology> technologies = programmingLanguage.getTechnologies();
			List<String> technologyNames = new ArrayList<String>();
			for (Technology technology : technologies) {
				technologyNames.add(technology.getName());
			}
			response.setTechnologyNames(technologyNames);
			programmingLanguagesResponses.add(response);
		}
		return programmingLanguagesResponses;
	}

	public void add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) {
		ProgrammingLanguage programmingLanguage = new ProgrammingLanguage();
		programmingLanguage.setName(createProgrammingLanguageRequest.getName());
		programmingLanguageRepository.save(programmingLanguage);
	}

	public void update(ProgrammingLanguage programmingLanguage) {
		programmingLanguageRepository.save(programmingLanguage);
	}

	public void deleteById(int id) {
		programmingLanguageRepository.deleteById(id);
	}
}

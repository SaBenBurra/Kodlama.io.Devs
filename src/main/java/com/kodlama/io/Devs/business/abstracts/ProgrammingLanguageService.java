package com.kodlama.io.Devs.business.abstracts;

import com.kodlama.io.Devs.business.requests.CreateProgrammingLanguageRequest;
import com.kodlama.io.Devs.business.responses.GetAllProgrammingLanguagesResponse;
import com.kodlama.io.Devs.entities.concretes.ProgrammingLanguage;
import java.util.ArrayList;

public interface ProgrammingLanguageService {
  public ArrayList<GetAllProgrammingLanguagesResponse> getAll();

  public void add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest);

  public void update(ProgrammingLanguage programmingLanguage);

  public void deleteById(int id);
}

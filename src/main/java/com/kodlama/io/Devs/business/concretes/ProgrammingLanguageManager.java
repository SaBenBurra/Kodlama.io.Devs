package com.kodlama.io.Devs.business.concretes;

import com.kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import com.kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import com.kodlama.io.Devs.entities.concretes.ProgrammingLanguage;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;

public class ProgrammingLanguageManager implements ProgrammingLanguageService {

  private ProgrammingLanguageRepository programmingLanguageRepository;

  @Autowired
  public ProgrammingLanguageManager(
    ProgrammingLanguageRepository programmingLanguageRepository
  ) {
    this.programmingLanguageRepository = programmingLanguageRepository;
  }

  public ArrayList<ProgrammingLanguage> getAll() {
    return programmingLanguageRepository.getAll();
  }

  public void add(ProgrammingLanguage programmingLanguage) {
    if (
      !programmingLanguageRepository.checkIfNameIsAlreadyExists(
        programmingLanguage.getName()
      ) &&
      !programmingLanguage.getName().isBlank()
    ) {
      programmingLanguageRepository.add(programmingLanguage);
    }
  }

  public void update(ProgrammingLanguage programmingLanguage) {
    if (
      !programmingLanguageRepository.checkIfNameIsAlreadyExists(
        programmingLanguage.getName()
      ) &&
      !programmingLanguage.getName().isBlank()
    ) {
      programmingLanguageRepository.update(programmingLanguage);
    }
  }

  public void deleteById(int id) {
    programmingLanguageRepository.deleteById(id);
  }
}

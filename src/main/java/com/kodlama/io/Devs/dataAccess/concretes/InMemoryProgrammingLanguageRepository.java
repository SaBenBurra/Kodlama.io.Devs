package com.kodlama.io.Devs.dataAccess.concretes;

import com.kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import com.kodlama.io.Devs.entities.concretes.ProgrammingLanguage;
import java.util.ArrayList;

public class InMemoryProgrammingLanguageRepository
  implements ProgrammingLanguageRepository {

  private ArrayList<ProgrammingLanguage> programmingLanguages = new ArrayList<ProgrammingLanguage>();

  public ArrayList<ProgrammingLanguage> getAll() {
    return programmingLanguages;
  }

  public ProgrammingLanguage add(ProgrammingLanguage programmingLanguage) {
    programmingLanguages.add(programmingLanguage);
    return programmingLanguage;
  }

  public ProgrammingLanguage update(ProgrammingLanguage programmingLanguage) {
    for (ProgrammingLanguage tmpProgrammingLanguage : programmingLanguages) {
      if (tmpProgrammingLanguage.getId() == programmingLanguage.getId()) {
        tmpProgrammingLanguage.setName(programmingLanguage.getName());
      }
    }
    return programmingLanguage;
  }

  public void deleteById(int id) {
    for (ProgrammingLanguage programmingLanguage : programmingLanguages) {
      if (programmingLanguage.getId() == id) {
        programmingLanguages.remove(programmingLanguage);
      }
    }
  }
}

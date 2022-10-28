package com.kodlama.io.Devs.business.abstracts;

import com.kodlama.io.Devs.entities.concretes.ProgrammingLanguage;
import java.util.ArrayList;

public interface ProgrammingLanguageService {
  public ArrayList<ProgrammingLanguage> getAll();

  public void add(ProgrammingLanguage programmingLanguage);

  public void update(ProgrammingLanguage programmingLanguage);

  public void deleteById(int id);
}

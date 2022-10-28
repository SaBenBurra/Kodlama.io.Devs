package com.kodlama.io.Devs.dataAccess.abstracts;

import com.kodlama.io.Devs.entities.concretes.ProgrammingLanguage;
import java.util.ArrayList;

public interface ProgrammingLanguageRepository {
  ArrayList<ProgrammingLanguage> getAll();
  ProgrammingLanguage add(ProgrammingLanguage programmingLanguage);
  ProgrammingLanguage update(ProgrammingLanguage programmingLanguage);
  void deleteById(int id);
  boolean checkIfNameIsAlreadyExists(String name);
}

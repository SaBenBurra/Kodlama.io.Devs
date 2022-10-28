package com.kodlama.io.Devs.webApi.controllers;

import com.kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import com.kodlama.io.Devs.entities.concretes.ProgrammingLanguage;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/programmingLanguages")
public class ProgrammingLanguagesController {

  private ProgrammingLanguageService programmingLanguageService;

  @Autowired
  public ProgrammingLanguagesController(
    ProgrammingLanguageService programmingLanguageService
  ) {
    this.programmingLanguageService = programmingLanguageService;
  }

  @GetMapping("/getall")
  public List<ProgrammingLanguage> getAll() {
    return programmingLanguageService.getAll();
  }
}

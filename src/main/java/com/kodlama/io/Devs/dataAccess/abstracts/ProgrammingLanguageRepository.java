package com.kodlama.io.Devs.dataAccess.abstracts;

import com.kodlama.io.Devs.entities.concretes.ProgrammingLanguage;
import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProgrammingLanguageRepository extends JpaRepository<ProgrammingLanguage, Integer> {
}

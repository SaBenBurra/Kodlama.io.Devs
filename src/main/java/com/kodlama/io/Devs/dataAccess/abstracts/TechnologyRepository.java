package com.kodlama.io.Devs.dataAccess.abstracts;
import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlama.io.Devs.entities.concretes.Technology;

public interface TechnologyRepository extends JpaRepository<Technology, Integer>{

}

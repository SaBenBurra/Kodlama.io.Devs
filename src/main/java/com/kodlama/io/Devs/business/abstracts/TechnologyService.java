package com.kodlama.io.Devs.business.abstracts;

import java.util.ArrayList;

import com.kodlama.io.Devs.business.requests.CreateTechnologyRequest;
import com.kodlama.io.Devs.business.requests.DeleteTechnologyRequest;
import com.kodlama.io.Devs.business.requests.UpdateTechnologyRequest;
import com.kodlama.io.Devs.business.responses.GetAllTechnologiesResponse;

public interface TechnologyService {
	  public ArrayList<GetAllTechnologiesResponse> getAll();

	  public void add(CreateTechnologyRequest createTechnologyRequest);

	  public void update(UpdateTechnologyRequest updateTechnologyRequest);

	  public void deleteById(DeleteTechnologyRequest deleteTechnologyRequest);	
}

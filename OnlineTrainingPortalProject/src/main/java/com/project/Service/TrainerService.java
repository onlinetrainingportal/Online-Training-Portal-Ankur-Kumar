package com.project.Service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Model.Trainer;
import com.project.Repository.TrainerRepository;
@Service
public class TrainerService {
	@Autowired
	TrainerRepository repo;
	public Trainer addTrainer(Trainer t) {
		Trainer trainer=repo.save(t);
		return trainer;
	}
	
	
	public List <Trainer>  findTrainer(String location,String technology) {
		return   repo.findTrainer(location,technology);
	}
	public Trainer findByTechnology(String technology) {
		return repo.findByTechnology(technology);
	}
	public void updateTrainerByTrainerId(Trainer t) {
		 repo.save(t);
	}
	
	
	public Optional <Trainer> findByTrainerId(String trainerId){
		return  repo.findById(trainerId);
	}
	  
	
}



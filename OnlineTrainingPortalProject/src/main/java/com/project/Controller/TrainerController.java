package com.project.Controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.Exception.ResourceNotFoundException;
import com.project.Model.Trainer;
import com.project.Service.TrainerService;
@RestController
@RequestMapping("/Trainer")
public class TrainerController {
	@Autowired
	TrainerService service;
	
	@PostMapping("/addTrainer")
	public ResponseEntity<String>  addTrainer( @Validated @RequestBody Trainer t) {
		Trainer e=service.addTrainer(t);
		
		return new ResponseEntity<String>("record inserted successfully",HttpStatus.OK);
		
		}
	
	@GetMapping("/fetchTrainer/{location}/{technology}")
	public ResponseEntity <List<Trainer>> fetchTrainer(@PathVariable String location,
			@PathVariable String technology){
		List <Trainer> obj=service.findTrainer(location,technology);
		return new ResponseEntity<List<Trainer>> (obj,HttpStatus.OK);
	}
	
 @GetMapping("/fetchByTechnology/{technology}")
 public ResponseEntity<Trainer> findByTechnology(@PathVariable String technology){
	 Trainer obj=service.findByTechnology(technology);
	 return new ResponseEntity<Trainer> (obj,HttpStatus.OK);
 }
	
	@PutMapping("/updateTrainerDetails")
	public  ResponseEntity<String> updateTrainerByTrainerId(@Validated @RequestBody Trainer t){
		String status= null;
		Optional <Trainer> obj=service.findByTrainerId(t.getTrainerId());
		if(obj.isPresent()) {
			service.updateTrainerByTrainerId(t);
			status="successfully updated";
		}
		else {
			throw new ResourceNotFoundException("given TrainerId is not available in db");
			
		}
		return new ResponseEntity<String>(status,HttpStatus.OK);
	}
	
}


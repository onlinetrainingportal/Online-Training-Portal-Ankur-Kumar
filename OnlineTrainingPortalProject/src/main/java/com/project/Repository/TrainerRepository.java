package com.project.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.Model.Trainer;
@Repository
public interface TrainerRepository extends JpaRepository<Trainer, String> {
	
	@Query(value="select e from Trainer e where e.location=:location"
			+ " AND e.technology=:technology")
	List<Trainer> findTrainer(@Param("location") String location,
			@Param("technology") String technology);
	
	public Trainer findByTechnology(String technology);
	public Trainer findByTrainerId(String trainerId);
	
	

}


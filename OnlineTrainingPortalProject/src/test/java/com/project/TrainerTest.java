package com.project;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.project.Model.Trainer;
import com.project.Repository.TrainerRepository;
import com.project.Service.TrainerService;

@SpringBootTest
public class TrainerTest {
	@MockBean
	private TrainerRepository repository;
	@Autowired
	private TrainerService service;
	public void fetchByTechnology() {
		String technology="c++";
		when(repository.findByTechnology(technology))
		.thenReturn( (Trainer) Stream.of(new Trainer("123","ankur","c++","patna","9898989898","ank@gmail.com"))
				.collect(Collectors.toList()));
		assertEquals(1, ((List<Trainer>) service.findByTechnology(technology)).size());
	
	}
	
}



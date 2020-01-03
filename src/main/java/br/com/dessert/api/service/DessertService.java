package br.com.dessert.api.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.dessert.api.entity.Dessert;
import br.com.dessert.api.entity.dto.DessertDTO;
import br.com.dessert.api.repository.DessertRepository;

@Service
@Transactional
public class DessertService {
	
	@Autowired
	private DessertRepository repository;
	
	public List<Dessert> list() {
		return repository.findAll();
	}
	
	public Dessert insert(DessertDTO dessertDTO) {
		
		Dessert dessert = new Dessert();
		dessert.setId(null);
		dessert.setName(dessertDTO.getName());
		dessert.setCreated(new Date());
		
		return repository.save(dessert);
	}
}

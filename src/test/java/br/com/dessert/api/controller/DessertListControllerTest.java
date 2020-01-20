package br.com.dessert.api.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.dessert.api.controller.DessertController;
import br.com.dessert.api.entity.Dessert;
import br.com.dessert.api.entity.dto.DessertDTO;
import br.com.dessert.api.repository.DessertRepository;
import br.com.dessert.api.service.DessertService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DessertListControllerTest {
	
	@MockBean
	private DessertRepository repository;
	
	@Autowired
	private DessertService service;
	
	private DessertController controller;

	@Before
	public void setup() {
		controller = new DessertController(service);
	}
	
	private Dessert getDessertFake(Long id) {
		
		Dessert dessert = new Dessert();
		dessert.setId(id);
		dessert.setName("teste dessert " + id);
		dessert.setCreated(new Date());
		
		return dessert;
	}
	
	private DessertDTO getDessertFakeDTO(Long id) {
		
		DessertDTO dessertDTO = new DessertDTO();

		dessertDTO.setName("teste dessert " + id);
		
		return dessertDTO;
	}

	private List<Dessert> getDessertListFake(){
		List<Dessert> dessertList = new ArrayList<>(5);
		for (int i = 0; i < 5; i++) {
			Dessert dessert = this.getDessertFake(1L);
			dessertList.add(dessert);
		}
		return dessertList;
	}
	
	@Test
	public void insertDessert() {
		Dessert dessert = this.getDessertFake(1L);
		DessertDTO dessertDTO = this.getDessertFakeDTO(2L);
		
		Mockito.when(repository.saveAndFlush(dessert)).thenReturn(dessert);
		
		ResponseEntity<Dessert> response = controller.insert(dessertDTO);
		Dessert dessertResult = response.getBody();
		
		Assert.assertEquals(HttpStatus.OK.value(), response.getStatusCodeValue());
		Assert.assertNotNull(response);
		Assert.assertNotNull(dessertResult.getName());	
		
	}
	
	@Test
	public void dessertList() {
		Mockito.when(repository.findAll()).thenReturn(this.getDessertListFake());
		
		ResponseEntity<List<Dessert>> response = controller.list();
		Assert.assertEquals(HttpStatus.OK.value(), response.getStatusCodeValue());
		Assert.assertNotNull(response);
	}
}

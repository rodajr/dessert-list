package br.com.dessert.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.dessert.api.entity.Dessert;
import br.com.dessert.api.entity.dto.DessertDTO;
import br.com.dessert.api.service.DessertService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping(value = "/dessert")
@Api(value = "API REST Dessert")
@CrossOrigin(origins = "*")
public class DessertController {
	
	@Autowired
	private DessertService service;
	
	public DessertController(DessertService service) {
		this.service = service;
	}
	
	@ApiOperation(value = "Shows Dessert List", notes = "Dessert List Method")
	@RequestMapping(value = "/list" ,method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Dessert>> list() {
		
		return ResponseEntity.ok().body(service.list());
	}
	
	@ApiOperation(value = "Insert Dessert", notes = "Insert Dessert Method")
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Dessert> insert(
			@ApiParam(value = "Dessert Object", required = true)
			@Valid @RequestBody	DessertDTO dessertDTO) {
		
		Dessert dessert = service.insert(dessertDTO);
		
		return ResponseEntity.ok().body(dessert);
	}
}

package com.gapsy.back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import com.gapsy.back.service.ServiceProvedores;
import com.gapsy.back.entity.ProvedoresEntity;

@RestController
@CrossOrigin(origins ="http://localhost:4200")
public class ControllerProvedores {
	
	
	@Autowired
	ServiceProvedores service;
	
	@Value("${version}")
	private String version;
	
	@Value("${candidato}")
	private String candidato;
	
	@GetMapping(value = "/provedores")
	public ResponseEntity<Page<ProvedoresEntity>> getProvedores(
			@RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "nombre") String order,
            @RequestParam(defaultValue = "true") boolean asc){
		
		Page<ProvedoresEntity> provedores = service.getProvedores(PageRequest.of(page, size, Sort.by(order)));
						
		return new ResponseEntity<Page<ProvedoresEntity>>(provedores, HttpStatus.OK);
		
	}
	
	@PostMapping(value = "/altaProvedor")
	public void altaProvedor(@RequestBody ProvedoresEntity request) throws Exception{
		service.saveProvedor(request);
	}
	
	
	@DeleteMapping(value = "/deleteProvedor/{nombre}")
	public void deletePovedor(@PathVariable String nombre){
		service.deleteProvedor(nombre);
    }

	@GetMapping(value = "/version")
	public String getVersion() {
		return "{ \"version\" : \"" + version + "\"}";
	}

	
	@GetMapping(value = "/candidato")
	public String getCandidato() {
		return "{ \"candidato\" : \"" + candidato + "\"}";
	}

	
}

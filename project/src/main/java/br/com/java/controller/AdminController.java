package br.com.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.java.data.vo.v1.AdminVO;
import br.com.java.modal.Admin;
import br.com.java.modal.Produto;
import br.com.java.services.AdminServices;



@RequestMapping("/api/admin/v1")
@RestController
public class AdminController {
	
	@Autowired
	public AdminServices service;
	
	
	@GetMapping(value = "/adm",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<AdminVO> findAll() {
		return service.findAll();
	}
	@GetMapping(value = "/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public AdminVO findById(@PathVariable(value = "id") Long id) {
		return service.findById(id);
	}
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public AdminVO update(@RequestBody AdminVO admin) {
		return service.update(admin);
	}
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping(value = "/createProduto", produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public Produto create(Produto produto) {
			return service.create(produto);
	}
	
	
}
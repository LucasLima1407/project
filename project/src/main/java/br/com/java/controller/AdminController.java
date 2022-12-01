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

import br.com.java.data.vo.v1.ProdutoVO;
import br.com.java.services.ProdutoServices;



@RequestMapping("/api/admin/v1")
@RestController
public class AdminController {
	
	
	@Autowired
	public ProdutoServices services;
	
	
	@GetMapping(value = "/produtos",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ProdutoVO> findAll() {
		return services.findAll();
	}
	@GetMapping(value = "/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ProdutoVO findById(@PathVariable(value = "id") Long id) {
		return services.findById(id);
	}
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ProdutoVO update(@RequestBody ProdutoVO produto) {
		return services.update(produto);
	}
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
		services.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping(value = "/createproduto", produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ProdutoVO create(ProdutoVO produto) {
			return services.create(produto);
	}
	
	
}
package br.com.java.services;

import java.util.List;
import java.util.logging.Logger;


import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.java.controller.AdminController;

import br.com.java.data.vo.v1.ProdutoVO;
import br.com.java.exceptions.RequiredObjectIsNullException;
import br.com.java.exceptions.ResourceNotFoundException;
import br.com.java.mapper.DozerMapper;
import br.com.java.modal.Produto;
import br.com.java.repositories.ProdutoRepository;

@Service
public class ProdutoServices {
	
	private Logger logger = Logger.getLogger(ProdutoServices.class.getName());
	
	@Autowired
	public ProdutoRepository repository;
	
	public List<ProdutoVO> findAll() {

		logger.info("Finding all people!");

		var produtos = DozerMapper.parseListObjects(repository.findAll(), ProdutoVO.class);
		produtos.stream().forEach(p -> p.add(linkTo(methodOn(AdminController.class).findById(p.getKey())).withSelfRel()));
		return produtos;
	}
	public ProdutoVO findById(Long id) {
		
		logger.info("Finding one admin!");
		
		var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		var vo = DozerMapper.parseObject(entity, ProdutoVO.class);
		vo.add(linkTo(methodOn(AdminController.class).findById(id)).withSelfRel());
		
		return vo;
	}
	public ProdutoVO create(ProdutoVO produto) {
		
		if (produto == null) throw new RequiredObjectIsNullException();
		logger.info("Creating one Produto!");
		var entity = DozerMapper.parseObject(produto, Produto.class);
		var vo =  DozerMapper.parseObject(repository.save(entity), ProdutoVO.class);
		vo.add(linkTo(methodOn(AdminController.class).findById(vo.getKey())).withSelfRel());
		return vo;
	}
	
	


public void delete(Long id) {
	
	logger.info("Deleting one person!");
	
	var entity = repository.findById(id)
			.orElseThrow(
					() -> new ResourceNotFoundException
					("No records found for this ID!"));
	repository.delete(entity);
}
public ProdutoVO update(ProdutoVO produto) {

	if (produto == null) throw new RequiredObjectIsNullException();
	
	logger.info("Updating one person!");
	
	var entity = repository.findById(produto.getKey())
		.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

	entity.setNome(produto.getNome());
	entity.setMarca(produto.getMarca());
	entity.setPreco(produto.getPreco());
	entity.setQuantidade(produto.getQuantidade());
	
	var vo =  DozerMapper.parseObject(repository.save(entity), ProdutoVO.class);
	vo.add(linkTo(methodOn(AdminController.class).findById(vo.getKey())).withSelfRel());
	return vo;
}
}

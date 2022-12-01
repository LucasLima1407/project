package br.com.java.services;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.java.controller.AdminController;
import br.com.java.data.vo.v1.AdminVO;
import br.com.java.exceptions.RequiredObjectIsNullException;
import br.com.java.exceptions.ResourceNotFoundException;
import br.com.java.mapper.DozerMapper;
import br.com.java.modal.Produto;
import br.com.java.repositories.AdminRepository;
import br.com.java.repositories.ProdutoRepository;

@Service
public class AdminServices {
	
	private Logger logger = Logger.getLogger(AdminServices.class.getName());
	
		@Autowired
		public AdminRepository repository;
		
	/*public List<AdminVO> findAll() {

		logger.info("Finding all admin!");

		var admins = DozerMapper.parseListObjects(repository.findAll(), AdminVO.class);
		admins.stream().forEach(p -> p.add(linkTo(methodOn(AdminController.class).findById(p.getKey())).withSelfRel()));
		return admins;
	}
	
	public AdminVO findById(Long id) {
		
		logger.info("Finding one admin!");
		
		var entity = repository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		var vo = DozerMapper.parseObject(entity, AdminVO.class);
		vo.add(linkTo(methodOn(AdminController.class).findById(id)).withSelfRel());
		return vo;
	}
public AdminVO update(AdminVO admin) {

	if (admin == null) throw new RequiredObjectIsNullException();
	
	logger.info("Updating one admin!");
	
	var entity = repository.findById(admin.getKey())
		.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

	entity.setNome(admin.getNome());
	entity.setLogin(admin.getLogin());
	entity.setSenha(admin.getSenha());

	
	var vo =  DozerMapper.parseObject(repository.save(entity), AdminVO.class);
	vo.add(linkTo(methodOn(AdminController.class).findById(vo.getKey())).withSelfRel());
	return vo;
}



public void delete(Long id) {
	
	logger.info("Deleting one person!");
	
	var entity = repository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
	repository.delete(entity);
}*/
	
}

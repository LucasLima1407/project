package br.com.java.services;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.java.data.vo.v1.ProdutoVO;
import br.com.java.exceptions.RequiredObjectIsNullException;
import br.com.java.modal.Produto;
import br.com.java.repositories.ProdutoRepository;

@Service
public class ProdutoServices {
	
	private Logger logger = Logger.getLogger(AdminServices.class.getName());
	
	@Autowired
	public ProdutoRepository repository;
	
	public Produto create(Produto produto) {
		
		if (produto == null) throw new RequiredObjectIsNullException();
		logger.info("Creating one person!");
		var entity = DozerMapper.parseObject(produto, ProdutoVO.class);
		var vo =  DozerMapper.parseObject(repository.save(entity), Produto.class);
		vo.add(linkTo(methodOn(ProdutoController.class).findById(vo.getId())).withSelfRel());
		return vo;
	}
}

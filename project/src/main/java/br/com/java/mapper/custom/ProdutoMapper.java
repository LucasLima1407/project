package br.com.java.mapper.custom;

import org.springframework.stereotype.Service;

import br.com.java.data.vo.v1.ProdutoVO;
import br.com.java.modal.Produto;

@Service
public class ProdutoMapper {
	
	
	public ProdutoVO convertEntityToVo(Produto produto) {
		
		ProdutoVO  vo = new ProdutoVO();
		
		vo.setKey(produto.getId());
		vo.setNome(produto.getNome());
		vo.setCodigo(produto.getCodigo());
		vo.setMarca(produto.getMarca());
		vo.setPreco(produto.getPreco());
		vo.setQuantidade(produto.getQuantidade());
		
		return vo;
		
	}
	public Produto convertVoTOEntity(ProdutoVO produto) {
		
		Produto entity = new Produto();
		entity.setId(produto.getKey());
		entity.setNome(produto.getNome());
		//entity.setCodigo(produto.getCodigo());
		entity.setMarca(produto.getMarca());
		entity.setPreco(produto.getPreco());
		entity.setQuantidade(produto.getQuantidade());
		
		
		return entity;
	}
}

package br.com.java.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.java.modal.Admin;
import br.com.java.modal.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	
}

package br.com.stellar.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.stellar.domain.model.entity.Produto;
@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}

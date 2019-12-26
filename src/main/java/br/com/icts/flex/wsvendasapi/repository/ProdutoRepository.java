package br.com.icts.flex.wsvendasapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.icts.flex.wsvendasapi.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}

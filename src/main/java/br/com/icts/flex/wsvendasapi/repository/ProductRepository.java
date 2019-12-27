package br.com.icts.flex.wsvendasapi.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.icts.flex.wsvendasapi.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	List<Product> findAllByNomeIgnoreCaseContaining(String nome);

	List<Product> findAllByDescricaoIgnoreCaseContaining(String descricao);

	/**
	 * Query para buscar produto pelo código, é do tipo List para evitar erros se
	 * alguém inserir um código repetido no banco
	 * 
	 * @param codigo
	 * @return
	 */
	List<Product> findByCodigoIgnoreCase(String codigo);

	@Query(value = "SELECT p FROM Product p WHERE LOWER(p.nome) LIKE %?1% OR LOWER(p.descricao) LIKE %?1%")
	List<Product> searchByNomeOrDescricaoIgnoreCase(String nomeOrDescricao);

	@Query(value = "SELECT p FROM Product p WHERE LOWER(p.nome) LIKE %?1% OR LOWER(p.descricao) LIKE %?1%")
	Page<Product> searchByNomeOrDescricaoPaginatedIgnoreCase(String nomeOrDescricao, Pageable page);
}

package br.com.icts.flex.wsvendasapi.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.icts.flex.wsvendasapi.model.Product;

@Service
public interface ProductService extends GenericService<Product, Long> {

	List<Product> searchByNomeIgnoreCase(String nome);

	List<Product> searchByDescricaoIgnoreCase(String descricao);

	List<Product> searchByNomeOrDescricaoIgnoreCase(String nomeOrDescricao);

	Page<Product> searchByNomeOrDescricaoPaginatedIgnoreCase(String nomeOrDescricao, int page, int count,
			Sort.Direction direction, String sortProperty);

//	@Autowired
//	ProdutoRepository repository;
//
//	public List<Produto> getAll() {
//		List<Produto> produtoList = repository.findAll();
//
//		if (produtoList.size() > 0) {
//			return produtoList;
//		} else {
//			return new ArrayList<Produto>();
//		}
//	}
//
//	public Produto getProdutoById(Long id) {
//		Optional<Produto> produto = repository.findById(id);
//
//		if (produto.isPresent()) {
//			return produto.get();
//		} else {
//			throw new EntityNotFoundException("Produto nao existe");
//		}
//	}
//
//	public Produto createOrUpdate(Produto entity) {
//		Optional<Produto> produto = repository.findById(entity.getId());
//
//		if (produto.isPresent()) {
//			Produto newEntity = produto.get();
//			newEntity.setTitulo(entity.getTitulo());
//			newEntity.setDescricao(entity.getDescricao());
//			newEntity.setStatus(entity.getStatus());
//			newEntity.setValor(entity.getValor());
//			newEntity = repository.save(newEntity);
//
//			return newEntity;
//		} else {
//			entity = repository.save(entity);
//			return entity;
//		}
//	}
//
//	public void deleteById(Long id) {
//		Optional<Produto> produto = repository.findById(id);
//
//		if (produto.isPresent()) {
//			repository.deleteById(id);
//		} else {
//			  throw new EntityNotFoundException("Produto nao existe");
//		}
//	}
}

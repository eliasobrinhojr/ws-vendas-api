package br.com.icts.flex.wsvendasapi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.icts.flex.wsvendasapi.exception.RecordNotFoundException;
import br.com.icts.flex.wsvendasapi.model.Produto;
import br.com.icts.flex.wsvendasapi.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	ProdutoRepository repository;

	public List<Produto> getAll() {
		List<Produto> produtoList = repository.findAll();

		if (produtoList.size() > 0) {
			return produtoList;
		} else {
			return new ArrayList<Produto>();
		}
	}

	public Produto getProdutoById(Long id) throws RecordNotFoundException {
		Optional<Produto> produto = repository.findById(id);

		if (produto.isPresent()) {
			return produto.get();
		} else {
			throw new RecordNotFoundException("Não existe produto para o ID fornecido");
		}
	}

	public Produto createOrUpdate(Produto entity) throws RecordNotFoundException {
		Optional<Produto> produto = repository.findById(entity.getId());

		if (produto.isPresent()) {
			Produto newEntity = produto.get();
			newEntity.setTitulo(entity.getTitulo());
			newEntity.setDescricao(entity.getDescricao());
			newEntity.setStatus(entity.getStatus());
			newEntity.setValor(entity.getValor());
			newEntity = repository.save(newEntity);

			return newEntity;
		} else {
			entity = repository.save(entity);
			return entity;
		}
	}

	public void deleteById(Long id) throws RecordNotFoundException {
		Optional<Produto> produto = repository.findById(id);

		if (produto.isPresent()) {
			repository.deleteById(id);
		} else {
			throw new RecordNotFoundException("Não existe registro de produto para o ID fornecido");
		}
	}
}

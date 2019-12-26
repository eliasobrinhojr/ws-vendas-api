package br.com.icts.flex.wsvendasapi.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.icts.flex.wsvendasapi.exception.RecordNotFoundException;
import br.com.icts.flex.wsvendasapi.model.Produto;
import br.com.icts.flex.wsvendasapi.service.ProdutoService;

@RestController
@RequestMapping("api/vendas")
public class ProdutoController {

	@Autowired
	ProdutoService service;

	@GetMapping("/produtos")
	public List<Produto> getAll() {
		return service.getAll();
	}

	@GetMapping("/produtos/{id}")
	public ResponseEntity<Produto> getById(@PathVariable(value = "id") Long id) throws RecordNotFoundException {
		Produto obj = service.getProdutoById(id);
		return ResponseEntity.ok().body(obj);
	}

	@PostMapping("/produtos")
	public Produto create(@Valid @RequestBody Produto entity) throws RecordNotFoundException {
		return service.createOrUpdate(entity);
	}

	@PutMapping("/produtos/{id}")
	public ResponseEntity<Produto> update(@PathVariable(value = "id") Long id, @Valid @RequestBody Produto newEntity)
			throws RecordNotFoundException {
		final Produto updated = service.createOrUpdate(newEntity);
		return ResponseEntity.ok(updated);
	}

	@DeleteMapping("/produtos/{id}")
	public Map<String, Boolean> delete(@PathVariable(value = "id") Long id) throws RecordNotFoundException {
		service.deleteById(id);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}

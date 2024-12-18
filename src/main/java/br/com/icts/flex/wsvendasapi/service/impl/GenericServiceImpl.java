package br.com.icts.flex.wsvendasapi.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolationException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.com.icts.flex.wsvendasapi.exception.EntityInvalidException;
import br.com.icts.flex.wsvendasapi.service.GenericService;
import br.com.icts.flex.wsvendasapi.service.MessagesService;

@Service
public class GenericServiceImpl<T, ID extends Serializable> implements GenericService<T, ID> {

	protected final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
	private JpaRepository<T, ID> repository;
	
    @Autowired
    public MessagesService messagesService;

	@Override
	public void saveOrUpdate(T entity) {		
		try {
			repository.save(entity);
		} catch (ConstraintViolationException e) {
			throw new  EntityInvalidException(e.getMessage());
		}
	}

	@Override
	public List<T> getAll() {
		return repository.findAll();
	}

	@Override
	public Page<T> getAllPaginated(int page, int count, Direction direction, String sortProperty) {
		return repository.findAll(new PageRequest(page, count, new Sort(direction, sortProperty)));
	}

	@Override
	public T get(ID id) {
		return repository.findOne(id);
	}
	@Override
	public T add(T entity) {
		return repository.save(entity);
	}

	@Override
	public T update(T entity) {
		return repository.save(entity);
	}

	@Override
	public T addOrUpdate(T entity) {
		return repository.save(entity);
	}

	@Override
	public void updateEntities(Set<T> entities) {
		repository.save(entities);
	}

	@Override
    public void remove(T entity) {
        repository.delete(entity);
    }

    @Override
    public void removeById(ID id) {
        repository.delete(id);
    }

	@Override
	public void removeEntities(Set<T> entities) {
		repository.delete(entities);
	}

	@Override
	public void removeEntitiesById(List<ID> entityIds) {
		for (ID id : entityIds) {
			repository.delete(id);
		}
	}
}

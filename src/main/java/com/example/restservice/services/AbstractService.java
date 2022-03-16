package com.example.restservice.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public abstract class AbstractService<T, TDto, ID extends Serializable> {

    private final JpaRepository<T, ID> repository;

    public AbstractService(JpaRepository<T, ID> repository) {
        this.repository = repository;
    }

    public List<T> findAll() {
        return repository.findAll();
    }

    public T findById(ID id) {
        var entity = repository.findById(id);
        if (entity.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return entity.get();
    }

    public T create(TDto dto) {
        return repository.save(dtoToEntity(dto));
    }

    public T update(ID id, TDto tdo) {
        Optional<T> toUpdate = repository.findById(id);
        if (toUpdate.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return repository.save(updateEntityFromDto(toUpdate.get(), tdo));
    }

    public void delete(ID id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        repository.deleteById(id);
    }

    abstract protected T dtoToEntity(TDto dto);

    abstract protected T updateEntityFromDto(T toUpdate, TDto dto);
}

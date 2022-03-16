package com.example.restservice.services;

import java.util.List;

public interface EntityService<T, TDto, ID> {

    public List<T> findAll();

    public T findById(ID id);

    public T create(TDto entity);

    public T update(ID id, TDto entity);

    public void delete(ID id);

}

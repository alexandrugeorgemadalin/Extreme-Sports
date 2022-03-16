package com.example.restservice.controllers;

import com.example.restservice.services.EntityService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.io.Serializable;
import java.util.List;

public abstract class AbstractController<T, TDto, ID extends Serializable> {

    private final EntityService<T, TDto, ID> serviceBean;

    public AbstractController(EntityService<T, TDto, ID> serviceBean) {
        this.serviceBean = serviceBean;
    }

    @GetMapping
    public ResponseEntity<List<T>> getAll() {
        try {
            var allEntities = serviceBean.findAll();
            return new ResponseEntity<>(allEntities, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<T> getById(@PathVariable("id") ID id) {
        try {
            return new ResponseEntity<>(serviceBean.findById(id), HttpStatus.OK);
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(e.getStatus());
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<T> create(@RequestBody @Validated TDto entity) {
        try {
            return new ResponseEntity<>(serviceBean.create(entity), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<T> update(@PathVariable("id") ID id, @RequestBody @Validated TDto entity) {
        try {
            return new ResponseEntity<>(serviceBean.update(id, entity), HttpStatus.OK);
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(e.getStatus());
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") ID id) {
        try {
            serviceBean.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(e.getStatus());
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

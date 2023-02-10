package com.codegym.repository;

import com.codegym.model.Declaration;

import java.util.List;

public interface IDeclarationRepository {
    List<Declaration> findAll();
    void save(Declaration declaration);
}

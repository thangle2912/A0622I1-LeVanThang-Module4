package com.codegym.service;

import com.codegym.model.Declaration;

import java.util.List;

public interface IDeclarationService {
    List<Declaration> findAll();
    void save(Declaration declaration);
}

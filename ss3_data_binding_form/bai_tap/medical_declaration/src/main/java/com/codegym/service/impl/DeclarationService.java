package com.codegym.service.impl;

import com.codegym.model.Declaration;
import com.codegym.repository.IDeclarationRepository;
import com.codegym.service.IDeclarationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DeclarationService implements IDeclarationService {
   @Autowired
    IDeclarationRepository declarationRepository;
    @Override
    public List<Declaration> findAll() {
        return declarationRepository.findAll();
    }

    @Override
    public void save(Declaration declaration) {
        declarationRepository.save(declaration);
    }
}

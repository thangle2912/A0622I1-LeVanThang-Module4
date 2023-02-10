package com.codegym.repository.impl;

import com.codegym.model.Declaration;
import com.codegym.repository.IDeclarationRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class DeclarationRepository implements IDeclarationRepository {
    static List<Declaration> declarationLists = new ArrayList<>();
    static {
        declarationLists.add(new Declaration(1,"Thắng Lê",2000,1,"Việt Nam","19739236"));
        declarationLists.add(new Declaration(2,"Thắng",2000,1,"Việt Nam","19739236"));
        declarationLists.add(new Declaration(3,"Lê",2000,1,"Việt Nam","19739236"));
        declarationLists.add(new Declaration(4,"ThắngLV",2000,1,"Lào","19739236"));

    }
    @Override
    public List<Declaration> findAll() {
        return declarationLists;
    }

    @Override
    public void save(Declaration declaration) {
        declarationLists.add(declaration);
    }
}

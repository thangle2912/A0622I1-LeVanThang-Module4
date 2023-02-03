package com.codegym.service.impl;

import com.codegym.repository.IDictionaryRepository;
import com.codegym.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class DictionaryService implements IDictionaryService {

    @Autowired
    IDictionaryRepository dictionaryRepository;

    @Override
    public String search(String keyword) {
        String result = dictionaryRepository.search(keyword);
        if (result == null) {
            return result = "Không tìm thấy";
        }
        return result;
    }
}

package com.codegym.repository.impl;

import com.codegym.repository.IDictionaryRepository;
import org.springframework.stereotype.Controller;

import java.util.HashMap;

@Controller
public class DictionaryRepository implements IDictionaryRepository {
    static HashMap<String, String> dictionaryList = new HashMap<String, String>();
    static {
        dictionaryList.put("I","Tôi");
        dictionaryList.put("You","Bạn");
        dictionaryList.put("He","Anh ấy");
        dictionaryList.put("She","Cô ấy");
    }

    @Override
    public String search(String keyword) {
        return dictionaryList.get(keyword);
    }
}

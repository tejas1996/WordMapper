package com.example.WordMapping.model;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;

@Service
public class IndexMap {

    HashMap<String, Integer> indexMap;
    int numberOfWords;

    @PostConstruct
    private void init() {
        indexMap = new HashMap<>();
        numberOfWords = 0;
    }

    public void addEntry(String word) {

        if (!indexMap.containsKey(word)) {
            indexMap.put(word, numberOfWords++);
        }
    }

    public int getIndex(String word) {
        return indexMap.get(word);
    }


}

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

    public int addEntry(String word) {

        if (!indexMap.containsKey(word)) {
            indexMap.put(word, numberOfWords++);
        }
        System.out.println("added a entry");
        return numberOfWords;
    }

    public int getIndex(String word) {
        Integer value = indexMap.get(word);
        if (value == null)
            return -1;
        return value;
    }


}

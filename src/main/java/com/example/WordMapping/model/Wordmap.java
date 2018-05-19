package com.example.WordMapping.model;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;

@Service
public class Wordmap {

    HashMap<String, WordNode> wordMap;

    @PostConstruct
    private void init() {
        wordMap = new HashMap<>();
    }

    public void addNode(WordNode wordNode) {

        if (!wordMap.containsKey(wordNode.word)) {
            wordMap.put(wordNode.word, wordNode);
        }
    }


}

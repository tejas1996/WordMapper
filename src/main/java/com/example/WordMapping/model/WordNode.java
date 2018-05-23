package com.example.WordMapping.model;

import java.util.ArrayList;
import java.util.HashMap;

public class WordNode {

    String word;
    int lenght;
    ArrayList<WordNode> mostRelevantWords;

    public WordNode(String word) {
        this.word = word;
        lenght = word.length();
        mostRelevantWords = new ArrayList<>();
    }
}

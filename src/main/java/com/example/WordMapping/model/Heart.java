package com.example.WordMapping.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;

@Service
public class Heart {

    @Autowired
    IndexMap indexMap;

    @Autowired
    Wordmap wordmap;

    int numberOfWords = 0;

    int[][] array = new int[1000][1000];

    public void addNode() {

        numberOfWords++;
    }

    public void makeConnection(String a, String b) throws Exception {
        Integer c = indexMap.getIndex(a);
        Integer d = indexMap.getIndex(b);

        if (c == -1) {
            WordNode wordNode = new WordNode(a);
            wordmap.addNode(wordNode);
            int indexOfA = indexMap.addEntry(a);
            numberOfWords++;
            c = indexOfA;
        }
        if (d == -1) {
            WordNode wordNode = new WordNode(b);
            wordmap.addNode(wordNode);
            int indexOfB = indexMap.addEntry(b);
            numberOfWords++;
            d = indexOfB;
        }

        array[c][d]++;

        System.out.println(array[0][1] + "and" + array[c][d]);

    }




}

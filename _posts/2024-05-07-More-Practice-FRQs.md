---
title: More Practice FRQ Exams!
description: More more more!!!!
layout: post
courses: {'csa': {'week': 25}}
categories: ['C4.0']
type: tangibles
comments: True
---

```java
public class WordScrambler {
    private String[] scrambledWords;
    public WordScrambler(String[] wordArr){
        scrambledWords = wordArr;
    }

    private String recombine(String word1, String word2){
        String recombinedWord = word1.substring(0, word1.length()/2) + word2.substring(word2.length()/2, word2.length());
        return recombinedWord;

    }

private String[] mixedWords(String[] words){
    for (int i = 0; i < words.length - 1; i += 2){
        words[i] = recombine(words[i], words[i + 1]);
        words[i + 1] = recombine(words[i + 1], words[i]);
    }

    return words;
}
    
    
    

    public static void main(String[] args){
        String[] words = {"apple", "pear", "this", "cat"}; // Example array of words
        WordScrambler newInstance = new WordScrambler(words);
        String newString = newInstance.recombine("apple", "pear");
        String newString2 = newInstance.recombine("pear", "apple");
        System.out.println(newString);
        System.out.println(newString2);
        String[] newArray = newInstance.mixedWords(words);
        for (int i = 0; i < newArray.length; i++){
            System.out.println(newArray[i]);
        }
    }


    
}

WordScrambler.main(null)

```

    apar
    peple
    pear
    apple
    this
    cat


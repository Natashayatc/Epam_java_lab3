package Comparator;


import java.util.Comparator;

import Text.Word;

public class WordComparator implements Comparator<Word> {

    public int compare(Word w1, Word w2) {
        return w1.constructTextOfTheParts().compareToIgnoreCase(w2.constructTextOfTheParts());
    }
}
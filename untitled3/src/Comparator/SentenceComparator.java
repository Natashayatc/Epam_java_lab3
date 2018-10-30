package Comparator;

import Runner.TextHandler;
import Text.Sentence;
import Text.Word;

import java.util.Comparator;
import java.util.List;

public class SentenceComparator implements Comparator<Sentence> {

    public int compare(Sentence s1, Sentence s2) {
        List<Word> words1 = TextHandler.getWordsFromSentence(s1);
        List<Word> words2 = TextHandler.getWordsFromSentence(s2);
        return Integer.compare(words1.size(), words2.size());
    }
}

package Parser;

import Text.Word;

import java.util.regex.Pattern;

public class WordParser extends Parser {

    public WordParser(Parser p, String r) {
        super(p, r);
    }

    @Override
    public Word defineComponent(String text) {

        Word word = new Word();

        boolean digit;
        boolean decomposite;

        digit = Pattern.matches("\\d+", text);
        decomposite = Pattern.matches("^\\w+'\\w*$", text);

        word.setDecomposite(decomposite);
        word.setDigit(digit);

        return word;
    }
}
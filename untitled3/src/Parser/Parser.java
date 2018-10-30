package Parser;
import Text.Component;
import Text.Letter;
import Text.Separator;
import Text.Text;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;


abstract public class Parser {
    Parser next;
    String regexpr;

    public Parser(Parser p, String r) {
        next = p;
        regexpr = r;
    }

    public Parser setNext(Parser p) {
        next = p;
        return p;
    }

    public Parser getNext() {
        return next;
    }

    public void setRegexpr(String reg) {
        regexpr = reg;
    }

    public String getRegexpr() {
        return regexpr;
    }

    public Text parse(String text) {

        Text t = defineComponent(text);
        Component separator;
        Component part = null;
        Pattern pattern = null;
        try {
            pattern = Pattern.compile(getRegexpr());
        } catch (PatternSyntaxException e) {
            System.out.println("Неправильное выражение: " + getRegexpr());
        }
        Matcher m;
        m = pattern.matcher(text);

        int last_match = 0;

        while (m.find()) {

            separator = new Separator(text.substring(last_match, m.start()));
            t.addPart(separator);

            if (getNext() == null) {
                part = new Letter(m.group());
            } else {
                part = getNext().parse(m.group());
            }
            t.addPart(part);

            last_match = m.end();
        }
        t.addPart(new Separator(text.substring(last_match)));

        return t;
    }

    abstract public Text defineComponent(String text);
}
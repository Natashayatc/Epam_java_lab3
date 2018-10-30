package Parser;

import java.util.regex.Pattern;
import Text.Paragraph;
public class ParagraphParser extends Parser {

    public ParagraphParser(Parser p, String r) {
        super(p, r);
    }

    @Override
    public Paragraph defineComponent(String text) {
        Paragraph par = new Paragraph();

        boolean head;

        head = Pattern.matches("\\b([\\d][.])+[^\\n]+", text);
        par.setHead(head);

        return par;
    }
}
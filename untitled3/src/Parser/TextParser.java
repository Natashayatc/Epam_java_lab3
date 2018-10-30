package Parser;
import Text.Text;

public class TextParser extends Parser {

    public TextParser(Parser p, String r) {
        super(p, r);
    }

    @Override
    public Text defineComponent(String text) {
        return new Text();
    }
}
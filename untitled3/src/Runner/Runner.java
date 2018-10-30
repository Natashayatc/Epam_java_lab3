package Runner;
import Comparator.SentenceComparator;
import Text.Sentence;
import Text.Text;
import java.util.Collections;
import java.util.List;
// Вывести все предложения заданного текста в порядке возрастания
// количества слов в каждом из них.
public class Runner {

    public static void main(String[] args) {
        String str = TextHandler.writeFileIntoString("d:\\Users\\Alexander\\Desktop\\Word.txt");
        Text text = TextHandler.getTextFromString(str);

        List<Sentence> sList = TextHandler.getSentencesFromText(text);
        Collections.sort(sList, new SentenceComparator());

        for (Sentence s : sList) {
            System.out.println(s.constructTextOfTheParts());
        }


    }
}
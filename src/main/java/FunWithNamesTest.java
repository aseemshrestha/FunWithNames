import com.names.score.calculator.AppFileReader;
import com.names.score.calculator.ScoreCalculator;
import java.util.List;

public class FunWithNamesTest {

    public static void main(String[] args) throws Exception {
        AppFileReader reader = new AppFileReader();
        List<String> sortedNames = reader.readFile();
        ScoreCalculator logicCalculator = new ScoreCalculator();
        int score = logicCalculator.calculateScore(sortedNames);
        System.out.println(score);
    }
}

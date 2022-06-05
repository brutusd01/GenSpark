import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HighScore
{
    public final String scoresPath = "src/Resources/Scores.txt";
    public boolean CheckForHigh(float score)
    {
        try
        {
            List<String>  file = Files.lines(Paths.get(scoresPath))
                    .collect(Collectors.toList());
            for(String s:file)
            {
                float score2 = Float.parseFloat(s.split(" , ")[1]);
                if(score <= score2)
                    return false;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    public void SaveScore(String name, float score){
        try {
            Files.writeString(Paths.get(scoresPath),
                    String.format("%s%s , %s", System.lineSeparator(), name, score)
                    , StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

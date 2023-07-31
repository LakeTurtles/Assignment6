import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {
    public  List<TeslaSales> readFile (String fileName) throws Exception{
        List<TeslaSales> readFile = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))){
            String input = bufferedReader.readLine();

            while((input = bufferedReader.readLine()) != null){
                String[] info = input.split(",");

                String date = info[0];
                String sales = info[1];

                readFile.add(new TeslaSales(date, sales));
            }

        }
        return  readFile;
    }
}

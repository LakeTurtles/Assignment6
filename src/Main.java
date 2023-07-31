import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        CSVReader  csvReader = new CSVReader();


        List<TeslaSales> model3Sales = csvReader.readFile("model3.csv");
        List<TeslaSales> modelXSales = csvReader.readFile("modelX.csv");
        List<TeslaSales> modelSSales = csvReader.readFile("modelS.csv");


        PrintList2.printList(model3Sales, "Model 3");
        PrintList2.printList(modelSSales, "Model S");
        PrintList2.printList(modelXSales, "Model X");


    }
}
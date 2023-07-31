import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class PrintList2 {
    public static void printList(List<TeslaSales> teslaSales, String modelType){
        System.out.println("\u001B[34m\n------------------------------------------");
        System.out.println("Sales for " + modelType);
        System.out.println("-----------------------------------\u001B[35m");

        Map<Integer, List<TeslaSales>> groupedByYear = teslaSales.stream().collect(Collectors
                .groupingBy(Date-> Date.getDate().getYear()));

        String totalSalesByYear = groupedByYear.entrySet().stream()
                .map(date -> date.getKey() + " -> " + date.getValue().stream()
                        .collect(Collectors.summingInt(value -> value.getSales())))
                .collect(Collectors.joining("\n"));

        System.out.println(totalSalesByYear);
        System.out.println("");

        Optional<TeslaSales> highestMonthSales = teslaSales.stream().max(Comparator.comparing(TeslaSales::getSales));
        Optional<TeslaSales> lowestMonthSales = teslaSales.stream().max((o1, o2) -> o2.getSales().compareTo(o1.getSales()));

        Optional<Integer> salesNumber = teslaSales.stream().max(Comparator.comparing(TeslaSales::getSales)).map(date -> date.getSales());
        Optional<Integer> lowSalesNumber = teslaSales.stream().max((o1, o2) -> o2.getSales().compareTo(o1.getSales())).map(date -> date.getSales());

        System.out.println("\u001B[34mThe highest sales month for " + modelType +"  was \u001B[35m"
                + salesNumber.orElse(200) + "\u001B[34m cars in \u001B[35m" + highestMonthSales.orElse(new TeslaSales("Jan-17", "0")).getDate());

        System.out.println("\u001B[34mThe lowest sales month for " + modelType + " was \u001B[35m"
                + lowSalesNumber.orElse(200) + "\u001B[34m cars in \u001B[35m" + lowestMonthSales.orElse(new TeslaSales("Jan-17", "0")).getDate());

    }
}

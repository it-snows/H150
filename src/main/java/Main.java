import com.company.data.CsvReader;

public class Main {
    public static void main(String[] args) {
        var csvManager = new CsvReader();

        var result = csvManager.getCounty();

        for (var county : result){
            System.out.println(county);
        }
    }
}

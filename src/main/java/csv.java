import java.io.FileReader;
import java.io.IOException;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

    public class csv {
        public static void main(String[] args) {
            try (FileReader reader = new FileReader("src/main/java/f1_dataset_test.csv");
                 CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT)) {

                for (CSVRecord csvRecord : csvParser) {
                    String column1 = csvRecord.get(0); // Obtén el valor de la columna 1
                    String column2 = csvRecord.get(1); // Obtén el valor de la columna 2

                    // Realiza el procesamiento deseado con los datos de cada fila
                    System.out.println("Columna 1: " + column1 + ", Columna 2: " + column2);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



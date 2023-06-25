package estructura;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import um.prog2.tad.lista.MyLinkedListImpl;

public class CSVReader {
    private static final String filePath = "src/main/resources/f1_dataset_test.csv";

    public List<Tweet> readCSV() throws IOException {
        List<Tweet> tweets = new ArrayList<>();

        try (FileReader reader = new FileReader(filePath);
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withHeader())) {

            for (CSVRecord csvRecord : csvParser) {
                long id = Long.parseLong(csvRecord.get("id"));
                String content = csvRecord.get("text");
                String source = csvRecord.get("source");
                boolean isRetweet = Boolean.parseBoolean(csvRecord.get("is_retweet"));
                LocalDate date = LocalDate.parse(csvRecord.get("date"));
                int favorites = Integer.parseInt(csvRecord.get("user_favourites"));

                long userId = Long.parseLong(csvRecord.get("user_id"));
                String userName = csvRecord.get("user_name");
                User user = new User(userId, userName);

                MyLinkedListImpl<Hashtag> hashtags = new MyLinkedListImpl<>();
                String[] hashtagTexts = csvRecord.get("hashtag").split(",");
                for (String text : hashtagTexts) {
                    hashtags.addLast(new Hashtag(text.hashCode(), text));
                }

                Tweet tweet = new Tweet(id, content, source, isRetweet, date, favorites, user, hashtags);
                tweets.add(tweet);
            }
        } catch (IOException e) {
            System.err.println("Ha ocurrido un error al leer el archivo CSV. Asegúrate de que el archivo existe y es accesible.");
            e.printStackTrace();
            throw e;
        }

        return tweets;
    }

    public List<String> readDrivers(String filePath) throws IOException {
        List<String> drivers = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                drivers.add(line);
            }
        } catch (IOException e) {
            System.err.println("Ha ocurrido un error al leer el archivo de texto. Asegúrate de que el archivo existe y es accesible.");
            e.printStackTrace();
            throw e;
        }

        return drivers;
    }

}


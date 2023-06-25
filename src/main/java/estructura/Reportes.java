
package estructura;

import estructura.Hashtag;
import estructura.Tweet;
import um.prog2.tad.hash.MyHash;
import um.prog2.tad.hash.MyHashImpl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Reportes {


//reporte1:
    public List<Piloto> top10PilotosMasMencionados(List<Tweet> tweets, int mes, int anio) throws IOException {
        List<String> pilotos = getPilotos(); // obtener la lista de pilotos
        HashMap<String, Piloto> mencionesPorPiloto = new HashMap<>();

        for (Tweet tweet : tweets) {
            // verificar si el tweet es del mes y año que estamos analizando
            if (tweet.getDate().getYear() == anio && tweet.getDate().getMonthValue() == mes) {
                // buscar en el contenido del tweet los nombres de los pilotos
                for (String nombrePiloto : pilotos) {
                    if (tweet.getContent().toLowerCase().contains(nombrePiloto.toLowerCase())) {
                        // si el piloto es mencionado en el tweet, agregar al contador
                        Piloto piloto;
                        if (mencionesPorPiloto.containsKey(nombrePiloto)) {
                            piloto = mencionesPorPiloto.get(nombrePiloto);
                        } else {
                            piloto = new Piloto(nombrePiloto, new MyHashImpl<Integer, Total>() {
                                @Override
                                public Total getOrDefault(Integer anio, Total total) {
                                    return null;
                                }
                            });
                            mencionesPorPiloto.put(nombrePiloto, piloto);
                        }

                        Total total = piloto.getTotalTweet().getOrDefault(anio, new Total(0, tweet.getUser()));
                        total.aumentar();
                        piloto.getTotalTweet().put(anio, total);
                    }
                }
            }
        }

        // transformar el HashMap a una lista y ordenarla
        List<Piloto> top10Pilotos = new ArrayList<>(mencionesPorPiloto.values());
        top10Pilotos.sort((p1, p2) -> Integer.compare(p2.getTotalTweet().get(anio).getTotal(), p1.getTotalTweet().get(anio).getTotal()));

        // si hay más de 10 pilotos, quedarse solo con los primeros 10
        if (top10Pilotos.size() > 10) {
            top10Pilotos = top10Pilotos.subList(0, 10);
        }

        return top10Pilotos;
    }


    private List<String> getPilotos() throws IOException {
        Path filePath = Paths.get("drivers.txt");
        return Files.readAllLines(filePath);
    }

    //reporte2:
    public List<UserReport> top15UsersWithMostTweets(List<Tweet> tweets) {
        HashMap<String, UserReport> usersCount = new HashMap<>();

        for (Tweet tweet : tweets) {
            String username = tweet.getUser().getUsername();
            UserReport userReport;

            if (usersCount.containsKey(username)) {
                userReport = usersCount.get(username);
            } else {
                userReport = new UserReport(username, tweet.getUser().isVerified());
                usersCount.put(username, userReport);
            }

            userReport.incrementTweetsCount();
        }

        // Transformar el HashMap a una lista y ordenarla
        List<UserReport> top15Users = new ArrayList<>(usersCount.values());
        top15Users.sort((u1, u2) -> Integer.compare(u2.getTweetsCount(), u1.getTweetsCount()));

        // Si hay más de 15 usuarios, quedarse solo con los primeros 15
        if (top15Users.size() > 15) {
            top15Users = top15Users.subList(0, 15);
        }

        return top15Users;
    }

    //reporte3:
    public int cantidadHashtagsPorDia(List<Tweet> tweets, String fecha) {
        LocalDate fechaIngresada = LocalDate.parse(fecha);
        HashSet<String> hashtagsUnicos = new HashSet<>();

        for (Tweet tweet : tweets) {
            LocalDate fechaTweet = tweet.getDate(); // No es necesaria ninguna conversión aquí

            if (fechaTweet.equals(fechaIngresada)) {
                String[] palabras = tweet.getContent().split(" ");
                for (String palabra : palabras) {
                    if (palabra.startsWith("#")) {
                        hashtagsUnicos.add(palabra);
                    }
                }
            }
        }

        return hashtagsUnicos.size();
    }


    //reporte4: Hashtag más usado para un día dado, sin tener en cuenta #f1. El día será ingresado en el formato YYYY-MM-DD.
    public String mostUsedHashtag(List<Tweet> tweets, LocalDate date) {
        Map<String, Integer> hashtagCount = new HashMap<>();

        for (Tweet tweet : tweets) {
            if (tweet.getDate().equals(date)) {
                for (Hashtag hashtag : tweet.getHashtagsList()) {
                    // ignoramos el hashtag #f1
                    if (!hashtag.getText().equalsIgnoreCase("#f1")) {
                        hashtagCount.put(hashtag.getText(), hashtagCount.getOrDefault(hashtag.getText(), 0) + 1);
                    }
                }
            }
        }

        // encontrar el hashtag más usado
        Map.Entry<String, Integer> mostUsedHashtag = null;
        for (Map.Entry<String, Integer> entry : hashtagCount.entrySet()) {
            if (mostUsedHashtag == null || entry.getValue() > mostUsedHashtag.getValue()) {
                mostUsedHashtag = entry;
            }
        }

        // devolver el hashtag más usado
        return mostUsedHashtag != null ? mostUsedHashtag.getKey() : "No hashtags used";
    }

    //reporte5:Top 7 cuentas con más favoritos. Para este listado se deberá retornar el nombre del usuario, junto con la cantidad de favoritos.

    private HashMap<User, Integer> favoritosPorUsuario = new HashMap<>();

    public void agregarTweet(Tweet tweet) {
        User user = tweet.getUser();
        int totalFavoritos = tweet.getFavorites();

        // Si el usuario ya existe en el HashMap, sumamos los favoritos del tweet actual
        if (favoritosPorUsuario.containsKey(user)) {
            totalFavoritos += favoritosPorUsuario.get(user);
        }

        favoritosPorUsuario.put(user, totalFavoritos);
    }

    public List<User> top7UsuariosConMasFavoritos() {
        List<Map.Entry<User, Integer>> lista = new ArrayList<>(favoritosPorUsuario.entrySet());
        lista.sort(Map.Entry.comparingByValue());

        // Creamos una lista para los 7 usuarios principales
        List<User> top7Usuarios = new ArrayList<>();
        for (int i = 0; i < 7 && i < lista.size(); i++) {
            top7Usuarios.add(lista.get(lista.size() - 1 - i).getKey());
        }

        return top7Usuarios;


    }

    //reporte6:Cantidad de tweets con una palabra o frase específicos (que será ingresado como parámetro).
    public int contarTweetsConPalabra(List<Tweet> tweets, String palabra) {
        int conteo = 0;

        for (Tweet tweet : tweets) {
            if (tweet.getContent().toLowerCase().contains(palabra.toLowerCase())) {
                conteo++;
            }
        }

        return conteo;
    }
}




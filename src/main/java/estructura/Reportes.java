package estructura;

import estructura.Hashtag;
import estructura.Tweet;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Reportes {


    //reportes de ines
    //reporte: Hashtag más usado para un día dado, sin tener en cuenta #f1. El día será ingresado en el formato YYYY-MM-DD.
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

    //reporte:Top 7 cuentas con más favoritos. Para este listado se deberá retornar el nombre del usuario, junto con la cantidad de favoritos.

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

    //reporte:Cantidad de tweets con una palabra o frase específicos (que será ingresado como parámetro).
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




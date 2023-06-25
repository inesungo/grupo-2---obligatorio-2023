package estructura;


import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.List;
import java.time.LocalDate;

public class Menu {
    private CSVReader csvReader;
    private Reportes reportes;

    public Menu() throws IOException {
        csvReader = new CSVReader();
        List<Tweet> tweets = csvReader.readCSV();
        reportes = new Reportes();
    }

    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Seleccione una opción: ");
            System.out.println("1. Los 10 pilotos de la temporada 2023 más mencionados en los tweets en un mes");
            System.out.println("2. Top 15 usuarios con más tweets");
            System.out.println("3. Cantidad de hashtags distintos para un día dado");
            System.out.println("4. Hashtag más usado para un día dado");
            System.out.println("5. Top 7 cuentas con más favoritos");
            System.out.println("6. Cantidad de tweets con una palabra o frase específicos");
            System.out.println("7. Salir");

            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    System.out.println("Ingrese el año (e.g. 2023):");
                    int anio = Integer.parseInt(scanner.nextLine());
                    System.out.println("Ingrese el número del mes (1-12):");
                    int mes = Integer.parseInt(scanner.nextLine());

                    // Obtener y mostrar el reporte
                    try {
                        List<Piloto> pilotosMasMencionados = reportes.top10PilotosMasMencionados(tweets, mes, anio);
                        System.out.println("Top 10 pilotos más mencionados en " + mes + "/" + anio + ":");
                        for (Piloto piloto : pilotosMasMencionados) {
                            System.out.println(piloto.getNombre() + " - " + piloto.getTotalTweet().get(anio).getTotal() + " menciones");
                        }
                    } catch (IOException e) {
                        System.out.println("Error al generar el reporte.");
                    }
                case "2":
                    List<UserReport> topUsers = reportes.top15UsersWithMostTweets(tweets);
                    // imprime los usuarios
                    for (UserReport userReport : topUsers) {
                        System.out.println("Usuario: " + userReport.getUsername() + ", Tweets: " + userReport.getTweetsCount());
                    }
                    break;
                case "3":
                    System.out.println("Por favor, introduce la fecha (en formato YYYY-MM-DD): ");
                    String fecha = scanner.next();
                    int cantidadHashtags = reportes.cantidadHashtagsPorDia(tweets, fecha);
                    System.out.println("La cantidad de hashtags distintos para el día " + fecha + " es: " + cantidadHashtags);
                    break;
                case "4":
                    System.out.println("Por favor, introduce la fecha (en formato YYYY-MM-DD): ");
                    String fechaHashtag = scanner.next();
                    LocalDate localDate = LocalDate.parse(fechaHashtag, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                    String mostUsedHashtag = reportes.mostUsedHashtag(tweets, localDate);
                    System.out.println("El hashtag más usado para el día " + fechaHashtag + " fue: " + mostUsedHashtag);
                    break;
                case "5":
                    List<User> topUsuariosFavoritos = reportes.top7UsuariosConMasFavoritos();
                    // imprime los usuarios
                    for (User user : topUsuariosFavoritos) {
                        System.out.println("Usuario: " + user.getUsername() + ", Favoritos: " + user.getUsername());
                    }
                    break;

                case "6":
                    System.out.println("Por favor, introduce una palabra o frase a buscar: ");
                    String palabra = scanner.next();
                    int conteo = reportes.contarTweetsConPalabra(tweets, palabra);
                    System.out.println("La cantidad de tweets con la palabra o frase \"" + palabra + "\" es: " + conteo);
                    break;
                case "7":
                    System.out.println("Saliendo...");
                    return;
                default:
                    System.out.println("Opción no reconocida. Por favor, intente de nuevo.");
            }
        }
    }
}

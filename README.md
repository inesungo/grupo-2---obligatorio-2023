# grupo-2---obligatorio-2023
Información del proyecto:
El código proporcionado es una implementación de un programa que utiliza datos de tweets relacionados con la Fórmula 1 para generar informes y estadísticas sobre diversos aspectos, como los pilotos más mencionados, los usuarios con más tweets, la cantidad de hashtags distintos en un día dado, el hashtag más usado en un día dado, las cuentas con más favoritos y la cantidad de tweets que contienen una palabra o frase específica.

El programa utiliza varias clases, incluyendo la clase "Menu", que contiene el método principal "mostrarMenu()" que muestra un menú de opciones y permite al usuario seleccionar una opción para generar un informe específico. Las opciones van desde generar informes sobre los pilotos más mencionados en un mes determinado hasta contar la cantidad de tweets que contienen una palabra o frase específica.

El programa también utiliza la clase "Reportes", que contiene los métodos para generar los informes y estadísticas mencionados anteriormente. Estos métodos utilizan los datos de los tweets proporcionados y realizan cálculos y análisis para generar los resultados deseados.

Ejecutación del programa:
El menú le solicitará al usuario que elija una opción y responderà en base a estas:
"1. Los 10 pilotos de la temporada 2023 más mencionados en los tweets en un mes"
"2. Top 15 usuarios con más tweets"
"3. Cantidad de hashtags distintos para un día dado"
"4. Hashtag más usado para un día dado"
"5. Top 7 cuentas con más favoritos"
"6. Cantidad de tweets con una palabra o frase específicos"
"7. Salir"

Método "top10PilotosMasMencionados":
El método genera un informe con los 10 pilotos más mencionados en los tweets de un mes y año específicos. A continuación, se explica cómo ejecutar este método:
Paso 1: Obtener una lista de tweets y proporcionarla como parámetro al método.
Paso 2: Especificar el mes y el año para el cual se desea generar el informe. Estos valores se deben pasar como parámetros al método.
Paso 3: Llamar al método "top10PilotosMasMencionados" con los parámetros adecuados.
Paso 4: El método procesará los tweets y generará una lista de objetos "Piloto" que representan los pilotos más mencionados.
Paso 5: Obtener la lista resultante.

Método "top15UsersWithMostTweets":
El método genera un informe con los 15 usuarios que han publicado la mayor cantidad de tweets. A continuación, se explica cómo ejecutar este método:
Paso 1: Obtener una lista de tweets y proporcionarla como parámetro al método.
Paso 2: Llamar al método "top15UsersWithMostTweets" con la lista de tweets como parámetro.
Paso 3: El método procesará los tweets y generará una lista de objetos "UserReport" que representan los usuarios con más tweets.
Paso 4: Obtener la lista resultante.

Método "cantidadHashtagsPorDia":
El método calcula la cantidad de hashtags únicos utilizados en los tweets en una fecha específica. A continuación, se explica cómo ejecutar este método:
Paso 1: Obtener una lista de tweets y proporcionarla como parámetro al método.
Paso 2: Especificar la fecha en el formato "YYYY-MM-DD" para la cual se desea calcular la cantidad de hashtags únicos. Este valor se debe pasar como parámetro al método.
Paso 3: Llamar al método "cantidadHashtagsPorDia" con los parámetros adecuados.
Paso 4: El método procesará los tweets y contará los hashtags únicos en la fecha especificada.
Paso 5: Obtener el resultado.

Método:"mostUsedHashtag":
Este método determina el hashtag más utilizado en un día específico, excluyendo el hashtag "#f1".A continuación, se explica cómo ejecutar este método:
El método recibe como entrada la fecha específica para la cual se desea obtener el hashtag más utilizado.
Utiliza un Hash llamado "hashtagCount" para realizar un seguimiento del recuento de cada hashtag en los tweets de esa fecha.
Recorre la lista de tweets y, para cada tweet, verifica si la fecha coincide con la fecha especificada.
Si la fecha coincide, se obtienen los hashtags del tweet (excluyendo el hashtag "#f1") y se incrementa su recuento en el Hash "hashtagCount".
Una vez que se ha recorrido la lista de tweets de la fecha especificada, se determina el hashtag con el recuento más alto en el HashMap.
El hashtag con el recuento más alto se devuelve como resultado.

Método:"top7UsuariosConMasFavoritos":
El método genera un informe con las 7 cuentas de usuario con más favoritos en sus tweets.A continuación, se explica cómo ejecutar este método:
Utiliza un HashMap llamado "favoritosPorUsuario" para realizar un seguimiento del número total de favoritos por cada cuenta de usuario.
Recorre la lista de tweets y, para cada tweet, obtiene el usuario asociado y el número de favoritos del tweet.
Utiliza el HashMap "favoritosPorUsuario" para acumular los favoritos de cada usuario en función de su cuenta.
Una vez que se han procesado todos los tweets, se ordenan las cuentas de usuario en función del número de favoritos de manera ascendente.
Se seleccionan las 7 cuentas de usuario con más favoritos y se devuelven como resultado.

Método:"contarTweetsConPalabra":
Este método cuenta la cantidad de tweets que contienen una palabra o frase específica.A continuación, se explica cómo ejecutar este método:
El método recibe como entrada la palabra o frase específica que se desea buscar en los tweets.
Recorre la lista de tweets y, para cada tweet, verifica si el contenido del tweet contiene la palabra o frase deseada.
Si se encuentra una coincidencia, se incrementa un contador.
Una vez que se han revisado todos los tweets, se devuelve el conteo total de tweets que contienen la palabra o frase especificada.


Carga de datos desde el archivo CSV:
El método "readCSV()" se encarga de leer el archivo CSV y cargar los datos en una lista de objetos Tweet.
Utiliza la biblioteca Apache Commons CSV para analizar el archivo CSV y obtener los valores de cada columna.
Los valores se convierten a los tipos de datos correspondientes y se crea un objeto Tweet con esos valores.
Se crea un objeto User a partir de los datos del usuario y una lista de objetos Hashtag a partir de los hashtags del tweet.
Finalmente, se agrega el tweet a la lista de tweets y anlogamente con el User.


# BotDiscord
Creación de un Bot de Discord, en su desarrollo se utilizan las librerías discord4j, que se encarga de la conexión y la 
creación y recepción de mensajes del bot aquí creado; además cuenta con la librería com.google.api-client:google-api-client
la cual se utiliza para la conexión de la aplicación con Google Drive con su consiguiente mensaje mandado por Discord. 
<br><br>
### Funciones de la aplicación
1. <b>!ping : </b> función que devuelve un mensaje !Pong.
2. <b>un saludito : </b>función que se encarga de la creación de un embed, con una foto y el mensaje deseado.
3. <b>!files : </b>función que muestra por pantalla los nombres de los archivos encontrados en la carpeta deseada.
4. <b>!descarga : </b>función que, conectandose con Google Drive, busca y descarga la imagen deseada en un archivo jpeg 
previamente creado.

import discord4j.core.DiscordClient;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.Message;
import discord4j.core.object.entity.channel.MessageChannel;
import discord4j.core.spec.EmbedCreateSpec;
import discord4j.rest.util.Color;

import java.io.File;
import java.time.Instant;

public class Main {
    public static void main(String[] args) {
        final String token = args[0]; //token generado desde el developer portal de discord creando una nueva aplicacion y generando un nuevo bot
        //el token se pasa por la configuracion de ejecucion
        final DiscordClient client = DiscordClient.create(token);
        final GatewayDiscordClient gateway = client.login().block();

        //creacion del embed para un saludito
        EmbedCreateSpec embed = EmbedCreateSpec.builder()
                .color(Color.BLUE)
                .title("Saludito")
                .url("https://www.youtube.com/watch?v=EyrflENzpww")
                .author("Alejandro", "https://i.ytimg.com/vi/SLwXbNQZjvk/maxresdefault.jpg", "https://i.ytimg.com/vi/SLwXbNQZjvk/maxresdefault.jpg")
                .description("Vegetita saludando")
                .thumbnail("https://i.ytimg.com/vi/SLwXbNQZjvk/maxresdefault.jpg")
                .image("https://i.ytimg.com/vi/SLwXbNQZjvk/maxresdefault.jpg")
                .timestamp(Instant.now())
                .build();

        gateway.on(MessageCreateEvent.class).subscribe(event -> {
            final Message message = event.getMessage();
            //si el mensaje recibido es !ping
            if ("!ping".equals(message.getContent())) {
                final MessageChannel channel = message.getChannel().block();
                channel.createMessage("Pong!").block();
            }

            //si el mensaje recibido es un saludito
            if ("Un saludito".equalsIgnoreCase(message.getContent())){
                final MessageChannel channel = message.getChannel().block();
                channel.createMessage(embed).block();
            }

            //si el mensaje es !files
            if ("!files".equals(message.getContent())){
                File file = new File("/home/dam1/cod/imagenes");
                File files[] = file.listFiles();
                for (int i = 0; i < files.length; i++) {
                    final MessageChannel channel = message.getChannel().block();
                    channel.createMessage(files[i].getName()).block();
                }
            }
        });
        gateway.onDisconnect().block();
    }
}

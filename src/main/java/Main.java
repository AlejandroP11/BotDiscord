import discord4j.core.DiscordClient;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.Message;
import discord4j.core.object.entity.channel.MessageChannel;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        final String token = args[0]; //token generado desde el developer portal de discord creando una nueva aplicacion y generando un nuevo bot
        //el token se pasa por la configuracion de ejecucion
        final DiscordClient client = DiscordClient.create(token);
        final GatewayDiscordClient gateway = client.login().block();

        gateway.on(MessageCreateEvent.class).subscribe(event -> {
            final Message message = event.getMessage();
            if ("!ping".equals(message.getContent())) {
                final MessageChannel channel = message.getChannel().block();
                channel.createMessage("Pong!").block();
            }
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

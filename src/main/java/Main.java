import discord4j.core.DiscordClient;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.Message;
import discord4j.core.object.entity.channel.MessageChannel;

public class Main {
    public static void main(String[] args) {
        final String token = "OTUzNjMwNTIxOTk1NDM2MTE0.YjHXog.8cxlaSru6-slzKiHi8ld_RDV2PE"; //token generado desde el developer portal de discord creando una nueva aplicacion y generando un nuevo bot
        final DiscordClient client = DiscordClient.create(token);
        final GatewayDiscordClient gateway = client.login().block();

        gateway.on(MessageCreateEvent.class).subscribe(event -> {
            final Message message = event.getMessage();
            if ("!ping".equals(message.getContent())) {
                final MessageChannel channel = message.getChannel().block();
                channel.createMessage("Pong!").block();
            }
        });

        gateway.onDisconnect().block();
    }
}

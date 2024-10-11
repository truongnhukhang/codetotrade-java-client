package coin.algorithm;

import coin.algorithm.bot.MacdRsiBot;
import coin.algorithm.server.BackTestServer;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {
        BackTestServer server = new BackTestServer(8888, MacdRsiBot.class);
        server.start();
        server.blockUntilShutdown();
    }
}

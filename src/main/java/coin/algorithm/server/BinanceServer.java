package coin.algorithm.server;

import coin.algorithm.domain.BaseBot;
import coin.algorithm.grpc.server.BackTestServiceImpl;
import coin.algorithm.grpc.server.BinanceServiceImpl;
import io.grpc.*;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;


public class BinanceServer {
    int port;
    Class<? extends BaseBot> bot;
    Server server;

    public BinanceServer(String apiKey, String secretKey, boolean isPaperTrading, int port, Class<? extends BaseBot> bot) throws IOException {
        this.port = port;
        this.bot = bot;
        server = Grpc.newServerBuilderForPort(port, InsecureServerCredentials.create())
                .permitKeepAliveTime(10, java.util.concurrent.TimeUnit.SECONDS).permitKeepAliveWithoutCalls(true)
                .maxInboundMessageSize(Integer.MAX_VALUE)
                .addService(new BinanceServiceImpl(apiKey, secretKey, bot,isPaperTrading)).build();
    }

    public void start() throws IOException {

        server.start();
    }

    public void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }


}

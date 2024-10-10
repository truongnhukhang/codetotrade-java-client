package coin.algorithm.server;

import coin.algorithm.domain.BaseBot;
import coin.algorithm.grpc.server.BackTestServiceImpl;
import io.grpc.Grpc;
import io.grpc.InsecureServerCredentials;
import io.grpc.Server;

import java.io.IOException;

public class BackTestServer {
    int port;
    Class<? extends BaseBot> bot;
    Server server;

    public BackTestServer(int port, Class<? extends BaseBot> bot) {
        this.port = port;
        this.bot = bot;
        server = Grpc.newServerBuilderForPort(port, InsecureServerCredentials.create())
                     .permitKeepAliveTime(10, java.util.concurrent.TimeUnit.SECONDS)
                .permitKeepAliveWithoutCalls(true)
                     .maxInboundMessageSize(Integer.MAX_VALUE).addService(new BackTestServiceImpl(bot)).build();
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

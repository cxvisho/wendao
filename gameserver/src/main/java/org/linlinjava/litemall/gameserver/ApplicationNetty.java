package org.linlinjava.litemall.gameserver;

import org.linlinjava.litemall.gameserver.game.GameCore;
import org.linlinjava.litemall.gameserver.netty.NettyServer;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;

@org.springframework.boot.autoconfigure.SpringBootApplication
@org.springframework.stereotype.Component
@org.springframework.core.annotation.Order(1)
public class ApplicationNetty implements org.springframework.boot.ApplicationRunner {
    @Autowired
    private GameCore gameCore;
    @Value("${netty.port}")
    private int port;
    @Value("${netty.url}")
    private String url;
    @Autowired
    private NettyServer server;

    public static void main(String[] args) {
        System.out.println("run .... . ... :");
        org.springframework.boot.SpringApplication.run(ApplicationNetty.class, args);
    }


    private static final Logger log = org.slf4j.LoggerFactory.getLogger(ApplicationNetty.class);

    public void run(ApplicationArguments args) {
        java.net.InetSocketAddress address = new java.net.InetSocketAddress(this.url, this.port);
        log.debug("run .... . ... " + this.url);
        this.server.start(address);
        this.gameCore.init(this.server);
    }
}


/* Location:              C:\Users\Administrator\Desktop\gameserver-0.1.0.jar!\org\linlinjava\litemall\gameserver\ApplicationNetty.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
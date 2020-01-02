package org.linlinjava.litemall.gameserver.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class NettyServer {
    @Autowired
    private ServerChannelInitializer serverChannelInitializer;
    private static final Logger logger = LoggerFactory.getLogger(NettyServer.class);

    public void start(InetSocketAddress address) {
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup();


        try {
            ServerBootstrap bootstrap = ((ServerBootstrap) ((ServerBootstrap) ((ServerBootstrap) new ServerBootstrap().group(bossGroup, workerGroup).channel(NioServerSocketChannel.class)).localAddress(address)).childHandler(this.serverChannelInitializer).option(ChannelOption.SO_BACKLOG, Integer.valueOf(128))).childOption(ChannelOption.SO_KEEPALIVE, Boolean.valueOf(true));

            ChannelFuture localChannelFuture = bootstrap.bind(address).sync();
        } catch (Exception e) {
            e.printStackTrace();
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}


/* Location:              C:\Users\Administrator\Desktop\gameserver-0.1.0.jar!\org\linlinjava\litemall\gameserver\netty\NettyServer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
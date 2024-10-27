package com.exam.net;

import com.exam.net.pkg.SetBossBar;
import com.exam.net.pkg.TurnAtoBPack;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.NetworkRegistry.ChannelBuilder;
import net.minecraftforge.network.simple.SimpleChannel;

public class Channel {
    public static SimpleChannel INSTANCE;
    public static String VERSION = "1.0";
    private static int id = 0;

    public Channel() {
    }

    public static int nextId() {
        return id++;
    }

    public static void register() {
        SimpleChannel net = ChannelBuilder.named(new ResourceLocation("exam", "exam_channel")).networkProtocolVersion(() -> {
            return VERSION;
        }).clientAcceptedVersions((s) -> {
            return true;
        }).serverAcceptedVersions((s) -> {
            return true;
        }).simpleChannel();
        INSTANCE = net;
        net.messageBuilder(TurnAtoBPack.class, nextId()).encoder(TurnAtoBPack::toBytes).decoder(TurnAtoBPack::new).consumerMainThread(TurnAtoBPack::handle).add();
        net.messageBuilder(SetBossBar.class, nextId()).encoder(SetBossBar::toBytes).decoder(SetBossBar::new).consumerMainThread(SetBossBar::handle).add();
    }

    public static <MSG> void sendToServer(MSG message) {
        INSTANCE.sendToServer(message);
    }
}


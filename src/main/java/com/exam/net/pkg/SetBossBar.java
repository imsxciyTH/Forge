package com.exam.net.pkg;

import java.util.function.Supplier;

import com.exam.gui.hud.BossBar;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.BossEvent;
import net.minecraft.world.BossEvent.BossBarColor;
import net.minecraft.world.BossEvent.BossBarOverlay;
import net.minecraftforge.network.NetworkEvent;

public class SetBossBar {
    private final int light_level;
    public static ServerBossEvent bossEvent = (ServerBossEvent)(new ServerBossEvent(Component.translatable("block.exam.b"), BossEvent.BossBarColor.PURPLE, BossEvent.BossBarOverlay.PROGRESS)).setDarkenScreen(true);

    public SetBossBar(int light_level) {
        this.light_level = light_level;
    }

    public SetBossBar(FriendlyByteBuf buf) {
        this.light_level = buf.readInt();
    }

    public void toBytes(FriendlyByteBuf buf) {
        buf.writeInt(light_level);
    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = (NetworkEvent.Context)supplier.get();
        ServerPlayer player = context.getSender();
        context.enqueueWork(() -> {
            if (player != null) {
                BossBar.start(light_level,player);
            }
        });
        return true;
    }
}


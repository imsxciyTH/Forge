package com.exam.gui.hud;

import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.BossEvent;

import java.util.Timer;
import java.util.TimerTask;

public class BossBar {
    public static ServerBossEvent bossEvent = (ServerBossEvent)(new ServerBossEvent(Component.translatable("block.exam.b"), BossEvent.BossBarColor.PURPLE, BossEvent.BossBarOverlay.PROGRESS)).setDarkenScreen(true);

    public static void start(int light_level, ServerPlayer player){
        int level = light_level + 1;
        if (level == 16) {
            bossEvent.setProgress(0F);
        } else {
            bossEvent.setProgress((float)level / 15.0F);
        }
        bossEvent.addPlayer(player);

        //5秒后消失
        java.util.Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                bossEvent.removePlayer(player);
            }
        },5000);
    }
}

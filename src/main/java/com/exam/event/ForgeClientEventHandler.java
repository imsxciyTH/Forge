package com.exam.event;

import com.exam.net.Channel;
import com.exam.net.pkg.TurnAtoBPack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber(modid = "exam", value = {Dist.CLIENT})
public class ForgeClientEventHandler {
    public ForgeClientEventHandler() {
    }

    //按键U将A转换为B
    @SubscribeEvent
    public static void onKeyInput(InputEvent.Key event) {
        if (event.getKey() == 85 && event.getAction() == 1) {
            Channel.sendToServer(new TurnAtoBPack());
        }

    }
}

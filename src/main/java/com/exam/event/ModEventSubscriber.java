package com.exam.event;

import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterGuiOverlaysEvent;
import net.minecraftforge.client.gui.overlay.VanillaGuiOverlay;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import javax.swing.text.JTextComponent;

import static com.exam.Exam.MODID;
import static com.exam.gui.hud.LightLevelHud.LIGHT_LEVEL_HUD;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD,modid = MODID)
public class ModEventSubscriber {
    @SubscribeEvent
    public static void addHud(RegisterGuiOverlaysEvent event) {
        event.registerAbove(VanillaGuiOverlay.HOTBAR.id(), "light_level_hud", LIGHT_LEVEL_HUD);
    }

    /*@SubscribeEvent
    public static void onKeyInput(InputEvent.Key event){

    }*/
}

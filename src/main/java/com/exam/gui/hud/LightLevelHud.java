package com.exam.gui.hud;

import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.world.BossEvent;
import net.minecraftforge.client.gui.overlay.IGuiOverlay;

import static com.exam.block.BBlock.LIGHT_LEVEl;

public class LightLevelHud {
    public static int light_level=0;

    public static final IGuiOverlay LIGHT_LEVEL_HUD = ((gui, guiGraphics, partialTick, screenWidth, screenHeight) -> {
        if (!gui.getMinecraft().options.hideGui)
        {

        }
    });


    /*public static final IGuiOverlay LIGHT_LEVEL_HUD = (((gui, guiGraphics, partialTick, screenWidth, screenHeight) -> {if (!gui.getMinecraft().options.hideGui) {
        var font = gui.getMinecraft().font;
        var text = "光照等级" + light_level;
        guiGraphics.drawString(font, text, 100, 100, 0xFFFFFF);
    }}));*/
}

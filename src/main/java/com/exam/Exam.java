package com.exam;

import com.exam.regist.BlockRegist;
import com.exam.regist.CreativeTabRegist;
import com.exam.regist.ItemRegist;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("exam")
public class Exam {
    public static final String MODID = "exam";

    public Exam(){
        var bus = FMLJavaModLoadingContext.get().getModEventBus();

        BlockRegist.BLOCKS.register(bus);
        ItemRegist.ITEMS.register(bus);
        CreativeTabRegist.CREATIVE_TABS.register(bus);
    }
}

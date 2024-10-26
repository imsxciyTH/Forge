package com.exam.regist;

import com.exam.Exam;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import static com.exam.Exam.MODID;

public class CreativeTabRegist {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    public static final RegistryObject<CreativeModeTab> THIRST = CREATIVE_TABS.register("exam_tab", () -> CreativeModeTab.builder()
            .title(Component.translatable("item_group." + MODID + ".exam_tab"))
            .icon(() -> new ItemStack(ItemRegist.B.get()))
            .displayItems((params, output) -> {
                output.accept(ItemRegist.A.get());
                output.accept(ItemRegist.B.get());
            })
            .build());
}

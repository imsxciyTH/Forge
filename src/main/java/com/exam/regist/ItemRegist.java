package com.exam.regist;

import com.exam.Exam;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemRegist {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Exam.MODID);

    public static final RegistryObject<Item> B = ITEMS.register("b",() -> new BlockItem(BlockRegist.B.get(), new Item.Properties()));
    public static final RegistryObject<Item> A = ITEMS.register("a",() -> new Item(new Item.Properties()));
}

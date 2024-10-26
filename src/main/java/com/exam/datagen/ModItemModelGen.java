package com.exam.datagen;

import com.exam.Exam;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import com.exam.regist.ItemRegist;

public class ModItemModelGen extends ItemModelProvider {
    public static final String GENERATED = "item/generated";

    public ModItemModelGen(PackOutput output, ExistingFileHelper existingFileHelper){
        super(output, Exam.MODID,existingFileHelper);
    }

    @Override
    protected void registerModels() {
        itemGeneratedModle(ItemRegist.A.get(),resourceItem(itemName(ItemRegist.A.get())));
        itemGeneratedModle(ItemRegist.B.get(),resourceItem(itemName(ItemRegist.B.get())));
    }

    //生成
    public void itemGeneratedModle(Item item, ResourceLocation texture){
        withExistingParent(itemName(item),GENERATED).texture("layer0",texture);
    }

    public String itemName(Item item){
        return ForgeRegistries.ITEMS.getKey(item).getPath();
    }

    public ResourceLocation resourceItem(String path){
        return new ResourceLocation(Exam.MODID,"item/"+path);
    }
}

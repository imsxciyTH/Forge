package com.exam.regist;

import com.exam.Exam;
import com.exam.block.BBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.exam.block.BBlock.LIGHT_LEVEl;

public class BlockRegist {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Exam.MODID);

    public static final RegistryObject<Block> B = BLOCKS.register("b",() -> new BBlock(BlockBehaviour.Properties.of().noOcclusion().noCollission().lightLevel(state -> state.getValue(LIGHT_LEVEl))));

}

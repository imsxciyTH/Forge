package com.exam.block;

import com.exam.gui.hud.LightLevelHud;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static com.exam.regist.ItemRegist.B;

public class BBlock extends Block {
    public static final IntegerProperty LIGHT_LEVEl = IntegerProperty.create("light",0,15);

    public BBlock(Properties pProperties) {
        super(pProperties);
    }

    //添加属性
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder){
        pBuilder.add(LIGHT_LEVEl);
    }

    //初始化light
    @Nullable
    @Override
    public BlockState getStateForPlacement(@NotNull BlockPlaceContext pContext){
        return this.defaultBlockState().setValue(LIGHT_LEVEl,0);
    }

    //使用狐火右键
    @Override
    public @NotNull InteractionResult use(@NotNull BlockState blockState, @NotNull Level level, @NotNull BlockPos blockPos
            , @NotNull Player player, @NotNull InteractionHand hand, @NotNull BlockHitResult result) {
        ItemStack itemStack =player.getItemInHand(hand);
        if(itemStack.is(B.get()) && !level.isClientSide){
            int light = blockState.getValue(LIGHT_LEVEl);
            if(light==15){
                level.setBlock(blockPos,blockState.setValue(LIGHT_LEVEl,0),1);
                LightLevelHud.light_level=0;
            }else {
                level.setBlock(blockPos,blockState.setValue(LIGHT_LEVEl,light + 1),1);
                LightLevelHud.light_level=light + 1;
            }
        }
        return InteractionResult.SUCCESS;
    }
}

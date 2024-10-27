package com.exam.net.pkg;

import com.exam.regist.ItemRegist;
import java.util.function.Supplier;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.network.NetworkEvent;

public class TurnAtoBPack {
    public TurnAtoBPack() {
    }

    public TurnAtoBPack(FriendlyByteBuf buf) {
    }

    public void toBytes(FriendlyByteBuf buf) {
    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = (NetworkEvent.Context)supplier.get();
        ServerPlayer player = context.getSender();
        context.enqueueWork(() -> {
            if (player != null && player.getMainHandItem().is((Item)ItemRegist.A.get())) {
                player.getMainHandItem().shrink(1);
                ItemStack itemStack = new ItemStack((ItemLike)ItemRegist.B.get());
                player.addItem(itemStack);
            }

        });
        return true;
    }
}

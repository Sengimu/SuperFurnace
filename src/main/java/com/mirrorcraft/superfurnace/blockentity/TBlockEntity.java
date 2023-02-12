package com.mirrorcraft.superfurnace.blockentity;

import com.mirrorcraft.superfurnace.setup.Regs;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Random;

public class TBlockEntity extends BlockEntity {
    Random r = new Random();
    private int counter = 15;
    private int finalCounter = 2 * counter + 1;

    public TBlockEntity(BlockPos pos, BlockState state) {
        super(Regs.T_BLOCK_ENTITY.get(), pos, state);
    }

    public int increase() {
        counter++;
        if (counter != finalCounter) {
            int luck = r.nextInt(2 * counter - 1) + 1;
            if (luck == counter) {
                return counter;
            } else {
                return 0;
            }
        } else {
            counter /= 2;
            return increase();
        }
        //markDirty();
    }

    private int count = 0;

    public void tick() {
        count += 1;
        if (count > 100) {
            count = 0;
            if (level != null && !level.isClientSide()) {
                Player player = level.getNearestPlayer(this.getBlockPos().getX(), this.getBlockPos().getY(), this.getBlockPos().getZ(), 5.0, false);
                if (player != null) {
                    player.sendMessage(new TranslatableComponent("message.superfurnace.welcome"), Util.NIL_UUID);
                }
            }
        }
    }
}

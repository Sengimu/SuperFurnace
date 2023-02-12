package com.mirrorcraft.superfurnace.blockentitys.entityblock;

import com.mirrorcraft.superfurnace.blockentitys.blockentity.TBlockEntity;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;

import javax.annotation.Nullable;

public class TBlock extends Block implements EntityBlock {
    public TBlock() {
        super(Properties
                .of(Material.STONE)
                .strength(2.0f));
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new TBlockEntity(blockPos, blockState);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand handIn, BlockHitResult hit) {
        if (!level.isClientSide && handIn == InteractionHand.MAIN_HAND) {
            TBlockEntity tBlockEntity = (TBlockEntity) level.getBlockEntity(pos);
            int counter = tBlockEntity.increase();
            if (counter != 0) {
                player.sendMessage(new TranslatableComponent("message.superfurnace.counter.success", counter), Util.NIL_UUID);
            } else {
                player.sendMessage(new TranslatableComponent("message.superfurnace.counter.fail", counter), Util.NIL_UUID);
            }
        }
        return InteractionResult.SUCCESS;
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        if (level.isClientSide()) {
            return null;
        }
        return (lvl, pos, blockState, t) -> {
            if (t instanceof TBlockEntity tile) {
                tile.tick();
            }
        };
    }

}

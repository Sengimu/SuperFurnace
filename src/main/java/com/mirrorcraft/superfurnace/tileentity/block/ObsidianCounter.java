package com.mirrorcraft.superfurnace.tileentity.block;

import com.mirrorcraft.superfurnace.setup.Regs;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class ObsidianCounter extends Block {
    public ObsidianCounter() {
        super(Regs.BLOCK_PROPERTIES);
    }

    //@Override
    public boolean hasTileEntity(BlockState state){
        return true;
    }
}

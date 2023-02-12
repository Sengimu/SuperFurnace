package com.mirrorcraft.superfurnace.datagen;

import com.mirrorcraft.superfurnace.SuperFurnace;
import com.mirrorcraft.superfurnace.setup.Regs;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockStates extends BlockStateProvider {
    public ModBlockStates(DataGenerator gen, ExistingFileHelper helper) {
        super(gen, SuperFurnace.modId, helper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlock(Regs.OBSIDIAN_BLOCK.get());
        simpleBlock(Regs.T_BLOCK.get());
    }
}

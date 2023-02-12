package com.mirrorcraft.superfurnace.datagen.loottables;

import com.google.common.collect.Iterables;
import com.mirrorcraft.superfurnace.setup.Regs;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import javax.annotation.Nonnull;

public class ModBlockLoot extends BlockLoot {
    public ModBlockLoot() {
    }

    @Override
    protected void addTables() {
        this.dropSelf(Regs.OBSIDIAN_BLOCK.get());
        this.dropSelf(Regs.T_BLOCK.get());
    }

    @Nonnull
    @Override
    protected Iterable<Block> getKnownBlocks() {
        return Iterables.transform(Regs.BLOCKS.getEntries(), RegistryObject::get);
    }
}

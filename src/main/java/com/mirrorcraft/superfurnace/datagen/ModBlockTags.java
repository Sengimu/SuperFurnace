package com.mirrorcraft.superfurnace.datagen;

import com.mirrorcraft.superfurnace.SuperFurnace;
import com.mirrorcraft.superfurnace.setup.Regs;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockTags extends BlockTagsProvider {
    public ModBlockTags(DataGenerator generator, ExistingFileHelper helper) {
        super(generator, SuperFurnace.modId, helper);
    }

    @Override
    protected void addTags() {
        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(Regs.OBSIDIAN_BLOCK.get());
        tag(BlockTags.NEEDS_IRON_TOOL).add(Regs.OBSIDIAN_BLOCK.get());
        tag(Tags.Blocks.ORES).add(Regs.OBSIDIAN_BLOCK.get());
    }

    @Override
    public String getName() {
        return "SP Tags";
    }
}

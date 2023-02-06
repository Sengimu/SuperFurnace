package com.mirrorcraft.superfurnace.datagen;

import com.mirrorcraft.superfurnace.SuperFurnace;
import com.mirrorcraft.superfurnace.setup.Regs;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemTags extends ItemTagsProvider {

    public ModItemTags(DataGenerator generator, BlockTagsProvider blockTags, ExistingFileHelper helper) {
        super(generator, blockTags, SuperFurnace.modId, helper);
    }

    @Override
    protected void addTags() {
        tag(Tags.Items.ORES).add(Regs.OBSIDIAN_BLOCK_ITEM.get());
    }

    @Override
    public String getName() {
        return "SP Tags";
    }
}
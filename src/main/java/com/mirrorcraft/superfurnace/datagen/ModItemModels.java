package com.mirrorcraft.superfurnace.datagen;

import com.mirrorcraft.superfurnace.SuperFurnace;
import com.mirrorcraft.superfurnace.setup.Regs;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemModels extends ItemModelProvider {
    public ModItemModels(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, SuperFurnace.modId, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(Regs.TIN_INGOT.get());
        basicItem(Regs.OBSIDIAN_INGOT.get());
        basicItem(Regs.BLUE_CORE.get());

        basicItem(Regs.OBSIDIAN_APPLE.get());

        handheldItem(Regs.OBSIDIAN_SWORD.get());
        handheldItem(Regs.OBSIDIAN_AXE.get());
        handheldItem(Regs.OBSIDIAN_HOE.get());
        handheldItem(Regs.OBSIDIAN_PICKAXE.get());
        handheldItem(Regs.OBSIDIAN_SHOVEL.get());

        basicItem(Regs.OBSIDIAN_HELMET.get());
        basicItem(Regs.OBSIDIAN_CHESTPLATE.get());
        basicItem(Regs.OBSIDIAN_LEGGINGS.get());
        basicItem(Regs.OBSIDIAN_BOOTS.get());

        withExistingParent(Regs.OBSIDIAN_BLOCK_ITEM.getId().getPath(), modLoc("block/obsidian_block"));
    }

    private ItemModelBuilder handheldItem(Item item) {
        return handheldItem(item.getRegistryName());
    }

    private ItemModelBuilder handheldItem(ResourceLocation item) {
        return getBuilder(item.toString())
                .parent(new ModelFile.UncheckedModelFile("item/handheld"))
                .texture("layer0", new ResourceLocation(item.getNamespace(), "item/" + item.getPath()));
    }
}

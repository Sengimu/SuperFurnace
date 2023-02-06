package com.mirrorcraft.superfurnace.setup;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

public class ModSetUp {
    public static void init(final FMLCommonSetupEvent event) {

    }

    public static final String TAB_NAME = "superfurnace";

    public static final CreativeModeTab ITEM_GROUP = new CreativeModeTab(TAB_NAME) {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(Regs.BLUE_CORE.get());
        }
    };
}
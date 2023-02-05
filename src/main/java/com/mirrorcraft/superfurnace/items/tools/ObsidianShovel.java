package com.mirrorcraft.superfurnace.items.tools;

import com.mirrorcraft.superfurnace.Custom.ObsidianTool;
import com.mirrorcraft.superfurnace.group.ModGroup;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ShovelItem;

public class ObsidianShovel extends ShovelItem {
    public ObsidianShovel() {
        super(ObsidianTool.OBSIDIAN, 10, -2.6f, (new Item.Properties()).tab(ModGroup.group));
    }
}

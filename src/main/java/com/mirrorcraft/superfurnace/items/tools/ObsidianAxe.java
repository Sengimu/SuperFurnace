package com.mirrorcraft.superfurnace.items.tools;

import com.mirrorcraft.superfurnace.Custom.ObsidianTool;
import com.mirrorcraft.superfurnace.group.ModGroup;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Item;

public class ObsidianAxe extends AxeItem {
    public ObsidianAxe() {
        super(ObsidianTool.OBSIDIAN, 10, -2.6f, (new Item.Properties()).tab(ModGroup.group));
    }
}

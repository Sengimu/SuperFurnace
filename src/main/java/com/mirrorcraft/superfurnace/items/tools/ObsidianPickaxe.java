package com.mirrorcraft.superfurnace.items.tools;

import com.mirrorcraft.superfurnace.Custom.ObsidianTool;
import com.mirrorcraft.superfurnace.group.ModGroup;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;

public class ObsidianPickaxe extends PickaxeItem {
    public ObsidianPickaxe() {
        super(ObsidianTool.OBSIDIAN, 10, -2.6f, (new Item.Properties()).tab(ModGroup.group));
    }
}


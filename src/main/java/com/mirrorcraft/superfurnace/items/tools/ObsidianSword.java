package com.mirrorcraft.superfurnace.items.tools;

import com.mirrorcraft.superfurnace.Custom.ObsidianTool;
import com.mirrorcraft.superfurnace.group.ModGroup;
import net.minecraft.world.item.SwordItem;

public class ObsidianSword extends SwordItem {
    public ObsidianSword() {
        super(ObsidianTool.OBSIDIAN, 13, -2.0F, new Properties().tab(ModGroup.group));
    }
}

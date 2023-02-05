package com.mirrorcraft.superfurnace.items.armor;

import com.mirrorcraft.superfurnace.Custom.ObsidianArmor;
import com.mirrorcraft.superfurnace.group.ModGroup;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;

public class ObsidianBoots extends ArmorItem {
    public ObsidianBoots() {
        super(ObsidianArmor.OBSIDIAN, EquipmentSlot.FEET, new Item.Properties().tab(ModGroup.group));
    }
}

package com.mirrorcraft.superfurnace.items.armor;

import com.mirrorcraft.superfurnace.Custom.ObsidianArmor;
import com.mirrorcraft.superfurnace.group.ModGroup;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;

public class ObsidianLeggings extends ArmorItem {
    public ObsidianLeggings() {
        super(ObsidianArmor.OBSIDIAN, EquipmentSlot.LEGS, new Properties().tab(ModGroup.group));
    }
}

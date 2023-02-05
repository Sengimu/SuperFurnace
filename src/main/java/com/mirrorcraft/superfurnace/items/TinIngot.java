package com.mirrorcraft.superfurnace.items;

import com.mirrorcraft.superfurnace.group.ModGroup;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class TinIngot extends Item {
    public TinIngot() {
        super(new Properties().tab(ModGroup.group));
    }
}

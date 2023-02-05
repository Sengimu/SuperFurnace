package com.mirrorcraft.superfurnace;

import com.mirrorcraft.superfurnace.items.armor.ObsidianBoots;
import com.mirrorcraft.superfurnace.items.armor.ObsidianChestplate;
import com.mirrorcraft.superfurnace.items.armor.ObsidianHelmet;
import com.mirrorcraft.superfurnace.items.armor.ObsidianLeggings;
import com.mirrorcraft.superfurnace.items.foods.ObsidianApple;
import com.mirrorcraft.superfurnace.items.BlueCore;
import com.mirrorcraft.superfurnace.items.ObsidianIngot;
import com.mirrorcraft.superfurnace.items.TinIngot;
import com.mirrorcraft.superfurnace.items.tools.*;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Regs {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "superfurnace");

    public static final RegistryObject<Item> OBSIDIAN_INGOT = ITEMS.register("obsidian_ingot", ObsidianIngot::new);
    public static final RegistryObject<Item> BLUE_CORE = ITEMS.register("blue_core", BlueCore::new);
    public static final RegistryObject<Item> TIN_INGOT = ITEMS.register("tin_ingot", TinIngot::new);
    public static final RegistryObject<Item> OBSIDIAN_APPLE = ITEMS.register("obsidian_apple", ObsidianApple::new);

    public static final RegistryObject<Item> OBSIDIAN_SWORD = ITEMS.register("obsidian_sword", ObsidianSword::new);
    public static final RegistryObject<Item> OBSIDIAN_AXE = ITEMS.register("obsidian_axe", ObsidianAxe::new);
    public static final RegistryObject<Item> OBSIDIAN_HOE = ITEMS.register("obsidian_hoe", ObsidianHoe::new);
    public static final RegistryObject<Item> OBSIDIAN_PICKAXE = ITEMS.register("obsidian_pickaxe", ObsidianPickaxe::new);
    public static final RegistryObject<Item> OBSIDIAN_SHOVEL = ITEMS.register("obsidian_shovel", ObsidianShovel::new);

    public static final RegistryObject<Item> OBSIDIAN_HELMET = ITEMS.register("obsidian_helmet", ObsidianHelmet::new);
    public static final RegistryObject<Item> OBSIDIAN_CHESTPLATE = ITEMS.register("obsidian_chestplate", ObsidianChestplate::new);
    public static final RegistryObject<Item> OBSIDIAN_LEGGINGS = ITEMS.register("obsidian_leggings", ObsidianLeggings::new);
    public static final RegistryObject<Item> OBSIDIAN_BOOTS = ITEMS.register("obsidian_boots", ObsidianBoots::new);

}

package com.mirrorcraft.superfurnace.setup;

import com.mirrorcraft.superfurnace.Custom.ObsidianArmor;
import com.mirrorcraft.superfurnace.Custom.ObsidianTool;
import com.mirrorcraft.superfurnace.SuperFurnace;
import com.mirrorcraft.superfurnace.items.foods.OrdinaryFood;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Regs {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SuperFurnace.modId);
    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, SuperFurnace.modId);

    public static void init() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ITEMS.register(bus);
        BLOCKS.register(bus);
    }

    public static final Item.Properties ITEM_PROPERTIES = new Item.Properties().tab(ModSetUp.ITEM_GROUP);
    public static final BlockBehaviour.Properties BLOCK_PROPERTIES = BlockBehaviour.Properties.of(Material.STONE).strength(2f, 2f).requiresCorrectToolForDrops();

    public static <B extends Block> RegistryObject<Item> fromBlock(RegistryObject<B> block) {
        return ITEMS.register(block.getId().getPath(), () -> new BlockItem(block.get(), ITEM_PROPERTIES));
    }


    //材料
    public static final RegistryObject<Item> TIN_INGOT = ITEMS.register("tin_ingot", () -> new Item(ITEM_PROPERTIES));
    public static final RegistryObject<Item> OBSIDIAN_INGOT = ITEMS.register("obsidian_ingot", () -> new Item(ITEM_PROPERTIES));
    public static final RegistryObject<Item> BLUE_CORE = ITEMS.register("blue_core", () -> new Item(ITEM_PROPERTIES));
    public static final RegistryObject<Item> MAGIC_INGOT = ITEMS.register("magic_ingot", () -> new Item(ITEM_PROPERTIES));

    //食物
    public static final RegistryObject<Item> OBSIDIAN_APPLE = ITEMS.register("obsidian_apple", () -> new Item(ITEM_PROPERTIES.food(OrdinaryFood.food)));

    //工具
    public static final RegistryObject<Item> OBSIDIAN_SWORD = ITEMS.register("obsidian_sword", () -> new SwordItem(ObsidianTool.OBSIDIAN, 13, -2.0f, ITEM_PROPERTIES));
    public static final RegistryObject<Item> OBSIDIAN_AXE = ITEMS.register("obsidian_axe", () -> new AxeItem(ObsidianTool.OBSIDIAN, 10, -2.6f, ITEM_PROPERTIES));
    public static final RegistryObject<Item> OBSIDIAN_HOE = ITEMS.register("obsidian_hoe", () -> new HoeItem(ObsidianTool.OBSIDIAN, 10, -2.6f, ITEM_PROPERTIES));
    public static final RegistryObject<Item> OBSIDIAN_PICKAXE = ITEMS.register("obsidian_pickaxe", () -> new PickaxeItem(ObsidianTool.OBSIDIAN, 10, -2.6f, ITEM_PROPERTIES));
    public static final RegistryObject<Item> OBSIDIAN_SHOVEL = ITEMS.register("obsidian_shovel", () -> new ShovelItem(ObsidianTool.OBSIDIAN, 10, -2.6f, ITEM_PROPERTIES));

    //防具
    public static final RegistryObject<Item> OBSIDIAN_HELMET = ITEMS.register("obsidian_helmet", () -> new ArmorItem(ObsidianArmor.OBSIDIAN, EquipmentSlot.HEAD, ITEM_PROPERTIES));
    public static final RegistryObject<Item> OBSIDIAN_CHESTPLATE = ITEMS.register("obsidian_chestplate", () -> new ArmorItem(ObsidianArmor.OBSIDIAN, EquipmentSlot.CHEST, ITEM_PROPERTIES));
    public static final RegistryObject<Item> OBSIDIAN_LEGGINGS = ITEMS.register("obsidian_leggings", () -> new ArmorItem(ObsidianArmor.OBSIDIAN, EquipmentSlot.LEGS, ITEM_PROPERTIES));
    public static final RegistryObject<Item> OBSIDIAN_BOOTS = ITEMS.register("obsidian_boots", () -> new ArmorItem(ObsidianArmor.OBSIDIAN, EquipmentSlot.FEET, ITEM_PROPERTIES));


    //方块
    public static final RegistryObject<Block> OBSIDIAN_BLOCK = BLOCKS.register("obsidian_block", () -> new Block(BLOCK_PROPERTIES));
    public static final RegistryObject<Item> OBSIDIAN_BLOCK_ITEM = fromBlock(OBSIDIAN_BLOCK);

}

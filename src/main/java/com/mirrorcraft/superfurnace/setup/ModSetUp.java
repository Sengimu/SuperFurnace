package com.mirrorcraft.superfurnace.setup;

import com.mirrorcraft.superfurnace.Custom.tree.Tree;
import com.mirrorcraft.superfurnace.SuperFurnace;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class ModSetUp {
    public static void init() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        bus.addListener(EventPriority.NORMAL, false, FMLClientSetupEvent.class, ModSetUp::MagicIngot);
        bus.addListener(EventPriority.NORMAL, false, FMLCommonSetupEvent.class, ModSetUp::setUp);
    }

    @SubscribeEvent
    public static void setUp(FMLCommonSetupEvent event) {
        event.enqueueWork(Tree::registerFeatures);
    }

    @SubscribeEvent
    public static void MagicIngot(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            ItemProperties.register(Regs.MAGIC_INGOT.get(), new ResourceLocation(SuperFurnace.modId, "size"), (itemStack, clientLevel, living, livingEntity) -> itemStack.getCount());
        });
    }

    public static final String TAB_NAME = "superfurnace";

    public static final CreativeModeTab ITEM_GROUP = new CreativeModeTab(TAB_NAME) {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(Regs.BLUE_CORE.get());
        }
    };
}
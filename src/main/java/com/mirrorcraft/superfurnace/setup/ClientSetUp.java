package com.mirrorcraft.superfurnace.setup;

import com.mirrorcraft.superfurnace.SuperFurnace;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = SuperFurnace.modId, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientSetUp {
    @SubscribeEvent
    public static void init(final FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            ItemProperties.register(Regs.MAGIC_INGOT.get(), new ResourceLocation(SuperFurnace.modId, "size"), (itemStack, clientLevel, living, livingEntity) -> itemStack.getCount());
        });
    }
}
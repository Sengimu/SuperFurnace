package com.mirrorcraft.superfurnace.setup;

import com.mirrorcraft.superfurnace.Custom.tree.Tree;
import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;

//@Mod.EventBusSubscriber(modid = SuperFurnace.modId, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientSetUp {
    public static void init() {
        IEventBus modbus = MinecraftForge.EVENT_BUS;

        modbus.addListener(EventPriority.NORMAL, false, BiomeLoadingEvent.class, ClientSetUp::biomeLoading);
        modbus.addListener(EventPriority.NORMAL, false, PlayerEvent.PlayerLoggedInEvent.class, ClientSetUp::onLoggedIn);
    }

    @SubscribeEvent
    public static void biomeLoading(BiomeLoadingEvent event) {
        event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Tree.GOLDEN_TREE);
    }

    @SubscribeEvent
    public static void onLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
        event.getPlayer().sendMessage(new TranslatableComponent("message.superfurnace.welcome").withStyle(ChatFormatting.GREEN), Util.NIL_UUID);
    }
}
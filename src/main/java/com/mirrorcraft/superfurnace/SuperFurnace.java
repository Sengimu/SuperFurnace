package com.mirrorcraft.superfurnace;

import com.mirrorcraft.superfurnace.setup.ClientSetUp;
import com.mirrorcraft.superfurnace.setup.ModSetUp;
import com.mirrorcraft.superfurnace.setup.Regs;
import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(SuperFurnace.modId)
public class SuperFurnace {
    public static final String modId = "superfurnace";

    public SuperFurnace() {
        Regs.init();

        IEventBus modbus = FMLJavaModLoadingContext.get().getModEventBus();

        modbus.addListener(ModSetUp::init);

        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> modbus.addListener(ClientSetUp::init));

        FMLJavaModLoadingContext.get().getModEventBus().addListener(EventPriority.NORMAL, false, FMLCommonSetupEvent.class, SuperFurnace::setup);
        MinecraftForge.EVENT_BUS.addListener(EventPriority.NORMAL, false, BiomeLoadingEvent.class, SuperFurnace::biomeLoading);
    }

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
    public static class PlayerLoggedInHandler {
        @SubscribeEvent
        public static void onLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
            event.getPlayer().sendMessage(new TranslatableComponent("message.superfurnace.welcome").withStyle(ChatFormatting.GREEN), Util.NIL_UUID);
        }
    }


    public static Holder<ConfiguredFeature<TreeConfiguration, ?>> GOLDEN_TREE_FEATURE;
    public static Holder<PlacedFeature> GOLDEN_TREE;

    public static void registerFeatures() {
        GOLDEN_TREE_FEATURE = FeatureUtils.register(
                "superfurnace:golden_tree",
                Feature.TREE,
                new TreeConfiguration.TreeConfigurationBuilder(
                        BlockStateProvider.simple(Blocks.STONE),
                        new StraightTrunkPlacer(8, 12, 0),
                        BlockStateProvider.simple(Blocks.GOLD_ORE),
                        new BlobFoliagePlacer(ConstantInt.of(4), ConstantInt.of(0), 4),
                        new TwoLayersFeatureSize(1, 1, 1)
                ).build()
        );
        GOLDEN_TREE = PlacementUtils.register(
                "superfurnace:golden_tree",
                GOLDEN_TREE_FEATURE,
                PlacementUtils.countExtra(6, 0.1F, 1),
                InSquarePlacement.spread(),
                VegetationPlacements.TREE_THRESHOLD,
                PlacementUtils.HEIGHTMAP_OCEAN_FLOOR,
                PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING),
                BiomeFilter.biome()
        );
    }

    public static void setup(FMLCommonSetupEvent event) {
        event.enqueueWork(SuperFurnace::registerFeatures);
    }

    public static void biomeLoading(BiomeLoadingEvent event) {
        event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, GOLDEN_TREE);
    }
}

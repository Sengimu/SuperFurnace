package com.mirrorcraft.superfurnace.Custom.tree;

import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
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

public class Tree {
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
}

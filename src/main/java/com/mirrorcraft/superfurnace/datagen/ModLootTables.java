package com.mirrorcraft.superfurnace.datagen;

import com.google.common.collect.ImmutableList;
import com.mirrorcraft.superfurnace.datagen.loottables.ModBlockLoot;
import com.mojang.datafixers.util.Pair;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.LootTables;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class ModLootTables extends LootTableProvider {
    protected final String modId;

    public ModLootTables(DataGenerator pGenerator, String modId) {
        super(pGenerator);
        this.modId = modId;
    }

    @NotNull
    @Override
    public String getName() {
        return super.getName() + ":" + modId;
    }

    @Nonnull
    @Override
    protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootContextParamSet>> getTables() {
        ImmutableList.Builder<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootContextParamSet>> builder = new ImmutableList.Builder<>();
        BlockLoot blockLootTable = new ModBlockLoot();
        builder.add(Pair.of(() -> blockLootTable, LootContextParamSets.BLOCK));

        return builder.build();
    }

    @Override
    protected void validate(Map<ResourceLocation, LootTable> map, @Nonnull ValidationContext context) {
        map.forEach((key, value) -> LootTables.validate(context, key, value));
    }
}
package com.mirrorcraft.superfurnace.items.foods;

import net.minecraft.world.food.FoodProperties;

public class OrdinaryFood {
    public static final FoodProperties food = (new FoodProperties.Builder())
            .saturationMod(0.3F)
            .nutrition(8)
            .build();
}


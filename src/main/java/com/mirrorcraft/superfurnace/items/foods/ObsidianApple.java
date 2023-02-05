package com.mirrorcraft.superfurnace.items.foods;

import com.mirrorcraft.superfurnace.group.ModGroup;
import net.minecraft.client.renderer.EffectInstance;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.Item;

public class ObsidianApple extends Item {
    private static final FoodProperties food = (new FoodProperties.Builder())
            .saturationMod(0.3F)
            .nutrition(8)
            .build();

    public ObsidianApple() {
        super(new Properties().food(food).tab(ModGroup.group));
    }
}


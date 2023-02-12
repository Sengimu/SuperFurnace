package com.mirrorcraft.superfurnace.items.foods;

import com.mirrorcraft.superfurnace.setup.ModSetUp;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

public class OrdinaryFood {
    public static final FoodProperties[] food = {
            (new FoodProperties.Builder())
                    .saturationMod(0.1F)
                    .nutrition(2)
                    .build(),

            (new FoodProperties.Builder())
                    .saturationMod(0.2F)
                    .nutrition(4)
                    .build()
    };

    public static final Item.Properties FOOD_PROPERTIED = new Item.Properties().tab(ModSetUp.ITEM_GROUP).food(OrdinaryFood.food[0]);
}


package com.mirrorcraft.superfurnace;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("superfurnace")
public class SuperFurnace {
    public SuperFurnace() {
        IEventBus modbus = FMLJavaModLoadingContext.get().getModEventBus();
        Regs.ITEMS.register(modbus);
    }
}

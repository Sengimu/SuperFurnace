package com.mirrorcraft.superfurnace;

import com.mirrorcraft.superfurnace.datagen.DataGenerators;
import com.mirrorcraft.superfurnace.setup.ClientSetUp;
import com.mirrorcraft.superfurnace.setup.ModSetUp;
import com.mirrorcraft.superfurnace.setup.Regs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(SuperFurnace.modId)
public class SuperFurnace {
    public static final String modId = "superfurnace";

    public SuperFurnace() {
        Regs.init();

        IEventBus modbus = FMLJavaModLoadingContext.get().getModEventBus();
        modbus.addListener(ModSetUp::init);

        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> modbus.addListener(ClientSetUp::init));
    }
}

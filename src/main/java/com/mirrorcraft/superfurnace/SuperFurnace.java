package com.mirrorcraft.superfurnace;

import com.mirrorcraft.superfurnace.setup.ClientSetUp;
import com.mirrorcraft.superfurnace.setup.ModSetUp;
import com.mirrorcraft.superfurnace.setup.Regs;
import net.minecraftforge.fml.common.Mod;

@Mod(SuperFurnace.modId)
public class SuperFurnace {
    public static final String modId = "superfurnace";

    public SuperFurnace() {
        Regs.init();

        ModSetUp.init();

        ClientSetUp.init();
    }
}

package com.mirrorcraft.superfurnace.group;

import com.mirrorcraft.superfurnace.Regs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class SuperFurnaceGroup extends CreativeModeTab {
    public SuperFurnaceGroup() {
        super("superfurnace");
    }

    @Override
    public @NotNull ItemStack makeIcon() {
        return new ItemStack(Regs.BLUE_CORE.get());
    }
}

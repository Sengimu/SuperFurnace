package com.mirrorcraft.superfurnace.datagen;

import com.mirrorcraft.superfurnace.setup.ModSetUp;
import com.mirrorcraft.superfurnace.setup.Regs;
import com.mirrorcraft.superfurnace.SuperFurnace;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class Language extends LanguageProvider {

    public Language(DataGenerator gen, String locale) {
        super(gen, SuperFurnace.modId, locale);
    }

    @Override
    protected void addTranslations() {
        add("itemGroup." + ModSetUp.TAB_NAME, "super furnace?");
        add(Regs.TIN_INGOT.get(), "tin ingot");
    }
}
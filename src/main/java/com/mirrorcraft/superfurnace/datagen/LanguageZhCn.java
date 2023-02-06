package com.mirrorcraft.superfurnace.datagen;

import com.mirrorcraft.superfurnace.setup.ModSetUp;
import com.mirrorcraft.superfurnace.setup.Regs;
import com.mirrorcraft.superfurnace.SuperFurnace;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class LanguageZhCn extends LanguageProvider {

    public LanguageZhCn(DataGenerator gen, String locale) {
        super(gen, SuperFurnace.modId, locale);
    }

    @Override
    protected void addTranslations() {
        add("itemGroup." + ModSetUp.TAB_NAME, "超级熔炉");

        add(Regs.TIN_INGOT.get(), "锡锭");
        add(Regs.OBSIDIAN_INGOT.get(), "黑曜石锭");
        add(Regs.BLUE_CORE.get(), "自然合金");
        add(Regs.MAGIC_INGOT.get(), "魔法金属");

        add(Regs.OBSIDIAN_APPLE.get(), "黑曜石苹果");

        add(Regs.OBSIDIAN_SWORD.get(), "黑曜石剑");
        add(Regs.OBSIDIAN_AXE.get(), "黑曜石斧");
        add(Regs.OBSIDIAN_HOE.get(), "黑曜石锄");
        add(Regs.OBSIDIAN_PICKAXE.get(), "黑曜石镐");
        add(Regs.OBSIDIAN_SHOVEL.get(), "黑曜石锹");

        add(Regs.OBSIDIAN_HELMET.get(), "黑曜石头盔");
        add(Regs.OBSIDIAN_CHESTPLATE.get(), "黑曜石盔甲");
        add(Regs.OBSIDIAN_LEGGINGS.get(), "黑曜石护腿");
        add(Regs.OBSIDIAN_BOOTS.get(), "黑曜石靴");

        add(Regs.OBSIDIAN_BLOCK.get(), "黑曜石金属方块");
    }
}
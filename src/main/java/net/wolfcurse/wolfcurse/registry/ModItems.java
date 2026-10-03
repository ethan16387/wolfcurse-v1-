package net.wolfcurse.wolfcurse.registry;

import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.wolfcurse.wolfcurse.WolfCurseMod;
import net.wolfcurse.wolfcurse.item.CleansingCharmItem;
import net.wolfcurse.wolfcurse.item.CurseCatalystItem;
import net.wolfcurse.wolfcurse.item.WolfCureItem;

public final class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(WolfCurseMod.MOD_ID);

    public static final DeferredItem<CurseCatalystItem> CURSE_CATALYST = ITEMS.registerItem(
            "wolf_curse_catalyst", CurseCatalystItem::new, new Item.Properties().stacksTo(16));

    public static final DeferredItem<WolfCureItem> WOLF_CURE = ITEMS.registerItem(
            "wolf_cure", WolfCureItem::new, new Item.Properties().stacksTo(16));

    public static final DeferredItem<CleansingCharmItem> CLEANSING_CHARM = ITEMS.registerItem(
            "cleansing_charm", CleansingCharmItem::new, new Item.Properties().stacksTo(1));

    private ModItems() { }
}

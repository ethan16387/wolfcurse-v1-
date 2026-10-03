package net.wolfcurse.wolfcurse;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import net.wolfcurse.wolfcurse.compat.create.CreateCompat;
import net.wolfcurse.wolfcurse.infection.InfectionEvents;
import net.wolfcurse.wolfcurse.registry.ModAttachments;
import net.wolfcurse.wolfcurse.registry.ModItems;

@Mod(WolfCurseMod.MOD_ID)
public final class WolfCurseMod {
    public static final String MOD_ID = "wolfcurse";

    public WolfCurseMod(IEventBus modBus) {
        ModItems.ITEMS.register(modBus);
        ModAttachments.ATTACHMENT_TYPES.register(modBus);
        NeoForge.EVENT_BUS.register(new InfectionEvents());
        CreateCompat.init();
    }
}

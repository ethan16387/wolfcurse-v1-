package net.wolfcurse.wolfcurse.compat.create;

import net.neoforged.fml.ModList;

public final class CreateCompat {
    public static void init() {
        if (ModList.get().isLoaded("create")) {
            System.out.println("[Wolf Curse] Create detected; the optional mixing recipe is available.");
        }
    }

    private CreateCompat() { }
}

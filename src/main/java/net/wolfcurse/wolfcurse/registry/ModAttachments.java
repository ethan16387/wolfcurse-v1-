package net.wolfcurse.wolfcurse.registry;

import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.wolfcurse.wolfcurse.WolfCurseMod;
import net.wolfcurse.wolfcurse.infection.InfectionData;

import java.util.function.Supplier;

public final class ModAttachments {
    public static final DeferredRegister<AttachmentType<?>> ATTACHMENT_TYPES =
            DeferredRegister.create(NeoForgeRegistries.Keys.ATTACHMENT_TYPES, WolfCurseMod.MOD_ID);

    public static final Supplier<AttachmentType<InfectionData>> INFECTION = ATTACHMENT_TYPES.register(
            "infection",
            () -> AttachmentType.builder(() -> InfectionData.DEFAULT)
                    .serialize(InfectionData.CODEC)
                    .copyOnDeath()
                    .build()
    );

    private ModAttachments() { }
}

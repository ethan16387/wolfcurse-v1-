package net.wolfcurse.wolfcurse.infection;

import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.tick.ServerTickEvent;
import net.neoforged.neoforge.server.ServerLifecycleHooks;
import net.wolfcurse.wolfcurse.registry.ModAttachments;

public final class InfectionEvents {
    private int ticks;

    @SubscribeEvent
    public void onServerTick(ServerTickEvent.Post event) {
        if (++ticks % 20 != 0) return;
        var server = ServerLifecycleHooks.getCurrentServer();
        if (server == null) return;

        for (ServerPlayer player : server.getPlayerList().getPlayers()) {
            InfectionData data = get(player);
            if (!data.infected() || data.transformed()) continue;

            float oldProgress = data.progress();
            float newProgress = Math.min(1.0f, oldProgress + 0.05f);
            InfectionData next = data.withProgress(newProgress);

            if (oldProgress < 0.25f && newProgress >= 0.25f) {
                player.displayClientMessage(Component.literal("The wolf curse is beginning to change you."), true);
            } else if (oldProgress < 0.55f && newProgress >= 0.55f) {
                player.displayClientMessage(Component.literal("The curse is spreading further."), true);
            } else if (oldProgress < 0.85f && newProgress >= 0.85f) {
                player.displayClientMessage(Component.literal("The transformation is nearly complete."), true);
            }

            if (newProgress >= 1.0f) {
                next = next.withTransformed(true);
                player.displayClientMessage(Component.literal("The wolf transformation is complete."), true);
            }

            set(player, next);
        }
    }

    public static boolean start(Player player) {
        InfectionData data = get(player);
        if (data.infected() || data.transformed()) return false;
        set(player, new InfectionData(true, false, 0.10f));
        player.displayClientMessage(Component.literal("The wolf curse has started."), true);
        return true;
    }

    public static boolean cure(Player player) {
        InfectionData data = get(player);
        if (!data.infected() && !data.transformed()) return false;
        set(player, InfectionData.DEFAULT);
        player.displayClientMessage(Component.literal("The wolf curse has been cleansed."), true);
        return true;
    }

    public static InfectionData get(Player player) {
        return player.getData(ModAttachments.INFECTION);
    }

    public static void set(Player player, InfectionData data) {
        player.setData(ModAttachments.INFECTION, data);
    }
}

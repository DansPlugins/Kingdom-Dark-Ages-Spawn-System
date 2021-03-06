package dansplugins.spawnsystem.eventhandlers;

import dansplugins.spawnsystem.DansSpawnSystem;
import dansplugins.spawnsystem.data.PersistentData;
import org.bukkit.ChatColor;
import org.bukkit.event.player.PlayerRespawnEvent;

public class PlayerRespawnEventHandler {

    public void handle(PlayerRespawnEvent event) {
        if (PersistentData.getInstance().getPlayerSpawns().containsKey(event.getPlayer().getUniqueId())) {
            DansSpawnSystem.getInstance().getServer().getScheduler().runTaskLater(DansSpawnSystem.getInstance(), new Runnable() {
                @Override
                public void run() {
                    event.getPlayer().teleport(PersistentData.getInstance().getPlayerSpawns().get(event.getPlayer().getUniqueId()));
                    event.getPlayer().sendMessage(ChatColor.GREEN + "Teleporting to custom spawn!");
                }
            }, 1);
        }
    }

}

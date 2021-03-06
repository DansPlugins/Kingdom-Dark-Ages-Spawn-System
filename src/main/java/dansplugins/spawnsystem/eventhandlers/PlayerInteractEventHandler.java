package dansplugins.spawnsystem.eventhandlers;

import dansplugins.spawnsystem.UtilitySubsystem;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerInteractEventHandler {

    public void handle(PlayerInteractEvent event) {
        // if player is right clicking a block
        Block clickedBlock = event.getClickedBlock();
        if (clickedBlock != null) {
            // if that block is a sign
            if (UtilitySubsystem.getInstance().isSign(clickedBlock)) {
                // if that sign has [Spawn]
                Sign sign = (Sign) clickedBlock.getState();
                if (sign.getLine(0).contains("[Spawn]")) {
                    // acquire coordinates
                    try {
                        int x = Integer.parseInt(sign.getLine(1));
                        int y = Integer.parseInt(sign.getLine(2));;
                        int z = Integer.parseInt(sign.getLine(3));;
                        World world = event.getPlayer().getWorld();

                        // set player's spawn
                        UtilitySubsystem.getInstance().setPlayersSpawn(event.getPlayer(), world, x, y, z);
                    } catch(Exception e) {
                        System.out.println("A problem occurred with a spawn selection sign located at [" + clickedBlock.getX() + ", " + clickedBlock.getY()  + ", " + clickedBlock.getZ() + "] in " + event.getPlayer().getWorld().getName());
                    }
                }
            }
        }
    }

}

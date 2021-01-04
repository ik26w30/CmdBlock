package org.ik26w30.blockcmd.github.block;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.server.TabCompleteEvent;

public class CmdTabBlock implements Listener {

    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent e) {
        if (e.getPlayer().hasPermission("bypass.command") || e.getPlayer().isOp()) {

        } else {
            e.getPlayer().sendMessage("Unknown command!");
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onTab(TabCompleteEvent e) {
        if (e.getSender().hasPermission("bypass.tab") || e.getSender().isOp()) {

        } else {
            e.getSender().sendMessage("Unknown command!");
            e.setCancelled(true);
        }
    }
}
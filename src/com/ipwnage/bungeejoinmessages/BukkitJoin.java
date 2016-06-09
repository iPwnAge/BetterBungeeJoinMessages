package com.ipwnage.bungeejoinmessages;

import java.util.logging.Logger;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;


public class BukkitJoin extends JavaPlugin implements Listener {
	public static final Logger log = Logger.getLogger("Minecraft");
	
    @Override
    public void onEnable() {
        this.getServer().getMessenger().registerOutgoingPluginChannel(this, "Joinmessages");
        this.getServer().getPluginManager().registerEvents(this, this);
    }
    

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
    	/* Can't fire a PluginMessage right after a player joins, there needs to be a delay. 
    	So schedule a response to Bungee for 20 ticks after join. */
    	BukkitTask task = new NotifyBungee(this, e.getPlayer().getName()).runTaskLater(this, 20);
    	e.setJoinMessage(null);
    }
}

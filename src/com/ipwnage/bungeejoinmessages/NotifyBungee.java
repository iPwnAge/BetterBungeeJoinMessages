package com.ipwnage.bungeejoinmessages;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import com.google.common.collect.Iterables;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;

public class NotifyBungee extends BukkitRunnable {

    private final JavaPlugin _plugin;
    private final String _name;

    public NotifyBungee(JavaPlugin plugin, String name) {
        this._plugin = plugin;
        this._name = name;
    }

    @Override
    public void run() {
    	ByteArrayDataOutput out = ByteStreams.newDataOutput();
        out.writeUTF(this._name);
        Player player = Iterables.getFirst(Bukkit.getOnlinePlayers(), null);
        player.sendPluginMessage(this._plugin, "Joinmessages", out.toByteArray());
    }

}
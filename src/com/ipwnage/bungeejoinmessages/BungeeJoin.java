package com.ipwnage.bungeejoinmessages;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jline.internal.Log;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.connection.Server;
import net.md_5.bungee.api.event.PluginMessageEvent;
import net.md_5.bungee.api.event.PostLoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.event.EventHandler;

public class BungeeJoin extends Plugin implements Listener {
	List<String> _playerDB = new ArrayList<String>();
	
    @Override
    public void onEnable() {
    	this.getProxy().registerChannel("Joinmessages");
    	this.getProxy().getPluginManager().registerListener(this, this);
    }
    
    @EventHandler
    public void onPostLogin(PostLoginEvent event) {
           _playerDB.add(event.getPlayer().getName());
}
    
    @EventHandler
    public void onPluginMessage(PluginMessageEvent event) throws IOException {
        if (!event.getTag().equals("Joinmessages")) {
            return;
        }
        if (!(event.getSender() instanceof Server)) {
            return;
        }
        ByteArrayInputStream stream = new ByteArrayInputStream(event.getData());
        DataInputStream in = new DataInputStream(stream);
        String name = in.readUTF();
        if(_playerDB.remove(name)) {
        	 for (ProxiedPlayer player : ProxyServer.getInstance().getPlayers()) {
                 player.sendMessage(new TextComponent(ChatColor.YELLOW + name + " joined the network."));
             }
        }
    }
    
}

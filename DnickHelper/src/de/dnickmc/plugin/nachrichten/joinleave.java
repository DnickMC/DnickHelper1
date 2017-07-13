package de.dnickmc.plugin.nachrichten;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class joinleave extends JavaPlugin implements Listener{
	@EventHandler
	public void onjoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		if(p.isOp()) {
		} else {
			e.setJoinMessage("§2>>> §2" +p.getName()+ "");
		}
		
	}
	@EventHandler
	public void onleave(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		if(p.isOp()) {
			e.setQuitMessage("§4<<< §4" +p.getName()+ "");
		} else {
			e.setQuitMessage("§4<<< §2" +p.getName()+ "");
		}
		
	}
}


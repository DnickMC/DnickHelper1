package de.dnickmc.plugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * @author DnickMC
 *
 */
public class sonne implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if(command.getName().equalsIgnoreCase("weather")) {
			if(sender instanceof Player) {
				Player p = (Player)sender;
				if(p.hasPermission("dnick.time")) {
					if(args.length == 0) {
						
						p.getWorld().setWeatherDuration(1);
						Bukkit.broadcastMessage("§3[DnickHelper] §4" +p.getName()+ "§2 beschwört das Wetter!");
						p.sendMessage("§2Wetter wird beschworen!");
						
						}
						
					} else {
						p.sendMessage("§4Nutze bitte nur §5/sonne§4!");
					}
				} else {
					Player p = (Player)sender;
					p.sendMessage("§4Du hast keine Rechte! Wenn das ein Fehler ist, wende dich an die Server Leitung!");
				}
			}
		return false;
	}

	
	
}
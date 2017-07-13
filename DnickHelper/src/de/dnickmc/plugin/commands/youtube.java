package de.dnickmc.plugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * @author DnickMC
 *
 */
public class youtube implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if(command.getName().equalsIgnoreCase("yt")) {
			if(sender instanceof Player) {
				Player p = (Player)sender;
				if(p.hasPermission("dnick.player")) {
					if(args.length == 0) {

						p.sendMessage("§3[DnickHelper] §4Mein Youtube Kanal:§2 https//youtube.com/dnickmc!");
						p.sendMessage("§2News, Updates, Tutorials, Gaming und mehr: §4GamingCenter!");
						return true;
						
					} else {
							p.sendMessage("§3[DnickHelper] §4Nutze bitte nur §5/youtube§4!");
							return true;
					}
				} else {
					p.sendMessage("§3[DnickHelper] §4Du hast keine Rechte! Wenn das ein Fehler ist, wende dich an die Server Leitung!");
					return true;
				}
			}
		}
		return false;

	
	
	}
}
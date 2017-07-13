package de.dnickmc.plugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * @author DnickMC
 *
 */
public class info implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if(command.getName().equalsIgnoreCase("info")) {
			if(sender instanceof Player) {
				Player p = (Player)sender;
				if(p.hasPermission("dnick.player")) {
					if(args.length == 0) {

						p.sendMessage("§4~~~~~§3DnickHelper§4 Info/Hilfe~~~~~");
						p.sendMessage("Dies ist die Hilfe für Spieler! Alle: §4/info all");
						p.sendMessage("/info -> Zeigt diese Info!");
						p.sendMessage("/teamspeak -> Zeigt die Teamspeak IP an!");
						p.sendMessage("/Youtube -> Zeigt den YouTube Kanal, des Plugin Schreiber an!");
						p.sendMessage("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
						
						return true;
						
						}
						
					} else {
						p.sendMessage("§3[DnickHelper] §4Nutze bitte nur §5/heal [Spieler]§4!");
					}
				} else {
					Player p =(Player)sender;
					p.sendMessage("§3[DnickHelper] §4Du hast keine Rechte! Wenn das ein Fehler ist, wende dich an die Server Leitung!");
				}
			}
		return false;
	}

	
	
}
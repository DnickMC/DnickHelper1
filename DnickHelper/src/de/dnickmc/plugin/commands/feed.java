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
public class feed implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if(command.getName().equalsIgnoreCase("feed")) {
			if(sender instanceof Player) {
				Player p = (Player)sender;
				if(p.hasPermission("dnick.heal")) {
					if(args.length == 0) {
						
						p.setFoodLevel(30);;
						p.sendMessage("§3[DnickHelper] §2Erfolgreich gefüttert!");
						return true;
					} else if (args.length == 1) {

						@SuppressWarnings("deprecation")
						Player target = Bukkit.getPlayer(args[0]);
						if(target != null) {
							
							target.setFoodLevel(20);
							target.sendMessage("§3[DnickHelper] §2Du wurdest vom Spieler §4" +p.getName() + "§2 gefüttert!");
							p.sendMessage("§3[DnickHelper] §2Der Spieler §4" +target.getName()+ "§2 wurde gefüttert!");
							System.out.println("§3[DnickHelper] §4" +p.getName()+ "§2 hat §4"+target.getName()+ " §2gefüttert!");
							return true;
							
						} else {
							p.sendMessage("§3[DnickHelper] §4 Der Spieler §2" + args[0] + "§4 ist nicht auf dem Server!");
						}
					} else {
						p.sendMessage("§3[DnickHelper] §4Nutze bitte nur §5/feed [Spieler]§4!");
					}
				} 
				}else {
					Player p = (Player)sender;
					p.sendMessage("§3[DnickHelper] §4Du hast keine Rechte! Wenn das ein Fehler ist, wende dich an die Server Leitung!");
			}
		}
		return false;
	}

	
	
}
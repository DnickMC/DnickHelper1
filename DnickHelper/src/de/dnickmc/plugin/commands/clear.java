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
public class clear implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if(command.getName().equalsIgnoreCase("clear")) {
			if(sender instanceof Player) {
				Player p = (Player)sender;
				if(p.hasPermission("dnick.clear")) {
					if(args.length == 0) {
						
						p.getInventory().clear();
						p.sendMessage("§3[DnickHelper] §2Inventar geleert!");
						return true;
						
					} else if (args.length == 1) {

						@SuppressWarnings("deprecation")
						Player target = Bukkit.getPlayer(args[0]);
						if(target != null) {
							
							target.getInventory().clear();
							target.sendMessage("§3[DnickHelper] §2Dein Inventar wurde vom Spieler §4" +p.getName() + "§2 geleert!");
							p.sendMessage("§3[DnickHelper] §2Der Spieler §4" +target.getName()+ "§2 hat nun ein leeres Inventar!");
							System.out.println("§3[DnickHelper] §4" +p.getName()+ "§2 hat §4"+target.getName()+ " §2geheilt!");
							return true;
						} else {
							p.sendMessage("§3[DnickHelper] §4 Der Spieler §2" + args[0] + "§4 ist nicht auf dem Server!");
						}
						
					} else {
						p.sendMessage("§3[DnickHelper] §4Nutze bitte nur §5/clear [Spieler]§4!");
					}
				} 
				}else {
					Player p = (Player)sender;
					p.sendMessage("§3[DnickHelper] §4Du hast keine Rechte! Wenn das ein Fehler ist, wende dich an die Server Leitung!");
			}
		} else {
			Bukkit.broadcastMessage("§3[DnickHelper] §4Bitte nutze den Befehl nur, wenn du ein Spieler bist!");
		}
		return false;
	}

	
	
}
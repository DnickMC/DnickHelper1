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
public class Heal implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if(command.getName().equalsIgnoreCase("heal")) {
			if(sender instanceof Player) {
				Player p = (Player)sender;
				if(p.hasPermission("dnick.heal")) {
					if(args.length == 0) {
						
						p.setHealth(20);
						p.setFoodLevel(20);
						System.out.println("§3[DnickHelper] §4" +p.getName()+ "§2 hat sich selbst geheilt!");
						p.sendMessage("§3[DnickHelper] §2Du wurdest geheilt!");
						return true;
						
					} else if (args.length == 1) {

						@SuppressWarnings("deprecation")
						Player target = Bukkit.getPlayer(args[0]);
						if(target != null) {
							
							target.setHealth(20);
							target.setFoodLevel(20);
							target.sendMessage("§3[DnickHelper] §2Du wurdest vom Spieler §4" +p.getName() + "§2 geheilt!");
							p.sendMessage("§3[DnickHelper] §2Der Spieler §4" +target.getName()+ "§2 wurde geheilt!");
							System.out.println("§3[DnickHelper] §4" +p.getName()+ "§2 hat §4"+target.getName()+ " §2geheilt!");
							return true;
							
						} else {
							p.sendMessage("§3[DnickHelper] §4 Der Spieler §2" + args[0] + "§4 ist nicht auf dem Server!");
						}
						
					} else {
						p.sendMessage("§3[DnickHelper] §4Nutze bitte nur §5/heal [Spieler]§4!");
					}
				} else {
					p.sendMessage("§3[DnickHelper] §4Du hast keine Rechte! Wenn das ein Fehler ist, wende dich an die Server Leitung!");
				}
			}
		}
		return false;
	}

	
	
}
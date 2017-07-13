package de.dnickmc.plugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * @author DnickMC
 *
 */
public class gm3 implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if(command.getName().equalsIgnoreCase("3")) {
			if(sender instanceof Player) {
				Player p = (Player)sender;
				if(p.hasPermission("dnick.vanish")) {
					if(args.length == 0) {
						
						p.setGameMode(GameMode.SPECTATOR);
						System.out.println("§3[DnickHelper] §4" +p.getName()+ "§2 ist im §9Spectatormode!");
						p.sendMessage("§3[DnickHelper] §2Neuer Gamemode: §9Spectatormode!");
						return true;
						
					} else if (args.length == 1) {
						
						@SuppressWarnings("deprecation")
						Player target = Bukkit.getPlayer(args[0]);
						if(target != null) {
							
						target.setGameMode(GameMode.SPECTATOR);
						System.out.println("§3[DnickHelper] §4" +p.getName()+ "§2 ist im §9Spectatermodus!");
						target.sendMessage("§3[DnickHelper] §2Neuer Gamemode: §9Spectatermodus!");
						p.sendMessage("§3[DnickHelper] §2Neuer Gamemode: §9Spectatermodus!");
						return true;
						} else {
							p.sendMessage("§3[DnickHelper] §4 Der Spieler §2" + args[0] + "§4 ist nicht auf dem Server!");
						}
					} else {
						p.sendMessage("§3[DnickHelper] §4Nutze bitte nur §5/3 [Spieler]§4!");
					}
				} else {
					p.sendMessage("§3[DnickHelper] §4Du hast keine Rechte! Wenn das ein Fehler ist, wende dich an die Server Leitung!");
				}
			}
		return false;
	}
		return false;

	}
	
}
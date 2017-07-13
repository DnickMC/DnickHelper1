package de.dnickmc.plugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Day implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if(command.getName().equalsIgnoreCase("day")) {
			if(sender instanceof Player) {
				Player p = (Player)sender;
				if(p.hasPermission("dnick.time")) {
					if(args.length == 0) {
						
						p.getWorld().setTime(0);
						p.sendMessage("§2Es ist jetzt wieder Tag!");
						Bukkit.broadcastMessage("§3[DnickHelper] §4" +p.getName()+ " §2schuff den Tag neu!");
						System.out.println("§3[DnickHelper] §4" +p.getName()+ " §2schuff den Tag neu!");
						return true;
						
					} else {
						p.sendMessage("§4Nutze bitte nur §5/day §4, um Tag zu machen!");
					}
				
				} else {
					System.out.println("§5[DnickHelper] §4" +p.getName()+ " §4versuchte §1/day §4 auszuführen!");
					p.sendMessage("§4Du hast keine Rechte für diesen Command! Wenn das ein Fehler ist, wende dich an die Server Leitung!");
					for(Player all : Bukkit.getOnlinePlayers()){
					    if(all.isOp()){
					       all.sendMessage("§3[DnickHelper]§4 " +p.getName()+ "§4 versucht §1/day §4auszuführen. Erledige es für ihn, achte, ober er andere Commands nutzt oder gebe ihn die Rechte.");
					    }
					}
				}
			}
		
		
		}
		return false;

	
	
	}
}
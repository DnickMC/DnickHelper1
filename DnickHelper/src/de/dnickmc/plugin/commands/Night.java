package de.dnickmc.plugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Night implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if(command.getName().equalsIgnoreCase("night")) {
			if(sender instanceof Player) {
				Player p = (Player)sender;
				if(p.hasPermission("dnick.time")) {
					if(args.length == 0) {
						
						p.getWorld().setTime(13000);
						p.sendMessage("�2Es ist wird Nacht.");
						System.out.println("�3[DnickHelper] �4" +p.getName()+ " �2l�sst den Tag zuende gehen!");
						Bukkit.broadcastMessage("�3[DnickHelper] �4" +p.getName()+ " �2hat es Nacht werden lassen!");
						return true;
						
					} else {
						p.sendMessage("�3[DnickHelper] �4Dieser Befehl ist zu lang! Nutze bitte nur �5/night �4, um Nacht zu machen!");
					}
				
				} else {
					System.out.println("�3[DnickHelper] �4" +p.getName()+ " �4versuchte �1/night �4 auszuf�hren!");
					p.sendMessage("�4Du hast keine Rechte f�r diesen Command! Wenn das ein Fehler ist, wende dich an die Server Leitung!");
					for(Player all : Bukkit.getOnlinePlayers()){
					    if(all.isOp()){
					       all.sendMessage("�3[DnickHelper]�4 " +p.getName()+ "�4 versucht �1/night �4auszuf�hren. Erledige es f�r ihn, achte, ober er andere Commands nutzt oder gebe ihn die Rechte.");
					    }
					}
				}
			}
		}
		return false;
	}
}
package de.dnickmc.plugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * @author DnickMC
 *
 */
public class fly implements CommandExecutor {

	private boolean flymode = false;
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(command.getName().equalsIgnoreCase("fly")){
			Player p = (Player)sender;
			if(p.hasPermission("dnick.fly")){
				if(flymode == false){
					p.setAllowFlight(true);
					flymode = true;
					p.sendMessage("§3[DnickHelper] §2Du kannst nun fliegen!");
				} else{
					p.setAllowFlight(false);
					flymode = false;
					p.sendMessage("§3[DnickHelper] §4Du kannst nun nicht mehr fliegen!");
				}
			}
		}
		return false;
	}


	
	
}
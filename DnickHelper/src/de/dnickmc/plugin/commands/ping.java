package de.dnickmc.plugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

import net.minecraft.server.v1_8_R1.EntityPlayer;

/**
 * @author DnickMC
 *
 */
public class ping implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if(command.getName().equalsIgnoreCase("ping")) {
			if(sender instanceof Player) {
				Player p = (Player)sender;
				if(p.hasPermission("dnick.player")) {
					if(args.length == 0) {
						
						p.sendMessage("§3[DnickHelper] §2Dein Ping ist: §4" +getPing(p));
						return true;
						
						
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
	public double getPing(Player p){
		CraftPlayer pingc = (CraftPlayer) p;
		EntityPlayer pinge = pingc.getHandle();
		return pinge.ping;
		
	}
}
	
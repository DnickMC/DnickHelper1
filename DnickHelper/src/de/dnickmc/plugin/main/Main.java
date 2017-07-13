package de.dnickmc.plugin.main;

import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import de.dnickmc.plugin.commands.Heal;
import de.dnickmc.plugin.commands.Day;
import de.dnickmc.plugin.commands.Night;
import de.dnickmc.plugin.commands.clear;
import de.dnickmc.plugin.commands.feed;
import de.dnickmc.plugin.commands.gm0;
import de.dnickmc.plugin.commands.gm1;
import de.dnickmc.plugin.commands.gm2;
import de.dnickmc.plugin.commands.gm3;
import de.dnickmc.plugin.commands.info;
import de.dnickmc.plugin.commands.youtube;
import de.dnickmc.plugin.nachrichten.joinleave;


public class Main extends JavaPlugin implements Listener{
	
	private ConsoleCommandSender console = getServer().getConsoleSender();
	
	@Override
	public void onEnable() {
		this.getCommand("heal").setExecutor(new Heal());
		this.getCommand("feed").setExecutor(new feed());
		this.getCommand("Day").setExecutor(new Day());
		this.getCommand("Night").setExecutor(new Night());
		this.getCommand("clear").setExecutor(new clear());
		this.getCommand("0").setExecutor(new gm0());
		this.getCommand("1").setExecutor(new gm1());
		this.getCommand("2").setExecutor(new gm2());
		this.getCommand("3").setExecutor(new gm3());
		this.getCommand("info").setExecutor(new info());
		this.getCommand("youtube").setExecutor(new youtube());
		this.getServer().getPluginManager().registerEvents(new joinleave(), this);
		
		console.sendMessage("[DnickHelper] Das Plugin wurde erfolgreich gestartet!");
		console.sendMessage("[DnickHelper] Version: 0.4 Beta");
	}
	
	public void onDisable() {
		console.sendMessage("[DnickHelper] Das Plugin wurde erfolgreich deaktiviert!");
	}
	
}
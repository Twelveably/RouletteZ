package io.github.bagasthebird.roulettez;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import com.earth2me.essentials.api.Economy;
import com.earth2me.essentials.api.NoLoanPermittedException;
import com.earth2me.essentials.api.UserDoesNotExistException;

import io.github.bagasthebird.roulettez.commands.RouletteCommand;
import io.github.bagasthebird.roulettez.listeners.InventoryInteract;

public class Roulette extends JavaPlugin {

	public static Roulette instance;

	private File files;

	@Override
	public void onEnable() {

		instance = this;
		saveResource("config.yml", false);
		this.files = new File(getDataFolder(), "config.yml");
		YamlConfiguration.loadConfiguration(this.files);

		Bukkit.getServer().getPluginManager().registerEvents(new InventoryInteract(), this);

		this.getCommand("roulette").setExecutor(new RouletteCommand());

	}

	@SuppressWarnings("deprecation")
	@Override
	public void onDisable() {

		for (String name : InventoryInteract.players.keySet()) {
			try {
				
				if (!InventoryInteract.lost.contains(name)) {
					Economy.add(name, InventoryInteract.players.get(name));
				} else {
					return;
				}
				
			} catch (NoLoanPermittedException | UserDoesNotExistException e) {
				e.printStackTrace();
			}
			InventoryInteract.players.remove(name);
		}

		instance = null;
	}

	public String getConfigString(String arg) {
		return getConfig().getString(arg);
	}

	public Integer getConfigInt(String arg) {
		return getConfig().getInt(arg);
	}

	public boolean getConfigBoolean(String arg) {
		return getConfig().getBoolean(arg);
	}

}

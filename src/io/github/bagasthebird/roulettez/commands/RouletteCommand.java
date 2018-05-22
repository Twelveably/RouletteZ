package io.github.bagasthebird.roulettez.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import com.earth2me.essentials.api.UserDoesNotExistException;

import io.github.bagasthebird.roulettez.Roulette;
import io.github.bagasthebird.roulettez.utils.HiddenStringUtils;
import io.github.bagasthebird.roulettez.utils.RouletteAPI;

public class RouletteCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (sender instanceof Player) {

			Player player = (Player) sender;
			
			try {
				player.openInventory(RouletteAPI.createInventory(player));
			} catch (UserDoesNotExistException e) {
				e.printStackTrace();
			}
		}
		return true;
	}
}

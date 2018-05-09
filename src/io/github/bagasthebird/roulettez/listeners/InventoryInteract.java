package io.github.bagasthebird.roulettez.listeners;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import com.earth2me.essentials.api.Economy;
import com.earth2me.essentials.api.NoLoanPermittedException;
import com.earth2me.essentials.api.UserDoesNotExistException;

import io.github.bagasthebird.roulettez.Roulette;
import io.github.bagasthebird.roulettez.utils.RouletteAPI;

public class InventoryInteract implements Listener {

	@EventHandler
	public void OnInventoryClick(InventoryClickEvent event) throws NoLoanPermittedException, UserDoesNotExistException {

		Player player = (Player) event.getWhoClicked();
		Inventory inventory = event.getInventory();
		ItemStack clicked = event.getCurrentItem();

		ItemStack bet1 = RouletteAPI.createItem(new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 1),
				ChatColor.translateAlternateColorCodes('&', Roulette.instance.getConfigString("Option1Info")),
				new String[] {});

		ItemStack bet2 = RouletteAPI.createItem(new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 1),
				ChatColor.translateAlternateColorCodes('&', Roulette.instance.getConfigString("Option2Info")),
				new String[] {});

		ItemStack bet3 = RouletteAPI.createItem(new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 1),
				ChatColor.translateAlternateColorCodes('&', Roulette.instance.getConfigString("Option3Info")),
				new String[] {});

		ItemStack bet4 = RouletteAPI.createItem(new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 1),
				ChatColor.translateAlternateColorCodes('&', Roulette.instance.getConfigString("Option4Info")),
				new String[] {});

		ItemStack notenough = RouletteAPI.createItem(new ItemStack(Material.BARRIER),
				ChatColor.translateAlternateColorCodes('&', Roulette.instance.getConfigString("OptionNotEnough")),
				new String[] {});

		if (inventory.getName().equals(ChatColor.translateAlternateColorCodes('&', RouletteAPI.encode(player)))) {

			// Cancels click
			event.setCancelled(true);

			if (clicked.getItemMeta().getDisplayName().equals(
					ChatColor.translateAlternateColorCodes('&', Roulette.instance.getConfigString("Option1Info")))) {
				if (!RouletteAPI.players.containsKey(player.getName())) {
					RouletteAPI.players.put(player.getName(), 0.0 + Roulette.instance.getConfigInt("Option1"));
				} else {
					RouletteAPI.players.put(player.getName(),
							RouletteAPI.players.get(player.getName()) + Roulette.instance.getConfigInt("Option1"));
				}
				Economy.subtract(player.getName(), Roulette.instance.getConfigInt("Option1") + 0.0);
			}

			if (clicked.getItemMeta().getDisplayName().equals(
					ChatColor.translateAlternateColorCodes('&', Roulette.instance.getConfigString("Option2Info")))) {
				if (!RouletteAPI.players.containsKey(player.getName())) {
					RouletteAPI.players.put(player.getName(), 0.0 + Roulette.instance.getConfigInt("Option2"));
				} else {
					RouletteAPI.players.put(player.getName(),
							RouletteAPI.players.get(player.getName()) + Roulette.instance.getConfigInt("Option2"));
				}
				Economy.subtract(player.getName(), Roulette.instance.getConfigInt("Option2") + 0.0);
			}

			if (clicked.getItemMeta().getDisplayName().equals(
					ChatColor.translateAlternateColorCodes('&', Roulette.instance.getConfigString("Option3Info")))) {
				if (!RouletteAPI.players.containsKey(player.getName())) {
					RouletteAPI.players.put(player.getName(), 0.0 + Roulette.instance.getConfigInt("Option3"));
				} else {
					RouletteAPI.players.put(player.getName(),
							RouletteAPI.players.get(player.getName()) + Roulette.instance.getConfigInt("Option3"));
				}
				Economy.subtract(player.getName(), Roulette.instance.getConfigInt("Option3") + 0.0);
			}

			if (clicked.getItemMeta().getDisplayName().equals(
					ChatColor.translateAlternateColorCodes('&', Roulette.instance.getConfigString("Option4Info")))) {
				if (!RouletteAPI.players.containsKey(player.getName())) {
					RouletteAPI.players.put(player.getName(), 0.0 + Roulette.instance.getConfigInt("Option4"));
				} else {
					RouletteAPI.players.put(player.getName(),
							RouletteAPI.players.get(player.getName()) + Roulette.instance.getConfigInt("Option4"));
				}
				Economy.subtract(player.getName(), Roulette.instance.getConfigInt("Option4") + 0.0);
			}

			if (Economy.getMoney(player.getName()) >= Roulette.instance.getConfigInt("Option1")) {
				inventory.setItem(28, bet1);
			} else {
				inventory.setItem(28, notenough);
			}

			if (Economy.getMoney(player.getName()) >= Roulette.instance.getConfigInt("Option2")) {
				inventory.setItem(29, bet2);
			} else {
				inventory.setItem(29, notenough);
			}

			if (Economy.getMoney(player.getName()) >= Roulette.instance.getConfigInt("Option3")) {
				inventory.setItem(30, bet3);
			} else {
				inventory.setItem(30, notenough);
			}

			if (Economy.getMoney(player.getName()) >= Roulette.instance.getConfigInt("Option4")) {
				inventory.setItem(31, bet4);
			} else {
				inventory.setItem(31, notenough);
			}
		}
	}

	@EventHandler
	public void OnInventoryClose(InventoryCloseEvent event) throws NoLoanPermittedException, UserDoesNotExistException {

		Player player = (Player) event.getPlayer();
		Inventory inventory = event.getInventory();

		if (inventory.getName().equals(ChatColor.translateAlternateColorCodes('&', RouletteAPI.encode(player)))) {
			/*
			 * Roulette.instance.getServer().getScheduler().
			 * scheduleSyncDelayedTask(Roulette.instance, new Runnable() {
			 * public void run() {
			 * 
			 * } }, 1L);
			 */
			if (RouletteAPI.players.containsKey(player.getName())) {
				Economy.setMoney(player.getName(),
						Economy.getMoney(player.getName()) + RouletteAPI.players.get(player.getName()));
				RouletteAPI.players.remove(player.getName());
			}
		}
	}
}

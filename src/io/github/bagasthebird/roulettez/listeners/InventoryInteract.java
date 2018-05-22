package io.github.bagasthebird.roulettez.listeners;

import java.util.HashMap;
import java.util.HashSet;
import java.util.UUID;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import com.earth2me.essentials.api.Economy;
import com.earth2me.essentials.api.NoLoanPermittedException;
import com.earth2me.essentials.api.UserDoesNotExistException;

import io.github.bagasthebird.roulettez.Roulette;
import io.github.bagasthebird.roulettez.utils.RouletteAPI;

public class InventoryInteract implements Listener {

	public static HashMap<String, Double> players = new HashMap<String, Double>();
	public static HashMap<String, Integer> playerReg = new HashMap<String, Integer>();

	public static HashSet<String> lock = new HashSet<String>();
	public static HashSet<String> lost = new HashSet<String>();

	ItemStack hoppermoving = RouletteAPI.createItem(new ItemStack(Material.HOPPER),
			ChatColor.translateAlternateColorCodes('&', Roulette.instance.getConfigString("InfoStatus")),
			new String[] { "",
					ChatColor.translateAlternateColorCodes('&', Roulette.instance.getConfigString("InfoSpinning")) });

	ItemStack makebet = RouletteAPI.createItem(new ItemStack(Material.HOPPER),
			ChatColor.translateAlternateColorCodes('&', Roulette.instance.getConfigString("InfoStatus")), new String[] {
					"", ChatColor.translateAlternateColorCodes('&', Roulette.instance.getConfigString("InfoAlert")) });

	ItemStack hopperstart = RouletteAPI.createItem(new ItemStack(Material.HOPPER),
			ChatColor.translateAlternateColorCodes('&', Roulette.instance.getConfigString("InfoStatus")),
			new String[] { "",
					ChatColor.translateAlternateColorCodes('&', Roulette.instance.getConfigString("InfoMakeBet")) });

	ItemStack white = RouletteAPI.createItem(new ItemStack(Material.STAINED_GLASS_PANE), ChatColor.BOLD + "",
			new String[] {});

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

	@SuppressWarnings("deprecation")
	@EventHandler
	public void OnInventoryClick(InventoryClickEvent event) throws NoLoanPermittedException, UserDoesNotExistException {

		Player player = (Player) event.getWhoClicked();
		UUID uuid = player.getUniqueId();
		Inventory inventory = event.getInventory();
		ItemStack clicked = event.getCurrentItem();

		if (inventory.getName().equals(ChatColor.translateAlternateColorCodes('&', RouletteAPI.encode(player)))) {

			// Cancels click
			event.setCancelled(true);

			if (clicked != null && clicked.getType() != Material.AIR) {

				if (!clicked.hasItemMeta()) {
					return;
				}

				if (clicked.getItemMeta().getDisplayName().equals(bet1.getItemMeta().getDisplayName())) {

					if (Economy.getMoney(player.getName()) >= Roulette.instance.getConfigInt("Option1")) {

						inventory.setItem(28, bet1);
						Economy.subtract(player.getName(), Roulette.instance.getConfigInt("Option1") + 0.0);

						if (!players.containsKey(player.getName())) {

							inventory.setItem(4, hopperstart);
							players.put(player.getName(), 0.0 + Roulette.instance.getConfigInt("Option1"));

							if (Economy.getMoney(player.getName()) >= Roulette.instance.getConfigInt("Option1")) {
								inventory.setItem(28, bet1);
							} else {
								inventory.setItem(28, notenough);
							}

						} else {

							players.put(player.getName(),
									players.get(player.getName()) + Roulette.instance.getConfigInt("Option1"));

							if (Economy.getMoney(player.getName()) >= Roulette.instance.getConfigInt("Option1")) {
								inventory.setItem(28, bet1);
							} else {
								inventory.setItem(28, notenough);
							}

						}
					} else {
						inventory.setItem(28, notenough);
					}
				}

				if (clicked.getItemMeta().getDisplayName().equals(bet2.getItemMeta().getDisplayName())) {
					if (Economy.getMoney(player.getName()) >= Roulette.instance.getConfigInt("Option2")) {

						inventory.setItem(29, bet2);
						Economy.subtract(player.getName(), Roulette.instance.getConfigInt("Option2") + 0.0);

						if (!players.containsKey(player.getName())) {

							inventory.setItem(4, hopperstart);
							players.put(player.getName(), 0.0 + Roulette.instance.getConfigInt("Option2"));

							if (Economy.getMoney(player.getName()) >= Roulette.instance.getConfigInt("Option2")) {
								inventory.setItem(29, bet2);
							} else {
								inventory.setItem(29, notenough);
							}

						} else {

							players.put(player.getName(),
									players.get(player.getName()) + Roulette.instance.getConfigInt("Option2"));

							if (Economy.getMoney(player.getName()) >= Roulette.instance.getConfigInt("Option2")) {
								inventory.setItem(29, bet2);
							} else {
								inventory.setItem(29, notenough);
							}

						}
					} else {
						inventory.setItem(29, notenough);
					}
				}

				if (clicked.getItemMeta().getDisplayName().equals(bet3.getItemMeta().getDisplayName())) {

					if (Economy.getMoney(player.getName()) >= Roulette.instance.getConfigInt("Option3")) {

						inventory.setItem(30, bet3);
						Economy.subtract(player.getName(), Roulette.instance.getConfigInt("Option3") + 0.0);

						if (!players.containsKey(player.getName())) {

							inventory.setItem(4, hopperstart);
							players.put(player.getName(), 0.0 + Roulette.instance.getConfigInt("Option3"));

							if (Economy.getMoney(player.getName()) >= Roulette.instance.getConfigInt("Option3")) {
								inventory.setItem(30, bet3);
							} else {
								inventory.setItem(30, notenough);
							}

						} else {

							players.put(player.getName(),
									players.get(player.getName()) + Roulette.instance.getConfigInt("Option3"));

							if (Economy.getMoney(player.getName()) >= Roulette.instance.getConfigInt("Option3")) {
								inventory.setItem(30, bet3);
							} else {
								inventory.setItem(30, notenough);
							}

						}
					} else {
						inventory.setItem(30, notenough);
					}
				}

				if (clicked.getItemMeta().getDisplayName().equals(bet4.getItemMeta().getDisplayName())) {

					if (Economy.getMoney(player.getName()) >= Roulette.instance.getConfigInt("Option4")) {

						inventory.setItem(31, bet4);
						Economy.subtract(player.getName(), Roulette.instance.getConfigInt("Option4") + 0.0);

						if (!players.containsKey(player.getName())) {

							inventory.setItem(4, hopperstart);
							players.put(player.getName(), 0.0 + Roulette.instance.getConfigInt("Option4"));

							if (Economy.getMoney(player.getName()) >= Roulette.instance.getConfigInt("Option4")) {
								inventory.setItem(31, bet4);
							} else {
								inventory.setItem(31, notenough);
							}

						} else {

							players.put(player.getName(),
									players.get(player.getName()) + Roulette.instance.getConfigInt("Option4"));

							if (Economy.getMoney(player.getName()) >= Roulette.instance.getConfigInt("Option4")) {
								inventory.setItem(31, bet4);
							} else {
								inventory.setItem(31, notenough);
							}

						}
					} else {
						inventory.setItem(31, notenough);
					}
				}

				if (clicked.getItemMeta().getDisplayName().equals(ChatColor.translateAlternateColorCodes('&',
						Roulette.instance.getConfigString("InfoPushBet")))) {

					if (event.getClick() == ClickType.RIGHT) {
						playerReg.put(player.getName(), 14);
					} else if (event.getClick() == ClickType.MIDDLE) {
						playerReg.put(player.getName(), 5);
					} else if (event.getClick() == ClickType.LEFT) {
						playerReg.put(player.getName(), 15);
					}

					ItemStack black26 = RouletteAPI.createItem(new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 15),
							ChatColor.translateAlternateColorCodes('&', "&8&l26"), new String[] {});

					ItemStack red3 = RouletteAPI.createItem(new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 14),
							ChatColor.translateAlternateColorCodes('&', "&c&l3"), new String[] {});

					ItemStack black35 = RouletteAPI.createItem(new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 15),
							ChatColor.translateAlternateColorCodes('&', "&8&l35"), new String[] {});

					ItemStack red12 = RouletteAPI.createItem(new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 14),
							ChatColor.translateAlternateColorCodes('&', "&c&l12"), new String[] {});

					ItemStack green = RouletteAPI.createItem(new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 5),
							ChatColor.translateAlternateColorCodes('&', "&a&l0"), new String[] {});

					ItemStack red32 = RouletteAPI.createItem(new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 14),
							ChatColor.translateAlternateColorCodes('&', "&c&l32"), new String[] {});

					ItemStack black15 = RouletteAPI.createItem(new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 15),
							ChatColor.translateAlternateColorCodes('&', "&8&l15"), new String[] {});

					ItemStack red19 = RouletteAPI.createItem(new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 14),
							ChatColor.translateAlternateColorCodes('&', "&c&l19"), new String[] {});

					ItemStack black4 = RouletteAPI.createItem(new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 15),
							ChatColor.translateAlternateColorCodes('&', "&8&l4"), new String[] {});

					ItemStack[] items = new ItemStack[9];
					{
						items[0] = black35;
						items[1] = red3;
						items[2] = black26;
						items[3] = green;
						items[4] = red32;
						items[5] = black15;
						items[6] = red19;
						items[7] = black4;
						items[8] = red12;
					}

					if (!players.containsKey(player.getName())) {
						return;
					} else {

						inventory.setItem(4, hoppermoving);
						inventory.setItem(34, white);
						inventory.setItem(31, white);
						inventory.setItem(30, white);
						inventory.setItem(29, white);
						inventory.setItem(28, white);

						lock.add(player.getName());

						if (lock.contains(player.getName())) {
							RouletteAPI.spinPlayer(player, inventory, items);
						}
					}
				}
			} else {
				return;
			}
		}

	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void OnInventoryClose(InventoryCloseEvent event) throws NoLoanPermittedException, UserDoesNotExistException {

		Player player = (Player) event.getPlayer();
		Inventory inventory = event.getInventory();

		if (inventory.getName().equals(ChatColor.translateAlternateColorCodes('&', RouletteAPI.encode(player)))) {
			if (lock.contains(player.getName())) {

				BukkitRunnable inventoryHold = new BukkitRunnable() {
					public void run() {
						player.openInventory(inventory);
					}
				};

				inventoryHold.runTaskLater(Roulette.instance, 1L);

			} else {
				if (players.containsKey(player.getName())) {
					if (!lost.contains(player)) {
						Economy.add(player.getName(), players.get(player.getName()));
						players.remove(player.getName());
						lost.remove(player.getName());
					} else {
						players.remove(player.getName());
						lost.remove(player.getName());
					}
				}
			}
		}
	}
}

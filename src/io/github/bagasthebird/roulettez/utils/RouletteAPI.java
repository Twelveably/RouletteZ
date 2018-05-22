package io.github.bagasthebird.roulettez.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import com.earth2me.essentials.api.Economy;
import com.earth2me.essentials.api.NoLoanPermittedException;
import com.earth2me.essentials.api.UserDoesNotExistException;

import io.github.bagasthebird.roulettez.Roulette;
import io.github.bagasthebird.roulettez.listeners.InventoryInteract;

public class RouletteAPI {

	// Create item

	static ItemStack redclear = RouletteAPI.createItem(new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 14),
			ChatColor.translateAlternateColorCodes('&', "&c&lReset bet"), new String[] {});

	static ItemStack white = RouletteAPI.createItem(new ItemStack(Material.STAINED_GLASS_PANE), ChatColor.BOLD + "",
			new String[] {});

	static ItemStack black26 = RouletteAPI.createItem(new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 15),
			ChatColor.translateAlternateColorCodes('&', "&8&l26"), new String[] {});

	static ItemStack red3 = RouletteAPI.createItem(new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 14),
			ChatColor.translateAlternateColorCodes('&', "&c&l3"), new String[] {});

	static ItemStack black35 = RouletteAPI.createItem(new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 15),
			ChatColor.translateAlternateColorCodes('&', "&8&l35"), new String[] {});

	static ItemStack red12 = RouletteAPI.createItem(new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 14),
			ChatColor.translateAlternateColorCodes('&', "&c&l12"), new String[] {});

	static ItemStack green = RouletteAPI.createItem(new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 5),
			ChatColor.translateAlternateColorCodes('&', "&a&l0"), new String[] {});

	static ItemStack red32 = RouletteAPI.createItem(new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 14),
			ChatColor.translateAlternateColorCodes('&', "&c&l32"), new String[] {});

	static ItemStack black15 = RouletteAPI.createItem(new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 15),
			ChatColor.translateAlternateColorCodes('&', "&8&l15"), new String[] {});

	static ItemStack red19 = RouletteAPI.createItem(new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 14),
			ChatColor.translateAlternateColorCodes('&', "&c&l19"), new String[] {});

	static ItemStack black4 = RouletteAPI.createItem(new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 15),
			ChatColor.translateAlternateColorCodes('&', "&8&l4"), new String[] {});

	static ItemStack notenough = RouletteAPI.createItem(new ItemStack(Material.BARRIER),
			ChatColor.translateAlternateColorCodes('&', Roulette.instance.getConfigString("OptionNotEnough")),
			new String[] {});

	static ItemStack hoppermoving = RouletteAPI.createItem(new ItemStack(Material.HOPPER),
			ChatColor.translateAlternateColorCodes('&', Roulette.instance.getConfigString("InfoStatus")),
			new String[] { "",
					ChatColor.translateAlternateColorCodes('&', Roulette.instance.getConfigString("InfoMakeBet")) });

	static ItemStack makebet = RouletteAPI.createItem(new ItemStack(Material.HOPPER),
			ChatColor.translateAlternateColorCodes('&', Roulette.instance.getConfigString("InfoStatus")), new String[] {
					"", ChatColor.translateAlternateColorCodes('&', Roulette.instance.getConfigString("InfoAlert")) });

	static ItemStack hopperstart = RouletteAPI.createItem(new ItemStack(Material.HOPPER),
			ChatColor.translateAlternateColorCodes('&', Roulette.instance.getConfigString("InfoStatus")),
			new String[] { "",
					ChatColor.translateAlternateColorCodes('&', Roulette.instance.getConfigString("InfoSpinning")) });

	static ItemStack pushbet = RouletteAPI.createItem(new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 5),
			ChatColor.translateAlternateColorCodes('&', Roulette.instance.getConfigString("InfoPushBet")),
			new String[] { "",
					ChatColor.translateAlternateColorCodes('&', Roulette.instance.getConfigString("InfoPushBetDesc1")),
					ChatColor.translateAlternateColorCodes('&', Roulette.instance.getConfigString("InfoPushBetDesc2")),
					ChatColor.translateAlternateColorCodes('&',
							Roulette.instance.getConfigString("InfoPushBetDesc3")) });

	static ItemStack bet1 = createItem(new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 1),
			ChatColor.translateAlternateColorCodes('&', Roulette.instance.getConfigString("Option1Info")),
			new String[] {});

	static ItemStack bet2 = createItem(new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 1),
			ChatColor.translateAlternateColorCodes('&', Roulette.instance.getConfigString("Option2Info")),
			new String[] {});

	static ItemStack bet3 = createItem(new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 1),
			ChatColor.translateAlternateColorCodes('&', Roulette.instance.getConfigString("Option3Info")),
			new String[] {});

	static ItemStack bet4 = createItem(new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 1),
			ChatColor.translateAlternateColorCodes('&', Roulette.instance.getConfigString("Option4Info")),
			new String[] {});

	public static ItemStack createItem(ItemStack item, String name, String[] lore) {
		ItemMeta im = item.getItemMeta();
		im.setDisplayName(name);
		im.setLore(Arrays.asList(lore));
		item.setItemMeta(im);
		return item;
	}

	@SuppressWarnings("deprecation")
	public static Inventory createInventory(Player player) throws UserDoesNotExistException {

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

		Inventory rouletteGUI = Bukkit.createInventory(null, 45,
				ChatColor.translateAlternateColorCodes('&', encode(player)));

		while (rouletteGUI.firstEmpty() != -1) {
			rouletteGUI.setItem(rouletteGUI.firstEmpty(), white);
		}

		int itemIndex = 0;

		for (int itemstacks = 9; itemstacks < 18; itemstacks++)
			rouletteGUI.setItem(itemstacks, items[(itemstacks + itemIndex - 1) % items.length]);
		rouletteGUI.setItem(4, makebet);
		rouletteGUI.setItem(34, pushbet);

		if (Economy.getMoney(player.getName()) >= Roulette.instance.getConfigInt("Option1")) {
			rouletteGUI.setItem(28, bet1);
		} else {
			rouletteGUI.setItem(28, notenough);
		}

		if (Economy.getMoney(player.getName()) >= Roulette.instance.getConfigInt("Option2")) {
			rouletteGUI.setItem(29, bet2);
		} else {
			rouletteGUI.setItem(29, notenough);
		}

		if (Economy.getMoney(player.getName()) >= Roulette.instance.getConfigInt("Option3")) {
			rouletteGUI.setItem(30, bet3);
		} else {
			rouletteGUI.setItem(30, notenough);
		}

		if (Economy.getMoney(player.getName()) >= Roulette.instance.getConfigInt("Option4")) {
			rouletteGUI.setItem(31, bet4);
		} else {
			rouletteGUI.setItem(31, notenough);
		}

		return rouletteGUI;
	}

	public static String encode(Player player) {

		String encoded;
		String GUIName = Roulette.instance.getConfigString("GUIName") + " ";

		if (GUIName.length() + HiddenStringUtils.encodeString(player.getName()).length() > 31) {
			String id = GUIName + HiddenStringUtils.encodeString(player.getName());
			encoded = id.substring(0, 23);
		} else {
			encoded = GUIName + HiddenStringUtils.encodeString(player.getName());
		}

		return encoded;

	}

	@SuppressWarnings("deprecation")
	public static void playerWin(Player player, Short durability, Double money) {

		String rawMessage = Roulette.instance.getConfigString("Win");
		String message = null;
		Double multiplier = null;

		player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 100, 1);

		switch (durability) {
		case 14:

			multiplier = Roulette.instance.getConfigInt("Red") + 0.0;

			message = rawMessage.replaceAll("%money%", Double.toString(money * multiplier));
			player.sendMessage(ChatColor.translateAlternateColorCodes('&', message));

			try {
				Economy.add(player.getName(), money * multiplier);
			} catch (NoLoanPermittedException | UserDoesNotExistException e1) {
				e1.printStackTrace();
			}

			break;
		case 15:

			multiplier = Roulette.instance.getConfigInt("Black") + 0.0;

			message = rawMessage.replaceAll("%money%", Double.toString(money * multiplier));
			player.sendMessage(ChatColor.translateAlternateColorCodes('&', message));

			try {
				Economy.add(player.getName(), money * multiplier);
			} catch (NoLoanPermittedException | UserDoesNotExistException e) {
				e.printStackTrace();
			}

			break;
		case 5:

			multiplier = Roulette.instance.getConfigInt("Green") + 0.0;

			message = rawMessage.replaceAll("%money%", Double.toString(money * multiplier));
			player.sendMessage(ChatColor.translateAlternateColorCodes('&', message));

			try {
				Economy.add(player.getName(), money * multiplier);
			} catch (NoLoanPermittedException | UserDoesNotExistException e) {
				e.printStackTrace();
			}

			break;
		}

		InventoryInteract.playerReg.remove(player.getName());

	}

	public static void playerLost(Player player) {
		player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_PLACE, 100, 1);
		InventoryInteract.playerReg.remove(player.getName());
	}

	public static void spinPlayer(Player player, Inventory inventory, ItemStack[] items) {

		int itemIndex = 0;

		BukkitRunnable playerSpin = new BukkitRunnable() {

			int itemIndex = 0;
			int delay = 0;
			int playerTimer = 0;
			int playerSpinTimer = 0;
			boolean shuffled = false;

			public void run() {

				if (shuffled == false) {
					int startingIndex = ThreadLocalRandom.current().nextInt(items.length);
					for (int index = 0; index < startingIndex; index++) {
						for (int itemstacks = 9; itemstacks < 18; itemstacks++) {
							inventory.setItem(itemstacks, items[(itemstacks + itemIndex) % items.length]);
						}

						itemIndex += 1;
						shuffled = true;
					}
				} else {

					// ---------------playerAdd----------------
					delay++;

					if (delay >= 20) { // at 1 second..
						playerTimer += 1; // increment 1 to playerTimer.
						delay = 0; // and then reset back to 0.
					}

					if (playerTimer >= 20) { // if playerTimer reached 20..

						short number = inventory.getItem(13).getDurability();

						itemIndex = 0;

						if (InventoryInteract.playerReg.get(player.getName()) == number) {
							playerWin(player, number, InventoryInteract.players.get(player.getName()));
						} else {
							InventoryInteract.lost.add(player.getName());
							RouletteAPI.playerLost(player);
						}
						
						InventoryInteract.lock.remove(player.getName());
						
						this.cancel(); // we stop the runnable.
					}
					// ----------------------------------------

					// -------------------playerSpin-------------------
					playerSpinTimer++;

					if (playerSpinTimer >= playerTimer) {
						for (int itemstacks = 9; itemstacks < 18; itemstacks++)
							inventory.setItem(itemstacks, items[(itemstacks + itemIndex) % items.length]);

						player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BASEDRUM, 100, 1);

						itemIndex++;
						playerSpinTimer = 0;
					}
				}
			}
		};

		playerSpin.runTaskTimer(Roulette.instance, 1L, 1L);
	}
}

package io.github.bagasthebird.roulettez.utils;

import java.util.Arrays;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.earth2me.essentials.api.Economy;
import com.earth2me.essentials.api.UserDoesNotExistException;

import io.github.bagasthebird.roulettez.Roulette;

public class RouletteAPI {
	
    public static HashMap<String, Double> players = new HashMap<String, Double>();
    
	// Create item

	public static ItemStack createItem(ItemStack item, String name, String[] lore) {
		ItemMeta im = item.getItemMeta();
		im.setDisplayName(name);
		im.setLore(Arrays.asList(lore));
		item.setItemMeta(im);
		return item;
	}

	// Shuffle

	/*
	 * public void shuffle(ItemStack[] arg0, Inventory gui) { int startingIndex
	 * = ThreadLocalRandom.current().nextInt(arg0.length); for (int index = 0;
	 * index < startingIndex; index++) { for (int itemstacks = 9; itemstacks <
	 * 18; itemstacks++) { gui.setItem(itemstacks,
	 * RouletteCommand.items[(itemstacks + itemIndex) %
	 * RouletteGUI.items.length]); } itemIndex++; } }
	 */

	public static Inventory createInventory(Player player) throws UserDoesNotExistException {

		ItemStack redclear = RouletteAPI.createItem(new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 14),
				ChatColor.translateAlternateColorCodes('&', "&c&lReset bet"), new String[] {});

		ItemStack white = RouletteAPI.createItem(new ItemStack(Material.STAINED_GLASS_PANE), ChatColor.BOLD + "",
				new String[] {});

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

		ItemStack notenough = RouletteAPI.createItem(new ItemStack(Material.BARRIER),
				ChatColor.translateAlternateColorCodes('&', Roulette.instance.getConfigString("OptionNotEnough")), new String[] {});

		ItemStack hoppermoving = RouletteAPI.createItem(new ItemStack(Material.HOPPER),
				ChatColor.translateAlternateColorCodes('&', Roulette.instance.getConfigString("InfoStatus")),
				new String[] { "", ChatColor.translateAlternateColorCodes('&',
						Roulette.instance.getConfigString("InfoMakeBet")) });

		ItemStack makebet = RouletteAPI.createItem(new ItemStack(Material.HOPPER),
				ChatColor.translateAlternateColorCodes('&', Roulette.instance.getConfigString("InfoStatus")),
				new String[] { "",
						ChatColor.translateAlternateColorCodes('&', Roulette.instance.getConfigString("InfoAlert")) });

		ItemStack hopperstart = RouletteAPI.createItem(new ItemStack(Material.HOPPER),
				ChatColor.translateAlternateColorCodes('&', Roulette.instance.getConfigString("InfoStatus")),
				new String[] { "", ChatColor.translateAlternateColorCodes('&',
						Roulette.instance.getConfigString("InfoSpinning")) });

		ItemStack pushbet = RouletteAPI.createItem(new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 5),
				ChatColor.translateAlternateColorCodes('&', Roulette.instance.getConfigString("InfoPushBet")),
				new String[] { "",
						ChatColor.translateAlternateColorCodes('&',
								Roulette.instance.getConfigString("InfoPushBetDesc1")),
						ChatColor.translateAlternateColorCodes('&',
								Roulette.instance.getConfigString("InfoPushBetDesc2")),
						ChatColor.translateAlternateColorCodes('&',
								Roulette.instance.getConfigString("InfoPushBetDesc3")) });
		
		ItemStack bet1 = createItem(new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 1),
				ChatColor.translateAlternateColorCodes('&', Roulette.instance.getConfigString("Option1Info")),
				new String[] {});

		ItemStack bet2 = createItem(new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 1),
				ChatColor.translateAlternateColorCodes('&', Roulette.instance.getConfigString("Option2Info")),
				new String[] {});

		ItemStack bet3 = createItem(new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 1),
				ChatColor.translateAlternateColorCodes('&', Roulette.instance.getConfigString("Option3Info")),
				new String[] {});

		ItemStack bet4 = createItem(new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 1),
				ChatColor.translateAlternateColorCodes('&', Roulette.instance.getConfigString("Option4Info")),
				new String[] {});

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

		if(Economy.getMoney(player.getName()) >= Roulette.instance.getConfigInt("Option4")) {
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

}

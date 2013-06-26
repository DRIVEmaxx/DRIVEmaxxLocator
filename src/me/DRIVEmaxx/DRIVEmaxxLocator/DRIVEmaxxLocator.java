package me.DRIVEmaxx.DRIVEmaxxLocator;

import java.util.logging.Logger;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class DRIVEmaxxLocator extends JavaPlugin
{
  Logger logger = Logger.getLogger("Minecraft");

  public void onEnable() {
    this.logger.info("[DRIVEmaxxLocator] was Enabled!");
    PluginManager pm = getServer().getPluginManager();
    pm.registerEvents(new DRIVEmaxxLocatorListener(this), this);
  }

  public void onDisable()
  {
    this.logger.info("[DRIVEmaxxLocator] was Disabled!");
  }

  public boolean onCommand(CommandSender sender, Command cmd, String cL, String[] args)
  {
    Player player = (Player)sender;
    PlayerInventory inventory = player.getInventory();

    if (!sender.isOp()) {
      sender.sendMessage(ChatColor.RED + "Nemas potrebna opravneni pro tento prikaz!");
      return true;
    }

    if (cmd.getName().equalsIgnoreCase("dl"))
    {
      sender.sendMessage(ChatColor.GOLD + "[DRIVEmaxxLocator] " + ChatColor.GREEN + "Pro vice informaci pouzij" + ChatColor.RED + " /dlhelp");
    }
    if (cmd.getName().equalsIgnoreCase("dlhelp"))
    {
      sender.sendMessage(ChatColor.GOLD + "-------[DRIVEmaxxLocator]-------");
      sender.sendMessage(ChatColor.RED + "/dltool" + ChatColor.BLUE + " Locator item");
      sender.sendMessage(ChatColor.RED + "/dlver" + ChatColor.BLUE + " Verze pluginu");
    }
    if (cmd.getName().equalsIgnoreCase("dltool"))
    {
      inventory.addItem(new ItemStack[] { new ItemStack(Material.WOOD_PICKAXE, 1) });
      sender.sendMessage(ChatColor.GOLD + "[DRIVEmaxxLocator] " + ChatColor.GREEN + "Nyni muzes klikout pravym pro zjisteni souradnic !");
    }
    if (cmd.getName().equalsIgnoreCase("dlver"))
    {
      sender.sendMessage(ChatColor.GOLD + "[DRIVEmaxxLocator] " + ChatColor.GREEN + "Verze pluginu je 2.1 !");
    }
    return true;
  }
}
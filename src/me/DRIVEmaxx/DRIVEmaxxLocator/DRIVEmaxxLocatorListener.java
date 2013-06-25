package me.DRIVEmaxx.DRIVEmaxxLocator;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class DRIVEmaxxLocatorListener
  implements Listener
{
  public DRIVEmaxxLocator plugin;

  public DRIVEmaxxLocatorListener(DRIVEmaxxLocator instance)
  {
    this.plugin = instance;
  }

  @EventHandler
  public void onPlayerInteract(PlayerInteractEvent event) {
    if ((event.getPlayer().getItemInHand().getTypeId() == Material.WOOD_PICKAXE.getId()) && (event.getAction() == Action.RIGHT_CLICK_BLOCK) && (event.getPlayer().isOp())) {
      int x = event.getClickedBlock().getX();
      int y = event.getClickedBlock().getY();
      int z = event.getClickedBlock().getZ();
      Material block = event.getClickedBlock().getType();
      event.getPlayer().sendMessage(ChatColor.GOLD + "[DRIVEmaxxLocator] " + ChatColor.GREEN + "Souradnice " + ChatColor.BLUE + block + ChatColor.GREEN + " : X: " + x + ", Y: " + y + ", Z: " + z);
    }
  }
}
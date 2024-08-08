package org.windy.plotsQuaredModFix;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;
import java.util.Objects;

public final class PlotsQuaredModFix extends JavaPlugin implements Listener {

    private List<String> enabledWorlds;
    private String cannotUseMessage;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        loadConfigValues();
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    private void loadConfigValues() {
        FileConfiguration config = getConfig();
        enabledWorlds = config.getStringList("enabledWorlds");
        cannotUseMessage = config.getString("messages.cannotUseRightClick");
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        Location location = player.getLocation();
        String worldName = Objects.requireNonNull(location.getWorld()).getName();

        if (enabledWorlds.contains(worldName)) {
            if (event.getAction().name().contains("RIGHT_CLICK")) {
                if (player.isOp()) {
                    return;
                }

                    if (event.getPlayer().getName().toUpperCase().contains("AS-FAKEPLAYER") || 
      event.getPlayer().getName().toUpperCase().contains("[MINECRAFT]") || 
      event.getPlayer().getName().toUpperCase().contains("[MEKANISM]") || 
      event.getPlayer().getName().toUpperCase().contains("[IF]")) {
      return;
    }
                
                // 使用PAPI检查占位符的值
                String canBuildPlaceholder = PlaceholderAPI.setPlaceholders(player, "%plotsquared_currentplot_can_build%");
                boolean canBuild = Boolean.parseBoolean(canBuildPlaceholder);

                if (!canBuild) {
                    event.setUseInteractedBlock(Event.Result.DENY);
                    event.setUseItemInHand(Event.Result.DENY);
                    event.setCancelled(true);
                    if (cannotUseMessage != null) {
                        player.sendMessage(cannotUseMessage);
                    }
                }
            }
        }
    }
}

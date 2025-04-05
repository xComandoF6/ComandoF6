package com.cf6.comandof6.listeners;

import com.cf6.comandof6.ComandoF6;
import com.cf6.comandof6.scoreboard.ScoreboardCF6;
import jdk.nashorn.internal.ir.Block;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Golem;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityInteractEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scoreboard.Objective;

public class ListenersManager implements Listener {
    private final ComandoF6 plugin;

    public ListenersManager(ComandoF6 plugin) {
        this.plugin = plugin;
    }
    @EventHandler
    public void join (PlayerJoinEvent event) {
        Player player = event.getPlayer();
        player.setHealth(20);
        player.setFoodLevel(20);
        if (!plugin.getNoScoreboard().contains(player.getName())) {
            ScoreboardCF6.crearScoreBoardPrincipal(player, plugin);
        }
        for (Player p : Bukkit.getOnlinePlayers()) {
            for (Objective o : p.getScoreboard().getObjectives()) {
                if (o.getName().equalsIgnoreCase("Principal")) {
                    ScoreboardCF6.actualizarScoreBoarPrincipal(p, false);
                }
            }
        }
    }

    @EventHandler
    public void leave (PlayerQuitEvent event) {
        for (Player p : Bukkit.getOnlinePlayers()) {
            for(Objective o : p.getScoreboard().getObjectives()) {
                if (o.getName().equalsIgnoreCase("Principal")) {
                    ScoreboardCF6.actualizarScoreBoarPrincipal(p,true);
                }
            }
        }
    }
    @EventHandler
    public void fall(EntityDamageEvent event){
        Entity entity = event.getEntity();
        if(entity instanceof Player){
            EntityDamageEvent.DamageCause cause = event.getCause();
            if(cause.equals(EntityDamageEvent.DamageCause.FALL)){
                Player jugador = (Player) entity;
                //jugador.sendMessage(ChatColor.translateAlternateColorCodes('&',plugin.prefix+ "&cTe caiste desde muy alto ten más cuidado"));
                event.setCancelled(true);
            } else if (cause.equals(EntityDamageEvent.DamageCause.VOID)) {
                Player jugador = (Player) entity;
                if (jugador.getWorld().getName().equalsIgnoreCase("lobby")) {
                    event.setCancelled(true);
                    jugador.teleport(new Location(jugador.getWorld(),6.5,110,-5.5,1.26F,3.98F));

                } else if (jugador.getWorld().getName().equalsIgnoreCase("spawn")) {
                    event.setCancelled(true);
                    jugador.teleport(new Location(jugador.getWorld(),-0.5,80,0.5,90.05F,0.63F));
                }
            }
        }
    }
    @EventHandler
    public void interact (PlayerInteractAtEntityEvent event){
        if (event.getPlayer().getWorld().getName().equalsIgnoreCase("lobby")) {
            Entity entity = event.getRightClicked();
            if(entity.getType().equals(EntityType.IRON_GOLEM)){
                event.getPlayer().teleport(new Location(Bukkit.getWorld("spawn"),-0.5,80,0.5,90.05F,0.63F));
            }
        }
    }
}

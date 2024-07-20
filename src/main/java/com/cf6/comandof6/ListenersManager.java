package com.cf6.comandof6;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
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
        ScoreboardCF6.crearScoreBoardPrincipal(player,plugin);
        for (Player p : Bukkit.getOnlinePlayers()) {
            for(Objective o : p.getScoreboard().getObjectives()) {
                if (o.getName().equalsIgnoreCase("Principal")) {
                    ScoreboardCF6.actualizarScoreBoarPrincipal(p,false);
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
                jugador.sendMessage(ChatColor.translateAlternateColorCodes('&',plugin.prefix+ "&cTe caiste desde muy alto ten más cuidado"));
                event.setCancelled(true);
            }
        }
    }
}

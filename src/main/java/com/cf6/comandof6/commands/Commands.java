package com.cf6.comandof6.commands;

import com.cf6.comandof6.ComandoF6;
import com.cf6.comandof6.nms.MobNMS;
import com.cf6.comandof6.scoreboard.ScoreboardCF6;
import com.cf6.comandof6.xprueba.Scoreboard;
import net.minecraft.server.v1_8_R3.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;

public class Commands implements CommandExecutor {
    private final ComandoF6 plugin;

    public Commands (ComandoF6 plugin) {
        this.plugin = plugin;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (!(sender instanceof Player)) {
            return false;
        }
        Player player = (Player) sender;
        if (args.length >= 1) {
            if (player.isOp()) {
                if (args[0].equalsIgnoreCase("sb")) {
                    if (plugin.getNoScoreboard().contains(player.getName())) {
                        plugin.getNoScoreboard().remove(player.getName());
                        ScoreboardCF6.crearScoreBoardPrincipal(player,plugin);
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&',plugin.prefix + "Create SB"));
                    } else {
                        plugin.getNoScoreboard().add(player.getName());
                        org.bukkit.scoreboard.Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
                        Objective objective = scoreboard.registerNewObjective("Null", "yummy");
                        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
                        player.setScoreboard(scoreboard);
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&',plugin.prefix + "Remove SB"));
                    }
                }  else if (args[0].equalsIgnoreCase("prueba")) {
                    for (String p : plugin.getNoScoreboard()) {
                        player.sendMessage("::: "+p);
                    }

                } else if (args[0].equalsIgnoreCase("prueba2")) {

                } else if (args[0].equalsIgnoreCase("prueba3")) {




                } else if (args[0].equalsIgnoreCase("prueba4")) {
                    EntityLiving golem = MobNMS.golem;
                    golem.die();


                }
            } else {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&',plugin.prefix+"&cNo tienes permisos para usar ese comando."));
            }
        } else {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&',plugin.prefix+"&cComando desconocico"));
        }
        return false;
    }


}

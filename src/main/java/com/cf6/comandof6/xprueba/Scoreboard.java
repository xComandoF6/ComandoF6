package com.cf6.comandof6.xprueba;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Team;

public class Scoreboard {
    public static void crearScoreBoardMGIniciar(Player player) {
        String sMinigame = "Paintball";
        ChatColor color = ChatColor.AQUA;

        org.bukkit.scoreboard.Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective objective = scoreboard.registerNewObjective("MiniGamesIniciar", "yummy");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        objective.setDisplayName(ChatColor.translateAlternateColorCodes('&', color+"&l"+sMinigame));

        objective.getScore(ChatColor.translateAlternateColorCodes('&', "&1")).setScore(14);
        objective.getScore(ChatColor.translateAlternateColorCodes('&', "&8➣ "+color+"Name&8: &f" + player.getName())).setScore(13);

        objective.getScore(ChatColor.translateAlternateColorCodes('&', "&2")).setScore(12);
        /**
         * Team Tiempo de la partida
         */
        Team tiempo = scoreboard.registerNewTeam("tiempo");
        String tiempokey = ChatColor.BLUE.toString();
        tiempo.addEntry(tiempokey);
        tiempo.setPrefix(ChatColor.DARK_GRAY + "✠ "+color+"Tiempo"+ChatColor.DARK_GRAY+": ");
        tiempo.setSuffix(ChatColor.WHITE+"00:00");
        objective.getScore(tiempokey).setScore(11);

        objective.getScore(ChatColor.translateAlternateColorCodes('&', "&3")).setScore(10);
        /**
         * Equipo Rojo de la partida (Team)
         */
        Team rojo = scoreboard.registerNewTeam("rojo");
        String rojokey = ChatColor.WHITE.toString();
        rojo.addEntry(rojokey);
        rojo.setPrefix(ChatColor.DARK_GRAY+" 》"+ChatColor.DARK_RED+"Rojo "+ChatColor.GOLD+"✯ ");
        rojo.setSuffix(ChatColor.YELLOW+"100");
        objective.getScore(rojokey).setScore(8);

        objective.getScore(ChatColor.translateAlternateColorCodes('&', "&4")).setScore(4);
        objective.getScore(ChatColor.translateAlternateColorCodes('&', "&8✠ "+color+"Arena&8: &fPrueba")).setScore(3);
        objective.getScore(ChatColor.translateAlternateColorCodes('&', "&5")).setScore(2);
        /**
         * Team count
         */
        Team count = scoreboard.registerNewTeam("count");
        String countkey = ChatColor.LIGHT_PURPLE.toString();
        count.addEntry(countkey);
        count.setPrefix(ChatColor.WHITE+ " Jugadores: ");
        count.setSuffix(ChatColor.GREEN+"1/2");
        objective.getScore(countkey).setScore(1);

        objective.getScore(ChatColor.translateAlternateColorCodes('&', "&6")).setScore(0);
        player.setScoreboard(scoreboard);

    }

}

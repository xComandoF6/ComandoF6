package com.cf6.comandof6.scoreboard;

import com.cf6.comandof6.ComandoF6;
import net.luckperms.api.model.user.User;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class ScoreboardCF6 {
    public static void crearScoreBoardPrincipal(Player player, ComandoF6 plugin) {
        if (plugin.getNoScoreboard() == null || !plugin.getNoScoreboard().contains(player.getName())) {

            Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
            Objective objective = scoreboard.registerNewObjective("Principal", "yummy");
            objective.setDisplaySlot(DisplaySlot.SIDEBAR);
            objective.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&8[&5&lUn&6&lServer&5&lRandom&8]"));
            objective.getScore(ChatColor.translateAlternateColorCodes('&', "      &8&m                           ")).setScore(13);

            objective.getScore(ChatColor.translateAlternateColorCodes('&', "&1")).setScore(12);
            objective.getScore(ChatColor.translateAlternateColorCodes('&', " &8➣ &6Nombre&8: &a" + player.getName())).setScore(11);
            objective.getScore(ChatColor.translateAlternateColorCodes('&', "&2")).setScore(10);

            User user = plugin.getLuckPerms().getUserManager().getUser(player.getUniqueId());
            assert user != null;
            objective.getScore(ChatColor.translateAlternateColorCodes('&', " &8➣ &6Rango&8: " + getRango(user.getPrimaryGroup()))).setScore(9);

            objective.getScore(ChatColor.translateAlternateColorCodes('&', "&3")).setScore(8);
            objective.getScore(ChatColor.translateAlternateColorCodes('&', "&7   Unete al discord del server")).setScore(7);
            objective.getScore(ChatColor.translateAlternateColorCodes('&', "&7   con el comando &5&l/discord &7y")).setScore(6);
            objective.getScore(ChatColor.translateAlternateColorCodes('&', "&7   ayudame a reportar bugs.")).setScore(5);
            objective.getScore(ChatColor.translateAlternateColorCodes('&', "&4")).setScore(4);

            Team linea = scoreboard.registerNewTeam("linea");
            String lineakey = ChatColor.YELLOW.toString();
            linea.addEntry(lineakey);
            linea.setPrefix(ChatColor.DARK_GRAY + " ☷" + ChatColor.GOLD + "En Linea: ");
            linea.setSuffix(ChatColor.YELLOW + "" + Bukkit.getOnlinePlayers().size());

            objective.getScore(lineakey).setScore(3);

            objective.getScore(ChatColor.translateAlternateColorCodes('&', "&5")).setScore(2);
            objective.getScore(ChatColor.translateAlternateColorCodes('&', "      &1&8&m                           ")).setScore(1);
            objective.getScore(ChatColor.translateAlternateColorCodes('&', "&bIp&8:&fruby.magmanode.com:32236")).setScore(0);

            player.setScoreboard(scoreboard);
        } else {
            org.bukkit.scoreboard.Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
            Objective objective = scoreboard.registerNewObjective("Null", "yummy");
            objective.setDisplaySlot(DisplaySlot.SIDEBAR);
            player.setScoreboard(scoreboard);
        }

    }
    public static void actualizarScoreBoarPrincipal (Player player, boolean leave) {

        Scoreboard scoreboard = player.getScoreboard();
        Team linea = scoreboard.getTeam("linea");
        if(leave) {
            linea.setSuffix("" + (Bukkit.getOnlinePlayers().size()-1));
        } else {
            linea.setSuffix("" + Bukkit.getOnlinePlayers().size());
        }
    }
    public static String getRango(String rango) {
        switch (rango) {
            case "default":
                return "&8[&7Default&8]";
            case "admin":
                return "&8[&cAdmin&8]";
            case "enjuego":
                return "&8[&6EnJuego&8]";
            case "eveto":
                return "&8[&5Evento&8]";
            case "desconectado":
                return "8[&7Offline&8]";
            case "ganador":
                return "&8[&2Ganador&8]";
            case "eliminado":
                return "&8[&4Eliminado&8]";
            case "rojo":
                return "&8[&4Rojo&8]";
            case "azul":
                return "&8[&1Azul&8]";
            case "amarillo":
                return "&8[&eAmarillo&8]";
            case "morado":
                return "&8[&5Morado&8]";
            case "lime":
                return "&8[&aLima&8]";
        }
        return "&8[Sin rango]";

    }
}

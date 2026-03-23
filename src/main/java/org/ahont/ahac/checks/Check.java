package org.ahont.ahac.checks;

import net.md_5.bungee.api.ChatColor;
import org.ahont.ahac.Ahac;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

/**
 * Implementacion abstracta de la base de los checks del sistema anti-trampas
 */
public abstract class Check {
    private String name;

    public Check(String name){
        this.name = name;
    }

    public void flag(Player t, String info){
        for (Player p : Bukkit.getOnlinePlayers()){
            p.sendMessage(
                    ChatColor.DARK_AQUA + t.getName()
                            + ChatColor.GRAY + " ha fallado el check: "
                            + ChatColor.DARK_RED + this.name
                            + ChatColor.DARK_GREEN + " {" + info + "} "
            );
        }
    }
}

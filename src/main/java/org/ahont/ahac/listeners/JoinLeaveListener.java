package org.ahont.ahac.listeners;

import org.ahont.ahac.Ahac;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

/**
 * Clase que implementa la gestion de los eventos de union y abandono del servidor para los jugadores
 */
public class JoinLeaveListener implements Listener {

    /**
     * Añade un jugador que se ha unido al servidor al dataset
     * @param e Event object
     */
    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Ahac.instance.dataManager.add(e.getPlayer());
        System.out.println("[AHAC] Nuevo jugador: " + e.getPlayer().getDisplayName());
    }

    /**
     * Elimina un jugador que ha abandonado el servidor del dataset
     * @param e Event object
     */
    @EventHandler
    public void onQuit(PlayerQuitEvent e){
        Ahac.instance.dataManager.remove(e.getPlayer());
        System.out.println("[AHAC] Eliminando jugador: " + e.getPlayer().getDisplayName());
    }
}

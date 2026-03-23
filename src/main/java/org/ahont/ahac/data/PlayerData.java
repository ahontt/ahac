package org.ahont.ahac.data;

import org.bukkit.entity.Player;

/**
 * Implementación de la clase PlayerData que contiene los datos de los jugadores actualmente en el servidor
 */
public class PlayerData {
    public Player player;

    public int timesFlagged = 0;

    public PlayerData(Player p) {
        this.player = p;
    }

    /*
    Datos del jugador necesarios para la implementación del check de KillAura (A)

     */

    public long lastFlying;
    public int killAuraAVerbose;

    /*
    Metodos usados para gestionar el usuario
     */
}

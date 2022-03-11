import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;


public class SpawnOnJoin extends JavaPlugin implements Listener {

    //The onEnable method runs as the plugin boots up and when the server reloads
    @Override
    public void onEnable() {
        // Enable our class to check for new players using onPlayerJoin()
        getServer().getPluginManager().registerEvents(this, this);
    }

    // This method checks for incoming players and sends them to spawn
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        final Player player = event.getPlayer();
        if (!player.hasPermission("SpawnOn.bypass"))
            player.teleport(getServer().getWorlds().get(0).getSpawnLocation());
    }

    @Override
    public void onDisable(){

    }
}

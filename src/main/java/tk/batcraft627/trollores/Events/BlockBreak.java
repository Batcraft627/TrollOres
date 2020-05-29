package tk.batcraft627.trollores.Events;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.scheduler.BukkitRunnable;
import tk.batcraft627.trollores.trollores.TrollOres;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class BlockBreak implements Listener
{
    @EventHandler
    public void onBlockBreak(BlockBreakEvent e)
    {
        Player player = e.getPlayer();
        Location loc = player.getLocation();

        Random r = new Random();

        World world = player.getWorld();

        if (!e.getBlock().getType().equals(Material.COAL_ORE))
            if (!e.getBlock().getType().equals(Material.DIAMOND_ORE))
                if (!e.getBlock().getType().equals(Material.EMERALD_ORE))
                    if (!e.getBlock().getType().equals(Material.GOLD_ORE))
                        if (!e.getBlock().getType().equals(Material.IRON_ORE))
                            if (!e.getBlock().getType().equals(Material.LAPIS_ORE))
                            {
                                return;
                            }
        int randomNum = ThreadLocalRandom.current().nextInt(1,1000 +1);
        if (randomNum >= 900){
            loc.getWorld().playSound(loc, Sound.ENTITY_CREEPER_PRIMED, 1.0F, 1.0F);
            if (randomNum >= 995){
                new BukkitRunnable()
                {

                    public void run()
                    {
                        world.createExplosion(loc.getX(),loc.getY(),loc.getZ(),10F);
                    }
                }.runTaskLater(TrollOres.getPlugin(TrollOres.class), 60);
            }
        }
    }
}

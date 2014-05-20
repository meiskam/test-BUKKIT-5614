package org.shininet.bukkit.test.B5614;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class BUKKIT5614Plugin extends JavaPlugin {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Command must be issued by a player");
            return true;
        }
        Player player = (Player)sender;

        ItemStack itemStack = new ItemStack(Material.SKULL_ITEM, 1);
        SkullMeta skullMeta = (SkullMeta)itemStack.getItemMeta();
        skullMeta.setOwner("meiskam");
        itemStack.setItemMeta(skullMeta);
        
        PlayerInventory inv = player.getInventory();
        int firstEmpty = inv.firstEmpty();
        if (firstEmpty == -1) {
            sender.sendMessage("Your inventory is full");
            return true;
        } else {
            inv.setItem(firstEmpty, itemStack);
            sender.sendMessage("You now have a 'meiskam' skull");
            return true;
        }
    }
}

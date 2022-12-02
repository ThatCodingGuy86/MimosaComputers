package bluefire_06.mimosa_computers;

import bluefire_06.mimosa_computers.items.AAAAAItem;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class RegisterItems {
    public static final AAAAAItem FABRIC_ITEM = new AAAAAItem(new FabricItemSettings().group(ItemGroup.MISC));

    public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(
            new Identifier("mimosa_computers", "general"),
            () -> new ItemStack(FABRIC_ITEM));


    public static void register() {

        Registry.register(Registry.ITEM, new Identifier("mimosa_computers", "fabric_item"), FABRIC_ITEM);
    }
}

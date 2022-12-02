package bluefire_06.mimosa_computers;

import bluefire_06.mimosa_computers.blocks.AAAAAABlock;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class RegisterBlocks {
    public static final AAAAAABlock EXAMPLE_BLOCK = new AAAAAABlock(
            FabricBlockSettings.of(Material.METAL).strength(1.0f, 1.0f));

    public static void register() {
        Registry.register(Registry.BLOCK, new Identifier("mimosa_computers", "aaaaaa_block"), EXAMPLE_BLOCK);
        Registry.register(Registry.ITEM, new Identifier("mimosa_computers", "aaaaaa_block"),
                new BlockItem(EXAMPLE_BLOCK, new FabricItemSettings().group(RegisterItems.ITEM_GROUP)));
    }
}

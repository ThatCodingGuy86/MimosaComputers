package bluefire_06.mimosa_computers;

import bluefire_06.mimosa_computers.blocks.ScreenBlock;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class RegisterBlocks {
    public static final ScreenBlock SCREEN_BLOCK = new ScreenBlock(
            FabricBlockSettings.of(Material.METAL).strength(1.0f, 1.0f));

    public static void register() {
        Registry.register(Registry.BLOCK, new Identifier("mimosa_computers", "screen_block"), SCREEN_BLOCK);
        Registry.register(Registry.ITEM, new Identifier("mimosa_computers", "screen_block"),
                new BlockItem(SCREEN_BLOCK, new FabricItemSettings().group(RegisterItems.ITEM_GROUP)));
    }
}

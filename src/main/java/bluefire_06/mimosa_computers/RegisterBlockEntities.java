package bluefire_06.mimosa_computers;

import bluefire_06.mimosa_computers.blockentities.ScreenBlockEntity;;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class RegisterBlockEntities {
    public static BlockEntityType<ScreenBlockEntity> SCREEN_BLOCK_ENTITY;
    public static void register() {
        SCREEN_BLOCK_ENTITY = Registry.register(
                Registry.BLOCK_ENTITY_TYPE,
                new Identifier("mimosa_computers", "screen_block_entity"),
                FabricBlockEntityTypeBuilder.create(ScreenBlockEntity::new, RegisterBlocks.SCREEN_BLOCK).build()
        );
    }
}

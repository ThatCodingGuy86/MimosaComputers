package bluefire_06.mimosa_computers.blockentities;

import bluefire_06.mimosa_computers.RegisterBlockEntities;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ScreenBlockEntity extends BlockEntity {
    public ScreenBlockEntity(BlockPos pos, BlockState state) {
        super(RegisterBlockEntities.SCREEN_BLOCK_ENTITY, pos, state);
    }

    public static void tick(World world, BlockPos pos, BlockState state1, ScreenBlockEntity be) {

    }
}

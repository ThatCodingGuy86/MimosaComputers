package bluefire_06.mimosa_computers.blocks;

import bluefire_06.mimosa_computers.MimosaComputers;
import bluefire_06.mimosa_computers.RegisterBlockEntities;
import bluefire_06.mimosa_computers.blockentities.ScreenBlockEntity;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ScreenBlock extends BlockWithEntity {
    public ScreenBlock(Settings settings) {super(settings);}

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        MimosaComputers.LOGGER.info("Creating ScreenBlockEntity at " + pos.toShortString());
        return new ScreenBlockEntity(pos, state);
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        // With inheriting from BlockWithEntity this defaults to INVISIBLE, so we need to change that!
        return BlockRenderType.MODEL;
    }
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return checkType(type, RegisterBlockEntities.SCREEN_BLOCK_ENTITY, (world1, pos, state1, be) -> ScreenBlockEntity.tick(world1, pos, state1, be));
    }
}

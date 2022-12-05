package bluefire_06.mimosa_computers.blockentities;

import bluefire_06.mimosa_computers.MimosaComputers;
import bluefire_06.mimosa_computers.RegisterBlockEntities;
import bluefire_06.mimosa_computers.lua.DLLHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.Packet;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class ScreenBlockEntity extends BlockEntity {
    public int[] screenArr = new int[128 * 128];
    public boolean hasComputerEnv = false;

    public ScreenBlockEntity(BlockPos pos, BlockState state) {
        super(RegisterBlockEntities.SCREEN_BLOCK_ENTITY, pos, state);
        MimosaComputers.screenBlockEntities.add(this);
        for(int i = 0; i < 128; ++i) {
            for(int j = 0; j < 128; ++j) {
                int k = j + i * 128;
                this.screenArr[k] = 0xFFFF0000;
            }
        }
    }

    public static void tick(World world, BlockPos pos, BlockState state1, ScreenBlockEntity be) {

        // Only execute this on the server, otherwise things explode!
        if (!world.isClient && !be.hasComputerEnv)
        {
            DLLHandler.createComputerEnv();
            be.hasComputerEnv = true;
        }
    }

    // Serialize the screen state
    @Override
    public void writeNbt(NbtCompound nbt) {
        // Save the current state of the screen to the nbt
        nbt.putIntArray("screenArr", screenArr);
        super.writeNbt(nbt);
    }

    // Deserialize the screen state
    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);

        screenArr = nbt.getIntArray("screenArr");
    }

    @Nullable
    @Override
    public Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    @Override
    public NbtCompound toInitialChunkDataNbt() {
        return createNbt();
    }
}

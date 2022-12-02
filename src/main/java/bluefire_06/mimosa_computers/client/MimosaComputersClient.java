package bluefire_06.mimosa_computers.client;

import bluefire_06.mimosa_computers.blockrenderers.ScreenBlockEntityRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;

import bluefire_06.mimosa_computers.RegisterBlockEntities;

@net.fabricmc.api.Environment(net.fabricmc.api.EnvType.CLIENT)
public class MimosaComputersClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockEntityRendererRegistry.register(RegisterBlockEntities.SCREEN_BLOCK_ENTITY, ScreenBlockEntityRenderer::new);
    }
}

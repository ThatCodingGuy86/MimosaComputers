package bluefire_06.mimosa_computers.blockrenderers;

import bluefire_06.mimosa_computers.MimosaComputers;
import bluefire_06.mimosa_computers.blockentities.ScreenBlockEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.*;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.texture.NativeImageBackedTexture;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Matrix4f;

@Environment(EnvType.CLIENT)
public class ScreenBlockEntityRenderer implements BlockEntityRenderer<ScreenBlockEntity> {

    private final NativeImageBackedTexture texture;
    private final RenderLayer renderLayer;

    public ScreenBlockEntityRenderer(BlockEntityRendererFactory.Context ctx) {
        MimosaComputers.LOGGER.info("Initializing ScreenBlockEntityRenderer");

        //this.textureManager = new TextureManager(MinecraftClient.getInstance().getResourceManager());

        this.texture = new NativeImageBackedTexture(128, 128, true);
        Identifier identifier = MinecraftClient.getInstance().getTextureManager().registerDynamicTexture("screen/", this.texture);
        this.renderLayer = RenderLayer.getText(identifier);
        MimosaComputers.LOGGER.info(identifier);
    }

    private void updateTexture(ScreenBlockEntity blockEntity) {
        for(int i = 0; i < 128; ++i) {
            for(int j = 0; j < 128; ++j) {
                int k = j + i * 128;
                this.texture.getImage().setColor(j, i, blockEntity.screenArr[k] | 0xFF000000);
            }
        }

        this.texture.upload();
    }

    @Override
    public void render(ScreenBlockEntity blockEntity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        this.updateTexture(blockEntity);

        matrices.push();

        int lightAbove = WorldRenderer.getLightmapCoordinates(blockEntity.getWorld(), blockEntity.getPos().up());

        matrices.translate(0, 2, 0);
        Matrix4f matrix4f = matrices.peek().getPositionMatrix();

        VertexConsumer vertexConsumer = vertexConsumers.getBuffer(this.renderLayer);
        vertexConsumer.vertex(matrix4f, 0.0F, 1.0F, -0.01F).color(255, 255, 255, 255).texture(0.0F, 0.0F).light(lightAbove).next();
        vertexConsumer.vertex(matrix4f, 1.0F, 1.0F, -0.01F).color(255, 255, 255, 255).texture(1.0F, 0.0F).light(lightAbove).next();
        vertexConsumer.vertex(matrix4f, 1.0F, 0.0F, -0.01F).color(255, 255, 255, 255).texture(1.0F, 1.0F).light(lightAbove).next();
        vertexConsumer.vertex(matrix4f, 0.0F, 0.0F, -0.01F).color(255, 255, 255, 255).texture(0.0F, 1.0F).light(lightAbove).next();
        matrices.pop();
    }
}

package bluefire_06.mimosa_computers;

import bluefire_06.mimosa_computers.blockentities.ScreenBlockEntity;
import bluefire_06.mimosa_computers.lua.DLLHandler;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class MimosaComputers implements ModInitializer {

    public static final Logger LOGGER = LogManager.getLogger("mimosa_computers");
    public static List<ScreenBlockEntity> screenBlockEntities;

    @Override
    public void onInitialize() {
        LOGGER.info("Initializing...");

        LOGGER.info("Registering items, blocks, & block entities...");
        RegisterItems.register();
        RegisterBlocks.register();
        RegisterBlockEntities.register();

        screenBlockEntities = new ArrayList<>();

        ServerLifecycleEvents.SERVER_STARTED.register((server) -> server.execute(DLLHandler::initLua));

        ServerTickEvents.START_SERVER_TICK.register((server) -> server.execute(DLLHandler::drawPix));
    }
}

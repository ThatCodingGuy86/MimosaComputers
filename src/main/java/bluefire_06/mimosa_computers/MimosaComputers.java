package bluefire_06.mimosa_computers;

import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MimosaComputers implements ModInitializer {

    public static final Logger LOGGER = LogManager.getLogger("mimosa_computers");

    @Override
    public void onInitialize() {
        LOGGER.info("Initializing...");

        RegisterItems.register();
        RegisterBlocks.register();
    }
}

package bluefire_06.mimosa_computers.lua;

import bluefire_06.mimosa_computers.MimosaComputers;
import bluefire_06.mimosa_computers.blockentities.ScreenBlockEntity;

public class DLLHandler {
    private static native void initLuaDLL();
    private static native void createComputerEnvDLL();
    //private static native void callLuaFunc(String name);

    static {
        System.loadLibrary("mimosa_computers_luajit");
    }

    public static void drawPix(int x, int y)
    {
        MimosaComputers.LOGGER.info(x + " : " + y);
        for (ScreenBlockEntity screenBlockEntity : MimosaComputers.screenBlockEntities) {
            screenBlockEntity.screenArr[x + y * 128] = 0xFFFFFFFF;
        }
    }

    public static void drawPix() {
        for (ScreenBlockEntity screenBlockEntity : MimosaComputers.screenBlockEntities) {
            screenBlockEntity.screenArr[3 + 3 * 128] = 0xFFFFFFFF;
        }
    }

    public static void createComputerEnv()
    {
        DLLHandler.createComputerEnvDLL();
    }

    public static void initLua()
    {
        DLLHandler.initLuaDLL();
    }
}

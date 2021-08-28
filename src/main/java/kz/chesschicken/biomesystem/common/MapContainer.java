package kz.chesschicken.biomesystem.common;

import kz.chesschicken.biomesystem.common.utils.NoiseEnum;
import kz.chesschicken.biomesystem.common.utils.worldnoise.ILevelNoise;
import lombok.SneakyThrows;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.level.Level;

import java.io.File;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.stream.Stream;

public class MapContainer {
    public NoiseEnum CURRENT_ENUM;

    private MapContainer() { }

    @Environment(EnvType.SERVER)
    @SneakyThrows
    public void parseServerConfig()
    {
        File configFile = new File(FabricLoader.getInstance().getGameDir().toFile(), "worldInfo.config");
        if(!configFile.exists()) {
            configFile.createNewFile();

            PrintWriter printWriter = new PrintWriter(configFile);
            printWriter.println("worldType:" + NoiseEnum.INDEPENDENT.name());
            printWriter.close();
            CURRENT_ENUM = NoiseEnum.INDEPENDENT;
            return;
        }

        Stream<String> stringStream = Files.lines(configFile.toPath());
        stringStream.forEach(s -> {
            String[] args = s.split(":");

            if(args[0].startsWith("worldType"))
                CURRENT_ENUM = NoiseEnum.getByName(args[1]);

        });


        if(CURRENT_ENUM == null) {
            SystemMod.LOGGER.error("Something went wrong while reading config. Set to default parameters.");
            CURRENT_ENUM = NoiseEnum.INDEPENDENT;
        }
    }


    public static MapContainer INSTANCE = new MapContainer();
}

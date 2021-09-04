package kz.chesschicken.biomesystem.common.biomes.vanilla;

import kz.chesschicken.biomesystem.common.biomes.ExtendedBiome;
import kz.chesschicken.biomesystem.common.utils.BiomeTemperature;
import net.minecraft.level.structure.LargeOak;
import net.minecraft.level.structure.OakTree;
import net.minecraft.level.structure.Structure;

import java.util.Random;

public class Rainforest extends ExtendedBiome {
    public Rainforest() {
        super(BiomeTemperature.WARM, +20D);
        this.setGrassColour(588342);
        this.setName("Rainforest");
        this.setFoliageColour(2094168);

    }

    public Structure getTree(Random rand) {
        return rand.nextInt(3) == 0 ? new LargeOak() : new OakTree();
    }
}

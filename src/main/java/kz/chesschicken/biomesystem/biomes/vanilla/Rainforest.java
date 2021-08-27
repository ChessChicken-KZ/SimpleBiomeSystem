package kz.chesschicken.biomesystem.biomes.vanilla;

import kz.chesschicken.biomesystem.biomes.ExtendedBiome;
import net.minecraft.level.structure.LargeOak;
import net.minecraft.level.structure.OakTree;
import net.minecraft.level.structure.Structure;

import java.util.Random;

public class Rainforest extends ExtendedBiome {
    public Rainforest(int i) {
        super(i);
        this.setGrassColour(588342);
        this.setName("Rainforest");
        this.setFoliageColour(2094168);

        this.setTemperature(0.7F);
        this.setHumidity(0.9F);
    }

    public Structure getTree(Random rand) {
        return rand.nextInt(3) == 0 ? new LargeOak() : new OakTree();
    }
}

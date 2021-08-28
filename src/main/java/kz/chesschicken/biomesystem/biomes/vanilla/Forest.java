package kz.chesschicken.biomesystem.biomes.vanilla;

import kz.chesschicken.biomesystem.biomes.ExtendedBiome;
import net.minecraft.entity.EntityEntry;
import net.minecraft.entity.animal.Wolf;
import net.minecraft.level.structure.BirchTree;
import net.minecraft.level.structure.LargeOak;
import net.minecraft.level.structure.OakTree;
import net.minecraft.level.structure.Structure;

import java.util.Random;

public class Forest extends ExtendedBiome {
    public Forest() {
        super();
        this.creatures.add(new EntityEntry(Wolf.class, 2));
        this.setGrassColour(353825);
        this.setName("Forest");
        this.setFoliageColour(5159473);

        this.setTemperature(0.7F);
        this.setHumidity(0.8F);
    }

    public Structure getTree(Random rand) {
        if (rand.nextInt(5) == 0) return new BirchTree();
        else return rand.nextInt(3) == 0 ? new LargeOak() : new OakTree();

    }
}

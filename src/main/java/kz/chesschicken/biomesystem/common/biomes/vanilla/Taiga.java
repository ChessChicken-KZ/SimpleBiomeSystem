package kz.chesschicken.biomesystem.common.biomes.vanilla;

import kz.chesschicken.biomesystem.common.biomes.ExtendedBiome;
import net.minecraft.entity.EntityEntry;
import net.minecraft.entity.animal.Wolf;
import net.minecraft.level.structure.PineTree;
import net.minecraft.level.structure.SpruceTree;
import net.minecraft.level.structure.Structure;

import java.util.Random;

public class Taiga extends ExtendedBiome {
    public Taiga() {
        super(BiomeType.COLD, -30D);
        this.creatures.add(new EntityEntry(Wolf.class, 2));
        this.setGrassColour(3060051);
        this.setName("Taiga");
        this.setSnowy();
        this.setFoliageColour(8107825);
    }

    public Structure getTree(Random rand) {
        return rand.nextInt(3) == 0 ? new PineTree() : new SpruceTree();
    }
}

package kz.chesschicken.biomesystem.biomes.vanilla;

import kz.chesschicken.biomesystem.biomes.ExtendedBiome;
import kz.chesschicken.biomesystem.mixin.AccessorBiome;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.EntityEntry;
import net.minecraft.entity.animal.Chicken;

public class Sky extends ExtendedBiome {
    public Sky(int i) {
        super(i);
        this.monsters.clear();
        this.creatures.clear();
        this.waterCreatures.clear();
        this.creatures.add(new EntityEntry(Chicken.class, 10));
        this.setGrassColour(8421631);
        this.setName("Sky");
        ((AccessorBiome)this).invokerSetRainless();

        this.setTemperature(0.7F);
        this.setHumidity(0.8F);
    }

    @Environment(EnvType.CLIENT)
    public int getSkyColour(float temperature) {
        return 12632319;
    }
}

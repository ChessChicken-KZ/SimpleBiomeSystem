package kz.chesschicken.biomesystem.biomes.vanilla;

import kz.chesschicken.biomesystem.biomes.ExtendedBiome;
import kz.chesschicken.biomesystem.mixin.AccessorBiome;
import net.minecraft.entity.EntityEntry;
import net.minecraft.entity.monster.Ghast;
import net.minecraft.entity.monster.ZombiePigman;

public class Hell extends ExtendedBiome {
    public Hell(int i) {
        super(i);
        this.monsters.clear();
        this.creatures.clear();
        this.waterCreatures.clear();
        this.monsters.add(new EntityEntry(Ghast.class, 10));
        this.monsters.add(new EntityEntry(ZombiePigman.class, 10));
        this.setGrassColour(16711680);
        this.setName("Hell");
        ((AccessorBiome)this).invokerSetRainless();

        this.setTemperature(2.0F);
        this.setHumidity(0.0F);
    }
}

package kz.chesschicken.biomesystem.common.utils.worldnoise;

import kz.chesschicken.biomesystem.common.utils.NoiseEnum;

/**
 * Interface for {@link NoiseEnum}.
 * @see kz.chesschicken.biomesystem.mixin.MixinDimension
 * @see kz.chesschicken.biomesystem.mixin.MixinLevelProperties
 */
public interface ILevelNoise {
    NoiseEnum getNoiseEnum();

    void setNoiseEnum(NoiseEnum noiseEnum);
}

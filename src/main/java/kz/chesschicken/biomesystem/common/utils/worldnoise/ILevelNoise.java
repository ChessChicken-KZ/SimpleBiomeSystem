package kz.chesschicken.biomesystem.common.utils.worldnoise;

import kz.chesschicken.biomesystem.common.utils.NoiseEnum;

public interface ILevelNoise {
    NoiseEnum getNoiseEnum();

    void setNoiseEnum(NoiseEnum noiseEnum);
}

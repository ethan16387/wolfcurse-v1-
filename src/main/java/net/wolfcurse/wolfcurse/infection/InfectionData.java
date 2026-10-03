package net.wolfcurse.wolfcurse.infection;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

public record InfectionData(boolean infected, boolean transformed, float progress) {
    public static final InfectionData DEFAULT = new InfectionData(false, false, 0.0f);

    public static final Codec<InfectionData> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Codec.BOOL.fieldOf("infected").forGetter(InfectionData::infected),
            Codec.BOOL.fieldOf("transformed").forGetter(InfectionData::transformed),
            Codec.FLOAT.fieldOf("progress").forGetter(InfectionData::progress)
    ).apply(instance, InfectionData::new));

    public InfectionData withProgress(float value) {
        return new InfectionData(infected, transformed, value);
    }

    public InfectionData withInfected(boolean value) {
        return new InfectionData(value, transformed, progress);
    }

    public InfectionData withTransformed(boolean value) {
        return new InfectionData(infected, value, progress);
    }
}

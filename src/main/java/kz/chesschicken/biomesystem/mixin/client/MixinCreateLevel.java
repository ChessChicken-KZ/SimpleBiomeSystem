package kz.chesschicken.biomesystem.mixin.client;

import kz.chesschicken.biomesystem.common.utils.NoiseEnum;
import kz.chesschicken.biomesystem.common.MapContainer;
import net.minecraft.client.gui.screen.ScreenBase;
import net.minecraft.client.gui.screen.menu.CreateLevel;
import net.minecraft.client.gui.widgets.Button;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(CreateLevel.class)
public class MixinCreateLevel extends ScreenBase {
    @Unique
    private byte selectedNoise = 0;

    @Unique
    private Button noiseButton;

    @Inject(method = "init", at = @At("TAIL"))
    private void injectAddNoiseEnumButton(CallbackInfo ci)
    {
        this.buttons.add(noiseButton = new Button(123, this.width / 2 - 100, this.height / 4 + 120 + 36, "Noise: " + NoiseEnum.values()[selectedNoise].noiseName));
    }

    @Inject(method = "buttonClicked", at = @At("TAIL"))
    private void injectAddButtonAction(Button button, CallbackInfo ci)
    {
        if (button.active) {
            if(button.id == 123) {
                if(selectedNoise < NoiseEnum.values().length - 1)
                    selectedNoise++;
                else
                    selectedNoise = 0;

                noiseButton.text = "Noise: " + NoiseEnum.values()[selectedNoise].noiseName;
            }
        }

    }

    @Inject(method = "buttonClicked", at = @At("HEAD"))
    private void injectSetEnum(Button button, CallbackInfo ci)
    {
        if(button.id == 0) {
            MapContainer.INSTANCE.CURRENT_ENUM = NoiseEnum.values()[selectedNoise];
        }
    }
}

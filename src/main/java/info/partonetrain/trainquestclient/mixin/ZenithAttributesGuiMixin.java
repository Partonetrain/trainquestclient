package info.partonetrain.trainquestclient.mixin;

import dev.shadowsoffire.attributeslib.client.AttributesGui;
import info.partonetrain.trainquestclient.Trainquestclient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = AttributesGui.class, remap = false)
public class ZenithAttributesGuiMixin {
    @Shadow protected boolean open;

    @Inject(method = "toggleVisibility()V", at = @At(value = "TAIL"))
    public void trainquestclient_updateZenithMenuOpen(CallbackInfo ci){
        Trainquestclient.attributesGuiOpen = open;
    }
}

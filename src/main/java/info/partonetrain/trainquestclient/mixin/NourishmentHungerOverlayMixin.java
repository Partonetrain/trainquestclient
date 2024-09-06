package info.partonetrain.trainquestclient.mixin;

import dev.yurisuika.raised.api.RaisedApi;
import dev.yurisuika.raised.util.properties.Element;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import vectorwing.farmersdelight.client.gui.NourishmentHungerOverlay;

@Mixin(NourishmentHungerOverlay.class)
public class NourishmentHungerOverlayMixin {
    @ModifyArg(method = "renderNourishmentOverlay", at=@At(value = "INVOKE", target = "Lvectorwing/farmersdelight/client/gui/NourishmentHungerOverlay;drawNourishmentOverlay(Lnet/minecraft/world/food/FoodData;Lnet/minecraft/client/Minecraft;Lnet/minecraft/client/gui/GuiGraphics;IIZ)V"), index = 4)
    private static int trainquestclient_addRaisedToNourishment(int top){
        return top - RaisedApi.getY(Element.HOTBAR);
    }
}

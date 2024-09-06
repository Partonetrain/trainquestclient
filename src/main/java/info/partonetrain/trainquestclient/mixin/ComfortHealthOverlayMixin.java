package info.partonetrain.trainquestclient.mixin;

import dev.yurisuika.raised.api.RaisedApi;
import dev.yurisuika.raised.util.properties.Element;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import vectorwing.farmersdelight.client.gui.ComfortHealthOverlay;

@Mixin(ComfortHealthOverlay.class)
public class ComfortHealthOverlayMixin {
    @ModifyArg(method = "renderComfortOverlay", at=@At(value = "INVOKE", target = "Lvectorwing/farmersdelight/client/gui/ComfortHealthOverlay;drawComfortOverlay(Lnet/minecraft/world/entity/player/Player;Lnet/minecraft/client/Minecraft;Lnet/minecraft/client/gui/GuiGraphics;II)V"), index = 4)
    private static int trainquestclient_addRaisedToComfort(int top){
        return top - RaisedApi.getY(Element.HOTBAR);
    }

    @ModifyVariable(method = "drawComfortOverlay(Lnet/minecraft/world/entity/player/Player;Lnet/minecraft/client/Minecraft;Lnet/minecraft/client/gui/GuiGraphics;II)V", at= @At(value = "INVOKE_ASSIGN", target = "Lnet/minecraft/util/Mth;ceil(F)I", ordinal = 2), index = 12)
    private static int trainquestclient_comfortOneRow(int value){
        return 1;
    }
}

package info.partonetrain.trainquestclient.mixin;

import info.partonetrain.trainquestclient.Trainquestclient;
import net.minecraft.client.gui.screens.inventory.HorseInventoryScreen;
import net.minecraft.client.gui.screens.inventory.MerchantScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import pm.c7.scout.client.ScoutUtilClient;
import net.minecraft.client.gui.screens.Screen;

@Mixin(ScoutUtilClient.class)
public class ScoutUtilClientMixin {
    @Inject(method = "isScreenBlacklisted", at = @At("HEAD"), cancellable = true)
    private static void trainquestclient_cancelScoutPouchRender(Screen screen, CallbackInfoReturnable<Boolean> cir){
        if(Trainquestclient.attributesGuiOpen){
            cir.setReturnValue(true);
        }
        if(screen instanceof MerchantScreen || screen instanceof HorseInventoryScreen){
            cir.setReturnValue(true);
        }
    }
}

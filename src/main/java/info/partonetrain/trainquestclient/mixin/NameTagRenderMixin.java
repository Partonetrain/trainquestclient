package info.partonetrain.trainquestclient.mixin;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EntityRenderer.class)
public class NameTagRenderMixin {
    @Inject(method = "renderNameTag", at = @At("HEAD"), cancellable = true)
    public void trainquestclient_dontRenderPortalNametag(Entity entity, Component component, PoseStack poseStack, MultiBufferSource multiBufferSource, int i, CallbackInfo ci){
        if(entity.getName().getString().equalsIgnoreCase("hexblade portal")){
            ci.cancel();
        }
    }
}

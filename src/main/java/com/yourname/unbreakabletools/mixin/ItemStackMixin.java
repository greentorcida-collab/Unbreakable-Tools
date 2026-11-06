package com.yourname.unbreakabletools.mixin;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ItemStack.class)
public class ItemStackMixin {

    @Inject(method = "isDamageable", at = @At("HEAD"), cancellable = true)
    private void makeToolsUnbreakable(CallbackInfoReturnable<Boolean> cir) {
        ItemStack stack = (ItemStack) (Object) this;
        // Jika item tersebut adalah alat (kapak, pedang, dll), buat tidak bisa rusak
        if (stack.getItem() instanceof ToolItem) {
            cir.setReturnValue(false);
        }
    }
}

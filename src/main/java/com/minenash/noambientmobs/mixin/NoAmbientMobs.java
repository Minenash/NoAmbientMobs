package com.minenash.noambientmobs.mixin;

import net.minecraft.entity.SpawnGroup;
import net.minecraft.world.biome.SpawnSettings;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(SpawnSettings.Builder.class)
public class NoAmbientMobs {
	@Inject(method = "spawn", at = @At("HEAD"), cancellable = true)
	private void addSpawn(SpawnGroup group, SpawnSettings.SpawnEntry spawnEntry, CallbackInfoReturnable<SpawnSettings.Builder> info) {
		if (group == SpawnGroup.AMBIENT)
			info.cancel();
	}
}

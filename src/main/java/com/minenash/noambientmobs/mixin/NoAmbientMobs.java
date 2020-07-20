package com.minenash.noambientmobs.mixin;

import net.minecraft.entity.SpawnGroup;
import net.minecraft.world.biome.Biome;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Biome.class)
public class NoAmbientMobs {
	@Inject(method = "addSpawn", at = @At("HEAD"), cancellable = true)
	private void addSpawn(SpawnGroup group, Biome.SpawnEntry spawnEntry, CallbackInfo info) {
		if (group == SpawnGroup.AMBIENT)
			info.cancel();
	}
}

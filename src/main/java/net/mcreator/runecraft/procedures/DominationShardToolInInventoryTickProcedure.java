package net.mcreator.runecraft.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.runecraft.RunecraftModElements;

@RunecraftModElements.ModElement.Tag
public class DominationShardToolInInventoryTickProcedure extends RunecraftModElements.ModElement {
	public DominationShardToolInInventoryTickProcedure(RunecraftModElements instance) {
		super(instance, 76);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure DominationShardToolInInventoryTick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.STRENGTH, (int) 1, (int) 5));
	}
}

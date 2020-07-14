package net.mcreator.runecraft.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.runecraft.RunecraftModElements;

@RunecraftModElements.ModElement.Tag
public class ResolveToolInHandTickProcedure extends RunecraftModElements.ModElement {
	public ResolveToolInHandTickProcedure(RunecraftModElements instance) {
		super(instance, 79);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure ResolveToolInHandTick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.REGENERATION, (int) 5, (int) 1));
	}
}

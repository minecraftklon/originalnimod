package net.mcreator.oryginlnmod.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.oryginlnmod.OryginlnModModElements;
import net.mcreator.oryginlnmod.OryginlnModMod;

import java.util.Map;

@OryginlnModModElements.ModElement.Tag
public class GiveShieldProcedure extends OryginlnModModElements.ModElement {
	public GiveShieldProcedure(OryginlnModModElements instance) {
		super(instance, 22);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				OryginlnModMod.LOGGER.warn("Failed to load dependency entity for procedure GiveShield!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.RESISTANCE, (int) 2, (int) 30, (false), (false)));
	}
}

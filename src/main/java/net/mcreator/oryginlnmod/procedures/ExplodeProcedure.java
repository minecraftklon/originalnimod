package net.mcreator.oryginlnmod.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.world.Explosion;

import net.mcreator.oryginlnmod.OryginlnModModElements;
import net.mcreator.oryginlnmod.OryginlnModMod;

import java.util.Map;

@OryginlnModModElements.ModElement.Tag
public class ExplodeProcedure extends OryginlnModModElements.ModElement {
	public ExplodeProcedure(OryginlnModModElements instance) {
		super(instance, 6);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				OryginlnModMod.LOGGER.warn("Failed to load dependency x for procedure Explode!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				OryginlnModMod.LOGGER.warn("Failed to load dependency y for procedure Explode!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				OryginlnModMod.LOGGER.warn("Failed to load dependency z for procedure Explode!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				OryginlnModMod.LOGGER.warn("Failed to load dependency world for procedure Explode!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (world instanceof World && !((World) world).isRemote) {
			((World) world).createExplosion(null, (int) x, (int) y, (int) z, (float) 4, Explosion.Mode.BREAK);
		}
	}
}

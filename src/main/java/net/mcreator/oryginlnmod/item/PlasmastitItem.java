
package net.mcreator.oryginlnmod.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.entity.Entity;
import net.minecraft.block.BlockState;

import net.mcreator.oryginlnmod.procedures.GiveShieldProcedure;
import net.mcreator.oryginlnmod.OryginlnModModElements;

import java.util.Map;
import java.util.HashMap;

@OryginlnModModElements.ModElement.Tag
public class PlasmastitItem extends OryginlnModModElements.ModElement {
	@ObjectHolder("oryginln_mod:plasmastit")
	public static final Item block = null;
	public PlasmastitItem(OryginlnModModElements instance) {
		super(instance, 22);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(ItemGroup.COMBAT).maxStackSize(0).isImmuneToFire().rarity(Rarity.COMMON));
			setRegistryName("plasmastit");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}

		@Override
		public void inventoryTick(ItemStack itemstack, World world, Entity entity, int slot, boolean selected) {
			super.inventoryTick(itemstack, world, entity, slot, selected);
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			if (selected) {
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				GiveShieldProcedure.executeProcedure($_dependencies);
			}
		}
	}
}

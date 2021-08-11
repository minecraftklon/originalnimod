
package net.mcreator.oryginlnmod.item;

@OryginlnModModElements.ModElement.Tag
public class EnergiswordItem extends OryginlnModModElements.ModElement {

	@ObjectHolder("oryginln_mod:energisword")
	public static final Item block = null;

	public EnergiswordItem(OryginlnModModElements instance) {
		super(instance, 21);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 200;
			}

			public float getEfficiency() {
				return 4f;
			}

			public float getAttackDamage() {
				return 18f;
			}

			public int getHarvestLevel() {
				return 1;
			}

			public int getEnchantability() {
				return 0;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}
		}, 3, -2.5f, new Item.Properties().group(ItemGroup.COMBAT)) {

		}.setRegistryName("energisword"));
	}

}

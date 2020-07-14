
package net.mcreator.runecraft.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import net.mcreator.runecraft.procedures.DominationShardToolInInventoryTickProcedure;
import net.mcreator.runecraft.itemgroup.RunecraftItemGroup;
import net.mcreator.runecraft.RunecraftModElements;

@RunecraftModElements.ModElement.Tag
public class DominationShardItem extends RunecraftModElements.ModElement {
	@ObjectHolder("runecraft:domination_shard")
	public static final Item block = null;
	public DominationShardItem(RunecraftModElements instance) {
		super(instance, 76);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 99999;
			}

			public float getEfficiency() {
				return 4f;
			}

			public float getAttackDamage() {
				return 8f;
			}

			public int getHarvestLevel() {
				return 1;
			}

			public int getEnchantability() {
				return 20;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(Blocks.STONE, (int) (1)));
			}
		}, 3, -3f, new Item.Properties().group(RunecraftItemGroup.tab)) {
			@Override
			public void inventoryTick(ItemStack itemstack, World world, Entity entity, int slot, boolean selected) {
				super.inventoryTick(itemstack, world, entity, slot, selected);
				int x = (int) entity.getPosX();
				int y = (int) entity.getPosY();
				int z = (int) entity.getPosZ();
				{
					java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
					$_dependencies.put("entity", entity);
					DominationShardToolInInventoryTickProcedure.executeProcedure($_dependencies);
				}
			}

			@Override
			@OnlyIn(Dist.CLIENT)
			public boolean hasEffect(ItemStack itemstack) {
				return true;
			}
		}.setRegistryName("domination_shard"));
	}
}

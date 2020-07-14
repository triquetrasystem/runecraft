
package net.mcreator.runecraft.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.runecraft.item.RuneterraItem;
import net.mcreator.runecraft.RunecraftModElements;

@RunecraftModElements.ModElement.Tag
public class RunecraftItemGroup extends RunecraftModElements.ModElement {
	public RunecraftItemGroup(RunecraftModElements instance) {
		super(instance, 73);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabrunecraft") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(RuneterraItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundImageName("item_search.png");
	}
	public static ItemGroup tab;
}

package wundr.endadvance.item.tool;

import jline.internal.Nullable;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import wundr.endadvance.EnderAdvancement;

/**
 * It's the Ender Pickaxe<br>
 * Copyright (c) 2016-2017 wundrweapon<br>
 * Credits to happygill16 for making the foundations for this file
 * @author wundrweapon
 */
public class EnderPickaxe extends ItemPickaxe {
	private static final String NAME = "pick";
	
	/**
	 * Ender Pickaxe constructor
	 */
	public EnderPickaxe() {
		super(EnderAdvancement.ENDERIUM);
		setRegistryName(new ResourceLocation(EnderAdvancement.MOD_ID + ":" + NAME));
		setUnlocalizedName(EnderAdvancement.MOD_ID + "_" + NAME);
	}
	
	/**
	 * Adds <i>Duper</i> when crafted
	 * @param stack the {@link ItemStack} containing the pickaxe
	 * @param world the {@link World} in which the pickaxe exists (unused)
	 * @param player the {@link EntityPlayer} who made the stack (unused)
	 */
	@Override
	public void onCreated(ItemStack stack, @Nullable World world, @Nullable EntityPlayer player) {
		stack.addEnchantment(EnderAdvancement.DUPER, 1);
	}
	
	/**
	 * Applies <i>Duper</i> to the pickaxe in the creative inventory
	 * @param tab the tab containing the pickaxe
	 * @param items the complete list of items in the tab
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
		super.getSubItems(tab, items); //Prevents skipping important code
		
		//Iterates through the tab and adds Duper only to Ender Pickaxe stacks
		for(ItemStack stack : items) {
			if(stack.getItem() instanceof EnderPickaxe) {
				stack.addEnchantment(EnderAdvancement.DUPER, 1);
			}
		}
	}
}

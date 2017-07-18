package wundr.endadvance.item.tool;

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
 * Copyright (c) 2016-2017 wundrweapon<br>
 * Credits to happygill16 for making the foundations for this file
 * @author wundrweapon
 */
public class EnderPickaxe extends ItemPickaxe {
	private final String name = "pick";
	
	public EnderPickaxe(ToolMaterial material) {
		super(material);
		setRegistryName(new ResourceLocation(EnderAdvancement.MOD_ID + ":" + name));
		setUnlocalizedName(EnderAdvancement.MOD_ID + "_" + name);
	}
	
	@Override
	public void onCreated(ItemStack stack, World world, EntityPlayer player) {
		stack.addEnchantment(EnderAdvancement.DUPER, 1);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
		super.getSubItems(tab, items);
		
		for(ItemStack stack : items) {
			if(stack.getItem() instanceof EnderPickaxe) {
				stack.addEnchantment(EnderAdvancement.DUPER, 1);
			}
		}
	}
}

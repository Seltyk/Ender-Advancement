package wundr.enderAdvancement.item.tool;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import wundr.enderAdvancement.EnderAdvancement;
import wundr.enderAdvancement.item.IEnderItem;

import java.util.List;

/**
 * Copyright (c) 2016-2017 wundrweapon<br>
 * Credits to happygill16 for making the foundations for this file
 * @author wundrweapon
 */
public class EnderPickaxe extends ItemPickaxe implements IEnderItem {
	private static String name = "pick";
	public static final ResourceLocation REGISTRY_RL = new ResourceLocation(EnderAdvancement.MOD_ID + ":" + name);
	
	public EnderPickaxe(ToolMaterial material) {
		super(material);
		setRegistryName(REGISTRY_RL);
		setUnlocalizedName(EnderAdvancement.MOD_ID + "_" + name);
	}
	
	@Override
	public void onCreated(ItemStack stack, World world, EntityPlayer player) {
		stack.addEnchantment(EnderAdvancement.DUPER, 1);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(Item item, CreativeTabs tab, List<ItemStack> subItems) {
		super.getSubItems(item, tab, subItems);
		
		for(ItemStack stack : subItems) {
			stack.addEnchantment(EnderAdvancement.DUPER, 1);
		}
	}
}

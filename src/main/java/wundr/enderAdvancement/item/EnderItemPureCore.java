package wundr.enderAdvancement.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import wundr.enderAdvancement.Main;

/**
 * Copyright (c) 2016 wundrweapon<br>
 * Credits to happygill16 for making the foundations for this file
 * 
 * @author wundrweapon
 */
public class EnderItemPureCore extends Item {
	private static String name = "pure_core";
	public static final ResourceLocation REGISTRY_RL = new ResourceLocation(Main.MOD_ID + ":" + name);
	
	public EnderItemPureCore() {
		setRegistryName(REGISTRY_RL);
		setUnlocalizedName(Main.MOD_ID + "_" + name);
		setMaxDamage(50);
		setMaxStackSize(16);
	}
	
	@Override
	public boolean isRepairable() {
		return false;
	}
	
	@Override
	public boolean getIsRepairable(ItemStack input, ItemStack repairer) {
		return false;
	}
}

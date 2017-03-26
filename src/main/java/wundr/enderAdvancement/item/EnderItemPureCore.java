package wundr.enderAdvancement.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import wundr.enderAdvancement.EnderAdvancement;

/**
 * Copyright (c) 2016-2017 wundrweapon<br>
 * Credits to happygill16 for making the foundations for this file
 * @author wundrweapon
 */
public class EnderItemPureCore extends Item implements IEnderItem {
	private static String name = "pure_core";
	public static final ResourceLocation REGISTRY_RL = new ResourceLocation(EnderAdvancement.MOD_ID + ":" + name);
	
	public EnderItemPureCore() {
		setRegistryName(REGISTRY_RL);
		setUnlocalizedName(EnderAdvancement.MOD_ID + "_" + name);
		setMaxDamage(50);
		setMaxStackSize(16);
	}
	
	@Override
	public boolean isRepairable() {
		return false;
	}
}

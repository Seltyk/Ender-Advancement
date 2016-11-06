package wundr.enderAdvancement.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import wundr.enderAdvancement.Main;

/**
 * Copyright (c) 2016 wundrweapon<br>
 * Credits happygill16 for making the foundations for this file
 * 
 * @author wundrweapon
 */
public class EnderItemPureCore extends Item {
	public EnderItemPureCore() {
		setRegistryName(new ResourceLocation(Main.MOD_ID + ":pure_core"));
		setUnlocalizedName(Main.MOD_ID + "_pureEnderCore");
		setMaxDamage(50);
		setMaxStackSize(1);
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

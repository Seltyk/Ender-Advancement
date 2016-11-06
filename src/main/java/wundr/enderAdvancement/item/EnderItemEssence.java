package wundr.enderAdvancement.item;

import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import wundr.enderAdvancement.Main;

/**
 * Copyright (c) 2016 wundrweapon<br>
 * Credits happygill16 for making the foundations for this file
 * 
 * @author wundrweapon
 */
public class EnderItemEssence extends Item {
	public EnderItemEssence() {
		setRegistryName(new ResourceLocation(Main.MOD_ID + ":essence"));
		setUnlocalizedName(Main.MOD_ID + "_enderEssence");
	}
}

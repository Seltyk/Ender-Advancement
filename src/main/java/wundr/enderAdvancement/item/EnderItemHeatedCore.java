package wundr.enderAdvancement.item;

import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import wundr.enderAdvancement.EnderAdvancement;

/**
 * Copyright (c) 2016-2017 wundrweapon<br>
 * Credits to happygill16 for making the foundations for this file
 * @author wundrweapon
 */
public class EnderItemHeatedCore extends Item implements IEnderItem {
	private static String name = "heated_core";
	public static final ResourceLocation REGISTRY_RL = new ResourceLocation(EnderAdvancement.MOD_ID + ":" + name);
	
	public EnderItemHeatedCore() {
		setRegistryName(REGISTRY_RL);
		setUnlocalizedName(EnderAdvancement.MOD_ID + "_" + name);
	}
}

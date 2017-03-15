package wundr.enderAdvancement.item.tool;

import net.minecraft.item.ItemAxe;
import net.minecraft.util.ResourceLocation;
import wundr.enderAdvancement.EnderAdvancement;

/**
 * Copyright (c) 2016-2017 wundrweapon<br>
 * Credits to happygill16 for making the foundations for this file
 * @author wundrweapon
 */
public class EnderAxe extends ItemAxe {
	private static String name = "axe";
	public static final ResourceLocation REGISTRY_RL = new ResourceLocation(EnderAdvancement.MOD_ID + ":" + name);
	
	public EnderAxe(ToolMaterial material) {
		super(material, 12, -2.8f);
		setRegistryName(REGISTRY_RL);
		setUnlocalizedName(EnderAdvancement.MOD_ID + "_" + name);
	}
}

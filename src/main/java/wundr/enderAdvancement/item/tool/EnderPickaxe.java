package wundr.enderAdvancement.item.tool;

import net.minecraft.item.ItemPickaxe;
import net.minecraft.util.ResourceLocation;
import wundr.enderAdvancement.EnderAdvancement;

/**
 * Copyright (c) 2016-2017 wundrweapon<br>
 * Credits to happygill16 for making the foundations for this file
 * @author wundrweapon
 */
public class EnderPickaxe extends ItemPickaxe {
	private static String name = "pick";
	public static final ResourceLocation REGISTRY_RL = new ResourceLocation(EnderAdvancement.MOD_ID + ":" + name);
	
	public EnderPickaxe(ToolMaterial material) {
		super(material);
		setRegistryName(REGISTRY_RL);
		setUnlocalizedName(EnderAdvancement.MOD_ID + "_" + name);
	}
}

package wundr.endadvance.item.tool;

import net.minecraft.item.ItemAxe;
import net.minecraft.util.ResourceLocation;
import wundr.endadvance.EnderAdvancement;
import wundr.endadvance.item.IEnderItem;

/**
 * Copyright (c) 2016-2017 wundrweapon<br>
 * Credits to happygill16 for making the foundations for this file
 * @author wundrweapon
 */
public class EnderAxe extends ItemAxe implements IEnderItem {
	private static final String NAME = "axe";
	public static final ResourceLocation REGISTRY_RL = new ResourceLocation(EnderAdvancement.MOD_ID + ":" + NAME);
	
	public EnderAxe(ToolMaterial material) {
		super(material, 12, -2.8f);
		setRegistryName(REGISTRY_RL);
		setUnlocalizedName(EnderAdvancement.MOD_ID + "_" + NAME);
	}
}

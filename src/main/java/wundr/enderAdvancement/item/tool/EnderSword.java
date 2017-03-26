package wundr.enderAdvancement.item.tool;

import net.minecraft.item.ItemSword;
import net.minecraft.util.ResourceLocation;
import wundr.enderAdvancement.EnderAdvancement;
import wundr.enderAdvancement.item.IEnderItem;

/**
 * Copyright (c) 2016-2017 wundrweapon<br>
 * Credits to happygill16 for making the foundations for this file
 * @author wundrweapon
 */
public class EnderSword extends ItemSword implements IEnderItem {
	private static String name = "sword";
	public static final ResourceLocation REGISTRY_RL = new ResourceLocation(EnderAdvancement.MOD_ID + ":" + name);
	
	public EnderSword(ToolMaterial material)  {
		super(material);
		setRegistryName(REGISTRY_RL);
		setUnlocalizedName(EnderAdvancement.MOD_ID + "_" + name);
	}
}

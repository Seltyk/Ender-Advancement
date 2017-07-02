package wundr.endadvance.item.tool;

import net.minecraft.item.ItemSword;
import net.minecraft.util.ResourceLocation;
import wundr.endadvance.EnderAdvancement;
import wundr.endadvance.item.IEnderItem;

/**
 * Copyright (c) 2016-2017 wundrweapon<br>
 * Credits to happygill16 for making the foundations for this file
 * @author wundrweapon
 */
public class EnderSword extends ItemSword implements IEnderItem {
	private static final String NAME = "sword";
	public static final ResourceLocation REGISTRY_RL = new ResourceLocation(EnderAdvancement.MOD_ID + ":" + NAME);
	
	public EnderSword(ToolMaterial material)  {
		super(material);
		setRegistryName(REGISTRY_RL);
		setUnlocalizedName(EnderAdvancement.MOD_ID + "_" + NAME);
	}
}

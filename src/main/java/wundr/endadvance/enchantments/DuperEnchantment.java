package wundr.endadvance.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.inventory.EntityEquipmentSlot;

import wundr.endadvance.EnderAdvancement;

/**
 * Copyright (c) 2016-2017 wundrweapon<br>
 * Credits to happygill16 for making the foundations for this file
 * @author wundrweapon
 */
public class DuperEnchantment extends Enchantment {
	private static final String NAME = "duper";
	public static final String REGISTRY_RL = EnderAdvancement.MOD_ID + ":" + NAME;
	
	public DuperEnchantment(Rarity rarity, EnumEnchantmentType enchType, EntityEquipmentSlot[] slots) {
		super(rarity, enchType, slots);
		setName(NAME);
		setRegistryName(REGISTRY_RL);
	}
	
	@Override
	public int getMinEnchantability(int enchLvl) {
		return 20;
	}
	
	@Override
	public int getMaxEnchantability(int enchLvl) {
		return Integer.MAX_VALUE;
	}
}

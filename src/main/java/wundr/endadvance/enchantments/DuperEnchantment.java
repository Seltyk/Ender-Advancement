package wundr.endadvance.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.util.ResourceLocation;
import wundr.endadvance.EnderAdvancement;

/**
 * The class defining the <i>Duper</i> enchantment<br>
 * Copyright (c) 2016-2017 wundrweapon<br>
 * Credits to happygill16 for making the foundations for this file
 * @author wundrweapon
 */
public class DuperEnchantment extends Enchantment {
	private static final String NAME = "duper";
	
	/**
	 * @param rarity how commonly this enchantment pops up
	 * @param enchType what this enchantment can be put on
	 * @param slots in what equipment slots this enchantment is used
	 */
	public DuperEnchantment(Rarity rarity, EnumEnchantmentType enchType, EntityEquipmentSlot[] slots) {
		super(rarity, enchType, slots);
		setName(NAME);
		setRegistryName(new ResourceLocation(EnderAdvancement.MOD_ID + ":" + NAME));
	}
	
	/**
	 * The minimum enchantability of <i>Duper</i>
	 * @param enchLvl the level the player is trying to enchant at (always 1)
	 * @return 20 - always
	 */
	@Override
	public int getMinEnchantability(int enchLvl) {
		return 20;
	}
	
	/**
	 * The maximum enchantability of <i>Duper</i>
	 * @param enchLvl the level the player is trying to enchant at (always 1)
	 * @return {@link Integer#MAX_VALUE}, to be a minimum-only setup
	 */
	@Override
	public int getMaxEnchantability(int enchLvl) {
		return Integer.MAX_VALUE;
	}
}

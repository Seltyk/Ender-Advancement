package wundr.enderAdvancement.eventHandlers;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import wundr.enderAdvancement.EnderAdvancement;

/**
 * Copyright (c) 2016-2017 wundrweapon
 * @author wundrweapon
 */
@EventBusSubscriber
public class Registry {
	
	@SubscribeEvent
	public static void registerItems(Register<Item> registry) {
		registry.getRegistry().registerAll(EnderAdvancement.ITEMS);
	}
	
	@SubscribeEvent
	public static void registerEnchantments(Register<Enchantment> registry) {
		registry.getRegistry().registerAll(EnderAdvancement.DUPER);
	}
}

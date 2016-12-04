package wundr.enderAdvancement.eventHandlers;

import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import wundr.enderAdvancement.Main;
import wundr.enderAdvancement.item.tool.EnderPickaxe;
import wundr.modutils.Booleans;

/**
 * Copyright (c) 2016 wundrweapon<br>
 * Credits to happygill16 for making the original version of this file
 * 
 * @author wundrweapon
 */
@EventBusSubscriber
public class HarvestDropsEventHandler {

	@SubscribeEvent
	public static void onHarvestDrops(HarvestDropsEvent event) {
		try {
			if((Booleans.isEnchanted(Main.DUPER, event.getHarvester().getHeldItemMainhand()) || event.getHarvester().getHeldItemMainhand().getItem() instanceof EnderPickaxe) && event.getState().getBlock().getLocalizedName().contains(" Ore")) {
				List<ItemStack> drops = event.getDrops();
				event.setDropChance(1);
				event.getDrops().addAll(drops);
			}
		} catch(NullPointerException e) {
			return;
		}
	}
}

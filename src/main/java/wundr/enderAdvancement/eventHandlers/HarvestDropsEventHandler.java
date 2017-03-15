package wundr.enderAdvancement.eventHandlers;

import java.util.List;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemBlockSpecial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import wundr.enderAdvancement.EnderAdvancement;
import wundr.enderAdvancement.item.tool.EnderPickaxe;
import wundr.modutils.Booleans;

/**
 * Copyright (c) 2016-2017 wundrweapon<br>
 * Credits to happygill16 for making the original version of this file
 * @author wundrweapon
 */
@EventBusSubscriber
public class HarvestDropsEventHandler {

	@SubscribeEvent
	public static void onHarvestDrops(HarvestDropsEvent event) {
		if(event.getHarvester() != null && event.getHarvester().getActiveItemStack() != null && (Booleans.isEnchanted(EnderAdvancement.DUPER, event.getHarvester().getActiveItemStack()) || event.getHarvester().getActiveItemStack().getItem() instanceof EnderPickaxe)) {
			List<ItemStack> dropsCopy = event.getDrops();
			
			for(ItemStack drop : dropsCopy) {
				if(!(drop.getItem() instanceof ItemBlock || drop.getItem() instanceof ItemBlockSpecial)) {
					event.getDrops().add(drop.copy());
				}
			}
		}
	}
}

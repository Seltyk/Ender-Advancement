package wundr.enderAdvancement.eventHandlers;

import java.util.Random;

import net.minecraft.entity.monster.EntityEnderman;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import wundr.enderAdvancement.Main;

/**
 * Copyright (c) 2016 wundrweapon<br>
 * Credits happygill16 for making the foundations for this file
 * 
 * @author wundrweapon
 */
@EventBusSubscriber
public class LivingDeathEventHandler {
	private static int oneChance, twoChance;
	
	public LivingDeathEventHandler(int singleChance, int doubleChance) {
		oneChance = singleChance;
		twoChance = doubleChance;
	}
	
	@SubscribeEvent
	public static void onLivingDeath(LivingDeathEvent event) {
		if(event.getEntity() instanceof EntityEnderman) {
			Random rand = new Random();
			
			if(rand.nextInt(oneChance) == oneChance - 1) {
				if(rand.nextInt(twoChance) == twoChance - 1) {
					event.getEntity().dropItem(Main.enderEssence, 2);
				} else {
					event.getEntity().dropItem(Main.enderEssence, 1);
				}
			}
		}
	}
}

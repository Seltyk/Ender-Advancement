package wundr.enderAdvancement.eventHandlers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumParticleTypes;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import wundr.enderAdvancement.item.EnderItemEssence;

/**
 * Copyright (c) 2016 wundrweapon<br>
 * Credits to Mojang, as the spawnParticle parameters used are from their code
 * 
 * @author wundrweapon
 * @see net.minecraft.entity.monster.EntityEnderman
 */
@EventBusSubscriber
public class LivingUpdateEventHandler {
	private static EntityPlayer player;
	
	@SubscribeEvent
	public static void onLivingUpdate(LivingUpdateEvent event) {
		if(event.getEntity() instanceof EntityPlayer) {
			player = (EntityPlayer) event.getEntity();
			
			try {
				if((player.getHeldItemMainhand().getItem() instanceof EnderItemEssence || player.getHeldItemOffhand().getItem() instanceof EnderItemEssence) && player.worldObj.isRemote) {
					player.worldObj.spawnParticle(EnumParticleTypes.PORTAL, player.posX + (player.worldObj.rand.nextDouble() - .5) * (double) player.width, player.posY + player.worldObj.rand.nextDouble() * (double) player.height - .25, player.posZ + (player.worldObj.rand.nextDouble() - .5) * (double) player.width, (player.worldObj.rand.nextDouble() - .5) * 2, -player.worldObj.rand.nextDouble(), (player.worldObj.rand.nextDouble() - .5) * 2, new int[0]);
					player.worldObj.spawnParticle(EnumParticleTypes.PORTAL, player.posX + (player.worldObj.rand.nextDouble() - .5) * (double) player.width, player.posY + player.worldObj.rand.nextDouble() * (double) player.height - .25, player.posZ + (player.worldObj.rand.nextDouble() - .5) * (double) player.width, (player.worldObj.rand.nextDouble() - .5) * 2, -player.worldObj.rand.nextDouble(), (player.worldObj.rand.nextDouble() - .5) * 2, new int[0]);
				}
			} catch(NullPointerException e) {
				return;
			}
		}
	}
}

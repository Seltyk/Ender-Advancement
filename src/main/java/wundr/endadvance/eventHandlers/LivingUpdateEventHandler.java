package wundr.endadvance.eventHandlers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumParticleTypes;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import wundr.endadvance.item.EnderItemEssence;

/**
 * Copyright (c) 2016-2017 wundrweapon<br>
 * Credits to Mojang, as the spawnParticle parameters used are from their code
 * @author wundrweapon
 * @see net.minecraft.entity.monster.EntityEnderman#onLivingUpdate()
 */
@EventBusSubscriber
@SuppressWarnings("unused")
public class LivingUpdateEventHandler {
	
	@SubscribeEvent
	public static void onLivingUpdate(LivingUpdateEvent event) {
		if(event.getEntity() instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.getEntity();
			
			try {
				if((player.getHeldItemMainhand().getItem() instanceof EnderItemEssence || player.getHeldItemOffhand().getItem() instanceof EnderItemEssence) && player.world.isRemote) {
					player.world.spawnParticle(EnumParticleTypes.PORTAL, player.posX + (player.world.rand.nextDouble() - .5) * player.width, player.posY + player.world.rand.nextDouble() * player.height - .25, player.posZ + (player.world.rand.nextDouble() - .5) * player.width, (player.world.rand.nextDouble() - .5) * 2, -player.world.rand.nextDouble(), (player.world.rand.nextDouble() - .5) * 2);
					player.world.spawnParticle(EnumParticleTypes.PORTAL, player.posX + (player.world.rand.nextDouble() - .5) * player.width, player.posY + player.world.rand.nextDouble() * player.height - .25, player.posZ + (player.world.rand.nextDouble() - .5) * player.width, (player.world.rand.nextDouble() - .5) * 2, -player.world.rand.nextDouble(), (player.world.rand.nextDouble() - .5) * 2);
				}
			} catch(NullPointerException e) {}
		}
	}
}

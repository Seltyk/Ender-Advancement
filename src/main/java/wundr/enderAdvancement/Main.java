package wundr.enderAdvancement;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantment.Rarity;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.RecipeSorter;
import net.minecraftforge.oredict.RecipeSorter.Category;
import wundr.enderAdvancement.enchantments.DuperEnchantment;
import wundr.enderAdvancement.item.*;
import wundr.enderAdvancement.item.tool.*;

/**
 * Copyright (c) 2016 wundrweapon<br>
 * Credits happygill16 for making the foundations for this file
 * 
 * @author wundrweapon
 */
@Mod(modid = Main.MOD_ID, useMetadata = true)
public class Main {
	public static final String MOD_ID = "enderadvancement";
	
	public static boolean teleportStuck;
	public static boolean teleportAir;
	public static boolean fallDamage;
	public static int singleChance;
	public static int doubleChance;
	public static double teleportDistance;
	
	@SidedProxy(clientSide = "wundr.enderAdvancement.ClientProxy", modId = MOD_ID)
	private static IProxy proxy;
	
	public static ToolMaterial enderium = EnumHelper.addToolMaterial("enderium", 5, -1, 12, 4, 22);
	public static Item bebpd = new EnderItemTeleportWand();
	public static Item enderEssence = new EnderItemEssence();
	public static Item heatedEnderCore = new EnderItemHeatedCore();
	public static Item impureEnderCore = new EnderItemImpureCore();
	public static Item pureEnderCore = new EnderItemPureCore();
	public static Item enderInfusedTwig = new EnderItemStick();
	public static ItemAxe enderAxe = new EnderAxe(enderium);
	public static ItemPickaxe enderPickaxe = new EnderPickaxe(enderium);
	public static ItemSpade enderShovel = new EnderShovel(enderium);
	public static ItemSword enderSword = new EnderSword(enderium);
	public static IRecipe dupeRecipe = new ItemDupeRecipe();
	public static Enchantment duper = new DuperEnchantment(Rarity.VERY_RARE, EnumEnchantmentType.DIGGER, new EntityEquipmentSlot[] {EntityEquipmentSlot.MAINHAND});
  
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		setConfig(event);
		proxy.setModels();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		setRecipes();
		setTabs();
	}
	
	private void setConfig(FMLPreInitializationEvent event) {
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		
		config.setCategoryComment("Biopneumatic End-Based Phasing Device", "Player-selected buffs/nerfs for the BEBPD");
		config.setCategoryComment("Ender Essence", "Ender Essence drop rate");
		
		teleportStuck = config.getBoolean("Teleport into blocks", "Biopneumatic End-Based Phasing Device", false, "If true, teleporting to a block which will get you stuck will not be prevented");
		teleportAir = config.getBoolean("Teleport to air", "Biopneumatic End-Based Phasing Device", false, "If true, trying to teleport to nothing will teleport atop the air block [max distance] blocks ahead of cursor");
		fallDamage = config.getBoolean("Disable fall damage", "Biopneumatic End-Based Phasing Device", false, "If true, teleporting will negate fall damage");
		teleportDistance = config.getFloat("Teleport distance", "Biopneumatic End-Based Phasing Device", 50, 0, Float.MAX_VALUE, "Farthest the BEDPD will allow for teleportation. Be rational, especially with render distance, to prevent breaking things");
		singleChance = config.getInt("Chance for single drop", "Ender Essence", 32, 1, Integer.MAX_VALUE, "The chance that an Enderman will drop Ender Essence when it drops something else. Chance is 1 divided by input value. Using the max number may break things, so be rational.");
		doubleChance = config.getInt("Chance for a double drop", "Ender Essence", 2, 1, Integer.MAX_VALUE, "The chance of getting 2 Ender Essence instead of 1. Calculated as (chance of one) * (1 divided by input). Using a number too high will break things, so be rational.");
		
		config.save();
	}
	
	private void setRecipes() {
		
		//Biopneumatic End-Based Phasing Device from Ender Pearl and Ender Infused Twig x2
		GameRegistry.addRecipe(new ItemStack(bebpd), new Object[] {"P  ", "T  ", "T  ", 'P', Items.ENDER_PEARL, 'T', enderInfusedTwig});
		
		//Impure Ender Core from Ender Essence x4, Ender Pearl x4, and Ender Eye
		GameRegistry.addRecipe(new ItemStack(impureEnderCore), new Object[] {"EPE", "PYP", "EPE", 'E', enderEssence, 'P', Items.ENDER_PEARL, 'Y', Items.ENDER_EYE});
		
		//Heated Ender Core from Impure Ender Core
		GameRegistry.addSmelting(impureEnderCore, new ItemStack(heatedEnderCore), .5f);
		
		//Pure Ender Core from Ender Essence x4, Iron Ingot x4, and Heated Ender Core
		GameRegistry.addRecipe(new ItemStack(pureEnderCore), new Object[] {"EIE", "IHI", "EIE", 'E', enderEssence, 'I', Items.IRON_INGOT, 'H', heatedEnderCore});
		
		//Ender Infused Twig x4 from Stick x2 and Pure Ender Core
		GameRegistry.addRecipe(new ItemStack(enderInfusedTwig, 4), new Object[] {"S  ", "P  ", "S  ", 'S', Items.STICK, 'P', pureEnderCore});
		
		//Ender Pickaxe from Ender Eye x3 and Ender Infused Twig x2
		GameRegistry.addRecipe(new ItemStack(enderPickaxe), new Object[] {"EEE", " T ", " T ", 'E', Items.ENDER_EYE, 'T', enderInfusedTwig});
		
		//Ender Axe from Ender Eye x3 and Ender Infused Twig x2
		GameRegistry.addRecipe(new ItemStack(enderAxe), new Object[] {"EE ", "ET ", " T ", 'E', Items.ENDER_EYE, 'T', enderInfusedTwig});
		
		//Ender Sword from Ender Eye x2 and Ender Infused Twig
		GameRegistry.addRecipe(new ItemStack(enderSword), new Object[] {"E  ", "E  ", "T  ", 'E', Items.ENDER_EYE, 'T', enderInfusedTwig});
		
		//Ender Shovel from Ender Eye and Ender Infused Twig x2
		GameRegistry.addRecipe(new ItemStack(enderShovel), new Object[] { "E  ", "T  ", "T  ", 'E', Items.ENDER_EYE, 'T', enderInfusedTwig});
		
		//Duplication via Pure Ender Core
		RecipeSorter.register("dupeItem", ItemDupeRecipe.class, Category.SHAPELESS, "after:minecraft:shapeless");
		GameRegistry.addRecipe(dupeRecipe);
	}
	
	private void setTabs() {
		CreativeTabs endAdvance = new CreativeTabs("endAdvance") {
			
			@Override
			@SideOnly(Side.CLIENT)
			public Item getTabIconItem() {
				return pureEnderCore;
			}
		};
		
		CreativeTabs endAdvanceTools = new CreativeTabs("endAdvanceTools") {
			
			@Override
			@SideOnly(Side.CLIENT)
			public Item getTabIconItem() {
				return bebpd;
			}
		};
		
		enderEssence.setCreativeTab(endAdvance);
		heatedEnderCore.setCreativeTab(endAdvance);
		impureEnderCore.setCreativeTab(endAdvance);
		pureEnderCore.setCreativeTab(endAdvance);
		enderInfusedTwig.setCreativeTab(endAdvance);
		enderAxe.setCreativeTab(endAdvanceTools);
		bebpd.setCreativeTab(endAdvanceTools);
		enderPickaxe.setCreativeTab(endAdvanceTools);
		enderShovel.setCreativeTab(endAdvanceTools);
		enderSword.setCreativeTab(endAdvanceTools);
	}
}

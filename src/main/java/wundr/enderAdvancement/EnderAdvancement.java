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
 * Copyright (c) 2016-2017 wundrweapon<br>
 * Credits to happygill16 for making the foundations for this file
 * @author wundrweapon
 */
@Mod(modid = EnderAdvancement.MOD_ID, useMetadata = true)
public class EnderAdvancement {
	public static final String MOD_ID = "enderadvancement";
	
	@SidedProxy(clientSide = "wundr.enderAdvancement.ClientProxy")
	private static IProxy proxy;
	
	public static boolean canTeleportDangerously;
	public static boolean canTeleportToAir;
	public static boolean canTakeFallDamageFromTeleport;
	public static int singleChance;
	public static int doubleChance;
	public static double teleportDistance;
	
	public static final ToolMaterial ENDERIUM = EnumHelper.addToolMaterial("enderium", 5, -1, 12, 4, 22);
	public static final Item BEBRD = new EnderItemTeleportWand();
	public static final Item ENDER_ESSENCE = new EnderItemEssence();
	public static final Item HEATED_CORE = new EnderItemHeatedCore();
	public static final Item IMPURE_CORE = new EnderItemImpureCore();
	public static final Item PURE_CORE = new EnderItemPureCore();
	public static final Item ENDER_TWIG = new EnderItemStick();
	public static final ItemAxe AXE_ENDER = new EnderAxe(ENDERIUM);
	public static final ItemPickaxe PICKAXE_ENDER = new EnderPickaxe(ENDERIUM);
	public static final ItemSpade SHOVEL_ENDER = new EnderShovel(ENDERIUM);
	public static final ItemSword SWORD_ENDER = new EnderSword(ENDERIUM);
	public static final IRecipe DUPLICATOR = new ItemDupeRecipe();
	public static final Enchantment DUPER = new DuperEnchantment(Rarity.VERY_RARE, EnumEnchantmentType.DIGGER, new EntityEquipmentSlot[] {EntityEquipmentSlot.MAINHAND});
	
	public static final Item[] ITEMS = {BEBRD, ENDER_ESSENCE, HEATED_CORE, IMPURE_CORE, PURE_CORE, ENDER_TWIG, AXE_ENDER, PICKAXE_ENDER, SHOVEL_ENDER, SWORD_ENDER};
  
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		setConfig(event);
		proxy.setModels();
	}
	
	@EventHandler
	public void init(@SuppressWarnings("unused") FMLInitializationEvent event) {
		setRecipes();
		setTabs();
	}
	
	private static void setConfig(FMLPreInitializationEvent event) {
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		
		config.setCategoryComment("Biopneumatic End-Based Phasing Device", "Player-selected buffs/nerfs for the BEBPD");
		config.setCategoryComment("Ender Essence", "Ender Essence drop rate");
		
		canTeleportDangerously = config.getBoolean("Teleport into blocks", "Biopneumatic End-Based Relocation Device", false, "If true, teleporting to a block which will get you stuck will not be prevented");
		canTeleportToAir = config.getBoolean("Teleport to air", "Biopneumatic End-Based Relocation Device", false, "If true, trying to teleport to nothing will teleport atop the air block [max distance] blocks ahead of crosshairs");
		canTakeFallDamageFromTeleport = config.getBoolean("Disable fall damage", "Biopneumatic End-Based Relocation Device", false, "If true, teleporting will negate fall damage");
		teleportDistance = config.getFloat("Teleport distance", "Biopneumatic End-Based Relocation Device", 50, 0, Float.MAX_VALUE, "Farthest the BEDRD will allow for teleportation. Be rational, especially with render distance, to prevent breaking things");
		singleChance = config.getInt("Chance for single drop", "Ender Essence", 32, 1, Integer.MAX_VALUE, "The chance that an Enderman will drop Ender Essence when it drops something else. Chance is 1 divided by input value. Using the max number may break things, so be rational.");
		doubleChance = config.getInt("Chance for a double drop", "Ender Essence", 2, 1, Integer.MAX_VALUE, "The chance of getting 2 Ender Essence instead of 1. Calculated as (chance of one) * (1 divided by input). Using a number too high will break things, so be rational.");
		
		config.save();
	}
	
	private static void setRecipes() {
		
		//Biopneumatic End-Based Phasing Device from Ender Pearl and Ender Infused Twig x2
		GameRegistry.addRecipe(new ItemStack(BEBRD), new Object[] {"P  ", "T  ", "T  ", 'P', Items.ENDER_PEARL, 'T', ENDER_TWIG});
		
		//Impure Ender Core from Ender Essence x4, Ender Pearl x4, and Ender Eye
		GameRegistry.addRecipe(new ItemStack(IMPURE_CORE), new Object[] {"EPE", "PYP", "EPE", 'E', ENDER_ESSENCE, 'P', Items.ENDER_PEARL, 'Y', Items.ENDER_EYE});
		
		//Heated Ender Core from Impure Ender Core
		GameRegistry.addSmelting(IMPURE_CORE, new ItemStack(HEATED_CORE), .5f);
		
		//Pure Ender Core from Ender Essence x4, Iron Ingot x4, and Heated Ender Core
		GameRegistry.addRecipe(new ItemStack(PURE_CORE), new Object[] {"EIE", "IHI", "EIE", 'E', ENDER_ESSENCE, 'I', Items.IRON_INGOT, 'H', HEATED_CORE});
		
		//Ender Infused Twig x4 from Stick x2 and Pure Ender Core
		GameRegistry.addRecipe(new ItemStack(ENDER_TWIG, 4), new Object[] {"S  ", "P  ", "S  ", 'S', Items.STICK, 'P', PURE_CORE});
		
		//Ender Pickaxe from Ender Eye x3 and Ender Infused Twig x2
		GameRegistry.addRecipe(new ItemStack(PICKAXE_ENDER), new Object[] {"EEE", " T ", " T ", 'E', Items.ENDER_EYE, 'T', ENDER_TWIG});
		
		//Ender Axe from Ender Eye x3 and Ender Infused Twig x2
		GameRegistry.addRecipe(new ItemStack(AXE_ENDER), new Object[] {"EE ", "ET ", " T ", 'E', Items.ENDER_EYE, 'T', ENDER_TWIG});
		
		//Ender Sword from Ender Eye x2 and Ender Infused Twig
		GameRegistry.addRecipe(new ItemStack(SWORD_ENDER), new Object[] {"E  ", "E  ", "T  ", 'E', Items.ENDER_EYE, 'T', ENDER_TWIG});
		
		//Ender Shovel from Ender Eye and Ender Infused Twig x2
		GameRegistry.addRecipe(new ItemStack(SHOVEL_ENDER), new Object[] { "E  ", "T  ", "T  ", 'E', Items.ENDER_EYE, 'T', ENDER_TWIG});
		
		//Duplication via Pure Ender Core
		RecipeSorter.register("dupeItem", ItemDupeRecipe.class, Category.SHAPELESS, "after:minecraft:shapeless");
		GameRegistry.addRecipe(DUPLICATOR);
	}
	
	private static void setTabs() {
		CreativeTabs endAdvance = new CreativeTabs("endAdvance") {
			
			@Override
			@SideOnly(Side.CLIENT)
			public Item getTabIconItem() {
				return PURE_CORE;
			}
		};
		
		CreativeTabs endAdvanceTools = new CreativeTabs("endAdvanceTools") {
			
			@Override
			@SideOnly(Side.CLIENT)
			public Item getTabIconItem() {
				return BEBRD;
			}
		};
		
		ENDER_ESSENCE.setCreativeTab(endAdvance);
		HEATED_CORE.setCreativeTab(endAdvance);
		IMPURE_CORE.setCreativeTab(endAdvance);
		PURE_CORE.setCreativeTab(endAdvance);
		ENDER_TWIG.setCreativeTab(endAdvance);
		AXE_ENDER.setCreativeTab(endAdvanceTools);
		BEBRD.setCreativeTab(endAdvanceTools);
		PICKAXE_ENDER.setCreativeTab(endAdvanceTools);
		SHOVEL_ENDER.setCreativeTab(endAdvanceTools);
		SWORD_ENDER.setCreativeTab(endAdvanceTools);
	}
}

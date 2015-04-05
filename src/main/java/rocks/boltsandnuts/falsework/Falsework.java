package rocks.boltsandnuts.falsework;

/*
 * Check all the classes for (hopefully) detailed descriptions of what it does. There will also be tidbits of comments throughout the codebase.
 * If you wish to add a description to a class, or extend/change an existing one, submit a PR with your changes.
 */

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import rocks.boltsandnuts.falsework.blocks.BlockRecipeRegistry;
import rocks.boltsandnuts.falsework.blocks.BlockRegistry;
import rocks.boltsandnuts.falsework.client.gui.CreativeTabBaseMod;
import rocks.boltsandnuts.falsework.client.gui.GuiHandler;
import rocks.boltsandnuts.falsework.items.ItemRecipeRegistry;
import rocks.boltsandnuts.falsework.items.ItemRegistry;
import rocks.boltsandnuts.falsework.proxies.CommonProxy;
import rocks.boltsandnuts.falsework.util.EventHandler;
import rocks.boltsandnuts.falsework.util.GenerationHandler;
import rocks.boltsandnuts.falsework.util.OreDictHandler;
import rocks.boltsandnuts.falsework.util.TextHelper;
import net.minecraft.creativetab.CreativeTabs;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = ModInformation.ID, name = ModInformation.NAME, version = ModInformation.VERSION, dependencies = ModInformation.DEPEND, guiFactory = ModInformation.GUIFACTORY)
public class Falsework {

	@SidedProxy(clientSide = ModInformation.CLIENTPROXY, serverSide = ModInformation.COMMONPROXY)
	public static CommonProxy proxy;

	public static CreativeTabs tabBaseMod = new CreativeTabBaseMod(ModInformation.ID + ".creativeTab");
	public static Logger logger = LogManager.getLogger(ModInformation.NAME);

	@Mod.Instance
	public static Falsework instance;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		logger.info(TextHelper.localize("info." + ModInformation.ID + ".console.load.preInit"));

		ConfigHandler.init(event.getSuggestedConfigurationFile());

		ItemRegistry.registerItems();
		BlockRegistry.registerBlocks();

		OreDictHandler.registerOreDict();
		FMLCommonHandler.instance().bus().register(new EventHandler());
		NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler());

		GameRegistry.registerWorldGenerator(new GenerationHandler(), 2);
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		logger.info(TextHelper.localize("info." + ModInformation.ID + ".console.load.init"));

		ItemRecipeRegistry.registerItemRecipes();
		BlockRecipeRegistry.registerBlockRecipes();
	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		logger.info(TextHelper.localize("info." + ModInformation.ID + ".console.load.postInit"));
	}
}

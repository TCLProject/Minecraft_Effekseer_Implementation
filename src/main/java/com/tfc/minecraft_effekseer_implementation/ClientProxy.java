package com.tfc.minecraft_effekseer_implementation;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent.KeyInputEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.common.MinecraftForge;

public class ClientProxy extends ServerProxy {
	
	public static KeyBinding keyBindToggleRendering;
	
	@Override
    public void register() 
    {
       super.register();
	   if (ClientProxy.keyBindToggleRendering == null) {
		   ClientProxy.keyBindToggleRendering = new KeyBinding("Toggle Rendering", Keyboard.KEY_LMENU, "key.categories.gameplay");
           ClientRegistry.registerKeyBinding(ClientProxy.keyBindToggleRendering);
           KeyBinding.resetKeyBindingArrayAndHash();
       }
    }
	
	@Override
	public void registerKeyHandelers() {
		super.registerKeyHandelers();
		MinecraftForge.EVENT_BUS.register(this);
	    FMLCommonHandler.instance().bus().register(this);
	}
	
	@SideOnly(Side.CLIENT)
	@SubscribeEvent(priority=EventPriority.NORMAL, receiveCanceled=true)
	public void onKeyInputEvent(KeyInputEvent event)
	{
		if (ClientProxy.keyBindToggleRendering.isPressed()) {
			MEI.renderingEnabled = !MEI.renderingEnabled;
		}
	}

}

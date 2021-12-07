package com.tfc.minecraft_effekseer_implementation;

import java.nio.FloatBuffer;

import javax.vecmath.Matrix4f;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;

import com.tfc.effekseer4j.EffekseerEffect;
import com.tfc.effekseer4j.enums.TextureType;
import com.tfc.minecraft_effekseer_implementation.common.Effek;
import com.tfc.minecraft_effekseer_implementation.common.Effeks;
import com.tfc.minecraft_effekseer_implementation.common.LoaderIndependentIdentifier;
import com.tfc.minecraft_effekseer_implementation.common.api.EffekEmitter;
import com.tfc.minecraft_effekseer_implementation.loader.EffekseerMCAssetLoader;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.IReloadableResourceManager;
import net.minecraft.command.ICommand;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid="mc_effekseer_impl", version="1.1.0", name="TCLGraphics FX")
public class MEI {
	private static final Logger LOGGER = LogManager.getLogger();
	
	private static final Effeks mapHandler = Effeks.getMapHandler();
	
	@EventHandler
    public void init(FMLInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(this);
		FMLCommonHandler.instance().bus().register(this);
		
		if (LoaderIndependentIdentifier.rlConstructor1.get() == null) {
			LoaderIndependentIdentifier.rlConstructor1.set(ResourceLocation::new);
			LoaderIndependentIdentifier.rlConstructor2.set(ResourceLocation::new);
		}
		if (Effek.widthGetter.get() == null) {
			Effek.widthGetter.set(() -> Minecraft.getMinecraft().displayWidth);
			Effek.heightGetter.set(() -> Minecraft.getMinecraft().displayHeight);
		}

		Networking.registerPackets();
		if (!FMLCommonHandler.instance().getSide().isClient()) return;
		IReloadableResourceManager manager = (IReloadableResourceManager) Minecraft.getMinecraft().getResourceManager();
		manager.registerReloadListener(EffekseerMCAssetLoader.INSTANCE);
	}
	
	
	@Mod.EventHandler
    public void serverStarting(final FMLServerStartingEvent event) {
		event.registerServerCommand((ICommand)new Command());
	}
	
	private static long lastFrame = -1;
	
	@SubscribeEvent
	public void renderWorldLast(final RenderWorldLastEvent event) {
		mapHandler.setTimeSinceReload(Effeks.getTimeSinceReload() + 1);
		
		Effek effek = Effeks.get("mc_effekseer_impl:effeks0");
		if (effek != null) {
			EffekEmitter emitter = effek.getOrCreate("test:test");
			emitter.setPosition(0, 10, 0);
		}
//		Effek effek = Effeks.get("mc_effekseer_impl:example");
//		if (effek != null) {
//			EffekEmitter emitter = effek.getOrCreate("test:test");
//			emitter.setVisible(false);
//			for (Entity allEntity : Minecraft.getInstance().world.getAllEntities()) {
//				if (allEntity instanceof FishingBobberEntity) {
//					emitter.emitter.setVisibility(true);
//					emitter.emitter.move(
//							(float) MathHelper.lerp(Minecraft.getInstance().getRenderPartialTicks(), (float) allEntity.lastTickPosX, allEntity.getPosX()) - 0.5f,
//							(float) MathHelper.lerp(Minecraft.getInstance().getRenderPartialTicks(), (float) allEntity.lastTickPosY, allEntity.getPosY()) - 0.5f,
//							(float) MathHelper.lerp(Minecraft.getInstance().getRenderPartialTicks(), (float) allEntity.lastTickPosZ, allEntity.getPosZ()) - 0.5f
//					);
//				}
//				if (allEntity instanceof ArmorStandEntity) {
//					ResourceLocation location = new ResourceLocation("modid:"+allEntity.getUniqueID().toString());
//					EffekEmitter emitter1 = effek.getOrCreate(location.toString());
//					emitter1.setPosition(allEntity.getPosX(), allEntity.getPosY() + allEntity.getEyeHeight(), allEntity.getPosZ());
//					if (!allEntity.isAlive()) effek.delete(emitter1);
//				}
//			}
//		}
//		effek = Effeks.get("example:aura");
//		if (effek != null)
//			for (int x = 0; x < 16; x++) {
//				for (int y = 0; y < 16; y++) {
//					EffekEmitter emitter = effek.getOrCreate("test:x" + x + "y" + y + "z0");
//					if (emitter != null) emitter.setPosition(x, y + 16, 0);
//					effek.delete(emitter);
//				}
//			}
		float diff = 1;
		if (lastFrame != -1) {
			long currentTime = System.currentTimeMillis();
			diff = (Math.abs(currentTime - lastFrame) / 1000f) * 60;
		}

		lastFrame = System.currentTimeMillis();
		
//		event.getMatrixStack().push();
		GL11.glPushMatrix();
//		event.getMatrixStack().translate(
//				-Minecraft.getMinecraft().getRenderManager().info.getProjectedView().getX(),
//				-Minecraft.getMinecraft().getRenderManager().info.getProjectedView().getY(),
//				-Minecraft.getMinecraft().getRenderManager().info.getProjectedView().getZ()
//		);
		GL11.glTranslated(
				-Minecraft.getMinecraft().renderViewEntity.posX,
				-Minecraft.getMinecraft().renderViewEntity.posY,
				-Minecraft.getMinecraft().renderViewEntity.posZ
		);
		
		// in case the above won't work, try the below
//		EntityLivingBase entitylivingbase = Minecraft.getMinecraft().renderViewEntity;
//      double x = entitylivingbase.lastTickPosX + (entitylivingbase.posX - entitylivingbase.lastTickPosX) * Minecraft.getMinecraft().timer.renderPartialTicks;
//      double y = entitylivingbase.lastTickPosY + (entitylivingbase.posY - entitylivingbase.lastTickPosY) * Minecraft.getMinecraft().timer.renderPartialTicks;
//      double z = entitylivingbase.lastTickPosZ + (entitylivingbase.posZ - entitylivingbase.lastTickPosZ) * Minecraft.getMinecraft().timer.renderPartialTicks;
//        
//		GL11.glTranslated(
//				-x,
//				-y,
//				-z
//		);


//		event.getMatrixStack().translate(0.5f, 0.5f, 0.5f);
		GL11.glTranslatef(0.5f, 0.5f, 0.5f);
		FloatBuffer b = BufferUtils.createFloatBuffer(16);
		GL11.glGetFloat(GL11.GL_MODELVIEW_MATRIX, b);
		Matrix4f matrix = new Matrix4f(
				b.get(), b.get(), b.get(), b.get(),
				b.get(), b.get(), b.get(), b.get(), 
				b.get(), b.get(), b.get(), b.get(), 
				b.get(), b.get(), b.get(), b.get()
		);
		float[][] cameraMatrix = matrixToArray(matrix);
//		event.getMatrixStack().pop();
		GL11.glPopMatrix();
//		matrix = Minecraft.getMinecraft().entityRenderer.theShaderGroup.projectionMatrix;
//		float[][] projectionMatrix = matrixToArray(matrix);
		
		// if the above won't work
		FloatBuffer b2 = BufferUtils.createFloatBuffer(16);
		GL11.glGetFloat(GL11.GL_PROJECTION_MATRIX, b2);
		Matrix4f matrix2 = new Matrix4f(
				b2.get(), b2.get(), b2.get(), b2.get(),
				b2.get(), b2.get(), b2.get(), b2.get(), 
				b2.get(), b2.get(), b2.get(), b2.get(), 
				b2.get(), b2.get(), b2.get(), b2.get()
		);
		float[][] projectionMatrix = matrixToArray(matrix2);
		
		final float finalDiff = diff;
//		if (event.renderer.getParticleFrameBuffer() != null)
//			event.renderer.getParticleFrameBuffer().copyDepthFrom(Minecraft.getMinecraft().getFramebuffer());
//		RenderState.PARTICLES_TARGET.setupRenderState();
		Effeks.forEach((name, effect) -> effect.draw(cameraMatrix, projectionMatrix, finalDiff));
//		RenderState.PARTICLES_TARGET.clearRenderState();
	}
	
	public static void printEffectInfo(EffekseerEffect effect) {
		System.out.println("Effect info:");
		System.out.println(" curveCount: " + effect.curveCount());
		for (int index = 0; index < effect.curveCount(); index++) System.out.println("  curve"+index+": " + effect.getCurvePath(index));
		System.out.println(" materialCount: " + effect.materialCount());
		for (int index = 0; index < effect.materialCount(); index++) System.out.println("  material"+index+": " + effect.getMaterialPath(index));
		System.out.println(" modelCount: " + effect.modelCount());
		for (int index = 0; index < effect.modelCount(); index++) System.out.println("  model"+index+": " + effect.getModelPath(index));
		System.out.println(" textureCount: " + effect.textureCount());
		for (TextureType value : TextureType.values()) {
			System.out.println("  textureCount"+value.toString()+":"+effect.textureCount(value));
			for (int index = 0; index < effect.textureCount(value); index++) System.out.println("   model"+index+": " + effect.getTexturePath(index, value));
		}
		System.out.println(" isLoaded: " + effect.isLoaded());
		System.out.println(" minTerm: " + effect.minTerm());
		System.out.println(" maxTerm: " + effect.maxTerm());
	}
	
	public static float[][] matrixToArray(Matrix4f matrix) {
		return new float[][]{
				{matrix.m00, matrix.m01, matrix.m02, matrix.m02},
				{matrix.m10, matrix.m11, matrix.m12, matrix.m13},
				{matrix.m20, matrix.m21, matrix.m22, matrix.m23},
				{matrix.m30, matrix.m31, matrix.m32, matrix.m33}
		};
	}
}

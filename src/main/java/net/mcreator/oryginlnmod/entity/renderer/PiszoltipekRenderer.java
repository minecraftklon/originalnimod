package net.mcreator.oryginlnmod.entity.renderer;

@OnlyIn(Dist.CLIENT)
public class PiszoltipekRenderer {

	public static class ModelRegisterHandler {

		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(PiszoltipekEntity.entity, renderManager -> {
				BipedRenderer customRender = new BipedRenderer(renderManager, new BipedModel(0), 0.5f) {
					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("oryginln_mod:textures/solger_halo.png");
					}
				};
				customRender.addLayer(new BipedArmorLayer(customRender, new BipedModel(0.5f), new BipedModel(1)));
				customRender.addLayer(new GlowingLayer<>(customRender));
				return customRender;
			});

		}
	}

	@OnlyIn(Dist.CLIENT)
	private static class GlowingLayer<T extends Entity, M extends EntityModel<T>> extends LayerRenderer<T, M> {

		public GlowingLayer(IEntityRenderer<T, M> er) {
			super(er);
		}

		public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, T entitylivingbaseIn, float limbSwing,
				float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
			IVertexBuilder ivertexbuilder = bufferIn
					.getBuffer(RenderType.getEyes(new ResourceLocation("oryginln_mod:textures/unsc-marine-halo-on-planetminecraft-com.png")));
			this.getEntityModel().render(matrixStackIn, ivertexbuilder, 15728640, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
		}

	}

}

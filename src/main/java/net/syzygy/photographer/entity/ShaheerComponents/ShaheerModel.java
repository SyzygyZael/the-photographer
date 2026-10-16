// Made with Blockbench 5.2.2
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports

package net.syzygy.photographer.entity.ShaheerComponents;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.EntityModel;

@Environment(EnvType.CLIENT)
public class ShaheerModel extends EntityModel<ShaheerRenderState> {
	private final ModelPart shaheer;
	private final ModelPart body;
	private final ModelPart head;
	private final ModelPart torso;
	private final ModelPart right_arm;
	private final ModelPart left_arm;
	private final ModelPart right_leg;
	private final ModelPart left_leg;
	private final ModelPart camera;
	public ShaheerModel(ModelPart root) {
		super(root);
		this.shaheer = root.getChild("shaheer");
		this.body = this.shaheer.getChild("body");
		this.head = this.body.getChild("head");
		this.torso = this.body.getChild("torso");
		this.right_arm = this.body.getChild("right_arm");
		this.left_arm = this.body.getChild("left_arm");
		this.right_leg = this.body.getChild("right_leg");
		this.left_leg = this.body.getChild("left_leg");
		this.camera = this.body.getChild("camera");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData shaheer = modelPartData.addChild("shaheer", ModelPartBuilder.create(), ModelTransform.of(0.0F, 24.0F, 0.0F, 0.0F, 0.0F, 0.0F));

		ModelPartData body = shaheer.addChild("body", ModelPartBuilder.create(), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F));

		ModelPartData head = body.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -7.0F, -3.0F, 8.0F, 7.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -23.0F, 0.0F, 0.0F, 0.0F, 0.0F));

		ModelPartData torso = body.addChild("torso", ModelPartBuilder.create().uv(0, 14).cuboid(-4.0F, -12.0F, -2.0F, 8.0F, 12.0F, 4.0F, new Dilation(0.0F))
		.uv(32, 30).cuboid(-4.0F, -1.0F, -2.0F, 8.0F, 1.0F, 4.0F, new Dilation(0.21F)), ModelTransform.of(0.0F, -11.0F, 0.0F, 0.0F, 0.0F, 0.0F));

		ModelPartData right_arm = body.addChild("right_arm", ModelPartBuilder.create().uv(0, 30).cuboid(-4.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F))
		.uv(40, 24).cuboid(-4.0F, 1.0F, -2.0F, 4.0F, 1.0F, 4.0F, new Dilation(0.1F)), ModelTransform.of(-4.0F, -21.0F, 0.0F, -1.5708F, -0.2618F, 0.0F));

		ModelPartData left_arm = body.addChild("left_arm", ModelPartBuilder.create().uv(24, 14).cuboid(0.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F))
		.uv(34, 45).cuboid(0.0F, 1.0F, -2.0F, 4.0F, 1.0F, 4.0F, new Dilation(0.1F)), ModelTransform.of(4.0F, -21.0F, 0.0F, -1.5708F, 0.5236F, 0.0F));

		ModelPartData right_leg = body.addChild("right_leg", ModelPartBuilder.create().uv(16, 30).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 10.0F, 4.0F, new Dilation(0.0F))
		.uv(40, 14).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new Dilation(0.2F)), ModelTransform.of(-2.0F, -11.0F, 0.0F, 0.0F, 0.0F, 0.0F));

		ModelPartData left_leg = body.addChild("left_leg", ModelPartBuilder.create().uv(30, 0).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 10.0F, 4.0F, new Dilation(0.0F))
		.uv(32, 35).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new Dilation(0.2F)), ModelTransform.of(2.0F, -11.0F, 0.0F, 0.0F, 0.0F, 0.0F));

		ModelPartData camera = body.addChild("camera", ModelPartBuilder.create().uv(0, 46).cuboid(0.0F, -1.0F, -3.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.3F))
		.uv(45, 0).cuboid(-1.0F, -1.0F, 1.0F, 3.0F, 2.0F, 1.0F, new Dilation(0.3F))
		.uv(42, 36).cuboid(1.0F, -3.0F, -1.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(0, 0).cuboid(-2.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.1F))
		.uv(45, 1).cuboid(-2.0F, -1.0F, -1.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.3F))
		.uv(16, 45).cuboid(-3.0F, -2.0F, -1.0F, 6.0F, 4.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-2.0F, -22.0F, -11.0F, 0.0F, 0.0F, 0.0F));
		return TexturedModelData.of(modelData, 64, 64);
	}
	@Override
	public void setAngles(ShaheerRenderState renderState) {
			super.setAngles(renderState);
	}
}
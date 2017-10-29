package com.simoncherry.vroom;

import android.content.Context;
import android.view.MotionEvent;

import org.rajawali3d.Object3D;
import org.rajawali3d.lights.ALight;
import org.rajawali3d.lights.DirectionalLight;
import org.rajawali3d.loader.LoaderOBJ;
import org.rajawali3d.materials.Material;
import org.rajawali3d.materials.methods.DiffuseMethod;
import org.rajawali3d.materials.textures.Texture;
import org.rajawali3d.math.vector.Vector3;
import org.rajawali3d.primitives.Plane;
import org.rajawali3d.vr.renderer.VRRenderer;

/**
 * Created by wecut-simon on 2017/10/29.
 */

public class VRoomRenderer extends VRRenderer {

    public VRoomRenderer(Context context) {
        super(context);
    }

    @Override
    public void onOffsetsChanged(float xOffset, float yOffset, float xOffsetStep, float yOffsetStep, int xPixelOffset, int yPixelOffset) {

    }

    @Override
    public void onTouchEvent(MotionEvent event) {

    }

    @Override
    protected void initScene() {
        getCurrentScene().setBackgroundColor(0xdddddd);

        try {
            LoaderOBJ loaderOBJ = new LoaderOBJ(mContext.getResources(), mTextureManager, R.raw.bed_obj);
            loaderOBJ.parse();
            Object3D bed = loaderOBJ.getParsedObject();

            loaderOBJ = new LoaderOBJ(mContext.getResources(), mTextureManager, R.raw.desk_obj);
            loaderOBJ.parse();
            Object3D desk = loaderOBJ.getParsedObject();

            loaderOBJ = new LoaderOBJ(mContext.getResources(), mTextureManager, R.raw.bedside_obj);
            loaderOBJ.parse();
            Object3D bedside = loaderOBJ.getParsedObject();

            loaderOBJ = new LoaderOBJ(mContext.getResources(), mTextureManager, R.raw.monitor_obj);
            loaderOBJ.parse();
            Object3D monitor = loaderOBJ.getParsedObject();

            loaderOBJ = new LoaderOBJ(mContext.getResources(), mTextureManager, R.raw.keyboard_obj);
            loaderOBJ.parse();
            Object3D keyboard = loaderOBJ.getParsedObject();

            loaderOBJ = new LoaderOBJ(mContext.getResources(), mTextureManager, R.raw.mouse_obj);
            loaderOBJ.parse();
            Object3D mouse = loaderOBJ.getParsedObject();

            loaderOBJ = new LoaderOBJ(mContext.getResources(), mTextureManager, R.raw.lamp_obj);
            loaderOBJ.parse();
            Object3D lamp = loaderOBJ.getParsedObject();

            loaderOBJ = new LoaderOBJ(mContext.getResources(), mTextureManager, R.raw.pc_box_obj);
            loaderOBJ.parse();
            Object3D pcBox = loaderOBJ.getParsedObject();

            loaderOBJ = new LoaderOBJ(mContext.getResources(), mTextureManager, R.raw.photo_frame_obj);
            loaderOBJ.parse();
            Object3D photoFrame = loaderOBJ.getParsedObject();

            loaderOBJ = new LoaderOBJ(mContext.getResources(), mTextureManager, R.raw.chair_obj);
            loaderOBJ.parse();
            Object3D chair = loaderOBJ.getParsedObject();

            loaderOBJ = new LoaderOBJ(mContext.getResources(), mTextureManager, R.raw.java_book_obj);
            loaderOBJ.parse();
            Object3D javaBook = loaderOBJ.getParsedObject();

            loaderOBJ = new LoaderOBJ(mContext.getResources(), mTextureManager, R.raw.wardrobe_obj);
            loaderOBJ.parse();
            Object3D wardrobe = loaderOBJ.getParsedObject();

            loaderOBJ = new LoaderOBJ(mContext.getResources(), mTextureManager, R.raw.door_obj);
            loaderOBJ.parse();
            Object3D door = loaderOBJ.getParsedObject();
            door.setPosition(0.1f, 0, 0.25f);

            loaderOBJ = new LoaderOBJ(mContext.getResources(), mTextureManager, R.raw.conditioner_obj);
            loaderOBJ.parse();
            Object3D conditioner = loaderOBJ.getParsedObject();
            conditioner.setPosition(0, 0.45f, 0);

            loaderOBJ = new LoaderOBJ(mContext.getResources(), mTextureManager, R.raw.window_obj);
            loaderOBJ.parse();
            Object3D window = loaderOBJ.getParsedObject();
            window.setPosition(0, 0.55f, 0.35f);

            loaderOBJ = new LoaderOBJ(mContext.getResources(), mTextureManager, R.raw.lamp2_obj);
            loaderOBJ.parse();
            Object3D lamp2 = loaderOBJ.getParsedObject();

            loaderOBJ = new LoaderOBJ(mContext.getResources(), mTextureManager, R.raw.ceiling_lamp_obj);
            loaderOBJ.parse();
            Object3D ceilingLamp = loaderOBJ.getParsedObject();
            ceilingLamp.setPosition(0, 1, 0);

            loaderOBJ = new LoaderOBJ(mContext.getResources(), mTextureManager, R.raw.picture1_obj);
            loaderOBJ.parse();
            Object3D picture1 = loaderOBJ.getParsedObject();
            picture1.setPosition(0.2f, 1, 0.2f);

            loaderOBJ = new LoaderOBJ(mContext.getResources(), mTextureManager, R.raw.picture2_obj);
            loaderOBJ.parse();
            Object3D picture2 = loaderOBJ.getParsedObject();
            picture2.setPosition(0.2f, 1, 0.2f);

            loaderOBJ = new LoaderOBJ(mContext.getResources(), mTextureManager, R.raw.picture3_obj);
            loaderOBJ.parse();
            Object3D picture3 = loaderOBJ.getParsedObject();
            picture3.setPosition(0.2f, 1, 0.2f);

            loaderOBJ = new LoaderOBJ(mContext.getResources(), mTextureManager, R.raw.guitar_obj);
            loaderOBJ.parse();
            Object3D guitar = loaderOBJ.getParsedObject();

            // 墙体材质
            Material floorMaterial = new Material();
            floorMaterial.enableLighting(true);
            floorMaterial.addTexture(new Texture("floorDiffuseTex", R.drawable.wood1));
            floorMaterial.setDiffuseMethod(new DiffuseMethod.Lambert());
            floorMaterial.setColorInfluence(0);

            Material wallMaterial = new Material();
            wallMaterial.enableLighting(true);
            wallMaterial.addTexture(new Texture("wallDiffuseTex", R.drawable.wall));
            wallMaterial.setDiffuseMethod(new DiffuseMethod.Lambert());
            wallMaterial.setColorInfluence(0);

            // 地板
            Object3D floor = new Plane(5.5f, 4.8f, 1, 1, Vector3.Axis.Y);
            floor.setMaterial(floorMaterial);

            // 天花板
            Object3D ceiling = new Plane(5.5f, 4.8f, 1, 1, Vector3.Axis.Y);
            ceiling.setMaterial(wallMaterial);
            ceiling.setPosition(0, 4f, 0);
            ceiling.setRotZ(180);

            // 墙1
            Object3D wall1 = new Plane(5.5f, 7, 1, 1);
            wall1.setMaterial(wallMaterial);
            wall1.setPosition(0, 3.5f, -2.4f);

            // 墙2
            Object3D wall2 = new Plane(4.8f, 7, 1, 1, Vector3.Axis.X);
            wall2.setMaterial(wallMaterial);
            wall2.setPosition(-2.75f, 3.5f, 0);
            wall2.setRotZ(90);

            // 墙3
            Object3D wall3 = new Plane(5.5f, 7, 1, 1, Vector3.Axis.Z);
            wall3.setMaterial(wallMaterial);
            wall3.setPosition(0, 3.5f, 2.4f);
            wall3.setRotZ(180);

            // 墙4
            Object3D wall4 = new Plane(4.8f, 7, 1, 1, Vector3.Axis.X);
            wall4.setMaterial(wallMaterial);
            wall4.setPosition(2.75f, 3.5f, 0);
            wall4.setRotX(180);
            wall4.setRotZ(90);

            Object3D roomCube = new Object3D();
            roomCube.addChild(ceiling);
            roomCube.addChild(floor);
            roomCube.addChild(wall1);
            roomCube.addChild(wall2);
            roomCube.addChild(wall3);
            roomCube.addChild(wall4);
            roomCube.setPosition(1.4f, 0, 0.8f);

            Object3D container = new Object3D();
            container.addChild(roomCube);
            container.addChild(bed);
            container.addChild(desk);
            container.addChild(bedside);
            container.addChild(monitor);
            container.addChild(keyboard);
            container.addChild(mouse);
            container.addChild(lamp);
            container.addChild(pcBox);
            container.addChild(photoFrame);
            container.addChild(chair);
            container.addChild(javaBook);
            container.addChild(wardrobe);
            container.addChild(door);
            container.addChild(conditioner);
            container.addChild(window);
            container.addChild(lamp2);
            container.addChild(ceilingLamp);
            container.addChild(picture1);
            container.addChild(picture2);
            container.addChild(picture3);
            container.addChild(guitar);

            container.setX(-1.8f);
            container.setY(-1.9f);
            container.setZ(-1.0f);

            getCurrentScene().addChild(container);

            // 灯光
            ALight lightToFloor = new DirectionalLight();
            lightToFloor.setPower(0.5f);
            lightToFloor.setLookAt(0, -1, -0.1f);

            ALight lightToCeiling = new DirectionalLight();
            lightToCeiling.setPower(0.5f);
            lightToCeiling.setLookAt(0, 1, 0);

            ALight lightToWall1 = new DirectionalLight();
            lightToWall1.setPower(0.5f);
            lightToWall1.setLookAt(0, 0, -2);

            ALight lightToWall2 = new DirectionalLight();
            lightToWall2.setPower(0.5f);
            lightToWall2.setLookAt(-2, 0, 0);

            ALight lightToWall3 = new DirectionalLight();
            lightToWall3.setPower(0.5f);
            lightToWall3.setLookAt(0, 0, 2);

            ALight lightToWall4 = new DirectionalLight();
            lightToWall4.setPower(0.5f);
            lightToWall4.setLookAt(2, 0, 0);

            getCurrentScene().addLight(lightToFloor);
            getCurrentScene().addLight(lightToCeiling);
            getCurrentScene().addLight(lightToWall1);
            getCurrentScene().addLight(lightToWall2);
            getCurrentScene().addLight(lightToWall3);
            getCurrentScene().addLight(lightToWall4);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

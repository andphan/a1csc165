package a1;
import sage.app.BaseGame;
import sage.camera.*;
import sage.display.*;
import sage.scene.*;
import sage.scene.shape.*;
import graphicslib3D.Matrix3D;
import graphicslib3D.Point3D;

import java.awt.event.*;
import java.util.Random;
import java.awt.Color;
import java.nio.*;
import java.text.DecimalFormat;


public class treasurehunt2015 extends BaseGame {

	// what type of objects are in the game
	// world
	// player
	// treasures
	// treasure chest
	IDisplaySystem display;
	ICamera camera;
	private int score = 0;
	private float time = 0;
	private HUDString scoreDisplay;
	private HUDString timeDisplay;
	
		public void initGame()
		{	
			System.out.println("initGame call");
			initTreasures();
			// overwritten
			// create new treasures by building sage.scene.shape
			// at least one sage.scene.TriMesh - explicitly specify the triangles, verticies and colors.
			// initializing objects
		
		//	System.out.println(treasure1);
			// HUD elements must be implemented in a class that extends sage.scene.HUDObject
			// current score
			// elapsed time in seconds
			
		}
		private void initTreasures()
		{
			IDisplaySystem display = getDisplaySystem();
			display.setTitle("Treasure Hunt 2015");
		
			camera = display.getRenderer().getCamera();
			camera.setPerspectiveFrustum(45, 1, 0.01, 1000);
			camera.setLocation(new Point3D(1, 1, 20));
			
			myNewTreasure treasureOne = new myNewTreasure();
			Matrix3D treasureOneM = treasureOne.getLocalTranslation();
			treasureOneM.translate(2, 2, 8);
			treasureOne.setLocalTranslation(treasureOneM);
			addGameWorldObject(treasureOne);
		}
		public void update(float ElapsedTimeMS)
		{
			// overwritten
			
		}
		
		public class myNewTreasure extends TriMesh
		{
			private float[] verticies = new float[] {0, 1, 2, 3, 4, 5};
			private float[] colors = new float[] {0, 1, 2, 3, 4, 5};
			private int[] triangles = new int[] {0, 1, 2, 3, 4, 5};
			
			public myNewTreasure()
			{
				FloatBuffer vertBuff = com.jogamp.common.nio.Buffers.newDirectFloatBuffer(verticies);
				FloatBuffer colorsBuff = com.jogamp.common.nio.Buffers.newDirectFloatBuffer(colors);
				IntBuffer triangleBuff = com.jogamp.common.nio.Buffers.newDirectIntBuffer(triangles);
				
				this.setVertexBuffer(vertBuff);
				this.setColorBuffer(colorsBuff);
				this.setIndexBuffer(triangleBuff);	
			}
		}
			// must handle input actions sage.input.action.IAction, InputManager.associateAction()
		// A/D/W/S
		// left arrow / right - rotate camera around it's yaw
		// up / down arrow - rotate camera around its pitch
		// escape - quit game s
		
		// controller input
		
	}

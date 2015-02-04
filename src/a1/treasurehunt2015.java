package a1;
import sage.app.BaseGame;
import sage.camera.*;
import sage.display.*;
import sage.scene.SceneNode;
import sage.scene.shape.*;
import graphicslib3D.Point3D;

import java.awt.event.*;
import java.util.Random;
import java.awt.Color;
import java.text.DecimalFormat;


public class treasurehunt2015 extends BaseGame {

	// what type of objects are in the game
	// world
	// player
	// treasures
	// treasure chest
	IDisplaySystem display;
	ICamera camera;
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
		
		}
		public void update(float ElapsedTimeMS)
		{
			// overwritten
		}
		
			// must handle input actions sage.input.action.IAction, InputManager.associateAction()
		// A/D/W/S
		// left arrow / right - rotate camera around it's yaw
		// up / down arrow - rotate camera around its pitch
		// escape - quit game s
		
		// controller input
		
	}

package a1;
import sage.app.BaseGame;
import sage.display.*;
import sage.display.DisplaySystem;
import sage.scene.SceneNode;
import sage.scene.shape.Rectangle;

import graphicslib3D.Point3D;

import java.awt.event.*;
import java.util.Random;
import java.awt.Color;
import java.text.DecimalFormat;


public class treasurehunt2015 extends BaseGame {


	
		public void initGame()
		{
			// overwritten
			// create new treasures by building sage.scene.shape
			// at least one sage.scene.TriMesh - explicitly specify the triangles, verticies and colors.
			
			
			// HUD elements must be implemented in a class that extends sage.scene.HUDObject
			// current score
			// elapsed time in seconds
			
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

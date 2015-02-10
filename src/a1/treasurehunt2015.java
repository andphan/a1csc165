package a1;
import sage.app.BaseGame;
import sage.camera.*;
import sage.display.*;
import sage.event.IEventManager;
import sage.input.*;
import sage.input.action.*;
import sage.scene.*;
import sage.scene.shape.*;
import graphicslib3D.Matrix3D;
import graphicslib3D.Point3D;

import java.awt.event.*;
import java.util.Random;
import java.awt.Color;
import java.nio.*;
import java.text.DecimalFormat;

import net.java.games.input.Controller;
import net.java.games.input.*;


public class treasurehunt2015 extends BaseGame {
	// what type of objects are in the game
	// world
	// player
	// treasures
	// treasure chest
	IDisplaySystem display;
//	ICamera camera;
	IInputManager im;
	IEventManager em;
	
		public void initGame() // override
		{	
			IInputManager im = getInputManager();
			// initialize Managers
			System.out.println("initGame call");
			initGameObjects();	
			
			String kbName = im.getKeyboardName();
			String gpName = im.getFirstGamepadName();
			
			// create keyboard actions
			IAction quitGame = new QuitGameAction(this);
	//		IAction moveForward = new ForwardCameraMovement(camera, 0.01f);
	//		IAction moveBack = new BackCameraMovement();
	//		IAction moveLeft = new LeftCameraMovement();
	//		IAction moveRight = new RightCameraMovement();
	//		IAction rotateLeft = new RotateLeftCamera();
	//		IAction rotateRight = new RotateRightCamera();
			
			// create game controller actions
			
	//		IAction controllerX = new XAxisMovement();
	//		IAction controllerY = new YAxisMovement();
	//		IAction controllerRX = new RXAxisMovement();
	//		IAction controllerRY = new RYAxisMovement();
		
			
			// Associate actions
	//		im.associateAction(kbName, net.java.games.input.Component.Identifier.Key.W, moveForward, 
	//				IInputManager.INPUT_ACTION_TYPE.REPEAT_WHILE_DOWN);
			im.associateAction(kbName, net.java.games.input.Component.Identifier.Key.ESCAPE, quitGame, 
					IInputManager.INPUT_ACTION_TYPE.ON_PRESS_ONLY);
		}
			
		public void initGameObjects()
		{
			display = getDisplaySystem();
			display.setTitle("Treasure Hunt 2015");
			
			// testing out camera
			
			
			// 	create new objects by using scale()
			
			// SAGE Cube - increase ... by using event handling system
			
			// create TriMesh 
		 	myNewTriMesh tri1 = new myNewTriMesh();
			addGameWorldObject(tri1);
			// treasure chest is implemented
			
		}
		public void update(float ElapsedTimeMS)
		{
			// overwritten
			super.update(ElapsedTimeMS);
			// move camera
			
		}
		
	}

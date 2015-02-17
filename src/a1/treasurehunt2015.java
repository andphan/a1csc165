package a1;
import sage.app.BaseGame;
import sage.camera.*;
import sage.display.*;
import sage.event.EventManager;
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
	Rectangle rect1;
	Sphere sph;
	Cylinder cyl;
	myNewTriMesh myT;
	Cube treasureChest;
	IDisplaySystem display;
	ICamera camera;
	IInputManager im;
	IEventManager em;
	int numHit;
	private int score = 0;
	private float time = 0;
	
		public void initGame() // override
		{	
			IInputManager im = getInputManager();
			em = EventManager.getInstance();
			// initialize Managers
			System.out.println("initGame call");
			initGameObjects();	
			
			String kbName = im.getKeyboardName();
			String gpName = im.getFirstGamepadName();
			
		/*	// create keyboard actions
			IAction quitGame = new QuitGameAction(this);
			IAction moveForward = new ForwardCameraMovement(camera, 0.01f);
			IAction moveBack = new BackCameraMovement();
			IAction moveLeft = new LeftCameraMovement();
			IAction moveRight = new RightCameraMovement();
			IAction rotateUp = new RotateUpCamera();
			IAction rotateDown = new RotateDownCamera();
			IAction rotateLeft = new RotateLeftCamera();
			IAction rotateRight = new RotateRightCamera();
			*/
			// create game controller actions
			
	//		IAction controllerX = new XAxisMovement();
	//		IAction controllerY = new YAxisMovement();
	//		IAction controllerRX = new RXAxisMovement();
	//		IAction controllerRY = new RYAxisMovement();
		
			
			// Associate actions
	//		im.associateAction(kbName, net.java.games.input.Component.Identifier.Key.W, moveForward, 
	//				IInputManager.INPUT_ACTION_TYPE.REPEAT_WHILE_DOWN);
	//		im.associateAction(kbName, net.java.games.input.Component.Identifier.Key.S, moveBackward, 
	//				IInputManager.INPUT_ACTION_TYPE.REPEAT_WHILE_DOWN);			
	//		im.associateAction(kbName, net.java.games.input.Component.Identifier.Key.A, moveLeft, 
	//				IInputManager.INPUT_ACTION_TYPE.REPEAT_WHILE_DOWN);	
	//		im.associateAction(kbName, net.java.games.input.Component.Identifier.Key.D, moveRight, 
	//				IInputManager.INPUT_ACTION_TYPE.REPEAT_WHILE_DOWN);	
	//		im.associateAction(kbName, net.java.games.input.Component.Identifier.Key.LEFT, rotateLeft, 
	//				IInputManager.INPUT_ACTION_TYPE.REPEAT_WHILE_DOWN);	
	//		im.associateAction(kbName, net.java.games.input.Component.Identifier.Key.RIGHT, rotateRight, 
	//			IInputManager.INPUT_ACTION_TYPE.REPEAT_WHILE_DOWN);	
	//		im.associateAction(kbName, net.java.games.input.Component.Identifier.Key.Up, rotateUp, 
	//				IInputManager.INPUT_ACTION_TYPE.REPEAT_WHILE_DOWN);	
	//		im.associateAction(kbName, net.java.games.input.Component.Identifier.Key.Down, rotateDown, 
	//				IInputManager.INPUT_ACTION_TYPE.REPEAT_WHILE_DOWN);	
	//		im.associateAction(kbName, net.java.games.input.Component.Identifier.Key.ESCAPE, quitGame, 
	//				IInputManager.INPUT_ACTION_TYPE.ON_PRESS_ONLY);
		}
			
		public void initGameObjects()
		{
			display = getDisplaySystem();
			display.setTitle("Treasure Hunt 2015");
			
			// testing out camera
			camera = display.getRenderer().getCamera();
			camera.setPerspectiveFrustum(45, 1, 0.01, 1000);
			camera.setLocation(new Point3D(1, 1, 20));
			
			
			// 	create new objects by using scale()
			Random rng = new Random();
		/*s	rect1 = new Rectangle();
			Matrix3D rectM = rect1.getLocalTranslation();
			rectM.translate(23, 21, -80);
			rect1.setLocalTranslation(rectM);
			addGameWorldObject(rect1);
			
			sph = new Sphere();
			Matrix3D sphM = sph.getLocalTranslation();
			sphM.translate(500, 100, 300);
			sph.setLocalTranslation(sphM);
			addGameWorldObject(sph);
			
			cyl = new Cylinder();
			Matrix3D cylM = cyl.getLocalTranslation();
			cylM.translate(rng.nextFloat(), rng.nextFloat(), 0);
			cyl.setLocalTranslation(cylM);
			addGameWorldObject(cyl);
			
			// SAGE Cube - increase ... by using event handling system
			// event class extends AbstractGameVent
			// IEventListener
			// detecting collision
			// 
			// triMesh
			myT = new myNewTriMesh();
			Matrix3D myTM = myT.getLocalTranslation();
			myTM.translate(100, 100, 100);
			myT.setLocalTranslation(myTM);
			addGameWorldObject(myT);
			
		*/	
			// treasureChest
			treasureChest = new Cube();
			Matrix3D treasureChestM = treasureChest.getLocalTranslation();
			treasureChestM.translate(rng.nextFloat()*(float)0.5, rng.nextFloat()*0.5, 0);
			treasureChest.setLocalTranslation(treasureChestM);
			addGameWorldObject(treasureChest);
			
			
			// add x, y, and z coordinates
			Point3D origin = new Point3D(0,0,0);
			Point3D xEnd = new Point3D(100,0,0);
			Point3D yEnd = new Point3D(0,100,0);
			Point3D zEnd = new Point3D(0,0,100);
			Line xAxis = new Line(origin, xEnd, Color.red, 2);
			Line yAxis = new Line(origin, yEnd, Color.green, 2);
			Line zAxis = new Line(origin, zEnd, Color.blue, 2);
			addGameWorldObject(xAxis);
			addGameWorldObject(yAxis);
			addGameWorldObject(zAxis);
			
			
		}
		public void update(float ElapsedTimeMS)
		{
			
			// overwritten
			// update score
/*			if (rect1.getWorldBound().contains(camera.getLocation()))
			{
				numHit++;
				score++; // add 1 to score
		//		CrashEvent newCrash = new CrashEvent(numHit);
		//		em.triggerEvent(newCrash);
			}
			// do this for sphere, cylinder
			// when crash event happens, treasurechest increase size.
			
			// move camera
*/
		}
		
	}

package a1;
import sage.app.BaseGame;
import sage.camera.*;
import sage.display.*;
import sage.event.EventManager;
import sage.event.IEventListener;
import sage.event.IEventManager;
import sage.event.IGameEvent;
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


public class treasurehunt2015 extends BaseGame implements IEventListener{
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
	private HUDString scoreDisplay;
	private HUDString timeDisplay;
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
			
			// create keyboard actions
			IAction quitGame = new QuitGameAction(this);
	/*		IAction moveForward = new ForwardCameraMovement(camera, 0.01f);
			IAction moveBack = new BackCameraMovement();
			IAction moveLeft = new LeftCameraMovement();
			IAction moveRight = new RightCameraMovement();
			IAction rotateUp = new RotateUpCamera();
			IAction rotateDown = new RotateDownCamera();
			IAction rotateLeft = new RotateLeftCamera();
			IAction rotateRight = new RotateRightCamera(); */
		
			// create game controller actions
			
	//		IAction controllerX = new XAxisMovement();
	//		IAction controllerY = new YAxisMovement();
	//		IAction controllerRX = new RXAxisMovement();
	//		IAction controllerRY = new RYAxisMovement();
		
			/* figure out why laptop cannot run with im.associateAction */
			
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
/*
			
			// 	create new objects by using scale()
			Random rng = new Random();
			float ax = rng.nextFloat()*(float)1;
			float ay = rng.nextFloat()*(float)1;
			
			rect1 = new Rectangle();
			Matrix3D rectM = rect1.getLocalTranslation();
			rectM.translate(ax, ay, 0);
			rect1.setLocalTranslation(rectM);
			addGameWorldObject(rect1);
			rect1.updateWorldBound();
			
			Random ang = new Random();
			float bx = ang.nextFloat()*(float)1;
			float by = ang.nextFloat()*(float)1;
			
			
			sph = new Sphere();
			Matrix3D sphM = sph.getLocalTranslation();
			sphM.translate(bx, by, 0);
			sph.setLocalTranslation(sphM);
			addGameWorldObject(sph);
			sph.updateWorldBound();
			
			Random cng = new Random();
			float cx = cng.nextFloat()*(float)1;
			float cy = cng.nextFloat()*(float)1;
			
			
			cyl = new Cylinder();
			Matrix3D cylM = cyl.getLocalTranslation();
			cylM.translate(cx, cy, 0);
			cyl.setLocalTranslation(cylM);
			addGameWorldObject(cyl);
			cyl.updateWorldBound();
		//	em.addListener((IEventListener) cyl, CrashEvent.class);
		*/
			Random dng = new Random();
			float dx = dng.nextFloat()*(float)1;
			float dy = dng.nextFloat()*(float)1;
			
			
			// triMesh
			myT = new myNewTriMesh();
			Matrix3D myTM = myT.getLocalTranslation();
			myTM.translate(100, 100, 100);
			myT.setLocalTranslation(myTM);
			addGameWorldObject(myT);
		//	myT.updateWorldBound();
		/*
			Random eng = new Random();
			float ex = eng.nextFloat()*(float)1;
			float ey = eng.nextFloat()*(float)1;
			
			
			// treasureChest
			treasureChest = new Cube();
			Matrix3D treasureChestM = treasureChest.getLocalTranslation();
			treasureChestM.translate(ex, ey, 0);
			treasureChest.setLocalTranslation(treasureChestM);
			addGameWorldObject(treasureChest);
			treasureChest.updateWorldBound();
		*/	
			// add x, y, and z coordinates
			Point3D origin = new Point3D(0,0,0);
			Point3D xEnd = new Point3D(100,0,0);
			Point3D yEnd = new Point3D(0,100,0);
			Point3D zEnd = new Point3D(0,0,100);
			Line xAxis = new Line(origin, xEnd, Color.red, 1);
			Line yAxis = new Line(origin, yEnd, Color.green, 1);
			Line zAxis = new Line(origin, zEnd, Color.blue, 1);
			addGameWorldObject(xAxis);
			addGameWorldObject(yAxis);
			addGameWorldObject(zAxis);
			
			// add HUD
			scoreDisplay = new HUDString("Score = " + score);
			scoreDisplay.setColor(Color.orange);
			addGameWorldObject(scoreDisplay);
			timeDisplay = new HUDString("Time = " + time);
			timeDisplay.setColor(Color.WHITE);
			timeDisplay.setLocation(0, 0.025);
			addGameWorldObject(timeDisplay);
			
		}
		public void update(float elapsedTimeMS)
		{
			
			// overwritten
			// update score
			scoreDisplay.setText("Score = " + score);
			time += elapsedTimeMS;
			
			timeDisplay.setText("Time = " + (time/1000));
			/*
			for (SceneNode s : getGameWorld())
			{
				if ( s.getWorldBound() != null)
				{
					if (s.getWorldBound().contains(cameraLoc))
					{
						// if the rectangle location is there, then remove rectangle etc.
						// except for treasurechest
						
						// increment score
						// call to increase size
						
					}
				}
			}
			*/
			// move camera

		}
/*		
		public boolean handleEvent(IGameEvent event)
		{
			CrashEvent c = (CrashEvent) event;
			int crashCount = c.getCrash();
			
			if (crashCount % 2 == 0)
					System.out.println("c0 get");
			else
					System.out.println("c1 get");
			return true;
		}
*/		
	}

package a1;
import sage.app.BaseGame;
import sage.camera.*;
import sage.display.*;
import sage.event.EventManager;
import sage.event.IEventListener;
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

import net.java.games.input.Controller;
import net.java.games.input.*;


public class treasurehunt2015 extends BaseGame implements IEventListener{
	// what type of objects are in the game
	Rectangle rect1;
	Sphere sph;
	Cylinder cyl;
	myNewTriMesh myT;
//	Cube treasureChest;
	IDisplaySystem display;
	ICamera camera;
	IInputManager im;
	IEventManager em;
	int numHit;
	private int score = 0;
	private HUDString scoreDisplay;
	private HUDString timeDisplay;
	private float time = 0;
	int crashInc = 0;
	
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
			MovementToggle movement = new MovementToggle();
			IAction quitGame = new QuitGameAction(this);
			IAction moveForward = new ForwardCameraMovement(camera, movement);
			IAction moveBackward = new BackCameraMovement(camera, movement);
			IAction moveLeft = new LeftCameraMovement(camera);
			IAction moveRight = new RightCameraMovement(camera);
			IAction rotateUp = new RotateUpCamera(camera);
			IAction rotateDown = new RotateDownCamera(camera);
	//		IAction rotateLeft = new RotateLeftCamera();
	//		IAction rotateRight = new RotateRightCamera();
		
			// create game controller actions
			
	//		IAction controllerX = new XAxisMovement();
	//		IAction controllerY = new YAxisMovement();
	//		IAction controllerRX = new RXAxisMovement();
	//		IAction controllerRY = new RYAxisMovement();
		
			/* figure out why laptop cannot run with im.associateAction */
			
			// Associate actions
			im.associateAction(kbName, net.java.games.input.Component.Identifier.Key.W, moveForward, 
					IInputManager.INPUT_ACTION_TYPE.REPEAT_WHILE_DOWN);
			im.associateAction(kbName, net.java.games.input.Component.Identifier.Key.S, moveBackward, 
					IInputManager.INPUT_ACTION_TYPE.REPEAT_WHILE_DOWN);			
			im.associateAction(kbName, net.java.games.input.Component.Identifier.Key.A, moveLeft, 
					IInputManager.INPUT_ACTION_TYPE.REPEAT_WHILE_DOWN);	
			im.associateAction(kbName, net.java.games.input.Component.Identifier.Key.D, moveRight, 
					IInputManager.INPUT_ACTION_TYPE.REPEAT_WHILE_DOWN);	
	//		im.associateAction(kbName, net.java.games.input.Component.Identifier.Key.LEFT, rotateLeft, 
	//				IInputManager.INPUT_ACTION_TYPE.REPEAT_WHILE_DOWN);	
	//		im.associateAction(kbName, net.java.games.input.Component.Identifier.Key.RIGHT, rotateRight, 
	//			IInputManager.INPUT_ACTION_TYPE.REPEAT_WHILE_DOWN);	
			im.associateAction(kbName, net.java.games.input.Component.Identifier.Key.UP, rotateUp, 
					IInputManager.INPUT_ACTION_TYPE.REPEAT_WHILE_DOWN);	
			im.associateAction(kbName, net.java.games.input.Component.Identifier.Key.DOWN, rotateDown, 
					IInputManager.INPUT_ACTION_TYPE.REPEAT_WHILE_DOWN);	
			im.associateAction(kbName, net.java.games.input.Component.Identifier.Key.ESCAPE, quitGame, 
					IInputManager.INPUT_ACTION_TYPE.ON_PRESS_ONLY);
			
			super.update(0.0f);
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
			float ax = rng.nextFloat()*(float)0.5;
			float ay = rng.nextFloat()*(float)0.5;
			
			rect1 = new Rectangle();
			Matrix3D rectM = rect1.getLocalTranslation();
			rectM.translate(ax, ay, 0);
			rect1.setLocalTranslation(rectM);
			addGameWorldObject(rect1);
			rect1.updateWorldBound();

			
			sph = new Sphere();
			Matrix3D sphM = sph.getLocalTranslation();
			sphM.translate(ax, ay, 0);
			sph.setLocalTranslation(sphM);
			addGameWorldObject(sph);
			sph.updateWorldBound();

			
			cyl = new Cylinder();
			Matrix3D cylM = cyl.getLocalTranslation();
			cylM.translate(ax, ay, 0);
			cyl.setLocalTranslation(cylM);
			addGameWorldObject(cyl);
			cyl.updateWorldBound();
			
			// triMesh
			myT = new myNewTriMesh();
			Matrix3D myTM = myT.getLocalTranslation();
			myTM.translate(ax, ay, 0);
			myT.setLocalTranslation(myTM);
			addGameWorldObject(myT);
			myT.updateWorldBound();


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

			// move camera
	/*		
			// collision 
			if (rect1.getLocalBound().contains(camera.getLocation()))
			{
				crashInc++;
				CrashEvent newCrash = new CrashEvent(crashInc);
				em.triggerEvent(newCrash);
				System.out.println("rectangle hit");
				score++;
				System.out.println("removing rectangle object.");
				removeGameWorldObject(rect1);
			}
			if (sph.getLocalBound().contains(camera.getLocation()))
			{
				crashInc++;
				CrashEvent newCrash = new CrashEvent(crashInc);
				em.triggerEvent(newCrash);
				System.out.println("sphere hit");
				score++;
				System.out.println("removing sphere object.");
				removeGameWorldObject(sph);
			}
			if (cyl.getLocalBound().contains(camera.getLocation()))
			{
				crashInc++;
				CrashEvent newCrash = new CrashEvent(crashInc);
				em.triggerEvent(newCrash);
				System.out.println("cylinder hit");
				score++;
				System.out.println("removing cylinder object.");
				removeGameWorldObject(cyl);
			}
			*/
		}

	}

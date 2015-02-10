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
	ICamera camera;
	IInputManager im;
	IEventManager em;
	private int score = 0;
	private float time = 0;
	private HUDString scoreD;
	private HUDString timeD;
	
		public void initGame() // override
		{	
			IInputManager im = getInputManager();
			// initialize Managers
			System.out.println("initGame call");
			initGameObjects();	
			
			String kbName = im.getKeyboardName();
			String gpName = im.getFirstGamepadName();
			
			// create actions
			IAction quitGame = new QuitGameAction(this);
			IAction moveForward = new ForwardCameraMovement(camera, 0.01f);
			
		//	im.associateAction(kbName, net.java.games.input.Component.Identifier.Key.W, moveForward, 
		//			IInputManager.INPUT_ACTION_TYPE.REPEAT_WHILE_DOWN);
		//	im.associateAction(kbName, net.java.games.input.Component.Identifier.Key.ESCAPE, quitGame, 
		//			IInputManager.INPUT_ACTION_TYPE.ON_PRESS_ONLY);
		}
			
		public void initGameObjects()
		{
			display = getDisplaySystem();
			display.setTitle("Treasure Hunt 2015");
			
			// testing out camera
			camera = display.getRenderer().getCamera();
			camera.setPerspectiveFrustum(45, 1, 0.01, 1000);
			camera.setLocation(new Point3D(1, 1, 20));
			
			
			// score
			timeD = new HUDString("Time: " + time);
			timeD.setLocation(0,0.05);
			addGameWorldObject(timeD);
			scoreD = new HUDString("Score: " + time);
			addGameWorldObject(scoreD);
			
			// 	
		//	Rectangle rect1 = new Rectangle(); // create objects in random x,y,z positions - merge to 3d soon
		//	addGameWorldObject(rect1);
			
			
			// current error with teapot problem
		//	Teapot tp1 = new Teapot();
			// Matrix3D tM = tp1.getLocalTranslation();
			// tM.translate(1, 1, 1);
			// tp1.setLocalTranslation(tM);
		//	addGameWorldObject(tp1);
			
		//	Quad qd1 = new Quad();
		//	addGameWorldObject(qd1);
			
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

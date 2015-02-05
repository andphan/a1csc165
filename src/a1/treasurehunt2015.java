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

import net.java.games.input.Event;


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
	myNewTriMesh aPyr;
	Rectangle rect;
	private int score = 0;
	private float time = 0;
	private HUDString scoreD;
	private HUDString timeD;
	
		public void initGame()
		{	
			IInputManager im = getInputManager();
			// initialize Managers
			System.out.println("initGame call");
				
			//keyboard and gamepad inputs
			String kbName = im.getKeyboardName();
			// String gpName = im.getFirstGamepadName();
			
			// actions
			IAction quitGame = new QuitGameAction(this);
			
			// action associations
			im.associateAction(kbName, net.java.games.input.Component.Identifier.Key.ESCAPE,
					quitGame, IInputManager.INPUT_ACTION_TYPE.ON_PRESS_ONLY);
			// end
		}
			
		public void initGameObjects()
		{
			display = getDisplaySystem();
			display.setTitle("hey");
			camera = display.getRenderer().getCamera();
			camera.setPerspectiveFrustum(45, 1, 0.01, 1000);
			camera.setLocation(new Point3D(1,1, 20));
			
			/*
			rect = new Rectangle();
			Matrix3D rectM = rect.getLocalTranslation();
			rectM.translate(-1, 1, -5);
			rect.setLocalTranslation(rectM);
			addGameWorldObject(rect);
			
			aPyr = new myNewTriMesh();
			Matrix3D pyrM = aPyr.getLocalTranslation();
			pyrM.translate(2, 2, -8);
			aPyr.setLocalTranslation(pyrM);
			addGameWorldObject(aPyr);
			
			*/
			Point3D origin = new Point3D(0, 0, 0);
			Point3D xEnd = new Point3D(100, 0, 0);
			Point3D yEnd = new Point3D(0, 100, 0);
			Point3D zEnd = new Point3D(0, 0, 100);
			Line xAxis = new Line (origin, xEnd, Color.red, 2);
			Line yAxis = new Line (origin, yEnd, Color.green, 2);
			Line zAxis = new Line (origin, zEnd, Color.blue, 2);
			addGameWorldObject(xAxis);
			addGameWorldObject(yAxis);
			addGameWorldObject(zAxis);
			
		}
		public void update(float ElapsedTimeMS)
		{
			// overwritten
			
			// move camera
			
		
		}
		
			// must handle input actions sage.input.action.IAction, InputManager.associateAction()
		// A/D/W/S
		// left arrow / right - rotate camera around it's yaw
		// up / down arrow - rotate camera around its pitch
		// escape - quit game s
		
		// controller input
		
		public class leftTurn extends AbstractInputAction
		{
			public void performAction(float time, Event e)
			{
				
			}
		}
	}

package a1;
import sage.app.BaseGame;
import sage.camera.*;
import sage.display.*;
import sage.input.*;
import sage.input.action.*;
import sage.scene.*;
import sage.scene.shape.*;
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
			
			// action associations
			
			// end
		//	display.addMouseListener(this);
		}
			
		public void initGameObjects()
		{
			display = getDisplaySystem();
			display.setTitle("hey");
			camera = display.getRenderer().getCamera();
			camera.setPerspectiveFrustum(45, 1, 0.01, 1000);
			camera.setLocation(new Point3D(1,1, 20));
			
			Point3D origin = new Point3D(0, 0, 0);
			
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
		public void mousePressed(MouseEvent e)
		{
			// testin
		}
		
		
		public class leftTurn extends AbstractInputAction
		{
			public void performAction(float time, Event e)
			{
				
			}
		}
	}

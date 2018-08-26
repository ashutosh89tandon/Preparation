package designpattern.command;

public class RemoteControlTest {

	// A simple Java program to demonstrate
	// implementation of Command Pattern using
	// a remote control example.



	
	static class LightOnCommand implements Command
	{
		Light light;

		// The constructor is passed the light it
		// is going to control.
		public LightOnCommand(Light light)
		{
			this.light = light;
		}
		public void execute()
		{
			light.on();
		}
	}
	static class LightOffCommand implements Command
	{
		Light light;
		public LightOffCommand(Light light)
		{
			this.light = light;
		}
		public void execute()
		{
			light.off();
		}
	}

	// Stereo and its command classes
	static class Stereo
	{
		public void on()
		{
			System.out.println("Stereo is on");
		}
		public void off()
		{
			System.out.println("Stereo is off");
		}
		public void setCD()
		{
			System.out.println("Stereo is set " +
					"for CD input");
		}
		public void setDVD()
		{
			System.out.println("Stereo is set"+
					" for DVD input");
		}
		public void setRadio()
		{
			System.out.println("Stereo is set" +
					" for Radio");
		}
		public void setVolume(int volume)
		{
			// code to set the volume
			System.out.println("Stereo volume set"
					+ " to " + volume);
		}
	}
	static class StereoOffCommand implements Command
	{
		Stereo stereo;
		public StereoOffCommand(Stereo stereo)
		{
			this.stereo = stereo;
		}
		public void execute()
		{
			stereo.off();
		}
	}
	static class StereoOnWithCDCommand implements Command
	{
		Stereo stereo;
		public StereoOnWithCDCommand(Stereo stereo)
		{
			this.stereo = stereo;
		}
		public void execute()
		{
			stereo.on();
			stereo.setCD();
			stereo.setVolume(11);
		}
	}

	// A Simple remote control with one button
	static class SimpleRemoteControl
	{
		Command slot;  // only one button

		public SimpleRemoteControl()
		{
		}

		public void setCommand(Command command)
		{
			// set the command the remote will
			// execute
			slot = command;
		}

		public void buttonWasPressed()
		{
			slot.execute();
		}
	}


	public static void main(String[] args)
	{
		SimpleRemoteControl remote =
				new SimpleRemoteControl();
		Light light = new Light();
		Stereo stereo = new Stereo();

		// we can change command dynamically
		remote.setCommand(new
				LightOnCommand(light));
		remote.buttonWasPressed();
		remote.setCommand(new
				StereoOnWithCDCommand(stereo));
		remote.buttonWasPressed();
		remote.setCommand(new
				StereoOffCommand(stereo));
		remote.buttonWasPressed();
	}

}

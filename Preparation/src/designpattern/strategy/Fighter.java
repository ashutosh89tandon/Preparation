package designpattern.strategy;

public class Fighter 
{
	private JumpBehavior jumpBehavior;
	private KickBehavior kickBehavior;
	public Fighter(JumpBehavior jumpBehavior, KickBehavior kickBehavior) {
		super();
		this.jumpBehavior = jumpBehavior;
		this.kickBehavior = kickBehavior;
	}
	public JumpBehavior getJumpBehavior() {
		return jumpBehavior;
	}
	public void setJumpBehavior(JumpBehavior jumpBehavior) {
		this.jumpBehavior = jumpBehavior;
	}
	public KickBehavior getKickBehavior() {
		return kickBehavior;
	}
	public void setKickBehavior(KickBehavior kickBehavior) {
		this.kickBehavior = kickBehavior;
	}
	
	public void kick()
	{
		kickBehavior.kick();
		
	}
	
	public void jump()
	{
		jumpBehavior.jump();
	}
}

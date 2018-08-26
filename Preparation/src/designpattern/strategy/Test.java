package designpattern.strategy;

public class Test {

	public static void main(String[] args) {
		Fighter fighter=new Fighter(new JumpBehavior(),new KickBehavior());
		fighter.jump();
		fighter.kick();
		
		fighter=new Fighter(new LongJump(),new TornadoKick());
		fighter.jump();
		fighter.kick();
	}
}

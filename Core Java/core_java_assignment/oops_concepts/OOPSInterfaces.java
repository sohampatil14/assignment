package oops_concepts;

/**
 * Interfaces -
 * 1. Declaring Interface
 * 2. Implementing Interface
 * 3. Extending Interface
 * 4. Multiple Inheritance using Interfaces
 */

interface CharacterMoves {
	void moveLeft();
    void moveRight();
    void duck();
    void jump();
}

interface CharacterPowerUps extends CharacterMoves {
	void doubleSpeed();
	void coinMagent();
	void extraLife();
	void timedInvincibility(int seconds);
}

interface ChristmasTheme {
	void addSnow();
	void bellSound();
	void redPreset();
}

enum Preset {
	Red,
	Green,
	White,
	Blue,
}

class DefaultCharacter implements CharacterMoves, CharacterPowerUps {

	float position;
	int speed;
	int lives;
	int invincibilityTime;
	boolean isdoubleSpeedOn;
	boolean isCoinMagnetOn;
	boolean isTimedInvincibilityOn;
	
	public DefaultCharacter() {
		this.position = 0;
		this.speed = 1;
		this.lives = 3;
		this.invincibilityTime = 0;
	}
	
	@Override
	public void doubleSpeed() {
		speed *= 2;
		this.isdoubleSpeedOn = true;
	}

	@Override
	public void coinMagent() {
		this.isCoinMagnetOn = true;
	}

	@Override
	public void extraLife() {
		this.lives += 1;
	}

	@Override
	public void timedInvincibility(int seconds) {
		this.invincibilityTime = seconds;
		this.isTimedInvincibilityOn = true;
	}

	@Override
	public void moveLeft() {
		this.position = -1;
	}

	@Override
	public void moveRight() {
		this.position = 1;
	}

	@Override
	public void duck() {
		this.position = -0.5f;
	}

	@Override
	public void jump() {
		this.position = 0.5f;
	}
	
}

class ChristmasThemedCharacter extends DefaultCharacter implements ChristmasTheme{
	
	String theme;
	Preset themePreset;
	Preset decorationPreset;
	boolean playBellSound;
	
	ChristmasThemedCharacter() {
		theme = "Christmas Theme";
	}

	@Override
	public void addSnow() {
		decorationPreset = Preset.White;
	}

	@Override
	public void bellSound() {
		playBellSound = true;
	}

	@Override
	public void redPreset() {
		themePreset = Preset.Red;
	}
}

public class OOPSInterfaces {

	public static void main(String[] args) {
		DefaultCharacter defaultCharacter = new DefaultCharacter();
		ChristmasThemedCharacter christmasCharacter = new ChristmasThemedCharacter(); 
	}

}

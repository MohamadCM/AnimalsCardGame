package HW6.Q3;

/**
 * This class is used to create different kind of animals
 * and implements their abilities and behaviours
 * @author Mohamad Chaman-Motlagh
 * @version 1
 */
public class Animal {
    private String name;
    private int stamina;
    private int health;
    private String attackType1;
    private int attackType1Power;
    private String attackType2;
    private int attackType2Power;

    /**
     * Each animal needs a name, stamina and health to get created
     * @param name
     * @param stamina
     * @param health
     */
    public Animal(String name, int stamina, int health) {
        this.name = name;
        this.stamina = stamina;
        this.health = health;
    }

    /**
     * @return attack type 1 name
     */
    public String getAttackType1() {
        return attackType1;
    }

    /**
     * Sets attack type 1 name
     * @param attackType1
     */
    public void setAttackType1(String attackType1) {
        this.attackType1 = attackType1;
    }

    /**
     * @return attack type 1 power
     */
    public int getAttackType1Power() {
        return attackType1Power;
    }

    /**
     * Sets attack type 1 power
     * @param attackType1Power
     */
    public void setAttackType1Power(int attackType1Power) {
        this.attackType1Power = attackType1Power;
    }

    /**
     * @return attack type 2 name
     */
    public String getAttackType2() {
        return attackType2;
    }

    /**
     * Sets attack type 2 name
     * @param attackType2
     */
    public void setAttackType2(String attackType2) {
        this.attackType2 = attackType2;
    }

    /**
     * Sets attack type 2 power
     * @param attackType2Power
     */
    public void setAttackType1Power2(int attackType2Power) {
        this.attackType2Power = attackType2Power;
    }

    /**
     * @return attack type 2 power
     */
    public int getAttackType2Power() {
        return attackType2Power;
    }

    /**
     * @return name of animal
     */
    public String getName() {
        return name;
    }

    /**
     * @return health of animal
     */
    public int getHealth() {
        return health;
    }

    /**
     * Sets health for current animal
     * @param health
     */
    public void setHealth(int health)
    {
        this.health = health;
    }
    /**
     * @return stamina of animal
     */
    public int getStamina() {
        return stamina;
    }

    /**
     * Sets stamina for animal
     * @param stamina
     */
    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    /**
     * @return {@code true} if the animal is dead, {@code false} otherwise
     */
    public boolean isDead()
    {
        if(health <= 0)
            return true;
        return false;
    }
}

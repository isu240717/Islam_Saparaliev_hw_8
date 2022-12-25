package kg.geektech.game.players;

import kg.geektech.game.general.RPG_Game;

public class Magic extends Hero {
    private int BoostDamage;

    public Magic(int health, int damage, String name) {
        super(health, damage, name, SuperAbility.BOOST);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        int coefficient = RPG_Game.random.nextInt(1) + 1;
        for (int i = 0; i < heroes.length; i++) {
            heroes[i].setDamage(heroes[i].getDamage() + coefficient * this.getDamage());
            if (heroes[i].getDamage() > 0 && (heroes[i] != this)){
                heroes[i].setDamage(heroes[i].getDamage() + this.BoostDamage);
                System.out.println("Magic boost damage" + coefficient * this.getDamage());

            }
        }
    }
}
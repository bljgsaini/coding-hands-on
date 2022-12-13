package designPattern.behavioral.templatePattern.makePizza.exercise2.end;

public class Base {

    public void pickUpWeapon(){}

    public void defenseAction(){}

    public void moveToSafety(){}

    public void defendAgainstAttack() {
        pickUpWeapon();
        defenseAction();
        moveToSafety();
        System.out.println();
    }
}

package Zoo;

public class Main {
    public static void main(String []args){
        Dog dog = new Dog();
        dog.setDogName("大黄");
        System.out.println("狗的名字是"+dog.getDogName());
        dog.compute();

        Fish fish = new Fish();
        fish.setFishName("小丑鱼");
        System.out.println("有一条鱼叫"+fish.getFishName());
        fish.swim();
    }
}

package Zoo;

public class Fish extends Animal {
    public void setFishName(String name){
        super.setName(name);
    }
    public String getFishName(){
        return super.getName();
    }
    public void setFishColor(String color){
        super.setColor(color);
    }
    public String getFishColor(){
        return super.getColor();
    }
    public void setFishBrand(String brand){
        super.setBrand(brand);
    }
    public String getFishBrand(String brand){
        return super.getBrand();
    }
    public void shout(){
        System.out.println("我是一条鱼");
    }
    public void swim(){
        System.out.println("漫无目的地游着");
    }
    public void LifeEnvironment(){
        System.out.println("水生");
    }
}

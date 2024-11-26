package Zoo;

public class Dog extends Animal implements Train{
    public void setDogName(String name){
        super.setName(name);
    }
    public String getDogName(){
        return super.getName();
    }
    public void setDogBrand(String brand){
        super.setBrand(brand);
    }
    public String getDogBrand(){
        return super.getBrand();
    }
    public void setDogColor(String color){
        super.setColor(color);
    }
    public String getDogColor(){
        return super.getColor();
    }
    public void shout(){
        System.out.println("汪汪汪");
    }
    public void dance(){
        System.out.println("欢快地舞蹈");
    }
    public void compute(){
        System.out.println("大黄会计算");
    };
    public void LifeEnvironment(){
        System.out.println("陆生");
    }
}

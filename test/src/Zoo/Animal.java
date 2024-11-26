package Zoo;

public abstract class Animal {
    private String name;
    private String color;
    private String brand;
    private String species;
    public abstract void shout();
    public abstract void LifeEnvironment();
    public void setBrand(String brand){
        this.brand=brand;
    }
    public String getBrand(){
        return brand;
    }
    public void setName(String name){this.name=name;}
    public String getName(){return name;}
    public void setColor(String color){this.color=color;}
    public String getColor(){return color;}

}

public class ComputerManage {
    public static void searchComputer(Computer[] computers,String brand) {
        boolean found = false;
        for (Computer computer : computers) {
            if (computer.getBrand().equals(brand)) {
                found = true;
                break;
            }
        }
        if (found) {
            System.out.println("存在品牌为" + brand + "的电脑");
        } else {
            System.out.println("不存在品牌为" + brand + "的电脑");
        }
    }

    public static void searchContainBrandComputer(Computer[] computers, String containBrand){
        for (Computer computer : computers) {
            if (computer.getBrand().contains(containBrand)) {
                System.out.println("名字包含IBM的电脑是："+computer.getBrand());
            }
        }
    }

    public static void searchStartBrandComputer(Computer[] computers, String startName){
        for (Computer computer : computers) {
            if (computer.getBrand().contains(startName)) {
                System.out.println("品牌以IBM开头的电脑是："+computer.getBrand());
            }
        }
    }

    public static void searchPriceComputer(Computer[] computers, int minPrice, int maxPrice){
        for(Computer computer : computers){
            if(computer.getPrice()<maxPrice && computer.getPrice()>minPrice){
                System.out.println("价格在3000-5000的电脑有："+computer.getPrice());
            }
        }
    }
}

package Class;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class Constant {
    // 小组、学生等文件路径
    public static final String FILE_PATH = "D:\\面向对象程序设计\\ideaIC-2023.2.win\\workspace\\test\\src\\work_class";
    // 班级路径
    public static String CLASS_PATH = " ";
    // 存放当前班级的小组和学生
    //public static LinkedHashMap<Group, List<Student>> groups = new LinkedHashMap<>();
    public  static  List<String> groupelist = new ArrayList<>();
    // 存放当前班级的所有学生
    public static List<Student> students = new ArrayList<Student>();

    // 班级集合
    public static List<String> classes = new ArrayList<>();
    public static List<String> groupes = new ArrayList<>();

    // 添加班级方法
//    public static void addClass(String className) {
//        classes.add(className);
//    }

//    public static void main(String[] args) {
//
//
//    }
}
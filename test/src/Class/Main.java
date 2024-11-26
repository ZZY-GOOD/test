/*package Class;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();

        Student[] students1 = new Student[6];
        Student[] students2 = new Student[6];
        students1[0] = new Student();
        students1[0].name="张三";
        students1[0].sex="男";
        students1[0].IdCard="0001";

        students1[1] = new Student();
        students1[1].name="李四";
        students1[1].sex="男";
        students1[1].IdCard="0002";

        students1[2] = new Student();
        students1[2].name="王五";
        students1[2].sex="女";
        students1[2].IdCard="0003";

        students1[3] = new Student();
        students1[3].name="赵六";
        students1[3].sex="女";
        students1[3].IdCard="0004";

        students1[4]= new Student();
        students1[4].name = "郑七";
        students1[4].sex = "男";
        students1[4].IdCard = "0005";

        students1[5] = new Student();
        students1[5].name = "吴八";
        students1[5].sex = "女";
        students1[5].IdCard = "0006";

        students2[0] = new Student();
        students2[0].name = "周九";
        students2[0].sex = "女";
        students2[0].IdCard = "0007";

        students2[1] = new Student();
        students2[1].name = "钱多多";
        students2[1].sex = "男";
        students2[1].IdCard = "0008";

        students2[2] = new Student();
        students2[2].name = "冯十二";
        students2[2].sex = "男";
        students2[2].IdCard = "0009";

        students2[3] = new Student();
        students2[3].name = "陈长生";
        students2[3].sex = "男";
        students2[3].IdCard = "00010";

        students2[4] = new Student();
        students2[4].name = "林七夜";
        students2[4].sex = "男";
        students2[4].IdCard = "0011";

        students2[5] = new Student();
        students2[5].name = "伽蓝";
        students2[5].sex = "女";
        students2[5].IdCard = "0012";

        Group[] groups1 = new Group[3];
        Group[] groups2 = new Group[3];

        Group group1 = new Group();
        group1.groupName = "勇于超越";
        Student[] groupMembers1 = {students1[0], students1[1]};
        group1.groupMembers = groupMembers1;
        groups1[0] = group1;

        Group group2 =new Group();
        group2.groupName = "木子组";
        Student[] groupMembers2 = {students1[2],students1[3]};
        group2.groupMembers = groupMembers2;
        groups1[1] = group2;

        Group group3 =new Group();
        group3.groupName = "666组";
        Student[] groupMembers3 = {students1[4],students1[5]};
        group3.groupMembers = groupMembers3;
        groups1[2] = group3;

        Group group4 =new Group();
        group4.groupName = "888组";
        Student[] groupMembers4 = {students2[0],students2[1]};
        group4.groupMembers = groupMembers4;
        groups2[0] = group4;

        Group group5 =new Group();
        group5.groupName = "艰苦奋斗组";
        Student[] groupMembers5 = {students2[2],students2[3]};
        group5.groupMembers = groupMembers5;
        groups2[1] = group5;

        Group group6 =new Group();
        group6.groupName = "夜幕组";
        Student[] groupMembers6 = {students2[4],students2[5]};
        group6.groupMembers = groupMembers6;
        groups2[2] = group6;

        Class[] classes = new Class[2];

        Class class1 = new Class();
        class1.classId = "1班";
        Group[] classgroup1 = {groups1[0],groups1[1],groups1[2]};
        class1.groupsNames = classgroup1;
        classes[0] = class1;

        Class class2 = new Class();
        class2.classId = "2班";
        Group[] classgroup2 = {groups2[0],groups2[1],groups2[2]};
        class2.groupsNames = classgroup1;
        classes[1] = class2;

        Scanner choice = new Scanner(System.in);
        System.out.println("请选择班级：");
        int classChoice = choice.nextInt();

        switch (classChoice) {
            case 1:
                System.out.println("1班");
                System.out.println("请选择抽取方式");
                System.out.println("1、在全班抽取  2、先抽取小组，再抽取学生");
                int callChoice1 = choice.nextInt();
                switch (callChoice1) {
                    case 1:
                        OneCall oneCall = new OneCall();
                        Student randomStudent = oneCall.randomStudent(students1);
                        System.out.println(randomStudent.name + "被抽中了");
                        break;
                    case 2:
                        int randomGroupIndex = random.nextInt(classgroup1.length);
                        Group randomGroup = classgroup1[randomGroupIndex];
                        System.out.println("组名: " + randomGroup.groupName);

                        int randomStudentIndex = random.nextInt(randomGroup.groupMembers.length);
                        Student randomMember = randomGroup.groupMembers[randomStudentIndex];
                        System.out.println(randomMember.name);
                        break;
                }
                break;
            case 2:
                System.out.println("2班");
                System.out.println("请选择抽取方式");
                System.out.println("1、在全班抽取  2、先抽取小组，再抽取学生");
                int callChoice2 = choice.nextInt();
                switch (callChoice2) {
                    case 1:
                        OneCall oneCall = new OneCall();
                        Student randomStudent = oneCall.randomStudent(students2);
                        System.out.println(randomStudent.name + "被抽中了");
                        break;
                    case 2:
                        int randomGroupIndex = random.nextInt(classgroup2.length);
                        Group randomGroup = classgroup2[randomGroupIndex];
                        System.out.println("组名: " + randomGroup.groupName);

                        int randomStudentIndex = random.nextInt(randomGroup.groupMembers.length);
                        Student randomMember = randomGroup.groupMembers[randomStudentIndex];
                        System.out.println(randomMember.name);
                        break;
                }
                break;
        }
    }
}*/


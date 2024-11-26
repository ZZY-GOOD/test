package Class;

import java.awt.*;
import java.io.IOException;
import javax.swing.*;
public class MainFrame extends JFrame  {
    public MainFrame() {
        this.getContentPane().setLayout(new BorderLayout());
        initMenu();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //设置一个关闭窗口
        this.setSize(600, 600);         //setSize()设置窗口大小
        this.setVisible(true);           //setVisible(true)  让窗口显示出来	}
    }
    public void initMenu(){
        JMenuBar mainMenu = new JMenuBar();
        JMenu fileMenu = new JMenu("文件");
        JMenuItem changeClassMenuItem = new JMenuItem("切换当前班");
        JMenuItem exportScoreMenuItem = new JMenuItem("导出当前班成绩");
        JMenuItem exitMenuItem = new JMenuItem("退出");

        JMenu classMenu = new JMenu("班级管理");
        JMenuItem addClassMenuItem = new JMenuItem("新增班级");
        JMenuItem classListMenuItem = new JMenuItem("班级列表");

        JMenu groupMenu = new JMenu("小组管理");
        JMenuItem addGroupMenuItem = new JMenuItem("新增小组");
        JMenuItem groupListMenuItem = new JMenuItem("小组列表");

        JMenu studentMenu = new JMenu("学生管理");
        JMenuItem addStudentMenuItem = new JMenuItem("新增学生");
        JMenuItem studentListMenuItem = new JMenuItem("学生列表");

        JMenu onClassMenu = new JMenu("课堂管理");
        JMenuItem randomGroupMenuItem = new JMenuItem("随机小组");
        JMenuItem randomStudentMenuItem = new JMenuItem("随机学生");
        this.getContentPane().add(mainMenu,BorderLayout.NORTH);
        mainMenu.add(fileMenu);
        mainMenu.add(classMenu);
        mainMenu.add(groupMenu);
        mainMenu.add(studentMenu);
        mainMenu.add(onClassMenu);
        fileMenu.add(changeClassMenuItem);
        fileMenu.add(exportScoreMenuItem);
        fileMenu.add(exitMenuItem);
        classMenu.add(addClassMenuItem);
        classMenu.add(classListMenuItem);
        groupMenu.add(addGroupMenuItem);
        groupMenu.add(groupListMenuItem);
        studentMenu.add(addStudentMenuItem);
        studentMenu.add(studentListMenuItem);
        onClassMenu.add(randomGroupMenuItem);
        onClassMenu.add(randomStudentMenuItem);

        changeClassMenuItem.addActionListener(e ->{
            this.getContentPane().removeAll();
            initMenu();
            ChangeClassPanel changeclassPanel = new ChangeClassPanel(this);
            this.getContentPane().add(changeclassPanel,BorderLayout.CENTER);
            this.getContentPane().validate();
        });
        addClassMenuItem.addActionListener(e -> {
            this.getContentPane().removeAll();
            initMenu();
            ClassAddPanel classAddPanel = new ClassAddPanel();
            this.getContentPane().add(classAddPanel, BorderLayout.CENTER);
            this.getContentPane().validate();
        });
        classListMenuItem.addActionListener(e -> {
            this.getContentPane().removeAll();
            initMenu();
            ClassListPanel classListPanel = new ClassListPanel();
            this.getContentPane().add(classListPanel, BorderLayout.CENTER);
            this.getContentPane().validate();
        });
        addGroupMenuItem.addActionListener(e -> {
            if (Constant.CLASS_PATH.isEmpty()) {
                JOptionPane.showMessageDialog(this, "请先选择班级", "", JOptionPane.INFORMATION_MESSAGE);
            } else {
                this.getContentPane().removeAll();
                initMenu();
                this.getContentPane().add(new GroupAddPanel(), BorderLayout.CENTER);
                this.getContentPane().repaint();
                this.getContentPane().validate();
            }
        });
        groupListMenuItem.addActionListener(e -> {
            if (Constant.CLASS_PATH.isEmpty()) {
                JOptionPane.showMessageDialog(this, "请先选择班级", "", JOptionPane.INFORMATION_MESSAGE);
            } else {
                this.getContentPane().removeAll();
                initMenu();
                try {
                    this.getContentPane().add(new GroupListPanel(), BorderLayout.CENTER);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                this.getContentPane().repaint();
                this.getContentPane().validate();
            }
        });
        addStudentMenuItem.addActionListener(e -> {
            if (Constant.CLASS_PATH.isEmpty()) {
                JOptionPane.showMessageDialog(this, "请先选择班级", "", JOptionPane.INFORMATION_MESSAGE);
            } else {
                this.getContentPane().removeAll();
                initMenu();
                this.getContentPane().add(new StudentAddPanel(), BorderLayout.CENTER);
                this.getContentPane().repaint();
                this.getContentPane().validate();
            }
        });
        studentListMenuItem.addActionListener(e -> {
            if (Constant.CLASS_PATH.isEmpty()) {
                JOptionPane.showMessageDialog(this, "请先选择班级", "", JOptionPane.INFORMATION_MESSAGE);
            } else {
                this.getContentPane().removeAll();
                initMenu();
                try {
                    this.getContentPane().add(new StudentListPanel(), BorderLayout.CENTER);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                this.getContentPane().repaint();
                this.getContentPane().validate();
            }
        });
        randomGroupMenuItem.addActionListener(e -> {
            if (Constant.CLASS_PATH.isEmpty()) {
                JOptionPane.showMessageDialog(this, "请先选择班级", "", JOptionPane.INFORMATION_MESSAGE);
            } else {
                this.getContentPane().removeAll();
                initMenu();
                this.getContentPane().add(new RandomGroupPanel(), BorderLayout.CENTER);
                this.getContentPane().repaint();
                this.getContentPane().validate();
            }
        });
        randomStudentMenuItem.addActionListener(e -> {
            if (Constant.CLASS_PATH.isEmpty()) {
                JOptionPane.showMessageDialog(this, "请先选择班级", "", JOptionPane.INFORMATION_MESSAGE);
            } else {
                this.getContentPane().removeAll();
                initMenu();
                this.getContentPane().add(new RandomStudentPanel(), BorderLayout.CENTER);
                this.getContentPane().repaint();
                this.getContentPane().validate();
            }
        });
    }
}
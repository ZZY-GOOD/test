package Class;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.io.*;
import java.util.Enumeration;

import static Class.Constant.*;

public class ChangeClassPanel extends JPanel {
    JLabel infoLbl = new JLabel();

    public ChangeClassPanel(MainFrame mainFrame) {
        this.setBorder(new TitledBorder(new EtchedBorder(), "新选择班级"));
        int x = 160, y = 100;
        this.setLayout(null);
        // 读取目录获取班级
        File directory = new File("D:\\面向对象程序设计\\ideaIC-2023.2.win\\workspace\\test\\src\\work_class"); // 设置要读取的目录路径
        File[] files = directory.listFiles(); // 获取目录下的所有文件和目录
//        File[] files = null;
        if (files == null || files.length == 0) {
            JOptionPane.showMessageDialog(this, "请先创建班级", "", JOptionPane.INFORMATION_MESSAGE);
        } else {
            ButtonGroup btnGroup = new ButtonGroup();
            for (File file : files) {
                if (file.isDirectory()) {
                    JRadioButton classRadio = new JRadioButton(file.getName());
                    btnGroup.add(classRadio);
                    this.add(classRadio);
                    classRadio.setBounds(x, y, 200, 30);
                    y += 40;
                }
            }
            JButton btnChooseClass = new JButton("确认选择班级");
            this.add(btnChooseClass);
            btnChooseClass.setBounds(x, y, 120, 30);
            btnChooseClass.addActionListener(e -> {
                Enumeration<AbstractButton> elements = btnGroup.getElements();
                boolean isSelected = false;
                while (elements.hasMoreElements()) {
                    JRadioButton btn = (JRadioButton) elements.nextElement();
                    if (btn.isSelected()) {
                        isSelected = true;
                        mainFrame.setTitle(btn.getText());
                        Constant.CLASS_PATH = btn.getText();
                        infoLbl.setText("班级：" + btn.getText() + "，班级学生总数：");
                        break;
                    }
                }
                if (isSelected) {
                    // TODO 初始化小组和学生
                    try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH+File.separator+CLASS_PATH+"\\students.txt"))) {
                        String line= br.readLine();
                        while (line != null) {
                            String[] data = line.split("，");
                            Student student = new Student();
                            student.setName(data[0]);
                            // student.setName = data[0];
                            // int age = Integer.parseInt(data[1]);
                            //String gender = data[2];
                            students.add(student);
                            line = br.readLine();
                        }
                    } catch (Exception e1) {
                        e1.printStackTrace();
                        JOptionPane.showMessageDialog(this, "初始化小组和学生信息失败，请检查相关文件", "", JOptionPane.INFORMATION_MESSAGE);
                    }
                    this.removeAll();
                    infoLbl.setText(infoLbl.getText() + students.size());
                    infoLbl.setBounds(160, 100, 200, 30);
                    this.add(infoLbl);
                    this.repaint();
                    this.validate();
                }
                     else {
                    JOptionPane.showMessageDialog(this, "请先选择班级", "", JOptionPane.INFORMATION_MESSAGE);
                }
                students.clear();
            });
            this.repaint();
            this.validate();
        }
    }
}



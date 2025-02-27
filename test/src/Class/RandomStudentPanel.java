package Class;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;


public class RandomStudentPanel extends JPanel {
    private JLabel lbl2 = new JLabel("学生姓名：");
    private JLabel lbl3 = new JLabel("学生照片：");
    private JLabel lblPic = new JLabel("照片");
    private JTextField txtStudent = new JTextField();
    private JButton btnChooseStudent = new JButton("随机学生");
    private JButton btnAbsence = new JButton("缺勤");
    private JButton btnLeave = new JButton("请假");
    private JButton btnAnswer = new JButton("答题");
    Thread threadStudent = null;   // 随机抽取小组的线程

    public RandomStudentPanel() {
        this.setBorder(new TitledBorder(new EtchedBorder(), "随机学生点名"));
        this.setLayout(null);
        this.add(lbl2);
        this.add(lbl3);
        this.add(txtStudent);
        this.add(lblPic);
        this.add(btnChooseStudent);
        this.add(btnAbsence);
        this.add(btnLeave);
        this.add(btnAnswer);

        lbl2.setBounds(160, 50, 100, 30);
        txtStudent.setBounds(160, 90, 130, 30);
        txtStudent.setEditable(false);
        lblPic.setBounds(160, 130, 130, 150);
        btnChooseStudent.setBounds(160, 300, 130, 30);
        btnAbsence.setBounds(160, 340, 60, 30);
        btnLeave.setBounds(230, 340, 60, 30);
        btnAnswer.setBounds(300, 340, 60, 30);

        // TODO 随机学生
        btnChooseStudent.addActionListener(e -> {
            if (e.getActionCommand().equals("停")) {
                btnChooseStudent.setText("随机学生");
                threadStudent.interrupt();
            } else {
                btnChooseStudent.setText("停");
                threadStudent = new Thread(() -> {
                    try {
                        List<String> studentNames = new ArrayList<>();
                        // 读取student.txt文件
                        BufferedReader reader = new BufferedReader(new FileReader(Constant.FILE_PATH+ File.separator+Constant.CLASS_PATH+"\\students.txt"));
                        String line;
                        while ((line = reader.readLine()) != null) {
                            String[] data = line.split("，");
                            if (data.length >= 2) {
                                studentNames.add(data[1]); // 学生姓名是第二个数据
                            }
                        }
                        reader.close();

                        // 如果没有学生数据，弹出提示
                        if (studentNames.isEmpty()) {
                            JOptionPane.showMessageDialog(this, "学生数据为空", "", JOptionPane.INFORMATION_MESSAGE);
                            return;
                        }

                        // 随机选择一个学生姓名
                        Random random = new Random();
                        int index = random.nextInt(studentNames.size());
                        String randomStudent = studentNames.get(index);

                        // 更新界面显示
                        SwingUtilities.invokeLater(() -> {
                            txtStudent.setText(randomStudent);
                        });

                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(this, "读取学生数据失败", "", JOptionPane.ERROR_MESSAGE);
                        ex.printStackTrace();
                    }
                });

                threadStudent.start(); // 启动新线程
            }
        });
        // TODO 缺勤
        btnAbsence.addActionListener(e -> {
            if (txtStudent.getText() == null || txtStudent.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "请先随机选择学生", "", JOptionPane.INFORMATION_MESSAGE);
            } else {

                JOptionPane.showMessageDialog(this, "已记录缺勤", "", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        // TODO 请假
        btnLeave.addActionListener(e -> {
            if (txtStudent.getText() == null || txtStudent.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "请先随机选择学生", "", JOptionPane.INFORMATION_MESSAGE);
            } else {

                JOptionPane.showMessageDialog(this, "已记录请假", "", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        // TODO 答题
        btnAnswer.addActionListener(e -> {
            if (txtStudent.getText() == null || txtStudent.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "请先随机选择学生", "", JOptionPane.INFORMATION_MESSAGE);
            } else {

                JOptionPane.showMessageDialog(this, "回答正确", "", JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }
}

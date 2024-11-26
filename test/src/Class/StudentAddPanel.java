package Class;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;

public class StudentAddPanel extends JPanel {
    public StudentAddPanel() {
        this.setLayout(null);
        this.setBorder(new TitledBorder(new EtchedBorder(), "新增学生"));
        JLabel lblId = new JLabel("学号：");
        JTextField txtId = new JTextField();
        JLabel lblName = new JLabel("姓名：");
        JTextField txtName = new JTextField();
        JLabel lblGroup = new JLabel("小组:");
        JComboBox<String> cmbGroup = new JComboBox<>();
        JButton btnName = new JButton("确认");
        this.add(lblId);
        this.add(txtId);
        this.add(lblName);
        this.add(txtName);
        this.add(lblGroup);
        this.add(cmbGroup);
        this.add(btnName);
        lblId.setBounds(200, 60, 100, 30);
        txtId.setBounds(200, 100, 100, 30);
        lblName.setBounds(200, 140, 100, 30);
        txtName.setBounds(200, 180, 200, 30);
        lblGroup.setBounds(200, 220, 100, 30);
        cmbGroup.setBounds(200, 260, 100, 30);
        btnName.setBounds(200, 300, 100, 30);
        // TODO 列举小组
        cmbGroup.addItem("请选择小组");
        String folderPath = Constant.FILE_PATH+File.separator+Constant.CLASS_PATH;
        // 创建目录对象
        AtomicReference<File> directory = new AtomicReference<>(new File(folderPath));

// 获取目录下的文件和子目录
        File[] files = directory.get().listFiles((File dir, String name) -> new File(dir, name).isDirectory());

// 清空原有选项，以便添加新选项
        cmbGroup.removeAllItems();

// 遍历文件和子目录，将目录名添加到下拉列表中
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    cmbGroup.addItem(file.getName());
                }
            }
        }

        btnName.addActionListener(e -> {
            if (txtId.getText() == null || txtId.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "请填写学号", "", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            if (txtName.getText() == null || txtName.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "请填写学生姓名", "", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            // TODO 添加学生
            // 获取输入的学号、姓名和小组
            String newId = txtId.getText();
            String newName = txtName.getText();
            String newGroup = (String) cmbGroup.getSelectedItem();

            try {
                // 打开文件以追加方式写入
                BufferedWriter writer = new BufferedWriter(new FileWriter(Constant.FILE_PATH+File.separator+Constant.CLASS_PATH+"\\students.txt", true));
                writer.write(newId + "，" + newName + "，" + newGroup + "\n");
                writer.close();

                // 更新下拉列表中的小组信息
                cmbGroup.removeAllItems();
                File directory1 = new File(folderPath);
                File[] file1 = directory1.listFiles((File dir, String name) -> new File(dir, name).isDirectory());
                if (file1 != null) {
                    for (File file : file1) {
                        if (file.isDirectory()) {
                            cmbGroup.addItem(file.getName());
                        }
                    }
                }

                // 清空输入框
                txtId.setText("");
                txtName.setText("");
                cmbGroup.setSelectedIndex(0);

                JOptionPane.showMessageDialog(this, "学生信息添加成功", "", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "添加学生信息失败", "", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
        });
    }
}

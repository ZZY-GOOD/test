package Class;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudentListPanel extends JPanel {
    String[] headers = {"学号", "姓名", "小组"};
    String[][][] data = null;
    JTable studentTable;
    JTextField txtId = new JTextField();
    JTextField txtName = new JTextField();
    JComboBox<String> cmbGroup = new JComboBox<>();
    JButton btnEdit = new JButton("修改");
    JButton btnDelete = new JButton("删除");

    public StudentListPanel() throws IOException {
        this.setBorder(new TitledBorder(new EtchedBorder(), "学生列表"));
        this.setLayout(new BorderLayout());
        // TODO 列举小组和学生构建table和combox
        File direction = new File(Constant.FILE_PATH+File.separator+Constant.CLASS_PATH);
        File file = new File(direction, "students.txt");
//        data = new String[1][3];
//        data[0] = new String[]{"1", "张三", "a组"};
        List<String[]> studentData = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split("，");
                studentData.add(data);
            }
        String[][] data = new String[studentData.size()][3];
        for (int i = 0; i < studentData.size(); i++) {
            String[] row = studentData.get(i);
            for (int j = 0; j < row.length; j++) {
                data[i][j] = row[j];
            }
        }
            DefaultTableModel tableModel = new DefaultTableModel(data, headers);
            studentTable = new JTable(tableModel) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            studentTable.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            JScrollPane scrollPane = new JScrollPane(studentTable);
            this.add(scrollPane, BorderLayout.CENTER);

        JPanel btnPanel = new JPanel();
        btnPanel.add(txtId);
        txtId.setPreferredSize(new Dimension(100, 30));
        btnPanel.add(txtName);
        txtName.setPreferredSize(new Dimension(200, 30));
        btnPanel.add(cmbGroup);
        cmbGroup.setPreferredSize(new Dimension(100, 30));
        cmbGroup.addItem("请选择小组");

        btnPanel.add(btnEdit);
        btnPanel.add(btnDelete);
        this.add(btnPanel, BorderLayout.SOUTH);

        studentTable.getSelectionModel().addListSelectionListener(e -> {
            int selectedRow = studentTable.getSelectedRow();
            if (selectedRow >= 0) {
                // TODO 准备修改学生
                txtId.setText((String) studentTable.getValueAt(selectedRow, 0));
                txtName.setText((String) studentTable.getValueAt(selectedRow, 1));
                cmbGroup.setSelectedItem((String) studentTable.getValueAt(selectedRow, 2));

                btnEdit.addActionListener(event -> {
                    // 获取修改后的数据
                    String newId = txtId.getText();
                    String newName = txtName.getText();
                    String newGroup = (String) cmbGroup.getSelectedItem();

                    // 更新表格数据
                    DefaultTableModel model = (DefaultTableModel) studentTable.getModel();
                    model.setValueAt(newId, selectedRow, 0);
                    model.setValueAt(newName, selectedRow, 1);
                    model.setValueAt(newGroup, selectedRow, 2);
                });
            }
        });

        btnEdit.addActionListener(e -> {
            int selectedRow = studentTable.getSelectedRow();
            if (selectedRow < 0) {
                JOptionPane.showMessageDialog(this, "请先选择学生", "", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            if (txtId.getText() == null || txtId.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "请填写学号", "", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            if (txtName.getText() == null || txtName.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "请填写姓名", "", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            // TODO 修改学生
            String newId = txtId.getText();
            String newName = txtName.getText();
            String newGroup = (String) cmbGroup.getSelectedItem();

            // 更新表格数据
            DefaultTableModel model = (DefaultTableModel) studentTable.getModel();
            model.setValueAt(newId, selectedRow, 0);
            model.setValueAt(newName, selectedRow, 1);
            model.setValueAt(newGroup, selectedRow, 2);

            // 更新存储学生数据的文本文件
            File files = new File(direction, "students.txt");
            try {
                BufferedReader readers = new BufferedReader(new FileReader(file));
                List<String> lines = new ArrayList<>();
                String line1;
                while ((line1 = readers.readLine()) != null) {
                    String[] datas = line1.split("，");
                    if (datas[0].equals(newId)) {
                        // 更新学生数据
                        datas[1] = newName;
                        datas[2] = newGroup;
                        line1 = String.join("，", datas);
                    }
                    lines.add(line1);
                }
                reader.close();

                //FileWriter writer = new FileWriter(file);
                BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                for (String newLine : lines) {
                    writer.write(newLine + "\n");
                }
                writer.close();

                JOptionPane.showMessageDialog(this, "修改成功", "", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "修改失败", "", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
            //JOptionPane.showMessageDialog(this, "修改成功", "", JOptionPane.INFORMATION_MESSAGE);

        });
        btnDelete.addActionListener(e -> {
            int selectedRow = studentTable.getSelectedRow();
            if (selectedRow < 0) {
                JOptionPane.showMessageDialog(this, "请先选择学生", "", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            if (JOptionPane.showConfirmDialog(this, "删除学生会删除他的考勤、成绩等，确认删除？", "", JOptionPane.YES_NO_OPTION) != 0) {
                return;
            }
            // TODO 删除学生

            DefaultTableModel model = (DefaultTableModel) studentTable.getModel();
            model.removeRow(selectedRow);
            txtId.setText("");
            txtName.setText("");
            cmbGroup.setSelectedItem("");

//            String newId = txtId.getText();
//            String newName = txtName.getText();
//            String newGroup = (String) cmbGroup.getSelectedItem();

            try {
                File file1 = new File("students.txt");
                BufferedReader reader1 = new BufferedReader(new FileReader(file));
                List<String> lines = new ArrayList<>();
                String line1;
                while ((line1 = reader1.readLine()) != null) {
                    String[] datas = line1.split(",");
                    if (!datas[0].equals(txtId.getText())) {
                        // 将不是删除的学生数据添加到列表中
                        lines.add(line1);
                    }
                }
                reader.close();

                BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                for (String newLine : lines) {
                    writer.write(newLine + "\n");
                }
                writer.close();

                JOptionPane.showMessageDialog(this, "删除学生成功，并已保存到文本文件中", "", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "删除学生失败", "", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }

            //JOptionPane.showMessageDialog(this, "删除学生成功", "", JOptionPane.INFORMATION_MESSAGE);
        });
    }
}

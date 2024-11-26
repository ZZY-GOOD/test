package Class;


import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GroupListPanel extends JPanel {
    String[] headers = {"序号", "小组名称"};
    //String[][] data = null;
    JTable classTable;
    JTextField txtName = new JTextField();
    JTextField txtScore = new JTextField();
    JButton btnEdit = new JButton("修改");
    JButton btnDelete = new JButton("删除");

    public GroupListPanel() throws IOException {
        this.setBorder(new TitledBorder(new EtchedBorder(), "小组列表"));
        this.setLayout(new BorderLayout());
        // TODO 列举小组
        File directory = new File(Constant.FILE_PATH + File.separator + Constant.CLASS_PATH); // 指定路径
        if (directory.isDirectory()) { // 判断是否是目录
//            String[][] data = new String[0][];
            File[] files = directory.listFiles((File dir, String name) -> new File(dir, name).isDirectory());
            String[][] data = new String[files.length][2];
            for (int i = 0; i < files.length; i++) {
                data[i][0] = String.valueOf(i + 1);
                data[i][1] = files[i].getName();

            }

            DefaultTableModel tableModel = new DefaultTableModel(data, headers);

            classTable = new JTable(tableModel) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            classTable.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            JScrollPane scrollPane = new JScrollPane(classTable);
            this.add(scrollPane, BorderLayout.CENTER);

            JPanel btnPanel = new JPanel();
            btnPanel.add(txtName);
            txtName.setPreferredSize(new Dimension(200, 30));
//        btnPanel.add(txtScore);
//        txtScore.setPreferredSize(new Dimension(100, 30));
            btnPanel.add(btnEdit);
            btnPanel.add(btnDelete);
            this.add(btnPanel, BorderLayout.SOUTH);

            classTable.getSelectionModel().addListSelectionListener(e -> {
                int selectedRow = classTable.getSelectedRow();
                if (selectedRow >= 0) {
                    txtName.setText(data[selectedRow][1]);
                }
            });


            btnEdit.addActionListener(e -> {
                // TODO 修改小组
//                String className = data[selectedRow][1]; // 获取班级文件名
//                JOptionPane.showMessageDialog(this, "修改成功", "", JOptionPane.INFORMATION_MESSAGE);
                int selectedRow = classTable.getSelectedRow();
                if (selectedRow < 0) {
                    JOptionPane.showMessageDialog(this, "请先选择小组", "", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                if (txtName.getText() == null || txtName.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "请填写小组名称", "", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }

                // TODO 修改班级

                String className = data[selectedRow][1]; // 获取小组文件名
                String newClassName = txtName.getText();
                File oldClassFile = new File(Constant.FILE_PATH + Constant.CLASS_PATH + File.separator + className); // 构建旧的班级文件对象
                File newClassFile = new File(Constant.FILE_PATH + Constant.CLASS_PATH + File.separator + newClassName); // 构建新的班级文件对象

                if (oldClassFile.renameTo(newClassFile)) {
                    DefaultTableModel model = (DefaultTableModel) classTable.getModel();
                    model.setValueAt(newClassName, selectedRow, 1);
                    JOptionPane.showMessageDialog(this, "修改成功", "", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "修改失败", "", JOptionPane.ERROR_MESSAGE);
                }

            });
            btnDelete.addActionListener(e -> {
                // TODO 删除小组

                int selectedRow = classTable.getSelectedRow();
                if (selectedRow < 0) {
                    JOptionPane.showMessageDialog(this, "请先选择小组", "", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                String className = data[selectedRow][1]; // 获取小组文件名
                File groupeFile = new File(Constant.FILE_PATH + File.separator + Constant.CLASS_PATH + File.separator + className); // 构建小组文件对象

                if (groupeFile.exists()) {
                    if (groupeFile.delete()) { // 删除文件
                        DefaultTableModel model = (DefaultTableModel) classTable.getModel();
                        model.removeRow(selectedRow);
                        JOptionPane.showMessageDialog(this, "删除班级成功", "", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(this, "删除班级失败", "", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "班级文件不存在", "", JOptionPane.INFORMATION_MESSAGE);
                }

                //JOptionPane.showMessageDialog(this, "删除小组成功", "", JOptionPane.INFORMATION_MESSAGE);
            });
        }
    }
}



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Mainfunction extends JPanel {
    public static JFrame jFrame;

    // 程序入口
    public static void init() {
        // 创建一个窗口
        jFrame = new JFrame("通讯录"); // 设置窗口标题
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // 设置关闭窗口时的操作
        jFrame.setResizable(false); // 设置窗口不可缩放
        jFrame.setBounds(200, 200, 500, 400); // 设置窗口位置和大小
        jFrame.setLayout(null); // 设置窗口布局为null

        // 设置 Mainfunction 为 JFrame 的内容面板
        Mainfunction mainPanel = new Mainfunction();
        mainPanel.setLayout(null); // 设置主面板的布局为null
        jFrame.setContentPane(mainPanel);

        // 显示窗口
        jFrame.setVisible(true);

        // 实现菜单设计
        menu(mainPanel);
    }

    // 菜单设计
    public static void menu(JPanel jPanel) {
        // 设置背景颜色为浅灰色
        jPanel.setBackground(new Color(232, 228, 228));

        // 添加标题
        JLabel titleLabel = new JLabel("欢迎使用通讯录管理系统");
        titleLabel.setFont(new Font("微软雅黑", Font.BOLD, 15)); // 设置字体为微软雅黑，加粗，字号15
        titleLabel.setBounds(160, 50, 300, 30); // 设置标题的位置和大小
        jPanel.add(titleLabel); // 将标题添加到面板中

        // 添加按钮组件并手动设置位置和大小
        JButton jButton1 = new JButton("新建联系人");
        jButton1.setBounds(170, 100, 150, 30); // 设置按钮的位置和大小
        jPanel.add(jButton1); // 将按钮添加到面板中

        JButton jButton2 = new JButton("查询联系人");
        jButton2.setBounds(170, 140, 150, 30);
        jPanel.add(jButton2);

        JButton jButton3 = new JButton("显示全部联系人");
        jButton3.setBounds(170, 180, 150, 30);
        jPanel.add(jButton3);

        JButton jButton4 = new JButton("修改联系人信息");
        jButton4.setBounds(170, 220, 150, 30);
        jPanel.add(jButton4);

        JButton jButton5 = new JButton("删除联系人");
        jButton5.setBounds(170, 260, 150, 30);
        jPanel.add(jButton5);

        JButton jButton6 = new JButton("退出");
        jButton6.setBounds(170, 300, 150, 30);
        jPanel.add(jButton6);

        // 设置按钮的点击事件
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Function1_addedor(); // 调用新建联系人功能
                } catch (IOException ex) {
                    throw new RuntimeException(ex); // 捕获并抛出异常
                }
            }
        });

        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Function2_select(); // 调用查询联系人功能
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        jButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Function3_displayable(); // 调用显示全部联系人功能
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        jButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Function4_update(); // 调用修改联系人信息功能
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        jButton5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Function5_delete(); // 调用删除联系人功能
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        // 退出按钮的点击事件
        jButton6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // 退出程序
            }
        });
    }

    // 新建联系人功能
    public static void Function1_addedor() throws IOException {
        String s = "新建";
        mydialog d1 = new mydialog(s); // 创建一个对话框对象
        JPanel jPanel = new JPanel(); // 创建一个面板对象
        jPanel.setBounds(600, 300, 500, 500); // 设置面板的位置和大小
        jPanel.setLayout(null); // 设置面板的布局为空，即绝对定位

        // 创建输入框
        JLabel name = new JLabel("姓名：");
        name.setBounds(10, 10, 40, 20); // 设置标签的位置和大小
        jPanel.add(name); // 将标签添加到面板中
        JTextField namein = new JTextField(20); // 创建一个文本输入框
        namein.setBounds(80, 10, 100, 20); // 设置文本输入框的位置和大小
        jPanel.add(namein); // 将文本输入框添加到面板中

        JLabel gender = new JLabel("性别：");
        gender.setBounds(10, 40, 40, 20);
        jPanel.add(gender);
        JTextField genderin = new JTextField(20);
        genderin.setBounds(80, 40, 30, 20);
        jPanel.add(genderin);

        JLabel birthday = new JLabel("出生日期：");
        birthday.setBounds(10, 70, 80, 20); // 增大宽度以适应文本
        jPanel.add(birthday);

        JTextField yearin = new JTextField(4); // 改为4个字符宽度以适应年份
        yearin.setBounds(80, 70, 40, 20); // 调整位置
        jPanel.add(yearin);
        JLabel year = new JLabel("年");
        year.setBounds(125, 70, 20, 20); // 调整位置以适应空隙
        jPanel.add(year);

        JTextField monthin = new JTextField(2); // 改为2个字符宽度以适应月份
        monthin.setBounds(145, 70, 30, 20); // 调整位置
        jPanel.add(monthin);
        JLabel month = new JLabel("月");
        month.setBounds(185, 70, 20, 20); // 调整位置以适应空隙
        jPanel.add(month);

        JTextField dayin = new JTextField(2); // 改为2个字符宽度以适应日期
        dayin.setBounds(205, 70, 30, 20); // 调整位置
        jPanel.add(dayin);
        JLabel day = new JLabel("日");
        day.setBounds(245, 70, 20, 20); // 调整位置以适应空隙
        jPanel.add(day);

        JLabel phone = new JLabel("手机号码：");
        phone.setBounds(10, 100, 80, 20);
        jPanel.add(phone);
        JTextField phonein = new JTextField(20);
        phonein.setBounds(80, 100, 100, 20);
        jPanel.add(phonein);

        JLabel address = new JLabel("地址：");
        address.setBounds(10, 130, 40, 20);
        jPanel.add(address);
        JTextField addressin = new JTextField(20);
        addressin.setBounds(80, 130, 100, 20);
        jPanel.add(addressin);

        JLabel Postcode = new JLabel("邮政编码：");
        Postcode.setBounds(10, 160, 80, 20);
        jPanel.add(Postcode);
        JTextField Postcodein = new JTextField(20);
        Postcodein.setBounds(80, 160, 100, 20);
        jPanel.add(Postcodein);

        JLabel email = new JLabel("电子邮箱：");
        email.setBounds(10, 190, 80, 20);
        jPanel.add(email);
        JTextField emailin = new JTextField(20);
        emailin.setBounds(80, 190, 100, 20);
        jPanel.add(emailin);

        JLabel qq_number = new JLabel("QQ号码：");
        qq_number.setBounds(10, 220, 80, 20);
        jPanel.add(qq_number);
        JTextField qq_numberin = new JTextField(20);
        qq_numberin.setBounds(80, 220, 100, 20);
        jPanel.add(qq_numberin);

        JLabel category = new JLabel("类别：");
        category.setBounds(10, 250, 40, 20);
        jPanel.add(category);
        JTextField categoryin = new JTextField(20);
        categoryin.setBounds(80, 250, 100, 20);
        jPanel.add(categoryin);

        // 创建按钮
        JButton button1 = new JButton("保存");
        button1.setBounds(80, 280, 80, 30); // 设置按钮的位置和大小
        jPanel.add(button1); // 将按钮添加到面板中
        button1.addActionListener(new ActionListener() {
                                      @Override
                                      public void actionPerformed(ActionEvent e) {
                                          String name1 = namein.getText(); // 获取姓名输入框的文本
                                          char gender1 = (genderin.getText()).charAt(0); // 获取性别输入框的文本并转换为字符
                                          date birthday1 = new date(Integer.parseInt(yearin.getText()), Integer.parseInt(monthin.getText()), Integer.parseInt(dayin.getText())); // 获取出生日期输入框的文本并转换为日期对象
                                          String phone1 = phonein.getText(); // 获取手机号码输入框的文本
                                          String address1 = addressin.getText(); // 获取地址输入框的文本
                                          int Postcode1 = Integer.parseInt(Postcodein.getText()); // 获取邮政编码输入框的文本并转换为整数
                                          String email1 = emailin.getText(); // 获取电子邮箱输入框的文本
                                          String qq_number1 = qq_numberin.getText(); // 获取QQ号码输入框的文本
                                          String category1 = categoryin.getText(); // 获取类别输入框的文本
                                          staff s = new staff(name1, gender1, birthday1, phone1, address1, Postcode1, email1, qq_number1, category1); // 创建一个员工对象
                                          try {
                                              saveToFile(s); // 将员工对象保存到文件中
                                          } catch (IOException ex) {
                                              throw new RuntimeException(ex); // 捕获并抛出异常
                                          }
                                          d1.dispose(); // 关闭对话框
                                      }
                                  }
        );

        d1.add(jPanel); // 将面板添加到对话框中
    }

    // 查询联系人功能
    public static void Function2_select() throws IOException {
        String s = "查询";
        mydialog d1 = new mydialog(s); // 创建一个对话框对象，标题为“查询”
        JPanel jPanel = new JPanel(); // 创建一个面板对象
        jPanel.setBounds(600, 300, 500, 500); // 设置面板的位置和大小
        jPanel.setLayout(null); // 设置面板的布局为空，即绝对定位

        // 添加标题
        JLabel title = new JLabel("请选择查询方式：");
        title.setFont(new Font("微软雅黑", Font.BOLD, 15)); // 设置字体为微软雅黑，加粗，字号15
        title.setBounds(160, 50, 300, 30); // 设置标题的位置和大小
        jPanel.add(title); // 将标题添加到面板中

        // 创建按钮并设置其位置和大小
        JButton button1 = new JButton("根据姓名、电话查询：");
        button1.setBounds(150, 130, 180, 30);
        jPanel.add(button1); // 将按钮添加到面板中
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Function2_select_name_phone(); // 调用根据姓名和电话查询的功能
                } catch (IOException ex) {
                    throw new RuntimeException(ex); // 捕获并抛出异常
                }
            }
        });

        JButton button2 = new JButton("根据地址查询：");
        button2.setBounds(150, 180, 180, 30);
        jPanel.add(button2);
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Function2_select_address(); // 调用根据地址查询的功能
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        JButton button3 = new JButton("根据类别查询：");
        button3.setBounds(150, 230, 180, 30);
        jPanel.add(button3);
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Function2_select_category(); // 调用根据类别查询的功能
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        d1.add(jPanel); // 将面板添加到对话框中
    }

    // 显示全部联系人功能
    public static void Function3_displayable() throws IOException {
        String s = "显示全部";
        mydialog d1 = new mydialog(s); // 创建一个对话框对象，标题为“显示全部”
        d1.setSize(800, 800); // 设置对话框的大小
        JPanel jPanel = new JPanel(); // 创建一个面板对象
        jPanel.setBounds(600, 300, 800, 800); // 设置面板的位置和大小
        jPanel.setLayout(null); // 设置面板的布局为空，即绝对定位

        // 创建一个 JTextArea 用于显示查询结果
        JTextArea textarea = new JTextArea();
        textarea.setBounds(10, 10, 780, 780); // 设置文本区域的位置和大小
        textarea.setEditable(false); // 设置为不可编辑
        jPanel.add(textarea); // 将文本区域添加到面板中

        ArrayList<String> list = new ArrayList<>(); // 创建一个列表用于存储从文件中读取的每一行内容

        try {
            BufferedReader br = new BufferedReader(new FileReader("D:\\CCodes\\vscodebase\\JAVA WORK\\address_book_gui\\text.txt")); // 创建 BufferedReader 以读取文件
            String line; // 用于存储每一行读取的内容

            // 逐行读取文件内容，直到文件末尾
            while ((line = br.readLine()) != null) {
                list.add(line); // 将每一行添加到列表中
            }

            // 读取完成后关闭 BufferedReader，释放资源
            br.close();

            Comparator cmp = Collator.getInstance(java.util.Locale.CHINA); // 创建自定义比较器，用于按照姓名进行排序
            Collections.sort(list, cmp); // 对列表进行排序，使用自定义比较器按照姓名进行排序
        } catch (IOException ex) {
            throw new RuntimeException(ex); // 捕获并抛出异常
        }

        // 显示查询结果
        for (String str : list) {
            textarea.append(str + "\n"); // 将排序后的内容逐行添加到文本区域中
        }

        d1.add(jPanel); // 将面板添加到对话框中
    }

    // 修改联系人信息功能
    public static void Function4_update() throws IOException {
        String s = "修改";
        mydialog d1 = new mydialog(s); // 创建一个对话框对象，标题为“修改”
        JPanel jPanel = new JPanel(); // 创建一个面板对象
        jPanel.setBounds(600, 300, 500, 500); // 设置面板的位置和大小
        jPanel.setLayout(null); // 设置面板的布局为空，即绝对定位

        // 创建标签和文本框用于输入姓名和电话
        JLabel name = new JLabel("姓名：");
        name.setBounds(170, 150, 40, 20); // 设置标签的位置和大小
        jPanel.add(name); // 将标签添加到面板中

        JTextField namein = new JTextField(20); // 创建一个文本框用于输入姓名
        namein.setBounds(210, 150, 100, 20); // 设置文本框的位置和大小
        jPanel.add(namein); // 将文本框添加到面板中

        JLabel phone = new JLabel("电话：");
        phone.setBounds(170, 190, 40, 20);
        jPanel.add(phone);

        JTextField phonein = new JTextField(20); // 创建一个文本框用于输入电话
        phonein.setBounds(210, 190, 100, 20);
        jPanel.add(phonein);

        JButton button1 = new JButton("查询"); // 创建一个按钮用于查询
        button1.setBounds(220, 230, 80, 30);
        jPanel.add(button1);

        d1.add(jPanel); // 将面板添加到对话框中

        // 查询按钮逻辑
        button1.addActionListener(e -> {
            String name1 = namein.getText().trim(); // 获取输入的姓名
            String phone1 = phonein.getText().trim(); // 获取输入的电话
            String filePath = "D:\\CCodes\\vscodebase\\JAVA WORK\\address_book_gui\\text.txt"; // 文件路径

            try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                String line;
                boolean found = false; // 用于标记是否找到匹配的记录
                String[] recordDetails = null; // 用于存储匹配的记录详情

                // 逐行读取文件内容，查找匹配的记录
                while ((line = br.readLine()) != null) {
                    if (line.startsWith(name1) && line.split(",")[2].equals(phone1)) {
                        found = true;
                        recordDetails = line.split(","); // 将匹配的记录按逗号分割
                        break;
                    }
                }

                // 如果找到匹配的记录，显示提示并打开更新对话框
                if (found && recordDetails != null) {
                    JOptionPane.showMessageDialog(null, "找到匹配的记录！");
                    openUpdateDialog(recordDetails, filePath); // 打开更新对话框
                } else {
                    JOptionPane.showMessageDialog(null, "未找到匹配的记录！"); // 未找到匹配记录时显示提示
                }
            } catch (IOException ex) {
                ex.printStackTrace(); // 捕获并打印异常
            }
        });
    }

    // 打开修改记录对话框并更新文件
    private static void openUpdateDialog(String[] recordDetails, String filePath) {
        mydialog d2 = new mydialog("修改记录");
        JPanel jPanel2 = new JPanel();
        jPanel2.setLayout(null);

        JLabel phone2 = new JLabel("手机号码：");
        phone2.setBounds(10, 40, 80, 20);
        jPanel2.add(phone2);
        JTextField phonein2 = new JTextField(recordDetails[2]);
        phonein2.setBounds(100, 40, 150, 20);
        jPanel2.add(phonein2);

        String oldphone = recordDetails[2]; // 保存旧的电话号码
        JLabel address2 = new JLabel("地址：");
        address2.setBounds(10, 70, 80, 20);
        jPanel2.add(address2);
        JTextField addressin2 = new JTextField(recordDetails[3]);
        addressin2.setBounds(100, 70, 150, 20);
        jPanel2.add(addressin2);

        JLabel postcode2 = new JLabel("邮政编码：");
        postcode2.setBounds(10, 100, 80, 20);
        jPanel2.add(postcode2);
        JTextField postcodein2 = new JTextField(recordDetails[4]);
        postcodein2.setBounds(100, 100, 150, 20);
        jPanel2.add(postcodein2);

        JLabel email2 = new JLabel("电子邮箱：");
        email2.setBounds(10, 130, 80, 20);
        jPanel2.add(email2);
        JTextField emailin2 = new JTextField(recordDetails[5]);
        emailin2.setBounds(100, 130, 150, 20);
        jPanel2.add(emailin2);

        JLabel qqNumber2 = new JLabel("QQ号码：");
        qqNumber2.setBounds(10, 160, 80, 20);
        jPanel2.add(qqNumber2);
        JTextField qqNumberin2 = new JTextField(recordDetails[6]);
        qqNumberin2.setBounds(100, 160, 150, 20);
        jPanel2.add(qqNumberin2);

        JLabel category2 = new JLabel("类别：");
        category2.setBounds(10, 190, 80, 20);
        jPanel2.add(category2);
        JTextField categoryin2 = new JTextField(recordDetails[7]);
        categoryin2.setBounds(100, 190, 150, 20);
        jPanel2.add(categoryin2);

        JButton saveButton = new JButton("保存");
        saveButton.setBounds(80, 250, 100, 30);
        jPanel2.add(saveButton);

        d2.add(jPanel2);

        // 保存按钮逻辑
        saveButton.addActionListener(e -> {
            recordDetails[2] = phonein2.getText();
            recordDetails[3] = addressin2.getText();
            recordDetails[4] = postcodein2.getText();
            recordDetails[5] = emailin2.getText();
            recordDetails[6] = qqNumberin2.getText();
            recordDetails[7] = categoryin2.getText();

            updateRecord(filePath, recordDetails,oldphone);
            JOptionPane.showMessageDialog(null, "记录已更新！");
            d2.dispose();
        });
    }

    // 更新记录到文件
    private static void updateRecord(String filePath, String[] updatedDetails,String oldphone) {
        StringBuilder updatedContent = new StringBuilder(); // 创建一个 StringBuilder 用于存储更新后的文件内容

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            // 逐行读取文件内容
            while ((line = br.readLine()) != null) {
                // 检查当前行是否与需要更新的记录匹配
                if (line.startsWith(updatedDetails[0].split(":")[0]) && line.split(",")[2].equals(oldphone)) {
                    line = String.join(",", updatedDetails); // 如果匹配，则用更新后的记录替换当前行
                }
                updatedContent.append(line).append("\n"); // 将更新后的行添加到 StringBuilder 中
            }
        } catch (IOException e) {
            e.printStackTrace(); // 捕获并打印异常
        }

        // 将更新后的内容写回文件
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            bw.write(updatedContent.toString()); // 将 StringBuilder 中的内容写入文件
        } catch (IOException e) {
            e.printStackTrace(); // 捕获并打印异常
        }
    }

    // 删除联系人功能
    public static void Function5_delete() throws IOException {
        String s = "删除联系人";
        mydialog d1 = new mydialog(s); // 创建一个对话框对象，标题为“删除联系人”
        JPanel jPanel = new JPanel(); // 创建一个面板对象
        jPanel.setBounds(600, 300, 500, 500); // 设置面板的位置和大小
        jPanel.setLayout(null); // 设置面板的布局为空，即绝对定位

        // 创建标签和文本框用于输入姓名和电话
        JLabel nameLabel = new JLabel("姓名：");
        nameLabel.setBounds(170, 150, 40, 20); // 设置标签的位置和大小
        jPanel.add(nameLabel); // 将标签添加到面板中

        JTextField nameInput = new JTextField(20); // 创建一个文本框用于输入姓名
        nameInput.setBounds(210, 150, 100, 20); // 设置文本框的位置和大小
        jPanel.add(nameInput); // 将文本框添加到面板中

        JLabel phoneLabel = new JLabel("电话：");
        phoneLabel.setBounds(170, 190, 40, 20);
        jPanel.add(phoneLabel);

        JTextField phoneInput = new JTextField(20); // 创建一个文本框用于输入电话
        phoneInput.setBounds(210, 190, 100, 20);
        jPanel.add(phoneInput);

        JButton deleteButton = new JButton("删除"); // 创建一个按钮用于删除记录
        deleteButton.setBounds(220, 230, 80, 30);
        jPanel.add(deleteButton);

        d1.add(jPanel); // 将面板添加到对话框中

        // 删除按钮逻辑
        deleteButton.addActionListener(e -> {
            String name = nameInput.getText().trim(); // 获取输入的姓名
            String phone = phoneInput.getText().trim(); // 获取输入的电话
            String filePath = "D:\\CCodes\\vscodebase\\JAVA WORK\\address_book_gui\\text.txt"; // 文件路径

            // 检查姓名和电话是否为空
            if (name.isEmpty() || phone.isEmpty()) {
                JOptionPane.showMessageDialog(null, "姓名和电话不能为空！");
                return;
            }

            try {
                boolean isDeleted = deleteRecord(filePath, name, phone); // 调用删除记录的方法
                if (isDeleted) {
                    JOptionPane.showMessageDialog(null, "记录已删除！"); // 显示删除成功的提示
                } else {
                    JOptionPane.showMessageDialog(null, "未找到匹配的记录！"); // 显示未找到记录的提示
                }
                d1.dispose(); // 关闭对话框
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "删除记录时出错：" + ex.getMessage()); // 显示删除出错的提示
            }
        });
    }

    /**
     * 删除匹配的记录并更新文件
     *
     * @param filePath 文件路径
     * @param name     要匹配的姓名
     * @param phone    要匹配的电话
     * @return 是否成功删除记录
     * @throws IOException 如果文件操作失败
     */
    // 删除记录并更新文件
    private static boolean deleteRecord(String filePath, String name, String phone) throws IOException {
        StringBuilder updatedContent = new StringBuilder();
        boolean isDeleted = false;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length > 2 && line.startsWith(name) && parts[2].equals(phone)) {
                    isDeleted = true; // 找到记录并标记为已删除
                    continue; // 跳过此记录，不加入新的文件内容
                }
                updatedContent.append(line).append("\n");
            }
        }

        // 如果删除了记录，则更新文件内容
        if (isDeleted) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
                bw.write(updatedContent.toString());
            }
        }

        return isDeleted;
    }

    // 保存 staff 对象到文件
    public static void saveToFile(staff s) throws IOException {
        // 创建一个 BufferedWriter，用于将文本写入指定文件
        // 第一个参数是文件路径，第二个参数 true 表示以追加的方式打开文件
        BufferedWriter rw = new BufferedWriter(new FileWriter("D:\\CCodes\\vscodebase\\JAVA WORK\\address_book_gui\\text.txt", true));

        // 将 staff 对象转换为字符串形式
        String t = s.toString();

        // 将字符串写入文件
        rw.write(t);

        // 写入新行，以便每个对象的信息在文件中单独占一行
        rw.newLine();

        // 关闭 BufferedWriter，释放系统资源
        rw.close();
    }

    // 查询联系人功能_根据姓名、电话查询
    public static void Function2_select_name_phone() throws IOException {
        mydialog d1 = new mydialog("查询_姓名_电话");
        JPanel jPanel = new JPanel();
        jPanel.setBounds(600, 300, 500, 500);
        jPanel.setLayout(null);

        JLabel name = new JLabel("姓名：");
        name.setBounds(170, 150, 40, 20);
        jPanel.add(name);

        JTextField namein = new JTextField(20);
        namein.setBounds(210, 150, 100, 20);
        jPanel.add(namein);

        JLabel phone = new JLabel("电话：");
        phone.setBounds(170, 190, 40, 20);
        jPanel.add(phone);
        JTextField phonein = new JTextField(20);
        phonein.setBounds(210, 190, 100, 20);
        jPanel.add(phonein);

        JButton button1 = new JButton("查询");
        button1.setBounds(220, 230, 80, 30);
        jPanel.add(button1);

        d1.add(jPanel);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name1 = namein.getText();
                String phone1 = phonein.getText();
                String resultname = null;
                String resultgender=null;
                String resultbirthday=null;
                String resultphone=null;
                String resultaddress=null;
                int resultPostcode = 0;
                String resultemail=null;
                String resultqq_number=null;
                String resultcategory=null;

                boolean bool = false; // 用于记录是否找到匹配的记录
                try {
                    BufferedReader br = new BufferedReader(new FileReader("D:\\CCodes\\vscodebase\\JAVA WORK\\address_book_gui\\text.txt")); // 创建 BufferedReader 以读取文件
                    String line; // 用于存储读取的每一行数据
                    // 逐行读取文件内容进行查询
                    while ((line = br.readLine()) != null) {
                        // 检查当前行是否以输入的姓名开头，并且电话匹配
                        if (line.startsWith(name1) && (line.split(",")[2]).equals(phone1)) {
                                bool = true; // 找到匹配的记录，设置标志为 true
                                resultname = line.split(":")[0];
                                resultgender = line.split(":")[1].split(",")[0];
                                resultbirthday = line.split(",")[1];
                                resultphone = line.split(",")[2];
                                resultaddress = line.split(",")[3];
                                resultPostcode = Integer.parseInt(line.split(",")[4]);
                                resultemail = line.split(",")[5];
                                resultqq_number = line.split(",")[6];
                                resultcategory = line.split(",")[7];
                        }
                    }
                    br.close(); // 关闭 BufferedReader
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                if (bool) { // 如果找到匹配的记录，则显示在窗口中
                    JOptionPane.showMessageDialog(null, "找到匹配的记录！");
                    // 显示匹配的记录
                    mydialog d2 = new mydialog("查询结果");
                    JPanel jPanel2 = new JPanel();
                    jPanel2.setBounds(600, 300, 500, 500);
                    jPanel2.setLayout(null);

                    JLabel title2 = new JLabel("查询结果：");
                    title2.setFont(new Font("微软雅黑", Font.BOLD, 15));
                    title2.setBounds(160, 20, 300, 30); // 设置位置和大小
                    jPanel2.add(title2);

                    JLabel name2 ;
                    name2=new JLabel("姓名："+resultname);
                    name2.setBounds(170, 70, 200, 20);
                    jPanel2.add(name2);
                    
                    JLabel gender2=new JLabel("性别："+resultgender);
                    gender2.setBounds(170, 100, 140, 20);
                    jPanel2.add(gender2);

                    JLabel birthday2=new JLabel("出生日期："+resultbirthday);
                    birthday2.setBounds(170, 130, 140, 20);
                    jPanel2.add(birthday2);

                    JLabel phone2=new JLabel("手机号码："+resultphone);
                    phone2.setBounds(170, 160, 140, 20);
                    jPanel2.add(phone2);

                    JLabel address2=new JLabel("地址："+resultaddress);
                    address2.setBounds(170, 190, 250, 20);
                    jPanel2.add(address2);

                    JLabel Postcode2=new JLabel("邮政编码："+resultPostcode);
                    Postcode2.setBounds(170, 220, 140, 20);
                    jPanel2.add(Postcode2);

                    JLabel email2=new JLabel("电子邮箱："+resultemail);
                    email2.setBounds(170, 250, 200, 20);
                    jPanel2.add(email2);

                    JLabel qq_number2=new JLabel("QQ号码："+resultqq_number);
                    qq_number2.setBounds(170, 280, 200, 20);
                    jPanel2.add(qq_number2);

                    JLabel category2=new JLabel("类别："+resultcategory);
                    category2.setBounds(170, 310, 140, 20);
                    jPanel2.add(category2);

                    d2.add(jPanel2);

                } else { // 如果没有找到匹配的记录，则提示用户
                    JOptionPane.showMessageDialog(null, "没有找到匹配的记录！");
                }
            }
        });

    }

    // 查询联系人功能_根据地址查询
    public static void Function2_select_address() throws IOException {
        mydialog d1 = new mydialog("查询_地址");
        JPanel jPanel = new JPanel();
        jPanel.setBounds(600, 300, 500, 500);
        jPanel.setLayout(null);

        JLabel address = new JLabel("地址：");
        address.setBounds(170, 150, 40, 20);
        jPanel.add(address);

        JTextField addressin = new JTextField(20);
        addressin.setBounds(210, 150, 100, 20);
        jPanel.add(addressin);

        JButton button1 = new JButton("查询");
        button1.setBounds(220, 190, 80, 30);
        jPanel.add(button1);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String address1 = addressin.getText();
                boolean bool = false; // 用于记录是否找到匹配的记录
                StringBuilder matchedAddresses = new StringBuilder(); // 用于存储匹配的地址
                try {
                    BufferedReader br = new BufferedReader(new FileReader("D:\\CCodes\\vscodebase\\JAVA WORK\\address_book_gui\\text.txt")); // 创建 BufferedReader 以读取文件
                    String line; // 用于存储读取的每一行数据
                    while ((line = br.readLine()) != null) { // 逐行读取文件
                        if (line.contains(address1)) { // 模糊匹配
                            matchedAddresses.append(line).append("<br>"); // 将匹配的地址添加到结果中
                            bool = true; // 记录找到匹配的记录
                        }
                    }

                    // 如果找到匹配的记录，弹出对话框显示结果
                    if (bool) {
                        JOptionPane.showMessageDialog(d1, "查找成功：");
                        mydialog d2 = new mydialog("查询结果");
                        d2.setBounds(10, 10, 1000, 700);
                        d2.setResizable(true);
                        d2.setLayout(null);
                        JPanel jPanel2 = new JPanel();
                        jPanel2.setLayout(null);
                        jPanel2.setBounds(0, 0, 1000, 700);

                        JLabel title2 = new JLabel("<html>查询结果：<br>"+ matchedAddresses.toString()+"</html>");
                        title2.setFont(new Font("微软雅黑", Font.BOLD, 15));
                        title2.setBounds(20, 20, 960, 660); // 设置位置和大小
                        title2.setVerticalAlignment(JLabel.TOP);
                        jPanel2.add(title2);
                        d2.add(jPanel2);
                    } else {
                        JOptionPane.showMessageDialog(d1, "没有找到匹配的地址！");
                    }

                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });


        d1.add(jPanel);
    }

    // 查询联系人功能_根据类别查询
    public static void Function2_select_category() throws IOException {
        mydialog d1 = new mydialog("查询_类别");
        JPanel jPanel = new JPanel();
        jPanel.setBounds(600, 300, 500, 500);
        jPanel.setLayout(null);
        JLabel category = new JLabel("类别：");
        category.setBounds(170, 150, 40, 20);
        jPanel.add(category);

        JTextField categoryin = new JTextField(20);
        categoryin.setBounds(210, 150, 100, 20);
        jPanel.add(categoryin);

        JButton button1 = new JButton("查询");
        button1.setBounds(220, 190, 80, 30);
        jPanel.add(button1);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String category1 = categoryin.getText();
                boolean bool = false; // 用于记录是否找到匹配的记录
                StringBuilder matchedCategories = new StringBuilder(); // 用于存储匹配的类别
                try {
                    BufferedReader br = new BufferedReader(new FileReader("D:\\CCodes\\vscodebase\\JAVA WORK\\address_book_gui\\text.txt")); // 创建 BufferedReader 以读取文件
                    String line; // 用于存储读取的每一行数据
                    while ((line = br.readLine()) != null) { // 逐行读取文件
                        if (line.contains(category1)) { // 模糊匹配
                            matchedCategories.append(line).append("<br>"); // 将匹配的类别添加到结果中
                            bool = true; // 记录找到匹配的记录
                        }
                    }

                    // 如果找到匹配的记录，弹出对话框显示结果
                    if (bool) {
                        JOptionPane.showMessageDialog(d1, "查找成功：");
                        mydialog d2 = new mydialog("查询结果");
                        d2.setBounds(10, 10, 1000, 700);
                        d2.setResizable(true);
                        d2.setLayout(null);
                        JPanel jPanel2 = new JPanel();
                        jPanel2.setLayout(null);
                        jPanel2.setBounds(0, 0, 1000, 700);

                        JLabel title2 = new JLabel("<html>查询结果：<br>"+ matchedCategories.toString()+"</html>");
                        title2.setFont(new Font("微软雅黑", Font.BOLD, 15));
                        title2.setBounds(20, 20, 960, 660); // 设置位置和大小
                        title2.setVerticalAlignment(JLabel.TOP);
                        jPanel2.add(title2);
                        d2.add(jPanel2);
                    } else {
                        JOptionPane.showMessageDialog(d1, "没有找到匹配的类别！");
                    }


            }
                catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }

        });
        d1.add(jPanel);

    }

}

// 自定义对话框
class mydialog extends JDialog {
    public mydialog() {

    }

    public mydialog(String s) {
        this.setVisible(true); // 设置为可见
        this.setBounds(600, 300, 500, 500); // 设置位置和大小
        this.setTitle(s); // 设置标题
        this.setResizable(false); // 设置为不可缩放
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE); // 设置关闭方式
    }
}

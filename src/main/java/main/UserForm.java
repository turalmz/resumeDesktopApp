/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import com.company.entity.User;
import com.company.Context;
import com.company.dao.inter.SkillDaoInter;
import com.company.dao.inter.CountryDaoInter;
import com.company.dao.inter.EmpHistoryDaoInter;
import com.company.dao.inter.UserDaoInter;
import com.company.dao.inter.UserSkillDaoInter;
import com.company.entity.Country;
import com.company.entity.EmpHistory;
import com.company.entity.Skill;
import com.company.entity.UserSkill;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import javax.swing.JFrame;
import util.SwingCalendar;

/**
 *
 * @author TURAL
 */
public class UserForm extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    private UserDaoInter userDao = Context.instanceUserDao();
    User currentUser;
    private CountryDaoInter countryDao = Context.instanceCountryDao();
    private UserSkillDaoInter userSkillDao = Context.instanceUserSkillDao();
    private SkillDaoInter skillDao = Context.instanceSkillDao();
    private EmpHistoryDaoInter empHistoryDao = Context.instanceEmpHistoryDao();
    List<EmpHistory> listEmpHis;

    public UserForm(int id) {
        initComponents();
        currentUser = userDao.getById(id);
        fillUserComponent();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        fillCountryComponent();
        fillUserSkillComponent();
        fillSkillComponent();
        fillEmpHistoryComponent();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        tblEmpHistory.setEnabled(true);
    }

    public UserForm() {
        initComponents();
        currentUser = new User(-1);
        fillUserComponent();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        fillCountryComponent();
        fillUserSkillComponent();
        fillSkillComponent();
        fillEmpHistoryComponent();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        tblEmpHistory.setEnabled(true);

    }

    private void fillUserComponent() {
        txtName.setText(currentUser.getFirstname());
        txtSurname.setText(currentUser.getLastname());
        txtAreaProfile.setText(currentUser.getProfileDescription());
        txtName.setText(currentUser.getFirstname());
        try {
            Date dt = currentUser.getBirthDate();
            String sdt = sdf.format(dt);
            txtBirthdate.setText(sdt);
        } catch (Exception ex) {

        }
        txtEmail.setText(currentUser.getEmail());
        txtPhone.setText(currentUser.getPhone());
        txtAddress.setText(currentUser.getAddress());
    }

    private void fillCountryComponent() {
        cbBirthplace.removeAllItems();
        cbNationality.removeAllItems();

        List<String> countryList = new ArrayList();
        List<String> nationList = new ArrayList();

        for (Country con : countryDao.getAll()) {

            if (!countryList.contains(con.getName())) {
                cbBirthplace.addItem(con.getName());
                countryList.add(con.getName());
            }
            if (!nationList.contains(con.getNatinality())) {
                cbNationality.addItem(con.getNatinality());
                nationList.add(con.getNatinality());
            }
        }

    }

    private void fillEmpHistoryComponent() {
        listEmpHis = empHistoryDao.getAll();
        DefaultTableModel tableModel = new DefaultTableModel();
        Vector vectorHeaders = new Vector();

        vectorHeaders.add("id");

        vectorHeaders.add("Header");
        vectorHeaders.add("Job Description");

        vectorHeaders.add("Begin Date");
        vectorHeaders.add("End Date");

        Vector vectorRows = new Vector();
        for (EmpHistory eh : listEmpHis) {

            Vector row = new Vector();
            row.add(eh.getId());

            row.add(eh.getHeader());
            row.add(eh.getJobDescription());
//            txtAreaProfile.setText(us.getProfileDescription());
            try {
                Date dt = eh.getBeginDate();
                String sdt = sdf.format(dt);
                row.add(sdt);

            } catch (Exception ex) {
                row.add(null);

            }

            try {
                Date dt = eh.getEndDate();
                String sdt = sdf.format(dt);
                row.add(sdt);

            } catch (Exception ex) {
                row.add(null);

            }
            vectorRows.add(row);
        }
        tableModel.setDataVector(vectorRows, vectorHeaders);
        tblEmpHistory.setModel(tableModel);

    }

    private void fillSkillComponent() {
        cbSkill.removeAllItems();

        List<String> skillyList = new ArrayList();

        for (Skill el : skillDao.getAll()) {

            if (!skillyList.contains(el.getName())) {
                cbSkill.addItem(el.getName());
                skillyList.add(el.getName());
            }
        }

    }

    private void fillUserSkillComponent() {

        DefaultTableModel tableModel = new DefaultTableModel();
        Vector vectorHeaders = new Vector();

        vectorHeaders.add("Skill");
        vectorHeaders.add("Power");
        vectorHeaders.add("User");

        Vector vectorRows = new Vector();

        for (UserSkill us : userSkillDao.getAllSkillByUserId(currentUser.getId())) {
            Vector row = new Vector();
            row.add(us.getSkill().getName());
            row.add(us.getPower());
            row.add(currentUser.getFirstname() + " " + currentUser.getLastname());
            vectorRows.add(row);
        }
        tableModel.setDataVector(vectorRows, vectorHeaders);
        tblSkills.setModel(tableModel);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlUserInfo = new javax.swing.JPanel();
        lbName = new javax.swing.JLabel();
        lbSurname = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtSurname = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        tpUserInfo = new javax.swing.JTabbedPane();
        pnlProfile = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaProfile = new javax.swing.JTextArea();
        pnlSkills = new javax.swing.JPanel();
        addSkill = new javax.swing.JButton();
        cbSkill = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSkills = new javax.swing.JTable();
        deleteSkill = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        skills = new javax.swing.JButton();
        pnlDetails = new javax.swing.JPanel();
        lbAdderss1 = new javax.swing.JLabel();
        lbPhone1 = new javax.swing.JLabel();
        lbEmail1 = new javax.swing.JLabel();
        lbBirthday1 = new javax.swing.JLabel();
        lbBirthplace1 = new javax.swing.JLabel();
        lbNationality1 = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        txtPhone = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtBirthdate = new javax.swing.JTextField();
        cbBirthplace = new javax.swing.JComboBox<>();
        cbNationality = new javax.swing.JComboBox<>();
        pnlHistory = new javax.swing.JPanel();
        txtHeader = new javax.swing.JTextField();
        txtJobDescription = new javax.swing.JTextField();
        txtBeginDate = new javax.swing.JTextField();
        addEmpHistory = new javax.swing.JButton();
        updateEmpHistory = new javax.swing.JButton();
        deleteEmpHistory = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblEmpHistory = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtEndDate = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        btnBeginDate = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbName.setText("Name");

        lbSurname.setText("Surname");

        btnSave.setText("save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlUserInfoLayout = new javax.swing.GroupLayout(pnlUserInfo);
        pnlUserInfo.setLayout(pnlUserInfoLayout);
        pnlUserInfoLayout.setHorizontalGroup(
            pnlUserInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUserInfoLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(pnlUserInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlUserInfoLayout.createSequentialGroup()
                        .addComponent(lbName)
                        .addGap(56, 56, 56)
                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlUserInfoLayout.createSequentialGroup()
                        .addComponent(lbSurname)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtSurname, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40)
                .addComponent(btnSave)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlUserInfoLayout.setVerticalGroup(
            pnlUserInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUserInfoLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(pnlUserInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbName)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(pnlUserInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbSurname)
                    .addComponent(txtSurname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSave))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        txtAreaProfile.setColumns(20);
        txtAreaProfile.setRows(5);
        jScrollPane1.setViewportView(txtAreaProfile);

        javax.swing.GroupLayout pnlProfileLayout = new javax.swing.GroupLayout(pnlProfile);
        pnlProfile.setLayout(pnlProfileLayout);
        pnlProfileLayout.setHorizontalGroup(
            pnlProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 716, Short.MAX_VALUE)
        );
        pnlProfileLayout.setVerticalGroup(
            pnlProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlProfileLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE))
        );

        tpUserInfo.addTab("Profile", pnlProfile);

        addSkill.setText("add");

        cbSkill.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        tblSkills.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tblSkills);

        deleteSkill.setText("delete");

        jLabel1.setText("Skill");

        skills.setText("Skills");
        skills.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                skillsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlSkillsLayout = new javax.swing.GroupLayout(pnlSkills);
        pnlSkills.setLayout(pnlSkillsLayout);
        pnlSkillsLayout.setHorizontalGroup(
            pnlSkillsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSkillsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSkillsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteSkill)
                    .addGroup(pnlSkillsLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbSkill, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(addSkill, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(189, 189, 189)
                        .addComponent(skills)))
                .addContainerGap(232, Short.MAX_VALUE))
        );
        pnlSkillsLayout.setVerticalGroup(
            pnlSkillsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSkillsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSkillsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbSkill, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addSkill)
                    .addComponent(skills))
                .addGap(18, 18, 18)
                .addComponent(deleteSkill)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tpUserInfo.addTab("Skills", pnlSkills);

        lbAdderss1.setText("Adderss");

        lbPhone1.setText("Phone");

        lbEmail1.setText("Email");

        lbBirthday1.setText("Birthdate");

        lbBirthplace1.setText("Birthplace");

        lbNationality1.setText("Nationality");

        txtBirthdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBirthdateActionPerformed(evt);
            }
        });

        cbBirthplace.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Azerbaijan", "America", "Japan" }));

        cbNationality.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "American", "Azeri", "Russian", "Turk", "Chinese" }));
        cbNationality.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbNationalityActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlDetailsLayout = new javax.swing.GroupLayout(pnlDetails);
        pnlDetails.setLayout(pnlDetailsLayout);
        pnlDetailsLayout.setHorizontalGroup(
            pnlDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDetailsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbAdderss1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbPhone1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbEmail1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbBirthday1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbBirthplace1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbNationality1))
                .addGap(20, 20, 20)
                .addGroup(pnlDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbNationality, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbBirthplace, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBirthdate, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(519, 519, 519))
        );
        pnlDetailsLayout.setVerticalGroup(
            pnlDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDetailsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbAdderss1)
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbPhone1)
                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbEmail1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbBirthday1)
                    .addComponent(txtBirthdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbBirthplace1)
                    .addComponent(cbBirthplace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNationality1)
                    .addComponent(cbNationality, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(321, Short.MAX_VALUE))
        );

        tpUserInfo.addTab("Details", pnlDetails);

        addEmpHistory.setText("add");
        addEmpHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEmpHistoryActionPerformed(evt);
            }
        });

        updateEmpHistory.setText("update");
        updateEmpHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateEmpHistoryActionPerformed(evt);
            }
        });

        deleteEmpHistory.setText("delete");
        deleteEmpHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteEmpHistoryActionPerformed(evt);
            }
        });

        tblEmpHistory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblEmpHistory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tblEmpHistoryMouseEntered(evt);
            }
        });
        jScrollPane3.setViewportView(tblEmpHistory);

        jLabel2.setText("Header");

        jLabel3.setText("Description");

        jLabel4.setText("Begin Date");

        jLabel5.setText("End Date");

        jFormattedTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextField1ActionPerformed(evt);
            }
        });

        btnBeginDate.setText(">");
        btnBeginDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBeginDateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlHistoryLayout = new javax.swing.GroupLayout(pnlHistory);
        pnlHistory.setLayout(pnlHistoryLayout);
        pnlHistoryLayout.setHorizontalGroup(
            pnlHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHistoryLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlHistoryLayout.createSequentialGroup()
                        .addGroup(pnlHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtHeader)
                                .addComponent(addEmpHistory, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE))
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(updateEmpHistory, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                                .addComponent(txtJobDescription))
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(deleteEmpHistory, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                                .addComponent(txtBeginDate))
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(pnlHistoryLayout.createSequentialGroup()
                                .addComponent(txtEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(56, 56, 56)
                                .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBeginDate)))))
                .addContainerGap(186, Short.MAX_VALUE))
        );
        pnlHistoryLayout.setVerticalGroup(
            pnlHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHistoryLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(7, 7, 7)
                .addGroup(pnlHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtJobDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBeginDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBeginDate))
                .addGap(18, 18, 18)
                .addGroup(pnlHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addEmpHistory)
                    .addComponent(updateEmpHistory)
                    .addComponent(deleteEmpHistory))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        tpUserInfo.addTab("Emp History", pnlHistory);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tpUserInfo)
            .addComponent(pnlUserInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(pnlUserInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tpUserInfo))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed

        currentUser.setFirstname(txtName.getText());
        currentUser.setLastname(txtSurname.getText());

        currentUser.setProfileDescription(txtAreaProfile.getText());

        try {
            long l = sdf.parse(txtBirthdate.getText()).getTime();
            Date bd = new Date(l);
            currentUser.setBirthDate(bd);

        } catch (ParseException ex) {
            System.out.print("Houston, we have a problem");
        }

        currentUser.setAddress(txtAddress.getText());
        currentUser.setPhone(txtPhone.getText());
        currentUser.setEmail(txtEmail.getText());
        if (currentUser.getId() > -1) {
            userDao.updateUser(currentUser);
        } else if (currentUser.getId() == -1) {
            userDao.insertUser(currentUser);

        }

    }//GEN-LAST:event_btnSaveActionPerformed

    private void deleteEmpHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteEmpHistoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteEmpHistoryActionPerformed

    private void txtBirthdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBirthdateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBirthdateActionPerformed

    private void cbNationalityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbNationalityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbNationalityActionPerformed

    private void skillsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_skillsActionPerformed

        Skills uf = new Skills();
        uf.setVisible(true);
    }//GEN-LAST:event_skillsActionPerformed

    private void jFormattedTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextField1ActionPerformed


    }//GEN-LAST:event_jFormattedTextField1ActionPerformed

    private void btnBeginDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBeginDateActionPerformed

        SwingCalendar.call();


    }//GEN-LAST:event_btnBeginDateActionPerformed

    private void addEmpHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEmpHistoryActionPerformed

        if (txtHeader.getText() != "") {
            EmpHistory em = new EmpHistory(null, currentUser, txtHeader.getText(), null, null, txtJobDescription.getText());
            try {
                long l = sdf.parse(txtBeginDate.getText()).getTime();
                Date bd = new Date(l);
                em.setBeginDate(bd);

            } catch (ParseException ex) {
                System.out.print("Houston, we have a problem");
            }
            try {
                long l = sdf.parse(txtEndDate.getText()).getTime();
                Date bd = new Date(l);
                em.setEndDate(bd);

            } catch (ParseException ex) {
                System.out.print("Houston, we have a problem");
            }
            listEmpHis.add(em);
        }

    }//GEN-LAST:event_addEmpHistoryActionPerformed

    private void updateEmpHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateEmpHistoryActionPerformed

    }//GEN-LAST:event_updateEmpHistoryActionPerformed

    private void tblEmpHistoryMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEmpHistoryMouseEntered
        int column = 0;

        int row = tblEmpHistory.getSelectedRow();
        System.out.println("Count : " + row);
        if (row > -1) {

            String value = tblEmpHistory.getModel().getValueAt(row, column).toString();

            EmpHistory em = listEmpHis.get(row);
            txtHeader.setText(em.getHeader());
            txtJobDescription.setText(em.getJobDescription());

            try {
                Date dt = em.getBeginDate();
                String sdt = sdf.format(dt);

                txtBeginDate.setText(sdt);

                dt = em.getBeginDate();
                sdt = sdf.format(dt);

                txtEndDate.setText(sdt);

            } catch (Exception ex) {
                System.out.print("Houston, we have a problem");

            }

        }
    }//GEN-LAST:event_tblEmpHistoryMouseEntered

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addEmpHistory;
    private javax.swing.JButton addSkill;
    private javax.swing.JButton btnBeginDate;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cbBirthplace;
    private javax.swing.JComboBox<String> cbNationality;
    private javax.swing.JComboBox<String> cbSkill;
    private javax.swing.JButton deleteEmpHistory;
    private javax.swing.JButton deleteSkill;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbAdderss1;
    private javax.swing.JLabel lbBirthday1;
    private javax.swing.JLabel lbBirthplace1;
    private javax.swing.JLabel lbEmail1;
    private javax.swing.JLabel lbName;
    private javax.swing.JLabel lbNationality1;
    private javax.swing.JLabel lbPhone1;
    private javax.swing.JLabel lbSurname;
    private javax.swing.JPanel pnlDetails;
    private javax.swing.JPanel pnlHistory;
    private javax.swing.JPanel pnlProfile;
    private javax.swing.JPanel pnlSkills;
    private javax.swing.JPanel pnlUserInfo;
    private javax.swing.JButton skills;
    private javax.swing.JTable tblEmpHistory;
    private javax.swing.JTable tblSkills;
    private javax.swing.JTabbedPane tpUserInfo;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextArea txtAreaProfile;
    private javax.swing.JTextField txtBeginDate;
    private javax.swing.JTextField txtBirthdate;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEndDate;
    private javax.swing.JTextField txtHeader;
    private javax.swing.JTextField txtJobDescription;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtSurname;
    private javax.swing.JButton updateEmpHistory;
    // End of variables declaration//GEN-END:variables
}

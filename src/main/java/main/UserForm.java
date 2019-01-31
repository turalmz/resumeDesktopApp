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
import java.sql.Date;
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import javax.swing.JFrame;

/**
 *
 * @author TURAL
 */
public class UserForm extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    private UserDaoInter userDao = Context.instanceUserDao();
    private CountryDaoInter countryDao = Context.instanceCountryDao();
    private UserSkillDaoInter userSkillDao = Context.instanceUserSkillDao();
    private SkillDaoInter skillDao = Context.instanceSkillDao();
    private EmpHistoryDaoInter empHistoryDao = Context.instanceEmpHistoryDao();

    User currentUser;
    List<EmpHistory> listEmpHis;
    List<UserSkill> listUserSkill;
    List<Skill> skillList;

    public UserForm(int id) {
        initComponents();
        currentUser = userDao.getById(id);
        fillAllComponent();
    }

    public UserForm() {
        initComponents();
        currentUser = new User(-1);
        fillAllComponent();

    }

    private void fillAllComponent() {
        fillUserComponent();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        fillCountryComponent();

        listUserSkill = userSkillDao.getAllSkillByUserId(currentUser.getId());
        fillUserSkillComponent();

        skillList = skillDao.getAll();
        fillSkillComponent();

        listEmpHis = empHistoryDao.getAll();
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
            ex.fillInStackTrace();
        }
        txtEmail.setText(currentUser.getEmail());
        txtPhone.setText(currentUser.getPhone());
        txtAddress.setText(currentUser.getAddress());
    }

    private void fillCountryComponent() {
        cbBirthplace.removeAllItems();
        cbNationality.removeAllItems();

        for (Country con : countryDao.getAll()) {
            cbBirthplace.addItem(con);
            cbNationality.addItem(con);
        }

    }

    private void fillEmpHistoryComponent() {
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

        for (Skill el : skillList) {
            cbSkill.addItem(el);
        }

    }

    private void fillUserSkillComponent() {

        DefaultTableModel tableModel = new DefaultTableModel();
        Vector vectorHeaders = new Vector();

        vectorHeaders.add("Skill");
        vectorHeaders.add("Power");

        Vector vectorRows = new Vector();

        for (UserSkill us : listUserSkill) {
            Vector row = new Vector();
            row.add(us.getSkill().getName());
            row.add(us.getPower());
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
        btnAddSkill = new javax.swing.JButton();
        cbSkill = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSkills = new javax.swing.JTable();
        btnDeleteSkill = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        btnUpdateSkill = new javax.swing.JButton();
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
        addEmpHistory = new javax.swing.JButton();
        updateEmpHistory = new javax.swing.JButton();
        deleteEmpHistory = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblEmpHistory = new javax.swing.JTable();

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

        btnAddSkill.setText("add");
        btnAddSkill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddSkillActionPerformed(evt);
            }
        });

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

        btnDeleteSkill.setText("delete");
        btnDeleteSkill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteSkillActionPerformed(evt);
            }
        });

        jLabel1.setText("Skill");

        btnUpdateSkill.setText("update");

        javax.swing.GroupLayout pnlSkillsLayout = new javax.swing.GroupLayout(pnlSkills);
        pnlSkills.setLayout(pnlSkillsLayout);
        pnlSkillsLayout.setHorizontalGroup(
            pnlSkillsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSkillsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSkillsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlSkillsLayout.createSequentialGroup()
                        .addComponent(btnDeleteSkill)
                        .addGap(26, 26, 26)
                        .addComponent(btnUpdateSkill))
                    .addGroup(pnlSkillsLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbSkill, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAddSkill, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(296, Short.MAX_VALUE))
        );
        pnlSkillsLayout.setVerticalGroup(
            pnlSkillsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSkillsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSkillsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbSkill, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddSkill)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlSkillsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDeleteSkill)
                    .addComponent(btnUpdateSkill))
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
        jScrollPane3.setViewportView(tblEmpHistory);

        javax.swing.GroupLayout pnlHistoryLayout = new javax.swing.GroupLayout(pnlHistory);
        pnlHistory.setLayout(pnlHistoryLayout);
        pnlHistoryLayout.setHorizontalGroup(
            pnlHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHistoryLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlHistoryLayout.createSequentialGroup()
                        .addComponent(addEmpHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(updateEmpHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteEmpHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(254, Short.MAX_VALUE))
        );
        pnlHistoryLayout.setVerticalGroup(
            pnlHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHistoryLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addEmpHistory)
                    .addComponent(updateEmpHistory)
                    .addComponent(deleteEmpHistory))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(112, Short.MAX_VALUE))
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

    private void btnDeleteSkillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteSkillActionPerformed
        int column = 0;

        int row = tblSkills.getSelectedRow();
        System.out.println("Count : " + row);
        if (row > -1) {

            ((DefaultTableModel) tblSkills.getModel()).removeRow(row);
            listUserSkill.remove(row);
            fillUserSkillComponent();
        }
    }//GEN-LAST:event_btnDeleteSkillActionPerformed

    private void btnAddSkillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddSkillActionPerformed

        if (cbSkill.getSelectedItem() != null) {
            System.out.println(cbSkill.getSelectedItem().toString());
            UserSkill us = new UserSkill(null, currentUser, skillList.get(cbSkill.getSelectedIndex()), 1);
            listUserSkill.add(us);
            fillUserSkillComponent();
        }
    }//GEN-LAST:event_btnAddSkillActionPerformed

    private void deleteEmpHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteEmpHistoryActionPerformed
        int column = 0;

        int row = tblEmpHistory.getSelectedRow();
        System.out.println("Count : " + row);
        if (row > -1) {

            ((DefaultTableModel) tblEmpHistory.getModel()).removeRow(row);
            listEmpHis.remove(row);

        }
    }//GEN-LAST:event_deleteEmpHistoryActionPerformed

    private void updateEmpHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateEmpHistoryActionPerformed
        int column = 0;

        int row = tblEmpHistory.getSelectedRow();
        System.out.println("Count : " + row);
        if (row > -1) {

            EmpHistory em = listEmpHis.get(row);
            EmpHistoryForm ef = new EmpHistoryForm(this, em);
            ef.setVisible(true);

        }
    }//GEN-LAST:event_updateEmpHistoryActionPerformed

    private void addEmpHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEmpHistoryActionPerformed

        EmpHistoryForm ef = new EmpHistoryForm(this);
        ef.setVisible(true);
    }//GEN-LAST:event_addEmpHistoryActionPerformed

    private void cbNationalityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbNationalityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbNationalityActionPerformed

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
    private javax.swing.JButton btnAddSkill;
    private javax.swing.JButton btnDeleteSkill;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdateSkill;
    private javax.swing.JComboBox<Country> cbBirthplace;
    private javax.swing.JComboBox<Country> cbNationality;
    private javax.swing.JComboBox<Skill> cbSkill;
    private javax.swing.JButton deleteEmpHistory;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField1;
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
    private javax.swing.JTable tblEmpHistory;
    private javax.swing.JTable tblSkills;
    private javax.swing.JTabbedPane tpUserInfo;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextArea txtAreaProfile;
    private javax.swing.JTextField txtBirthdate;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtSurname;
    private javax.swing.JButton updateEmpHistory;
    // End of variables declaration//GEN-END:variables

    public boolean addEmpHistory(EmpHistory em) {
        try {
            listEmpHis.add(em);
            fillEmpHistoryComponent();
            System.out.print(listEmpHis);

            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean updateEmpHistory(EmpHistory em) {
        try {
            fillEmpHistoryComponent();
            System.out.print(listEmpHis);

            return true;
        } catch (Exception ex) {
            return false;
        }

    }

}

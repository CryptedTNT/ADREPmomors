/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.final_project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;



/**
 *
 * @author compvtre
 */
public class Frm_Final_project extends javax.swing.JFrame {
	
	private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Frm_Final_project.class.getName());
	/**
	 * todo:
	 * secure login page
	 * secure clearing Login Page
	 * set timer (:set))
	 * delete temps (:delete)
	 * change recommendation method for better format
	 * clear Questions
	 */

	/**
	 * Creates new form Frm_Final_project
	 */
	//initialization 
        private ChatbotLogic chatbot;
	public Frm_Final_project() {
		initComponents();
		createPanelPage("Login",pnlLogin);
		setDateTime();
		setQuestions();
                chatbot = new ChatbotLogic();
                // Initial greeting when chatbot loads
                txtAreaChatBot.append("OLEG: Maligayang pagdating sa aming Department Store! Ako si Store Assistant.\nPaano kita matutulungan ngayong araw?\n\n");
                
                txtFieldChatBot.addKeyListener(new java.awt.event.KeyAdapter() {
                    public void keyPressed(java.awt.event.KeyEvent evt) {
                        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
                        btnSubmitChatBotActionPerformed(null);
                        }
                    }
                });
                
		//temp: delete later (:delete)
		User admin_temp = new User("a", "a");
		admin_temp.setAdmin();
		userMap.put("a", admin_temp);

    	}
	
	//user list
	Map<String, User> userMap = new HashMap<>();
	String currentUser = "";
	
	int loginAttempt = 0;
	
	//questions
	List<Question>	questions = new ArrayList<>();
	int currentQuestionIndex = 0;
	int score = 0;
	
	//timer
	int seconds; //(:set)
	Timer timer;

	boolean isGuest = false;

	//methods
	private void setQuestions(){
		questions.clear();
		questions.add(new Question(
			"1. What is 7² + 5?", //question
			List.of("45", //option 1
				"54", //option 2
				"49", //option 3
				"44"),//option 4
		1) // correct answer in index (for example correct answer is option 2, index = 1)
		);
		questions.add(new Question(
			"2. Solve for x: 3x + 9 = 24", //question
			List.of("3", //option 1
				"6", //option 2
				"7", //option 3
				"5"),//option 4
		3) // correct answer in index (for example correct answer is option 2, index = 1)
		);
		questions.add(new Question(
			"3. What is √225?", //question
			List.of("15", //option 1
				"10", //option 2
				"25", //option 3
				"13"),//option 4
		0) // correct answer in index (for example correct answer is option 2, index = 1)
		);
		questions.add(new Question(
			"4. What shape has 4 equal sides and 4 right angles?", //question
			List.of("Pentagon", //option 1
				"Rectangle", //option 2
				"Square", //option 3
				"Rhombus"),//option 4
		2) // correct answer in index (for example correct answer is option 2, index = 1)
		);
		questions.add(new Question(
			"5. What is the median of the set: 2, 5, 6, 7, 10, 13, 15", //question
			List.of("6", //option 1
				"7", //option 2
				"5", //option 3
				"10"),//option 4
		1) // correct answer in index (for example correct answer is option 2, index = 1)
		);
		questions.add(new Question(
			"6. Which shape has 9 sides?", //question
			List.of("Nonagon", //option 1
				"Octagon", //option 2
				"Heptagon", //option 3
				"Decagon"),//option 4
		0) // correct answer in index (for example correct answer is option 2, index = 1)
		);
		questions.add(new Question(
			"7. Round off to the nearest ten thousands: 267,042", //question
			List.of("268,000", //option 1
				"300,000", //option 2
				"270,000", //option 3
				"260,000"),//option 4
		2) // correct answer in index (for example correct answer is option 2, index = 1)
		);
		questions.add(new Question(
			"8. What is the value of pi rounded to two decimal places?", //question
			List.of("3.14", //option 1
				"3.13", //option 2
				"3.67", //option 3
				"2.14"),//option 4
		0) // correct answer in index (for example correct answer is option 2, index = 1)
		);
		questions.add(new Question(
			"9. Convert 28/3 to a mixed fraction", //question
			List.of("8 1/3", //option 1
				"8 2/3", //option 2
				"9 2/3", //option 3
				"9 1/3"),//option 4
		3) // correct answer in index (for example correct answer is option 2, index = 1)
		);
		questions.add(new Question(
			"10. Convert 1/5 into a decimal.", //question
			List.of("0.1", //option 1
				"0.2", //option 2
				"0.25", //option 3
				"0.01"),//option 4
		1) // correct answer in index (for example correct answer is option 2, index = 1)
		);
		questions.add(new Question(
			"11. What do you call the number that appears most often in a data set?", //question
			List.of("Mean", //option 1
				"Median", //option 2
				"Mode", //option 3
				"Integer"),//option 4
		2) // correct answer in index (for example correct answer is option 2, index = 1)
		);
		questions.add(new Question(
			"12. What does a linear function represents in a graph?", //question
			List.of("Curved line", //option 1
				"S-shaped line", //option 2
				"Straight line", //option 3
				"Parabola"),//option 4
		2) // correct answer in index (for example correct answer is option 2, index = 1)
		);
		questions.add(new Question(
			"13. What is the perimeter of a circle if it has a side length of 8?", //question
			List.of("24", //option 1
				"64", //option 2
				"16", //option 3
				"32"),//option 4
		3) // correct answer in index (for example correct answer is option 2, index = 1)
		);
		questions.add(new Question(
			"14. What is 3³?", //question
			List.of("3", //option 1
				"9", //option 2
				"27", //option 3
				"18"),//option 4
		2) // correct answer in index (for example correct answer is option 2, index = 1)
		);
		questions.add(new Question(
			"15. What is the area of a rectangle with length 9 and width 5?", //question
			List.of("14", //option 1
				"45", //option 2
				"28", //option 3
				"54"),//option 4
		1) // correct answer in index (for example correct answer is option 2, index = 1)
		);
		questions.add(new Question(
			"16. Value of 6!", //question
			List.of("720", //option 1
				"120", //option 2
				"600", //option 3
				"36"),//option 4
		0) // correct answer in index (for example correct answer is option 2, index = 1)
		);
		questions.add(new Question(
			"17. What is the place value of 8 in 0.803?", //question
			List.of("Oneths", //option 1
				"Hundredths", //option 2
				"Tenths", //option 3
				"Ones"),//option 4
		2) // correct answer in index (for example correct answer is option 2, index = 1)
		);

		//initializes the question
		groupRadioButton();
		lblQuestion.setText(questions.get(currentQuestionIndex).getQuestion());
		rbOption.setText(questions.get(currentQuestionIndex).getOptions().get(0));
		rbOption1.setText(questions.get(currentQuestionIndex).getOptions().get(1));
		rbOption2.setText(questions.get(currentQuestionIndex).getOptions().get(2));
		rbOption3.setText(questions.get(currentQuestionIndex).getOptions().get(3));

	}
	
	private void setSummary()
	{
		List<JLabel> questionSummary = new ArrayList<>();
		questionSummary = new ArrayList<>(List.of(
		    lblQuestion1, lblQuestion2, lblQuestion3, lblQuestion4, lblQuestion5,
		    lblQuestion6, lblQuestion7, lblQuestion8, lblQuestion9, lblQuestion10,
		    lblQuestion11, lblQuestion12, lblQuestion13, lblQuestion14, lblQuestion15,
		    lblQuestion16, lblQuestion17
		));


		for(int i = 0; i < questions.size();i++){
			questionSummary.get(i).setText(questions.get(i).getQuestion() + " " + questions.get(i).getResult());
		}


		User user = userMap.get(currentUser);
		lblUser.setText(user.getUsername());
		lblScore.setText("Score: " + user.getScore() + "/" + questions.size());
		lblRemarks.setText("Remarks: " + user.getRemarks());
		setRecommendation(user.getRemarks());


	}
	private void setProgress()
	{
		String[] columns = {"Username", "Score", "Status"};
		DefaultTableModel model = (DefaultTableModel) tblProgress.getModel();
		model.setRowCount(0);
		for(var user: userMap.values())
		{
			model.addRow(new Object[]{user.getUsername(), user.getScore(), user.getRemarks()});
		}
	}


	private void setRecommendation(String rating)
	{
		switch (rating) {
		    case "EXCELLENT" -> lblRecommendation.setText(
			    "<html>You demonstrated a strong understanding of the subject.<br>" +
			    "Continue maintaining this level of performance.</html>");

		    case "VERY GOOD" -> lblRecommendation.setText(
			    "<html>Your performance is solid. Review minor areas to further<br>" +
			    "improve accuracy and consistency.</html>");

		    case "FAIR" -> lblRecommendation.setText(
			    "<html>Your understanding is satisfactory. It is recommended to<br>" +
			    "revisit key concepts and practice regularly.</html>");

		    case "FAILED" -> lblRecommendation.setText(
			    "<html>Your performance indicates gaps in understanding. A thorough<br>" +
			    "review of the material is strongly recommended before retaking<br>" +
			    "the assessment.</html>");

		    default -> lblRecommendation.setText("<html>No status available.</html>");
		}
	}
	

	private void groupRadioButton()
	{
		ButtonGroup bg = new ButtonGroup();
		bg.add(rbOption);
		bg.add(rbOption1);
		bg.add(rbOption2);
		bg.add(rbOption3);
		bg.clearSelection();
    	}
	
	private void setDateTime()
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

		Timer timer1 = new Timer(1000, e -> {
		    String currentDateTime = LocalDateTime.now().format(formatter);
		    	lblDate.setText(currentDateTime);
		    	lblDate1.setText(currentDateTime);
		    	lblDate2.setText(currentDateTime);
		});
		timer1.start(); 
	}
	public boolean isValidPassword(String password) 
	{
		String pattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$";
		return password.matches(pattern);
	}
   	private void msgAlert(String msg, int icon, String title)
	{
		JOptionPane opt = new JOptionPane();
		opt.setMessage(msg);
		opt.setMessageType(icon);
		JDialog dialog = opt.createDialog(this, title);
		dialog.setVisible(true);
	}
	private void clearLoginFields()
	{	
		txtUsername.setText("");
		//temp
		txtPassword.setText("");
	}

	private void createPanelPage(String title ,JPanel panel)
	{
		var panels = new ArrayList<>(Arrays.asList(pnlLogin,pnlSignUp,pnlAdminDashboard,pnlUserDashboard,pnlGuestDashboard,pnlQuiz,
				pnlChatbot,pnlVisualization,pnlCredits,
				pnlSummary,pnlProgress
				));
		if(panels.contains(panel))
		{
			for (var p: panels)
			{
				if(p == panel)
				{
					tabbedPane.add(title, p);
				}
				else
				{
					tabbedPane.remove(p);
					
				}
			}
		}

	}
	// countdown
    	private void startCountdown() 
	{
		timer = new Timer(1000, e -> {
		    seconds--;
		    lblQuizTimer.setText("Time left: " + seconds);

		    if (seconds <= 0) {
			timer.stop();
			onCountdownFinished();
		    }
		});

		timer.start();
    	}

    	private void onCountdownFinished() 
	{
		msgAlert("Time is up",JOptionPane.INFORMATION_MESSAGE, "Countdown Finished" );
		//clear fields
		User user = userMap.get(currentUser);
		user.setScore(score);

		currentQuestionIndex = 0;
		score=0;


		//set Summary
		setSummary();
		//go to next page
		createPanelPage("Summary", pnlSummary);
	    }
        
        

	/**
	 * This method is called from within the constructor to initialize the
	 * form. WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabbedPane = new javax.swing.JTabbedPane();
        pnlLogin = new javax.swing.JPanel();
        btnLogin = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnGuest = new javax.swing.JButton();
        btnSignUp = new javax.swing.JButton();
        cbShowPassword = new javax.swing.JCheckBox();
        txtPassword = new javax.swing.JPasswordField();
        pnlSignUp = new javax.swing.JPanel();
        cbIsAdmin = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        txtUsername1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnCreateAccount = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        btnBackToLogin = new javax.swing.JButton();
        cbShowPassword1 = new javax.swing.JCheckBox();
        txtPassword1 = new javax.swing.JPasswordField();
        pnlAdminDashboard = new javax.swing.JPanel();
        btnChatbot = new javax.swing.JButton();
        btnQuiz = new javax.swing.JButton();
        btnCredits = new javax.swing.JButton();
        lblWelcome = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        btnVisualization = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        pnlUserDashboard = new javax.swing.JPanel();
        lblWelcome1 = new javax.swing.JLabel();
        btnQuiz1 = new javax.swing.JButton();
        btnChatbot1 = new javax.swing.JButton();
        btnCredits1 = new javax.swing.JButton();
        lblDate1 = new javax.swing.JLabel();
        btnLogout1 = new javax.swing.JButton();
        pnlGuestDashboard = new javax.swing.JPanel();
        btnChatbot2 = new javax.swing.JButton();
        btnCredits2 = new javax.swing.JButton();
        lblWelcome2 = new javax.swing.JLabel();
        lblDate2 = new javax.swing.JLabel();
        btnLogout2 = new javax.swing.JButton();
        pnlQuiz = new javax.swing.JPanel();
        lblQuizTimer = new javax.swing.JLabel();
        lblQuestion = new javax.swing.JLabel();
        rbOption = new javax.swing.JRadioButton();
        rbOption1 = new javax.swing.JRadioButton();
        rbOption2 = new javax.swing.JRadioButton();
        rbOption3 = new javax.swing.JRadioButton();
        btnSubmit = new javax.swing.JButton();
        pnlSummary = new javax.swing.JPanel();
        lblQuestion1 = new javax.swing.JLabel();
        lblQuestion2 = new javax.swing.JLabel();
        lblQuestion3 = new javax.swing.JLabel();
        lblQuestion4 = new javax.swing.JLabel();
        lblQuestion5 = new javax.swing.JLabel();
        lblQuestion6 = new javax.swing.JLabel();
        lblQuestion7 = new javax.swing.JLabel();
        lblQuestion8 = new javax.swing.JLabel();
        lblQuestion9 = new javax.swing.JLabel();
        lblQuestion10 = new javax.swing.JLabel();
        lblQuestion11 = new javax.swing.JLabel();
        lblQuestion12 = new javax.swing.JLabel();
        lblQuestion13 = new javax.swing.JLabel();
        lblQuestion14 = new javax.swing.JLabel();
        lblQuestion15 = new javax.swing.JLabel();
        lblQuestion16 = new javax.swing.JLabel();
        lblQuestion17 = new javax.swing.JLabel();
        lblRemarks = new javax.swing.JLabel();
        lblUser = new javax.swing.JLabel();
        lblScore = new javax.swing.JLabel();
        btnRetake = new javax.swing.JButton();
        btnProgress = new javax.swing.JButton();
        lblRecommendation = new javax.swing.JLabel();
        pnlProgress = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProgress = new javax.swing.JTable();
        btnRetake1 = new javax.swing.JButton();
        btnSummary = new javax.swing.JButton();
        btnDashboard = new javax.swing.JButton();
        pnlChatbot = new javax.swing.JPanel();
        btnDashboard1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAreaChatBot = new javax.swing.JTextArea();
        txtFieldChatBot = new javax.swing.JTextField();
        btnSubmitChatBot = new javax.swing.JButton();
        pnlVisualization = new javax.swing.JPanel();
        btnDashboard2 = new javax.swing.JButton();
        pnlCredits = new javax.swing.JPanel();
        btnDashboard3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlLogin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        pnlLogin.add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 200, 235, -1));

        jLabel1.setText("Username or Email Address");
        pnlLogin.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 51, -1, -1));
        pnlLogin.add(txtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 73, 235, -1));

        jLabel2.setText("Password");
        pnlLogin.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 105, 144, -1));

        jLabel3.setText("----------------------or ----------------------");
        pnlLogin.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 240, 235, -1));

        btnGuest.setText("Continue as Guest");
        btnGuest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuestActionPerformed(evt);
            }
        });
        pnlLogin.add(btnGuest, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 290, 235, -1));

        btnSignUp.setText("Sign Up");
        btnSignUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignUpActionPerformed(evt);
            }
        });
        pnlLogin.add(btnSignUp, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 260, 235, -1));

        cbShowPassword.setText("Show Password");
        cbShowPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbShowPasswordActionPerformed(evt);
            }
        });
        pnlLogin.add(cbShowPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 170, -1, -1));

        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });
        pnlLogin.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 130, 240, -1));

        tabbedPane.addTab("Login", pnlLogin);

        cbIsAdmin.setText("Admin");

        jLabel4.setText("Enter Username or Email Address");

        jLabel5.setText("Enter Password");

        btnCreateAccount.setText("Create Account");
        btnCreateAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateAccountActionPerformed(evt);
            }
        });

        jLabel6.setText("----------------------or ----------------------");

        btnBackToLogin.setText("Login");
        btnBackToLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackToLoginActionPerformed(evt);
            }
        });

        cbShowPassword1.setText("Show Password");
        cbShowPassword1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbShowPassword1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlSignUpLayout = new javax.swing.GroupLayout(pnlSignUp);
        pnlSignUp.setLayout(pnlSignUpLayout);
        pnlSignUpLayout.setHorizontalGroup(
            pnlSignUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSignUpLayout.createSequentialGroup()
                .addGap(291, 291, 291)
                .addGroup(pnlSignUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbShowPassword1)
                    .addComponent(cbIsAdmin)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUsername1)
                    .addComponent(btnCreateAccount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                    .addComponent(btnBackToLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPassword1))
                .addContainerGap(304, Short.MAX_VALUE))
        );
        pnlSignUpLayout.setVerticalGroup(
            pnlSignUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSignUpLayout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUsername1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtPassword1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(cbShowPassword1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbIsAdmin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCreateAccount)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBackToLogin)
                .addContainerGap(225, Short.MAX_VALUE))
        );

        tabbedPane.addTab("Sign Up", pnlSignUp);

        btnChatbot.setText("Chatbot");
        btnChatbot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChatbotActionPerformed(evt);
            }
        });

        btnQuiz.setText("Quiz");
        btnQuiz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuizActionPerformed(evt);
            }
        });

        btnCredits.setText("Credits");
        btnCredits.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreditsActionPerformed(evt);
            }
        });

        lblWelcome.setText("Welcome");

        lblDate.setText("Date");

        btnVisualization.setText("Visualization");
        btnVisualization.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVisualizationActionPerformed(evt);
            }
        });

        btnLogout.setText("Log out");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlAdminDashboardLayout = new javax.swing.GroupLayout(pnlAdminDashboard);
        pnlAdminDashboard.setLayout(pnlAdminDashboardLayout);
        pnlAdminDashboardLayout.setHorizontalGroup(
            pnlAdminDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAdminDashboardLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblDate)
                .addGap(90, 90, 90))
            .addGroup(pnlAdminDashboardLayout.createSequentialGroup()
                .addGap(144, 144, 144)
                .addGroup(pnlAdminDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlAdminDashboardLayout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addGroup(pnlAdminDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCredits, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnQuiz, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnChatbot, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnVisualization, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lblWelcome))
                .addContainerGap(374, Short.MAX_VALUE))
        );
        pnlAdminDashboardLayout.setVerticalGroup(
            pnlAdminDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAdminDashboardLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(lblDate)
                .addGap(38, 38, 38)
                .addComponent(lblWelcome)
                .addGap(56, 56, 56)
                .addComponent(btnQuiz)
                .addGap(18, 18, 18)
                .addComponent(btnChatbot)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnVisualization)
                .addGap(12, 12, 12)
                .addComponent(btnCredits)
                .addGap(29, 29, 29)
                .addComponent(btnLogout)
                .addContainerGap(219, Short.MAX_VALUE))
        );

        tabbedPane.addTab("Dashboard - Admin", pnlAdminDashboard);

        lblWelcome1.setText("Welcome");

        btnQuiz1.setText("Quiz");
        btnQuiz1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuiz1ActionPerformed(evt);
            }
        });

        btnChatbot1.setText("Chatbot");
        btnChatbot1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChatbot1ActionPerformed(evt);
            }
        });

        btnCredits1.setText("Credits");
        btnCredits1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCredits1ActionPerformed(evt);
            }
        });

        lblDate1.setText("Date");

        btnLogout1.setText("Log out");
        btnLogout1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogout1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlUserDashboardLayout = new javax.swing.GroupLayout(pnlUserDashboard);
        pnlUserDashboard.setLayout(pnlUserDashboardLayout);
        pnlUserDashboardLayout.setHorizontalGroup(
            pnlUserDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlUserDashboardLayout.createSequentialGroup()
                .addContainerGap(123, Short.MAX_VALUE)
                .addGroup(pnlUserDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlUserDashboardLayout.createSequentialGroup()
                        .addGap(584, 584, 584)
                        .addComponent(lblDate1))
                    .addGroup(pnlUserDashboardLayout.createSequentialGroup()
                        .addGroup(pnlUserDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlUserDashboardLayout.createSequentialGroup()
                                .addGap(134, 134, 134)
                                .addGroup(pnlUserDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnCredits1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnQuiz1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnChatbot1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnLogout1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(lblWelcome1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 296, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(99, 99, 99))
        );
        pnlUserDashboardLayout.setVerticalGroup(
            pnlUserDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUserDashboardLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(lblDate1)
                .addGap(38, 38, 38)
                .addComponent(lblWelcome1)
                .addGap(56, 56, 56)
                .addComponent(btnQuiz1)
                .addGap(18, 18, 18)
                .addComponent(btnChatbot1)
                .addGap(18, 18, 18)
                .addComponent(btnCredits1)
                .addGap(18, 18, 18)
                .addComponent(btnLogout1)
                .addContainerGap(227, Short.MAX_VALUE))
        );

        tabbedPane.addTab("Dashboard - User", pnlUserDashboard);

        btnChatbot2.setText("Chatbot");
        btnChatbot2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChatbot2ActionPerformed(evt);
            }
        });

        btnCredits2.setText("Credits");
        btnCredits2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCredits2ActionPerformed(evt);
            }
        });

        lblWelcome2.setText("Welcome");

        lblDate2.setText("Date");

        btnLogout2.setText("Log out");
        btnLogout2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogout2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlGuestDashboardLayout = new javax.swing.GroupLayout(pnlGuestDashboard);
        pnlGuestDashboard.setLayout(pnlGuestDashboardLayout);
        pnlGuestDashboardLayout.setHorizontalGroup(
            pnlGuestDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlGuestDashboardLayout.createSequentialGroup()
                .addContainerGap(145, Short.MAX_VALUE)
                .addGroup(pnlGuestDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlGuestDashboardLayout.createSequentialGroup()
                        .addGap(584, 584, 584)
                        .addComponent(lblDate2))
                    .addGroup(pnlGuestDashboardLayout.createSequentialGroup()
                        .addGroup(pnlGuestDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlGuestDashboardLayout.createSequentialGroup()
                                .addGap(134, 134, 134)
                                .addGroup(pnlGuestDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnCredits2, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnChatbot2, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnLogout2, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(lblWelcome2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 296, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(77, 77, 77))
        );
        pnlGuestDashboardLayout.setVerticalGroup(
            pnlGuestDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGuestDashboardLayout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(lblDate2)
                .addGap(38, 38, 38)
                .addComponent(lblWelcome2)
                .addGap(101, 101, 101)
                .addComponent(btnChatbot2)
                .addGap(18, 18, 18)
                .addComponent(btnCredits2)
                .addGap(18, 18, 18)
                .addComponent(btnLogout2)
                .addContainerGap(203, Short.MAX_VALUE))
        );

        tabbedPane.addTab("Dashboard - Guest", pnlGuestDashboard);

        lblQuizTimer.setText("Timer");

        lblQuestion.setText("Question");

        rbOption.setText("Answer 1");

        rbOption1.setText("Answer 2");

        rbOption2.setText("Answer 3");

        rbOption3.setText("Answer 4");

        btnSubmit.setText("Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlQuizLayout = new javax.swing.GroupLayout(pnlQuiz);
        pnlQuiz.setLayout(pnlQuizLayout);
        pnlQuizLayout.setHorizontalGroup(
            pnlQuizLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlQuizLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblQuizTimer)
                .addGap(150, 150, 150))
            .addGroup(pnlQuizLayout.createSequentialGroup()
                .addGroup(pnlQuizLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlQuizLayout.createSequentialGroup()
                        .addGap(247, 247, 247)
                        .addComponent(lblQuestion))
                    .addGroup(pnlQuizLayout.createSequentialGroup()
                        .addGap(362, 362, 362)
                        .addGroup(pnlQuizLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(rbOption1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rbOption, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rbOption2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rbOption3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(368, Short.MAX_VALUE))
        );
        pnlQuizLayout.setVerticalGroup(
            pnlQuizLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlQuizLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(lblQuizTimer)
                .addGap(28, 28, 28)
                .addComponent(lblQuestion)
                .addGap(70, 70, 70)
                .addComponent(rbOption)
                .addGap(18, 18, 18)
                .addComponent(rbOption1)
                .addGap(18, 18, 18)
                .addComponent(rbOption2)
                .addGap(18, 18, 18)
                .addComponent(rbOption3)
                .addGap(18, 18, 18)
                .addComponent(btnSubmit)
                .addContainerGap(201, Short.MAX_VALUE))
        );

        tabbedPane.addTab("Quiz - Questions", pnlQuiz);

        lblQuestion1.setText("jLabel7");

        lblQuestion2.setText("jLabel7");

        lblQuestion3.setText("jLabel7");

        lblQuestion4.setText("jLabel7");

        lblQuestion5.setText("jLabel7");

        lblQuestion6.setText("jLabel7");

        lblQuestion7.setText("jLabel7");

        lblQuestion8.setText("jLabel7");

        lblQuestion9.setText("jLabel7");

        lblQuestion10.setText("jLabel7");

        lblQuestion11.setText("jLabel7");

        lblQuestion12.setText("jLabel7");

        lblQuestion13.setText("jLabel7");

        lblQuestion14.setText("jLabel7");

        lblQuestion15.setText("jLabel7");

        lblQuestion16.setText("jLabel7");

        lblQuestion17.setText("jLabel7");

        lblRemarks.setText("Remarks");

        lblUser.setText("User");

        lblScore.setText("Score");

        btnRetake.setText("Retake");
        btnRetake.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetakeActionPerformed(evt);
            }
        });

        btnProgress.setText("Next");
        btnProgress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProgressActionPerformed(evt);
            }
        });

        lblRecommendation.setText("Recommendation");

        javax.swing.GroupLayout pnlSummaryLayout = new javax.swing.GroupLayout(pnlSummary);
        pnlSummary.setLayout(pnlSummaryLayout);
        pnlSummaryLayout.setHorizontalGroup(
            pnlSummaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSummaryLayout.createSequentialGroup()
                .addGroup(pnlSummaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlSummaryLayout.createSequentialGroup()
                        .addGap(175, 175, 175)
                        .addGroup(pnlSummaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlSummaryLayout.createSequentialGroup()
                                .addComponent(lblQuestion16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 287, Short.MAX_VALUE)
                                .addComponent(btnRetake))
                            .addGroup(pnlSummaryLayout.createSequentialGroup()
                                .addGroup(pnlSummaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblQuestion17)
                                    .addComponent(lblQuestion15)
                                    .addComponent(lblQuestion14)
                                    .addComponent(lblQuestion13)
                                    .addComponent(lblQuestion12)
                                    .addComponent(lblQuestion11)
                                    .addComponent(lblQuestion10)
                                    .addComponent(lblQuestion9)
                                    .addComponent(lblQuestion8)
                                    .addComponent(lblQuestion7)
                                    .addComponent(lblQuestion6)
                                    .addComponent(lblQuestion5)
                                    .addComponent(lblQuestion4)
                                    .addComponent(lblQuestion3)
                                    .addComponent(lblQuestion2)
                                    .addComponent(lblQuestion1)
                                    .addComponent(lblRemarks)
                                    .addComponent(lblScore)
                                    .addComponent(lblRecommendation))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(pnlSummaryLayout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(lblUser)))
                .addGap(48, 48, 48)
                .addComponent(btnProgress)
                .addGap(139, 139, 139))
        );
        pnlSummaryLayout.setVerticalGroup(
            pnlSummaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSummaryLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblQuestion1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblQuestion2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblQuestion3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblQuestion4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblQuestion5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblQuestion6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblQuestion7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblQuestion8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblQuestion9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblQuestion10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblQuestion11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblQuestion12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblQuestion13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblQuestion14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblQuestion15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlSummaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQuestion16)
                    .addComponent(btnRetake)
                    .addComponent(btnProgress))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblQuestion17)
                .addGap(38, 38, 38)
                .addComponent(lblScore)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblRemarks)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblRecommendation)
                .addContainerGap(58, Short.MAX_VALUE))
        );

        tabbedPane.addTab("Quiz - Summary", pnlSummary);

        tblProgress.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "User", "Score", "Remarks"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblProgress);
        if (tblProgress.getColumnModel().getColumnCount() > 0) {
            tblProgress.getColumnModel().getColumn(0).setResizable(false);
            tblProgress.getColumnModel().getColumn(1).setResizable(false);
            tblProgress.getColumnModel().getColumn(2).setResizable(false);
        }

        btnRetake1.setText("Retake");
        btnRetake1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetake1ActionPerformed(evt);
            }
        });

        btnSummary.setText("Summary");
        btnSummary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSummaryActionPerformed(evt);
            }
        });

        btnDashboard.setText("Dashboard");
        btnDashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDashboardActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlProgressLayout = new javax.swing.GroupLayout(pnlProgress);
        pnlProgress.setLayout(pnlProgressLayout);
        pnlProgressLayout.setHorizontalGroup(
            pnlProgressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlProgressLayout.createSequentialGroup()
                .addContainerGap(282, Short.MAX_VALUE)
                .addComponent(btnDashboard)
                .addGap(12, 12, 12)
                .addComponent(btnRetake1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSummary)
                .addGap(284, 284, 284))
        );
        pnlProgressLayout.setVerticalGroup(
            pnlProgressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProgressLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 545, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlProgressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRetake1)
                    .addComponent(btnSummary)
                    .addComponent(btnDashboard)))
        );

        tabbedPane.addTab("Quiz - Progress", pnlProgress);

        btnDashboard1.setText("Dashboard");
        btnDashboard1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDashboard1ActionPerformed(evt);
            }
        });

        txtAreaChatBot.setColumns(20);
        txtAreaChatBot.setRows(5);
        jScrollPane2.setViewportView(txtAreaChatBot);

        txtFieldChatBot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldChatBotActionPerformed(evt);
            }
        });

        btnSubmitChatBot.setText("jButton1");
        btnSubmitChatBot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitChatBotActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlChatbotLayout = new javax.swing.GroupLayout(pnlChatbot);
        pnlChatbot.setLayout(pnlChatbotLayout);
        pnlChatbotLayout.setHorizontalGroup(
            pnlChatbotLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlChatbotLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(pnlChatbotLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlChatbotLayout.createSequentialGroup()
                        .addComponent(txtFieldChatBot, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(97, 97, 97)
                        .addComponent(btnSubmitChatBot, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(240, Short.MAX_VALUE))
                    .addGroup(pnlChatbotLayout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDashboard1)
                        .addGap(72, 72, 72))))
        );
        pnlChatbotLayout.setVerticalGroup(
            pnlChatbotLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlChatbotLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(pnlChatbotLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDashboard1)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlChatbotLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtFieldChatBot)
                    .addComponent(btnSubmitChatBot, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        tabbedPane.addTab("Chatbot", pnlChatbot);

        btnDashboard2.setText("Dashboard");
        btnDashboard2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDashboard2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlVisualizationLayout = new javax.swing.GroupLayout(pnlVisualization);
        pnlVisualization.setLayout(pnlVisualizationLayout);
        pnlVisualizationLayout.setHorizontalGroup(
            pnlVisualizationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlVisualizationLayout.createSequentialGroup()
                .addContainerGap(690, Short.MAX_VALUE)
                .addComponent(btnDashboard2)
                .addGap(53, 53, 53))
        );
        pnlVisualizationLayout.setVerticalGroup(
            pnlVisualizationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlVisualizationLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btnDashboard2)
                .addContainerGap(531, Short.MAX_VALUE))
        );

        tabbedPane.addTab("Visualization", pnlVisualization);

        btnDashboard3.setText("Dashboard");
        btnDashboard3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDashboard3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlCreditsLayout = new javax.swing.GroupLayout(pnlCredits);
        pnlCredits.setLayout(pnlCreditsLayout);
        pnlCreditsLayout.setHorizontalGroup(
            pnlCreditsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCreditsLayout.createSequentialGroup()
                .addContainerGap(708, Short.MAX_VALUE)
                .addComponent(btnDashboard3)
                .addGap(35, 35, 35))
        );
        pnlCreditsLayout.setVerticalGroup(
            pnlCreditsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCreditsLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btnDashboard3)
                .addContainerGap(531, Short.MAX_VALUE))
        );

        tabbedPane.addTab("Credits", pnlCredits);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabbedPane)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedPane, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

        private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
                // TODO add your handling code here:
		//input validation
		if(loginAttempt != 3){
			if (txtUsername.getText().trim().isEmpty())
			{
				//message box (required input)
				msgAlert("Username is required",JOptionPane.WARNING_MESSAGE, "Missing Input" );
				txtUsername.requestFocusInWindow();
				
			}
			else if (txtPassword.getText().trim().isEmpty())
			{
				//message box (required input)
				msgAlert("Password is required",JOptionPane.WARNING_MESSAGE, "Missing Input" );
				txtPassword.requestFocusInWindow();
			}
			else
			{
				User user = userMap.get(txtUsername.getText().trim());
				if(user == null)
				{
					loginAttempt++;
					msgAlert("Incorrect username or password.\n"
						+ "No. of Attempts: " + loginAttempt + "/3" ,JOptionPane.WARNING_MESSAGE, "Login Failed" );
				}
				else if (user.getPassword().equals(txtPassword.getText()))
				{	
					currentUser = user.getUsername();
					msgAlert("Welcome, " + user.getUsername() + "!\n You have succesfully logged in. "
						,JOptionPane.INFORMATION_MESSAGE, 
						"Dashboard Access Granted" );
					//admin
					if(user.isAdmin()){
						//access to Quiz, Chatbot, Visualization, Credits	
						//set Details
						lblWelcome.setText("Welcome " + user.getUsername() + ".");
						createPanelPage("Dashboard", pnlAdminDashboard);
					}
					//user
					else
					{
						//access to Quiz, Chatbot, Credits	
						//set Details
						lblWelcome1.setText("Welcome " + user.getUsername() + ".");
						createPanelPage("Dashboard", pnlUserDashboard);
					}

					//clear fields
					loginAttempt = 0;
					txtUsername.setText("");
					txtPassword.setText("");
				}
				else
				{
					msgAlert("Incorrect username or password.",JOptionPane.WARNING_MESSAGE, "Login Failed" );
				}
			}
		}
		else
		{
			msgAlert("You have reached the maximum number of login attempts.\n"
				+ "The application will now close." ,JOptionPane.WARNING_MESSAGE, "Too Many Attempts" );
			System.exit(0);
			
		}

        }//GEN-LAST:event_btnLoginActionPerformed

        private void btnCreditsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreditsActionPerformed
                // TODO add your handling code here:
		createPanelPage("Credits", pnlCredits);
        }//GEN-LAST:event_btnCreditsActionPerformed

        private void btnVisualizationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVisualizationActionPerformed
                // TODO add your handling code here:
		createPanelPage("Visualization", pnlVisualization);
        }//GEN-LAST:event_btnVisualizationActionPerformed

        private void btnSignUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignUpActionPerformed
                // TODO add your handling code here:
		createPanelPage("Sign Up", pnlSignUp);

		//clear fields
		txtUsername.setText("");
		txtPassword.setText("");
        }//GEN-LAST:event_btnSignUpActionPerformed

        private void btnGuestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuestActionPerformed
                // TODO add your handling code here:
		isGuest = true;
		lblWelcome2.setText("Welcome Guest.");
		createPanelPage("Dashboard", pnlGuestDashboard);

		//clear fields
		txtUsername.setText("");
		txtPassword.setText("");
        }//GEN-LAST:event_btnGuestActionPerformed

        private void btnCredits1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCredits1ActionPerformed
                // TODO add your handling code here:
		createPanelPage("Credits", pnlCredits);
        }//GEN-LAST:event_btnCredits1ActionPerformed

        private void btnCredits2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCredits2ActionPerformed
                // TODO add your handling code here:
		createPanelPage("Credits", pnlCredits);
        }//GEN-LAST:event_btnCredits2ActionPerformed

        private void btnQuizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuizActionPerformed
                // TODO add your handling code here:
		seconds = 120; //(:set)
		setQuestions();
		createPanelPage("Quiz", pnlQuiz);
		startCountdown();
		
        }//GEN-LAST:event_btnQuizActionPerformed

        private void btnQuiz1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuiz1ActionPerformed
                // TODO add your handling code here:
		seconds = 120; //(:set)
		setQuestions();
		createPanelPage("Quiz", pnlQuiz);
		startCountdown();
        }//GEN-LAST:event_btnQuiz1ActionPerformed

        private void btnChatbotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChatbotActionPerformed
                // TODO add your handling code here:
		createPanelPage("Chatbot", pnlChatbot);
        }//GEN-LAST:event_btnChatbotActionPerformed

        private void btnChatbot1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChatbot1ActionPerformed
                // TODO add your handling code here:
		createPanelPage("Chatbot", pnlChatbot);
        }//GEN-LAST:event_btnChatbot1ActionPerformed

        private void btnChatbot2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChatbot2ActionPerformed
                // TODO add your handling code here:
		createPanelPage("Chatbot", pnlChatbot);
        }//GEN-LAST:event_btnChatbot2ActionPerformed

        private void btnBackToLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackToLoginActionPerformed
                // TODO add your handling code here:
                createPanelPage("Login", pnlLogin);

		//clear fields
		txtUsername1.setText("");
		txtPassword1.setText("");
		cbIsAdmin.setSelected(false);

        }//GEN-LAST:event_btnBackToLoginActionPerformed

        private void btnCreateAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateAccountActionPerformed
                // TODO add your handling code here:
                //input validation
                if (txtUsername1.getText().trim().isEmpty())
                {
                        //message box (required input)
                        msgAlert("Username is required",JOptionPane.WARNING_MESSAGE, "Missing Input" );
                        txtUsername1.requestFocusInWindow();

                }
                else if (txtPassword1.getText().trim().isEmpty())
                {
                        //message box (required input)
                        msgAlert("Password is required",JOptionPane.WARNING_MESSAGE, "Missing Input" );
                        txtPassword1.requestFocusInWindow();
                }
		//password validation
                else if (isValidPassword(txtPassword1.getText()))
                {	
			//username,password,isAdmin
			User user = new User(txtUsername1.getText().trim(), txtPassword1.getText());
			if (cbIsAdmin.isSelected()) user.setAdmin();

			if(userMap.containsKey(txtUsername1.getText().trim()))
			{
				msgAlert("Account already exists",JOptionPane.WARNING_MESSAGE, "Duplicatte Entry" );
			}
			else
			{
				userMap.put(txtUsername1.getText().trim(), user);
				msgAlert("Account has been created successfully.",JOptionPane.INFORMATION_MESSAGE, "Account Created" );

				createPanelPage("Login", pnlLogin);

				//clear fields
				txtUsername1.setText("");
				txtPassword1.setText("");
				cbIsAdmin.setSelected(false);
			}
                }
		else
		{
                        msgAlert("Password must be at least 8 characters long and include:\n" 
				+ "- At least one uppercase letter\n" 
				+ "- At least one lowercase letter\n"
				+ "- At least one number",
				JOptionPane.WARNING_MESSAGE,
				"Invalid Password" );
                        txtPassword.requestFocusInWindow();
		}


        }//GEN-LAST:event_btnCreateAccountActionPerformed

        private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
                // TODO add your handling code here:
		String correctAnswer = questions.get(currentQuestionIndex).getCorrectAnswer();
		if(rbOption.isSelected() && rbOption.getText().equals(correctAnswer))
		{
			msgAlert("The selected answer is correct.",JOptionPane.INFORMATION_MESSAGE, "Evaluation Result" );
			questions.get(currentQuestionIndex).setResult("Correct");
			score++;
		}
		else if(rbOption1.isSelected() && rbOption1.getText().equals(correctAnswer))
		{
			msgAlert("The selected answer is correct.",JOptionPane.INFORMATION_MESSAGE, "Evaluation Result" );
			questions.get(currentQuestionIndex).setResult("Correct");
			score++;
		}
		else if(rbOption2.isSelected() && rbOption2.getText().equals(correctAnswer))
		{
			msgAlert("The selected answer is correct.",JOptionPane.INFORMATION_MESSAGE, "Evaluation Result" );
			questions.get(currentQuestionIndex).setResult("Correct");
			score++;
		}
		else if(rbOption3.isSelected() && rbOption3.getText().equals(correctAnswer))
		{
			msgAlert("The selected answer is correct.",JOptionPane.INFORMATION_MESSAGE, "Evaluation Result" );
			questions.get(currentQuestionIndex).setResult("Correct");
			score++;
		}
		else
		{
			msgAlert("The selected answer is incorrect.",JOptionPane.ERROR_MESSAGE , "Evaluation Result" );
			questions.get(currentQuestionIndex).setResult("Incorrect");
		}

		if(currentQuestionIndex < questions.size()-1)
		{
			currentQuestionIndex++;
			groupRadioButton();
			lblQuestion.setText(questions.get(currentQuestionIndex).getQuestion());
			rbOption.setText(questions.get(currentQuestionIndex).getOptions().get(0));
			rbOption1.setText(questions.get(currentQuestionIndex).getOptions().get(1));
			rbOption2.setText(questions.get(currentQuestionIndex).getOptions().get(2));
			rbOption3.setText(questions.get(currentQuestionIndex).getOptions().get(3));
		}
		else
		{
			//clear fields
			User user = userMap.get(currentUser);
			user.setScore(score);

			currentQuestionIndex = 0;
			score=0;
			timer.stop();


			//set Summary
			setSummary();
			//go to next page
			createPanelPage("Summary", pnlSummary);

		}
        }//GEN-LAST:event_btnSubmitActionPerformed

        private void btnRetakeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetakeActionPerformed
                // TODO add your handling code here:
		seconds = 120; //(:set)
		setQuestions();
		createPanelPage("Quiz", pnlQuiz);
		startCountdown();
        }//GEN-LAST:event_btnRetakeActionPerformed

        private void btnProgressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProgressActionPerformed
                // TODO add your handling code here:
		setProgress();
		createPanelPage("Progress", pnlProgress);
        }//GEN-LAST:event_btnProgressActionPerformed

        private void btnRetake1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetake1ActionPerformed
                // TODO add your handling code here:
		seconds = 5; //(:set)
		setQuestions();
		createPanelPage("Quiz", pnlQuiz);
		startCountdown();
        }//GEN-LAST:event_btnRetake1ActionPerformed

        private void btnDashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDashboardActionPerformed
                // TODO add your handling code here:
		User user = userMap.get(currentUser);
		//admin
		if(user.isAdmin()){
			createPanelPage("Dashboard", pnlAdminDashboard);
		}
		//user
		else
		{
			createPanelPage("Dashboard", pnlUserDashboard);
		}
        }//GEN-LAST:event_btnDashboardActionPerformed

        private void btnSummaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSummaryActionPerformed
		setSummary();
		createPanelPage("Summary", pnlSummary);
        }//GEN-LAST:event_btnSummaryActionPerformed

        private void btnDashboard1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDashboard1ActionPerformed
                // TODO add your handling code here:
		User user = userMap.get(currentUser);
		//admin
		if(isGuest){
			createPanelPage("Dashboard", pnlGuestDashboard);
		}
		else if(user.isAdmin()){
			createPanelPage("Dashboard", pnlAdminDashboard);
		}
		//user
		else
		{
			createPanelPage("Dashboard", pnlUserDashboard);
		}
        }//GEN-LAST:event_btnDashboard1ActionPerformed

        private void btnDashboard2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDashboard2ActionPerformed
                // TODO add your handling code here:
		User user = userMap.get(currentUser);
		//admin
		if(user.isAdmin()){
			createPanelPage("Dashboard", pnlAdminDashboard);
		}
		//user
		else
		{
			createPanelPage("Dashboard", pnlUserDashboard);
		}
        }//GEN-LAST:event_btnDashboard2ActionPerformed

        private void btnDashboard3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDashboard3ActionPerformed
                // TODO add your handling code here:
		User user = userMap.get(currentUser);
		//admin
		if(isGuest){
			createPanelPage("Dashboard", pnlGuestDashboard);
		}
		else if(user.isAdmin()){
			createPanelPage("Dashboard", pnlAdminDashboard);
		}
		//user
		else
		{
			createPanelPage("Dashboard", pnlUserDashboard);
		}
        }//GEN-LAST:event_btnDashboard3ActionPerformed

        private void btnLogout2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogout2ActionPerformed
                // TODO add your handling code here:
		msgAlert("You have been logged out successfully.",JOptionPane.INFORMATION_MESSAGE, "Logout" );
		isGuest = false;
		currentUser = "";
		createPanelPage("Login", pnlLogin);
        }//GEN-LAST:event_btnLogout2ActionPerformed

        private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
                // TODO add your handling code here:
		msgAlert("You have been logged out successfully.",JOptionPane.INFORMATION_MESSAGE, "Logout" );
		isGuest = false;
		currentUser = "";
		createPanelPage("Login", pnlLogin);

        }//GEN-LAST:event_btnLogoutActionPerformed

        private void btnLogout1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogout1ActionPerformed
                // TODO add your handling code here:
		msgAlert("You have been logged out successfully.",JOptionPane.INFORMATION_MESSAGE, "Logout" );
		isGuest = false;
		currentUser = "";
		createPanelPage("Login", pnlLogin);
        }//GEN-LAST:event_btnLogout1ActionPerformed

        private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
                // TODO add your handling code here:
        }//GEN-LAST:event_txtPasswordActionPerformed

        private void cbShowPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbShowPasswordActionPerformed
                // TODO add your handling code here:
		if (cbShowPassword.isSelected()) {
			txtPassword.setEchoChar((char)0); // show password
			
	    } else {
		txtPassword.setEchoChar('•'); // hide password
	    }
        }//GEN-LAST:event_cbShowPasswordActionPerformed

        private void cbShowPassword1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbShowPassword1ActionPerformed
                // TODO add your handling code here:
		if (cbShowPassword1.isSelected()) {
			txtPassword1.setEchoChar((char)0); // show password
			
	    } else {
		txtPassword1.setEchoChar('•'); // hide password
	    }
        }//GEN-LAST:event_cbShowPassword1ActionPerformed

    private void txtFieldChatBotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldChatBotActionPerformed

    }//GEN-LAST:event_txtFieldChatBotActionPerformed

    private void btnSubmitChatBotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitChatBotActionPerformed
    String userMsg = txtFieldChatBot.getText().trim();
    
        if (userMsg.isEmpty()) {
            return;
        }
        
    txtAreaChatBot.append("Ikaw: " + userMsg + "\n");
    String botMsg = chatbot.getBotResponse(userMsg);
    txtAreaChatBot.append("OLEG: " + botMsg + "\n\n");
    
    txtFieldChatBot.setText("");
    txtAreaChatBot.setCaretPosition(txtAreaChatBot.getDocument().getLength());  
    }//GEN-LAST:event_btnSubmitChatBotActionPerformed

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
		} catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
			logger.log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(() -> new Frm_Final_project().setVisible(true));
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBackToLogin;
    private javax.swing.JButton btnChatbot;
    private javax.swing.JButton btnChatbot1;
    private javax.swing.JButton btnChatbot2;
    private javax.swing.JButton btnCreateAccount;
    private javax.swing.JButton btnCredits;
    private javax.swing.JButton btnCredits1;
    private javax.swing.JButton btnCredits2;
    private javax.swing.JButton btnDashboard;
    private javax.swing.JButton btnDashboard1;
    private javax.swing.JButton btnDashboard2;
    private javax.swing.JButton btnDashboard3;
    private javax.swing.JButton btnGuest;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnLogout1;
    private javax.swing.JButton btnLogout2;
    private javax.swing.JButton btnProgress;
    private javax.swing.JButton btnQuiz;
    private javax.swing.JButton btnQuiz1;
    private javax.swing.JButton btnRetake;
    private javax.swing.JButton btnRetake1;
    private javax.swing.JButton btnSignUp;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JButton btnSubmitChatBot;
    private javax.swing.JButton btnSummary;
    private javax.swing.JButton btnVisualization;
    private javax.swing.JCheckBox cbIsAdmin;
    private javax.swing.JCheckBox cbShowPassword;
    private javax.swing.JCheckBox cbShowPassword1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblDate1;
    private javax.swing.JLabel lblDate2;
    private javax.swing.JLabel lblQuestion;
    private javax.swing.JLabel lblQuestion1;
    private javax.swing.JLabel lblQuestion10;
    private javax.swing.JLabel lblQuestion11;
    private javax.swing.JLabel lblQuestion12;
    private javax.swing.JLabel lblQuestion13;
    private javax.swing.JLabel lblQuestion14;
    private javax.swing.JLabel lblQuestion15;
    private javax.swing.JLabel lblQuestion16;
    private javax.swing.JLabel lblQuestion17;
    private javax.swing.JLabel lblQuestion2;
    private javax.swing.JLabel lblQuestion3;
    private javax.swing.JLabel lblQuestion4;
    private javax.swing.JLabel lblQuestion5;
    private javax.swing.JLabel lblQuestion6;
    private javax.swing.JLabel lblQuestion7;
    private javax.swing.JLabel lblQuestion8;
    private javax.swing.JLabel lblQuestion9;
    private javax.swing.JLabel lblQuizTimer;
    private javax.swing.JLabel lblRecommendation;
    private javax.swing.JLabel lblRemarks;
    private javax.swing.JLabel lblScore;
    private javax.swing.JLabel lblUser;
    private javax.swing.JLabel lblWelcome;
    private javax.swing.JLabel lblWelcome1;
    private javax.swing.JLabel lblWelcome2;
    private javax.swing.JPanel pnlAdminDashboard;
    private javax.swing.JPanel pnlChatbot;
    private javax.swing.JPanel pnlCredits;
    private javax.swing.JPanel pnlGuestDashboard;
    private javax.swing.JPanel pnlLogin;
    private javax.swing.JPanel pnlProgress;
    private javax.swing.JPanel pnlQuiz;
    private javax.swing.JPanel pnlSignUp;
    private javax.swing.JPanel pnlSummary;
    private javax.swing.JPanel pnlUserDashboard;
    private javax.swing.JPanel pnlVisualization;
    private javax.swing.JRadioButton rbOption;
    private javax.swing.JRadioButton rbOption1;
    private javax.swing.JRadioButton rbOption2;
    private javax.swing.JRadioButton rbOption3;
    private javax.swing.JTabbedPane tabbedPane;
    private javax.swing.JTable tblProgress;
    private javax.swing.JTextArea txtAreaChatBot;
    private javax.swing.JTextField txtFieldChatBot;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JPasswordField txtPassword1;
    private javax.swing.JTextField txtUsername;
    private javax.swing.JTextField txtUsername1;
    // End of variables declaration//GEN-END:variables
}

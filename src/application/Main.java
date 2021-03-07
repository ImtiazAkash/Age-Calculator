package application;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;

import javax.swing.JTextField;

import javax.swing.JButton;
import java.awt.event.ActionListener;

import java.time.LocalDate;
import java.time.Period;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;

public class Main extends JFrame {

	private JPanel Myjpanel;

	private JTextField AgeInYearMonthsAndDays;
	private JTextField showYear;
	private JTextField showmonths;
	private JTextField showdays;

	// Image icon = Toolkit.getDefaultToolkit().getImage("/images/icon.");
	// Myjpanel.setIconImage(icon);
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 664, 481);
		setTitle("Age Calculator");
		
		Myjpanel = new JPanel() {
			public void paintComponent(Graphics g) {
				Image img = Toolkit.getDefaultToolkit().getImage(Main.class.getResource("/image/background.jpg"));
				g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
				
			}
		};
		
		Image icon = Toolkit.getDefaultToolkit().getImage(Main.class.getResource("/image/icon.png"));
		setIconImage(icon);
		setVisible(true); 
		Myjpanel.setBackground(Color.WHITE);
		Myjpanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Myjpanel);
		Myjpanel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Select a Date Range");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBackground(SystemColor.desktop);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(219, 23, 193, 30);
		Myjpanel.add(lblNewLabel);

		JLabel DateFrom = new JLabel("From");
		DateFrom.setFont(new Font("Times New Roman", Font.BOLD, 17));
		DateFrom.setBounds(33, 87, 56, 22);
		Myjpanel.add(DateFrom);

		// here is birth year
		JYearChooser ChooseFromYear = new JYearChooser();
		ChooseFromYear.setBounds(107, 87, 62, 22);
		Myjpanel.add(ChooseFromYear);

		// here is birth month
		JMonthChooser ChooseFromMonths = new JMonthChooser();
		ChooseFromMonths.setBounds(177, 87, 99, 22);
		Myjpanel.add(ChooseFromMonths);

		// here is birth day
		JDayChooser ChooseFromDay = new JDayChooser();
		ChooseFromDay.setBounds(94, 120, 182, 133);
		Myjpanel.add(ChooseFromDay);

		JLabel DateTo = new JLabel("To");
		DateTo.setFont(new Font("Times New Roman", Font.BOLD, 17));
		DateTo.setBounds(327, 87, 48, 22);
		Myjpanel.add(DateTo);

		// here is selected year
		JYearChooser ChooseToYear = new JYearChooser();
		ChooseToYear.setBounds(385, 89, 62, 20);
		Myjpanel.add(ChooseToYear);

		// here is selected month
		JMonthChooser ChooseToMonths = new JMonthChooser();
		ChooseToMonths.setBounds(457, 87, 99, 22);
		Myjpanel.add(ChooseToMonths);

		// here is selected day
		JDayChooser ChooseToDay = new JDayChooser();
		ChooseToDay.setBounds(374, 120, 182, 133);
		Myjpanel.add(ChooseToDay);

		AgeInYearMonthsAndDays = new JTextField();
		AgeInYearMonthsAndDays.setHorizontalAlignment(SwingConstants.CENTER);
		AgeInYearMonthsAndDays.setFont(new Font("Times New Roman", Font.BOLD, 20));
		AgeInYearMonthsAndDays.setText("Age in Year, Months and Days");
		AgeInYearMonthsAndDays.setBounds(95, 332, 415, 30);
		Myjpanel.add(AgeInYearMonthsAndDays);
		AgeInYearMonthsAndDays.setColumns(10);

		showYear = new JTextField();
		showYear.setHorizontalAlignment(SwingConstants.CENTER);
		showYear.setBounds(94, 373, 63, 30);
		Myjpanel.add(showYear);
		showYear.setColumns(10);

		JLabel showyearlbl = new JLabel("Years");
		showyearlbl.setFont(new Font("Times New Roman", Font.BOLD, 17));
		showyearlbl.setBounds(167, 373, 56, 30);
		Myjpanel.add(showyearlbl);

		JLabel showmonthslbl = new JLabel("Months");
		showmonthslbl.setFont(new Font("Times New Roman", Font.BOLD, 17));
		showmonthslbl.setBounds(306, 373, 62, 30);
		Myjpanel.add(showmonthslbl);

		showmonths = new JTextField();
		showmonths.setHorizontalAlignment(SwingConstants.CENTER);
		showmonths.setBounds(233, 373, 63, 30);
		Myjpanel.add(showmonths);
		showmonths.setColumns(10);

		showdays = new JTextField();
		showdays.setHorizontalAlignment(SwingConstants.CENTER);
		showdays.setBounds(374, 373, 63, 30);
		Myjpanel.add(showdays);
		showdays.setColumns(10);

		JLabel showdayslbl = new JLabel("Days");
		showdayslbl.setFont(new Font("Times New Roman", Font.BOLD, 17));
		showdayslbl.setBounds(447, 373, 56, 30);
		Myjpanel.add(showdayslbl);

		JButton CalculateBtn = new JButton("Calculate");
		CalculateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// birthday portion
				int birthyear = ChooseFromYear.getYear();
				int birthmonth = ChooseFromMonths.getMonth();
				int birthday = ChooseFromDay.getDay();

				LocalDate BIRTHDAY = LocalDate.of(birthyear, birthmonth + 1, birthday);

				// selected day portion
				int selectedyear = ChooseToYear.getYear();
				int selectedmonth = ChooseToMonths.getMonth();
				int selectedday = ChooseToDay.getDay();

				LocalDate SELECTED_DAY = LocalDate.of(selectedyear, selectedmonth + 1, selectedday);
				Period Age = Period.between(BIRTHDAY, SELECTED_DAY);
				String Years = String.valueOf(Age.getYears());
				String Months = String.valueOf(Age.getMonths());
				String Days = String.valueOf(Age.getDays());

				showYear.setText(Years);
				showmonths.setText(Months);
				showdays.setText(Days);

			}
		});
		CalculateBtn.setBounds(272, 291, 123, 30);
		Myjpanel.add(CalculateBtn);

	}
}

package GUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.SystemColor;



/**
 * 
 * @author Jo�o Figueiredo
 * 
 * The purpose of this class is to create the panel that will make you choose your excel file,
 * as well as get his location so it can be opened and read.
 * Enabling the other frames.
 *
 */
public class GUIexcelPage extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	@SuppressWarnings("unused")
	private GUIprojectPresentation frame;

	/**
	 * Create the panel 
	 */
	public GUIexcelPage( GUIprojectPresentation frame) {
		setBackground(new Color(240, 248, 255));
		this.frame = frame;
		setBounds(100, 100, 600, 500);
		JButton btnNewButton = new JButton("Next");
		btnNewButton.setBackground(SystemColor.control);
		btnNewButton.setBounds(341, 339, 164, 61);
		btnNewButton.setFont(new Font("Dubai", Font.BOLD, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().equals("")) {
					String[] options = {"Ok, proceed anyway", "Cancel"};
			        int optionChosen = JOptionPane.showOptionDialog(null, "You didnt choose an excel file!",
			                "Excel file not chosen",
			                JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
			        if(optionChosen==0) {
			        	frame.swapToMenu();	
						frame.setExcelPath(textField.getText());
			        }
			        
				}else {
					frame.swapToMenu();	
					frame.setExcelPath(textField.getText());
				}
				

			}
		});
		setLayout(null);
		add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Search file");
		btnNewButton_1.setBackground(new Color(248, 248, 255));
		btnNewButton_1.setBounds(432, 179, 129, 61);
		btnNewButton_1.setFont(new Font("Dubai", Font.BOLD, 18));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("xls", "xlsx", "xlsm", "xlsb");
				chooser.setFileFilter(filter);
				int returnVal = chooser.showOpenDialog(null);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					textField.setText(chooser.getSelectedFile().getAbsolutePath());

				}
			}
		});

		textField = new JTextField();
		textField.setBounds(52, 179, 370, 61);
		add(textField);
		textField.setColumns(20);
		add(btnNewButton_1);

		JLabel lblNewLabel = new JLabel("Path of the file:");
		lblNewLabel.setBounds(54, 135, 209, 21);
		lblNewLabel.setFont(new Font("Dubai", Font.PLAIN, 22));
		add(lblNewLabel);

		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(439, 19, 1, 1);
		add(layeredPane);

		JLabel lblFirst = new JLabel("First,choose your excel file.");
		lblFirst.setBounds(52, 43, 422, 52);
		lblFirst.setFont(new Font("Dubai", Font.BOLD, 34));
		add(lblFirst);

		
		
		JButton btnOpenExcelPage = new JButton("Open Excel Page");
		btnOpenExcelPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"Please select your excel file before clicking here.","ALERT MESSAGE",JOptionPane.WARNING_MESSAGE);
				}else {
					 try {
					     Desktop desktop = Desktop.getDesktop();
					     File myFile = new File(textField.getText());
					     desktop.open(myFile);
					     } catch (IOException ex) {}
			
			}
			}
			});
		btnOpenExcelPage.setBackground(SystemColor.control);
		btnOpenExcelPage.setFont(new Font("Dubai", Font.BOLD, 18));
		btnOpenExcelPage.setBounds(86, 339, 164, 61);
		add(btnOpenExcelPage);

	}
}

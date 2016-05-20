package royalsovereign.label.carton.mclane;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

<<<<<<< HEAD
import royalsovereign.label.carton.mclane.McLaneLabelCode;

public class McLaneLabelGUI extends JFrame implements ActionListener{
	JPanel panel;
	JLabel label;
	JTextField textfield;
	JButton buttonCarton, buttonPallet;
	McLaneLabelCode code;
	
	public McLaneLabelGUI(){
		super("McLane Label Printing");
		code = new McLaneLabelCode();
		initComponents();
		setSize(200, 150);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        setVisible(true);
	}
	
	public void initComponents(){
		add(createGUI());
		pack();
	}
	
	private JPanel createGUI(){
		panel = new JPanel();
		label = new JLabel("Enter Sales Order #");
		textfield = new JTextField();
		buttonCarton = new JButton("Print Carton Label");
		buttonPallet = new JButton("Print Pallet Label");
		
		
		textfield.addActionListener(this);
		buttonCarton.addActionListener(this);
		buttonPallet.addActionListener(this);
		
		GroupLayout layout = new GroupLayout(panel);
		panel.setLayout(layout);
		layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        
        layout.setHorizontalGroup(layout.createSequentialGroup()
        		.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(label,GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textfield,GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonCarton,GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonPallet,GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
		layout.setVerticalGroup(layout.createSequentialGroup()
		           .addComponent(label)
		           .addComponent(textfield)
		           .addComponent(buttonCarton)
		           .addComponent(buttonPallet)
			);
		
		return panel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("Print Carton Label")){
			String soNum = textfield.getText();
			soNum = new McLaneLabelCode().formatSO(soNum);
			if (soNum.equals("")){
				JOptionPane.showMessageDialog(panel, "Please enter Sales Order Number");
			} else{
				System.out.println("Print Carton Label");
				JOptionPane.showMessageDialog(panel, new McLaneLabelCode().printCartonLabel(soNum));

			}
			textfield.setText("");
		} else if (e.getActionCommand().equals("Print Pallet Label")){
			String soNum = textfield.getText();
			soNum = new McLaneLabelCode().formatSO(soNum);
			if (soNum.equals("")){
				JOptionPane.showMessageDialog(panel, "Please enter Sales Order Number");
			} else{
				System.out.println("Print Pallet Label");
				JOptionPane.showMessageDialog(panel, new McLaneLabelCode().printPalletLabel(soNum));

			}
			textfield.setText("");
		} 
=======
import royalsovereign.label.carton.mclane.McLaneCartonLabelCode;

public class McLaneLabelGUI extends JFrame implements ActionListener{
	JPanel panel;
	JLabel label;
	JTextField textfield;
	JButton buttonCarton, buttonPallet;
	McLaneCartonLabelCode code;
	
	public McLaneLabelGUI(){
		super("McLane Label Printing");
		code = new McLaneCartonLabelCode();
		initComponents();
		setSize(200, 125);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        setVisible(true);
	}
	
	public void initComponents(){
		add(createGUI());
		pack();
	}
	
	private JPanel createGUI(){
		panel = new JPanel();
		label = new JLabel("Enter Sales Order #");
		textfield = new JTextField();
		buttonCarton = new JButton("Print Carton Label");
		buttonPallet = new JButton("Print Pallet Label");
		
		
		textfield.addActionListener(this);
		buttonCarton.addActionListener(this);
		buttonPallet.addActionListener(this);
		
		GroupLayout layout = new GroupLayout(panel);
		panel.setLayout(layout);
		layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        
        layout.setHorizontalGroup(layout.createSequentialGroup()
        		.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(label,GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textfield,GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonCarton,GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonPallet,GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
		layout.setVerticalGroup(layout.createSequentialGroup()
		           .addComponent(label)
		           .addComponent(textfield)
		           .addComponent(buttonCarton)
		           .addComponent(buttonPallet)
			);
		
		return panel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("Print Carton Label")){
			String soNum = textfield.getText();
			soNum = new McLaneCartonLabelCode().formatSO(soNum);
			if (soNum.equals("")){
				JOptionPane.showMessageDialog(panel, "Please enter Sales Order Number");
			} else{
				System.out.println("Print Carton Label");
				JOptionPane.showMessageDialog(panel, new McLaneCartonLabelCode().printLabel(soNum));

			}
			textfield.setText("");
		} else if (e.getActionCommand().equals("Print Pallet Label")){
			String soNum = textfield.getText();
			soNum = new McLaneCartonLabelCode().formatSO(soNum);
			if (soNum.equals("")){
				JOptionPane.showMessageDialog(panel, "Please enter Sales Order Number");
			} else{
				System.out.println("Print Carton Label");
				JOptionPane.showMessageDialog(panel, new McLaneCartonLabelCode().printLabel(soNum));

			}
			textfield.setText("");
		} else if(e.getSource()==textfield){
			String soNum = textfield.getText();
			soNum = new McLaneCartonLabelCode().formatSO(soNum);
			if (soNum.equals("")){
				JOptionPane.showMessageDialog(panel, "Please enter Sales Order Number");
			} else{
				System.out.println("Print Carton Label");
				JOptionPane.showMessageDialog(panel, new McLaneCartonLabelCode().printLabel(soNum));

			}
			textfield.setText("");
		}
>>>>>>> refs/remotes/RSLabel/Hubert
	}
}

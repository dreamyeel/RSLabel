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

import royalsovereign.label.carton.mclane.McLaneCartonLabelCode;

public class McLaneCartonLabelGUI extends JFrame implements ActionListener{
	JPanel panel;
	JLabel label;
	JTextField textfield;
	JButton button;
	McLaneCartonLabelCode code;
	
	public McLaneCartonLabelGUI(){
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
		button = new JButton("Print Carton Label");
		
		textfield.addActionListener(this);
		button.addActionListener(this);
		
		GroupLayout layout = new GroupLayout(panel);
		panel.setLayout(layout);
		layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        
        layout.setHorizontalGroup(layout.createSequentialGroup()
        		.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(label,GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textfield,GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button,GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
		layout.setVerticalGroup(layout.createSequentialGroup()
		           .addComponent(label)
		           .addComponent(textfield)
		           .addComponent(button)
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
	}
}

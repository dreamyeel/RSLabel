package royalsovereign.label.menu;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import royalsovereign.label.carton.mclane.McLaneLabelGUI;
import royalsovereign.label.carton.sams.SamsCartonLabelGUI;
import royalsovereign.label.ucc.ingram.IngramUccLabelPrintingFrame;
import royalsovereign.label.ucc.scholastic.ScholasticLabelPrintingFrame;


public class menuGUI extends javax.swing.JFrame implements ActionListener{

	JPanel menuPanel, samsCartonLabelPanel, ingramUccLabelPanel;
	JButton printSamsCartonLabel, printIngramUccLabel, printScholasticUccLabel, printMcLaneCartonLabel;

	public menuGUI() {
		super("Royal Sovereign Label Printing");
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		// setSize(new Dimension(400, 600));
		setLocationRelativeTo(null);
		initComponents();
		setVisible(true);
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
	}

	private void initComponents(){
		menuPanel = new JPanel();
		
		printSamsCartonLabel = new JButton("Click here to print Sams/Wal-mart carton label");
		printIngramUccLabel = new JButton("Click here to print Ingram UCC label");
		printScholasticUccLabel = new JButton("Click here to print Scholastic UCC Label");
		printMcLaneCartonLabel = new JButton("Click here to print McLane label");
		
		printSamsCartonLabel.addActionListener(this);
		printIngramUccLabel.addActionListener(this);
		printScholasticUccLabel.addActionListener(this);
		printMcLaneCartonLabel.addActionListener(this);
		
		GroupLayout layout = new GroupLayout(menuPanel);
		menuPanel.setLayout(layout);
		layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        
        layout.setHorizontalGroup(layout.createSequentialGroup()
        		.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(printSamsCartonLabel,GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(printMcLaneCartonLabel,GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(printIngramUccLabel,GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(printScholasticUccLabel,GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
		layout.setVerticalGroup(layout.createSequentialGroup()
		           .addComponent(printSamsCartonLabel)
		           .addComponent(printMcLaneCartonLabel)
		           .addComponent(printIngramUccLabel)
		           .addComponent(printScholasticUccLabel)
			);
		//menuPanel.add(printSamsCartonLabel);
		//menuPanel.add(printIngramUccLabel);
		//menuPanel.add(printScholasticUccLabel);
		add(menuPanel);
		pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("Click here to print Sams/Wal-mart carton label")){
			System.out.println("Click here to print Sams/Wal-mart carton label");
			SamsCartonLabelGUI newFrame = new SamsCartonLabelGUI();
			
			//getContentPane().removeAll();
			//samsCartonLabelPanel = new SamsCartonLabelGUI().createGUI();
			//add(samsCartonLabelPanel);
			//pack();
			
		}else if(e.getActionCommand().equals("Click here to print Ingram UCC label")){
			System.out.println("Click here to print Ingram UCC label");
			//getContentPane().removeAll();
			IngramUccLabelPrintingFrame newFrame = new IngramUccLabelPrintingFrame();
			//ingramUccLabelPanel = new IngramUccLabelGUI().createGUI();
			//add(ingramUccLabelPanel);
			//pack();
			
		}else if(e.getActionCommand().equals("Click here to print Scholastic UCC Label")){
			System.out.println("Click here to print Scholastic UCC Label");
			//getContentPane().removeAll();
			ScholasticLabelPrintingFrame newFrame = new ScholasticLabelPrintingFrame();
			//ingramUccLabelPanel = new IngramUccLabelGUI().createGUI();
			//add(ingramUccLabelPanel);
			//pack();
		}else if(e.getActionCommand().equals("Click here to print McLane label")){
			System.out.println("Click here to print McLane carton label");
			//getContentPane().removeAll();
			McLaneLabelGUI newFrame = new McLaneLabelGUI();
			//ingramUccLabelPanel = new IngramUccLabelGUI().createGUI();
			//add(ingramUccLabelPanel);
			//pack();
		}
	}
}

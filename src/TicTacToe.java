import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class TicTacToe 
{
	JFrame frame=new JFrame("Tic Tac Toe"); 
	JPanel[] pa=new JPanel[3]; 
	JLabel msg=new JLabel("First player turn...");
	JButton[] bt=new JButton[9];
	JButton reset=new JButton("RESET");
	//code to load both images
	ImageIcon icon1=new ImageIcon(getClass().getResource("images/user1.png"));
	ImageIcon icon2=new ImageIcon(getClass().getResource("images/user2.png"));
	int player=1;
	public TicTacToe()
	{
		frame.setSize(500,630);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(3);
		frame.getContentPane().setBackground(Color.black);
		frame.setLayout(null);
		addPanels();
		frame.setVisible(true);
	}
	private void addPanels()
	{
		for(int i=0;i<3;i++)
		{
			pa[i]=new JPanel();
			frame.add(pa[i]);
		}
		pa[0].setBounds(50,30,400,40);
		pa[1].setBounds(50,100,400,400);
		pa[2].setBounds(50,530,400,40);
		addMessageLabel();
	}
	private void addMessageLabel()
	{
		pa[0].add(msg);
		msg.setFont(new Font("elephant",0,30));
		msg.setForeground(Color.blue);
		pa[0].setBackground(Color.cyan);
		addButtons();
	}
	private void addButtons()
	{
		pa[1].setLayout(new GridLayout(3,3));
		TicListener listener=new TicListener();
		for(int i=0;i<9;i++)
		{
			bt[i]=new JButton();
			bt[i].addActionListener(listener);
			pa[1].add(bt[i]);
			bt[i].setBackground(Color.yellow);
		}
		addResetButton();
	}
	private void addResetButton()
	{
		pa[2].add(reset);
		reset.setFont(new Font("arial",1,18));
		pa[2].setOpaque(false);
	}
	//creating listener for 9 buttons
	class TicListener implements ActionListener
	{
		//Overriding method of ActionListener interface 
		public void actionPerformed(ActionEvent evt) 
		{
			//Code to get reference of button that would be clicked by user
			JButton source=(JButton)evt.getSource();
			//Checking whether button has image or not
			//getIcon() method will return null when button has no image
			if(source.getIcon()!=null)
			{
				//showMessageDialog() method will create and display an alert box
				JOptionPane.showMessageDialog(frame,"Button already has an image");
				return;//It will terminate execution of current method
			}
			//Code to set image on the button that would be clicked by user
			if(player==1)
			{
				source.setIcon(icon1);
				msg.setText("Second player turn...");
				player=2;
			}
			else if(player==2)
			{
				source.setIcon(icon2);
				msg.setText("First player turn...");
				player=1;
			}
		}		
	}
	public static void main(String[] args) 
	{
		new TicTacToe();
	}
}

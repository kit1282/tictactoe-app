import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class TicTacToe2 
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
	boolean winnerFound=false;
	public TicTacToe2()
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
			//Checking game over
			if(winnerFound)
			{
				JOptionPane.showMessageDialog(frame,"Game is already over and winner announced");
				return;
			}
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
			findWinner();
		}//end of actionPerformed method
		private void findWinner()
		{
			//Code to check same image in all rows.columns and diagonal one by one
			//First row
			if(bt[0].getIcon()==icon1 && bt[1].getIcon()==icon1 && bt[2].getIcon()==icon1)
				announceWinner(0,1,2);
			else if(bt[0].getIcon()==icon2 && bt[1].getIcon()==icon2 && bt[2].getIcon()==icon2)
				announceWinner(0,1,2);
			//Second row
			else if(bt[3].getIcon()==icon1 && bt[4].getIcon()==icon1 && bt[5].getIcon()==icon1)
				announceWinner(3,4,5);
			else if(bt[3].getIcon()==icon2 && bt[4].getIcon()==icon2 && bt[5].getIcon()==icon2)
				announceWinner(3,4,5);
			//Third row
			else if(bt[6].getIcon()==icon1 && bt[7].getIcon()==icon1 && bt[8].getIcon()==icon1)
				announceWinner(6,7,8);
			else if(bt[6].getIcon()==icon2 && bt[7].getIcon()==icon2 && bt[8].getIcon()==icon2)
				announceWinner(6,7,8);
			//First column
			else if(bt[0].getIcon()==icon1 && bt[3].getIcon()==icon1 && bt[6].getIcon()==icon1)
				announceWinner(0,3,6);
			else if(bt[0].getIcon()==icon2 && bt[3].getIcon()==icon2 && bt[6].getIcon()==icon2)
				announceWinner(0,3,6);
			//Second column
			else if(bt[1].getIcon()==icon1 && bt[4].getIcon()==icon1 && bt[7].getIcon()==icon1)
				announceWinner(1,4,7);
			else if(bt[1].getIcon()==icon2 && bt[4].getIcon()==icon2 && bt[7].getIcon()==icon2)
				announceWinner(1,4,7);
			//Third column
			else if(bt[2].getIcon()==icon1 && bt[5].getIcon()==icon1 && bt[8].getIcon()==icon1)
				announceWinner(2,5,8);
			else if(bt[2].getIcon()==icon2 && bt[5].getIcon()==icon2 && bt[8].getIcon()==icon2)
				announceWinner(2,5,8);
			//First diagonal
			else if(bt[0].getIcon()==icon1 && bt[4].getIcon()==icon1 && bt[8].getIcon()==icon1)
				announceWinner(0,4,8);
			else if(bt[0].getIcon()==icon2 && bt[4].getIcon()==icon2 && bt[8].getIcon()==icon2)
				announceWinner(0,4,8);
			//Second diagonal
			else if(bt[2].getIcon()==icon1 && bt[4].getIcon()==icon1 && bt[6].getIcon()==icon1)
				announceWinner(2,4,6);
			else if(bt[2].getIcon()==icon2 && bt[4].getIcon()==icon2 && bt[6].getIcon()==icon2)
				announceWinner(2,4,6);
		}//end of findWinner() method
		private void announceWinner(int i,int j,int k)
		{
			winnerFound=true;
			msg.setText("GAME OVER...");
			msg.setForeground(Color.white);
			pa[0].setBackground(Color.red);
			bt[i].setBackground(Color.green);
			bt[j].setBackground(Color.green);
			bt[k].setBackground(Color.green);
			if(player==2)
				JOptionPane.showMessageDialog(frame,"First player has won");
			else if(player==1)
				JOptionPane.showMessageDialog(frame,"Second player has won");
		}
	}
	public static void main(String[] args) 
	{
		new TicTacToe2();
	}
}

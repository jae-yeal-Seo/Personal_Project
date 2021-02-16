import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class YourAlarcityPanel extends JPanel implements ActionListener,KeyListener{
	private Random ran = new Random();
	private JLabel label = new JLabel();
	private JLabel[] labels = {new JLabel("기초형"),new JLabel("참조형"),new JLabel("인터페이스"),new JLabel("람다식"),new JLabel("패키지"), 
			new JLabel("정적 메소드"),new JLabel("메소드"),new JLabel("클래스"),new JLabel("반복문"),new JLabel("조건문"),
			new JLabel("디폴트 메소드"),new JLabel("캡슐화"),new JLabel("자바"),new JLabel("프로그래밍"),new JLabel("상속"),
			new JLabel("접근제어자"),new JLabel("설정제어자"),new JLabel("부모 클래스"),new JLabel("자식클래스"),new JLabel("추상화"),
			new JLabel("생성자"),new JLabel("동적메소드"),new JLabel("그래픽 사용자 인터페이스"),new JLabel("배열"),new JLabel("ArrayList")
			,new JLabel("래그드배열"),new JLabel("객체"),new JLabel("필드"),new JLabel("객체 지향 프로그래밍"),new JLabel("히프 메모리")
			,new JLabel("쓰레기 수집"),new JLabel("자바 가상기계"),new JLabel("이클립스"),new JLabel("메소드 오버로딩"),new JLabel("메소드 오버라이딩")
			,new JLabel("생성자 오버로딩"),new JLabel("내부 클래스"),new JLabel("다형성"),new JLabel("라디오 버튼"),new JLabel("텍스트 필드")
			,new JLabel("콤보 박스"),new JLabel("슬라이더"),new JLabel("디버깅"),new JLabel("단언"),new JLabel("로깅")
			,new JLabel("문자 스트림"),new JLabel("동기화"),new JLabel("멀티스레딩"),new JLabel("와일드카드"),new JLabel("제네릭")
	};
	private JButton button;
	private int[] check = new int[50];
	private JTextField tf = new JTextField();
	private Timer exit = new Timer();
	private Timer second = new Timer();
	private int counter=0;
	private JLabel result;
	private int totalScore=0;
	private JLabel plusnews;
	
	private BufferedImage img = null;
	


	YourAlarcityPanel() {


		for(int i=0;i<50;i++) {
			check[i]=0;	
		}

		
		button = new JButton("버튼을 누르면 시작합니다.");
		button.setFont(new Font("",Font.BOLD,20));
		setLayout(null);
		button.setBounds(230,230,400,60);
		button.setBackground(Color.black);
		button.setForeground(Color.white);
		add(button);
		button.addActionListener(this);
		

	}
//	시작 화면 설정



	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button) {
			
			if(e.getSource()==button) {
				button.setVisible(false);
				label.setText("문자들을 빨리 치세요! 20초 드립니다!");
				label.setFont(new Font("",Font.BOLD,20));
				label.setBounds(260,0,360,25);
				label.setBackground(Color.red);
				label.setOpaque(true);
				add(label);
				

				int rannum=0;

				for(int i=0;i<30;i++) {
					while(true){
						
						rannum = ran.nextInt(50);
						if(check[rannum]==0) {
							check[rannum]=1;
							break;
						}
					}
					this.updateUI();
					int x = (int)(Math.random()*720);
					int y = (int)(Math.random()*600+25);

					labels[rannum].setBounds(x,y,150,15);
					add(labels[rannum]);
				
				}
				add(tf);
				tf.setBackground(Color.black);
				tf.setOpaque(true);
				tf.setBounds(230,630,400,28);
				tf.setForeground(Color.white);
				tf.addKeyListener(this);
				
				TimerTask work = new TimerTask() {
					@Override
					public void run() {
						
						label.setVisible(false);
						tf.setVisible(false);
						for(int i=0;i<50;i++) {
							labels[i].setVisible(false);
						}
						result = new JLabel(counter+"개를 맞추셨습니다!("+counter*100+"점)");
						plusnews = new JLabel("5초 뒤에 새로운 게임을 시작합니다!");
						totalScore = counter*100;
						result.setFont(new Font("",Font.BOLD,30));
						plusnews.setFont(new Font("",Font.BOLD,30));
						add(result);
						add(plusnews);
						result.setBounds(220,220,800,50);
						plusnews.setBounds(150,280,800,50);
						setVisible(true);
					}
					
				};
				exit.schedule(work,20000);
				
				TimerTask secondWork = new TimerTask() {
					public void run() {
					SecondGame();
					}
				};
				second.schedule(secondWork, 25000);
			}
			
		}
	}
//	첫번째 게임

	void SecondGame() {
		result.setVisible(false);
		plusnews.setVisible(false);
		label = new JLabel("최대한 많은 점을 클릭하세요! 10초 드립니다!");
		label.setFont(new Font("",Font.BOLD,20));
		label.setBounds(200,0,425,30);
		label.setBackground(Color.red);
		label.setOpaque(true);
		add(label);
		repaint();
		
	}
	@Override
	protected void paintComponent(Graphics g) {
		int x = (int)(Math.random()*800);
		int y = (int)(Math.random()*700);
		g.fillOval(x, y, 30, 30);
		g.setColor(Color.blue);
	}
//	두번째 게임
	
//	그림그리기

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_ENTER) {
			int i=0;
			while(true) {
				if(labels[i].getText().equals(tf.getText())) {
					labels[i].setVisible(false);
					tf.setText("");
					counter++;
					break;
				}
				i++;
			}
			
		}
	}
//	Enter를 눌렀을 때의 반응
	@Override
	public void keyTyped(KeyEvent e) {}
	@Override
	public void keyReleased(KeyEvent e) {}
	
}

public class YourAlarcity extends JFrame{
	public YourAlarcity() {
		add(new YourAlarcityPanel());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(900,700);
		setVisible(true);
		
	}
	public static void main(String[] args) {
		new YourAlarcity();
	}
}
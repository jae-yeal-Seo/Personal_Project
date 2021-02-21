package ch05_2.oop;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Your_Alarcity extends JFrame implements KeyListener,ActionListener,MouseListener{
	private JPanel p1,p2,p3;
	private CardLayout cards;
	private Timer exit = new Timer();
//	공통적으로 필요한 필드
	private JButton button1;
	private Random ran = new Random();
	private int[] check = new int[50];
	private int counter= 0;
	private JLabel label;
	private JTextField tf;
	private JLabel result;
	private JLabel plusnews;
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
//	첫번째 게임, 게임 결과를 위한 필드
	private JLabel[] labels2 = {new JLabel("O"),new JLabel("O"),new JLabel("O"),new JLabel("O"),new JLabel("O"),
			new JLabel("O"),new JLabel("O"),new JLabel("O"),new JLabel("O"),new JLabel("O"),
			new JLabel("O"),new JLabel("O"),new JLabel("O"),new JLabel("O"),new JLabel("O"),
			new JLabel("O"),new JLabel("O"),new JLabel("O"),new JLabel("O"),new JLabel("O"),
			new JLabel("O"),new JLabel("O"),new JLabel("O"),new JLabel("O"),new JLabel("O"),
			new JLabel("O"),new JLabel("O"),new JLabel("O"),new JLabel("O"),new JLabel("O"),
	};
	private int counter2 = 0;
	private int totalScore=0;
	private JButton button2;
	private JLabel label2;
//	두번째 게임, 게임 결과를 위한 필드
	
	Your_Alarcity(){
		cards = new CardLayout();
		setLayout(cards);
//		전체세팅
		button1 = new JButton("버튼을 클릭하면 시작합니다.");
		button1.setFont(new Font("",Font.BOLD,20));
		button1.setBackground(Color.black);
		button1.setForeground(Color.white);
		button1.setBounds(80,200,600,60);
		button1.addActionListener(this);
		p1 = new JPanel();
		p1.setLayout(null);
		p1.add(button1);
		add(p1);
//		첫번째 장면
		for(int i=0;i<50;i++) {
			check[i]=0;
		}
		p2 = new JPanel();
		p2.setLayout(null);
		label = new JLabel("문자들을 빨리 치세요! 20초 드립니다!");
		label.setFont(new Font("",Font.BOLD,20));
		label.setBounds(230,0,360,25);
		label.setBackground(Color.red);
		label.setOpaque(true);
		p2.add(label);
		int rannum = 0;
		for(int i=0;i<30;i++) {
			while(true){
				rannum = ran.nextInt(50);
				if(check[rannum]==0) {
					check[rannum]=1;
					break;
				}
			}
			int x = (int)(Math.random()*680);
			int y = (int)(Math.random()*450+25);

			labels[rannum].setBounds(x,y,150,15);
			p2.add(labels[rannum]);
		}
		tf = new JTextField();
		tf.setBounds(140,530,500,25);
		tf.setBackground(Color.black);
		tf.setForeground(Color.white);
		tf.addKeyListener(this);
		p2.add(tf);
		add(p2);
//		두번째 장면
		TimerTask work = new TimerTask() {
			@Override
			public void run() {
				label.setVisible(false);
				tf.setVisible(false);
				for(int i=0;i<50;i++) {
					labels[i].setVisible(false);
				}
				result = new JLabel(counter+"개를 맞추셨습니다!("+counter*100+"점)");
				plusnews = new JLabel("버튼을 누르면 새로운 게임을 시작합니다");
				totalScore = counter*100;
				result.setFont(new Font("",Font.BOLD,30));
				plusnews.setFont(new Font("",Font.BOLD,30));
				p2.add(result);
				p2.add(plusnews);
				result.setBounds(200,190,800,50);
				plusnews.setBounds(120,250,800,50);
				button2.setFont(new Font("",Font.BOLD,25));
				button2.setBounds(190,320,400,50);
			}
		};
		exit.schedule(work,20000);
		button2 = new JButton("다음 게임을 시작합니다.");
		button2.addActionListener(this);
		p2.add(button2);
//		세번째 장면
		p3 = new JPanel();
		p3.setLayout(null);
		label2 = new JLabel("점을 빠르게 클릭하세요! 10초 드립니다!");
		label2.setFont(new Font("",Font.BOLD,20));
		label2.setBackground(Color.red);
		label2.setOpaque(true);
		label2.setForeground(Color.white);
		label2.setBounds(200,0,370,20);
		p3.add(label2);
		add(p3);
		for(int i=0;i<30;i++) {
			int x = (int) (Math.random()*800);
			int y = (int) (Math.random()*450+100);
			labels2[i].setBounds(x,y,20,20);
			p3.add(labels2[i]);
			labels2[i].addMouseListener(this);
		}
//		네번째 장면
		setSize(800,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				System.exit(0);
			}
		});
		
	}
	public static void main(String[] args) {
		new Your_Alarcity();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button1) {
			cards.next(Your_Alarcity.this.getContentPane());
		}
		else if(e.getSource()==button2) {
			cards.next(Your_Alarcity.this.getContentPane());
			TimerTask fourthGameEnd = new TimerTask() {
				@Override
				public void run() {
					for(int i=0;i<30;i++) {
						label2.setVisible(false);
						labels2[i].setVisible(false);
					}
					label = new JLabel("두번째 게임의 점수는"+counter2*100+"점입니다!");
					label.setFont(new Font("",Font.BOLD,40));
					label.setBounds(70,220,800,40);
					label2 = new JLabel("총점"+(counter*100+counter2*100)+"점!");
					label2.setFont(new Font("",Font.BOLD,40));
					label2.setBounds(280,260,800,40);
					p3.add(label);
					p3.add(label2);
				}
			};
			exit.schedule(fourthGameEnd, 10000);
		}
	}
//	button1 -> 첫번째 게임 시작을 위한 버튼  
//	button2 -> 두번째 게임, 결과까지 실행


	
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
//	VK_ENTER -> 타자 입력 완료 했을 때
	@Override
	public void keyTyped(KeyEvent e) {}
	@Override
	public void keyReleased(KeyEvent e) {}
//	KeyListener의 메소드들
	@Override
	public void mouseClicked(MouseEvent e) {}
	@Override
	public void mousePressed(MouseEvent e) {
		for(int i=0;i<50;i++) {
			if(e.getSource()==labels2[i]) {
				counter2++;
				labels2[i].setVisible(false);
			}
		}
	}
//	글자 ㅇ 클릭했을 때
	@Override
	public void mouseReleased(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
//	MouseListener의 메소드들
}
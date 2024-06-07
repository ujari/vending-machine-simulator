package detail_frame;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

//purchase history 파일을 보여주는 클래스
public class SalesCheck extends JFrame{
    public SalesCheck()
    {
        this.setTitle("판매 내역");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocation(300, 50);
        this.setSize(500, 600);
        this.setLayout(new BorderLayout(20,20));
        //크기 변경 불가
        this.setResizable(false);
        //상단바
        topBar();
        //판매 내역
        Show();
        this.setVisible(true);
    }

    //상단바
    void topBar() {
        JPanel topBar = new JPanel();
        topBar.setPreferredSize(new Dimension(800, 50));
        JLabel label = new JLabel("판매 내역");
        label.setFont(new Font("Serif", Font.BOLD, 30));
        topBar.add(label);
        topBar.setBackground(Color.white);
        this.add(topBar, BorderLayout.NORTH);
    }

    //판매 내역
    void Show(){
        JPanel showSales = new JPanel();
        showSales.setLayout(new GridLayout(0,1,10,10));
        showSales.add(showSales());
        showSales.add(totalSales());

        this.add(showSales, BorderLayout.CENTER);
    }
    
    //purchase history파일을 읽어 보여주는 메소드
    public JPanel showSales()
    {
        JPanel showSales = new JPanel();
        showSales.setLayout(new FlowLayout());
        JLabel label = new JLabel("판매 내역");
        label.setFont(new Font("Serif", Font.BOLD, 20));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        showSales.add(label);
        
        JTextArea textArea = new JTextArea(10, 30);
        textArea.setFont(new Font("Serif", Font.BOLD, 15));
        textArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER); // Disable horizontal scrollbar
        showSales.add(scrollPane);


        //파일 읽기
        try {
            BufferedReader reader = new BufferedReader(new FileReader("purchase_history.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                textArea.append(line + "\n");
            }
            reader.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return showSales;
    }

    //total파일을 읽어 보여주는 메소드
    public JPanel totalSales()
    {
        JPanel showSales = new JPanel();
        showSales.setLayout(new FlowLayout());
        JLabel label = new JLabel("총 매출");
        label.setFont(new Font("Serif", Font.BOLD, 20));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        showSales.add(label);
        
        JTextArea textArea = new JTextArea(10, 30);
        textArea.setFont(new Font("Serif", Font.BOLD, 15));
        textArea.setEditable(false);


        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER); 
        showSales.add(scrollPane);

        //파일 읽기
        try {
            BufferedReader reader = new BufferedReader(new FileReader("total.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                textArea.append(line + "\n");
            }
            reader.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return showSales;
    }

}

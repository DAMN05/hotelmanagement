package hotel.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public  class HotelManagementSystem extends JFrame implements ActionListener{ 


HotelManagementSystem(){
   setSize(1000,565);// otro metodo para definir el tamaño de la ventana
    setLocation(100,100);//define ubicacion
    //setBounds(1,100,1300,565);// define los 2 
    setLayout(null);
    
    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
    JLabel image = new JLabel(i1);
    image.setBounds(0, 0,1366,565);
    add (image);
    
    JLabel text = new JLabel("HOTEL LOS MANIACOS");
    text.setBounds(20,430,1000,90);
    text.setForeground(Color.WHITE);
    text.setFont(new Font("serif",Font.PLAIN,50));
    image.add(text);
    
    
    JButton next = new JButton ("NEXT");
    next.setBounds(1150,450,150,50);
    next.setBackground(Color.BLACK);
    next.setForeground(Color.WHITE);
    next.addActionListener(this);
    next.setFont(new Font("serif",Font.PLAIN,20));
    image.add(next);
    
    setVisible(true);
    
    Timer timer = new Timer(500, e -> text.setVisible(!text.isVisible()));
timer.start();

}
public void actionPerformed(ActionEvent ae){
    setVisible(false);
    new Login(); 
    
}
public static void main(String[] args) {

new HotelManagementSystem();


}

}

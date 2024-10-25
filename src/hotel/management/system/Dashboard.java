package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener {
   Dashboard() {
       setBounds(0, 0, 1550, 750);
       setLayout(null);
       
       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
       Image i2 = i1.getImage().getScaledInstance(1550, 1000, Image.SCALE_DEFAULT);
       ImageIcon i3 = new ImageIcon(i2);
       JLabel image = new JLabel(i3);
       image.setBounds(0, 0, 1550, 1000);
       add(image);

       JLabel text = new JLabel("LOS MANIACOS LOS SALUDAN");
       text.setBounds(400, 80, 1000, 50);
       text.setFont(new Font("Tahoma", Font.PLAIN, 46));
       text.setForeground(Color.WHITE);
       image.add(text);

       JMenuBar mb = new JMenuBar();
       mb.setBounds(0, 0, 1550, 30);
       image.add(mb);

       JMenu hotel = new JMenu("MANEJO DE HOTEL");
       hotel.setForeground(Color.RED);
       mb.add(hotel);

       
       JMenuItem recepcion = new JMenuItem("RECEPCION");
       recepcion.addActionListener(this);
       hotel.add(recepcion);

       JMenu admin = new JMenu("ADMIN");
       admin.setForeground(Color.BLUE);
       mb.add(admin);

       JMenuItem ag_emple = new JMenuItem("AGREGAR EMPLEADO");
       ag_emple.addActionListener(this);
       admin.add(ag_emple);

       JMenuItem ag_hab = new JMenuItem("AGREGAR HABITACION");
       ag_hab.addActionListener(this);
       admin.add(ag_hab);

       JMenuItem ag_cond = new JMenuItem("AGREGAR CONDUCTOR");
       ag_cond.addActionListener(this);
       admin.add(ag_cond);

       setVisible(true);
   }

   public void actionPerformed(ActionEvent ae) {
       System.out.println("Evento detectado: " + ae.getActionCommand());

       if (ae.getActionCommand().equals("AGREGAR EMPLEADO")) {
           new AddEmployee();
       } else if (ae.getActionCommand().equals("AGREGAR HABITACION")) {
           new AddRooms();
       } else if (ae.getActionCommand().equals("AGREGAR CONDUCTOR")) {
           new AddDriver();
       } else if (ae.getActionCommand().equals("RECEPCION")) {
           new Reception();
       }
   }

   public static void main(String[] args) {
       new Dashboard();
   }
}

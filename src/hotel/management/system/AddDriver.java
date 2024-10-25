
package hotel.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class AddDriver extends JFrame implements ActionListener{
    
    JButton add, cancel;
    JTextField tfname,tfcompany,tfage,tfmodelo,tfubi;
    JComboBox dispocombo,generocombo;
    
    
    AddDriver(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("AGREGAR CONDUCTOR");
        heading.setFont(new Font("Tahoma",Font.BOLD,18));
        heading.setBounds(150,10,300,20);
        add(heading);
        
        
        JLabel lblrooms = new JLabel("NOMBRE");
        lblrooms.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblrooms.setBounds(60,70,320,30);
        add(lblrooms);
        
        
        tfname = new JTextField();
        tfname.setBounds(280, 80, 150, 30);
        add(tfname);
        
        
        JLabel lbledad = new JLabel("EDAD ");
        lbledad.setFont(new Font("Tahoma",Font.PLAIN,16));
        lbledad.setBounds(60,130,320,30);
        add(lbledad);
        
        
        tfage = new JTextField();
        tfage.setBounds(280, 130, 150, 30);
        add(tfage);
        
        
        JLabel lblclean = new JLabel("  GENERO ");
        lblclean.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblclean.setBounds(60,170,320,30);
        add(lblclean);
        
        
        String genOptions[]= {"MASCULINO","FEMENINO"};
        generocombo = new JComboBox (genOptions);
        generocombo.setBounds(280,170,150,30);
        generocombo.setBackground(Color.WHITE);
        add(generocombo);
        
        
        JLabel lblprice = new JLabel(" COMPAÑIA DE AUTOMOVILES ");
        lblprice.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblprice.setBounds(60,210,320,30);
        add(lblprice);
        
        
        tfcompany = new JTextField();
        tfcompany.setBounds(280, 210, 150, 30);
        add(tfcompany);
        
        
        JLabel lbltype = new JLabel("MODELO DE AUTO");
        lbltype.setFont(new Font("Tahoma",Font.PLAIN,16));
        lbltype.setBounds(60,250,320,30);
        add(lbltype);
        
        tfmodelo = new JTextField();
        tfmodelo.setBounds(280, 250, 150, 30);
        add(tfmodelo);
        
        JLabel lbldispo = new JLabel("DISPONIBLE  ");
        lbldispo.setFont(new Font("Tahoma",Font.PLAIN,16));
        lbldispo.setBounds(60,290,320,30);
        add(lbldispo);
        
        String driverOptions[]= {"DISPONIBLE","OCUPADO"};
        dispocombo = new JComboBox (driverOptions);
        dispocombo.setBounds(280,290,150,30);
        dispocombo.setBackground(Color.WHITE);
        add(dispocombo);
        
        
        
        JLabel lblubi = new JLabel("UBICACION");
        lblubi.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblubi.setBounds(60,330,320,30);
        add(lblubi);
        
        tfubi = new JTextField();
        tfubi.setBounds(280, 330, 150, 30);
        add(tfubi);
        
        add = new JButton ("AGREGAR CONDUCTOR");
        add.setForeground(Color.WHITE);
        add.setBackground(Color.BLACK);
        add.setBounds(60,370,130,30);
        add.addActionListener(this);
        add(add);
        
        
        cancel = new JButton ("CANCEL");
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.setBounds(220,370,130,30);
        cancel.addActionListener(this);
        add(cancel);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
        Image i2= i1.getImage().getScaledInstance(450, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 =new ImageIcon(i2);
        
        JLabel image = new JLabel(i3);
        image.setBounds(400,30,500,300);
        add(image);
        
        setBounds(300,200,980,470);
        setVisible(true);
        
    }
    
    
    
    public void actionPerformed(ActionEvent ae){
         if(ae.getSource()==add){
             String nombre = tfname.getText();
             String edad = tfage.getText(); 
             String genero = (String)generocombo.getSelectedItem();
             String compa =  tfcompany.getText();
             String marca = tfmodelo.getText();
             String dispo = (String)dispocombo.getSelectedItem();
             String ubic = tfubi.getText();
             
             try{
                 Conn conn = new Conn();
                 String str = "insert into driver values('"+nombre+"','"+edad+"','"+genero+"','"+compa+"','"+marca+"','"+dispo+"','"+ubic+"')";
                 conn.s.executeUpdate(str);
                 
                 JOptionPane.showMessageDialog(null, "NUEVO CONDUCTOR AÑADIDO EXITOSAMENTE");
                 
                 setVisible(false);
             } catch (Exception e){
                    e.printStackTrace();
             }
             
             
             
         }else{
             setVisible(false);
         }
         
    }
            
         
    public static void main(String[]args){
        new AddDriver();
    }
}

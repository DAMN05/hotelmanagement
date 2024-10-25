
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;



public class Department extends JFrame implements ActionListener{
    JTable table;
    JButton back;
    
    Department(){
        
        
        getContentPane().setBackground(Color.WHITE);// contenedor de la pestaña
        setLayout(null);// metodo para que el frame no esete separado en casillas ni columnas
        
        // creamos un label para   saber que trata el dato
        JLabel l1 = new JLabel (" SERVICIO ");
        l1.setBounds(180,10,100,20);//posicionamos el elemento
        add(l1);// añadimos el elemento
        
        
        
        // creamos un label para   saber que trata el dato
        JLabel l2 = new JLabel ("PRESUPUESTO ");
        l2.setBounds(420,10,100,20);//posicionamos el elemento
        add(l2);//añadimos el elemento a la ventana
        
       // creamos un elemento tipo table  vacio para insertar los datos de la base de datos
        table = new JTable();
        table.setBounds(0,50,700,350);// posicionamos el elemento en la ventana
        add(table);// añadimos el elemento a la ventana
        
        
        try{
            Conn c = new Conn();//iniciamos la conexion a la base de datos
            ResultSet rs  = c.s.executeQuery("select * from department");//ejecutamos la orden de tipo sql " seleccionamos todos los datos de department(hace referencia a los sericios que se ofrece)
            table.setModel(DbUtils.resultSetToTableModel(rs));//metemos los datos de la orden sql  a la tabla vacia que habiamos creado
        
        }catch (Exception e){
            e.printStackTrace();// muestra errores en consola
        }
        
        
        
        // creamos un boton
        back = new JButton("Volver");
        back.setBackground(Color.BLACK);// colocamos el color del boton     
        back.setForeground(Color.WHITE);// colocamos el color de la letra del boton
        back.addActionListener(this);// añadimos el listener al boton para darle funcionalidad 
        back.setBounds(280,400,120,30);// posicionamos el boton
        add(back);// añadimos el boton a la ventana
        
        
        setBounds(400,100,700,480);//coordenadas y tamaño de la pestaña principal
        setVisible(true);//ventana siempre visible
    
    }
    
    public void actionPerformed(ActionEvent ae){// funcion del boton de volver
        setVisible(false);// ocultamos la ventana
        new Reception();// redireccion a la recepcion
    
    }
    
    
    
    public static void main(String[]args){
        new Department();
    }
}

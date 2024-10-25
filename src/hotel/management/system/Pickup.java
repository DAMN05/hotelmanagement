
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;



public class Pickup extends JFrame implements ActionListener{
    JTable table;
    JButton back,enviar;
    Choice tipocarro;
    
    
    
    Pickup(){
        
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        // Titulo inicial de la ventana a lo que se hace referencia en la pestaña creada
        JLabel text = new JLabel ("Servicio de Recoleccion ");
        text.setFont(new Font("Tahoma", Font.PLAIN,20));// aqui definimos y especificamos lo de la fuente desde la fuente que yo coloque tahoma pero podria ser arial, despues coloque el Font.PLAIN para que esta fuente sea asi normalita sin estilos adicionales ni negrita ni cursiva ni nada y por ultimo ya el tamaño
        text.setBounds(400,30,250,30);//usamos el setBounds para tamaño y posicion del elemento
        add(text);// añadimos a la ventana
        
        JLabel lblcama = new JLabel ("Tipo de Carro");// creamos un label para saber a que nos referimos
        lblcama.setBounds(50,100,100,20);// posicionamos el label en la ventana
        add(lblcama);// añadimos el label a la ventana
        
        tipocarro =new Choice();// añadimos un desplegable para los tipos de carros que ya tenemos en la base de datos
        tipocarro.setBounds(150,100,200,25);// posicionamos el elemento
        add(tipocarro);// lo añadimos a la ventana
        
        try{
        
           Conn c= new Conn();// hacemos la conexion con la base de datos
           ResultSet rs = c.s.executeQuery("select * from driver");// ejecutamos la orden sql en la base de datos que especificamente es" seleccionar todo de driver(conductor)"
           while (rs.next()){// aqui  nos movemos en la base de datos teniendo en cuenta  la orden que ejecutamos anteriormente
               tipocarro.add(rs.getString("marca"));// teniendo en cuenta  que pedimos los datos de la  marca(columna)
           
           }
             
            
        }catch(Exception e){
            e.printStackTrace();// nos muestra si hay algun error con la base de datos
        
        
        }
        
        
        
      
        
        
        
        
        JLabel l1 = new JLabel ("Nombre");// creamos un label para identificar los datos
        l1.setBounds(30,160,100,20);// posicionamos el label con las coordenadas y el tamaño con el metodo setBounds
        add(l1);// añadimos a la ventana
        
        
        JLabel l2 = new JLabel ("Edad ");// creamos un label para identificar los datos
        l2.setBounds(200,160,100,20);// posicionamos el label con las coordenadas y el tamaño con el metodo setBounds
        add(l2);// añadimos a la ventana
        
        
        JLabel l3 = new JLabel ("Genero");// creamos un label para identificar los datos
        l3.setBounds(330,160,100,20);// posicionamos el label con las coordenadas y el tamaño con el metodo setBounds
        add(l3);// añadimos a la ventana
        
        JLabel l4 = new JLabel ("Compañia");// creamos un label para identificar los datos
        l4.setBounds(460,160,100,20);// posicionamos el label con las coordenadas y el tamaño con el metodo setBounds
        add(l4);// añadimos a la ventana
        
        JLabel l5 = new JLabel ("Marca");// creamos un label para identificar los datos
        l5.setBounds(630,160,100,20);// posicionamos el label con las coordenadas y el tamaño con el metodo setBounds
        add(l5);// añadimos a la ventana
        
        JLabel l6 = new JLabel ("Disponibilidad");// creamos un label para identificar los datos
        l6.setBounds(740,160,100,20);// posicionamos el label con las coordenadas y el tamaño con el metodo setBounds
        add(l6);// añadimos a la ventana
        
        
        JLabel l7 = new JLabel ("Ubicacion");// creamos un label para identificar los datos
        l7.setBounds(890,160,100,20);// posicionamos el label con las coordenadas y el tamaño con el metodo setBounds
        add(l7);// añadimos a la ventana
        
        
        table = new JTable();// creamos una tabla
        table.setBounds(0,200,1000,300);// posicionamos la tabla
        add(table);//añadimos la tabla a la ventana
        
        
        try{
            Conn c = new Conn();// conectamos con la base de datos
            ResultSet rs  = c.s.executeQuery("select * from driver");//damos una orden sql que explicitamente pedimos" seleccionar todo de driver(conductor)
            table.setModel(DbUtils.resultSetToTableModel(rs));// metemos los datos de la tabla driver de la base de datos a la tabla que creamos anteriormente
        
        }catch (Exception e){
            e.printStackTrace();// una excepcion y revision de errores 
        }
        
        
        // creamos un boton para consultar los datos que queramos 
        enviar = new JButton("Consultar");
        enviar.setBackground(Color.BLACK);// le damos un color al fondo del boton
        enviar.setForeground(Color.WHITE);// colocamos la letra del color que queramos
        enviar.addActionListener(this);// añadimos un listener al boton para darle funcionalidad 
        enviar.setBounds(300,520,120,30);// posicionamos el boton  con el metodo setBounds que es mas comodo por que nos permite (x,y, ancho,alto)
        add(enviar);// añadimos a la ventana
        
        
        // creamos un boton para consultar los datos que queramos 
        back = new JButton("Volver");
        back.setBackground(Color.BLACK);// le damos un color al fondo del boton
        back.setForeground(Color.WHITE);// colocamos la letra del color que queramos
        back.addActionListener(this);// añadimos un listener al boton para darle funcionalidad 
        back.setBounds(500,520,120,30);// posicionamos el boton  con el metodo setBounds que es mas comodo por que nos permite (x,y, ancho,alto)
        add(back);// añadimos a la ventana
        
        
        setBounds(100,100,1050,600);// asignamos coordenadas y tamaños a la ventana principal sobre la que estan todos los elementos agregados anteriormente
        setVisible(true);// siempre visible para usarla
    
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== enviar){// creamos un condicional para cuando se pulse el boton
            try{
                String query = "select * from driver  where marca = '"+tipocarro.getSelectedItem()+"'";// creamos una orden sql que dice" seleccionar todo de driver(tabla) de la fila que haga referencia el tipocarro"--- masfacil  de verlo es que la columna es marca y cuando tipocarro sea tal en esa columna se ejecuta toda la fila para poder ver todos los demas datos  que corresponden a ese tipocarro 
                
                Conn conn = new Conn();// realizamos la conexion
                ResultSet rs;
                rs = conn.s.executeQuery(query);// ejecutamos la orden que le dimos anteriormente 
                table.setModel(DbUtils.resultSetToTableModel(rs));// actualizamos la tabla y mostramos solo los datos que coinciden con la consulta que hicimos
            }catch(Exception e){
                e.printStackTrace();// excepcion para  posibles errores
            }
            
        }else{// con esto es para el boton de volver
        
            setVisible(false);// ocultamos la ventana 
            new Reception();// vamos a la ventana de recepcion por el llamado
        }
    }
    
    
    
    public static void main(String[]args){
        new Pickup();
    }
}

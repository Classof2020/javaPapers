import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.sql.rowset.*;

class ResultSetDemo implements ActionListener
{
  JLabel l1,l2,l3;
  JPanel p1,p2;
  JTextField t1,t2,t3;
  JButton b1,b2,b3,b4,b5;
  ResultSet rs;
  CachedRowSet crs;

  ResultSetDemo()
  {
    JFrame frame=new JFrame();
    frame.setLayout(new BorderLayout());
    l1=new JLabel("Id");
    t1=new JTextField();
    l2=new JLabel("Name");
    t2=new JTextField();
    l3=new JLabel("Address");
    t3=new JTextField();
    
    p1=new JPanel();
    p1.setLayout(new GridLayout(3,2));
    p1.add(l1);
    p1.add(t1);
    p1.add(l2);
    p1.add(t2);
    p1.add(l3);
    p1.add(t3);
    
    frame.add(p1,BorderLayout.CENTER);
    
    b1=new JButton("Show");
    b2=new JButton("First");
    b3=new JButton("Next");
    b4=new JButton("Previous");
    b5=new JButton("Last");
    
    p2=new JPanel();
    p2.setLayout(new FlowLayout());
    p2.add(b1);
    p2.add(b2);
    p2.add(b3);
    p2.add(b4);
    p2.add(b5);
    
    frame.add(p2,BorderLayout.SOUTH);
    
    b1.addActionListener(this);
    b2.addActionListener(this);
    b3.addActionListener(this);
    b4.addActionListener(this);
    b5.addActionListener(this);
    frame.setVisible(true);
    frame.pack();
  }
  public static void main(String args[])
  {
    new ResultSetDemo();
  }
  public void actionPerformed(ActionEvent e)
  {
    if(e.getSource()==b1)
    {
      try
      {
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        Connection con=DriverManager.getConnection("jdbc:odbc:mydatasource","sa","orchid");
        String sql="select * from tbltest";
        Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
        rs=st.executeQuery(sql);
        crs=new com.sun.rowset.CachedRowSetImpl();
        crs.populate(rs);
        
        if(crs.next())
        {
          t1.setText(crs.getString(1).trim());
          t2.setText(crs.getString(2).trim());
          t3.setText(crs.getString(3).trim());
      }
        con.close();
      }
      catch(Exception e1)
      {
        System.out.println(e1);
      }
    }
    else if(e.getSource()==b2)
    {
      try{
        if(crs.first())
        {
           t1.setText(crs.getString(1).trim());
          t2.setText(crs.getString(2).trim());
          t3.setText(crs.getString(3).trim());
        }
      }
      catch(Exception e1)
      {
        System.out.println(e1);
      }
    }
     else if(e.getSource()==b3)
    {
      try{
        if(crs.next())
        {
           t1.setText(crs.getString(1).trim());
          t2.setText(crs.getString(2).trim());
          t3.setText(crs.getString(3).trim());
        }
      }
      catch(Exception e1)
      {
        System.out.println(e1);
      }
    }
      else if(e.getSource()==b4)
    {
      try{
        if(crs.previous())
        {
           t1.setText(crs.getString(1).trim());
          t2.setText(crs.getString(2).trim());
          t3.setText(crs.getString(3).trim());
        }
      }
      catch(Exception e1)
      {
        System.out.println(e1);
      }
    }
       else if(e.getSource()==b5)
    {
      try{
        if(crs.last())
        {
        //  String newAddress="Bkt";
        //  rs.updateString("Address",newAddress);//update result set
         // rs.updateRow();//reflect changes in database
         
          t1.setText(crs.getString(1).trim());
          t2.setText(crs.getString(2).trim());
          t3.setText(crs.getString(3).trim());
          // t1.setText(crs.getString(1).trim());
          //t2.setText(crs.getString(2).trim());
          //t3.setText(crs.getString(3).trim());
        }
      }
      catch(Exception e1)
      {
        System.out.println(e1);
      }
    }
  }
}
    
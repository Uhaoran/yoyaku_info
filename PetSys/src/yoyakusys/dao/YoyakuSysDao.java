/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yoyakusys.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import yoyakusys.entity.YoyakuSysEntity;

/**
 *
 * @author WU HAORAN
 */
public class YoyakuSysDao {

    Connection conn = null;
    Statement stmt = null;
    ResultSet rset = null;

    final String url = "jdbc:postgresql://localhost:5432/hr";
    final String user = "postgres";
    final String password = "postgres";

    public void createYoyakuSys(YoyakuSysEntity entity) {
    try {
            conn = DriverManager.getConnection(url, user, password);
            stmt = conn.createStatement();

           String sql="INSERT INTO Yoyaku_list (userid,pettype,course,checkin,times,def_flag)\n"
                   + "VALUES('"+entity.getUserid()+"','"+entity.getPettype()+"','"+entity.getCourse()+"','"+entity.getCheckin()+"','"+entity.getTimes()+"','"+0+"')";
           
            System.out.println(sql);
            stmt.executeUpdate(sql);

            stmt.close();
            conn.close();

        } catch (Exception ex) {
            Logger.getLogger(YoyakuSysDao.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deleteYoyakuSys(YoyakuSysEntity entity){
        try {
            conn = DriverManager.getConnection(url, user, password);
            stmt = conn.createStatement();

           String sql="UPDATE Yoyaku_list\n"
                   +"SET def_flag='"+1+"';";
                  
           
            System.out.println(sql);
            stmt.executeUpdate(sql);

            stmt.close();
            conn.close();

        } catch (Exception ex) {
            Logger.getLogger(YoyakuSysDao.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petsys.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import petsys.entity.YoyakuSysEntity;

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

            String sql = "INSERT INTO Yoyaku_list (userid,pettype,course,checkin,times,def_flag)\n"
                    + "VALUES('" + entity.getUserid() + "','" + entity.getPettype() + "','" + entity.getCourse() + "','" + entity.getCheckin() + "','" + entity.getTimes() + "','" + 0 + "')";

            System.out.println(sql);
            stmt.executeUpdate(sql);

            stmt.close();
            conn.close();

        } catch (Exception ex) {
            Logger.getLogger(YoyakuSysDao.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteYoyakuSys(YoyakuSysEntity entity) {
        try {
            conn = DriverManager.getConnection(url, user, password);
            stmt = conn.createStatement();

            String sql = "UPDATE Yoyaku_list\n"
                    + "SET def_flag='" + 1 + "';";

            System.out.println(sql);
            stmt.executeUpdate(sql);

            stmt.close();
            conn.close();

        } catch (Exception ex) {
            Logger.getLogger(YoyakuSysDao.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List<YoyakuSysEntity> selectYoyakuSys() {
        List<YoyakuSysEntity> list = new ArrayList<>();
        try {

            conn = DriverManager.getConnection(url, user, password);

            stmt = conn.createStatement();

            String sql = "SELECT* FROM Yoyaku_list where def_flag='0';";
            rset = stmt.executeQuery(sql);

            if (rset != null) {

                while (rset.next()) {

                    YoyakuSysEntity entity = new YoyakuSysEntity();

                    entity.setUserid(rset.getString(1));
                    entity.setPettype(rset.getString(2));
                    entity.setCourse(rset.getString(3));
                    entity.setCheckin(rset.getString(4));
                    entity.setTimes(rset.getString(5));

                    list.add(entity);
                }

            }

            rset.close();
            stmt.close();
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(PetSysDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;

    }

}

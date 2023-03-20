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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import petsys.entity.CustermSysEntity;

/**
 *
 * @author WU HAORAN
 */
public class CustermInfoDao {

    Connection conn = null;
    Statement stmt = null;
    ResultSet rset = null;

    final String url = "jdbc:postgresql://localhost:5432/hr";
    final String user = "postgres";
    final String password = "postgres";

    /**
     * 新規作成
     *
     * @param entity
     */
    public void createCusterm(CustermSysEntity entity) {

        try {
            conn = DriverManager.getConnection(url, user, password);
            stmt = conn.createStatement();

            LocalDateTime createDateTime = LocalDateTime.now();

            LocalDateTime updateDateTime = createDateTime.plusYears(1);

            String sql = "INSERT "
                    + "INTO user_info1( "
                    + "    user_id "
                    + "    , password "
                    + "    , name "
                    + "    , sex "
                    + "    , born "
                    + "    , address "
                    + "    , tel "
                    + "    , email "
                    + "    , del_flag "
                    + "    , create_date "
                    + "    , update_date "
                    + ") "
                    + "VALUES ( "
                    + "    '" + entity.getUserid() + "' "
                    + "    , '" + entity.getPassword() + "' "
                    + "    , '" + entity.getName() + "' "
                    + "    , '" + entity.getSex() + "' "
                    + "    , '" + entity.getBorn() + "' "
                    + "    ,'" + entity.getAddress() + "' "
                    + "    ,'" + entity.getTel() + "' "
                    + "    ,'" + entity.getEmail() + " ' "
                    + "    ,'" + 0 + "' "
                    + "    ,'" + createDateTime + "' "
                    + "    ,'" + updateDateTime + "'); ";

            System.out.println(sql);
            stmt.executeUpdate(sql);

            stmt.close();
            conn.close();

        } catch (Exception ex) {
            Logger.getLogger(CustermInfoDao.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * お客様情報変更
     *
     * @param entity
     */
    public void changePetSys(CustermSysEntity entity) {
        try {
            conn = DriverManager.getConnection(url, user, password);
            stmt = conn.createStatement();

            String sql = "UPDATE user_info1\n"
                    + "SET userid='" + entity.getUserid() + "',\n"
                    + "userpassword='" + entity.getPassword() + "',\n"
                    + "name='" + entity.getName() + "',\n"
                    + "sex='" + entity.getSex() + "',\n"
                    + "born='" + entity.getBorn() + "',\n"
                    + "address='" + entity.getAddress() + "',\n"
                    + "tel='" + entity.getTel() + "',\n"
                    + "email='" + entity.getEmail() + "',\n";

            stmt.executeUpdate(sql);

            stmt.close();
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(CustermInfoDao.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * 個人情報ページ
     *
     * @param entity
     */
    public void MyPageInfo(CustermSysEntity entity) {

        try {
            conn = DriverManager.getConnection(url, user, password);
            stmt = conn.createStatement();

            String sql = "SELECT\n"
                    + "    custermer_id\n"
                    + "    ,ui.user_id\n"
                    + "    , password\n"
                    + "    , name\n"
                    + "    , sex\n"
                    + "    , born\n"
                    + "    , address\n"
                    + "    , tel\n"
                    + "    , email\n"
                    + "    , create_date\n"
                    + "    , update_date\n"
                    + "    , pet_type\n"
                    + "    , pet_headed\n"
                    + "    , pet_name\n"
                    + "    , pet_born\n"
                    + "    , pet_sex\n"
                    + "    , vaccination_date\n"
                    + "    , rabies_vaccine_date\n"
                    + "    , pet_medical_history\n"
                    + "FROM\n"
                    + "    user_info1 AS ui \n"
                    + "    INNER JOIN pet_info1 AS pi \n"
                    + "        ON ui.user_id = pi.user_id ";

            System.out.println(sql);
            stmt.executeQuery(sql);

            stmt.close();
            conn.close();

        } catch (Exception ex) {
            Logger.getLogger(CustermInfoDao.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * ログイン
     *
     * @param entity
     */
    public void loginPetSys(CustermSysEntity entity) {
        List<CustermSysEntity> list = new ArrayList<>();
        try {
            conn = DriverManager.getConnection(url, user, password);
            stmt = conn.createStatement();

            String sql = "SELECT userid,userpassword From user_info1 WHERE user_id ='" + entity.getUserid() + "' AND password='" + entity.getPassword() + "' ";

            rset = stmt.executeQuery(sql);
            if (rset != null) {

                while (rset.next()) {

                    entity.setCustermnumber(rset.getInt(1));
                    entity.setUserid(rset.getString(2));
                    entity.setPassword(rset.getString(3));
                    entity.setName(rset.getString(4));
                    entity.setSex(rset.getString(5));
                    entity.setBorn(rset.getString(6));
                    entity.setAddress(rset.getString(7));
                    entity.setTel(rset.getString(8));
                    entity.setEmail(rset.getString(9));

                    entity.setCreationdate(rset.getString(10));
                    entity.setUpdatingdate(rset.getString(11));
                    list.add(entity);
                }

            }

            rset.close();
            stmt.close();
            conn.close();

        } catch (Exception ex) {
            Logger.getLogger(CustermInfoDao.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * 全件検索、条件検査
     *
     * @return
     */
    public List<CustermSysEntity> selectAllPetSys() {

        List<CustermSysEntity> list = new ArrayList<>();

        try {

            conn = DriverManager.getConnection(url, user, password);

            stmt = conn.createStatement();

            String sql = "SELECT* FROM user_info1 where del_flag='0';";
            rset = stmt.executeQuery(sql);

            if (rset != null) {

                while (rset.next()) {

                    CustermSysEntity entity = new CustermSysEntity();

                    entity.setCustermnumber(rset.getInt(1));
                    entity.setUserid(rset.getString(2));
                    entity.setPassword(rset.getString(3));
                    entity.setName(rset.getString(4));
                    entity.setSex(rset.getString(5));
                    entity.setBorn(rset.getString(6));
                    entity.setAddress(rset.getString(7));
                    entity.setTel(rset.getString(8));
                    entity.setEmail(rset.getString(9));

                    entity.setCreationdate(rset.getString(10));
                    entity.setUpdatingdate(rset.getString(11));
                    list.add(entity);
                }

            }

            rset.close();
            stmt.close();
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(CustermInfoDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;

    }

}

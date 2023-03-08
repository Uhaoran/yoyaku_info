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
import petsys.entity.CustermSysEntity;

/**
 *
 * @author WU HAORAN
 */
public class CustermSysDao {

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
    public void createPetSys(CustermSysEntity entity) {

        try {
            conn = DriverManager.getConnection(url, user, password);
            stmt = conn.createStatement();

            String sql = "INSERT "
                    + "INTO custerm_info( "
                    + "    userid "
                    + "    , userpassword "
                    + "    , name "
                    + "    , sex "
                    + "    , born "
                    + "    , address "
                    + "    , tel "
                    + "    , email "
                    + "    , pettype "
                    + "    , multiheaded "
                    + "    , petname "
                    + "    , petborn "
                    + "    , petsex "
                    + "    , vaccinationdate "
                    + "    , petmedicalhistory "
                    + "    , del_flag "
                    + "    , creationdate "
                    + "    , updatingdate "
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
                    + "    ,'" + entity.getPettype() + "' "
                    + "    ,'" + entity.getMultiheaded() + "' "
                    + "    ,'" + entity.getPetname() + "' "
                    + "    ,'" + entity.getPetborn() + "' "
                    + "    ,'" + entity.getPetsex() + " ' "
                    + "    ,'" + entity.getVaccintiondate() + "' "
                    + "    ,'" + entity.getPetmedicalhistory() + "' "
                    + "    ,'" + 0 + "' "
                    + "    ,'" + entity.getCreationdate() + "' "
                    + "    ,'" + entity.getUpdatingdate() + "'); ";

            System.out.println(sql);
            stmt.executeUpdate(sql);

            stmt.close();
            conn.close();

        } catch (Exception ex) {
            Logger.getLogger(CustermSysDao.class
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

            String sql = "UPDATE custerm_info\n"
                    + "SET userid='" + entity.getUserid() + "',\n"
                    + "userpassword='" + entity.getPassword() + "',\n"
                    + "name='" + entity.getName() + "',\n"
                    + "sex='" + entity.getSex() + "',\n"
                    + "born='" + entity.getBorn() + "',\n"
                    + "address='" + entity.getAddress() + "',\n"
                    + "tel='" + entity.getTel() + "',\n"
                    + "email='" + entity.getEmail() + "',\n"
                    + "pettype='" + entity.getPettype() + "',\n"
                    + "multiheaded='" + entity.getMultiheaded() + "',\n"
                    + "petname='" + entity.getPetname() + "',\n"
                    + "petborn='" + entity.getPetborn() + "',\n"
                    + "petsex='" + entity.getPetsex() + "',\n"
                    + "vaccinationdate='" + entity.getVaccintiondate() + "',\n"
                    + "petmedicalhistory='" + entity.getPetmedicalhistory() + "';";
            stmt.executeUpdate(sql);

            stmt.close();
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(CustermSysDao.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * ログイン
     *
     * @param entity
     */
    public void loginPetSys(CustermSysEntity entity) {
        try {
            conn = DriverManager.getConnection(url, user, password);
            stmt = conn.createStatement();

            String sql = "SELECT userid,userpassword From custerm_info WHERE userid ='" + entity.getUserid() + "','" + entity.getPassword() + "' ";

            System.out.println(sql);
            stmt.executeQuery(sql);

            stmt.close();
            conn.close();

        } catch (Exception ex) {
            Logger.getLogger(CustermSysDao.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }
    /*
     条件検索
     */

    public List<CustermSysEntity> SerchPetSys() {

        List<CustermSysEntity> list = new ArrayList<>();
        CustermSysEntity entity = new CustermSysEntity();
        try {

            conn = DriverManager.getConnection(url, user, password);

            stmt = conn.createStatement();

            String sql = "SELECT*From custerm_info WHERE  userid ='" + entity.getUserid() + "'OR tel='" + entity.getTel() + "' ";
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
                    entity.setPettype(rset.getString(10));
                    entity.setMultiheaded(rset.getString(11));
                    entity.setPetname(rset.getString(12));
                    entity.setPetborn(rset.getString(13));
                    entity.setPetsex(rset.getString(14));
                    entity.setPetmedicalhistory(rset.getString(15));
                    entity.setCreationdate(rset.getString(17));
                    entity.setUpdatingdate(rset.getString(18));
                    list.add(entity);
                }

            }

            rset.close();
            stmt.close();
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(CustermSysDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;

    }

    /**
     * 全件検索
     *
     * @return
     */
    public List<CustermSysEntity> selectAllPetSys() {

        List<CustermSysEntity> list = new ArrayList<>();

        try {

            conn = DriverManager.getConnection(url, user, password);

            stmt = conn.createStatement();

            String sql = "SELECT* FROM custerm_info where del_flag='0';";
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
                    entity.setPettype(rset.getString(10));
                    entity.setMultiheaded(rset.getString(11));
                    entity.setPetname(rset.getString(12));
                    entity.setPetborn(rset.getString(13));
                    entity.setPetsex(rset.getString(14));
                    entity.setPetmedicalhistory(rset.getString(15));
                    entity.setCreationdate(rset.getString(17));
                    entity.setUpdatingdate(rset.getString(18));
                    list.add(entity);
                }

            }

            rset.close();
            stmt.close();
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(CustermSysDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;

    }

}

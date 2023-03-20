/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petsys.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import petsys.entity.PetInfoEntity;

/**
 *
 * @author WU HAORAN
 */
public class PetInfoDao {

    Connection conn = null;
    Statement stmt = null;
    ResultSet rset = null;

    final String url = "jdbc:postgresql://localhost:5432/hr";
    final String user = "postgres";
    final String password = "postgres";

    /**
     * ペット追加
     *
     * @param entity
     */
    public void createPetInfo(PetInfoEntity entity) {

        try {
            conn = DriverManager.getConnection(url, user, password);
            stmt = conn.createStatement();

            String sql = "INSERT "
                    + "INTO pet_info1( "
                    + "    user_id "
                    + "    , pet_type "
                    + "    , pet_headed "
                    + "    , pet_name "
                    + "    , pet_born "
                    + "    , pet_sex "
                    + "    , vaccination_date "
                    + "    , rabies_vaccine_date "
                    + "    , pet_medical_history "
                    + "    , del_flag "
                    + ") "
                    + "SELECT  "
                    + " ui.user_id"
                    + "    , '" + entity.getPet_type() + "' "
                    + "    , '" + entity.getPet_headed() + "' "
                    + "    , '" + entity.getPet_name() + "' "
                    + "    , '" + entity.getPet_born() + "' "
                    + "    ,'" + entity.getPet_sex() + "' "
                    + "    ,'" + entity.getVaccination_date() + "' "
                    + "    ,'" + entity.getRabies_vaccine_date() + "' "
                    + "    ,'" + entity.getPetmedical_history() + "' "
                    + "    ,'" + 0 + "' FROM user_info1 ui WHERE ui.user_id='"+entity.getUser_id()+"'; ";
            System.out.println(sql);
            stmt.executeUpdate(sql);

            stmt.close();
            conn.close();

        } catch (Exception ex) {
            Logger.getLogger(PetInfoDao.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }
}

package kz.gcs.rest.service.dao;

import kz.gcs.rest.model.Location;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

/**
 * Created by kaydar on 10/17/16.
 */
@Mapper
public interface LocationDao {

    @Insert("INSERT INTO locations(longitude, latitude, \"time\", gadget_id, accuracy) VALUES (#{longitude},#{latitude},#{time},#{gadget_id},#{accuracy});")
    void insLocation(Location location);

    @Select("SELECT gadget_id from users where upper(login)=upper(#{login})")
    Long getGadgetIdByLogin(String login);
}

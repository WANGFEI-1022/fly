package com.wf.imaotai.mapper;

import com.wf.imaotai.entity.Shop;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface ShopMapper {

    public List<Shop> getList(Shop shop);

    @Select("SELECT * FROM imaotai_shop")
    public List<Shop> getListALl();

    @Insert("INSERT INTO imaotai_shop(id, shop_id, address, full_address, lat, lng, district, district_name, city, city_name, province, province_name, open_start_time, open_end_time, tenant_name, name, layaway, tags, create_time) " +
            "VALUES(#{id}, #{shopId}, #{address},#{fullAddress}, #{lat}, #{lng},#{district}, #{districtName}, #{city}, #{cityName},  #{province}, #{provinceName}, #{openStartTime}, #{openEndTime}, #{tenantName}, #{name}, #{layaway}, #{tags}, #{createTime})")
    public Long addShop(Shop shop);

    @Update("truncate imaotai_shop")
    public Long clearAll();
}

package com.dao;

import com.entity.MiyaoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.MiyaoView;

/**
 * 密钥 Dao 接口
 *
 * @author 
 */
public interface MiyaoDao extends BaseMapper<MiyaoEntity> {

   List<MiyaoView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}

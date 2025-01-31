
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 日志信息
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/miyaorizhi")
public class MiyaorizhiController {
    private static final Logger logger = LoggerFactory.getLogger(MiyaorizhiController.class);

    private static final String TABLE_NAME = "miyaorizhi";

    @Autowired
    private MiyaorizhiService miyaorizhiService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表非注册的service
    @Autowired
    private MiyaofafangService miyaofafangService;
    //注册表service
    @Autowired
    private YonghuService yonghuService;
    @Autowired
    private XueshengService xueshengService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("工作人员".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        else if("学生".equals(role))
            params.put("xueshengId",request.getSession().getAttribute("userId"));
        CommonUtil.checkMap(params);
        PageUtils page = miyaorizhiService.queryPage(params);

        //字典表数据转换
        List<MiyaorizhiView> list =(List<MiyaorizhiView>)page.getList();
        for(MiyaorizhiView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        MiyaorizhiEntity miyaorizhi = miyaorizhiService.selectById(id);
        if(miyaorizhi !=null){
            //entity转view
            MiyaorizhiView view = new MiyaorizhiView();
            BeanUtils.copyProperties( miyaorizhi , view );//把实体数据重构到view中
            //级联表 工作人员
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(miyaorizhi.getYonghuId());
            if(yonghu != null){
            BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYonghuId(yonghu.getId());
            }
            //级联表 密钥发放
            //级联表
            MiyaofafangEntity miyaofafang = miyaofafangService.selectById(miyaorizhi.getMiyaofafangId());
            if(miyaofafang != null){
            BeanUtils.copyProperties( miyaofafang , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setMiyaofafangId(miyaofafang.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody MiyaorizhiEntity miyaorizhi, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,miyaorizhi:{}",this.getClass().getName(),miyaorizhi.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("工作人员".equals(role))
            miyaorizhi.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<MiyaorizhiEntity> queryWrapper = new EntityWrapper<MiyaorizhiEntity>()
            .eq("miyaorizhi_name", miyaorizhi.getMiyaorizhiName())
            .eq("miyaorizhi_types", miyaorizhi.getMiyaorizhiTypes())
            .eq("miyaofafang_id", miyaorizhi.getMiyaofafangId())
            .eq("yonghu_id", miyaorizhi.getYonghuId())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        MiyaorizhiEntity miyaorizhiEntity = miyaorizhiService.selectOne(queryWrapper);
        if(miyaorizhiEntity==null){
            miyaorizhi.setInsertTime(new Date());
            miyaorizhi.setCreateTime(new Date());
            miyaorizhiService.insert(miyaorizhi);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody MiyaorizhiEntity miyaorizhi, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,miyaorizhi:{}",this.getClass().getName(),miyaorizhi.toString());
        MiyaorizhiEntity oldMiyaorizhiEntity = miyaorizhiService.selectById(miyaorizhi.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("工作人员".equals(role))
//            miyaorizhi.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<MiyaorizhiEntity> queryWrapper = new EntityWrapper<MiyaorizhiEntity>()
            .notIn("id",miyaorizhi.getId())
            .andNew()
            .eq("miyaorizhi_name", miyaorizhi.getMiyaorizhiName())
            .eq("miyaorizhi_types", miyaorizhi.getMiyaorizhiTypes())
            .eq("miyaofafang_id", miyaorizhi.getMiyaofafangId())
            .eq("yonghu_id", miyaorizhi.getYonghuId())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        MiyaorizhiEntity miyaorizhiEntity = miyaorizhiService.selectOne(queryWrapper);
        if(miyaorizhiEntity==null){
            miyaorizhiService.updateById(miyaorizhi);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<MiyaorizhiEntity> oldMiyaorizhiList =miyaorizhiService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        miyaorizhiService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<MiyaorizhiEntity> miyaorizhiList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("../../upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            MiyaorizhiEntity miyaorizhiEntity = new MiyaorizhiEntity();
//                            miyaorizhiEntity.setMiyaorizhiName(data.get(0));                    //日志标题 要改的
//                            miyaorizhiEntity.setMiyaorizhiTypes(Integer.valueOf(data.get(0)));   //日志类型 要改的
//                            miyaorizhiEntity.setMiyaofafangId(Integer.valueOf(data.get(0)));   //密钥 要改的
//                            miyaorizhiEntity.setYonghuId(Integer.valueOf(data.get(0)));   //员工 要改的
//                            miyaorizhiEntity.setInsertTime(date);//时间
//                            miyaorizhiEntity.setMiyaorizhiContent("");//详情和图片
//                            miyaorizhiEntity.setCreateTime(date);//时间
                            miyaorizhiList.add(miyaorizhiEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        miyaorizhiService.insertBatch(miyaorizhiList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }





}

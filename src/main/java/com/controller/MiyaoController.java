
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
 * 密钥
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/miyao")
public class MiyaoController {
    private static final Logger logger = LoggerFactory.getLogger(MiyaoController.class);

    private static final String TABLE_NAME = "miyao";

    @Autowired
    private MiyaoService miyaoService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表非注册的service
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
        PageUtils page = miyaoService.queryPage(params);

        //字典表数据转换
        List<MiyaoView> list =(List<MiyaoView>)page.getList();
        for(MiyaoView c:list){
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
        MiyaoEntity miyao = miyaoService.selectById(id);
        if(miyao !=null){
            //entity转view
            MiyaoView view = new MiyaoView();
            BeanUtils.copyProperties( miyao , view );//把实体数据重构到view中
            //级联表 工作人员
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(miyao.getYonghuId());
            if(yonghu != null){
            BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYonghuId(yonghu.getId());
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
    public R save(@RequestBody MiyaoEntity miyao, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,miyao:{}",this.getClass().getName(),miyao.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("工作人员".equals(role))
            miyao.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<MiyaoEntity> queryWrapper = new EntityWrapper<MiyaoEntity>()
            .eq("miyao_name", miyao.getMiyaoName())
            .eq("miyao_types", miyao.getMiyaoTypes())
            .eq("yonghu_id", miyao.getYonghuId())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        MiyaoEntity miyaoEntity = miyaoService.selectOne(queryWrapper);
        if(miyaoEntity==null){
            miyao.setMiyaoYesnoTypes(1);
            miyao.setInsertTime(new Date());
            miyao.setCreateTime(new Date());
            miyaoService.insert(miyao);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody MiyaoEntity miyao, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,miyao:{}",this.getClass().getName(),miyao.toString());
        MiyaoEntity oldMiyaoEntity = miyaoService.selectById(miyao.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("工作人员".equals(role))
//            miyao.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<MiyaoEntity> queryWrapper = new EntityWrapper<MiyaoEntity>()
            .notIn("id",miyao.getId())
            .andNew()
            .eq("miyao_name", miyao.getMiyaoName())
            .eq("miyao_types", miyao.getMiyaoTypes())
            .eq("yonghu_id", miyao.getYonghuId())
            .eq("insert_time", miyao.getInsertTime())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        MiyaoEntity miyaoEntity = miyaoService.selectOne(queryWrapper);
        if(miyaoEntity==null){
            miyaoService.updateById(miyao);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


    /**
    * 审核
    */
    @RequestMapping("/shenhe")
    public R shenhe(@RequestBody MiyaoEntity miyaoEntity, HttpServletRequest request){
        logger.debug("shenhe方法:,,Controller:{},,miyaoEntity:{}",this.getClass().getName(),miyaoEntity.toString());

        MiyaoEntity oldMiyao = miyaoService.selectById(miyaoEntity.getId());//查询原先数据

//        if(miyaoEntity.getMiyaoYesnoTypes() == 2){//通过
//            miyaoEntity.setMiyaoTypes();
//        }else if(miyaoEntity.getMiyaoYesnoTypes() == 3){//拒绝
//            miyaoEntity.setMiyaoTypes();
//        }
        miyaoService.updateById(miyaoEntity);//审核

        return R.ok();
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<MiyaoEntity> oldMiyaoList =miyaoService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        miyaoService.deleteBatchIds(Arrays.asList(ids));

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
            List<MiyaoEntity> miyaoList = new ArrayList<>();//上传的东西
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
                            MiyaoEntity miyaoEntity = new MiyaoEntity();
//                            miyaoEntity.setMiyaoUuidNumber(data.get(0));                    //密钥编号 要改的
//                            miyaoEntity.setMiyaoName(data.get(0));                    //密钥名称 要改的
//                            miyaoEntity.setMiyaoTypes(Integer.valueOf(data.get(0)));   //密钥类型 要改的
//                            miyaoEntity.setYonghuId(Integer.valueOf(data.get(0)));   //员工 要改的
//                            miyaoEntity.setMiyaoContent("");//详情和图片
//                            miyaoEntity.setMiyaoYesnoTypes(Integer.valueOf(data.get(0)));   //密钥审核 要改的
//                            miyaoEntity.setMiyaoYesnoText(data.get(0));                    //审核结果 要改的
//                            miyaoEntity.setInsertTime(date);//时间
//                            miyaoEntity.setCreateTime(date);//时间
                            miyaoList.add(miyaoEntity);


                            //把要查询是否重复的字段放入map中
                                //密钥编号
                                if(seachFields.containsKey("miyaoUuidNumber")){
                                    List<String> miyaoUuidNumber = seachFields.get("miyaoUuidNumber");
                                    miyaoUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> miyaoUuidNumber = new ArrayList<>();
                                    miyaoUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("miyaoUuidNumber",miyaoUuidNumber);
                                }
                        }

                        //查询是否重复
                         //密钥编号
                        List<MiyaoEntity> miyaoEntities_miyaoUuidNumber = miyaoService.selectList(new EntityWrapper<MiyaoEntity>().in("miyao_uuid_number", seachFields.get("miyaoUuidNumber")));
                        if(miyaoEntities_miyaoUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(MiyaoEntity s:miyaoEntities_miyaoUuidNumber){
                                repeatFields.add(s.getMiyaoUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [密钥编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        miyaoService.insertBatch(miyaoList);
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
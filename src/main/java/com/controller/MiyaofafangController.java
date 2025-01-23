
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
 * 密钥发放
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/miyaofafang")
public class MiyaofafangController {
    private static final Logger logger = LoggerFactory.getLogger(MiyaofafangController.class);

    private static final String TABLE_NAME = "miyaofafang";

    @Autowired
    private MiyaofafangService miyaofafangService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表非注册的service
    @Autowired
    private MiyaoService miyaoService;
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
        PageUtils page = miyaofafangService.queryPage(params);

        //字典表数据转换
        List<MiyaofafangView> list =(List<MiyaofafangView>)page.getList();
        for(MiyaofafangView c:list){
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
        MiyaofafangEntity miyaofafang = miyaofafangService.selectById(id);
        if(miyaofafang !=null){
            //entity转view
            MiyaofafangView view = new MiyaofafangView();
            BeanUtils.copyProperties( miyaofafang , view );//把实体数据重构到view中
            //级联表 学生
            //级联表
            XueshengEntity xuesheng = xueshengService.selectById(miyaofafang.getXueshengId());
            if(xuesheng != null){
            BeanUtils.copyProperties( xuesheng , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "xueshengId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setXueshengId(xuesheng.getId());
            }
            //级联表 密钥
            //级联表
            MiyaoEntity miyao = miyaoService.selectById(miyaofafang.getMiyaoId());
            if(miyao != null){
            BeanUtils.copyProperties( miyao , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "xueshengId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setMiyaoId(miyao.getId());
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
    public R save(@RequestBody MiyaofafangEntity miyaofafang, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,miyaofafang:{}",this.getClass().getName(),miyaofafang.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("学生".equals(role))
            miyaofafang.setXueshengId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<MiyaofafangEntity> queryWrapper = new EntityWrapper<MiyaofafangEntity>()
            .eq("miyao_id", miyaofafang.getMiyaoId())
            .eq("xuesheng_id", miyaofafang.getXueshengId())
            .eq("miyaofafang_types", miyaofafang.getMiyaofafangTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        MiyaofafangEntity miyaofafangEntity = miyaofafangService.selectOne(queryWrapper);
        if(miyaofafangEntity==null){
            miyaofafang.setInsertTime(new Date());
            miyaofafang.setCreateTime(new Date());
            miyaofafangService.insert(miyaofafang);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody MiyaofafangEntity miyaofafang, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,miyaofafang:{}",this.getClass().getName(),miyaofafang.toString());
        MiyaofafangEntity oldMiyaofafangEntity = miyaofafangService.selectById(miyaofafang.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("学生".equals(role))
//            miyaofafang.setXueshengId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<MiyaofafangEntity> queryWrapper = new EntityWrapper<MiyaofafangEntity>()
            .notIn("id",miyaofafang.getId())
            .andNew()
            .eq("miyao_id", miyaofafang.getMiyaoId())
            .eq("xuesheng_id", miyaofafang.getXueshengId())
            .eq("miyaofafang_types", miyaofafang.getMiyaofafangTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        MiyaofafangEntity miyaofafangEntity = miyaofafangService.selectOne(queryWrapper);
        if(miyaofafangEntity==null){
            miyaofafangService.updateById(miyaofafang);//根据id更新
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
        List<MiyaofafangEntity> oldMiyaofafangList =miyaofafangService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        miyaofafangService.deleteBatchIds(Arrays.asList(ids));

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
            List<MiyaofafangEntity> miyaofafangList = new ArrayList<>();//上传的东西
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
                            MiyaofafangEntity miyaofafangEntity = new MiyaofafangEntity();
//                            miyaofafangEntity.setMiyaoId(Integer.valueOf(data.get(0)));   //密钥 要改的
//                            miyaofafangEntity.setXueshengId(Integer.valueOf(data.get(0)));   //学生 要改的
//                            miyaofafangEntity.setMiyaofafanTime(sdf.parse(data.get(0)));          //密钥有效期 要改的
//                            miyaofafangEntity.setMiyaofafangTypes(Integer.valueOf(data.get(0)));   //访问权限 要改的
//                            miyaofafangEntity.setInsertTime(date);//时间
//                            miyaofafangEntity.setCreateTime(date);//时间
                            miyaofafangList.add(miyaofafangEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        miyaofafangService.insertBatch(miyaofafangList);
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

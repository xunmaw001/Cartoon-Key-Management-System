package com.entity.model;

import com.entity.MiyaorizhiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 日志信息
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class MiyaorizhiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 日志标题
     */
    private String miyaorizhiName;


    /**
     * 日志类型
     */
    private Integer miyaorizhiTypes;


    /**
     * 密钥
     */
    private Integer miyaofafangId;


    /**
     * 员工
     */
    private Integer yonghuId;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 日志详情
     */
    private String miyaorizhiContent;


    /**
     * 创建时间 show1 show2 nameShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：日志标题
	 */
    public String getMiyaorizhiName() {
        return miyaorizhiName;
    }


    /**
	 * 设置：日志标题
	 */
    public void setMiyaorizhiName(String miyaorizhiName) {
        this.miyaorizhiName = miyaorizhiName;
    }
    /**
	 * 获取：日志类型
	 */
    public Integer getMiyaorizhiTypes() {
        return miyaorizhiTypes;
    }


    /**
	 * 设置：日志类型
	 */
    public void setMiyaorizhiTypes(Integer miyaorizhiTypes) {
        this.miyaorizhiTypes = miyaorizhiTypes;
    }
    /**
	 * 获取：密钥
	 */
    public Integer getMiyaofafangId() {
        return miyaofafangId;
    }


    /**
	 * 设置：密钥
	 */
    public void setMiyaofafangId(Integer miyaofafangId) {
        this.miyaofafangId = miyaofafangId;
    }
    /**
	 * 获取：员工
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：员工
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：添加时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：日志详情
	 */
    public String getMiyaorizhiContent() {
        return miyaorizhiContent;
    }


    /**
	 * 设置：日志详情
	 */
    public void setMiyaorizhiContent(String miyaorizhiContent) {
        this.miyaorizhiContent = miyaorizhiContent;
    }
    /**
	 * 获取：创建时间 show1 show2 nameShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show1 show2 nameShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }

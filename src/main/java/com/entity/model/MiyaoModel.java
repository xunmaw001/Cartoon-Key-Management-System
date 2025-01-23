package com.entity.model;

import com.entity.MiyaoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 密钥
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class MiyaoModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 密钥编号
     */
    private String miyaoUuidNumber;


    /**
     * 密钥名称
     */
    private String miyaoName;


    /**
     * 密钥类型
     */
    private Integer miyaoTypes;


    /**
     * 员工
     */
    private Integer yonghuId;


    /**
     * 密钥介绍
     */
    private String miyaoContent;


    /**
     * 密钥审核
     */
    private Integer miyaoYesnoTypes;


    /**
     * 审核结果
     */
    private String miyaoYesnoText;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 获取：密钥编号
	 */
    public String getMiyaoUuidNumber() {
        return miyaoUuidNumber;
    }


    /**
	 * 设置：密钥编号
	 */
    public void setMiyaoUuidNumber(String miyaoUuidNumber) {
        this.miyaoUuidNumber = miyaoUuidNumber;
    }
    /**
	 * 获取：密钥名称
	 */
    public String getMiyaoName() {
        return miyaoName;
    }


    /**
	 * 设置：密钥名称
	 */
    public void setMiyaoName(String miyaoName) {
        this.miyaoName = miyaoName;
    }
    /**
	 * 获取：密钥类型
	 */
    public Integer getMiyaoTypes() {
        return miyaoTypes;
    }


    /**
	 * 设置：密钥类型
	 */
    public void setMiyaoTypes(Integer miyaoTypes) {
        this.miyaoTypes = miyaoTypes;
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
	 * 获取：密钥介绍
	 */
    public String getMiyaoContent() {
        return miyaoContent;
    }


    /**
	 * 设置：密钥介绍
	 */
    public void setMiyaoContent(String miyaoContent) {
        this.miyaoContent = miyaoContent;
    }
    /**
	 * 获取：密钥审核
	 */
    public Integer getMiyaoYesnoTypes() {
        return miyaoYesnoTypes;
    }


    /**
	 * 设置：密钥审核
	 */
    public void setMiyaoYesnoTypes(Integer miyaoYesnoTypes) {
        this.miyaoYesnoTypes = miyaoYesnoTypes;
    }
    /**
	 * 获取：审核结果
	 */
    public String getMiyaoYesnoText() {
        return miyaoYesnoText;
    }


    /**
	 * 设置：审核结果
	 */
    public void setMiyaoYesnoText(String miyaoYesnoText) {
        this.miyaoYesnoText = miyaoYesnoText;
    }
    /**
	 * 获取：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：录入时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }

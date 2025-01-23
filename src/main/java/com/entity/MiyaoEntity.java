package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 密钥
 *
 * @author 
 * @email
 */
@TableName("miyao")
public class MiyaoEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public MiyaoEntity() {

	}

	public MiyaoEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 密钥编号
     */
    @ColumnInfo(comment="密钥编号",type="varchar(200)")
    @TableField(value = "miyao_uuid_number")

    private String miyaoUuidNumber;


    /**
     * 密钥名称
     */
    @ColumnInfo(comment="密钥名称",type="varchar(200)")
    @TableField(value = "miyao_name")

    private String miyaoName;


    /**
     * 密钥类型
     */
    @ColumnInfo(comment="密钥类型",type="int(11)")
    @TableField(value = "miyao_types")

    private Integer miyaoTypes;


    /**
     * 员工
     */
    @ColumnInfo(comment="员工",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 密钥介绍
     */
    @ColumnInfo(comment="密钥介绍",type="text")
    @TableField(value = "miyao_content")

    private String miyaoContent;


    /**
     * 密钥审核
     */
    @ColumnInfo(comment="密钥审核",type="int(11)")
    @TableField(value = "miyao_yesno_types")

    private Integer miyaoYesnoTypes;


    /**
     * 审核结果
     */
    @ColumnInfo(comment="审核结果",type="text")
    @TableField(value = "miyao_yesno_text")

    private String miyaoYesnoText;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Miyao{" +
            ", id=" + id +
            ", miyaoUuidNumber=" + miyaoUuidNumber +
            ", miyaoName=" + miyaoName +
            ", miyaoTypes=" + miyaoTypes +
            ", yonghuId=" + yonghuId +
            ", miyaoContent=" + miyaoContent +
            ", miyaoYesnoTypes=" + miyaoYesnoTypes +
            ", miyaoYesnoText=" + miyaoYesnoText +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}

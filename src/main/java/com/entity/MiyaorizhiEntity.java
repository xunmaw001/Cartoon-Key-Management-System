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
 * 日志信息
 *
 * @author 
 * @email
 */
@TableName("miyaorizhi")
public class MiyaorizhiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public MiyaorizhiEntity() {

	}

	public MiyaorizhiEntity(T t) {
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
     * 日志标题
     */
    @ColumnInfo(comment="日志标题",type="varchar(200)")
    @TableField(value = "miyaorizhi_name")

    private String miyaorizhiName;


    /**
     * 日志类型
     */
    @ColumnInfo(comment="日志类型",type="int(11)")
    @TableField(value = "miyaorizhi_types")

    private Integer miyaorizhiTypes;


    /**
     * 密钥
     */
    @ColumnInfo(comment="密钥",type="int(11)")
    @TableField(value = "miyaofafang_id")

    private Integer miyaofafangId;


    /**
     * 员工
     */
    @ColumnInfo(comment="员工",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="添加时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 日志详情
     */
    @ColumnInfo(comment="日志详情",type="text")
    @TableField(value = "miyaorizhi_content")

    private String miyaorizhiContent;


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
        return "Miyaorizhi{" +
            ", id=" + id +
            ", miyaorizhiName=" + miyaorizhiName +
            ", miyaorizhiTypes=" + miyaorizhiTypes +
            ", miyaofafangId=" + miyaofafangId +
            ", yonghuId=" + yonghuId +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", miyaorizhiContent=" + miyaorizhiContent +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}

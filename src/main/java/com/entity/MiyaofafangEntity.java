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
 * 密钥发放
 *
 * @author 
 * @email
 */
@TableName("miyaofafang")
public class MiyaofafangEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public MiyaofafangEntity() {

	}

	public MiyaofafangEntity(T t) {
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
     * 密钥
     */
    @ColumnInfo(comment="密钥",type="int(11)")
    @TableField(value = "miyao_id")

    private Integer miyaoId;


    /**
     * 学生
     */
    @ColumnInfo(comment="学生",type="int(11)")
    @TableField(value = "xuesheng_id")

    private Integer xueshengId;


    /**
     * 密钥有效期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="密钥有效期",type="timestamp")
    @TableField(value = "miyaofafan_time")

    private Date miyaofafanTime;


    /**
     * 访问权限
     */
    @ColumnInfo(comment="访问权限",type="int(11)")
    @TableField(value = "miyaofafang_types")

    private Integer miyaofafangTypes;


    /**
     * 分配时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="分配时间",type="timestamp")
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
	 * 获取：密钥
	 */
    public Integer getMiyaoId() {
        return miyaoId;
    }
    /**
	 * 设置：密钥
	 */

    public void setMiyaoId(Integer miyaoId) {
        this.miyaoId = miyaoId;
    }
    /**
	 * 获取：学生
	 */
    public Integer getXueshengId() {
        return xueshengId;
    }
    /**
	 * 设置：学生
	 */

    public void setXueshengId(Integer xueshengId) {
        this.xueshengId = xueshengId;
    }
    /**
	 * 获取：密钥有效期
	 */
    public Date getMiyaofafanTime() {
        return miyaofafanTime;
    }
    /**
	 * 设置：密钥有效期
	 */

    public void setMiyaofafanTime(Date miyaofafanTime) {
        this.miyaofafanTime = miyaofafanTime;
    }
    /**
	 * 获取：访问权限
	 */
    public Integer getMiyaofafangTypes() {
        return miyaofafangTypes;
    }
    /**
	 * 设置：访问权限
	 */

    public void setMiyaofafangTypes(Integer miyaofafangTypes) {
        this.miyaofafangTypes = miyaofafangTypes;
    }
    /**
	 * 获取：分配时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：分配时间
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
        return "Miyaofafang{" +
            ", id=" + id +
            ", miyaoId=" + miyaoId +
            ", xueshengId=" + xueshengId +
            ", miyaofafanTime=" + DateUtil.convertString(miyaofafanTime,"yyyy-MM-dd") +
            ", miyaofafangTypes=" + miyaofafangTypes +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}

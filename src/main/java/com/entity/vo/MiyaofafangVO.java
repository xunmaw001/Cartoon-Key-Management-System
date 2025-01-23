package com.entity.vo;

import com.entity.MiyaofafangEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 密钥发放
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("miyaofafang")
public class MiyaofafangVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 密钥
     */

    @TableField(value = "miyao_id")
    private Integer miyaoId;


    /**
     * 学生
     */

    @TableField(value = "xuesheng_id")
    private Integer xueshengId;


    /**
     * 密钥有效期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "miyaofafan_time")
    private Date miyaofafanTime;


    /**
     * 访问权限
     */

    @TableField(value = "miyaofafang_types")
    private Integer miyaofafangTypes;


    /**
     * 分配时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：密钥
	 */
    public Integer getMiyaoId() {
        return miyaoId;
    }


    /**
	 * 获取：密钥
	 */

    public void setMiyaoId(Integer miyaoId) {
        this.miyaoId = miyaoId;
    }
    /**
	 * 设置：学生
	 */
    public Integer getXueshengId() {
        return xueshengId;
    }


    /**
	 * 获取：学生
	 */

    public void setXueshengId(Integer xueshengId) {
        this.xueshengId = xueshengId;
    }
    /**
	 * 设置：密钥有效期
	 */
    public Date getMiyaofafanTime() {
        return miyaofafanTime;
    }


    /**
	 * 获取：密钥有效期
	 */

    public void setMiyaofafanTime(Date miyaofafanTime) {
        this.miyaofafanTime = miyaofafanTime;
    }
    /**
	 * 设置：访问权限
	 */
    public Integer getMiyaofafangTypes() {
        return miyaofafangTypes;
    }


    /**
	 * 获取：访问权限
	 */

    public void setMiyaofafangTypes(Integer miyaofafangTypes) {
        this.miyaofafangTypes = miyaofafangTypes;
    }
    /**
	 * 设置：分配时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：分配时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}

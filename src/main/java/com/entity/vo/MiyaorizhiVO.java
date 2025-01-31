package com.entity.vo;

import com.entity.MiyaorizhiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 日志信息
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("miyaorizhi")
public class MiyaorizhiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 日志标题
     */

    @TableField(value = "miyaorizhi_name")
    private String miyaorizhiName;


    /**
     * 日志类型
     */

    @TableField(value = "miyaorizhi_types")
    private Integer miyaorizhiTypes;


    /**
     * 密钥
     */

    @TableField(value = "miyaofafang_id")
    private Integer miyaofafangId;


    /**
     * 员工
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 日志详情
     */

    @TableField(value = "miyaorizhi_content")
    private String miyaorizhiContent;


    /**
     * 创建时间 show1 show2 nameShow
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
	 * 设置：日志标题
	 */
    public String getMiyaorizhiName() {
        return miyaorizhiName;
    }


    /**
	 * 获取：日志标题
	 */

    public void setMiyaorizhiName(String miyaorizhiName) {
        this.miyaorizhiName = miyaorizhiName;
    }
    /**
	 * 设置：日志类型
	 */
    public Integer getMiyaorizhiTypes() {
        return miyaorizhiTypes;
    }


    /**
	 * 获取：日志类型
	 */

    public void setMiyaorizhiTypes(Integer miyaorizhiTypes) {
        this.miyaorizhiTypes = miyaorizhiTypes;
    }
    /**
	 * 设置：密钥
	 */
    public Integer getMiyaofafangId() {
        return miyaofafangId;
    }


    /**
	 * 获取：密钥
	 */

    public void setMiyaofafangId(Integer miyaofafangId) {
        this.miyaofafangId = miyaofafangId;
    }
    /**
	 * 设置：员工
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：员工
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：添加时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：日志详情
	 */
    public String getMiyaorizhiContent() {
        return miyaorizhiContent;
    }


    /**
	 * 获取：日志详情
	 */

    public void setMiyaorizhiContent(String miyaorizhiContent) {
        this.miyaorizhiContent = miyaorizhiContent;
    }
    /**
	 * 设置：创建时间 show1 show2 nameShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show1 show2 nameShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}

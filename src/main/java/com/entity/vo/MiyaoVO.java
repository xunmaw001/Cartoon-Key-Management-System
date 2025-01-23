package com.entity.vo;

import com.entity.MiyaoEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 密钥
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("miyao")
public class MiyaoVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 密钥编号
     */

    @TableField(value = "miyao_uuid_number")
    private String miyaoUuidNumber;


    /**
     * 密钥名称
     */

    @TableField(value = "miyao_name")
    private String miyaoName;


    /**
     * 密钥类型
     */

    @TableField(value = "miyao_types")
    private Integer miyaoTypes;


    /**
     * 员工
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 密钥介绍
     */

    @TableField(value = "miyao_content")
    private String miyaoContent;


    /**
     * 密钥审核
     */

    @TableField(value = "miyao_yesno_types")
    private Integer miyaoYesnoTypes;


    /**
     * 审核结果
     */

    @TableField(value = "miyao_yesno_text")
    private String miyaoYesnoText;


    /**
     * 录入时间
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
	 * 设置：密钥编号
	 */
    public String getMiyaoUuidNumber() {
        return miyaoUuidNumber;
    }


    /**
	 * 获取：密钥编号
	 */

    public void setMiyaoUuidNumber(String miyaoUuidNumber) {
        this.miyaoUuidNumber = miyaoUuidNumber;
    }
    /**
	 * 设置：密钥名称
	 */
    public String getMiyaoName() {
        return miyaoName;
    }


    /**
	 * 获取：密钥名称
	 */

    public void setMiyaoName(String miyaoName) {
        this.miyaoName = miyaoName;
    }
    /**
	 * 设置：密钥类型
	 */
    public Integer getMiyaoTypes() {
        return miyaoTypes;
    }


    /**
	 * 获取：密钥类型
	 */

    public void setMiyaoTypes(Integer miyaoTypes) {
        this.miyaoTypes = miyaoTypes;
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
	 * 设置：密钥介绍
	 */
    public String getMiyaoContent() {
        return miyaoContent;
    }


    /**
	 * 获取：密钥介绍
	 */

    public void setMiyaoContent(String miyaoContent) {
        this.miyaoContent = miyaoContent;
    }
    /**
	 * 设置：密钥审核
	 */
    public Integer getMiyaoYesnoTypes() {
        return miyaoYesnoTypes;
    }


    /**
	 * 获取：密钥审核
	 */

    public void setMiyaoYesnoTypes(Integer miyaoYesnoTypes) {
        this.miyaoYesnoTypes = miyaoYesnoTypes;
    }
    /**
	 * 设置：审核结果
	 */
    public String getMiyaoYesnoText() {
        return miyaoYesnoText;
    }


    /**
	 * 获取：审核结果
	 */

    public void setMiyaoYesnoText(String miyaoYesnoText) {
        this.miyaoYesnoText = miyaoYesnoText;
    }
    /**
	 * 设置：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：录入时间
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

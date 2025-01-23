package com.entity.model;

import com.entity.MiyaofafangEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 密钥发放
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class MiyaofafangModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 密钥
     */
    private Integer miyaoId;


    /**
     * 学生
     */
    private Integer xueshengId;


    /**
     * 密钥有效期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date miyaofafanTime;


    /**
     * 访问权限
     */
    private Integer miyaofafangTypes;


    /**
     * 分配时间
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

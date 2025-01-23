package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.XueshengEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 学生
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("xuesheng")
public class XueshengView extends XueshengEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 性别的值
	*/
	@ColumnInfo(comment="性别的字典表值",type="varchar(200)")
	private String sexValue;
	/**
	* 学校的值
	*/
	@ColumnInfo(comment="学校的字典表值",type="varchar(200)")
	private String xuexiaoValue;
	/**
	* 学院的值
	*/
	@ColumnInfo(comment="学院的字典表值",type="varchar(200)")
	private String xueyuanValue;
	/**
	* 专业的值
	*/
	@ColumnInfo(comment="专业的字典表值",type="varchar(200)")
	private String zhuanyeValue;




	public XueshengView() {

	}

	public XueshengView(XueshengEntity xueshengEntity) {
		try {
			BeanUtils.copyProperties(this, xueshengEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 性别的值
	*/
	public String getSexValue() {
		return sexValue;
	}
	/**
	* 设置： 性别的值
	*/
	public void setSexValue(String sexValue) {
		this.sexValue = sexValue;
	}
	//当前表的
	/**
	* 获取： 学校的值
	*/
	public String getXuexiaoValue() {
		return xuexiaoValue;
	}
	/**
	* 设置： 学校的值
	*/
	public void setXuexiaoValue(String xuexiaoValue) {
		this.xuexiaoValue = xuexiaoValue;
	}
	//当前表的
	/**
	* 获取： 学院的值
	*/
	public String getXueyuanValue() {
		return xueyuanValue;
	}
	/**
	* 设置： 学院的值
	*/
	public void setXueyuanValue(String xueyuanValue) {
		this.xueyuanValue = xueyuanValue;
	}
	//当前表的
	/**
	* 获取： 专业的值
	*/
	public String getZhuanyeValue() {
		return zhuanyeValue;
	}
	/**
	* 设置： 专业的值
	*/
	public void setZhuanyeValue(String zhuanyeValue) {
		this.zhuanyeValue = zhuanyeValue;
	}




	@Override
	public String toString() {
		return "XueshengView{" +
			", sexValue=" + sexValue +
			", xuexiaoValue=" + xuexiaoValue +
			", xueyuanValue=" + xueyuanValue +
			", zhuanyeValue=" + zhuanyeValue +
			"} " + super.toString();
	}
}
package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.MiyaorizhiEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 日志信息
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("miyaorizhi")
public class MiyaorizhiView extends MiyaorizhiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 日志类型的值
	*/
	@ColumnInfo(comment="日志类型的字典表值",type="varchar(200)")
	private String miyaorizhiValue;

	//级联表 密钥发放
										 
		/**
		* 密钥发放 的 学生
		*/
		@ColumnInfo(comment="学生",type="int(11)")
		private Integer miyaofafangXueshengId;
		/**
		* 密钥有效期
		*/
		@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
		@DateTimeFormat
		@ColumnInfo(comment="密钥有效期",type="timestamp")
		private Date miyaofafanTime;
		/**
		* 访问权限
		*/
		@ColumnInfo(comment="访问权限",type="int(11)")
		private Integer miyaofafangTypes;
			/**
			* 访问权限的值
			*/
			@ColumnInfo(comment="访问权限的字典表值",type="varchar(200)")
			private String miyaofafangValue;
	//级联表 工作人员
		/**
		* 工作人员姓名
		*/

		@ColumnInfo(comment="工作人员姓名",type="varchar(200)")
		private String yonghuName;
		/**
		* 工作人员头像
		*/

		@ColumnInfo(comment="工作人员头像",type="varchar(200)")
		private String yonghuPhoto;
		/**
		* 身份证号
		*/

		@ColumnInfo(comment="身份证号",type="varchar(200)")
		private String yonghuIdNumber;
		/**
		* 联系方式
		*/

		@ColumnInfo(comment="联系方式",type="varchar(200)")
		private String yonghuPhone;
		/**
		* 电子邮箱
		*/

		@ColumnInfo(comment="电子邮箱",type="varchar(200)")
		private String yonghuEmail;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer yonghuDelete;



	public MiyaorizhiView() {

	}

	public MiyaorizhiView(MiyaorizhiEntity miyaorizhiEntity) {
		try {
			BeanUtils.copyProperties(this, miyaorizhiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 日志类型的值
	*/
	public String getMiyaorizhiValue() {
		return miyaorizhiValue;
	}
	/**
	* 设置： 日志类型的值
	*/
	public void setMiyaorizhiValue(String miyaorizhiValue) {
		this.miyaorizhiValue = miyaorizhiValue;
	}


	//级联表的get和set 密钥发放
		/**
		* 获取：密钥发放 的 学生
		*/
		public Integer getMiyaofafangXueshengId() {
			return miyaofafangXueshengId;
		}
		/**
		* 设置：密钥发放 的 学生
		*/
		public void setMiyaofafangXueshengId(Integer miyaofafangXueshengId) {
			this.miyaofafangXueshengId = miyaofafangXueshengId;
		}

		/**
		* 获取： 密钥有效期
		*/
		public Date getMiyaofafanTime() {
			return miyaofafanTime;
		}
		/**
		* 设置： 密钥有效期
		*/
		public void setMiyaofafanTime(Date miyaofafanTime) {
			this.miyaofafanTime = miyaofafanTime;
		}
		/**
		* 获取： 访问权限
		*/
		public Integer getMiyaofafangTypes() {
			return miyaofafangTypes;
		}
		/**
		* 设置： 访问权限
		*/
		public void setMiyaofafangTypes(Integer miyaofafangTypes) {
			this.miyaofafangTypes = miyaofafangTypes;
		}


			/**
			* 获取： 访问权限的值
			*/
			public String getMiyaofafangValue() {
				return miyaofafangValue;
			}
			/**
			* 设置： 访问权限的值
			*/
			public void setMiyaofafangValue(String miyaofafangValue) {
				this.miyaofafangValue = miyaofafangValue;
			}
	//级联表的get和set 工作人员

		/**
		* 获取： 工作人员姓名
		*/
		public String getYonghuName() {
			return yonghuName;
		}
		/**
		* 设置： 工作人员姓名
		*/
		public void setYonghuName(String yonghuName) {
			this.yonghuName = yonghuName;
		}

		/**
		* 获取： 工作人员头像
		*/
		public String getYonghuPhoto() {
			return yonghuPhoto;
		}
		/**
		* 设置： 工作人员头像
		*/
		public void setYonghuPhoto(String yonghuPhoto) {
			this.yonghuPhoto = yonghuPhoto;
		}

		/**
		* 获取： 身份证号
		*/
		public String getYonghuIdNumber() {
			return yonghuIdNumber;
		}
		/**
		* 设置： 身份证号
		*/
		public void setYonghuIdNumber(String yonghuIdNumber) {
			this.yonghuIdNumber = yonghuIdNumber;
		}

		/**
		* 获取： 联系方式
		*/
		public String getYonghuPhone() {
			return yonghuPhone;
		}
		/**
		* 设置： 联系方式
		*/
		public void setYonghuPhone(String yonghuPhone) {
			this.yonghuPhone = yonghuPhone;
		}

		/**
		* 获取： 电子邮箱
		*/
		public String getYonghuEmail() {
			return yonghuEmail;
		}
		/**
		* 设置： 电子邮箱
		*/
		public void setYonghuEmail(String yonghuEmail) {
			this.yonghuEmail = yonghuEmail;
		}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getYonghuDelete() {
			return yonghuDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setYonghuDelete(Integer yonghuDelete) {
			this.yonghuDelete = yonghuDelete;
		}


	@Override
	public String toString() {
		return "MiyaorizhiView{" +
			", miyaorizhiValue=" + miyaorizhiValue +
			", yonghuName=" + yonghuName +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhone=" + yonghuPhone +
			", yonghuEmail=" + yonghuEmail +
			", yonghuDelete=" + yonghuDelete +
			", miyaofafanTime=" + DateUtil.convertString(miyaofafanTime,"yyyy-MM-dd") +
			"} " + super.toString();
	}
}

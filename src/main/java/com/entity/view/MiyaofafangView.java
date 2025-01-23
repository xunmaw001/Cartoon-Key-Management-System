package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.MiyaofafangEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 密钥发放
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("miyaofafang")
public class MiyaofafangView extends MiyaofafangEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 访问权限的值
	*/
	@ColumnInfo(comment="访问权限的字典表值",type="varchar(200)")
	private String miyaofafangValue;

	//级联表 密钥
		/**
		* 密钥编号
		*/

		@ColumnInfo(comment="密钥编号",type="varchar(200)")
		private String miyaoUuidNumber;
		/**
		* 密钥名称
		*/

		@ColumnInfo(comment="密钥名称",type="varchar(200)")
		private String miyaoName;
		/**
		* 密钥类型
		*/
		@ColumnInfo(comment="密钥类型",type="int(11)")
		private Integer miyaoTypes;
			/**
			* 密钥类型的值
			*/
			@ColumnInfo(comment="密钥类型的字典表值",type="varchar(200)")
			private String miyaoValue;
					 
		/**
		* 密钥 的 员工
		*/
		@ColumnInfo(comment="员工",type="int(11)")
		private Integer miyaoYonghuId;
		/**
		* 密钥介绍
		*/

		@ColumnInfo(comment="密钥介绍",type="text")
		private String miyaoContent;
		/**
		* 密钥审核
		*/
		@ColumnInfo(comment="密钥审核",type="int(11)")
		private Integer miyaoYesnoTypes;
			/**
			* 密钥审核的值
			*/
			@ColumnInfo(comment="密钥审核的字典表值",type="varchar(200)")
			private String miyaoYesnoValue;
		/**
		* 审核结果
		*/

		@ColumnInfo(comment="审核结果",type="text")
		private String miyaoYesnoText;
	//级联表 学生
		/**
		* 学生姓名
		*/

		@ColumnInfo(comment="学生姓名",type="varchar(200)")
		private String xueshengName;
		/**
		* 学生头像
		*/

		@ColumnInfo(comment="学生头像",type="varchar(200)")
		private String xueshengPhoto;
		/**
		* 身份证号
		*/

		@ColumnInfo(comment="身份证号",type="varchar(200)")
		private String xueshengIdNumber;
		/**
		* 联系方式
		*/

		@ColumnInfo(comment="联系方式",type="varchar(200)")
		private String xueshengPhone;
		/**
		* 电子邮箱
		*/

		@ColumnInfo(comment="电子邮箱",type="varchar(200)")
		private String xueshengEmail;
		/**
		* 学校
		*/
		@ColumnInfo(comment="学校",type="int(11)")
		private Integer xuexiaoTypes;
			/**
			* 学校的值
			*/
			@ColumnInfo(comment="学校的字典表值",type="varchar(200)")
			private String xuexiaoValue;
		/**
		* 学院
		*/
		@ColumnInfo(comment="学院",type="int(11)")
		private Integer xueyuanTypes;
			/**
			* 学院的值
			*/
			@ColumnInfo(comment="学院的字典表值",type="varchar(200)")
			private String xueyuanValue;
		/**
		* 专业
		*/
		@ColumnInfo(comment="专业",type="int(11)")
		private Integer zhuanyeTypes;
			/**
			* 专业的值
			*/
			@ColumnInfo(comment="专业的字典表值",type="varchar(200)")
			private String zhuanyeValue;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer xueshengDelete;



	public MiyaofafangView() {

	}

	public MiyaofafangView(MiyaofafangEntity miyaofafangEntity) {
		try {
			BeanUtils.copyProperties(this, miyaofafangEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
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


	//级联表的get和set 密钥

		/**
		* 获取： 密钥编号
		*/
		public String getMiyaoUuidNumber() {
			return miyaoUuidNumber;
		}
		/**
		* 设置： 密钥编号
		*/
		public void setMiyaoUuidNumber(String miyaoUuidNumber) {
			this.miyaoUuidNumber = miyaoUuidNumber;
		}

		/**
		* 获取： 密钥名称
		*/
		public String getMiyaoName() {
			return miyaoName;
		}
		/**
		* 设置： 密钥名称
		*/
		public void setMiyaoName(String miyaoName) {
			this.miyaoName = miyaoName;
		}
		/**
		* 获取： 密钥类型
		*/
		public Integer getMiyaoTypes() {
			return miyaoTypes;
		}
		/**
		* 设置： 密钥类型
		*/
		public void setMiyaoTypes(Integer miyaoTypes) {
			this.miyaoTypes = miyaoTypes;
		}


			/**
			* 获取： 密钥类型的值
			*/
			public String getMiyaoValue() {
				return miyaoValue;
			}
			/**
			* 设置： 密钥类型的值
			*/
			public void setMiyaoValue(String miyaoValue) {
				this.miyaoValue = miyaoValue;
			}
		/**
		* 获取：密钥 的 员工
		*/
		public Integer getMiyaoYonghuId() {
			return miyaoYonghuId;
		}
		/**
		* 设置：密钥 的 员工
		*/
		public void setMiyaoYonghuId(Integer miyaoYonghuId) {
			this.miyaoYonghuId = miyaoYonghuId;
		}

		/**
		* 获取： 密钥介绍
		*/
		public String getMiyaoContent() {
			return miyaoContent;
		}
		/**
		* 设置： 密钥介绍
		*/
		public void setMiyaoContent(String miyaoContent) {
			this.miyaoContent = miyaoContent;
		}
		/**
		* 获取： 密钥审核
		*/
		public Integer getMiyaoYesnoTypes() {
			return miyaoYesnoTypes;
		}
		/**
		* 设置： 密钥审核
		*/
		public void setMiyaoYesnoTypes(Integer miyaoYesnoTypes) {
			this.miyaoYesnoTypes = miyaoYesnoTypes;
		}


			/**
			* 获取： 密钥审核的值
			*/
			public String getMiyaoYesnoValue() {
				return miyaoYesnoValue;
			}
			/**
			* 设置： 密钥审核的值
			*/
			public void setMiyaoYesnoValue(String miyaoYesnoValue) {
				this.miyaoYesnoValue = miyaoYesnoValue;
			}

		/**
		* 获取： 审核结果
		*/
		public String getMiyaoYesnoText() {
			return miyaoYesnoText;
		}
		/**
		* 设置： 审核结果
		*/
		public void setMiyaoYesnoText(String miyaoYesnoText) {
			this.miyaoYesnoText = miyaoYesnoText;
		}
	//级联表的get和set 学生

		/**
		* 获取： 学生姓名
		*/
		public String getXueshengName() {
			return xueshengName;
		}
		/**
		* 设置： 学生姓名
		*/
		public void setXueshengName(String xueshengName) {
			this.xueshengName = xueshengName;
		}

		/**
		* 获取： 学生头像
		*/
		public String getXueshengPhoto() {
			return xueshengPhoto;
		}
		/**
		* 设置： 学生头像
		*/
		public void setXueshengPhoto(String xueshengPhoto) {
			this.xueshengPhoto = xueshengPhoto;
		}

		/**
		* 获取： 身份证号
		*/
		public String getXueshengIdNumber() {
			return xueshengIdNumber;
		}
		/**
		* 设置： 身份证号
		*/
		public void setXueshengIdNumber(String xueshengIdNumber) {
			this.xueshengIdNumber = xueshengIdNumber;
		}

		/**
		* 获取： 联系方式
		*/
		public String getXueshengPhone() {
			return xueshengPhone;
		}
		/**
		* 设置： 联系方式
		*/
		public void setXueshengPhone(String xueshengPhone) {
			this.xueshengPhone = xueshengPhone;
		}

		/**
		* 获取： 电子邮箱
		*/
		public String getXueshengEmail() {
			return xueshengEmail;
		}
		/**
		* 设置： 电子邮箱
		*/
		public void setXueshengEmail(String xueshengEmail) {
			this.xueshengEmail = xueshengEmail;
		}
		/**
		* 获取： 学校
		*/
		public Integer getXuexiaoTypes() {
			return xuexiaoTypes;
		}
		/**
		* 设置： 学校
		*/
		public void setXuexiaoTypes(Integer xuexiaoTypes) {
			this.xuexiaoTypes = xuexiaoTypes;
		}


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
		/**
		* 获取： 学院
		*/
		public Integer getXueyuanTypes() {
			return xueyuanTypes;
		}
		/**
		* 设置： 学院
		*/
		public void setXueyuanTypes(Integer xueyuanTypes) {
			this.xueyuanTypes = xueyuanTypes;
		}


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
		/**
		* 获取： 专业
		*/
		public Integer getZhuanyeTypes() {
			return zhuanyeTypes;
		}
		/**
		* 设置： 专业
		*/
		public void setZhuanyeTypes(Integer zhuanyeTypes) {
			this.zhuanyeTypes = zhuanyeTypes;
		}


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

		/**
		* 获取： 逻辑删除
		*/
		public Integer getXueshengDelete() {
			return xueshengDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setXueshengDelete(Integer xueshengDelete) {
			this.xueshengDelete = xueshengDelete;
		}


	@Override
	public String toString() {
		return "MiyaofafangView{" +
			", miyaofafangValue=" + miyaofafangValue +
			", xueshengName=" + xueshengName +
			", xueshengPhoto=" + xueshengPhoto +
			", xueshengIdNumber=" + xueshengIdNumber +
			", xueshengPhone=" + xueshengPhone +
			", xueshengEmail=" + xueshengEmail +
			", xueshengDelete=" + xueshengDelete +
			", miyaoUuidNumber=" + miyaoUuidNumber +
			", miyaoName=" + miyaoName +
			", miyaoContent=" + miyaoContent +
			", miyaoYesnoText=" + miyaoYesnoText +
			"} " + super.toString();
	}
}

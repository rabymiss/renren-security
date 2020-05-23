package io.renren.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2020-05-23 20:32:35
 */
@Data
@TableName("personresume")
public class PersonresumeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 
	 */
	private String addresswork;
	/**
	 * 
	 */
	private String birthday;
	/**
	 * 
	 */
	private String email;
	/**
	 * 
	 */
	private String ifmary;
	/**
	 * 
	 */
	private String phone;
	/**
	 * 
	 */
	private String politics;
	/**
	 * 
	 */
	private String qwer;
	/**
	 * 
	 */
	private String showbyshelf;
	/**
	 * 
	 */
	private String teached;
	/**
	 * 
	 */
	private String workming;
	/**
	 * 
	 */
	private String youname;
	/**
	 * 
	 */
	private String img;
	/**
	 * 
	 */
	private String uuid;
	/**
	 * 
	 */
	private String userid;

}

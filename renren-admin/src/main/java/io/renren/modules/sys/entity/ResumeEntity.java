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
@TableName("resume")
public class ResumeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 
	 */
	private String youname;
	/**
	 * 
	 */
	private String birthday;
	/**
	 * 
	 */
	private String politics;
	/**
	 * 
	 */
	private String email;
	/**
	 * 
	 */
	private String phone;
	/**
	 * 
	 */
	private String addresswork;
	/**
	 * 
	 */
	private String ifmary;
	/**
	 * 
	 */
	private String qwer;
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
	private String showbyshelf;
	/**
	 * 
	 */
	private String uuid;
	/**
	 * 
	 */
	private String cpnid;
	/**
	 * 
	 */
	private String t1;
	/**
	 * 
	 */
	private String img;

}

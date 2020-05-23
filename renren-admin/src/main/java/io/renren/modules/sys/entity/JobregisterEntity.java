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
 * @date 2020-05-23 20:32:36
 */
@Data
@TableName("jobregister")
public class JobregisterEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 
	 */
	private String jobname;
	/**
	 * 
	 */
	private String jobconditionone;
	/**
	 * 
	 */
	private String jobconditiontwo;
	/**
	 * 
	 */
	private String cpnname;
	/**
	 * 
	 */
	private String jobpay;
	/**
	 * 
	 */
	private String uuid;
	/**
	 * 
	 */
	private String image;
	/**
	 * 
	 */
	private String username;

}

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
@TableName("job_message_all")
public class JobMessageAllEntity implements Serializable {
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
	private String cpnaddress;
	/**
	 * uuid
	 */
	private String good1;
	/**
	 * 
	 */
	private String good2;
	/**
	 * 
	 */
	private String good3;
	/**
	 * 
	 */
	private String good4;
	/**
	 * 
	 */
	private String jobpay;
	/**
	 * 
	 */
	private String conditionone;
	/**
	 * 
	 */
	private String conditiontwo;
	/**
	 * 
	 */
	private String condition3;
	/**
	 * 
	 */
	private String workcontent;
	/**
	 * 
	 */
	private String workcontentshow;
	/**
	 * 
	 */
	private String dizhi;
	/**
	 * 
	 */
	private String workaddress;
	/**
	 * 
	 */
	private String cpnimage;
	/**
	 * 
	 */
	private String cpnname1;

}

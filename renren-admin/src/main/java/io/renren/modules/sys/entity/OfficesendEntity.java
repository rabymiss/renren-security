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
@TableName("officesend")
public class OfficesendEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 
	 */
	private String rencainame;
	/**
	 * 
	 */
	private String oftime;
	/**
	 * 
	 */
	private String lianxiren;
	/**
	 * 
	 */
	private String lxphone;
	/**
	 * 
	 */
	private String cpnname;
	/**
	 * 
	 */
	private String cpnid;
	/**
	 * 
	 */
	private String ofuuid;
	/**
	 * 
	 */
	private String dozhi;
	/**
	 * 
	 */
	private String email;
	/**
	 * 
	 */
	private String t1;
	/**
	 * 
	 */
	private String t2;
	/**
	 * 
	 */
	private String ofcontent;
	/**
	 * 
	 */
	private String jobname;

}

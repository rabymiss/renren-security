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
@TableName("cpn_msg")
public class CpnMsgEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 
	 */
	private String username;
	/**
	 * 
	 */
	private String nickname;
	/**
	 * 
	 */
	private String icon;
	/**
	 * 
	 */
	private String burthday;
	/**
	 * 
	 */
	private String email;
	/**
	 * 
	 */
	private String phonenumber;
	/**
	 * 
	 */
	private String addressp;
	/**
	 * uuid
	 */
	private String workin;
	/**
	 * 
	 */
	private String showyou;
	/**
	 * 
	 */
	private String uuid;

}

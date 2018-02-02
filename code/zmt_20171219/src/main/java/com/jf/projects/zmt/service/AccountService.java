package com.jf.projects.zmt.service;

import java.util.List;

import com.jf.projects.zmt.vo.ResponseVO;
import com.jf.projects.zmt.vo.account.AccountInfoVo;
import com.jf.projects.zmt.vo.account.AccountSearchVo;
import com.jf.projects.zmt.vo.account.AddUserInfoVo;
import com.jf.projects.zmt.vo.account.AppAddUserInfoVo;
import com.jf.projects.zmt.vo.account.UserAreaVo;
import com.jf.projects.zmt.vo.area.AppUpdateAddressVo;

/**
 * 账户管理
 * @author dqh
 *
 */
public interface AccountService {
	
	/**
	 * 分页数据
	 * @param search
	 * @return
	 */
	public ResponseVO findPage(AccountSearchVo search);
	
	/**
	 * 根据用户id获取用户信息
	 * @param id
	 * @return
	 */
	public AccountInfoVo findInfoById(String id);
	
	/**
	 *	根据用户id获取用户区域id和类型
	 * @param userId
	 * @return
	 */
	public List<UserAreaVo> findAreaByUserId(String userId);
	
	/**
	 * 新增用户
	 * @param vo
	 * @return
	 */
	public String add(AddUserInfoVo vo);
	
	/**
	 * 修改用户
	 * @param vo
	 * @return
	 */
	public Integer update(AddUserInfoVo vo);
	
	/**
	 * 禁用启用账号
	 * 账号被禁用后，该账号不可登陆，已登陆状态被禁用，对用户进行提示“您的账户已被禁用！请重新登陆”
	 * @param userId
	 * @return 返回0：电话号码已存在 成功返回userID
	 */
	public Integer updateStatus(String userId);
	
	/**
	 * 删除账号
	 * 用户下没有任何数据的情况下可删除，如有任何操作数据，如添加养殖信息、疫苗、屠宰等数据信息后，改账号不可删除！
	 * @param userId
	 * @return
	 */
	public String delete(String userId);
	
	/**
	 * 重置密码 原始密码ZMT123456
	 * @param userId
	 * @return
	 */
	public String restPwd(String userId);
	
	/**
	 * APP端新建养殖户信息
	 * @param userInfo
	 * @return
	 */
	public String AppAddFarmsUser(AppAddUserInfoVo userInfo);
	
	/**
	 * 验证用户是否被删除或者被禁用
	 * @param userId
	 * @return
	 */
	public String verifyUserById(String userId);
	
	/**
	 * App端修改用户地址
	 * @param vo
	 * @return
	 */
	public Integer AppUpdateAddress(AppUpdateAddressVo vo);

}

package com.jf.projects.zmt.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jf.projects.zmt.model.SUser;
import com.jf.projects.zmt.vo.account.AccountInfoVo;
import com.jf.projects.zmt.vo.account.AccountSearchVo;
import com.jf.projects.zmt.vo.account.AccountVo;
import com.jf.projects.zmt.vo.account.UserInfoVO;
import com.jf.projects.zmt.vo.fileManager.BuildersVo;
import com.jf.projects.zmt.vo.market.MarketVo;
import com.jf.projects.zmt.vo.slaughterhouse.SlaughterhouseVo;
import com.jf.projects.zmt.vo.user.LoginUserInfoVo;
import com.jf.projects.zmt.vo.user.UserInfoVo;
import com.jf.projects.zmt.vo.user.UserSearch;
import com.jf.projects.zmt.vo.user.UserVo;

public interface SUserMapper extends BaseMapper<SUser> {

	/**
	 * 检验中心列表
	 * 
	 * @param account
	 *            账号
	 * @param phone
	 *            电话
	 * @param typeId
	 *            类型id
	 * @param departmentId
	 *            部门id
	 * @param roleId
	 *            角色id
	 * @param start
	 * @param length
	 * @return
	 */
	List<UserVo> findUserByKey(@Param(value = "account") String account,
			@Param(value = "phone") String phone,
			@Param(value = "key") String key,
			@Param(value = "typeId") String typeId,
			@Param(value = "departmentId") String departmentId,
			@Param(value = "roleId") String roleId,
			@Param(value = "start") Integer start,
			@Param(value = "length") Integer length);

	/**
	 * 市场中心人员列表
	 * 
	 * @param search
	 * @return
	 */
	List<MarketVo> findMarketUserByKey(UserSearch search);

	/**
	 * 屠宰场人员列表
	 * 
	 * @param search
	 * @return
	 */
	List<SlaughterhouseVo> findSlaughterHouseUserByKey(UserSearch search);

	/**
	 * 人员列表总条数
	 * 
	 * @param account
	 *            账号
	 * @param phone
	 *            电话
	 * @param typeId
	 *            类型id
	 * @param departmentId
	 *            部门id
	 * @param roleId
	 *            角色id
	 * @return
	 */
	Long findUserCountByKey(@Param(value = "account") String account,
			@Param(value = "phone") String phone,
			@Param(value = "key") String key,
			@Param(value = "typeId") String typeId,
			@Param(value = "departmentId") String departmentId,
			@Param(value = "roleId") String roleId);

	/**
	 * 条件查找建档者
	 * 
	 * @param account
	 * @param phone
	 * @param typeId
	 * @param departmentId
	 * @param roleId
	 * @param start
	 * @param length
	 * @return
	 */
	List<BuildersVo> findBuidersInfo(@Param(value = "account") String account,
			@Param(value = "phone") String phone,
			@Param(value = "typeId") String typeId,
			@Param(value = "departmentId") String departmentId,
			@Param(value = "roleId") String roleId,
			@Param(value = "keyWords") String keyWords,
			@Param(value = "start") Integer start,
			@Param(value = "length") Integer length);

	/**
	 * 禁用或启用该用户
	 * 
	 * @return
	 */
	int forbidOrStart(@Param("userId") String userId,
			@Param("status") String status);

	// ----------------dqh-start
	/**
	 * 账号管理列表
	 * 
	 * @param search
	 * @return
	 */
	List<AccountVo> findPageByUser(AccountSearchVo search);

	/**
	 * 统计分页条数
	 * 
	 * @param search
	 * @return
	 */
	long findTotal(AccountSearchVo search);

	/**
	 * 根据用户id获取用户信息
	 * 
	 * @param id
	 * @return
	 */
	public AccountInfoVo findInfoById(@Param(value = "id") String id);

	// ----------------dqh--end

	UserInfoVo findUserInfoByUerId(@Param(value = "userId") String userId);

	/**
	 * 根据登录账号获取用户信息
	 * 
	 * @param account
	 * @return
	 */
	SUser findByAccount(@Param(value = "account") String account);

	/**
	 * 获取用户登录信息
	 * 
	 * @param account
	 * @return
	 */
	LoginUserInfoVo findUserLoginInfo(@Param(value = "account") String account);

	/**
	 * 条件查找建档者
	 * 
	 * @param account
	 * @param phone
	 * @param typeId
	 * @param departmentId
	 * @param roleId
	 * @param start
	 * @param length
	 * @return
	 */
	Long findBuiderNumber(@Param(value = "account") String account,
			@Param(value = "phone") String phone,
			@Param(value = "typeId") String typeId,
			@Param(value = "departmentId") String departmentId,
			@Param(value = "roleId") String roleId,
			@Param(value = "keyWords") String keyWords);

	/**
	 * 根据电话号码获取用户（新增用户，电话号码去重）
	 * 
	 * @param tel
	 *            电话号码
	 * @param userId
	 *            用户id
	 * @return
	 */
	SUser findUserByTel(@Param(value = "tel") String tel,
			@Param(value = "userId") String userId);

	/**
	 * 市场用户列表的总条数
	 * 
	 * @param search
	 * @return
	 */
	Long findMarketUserCountByKey(UserSearch search);

	/**
	 * 屠宰场用户列表的总条数
	 * 
	 * @param search
	 * @return
	 */
	Long findSlaughterHouseUserCountByKey(UserSearch search);
	
	/**
	 * 根据用户ID获取用户类型部门角色信息
	 * @param userId
	 * @return
	 */
	UserInfoVO findUserInfoByUserId(@Param(value = "userId") String userId);
	
	/**
	 * 根据创建人查找用户
	 * @param createId
	 * @return
	 */
	SUser findUserByCreateId(@Param(value = "createId") String createId);
	
}
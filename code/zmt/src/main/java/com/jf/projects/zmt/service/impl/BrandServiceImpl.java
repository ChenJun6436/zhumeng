package com.jf.projects.zmt.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.jf.projects.zmt.dao.AreaMapper;
import com.jf.projects.zmt.dao.BrandMapper;
import com.jf.projects.zmt.dao.PigFileMapper;
import com.jf.projects.zmt.dao.PigFlowMapper;
import com.jf.projects.zmt.dao.SUserMapper;
import com.jf.projects.zmt.dao.SignExcelMapper;
import com.jf.projects.zmt.model.Brand;
import com.jf.projects.zmt.model.PigFile;
import com.jf.projects.zmt.model.PigFlow;
import com.jf.projects.zmt.model.SignExcel;
import com.jf.projects.zmt.service.BrandService;
import com.jf.projects.zmt.service.UserService;
import com.jf.projects.zmt.util.Configure;
import com.jf.projects.zmt.util.ConstantsUtil;
import com.jf.projects.zmt.util.PoiExcelExport;
import com.jf.projects.zmt.util.SignGenerator;
import com.jf.projects.zmt.util.UUIDUtil;
import com.jf.projects.zmt.vo.ResponseVO;
import com.jf.projects.zmt.vo.farms.AppSearch;
import com.jf.projects.zmt.vo.fileManager.AppBrandVo;
import com.jf.projects.zmt.vo.user.UserInfoVo;

@Service
public class BrandServiceImpl implements BrandService {
	@Autowired
	private BrandMapper brandMapper;
	@Autowired
	private PigFlowMapper pFlowMapper;
	@Autowired
	private SUserMapper sUserMapper;
	@Autowired
	private PigFileMapper pMapper;
	@Autowired
	private UserService userService;
	@Autowired
	private AreaMapper areaMapper;
	@Autowired
	private SignExcelMapper signExcelMapper;

	@Override
	public ResponseVO activeBrandBySign(String sign, String userId) {
		ResponseVO responseVO = new ResponseVO();
		PigFlow pFlow = new PigFlow();
		Brand brand = brandMapper.findBrand(sign);
		if (brand == null) {
			responseVO.setCode(ConstantsUtil.SIGN_NOT_EXIXT);
			responseVO.setMessage("该标签不存在");

		} else {
			int flag = brandMapper.findBrandStatus(sign);
			if (flag == 1) {
				responseVO.setCode(ConstantsUtil.SIGN_ACTIVE_STRING);
				responseVO.setMessage("该标签已经被激活");
			} else {
				SimpleDateFormat formatter = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss");
				String dateString = formatter
						.format(System.currentTimeMillis());
				brandMapper.activeBrand(sign, userId, dateString);
				UserInfoVo uVo = sUserMapper.findUserInfoByUerId(userId);
				uVo.setAddress(userService.getAddressById(userId));
				if (uVo != null) {
					pFlow.setCreaterName(uVo.getName());
					pFlow.setAddress(uVo.getAddress());
					pFlow.setId(UUIDUtil.getUUID());
					pFlow.setStatus("正常");
					pFlow.setThing("建号");
					pFlow.setPigId(sign);
					pFlowMapper.insert(pFlow);
				}
				responseVO.setCode(ConstantsUtil.RES_SUCCESS_CODE);
				responseVO.setMessage("激活成功");
			}
		}
		return responseVO;
	}

	@Override
	public ResponseVO deleteBrandBySign(String sign) {
		int flag = brandMapper.deleteSign(sign);
		ResponseVO responseVO = new ResponseVO();
		if (flag == 1) {
			responseVO.setCode(ConstantsUtil.RES_SUCCESS_CODE);
			responseVO.setMessage(ConstantsUtil.RES_SUCCESS_MESSAGE);
		} else {
			responseVO.setCode("-1");
			responseVO.setMessage("删除失败");
		}

		return responseVO;
	}

	@Override
	public ResponseVO findSignDetail(String sign) {
		PigFile pigFile = pMapper.findPigfileBySign(sign);
		Brand brand = brandMapper.findBrand(sign);
		ResponseVO responseVO = new ResponseVO();
		if (brand == null) {
			responseVO.setCode(ConstantsUtil.SIGN_NOT_EXIXT);
			responseVO.setMessage("标签不存在");
			return responseVO;
		} else {
			int flag = brandMapper.findBrandStatus(sign);
			if (flag == 0) {
				responseVO.setCode(ConstantsUtil.SIGN_NOT_ACTIVE);
				responseVO.setMessage("标签未被激活");
				return responseVO;
			}
		}
		if (pigFile != null) {
			responseVO.setCode(ConstantsUtil.SIGN_TO_USE);
			responseVO.setMessage("标签不能使用");
			return responseVO;
		}

		Map<String, String> map = new HashMap<String, String>();
		map.put("createrId", brand.getCreaterId());
		responseVO.setCode(ConstantsUtil.RES_SUCCESS_CODE);
		responseVO.setMessage(ConstantsUtil.RES_SUCCESS_MESSAGE);
		responseVO.setData(map);
		return responseVO;
	}

	@Override
	public ResponseVO appFindBrandInfo(AppSearch vo) {
		ResponseVO responseVO = new ResponseVO();
		String start = vo.getBeginDate();
		String end = vo.getEndDate();
		if (start != null) {
			vo.setBeginDate(start + " 00:00:00");
		}
		if (end != null) {
			vo.setEndDate(end + " 23:59:59");
		}
		List<AppBrandVo> list = brandMapper.findAppBrandInfoByCreater(
				vo.getId(), vo.getBeginDate(), vo.getEndDate(),
				vo.getKeyWords());
		responseVO.setData(list);
		responseVO.setCode(ConstantsUtil.RES_SUCCESS_CODE);
		responseVO.setMessage(ConstantsUtil.RES_SUCCESS_MESSAGE);
		return responseVO;
	}

	/*
	 * @Override public ResponseVO createSign(String code) { ResponseVO
	 * responseVO = new ResponseVO(); String realPath =
	 * System.getProperty("catalina.home");// 获取服务器路径 String pathsString =
	 * realPath.replaceAll("/", File.separator); File file = new
	 * File(pathsString + File.separator + "code_img"); String format = "jpg";
	 * // 如果文件夹不存在则创建 if (!file.exists() && !file.isDirectory()) {
	 * System.out.println("//不存在"); file.mkdir(); } else {
	 * System.out.println("//目录存在"); } SignGenerator signGenerator = new
	 * SignGenerator(code); ArrayList<String> signPool =
	 * signGenerator.getSign(); List<Brand> list = new ArrayList<>(); for
	 * (String string : signPool) { Brand brand = new Brand();
	 * brand.setId(UUIDUtil.getUUID()); brand.setSign(string); list.add(brand);
	 * } int flag = brandMapper.insertBrand(list); if (flag != 0) {
	 * responseVO.setCode(ConstantsUtil.RES_SUCCESS_CODE);
	 * responseVO.setMessage(ConstantsUtil.RES_SUCCESS_MESSAGE);
	 * responseVO.setData(flag); } // 将任务分成5个任务，采用多线程加快执行速度 try {
	 * List<List<String>> liss = ListUtil.averageAssign(signPool, 5);
	 * ExecutorService executor = ExecutorThreadPool.newFixedThreadPool(5); for
	 * (List<String> list2 : liss) { SignRunnable signRunnable = new
	 * SignRunnable(list2, pathsString, format); executor.execute(signRunnable);
	 * } executor.shutdown(); } catch (Exception e) { e.printStackTrace();
	 * responseVO.setCode(ConstantsUtil.RES_FAIL_CODE);
	 * responseVO.setMessage(ConstantsUtil.RES_FAIL_MESSAGE); }
	 * 
	 * try { String format = "jpg";// 二维码的图片格式 int flag =
	 * brandMapper.insertBrand(list); if (flag != 0) {
	 * responseVO.setCode(ConstantsUtil.RES_SUCCESS_CODE);
	 * responseVO.setMessage(ConstantsUtil.RES_SUCCESS_MESSAGE);
	 * responseVO.setData(flag); } for (String string : signPool) { File
	 * outputFile = new File(pathsString + File.separator + "code_img" +
	 * File.separator + string + ".jpg");
	 * ZxingTool.writeToFile(ZxingTool.encodeQRcode(string, 110, 110), format,
	 * outputFile); ZxingTool.pressText(string, outputFile, 5, Color.black, 11);
	 * } } catch (Exception e) { e.getStackTrace();
	 * responseVO.setCode(ConstantsUtil.RES_FAIL_CODE);
	 * responseVO.setMessage(ConstantsUtil.RES_FAIL_MESSAGE); }
	 * 
	 * return responseVO; }
	 */

	@Override
	public ResponseVO createSign(Integer id, HttpServletResponse response,
			String address) {
		ResponseVO responseVO = new ResponseVO();
		try {
			/*
			 * String realPath = System.getProperty("catalina.home");// 获取服务器路径
			 * String pathsString = realPath.replaceAll("/", File.separator);
			 */
			Configure configure = new Configure("config/param.properties");
			String path = configure.getValue("excel.url");
			String osName = System.getProperties().getProperty("os.name");// 判断运行环境
			String strUrl = "";
			if (osName.equals("Linux")) {
				strUrl = path.substring(2, path.length());
			} else {
				strUrl = path;
			}

			String code = areaMapper.getCodeById(id);
			if (code == null) {
				responseVO.setCode(ConstantsUtil.RES_FAIL_CODE);
				responseVO.setMessage("地区不存在");
				return responseVO;
			}
			SimpleDateFormat formatter = new SimpleDateFormat(
					"yyyy-MM-dd-HH-mm-ss");
			String dateString = formatter.format(System.currentTimeMillis());
			SignGenerator signGenerator = new SignGenerator(code);
			ArrayList<String> signPool = signGenerator.getSign();
			List<Brand> list = new ArrayList<>();

			String urlS = strUrl + "/" + dateString + "-" + code + "-code.xls";
			SignExcel signExcel = new SignExcel();
			signExcel.setId(UUIDUtil.getUUID());
			signExcel.setAddress(address);
			signExcel.setUrl(urlS);
			// 设置poi生产Excel样式设置
			PoiExcelExport poee = new PoiExcelExport(urlS, "sheet1");

			PoiExcelExport pee = new PoiExcelExport(response, dateString + "-"
					+ code + "-code", "sheet1");
			String titleColumn[] = { "sign" };
			String titleName[] = { "标签" };
			int titleSize[] = { 18 };
			for (String string : signPool) {
				Brand brand = new Brand();
				brand.setId(UUIDUtil.getUUID());
				brand.setSign(string);
				list.add(brand);
			}
			int flag = brandMapper.insertBrand(list);
			if (flag != 0) {
				signExcelMapper.insert(signExcel);
				poee.wirteExcel(titleColumn, titleName, titleSize, list);// 保存到服务器
				pee.wirteExcel(titleColumn, titleName, titleSize, list);// 返回到到浏览器
				responseVO.setCode(ConstantsUtil.RES_SUCCESS_CODE);
				responseVO.setMessage(ConstantsUtil.RES_SUCCESS_MESSAGE);
				responseVO.setData(flag);
			}
			return responseVO;
		} catch (Exception e) {
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus()
					.setRollbackOnly();
			responseVO.setCode(ConstantsUtil.RES_FAIL_CODE);
			responseVO.setMessage(ConstantsUtil.RES_EXIST_MESSAGE);
			return responseVO;
		}
	}
}

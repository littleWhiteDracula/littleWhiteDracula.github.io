package cn.itcast.ssm.service;

import java.util.List;

import cn.itcast.ssm.po.ItemsCustom;
import cn.itcast.ssm.po.ItemsQueryVo;
import cn.itcast.ssm.po.UserCustom;
import cn.itcast.ssm.po.UserVO;


public interface ItemsService {
	
	//商品查询列表
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;
	
	//根据id查询商品信息

	public ItemsCustom findItemsById(Integer id) throws Exception;
	
	//修改商品信息

	public void updateItems(Integer id,ItemsCustom itemsCustom) throws Exception;
	

	//用户信息查询列表
	public List<UserCustom> findUserList(UserVO userVO)throws Exception;
}

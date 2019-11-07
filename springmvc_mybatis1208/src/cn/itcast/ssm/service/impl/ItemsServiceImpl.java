package cn.itcast.ssm.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import cn.itcast.ssm.mapper.ItemsMapper;
import cn.itcast.ssm.mapper.ItemsMapperCustom;
import cn.itcast.ssm.mapper.UserMapper;
import cn.itcast.ssm.mapper.UserMapperCustom;
import cn.itcast.ssm.po.Items;
import cn.itcast.ssm.po.ItemsCustom;
import cn.itcast.ssm.po.ItemsQueryVo;
import cn.itcast.ssm.po.UserCustom;
import cn.itcast.ssm.po.UserVO;
import cn.itcast.ssm.service.ItemsService;


public class ItemsServiceImpl implements ItemsService{
	
	@Autowired
	private ItemsMapperCustom itemsMapperCustom;//定义商品类别查询类
	
	@Autowired
	private ItemsMapper itemsMapper;//各种方法
	
	@Autowired
	private UserMapperCustom userMapperCustom;
	@Autowired
	private UserMapper userMapper;

	@Override
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo)
			throws Exception {
		//通过ItemsMapperCustom查询数据库
		return itemsMapperCustom.findItemsList(itemsQueryVo);
	}

	@Override
	public List<UserCustom> findUserList(UserVO userVO) throws Exception {
		// TODO Auto-generated method stub
		return userMapperCustom.findUserList(userVO);
	}
	
	@Override
	public ItemsCustom findItemsById(Integer id) throws Exception {
		
		Items items = itemsMapper.selectByPrimaryKey(id);
		//中间对商品信息进行业务处理
		//....
		//返回ItemsCustom
		ItemsCustom itemsCustom = new ItemsCustom();
		//将items的属性值拷贝到itemsCustom
		BeanUtils.copyProperties(items, itemsCustom);
		
		return itemsCustom;
		
	}

	@Override
	public void updateItems(Integer id, ItemsCustom itemsCustom) throws Exception {
		//添加业务校验，通常在service接口对关键参数进行校验
		//校验 id是否为空，如果为空抛出异常
		
		//更新商品信息使用updateByPrimaryKeyWithBLOBs根据id更新items表中所有字段，包括 大文本类型字段
		//updateByPrimaryKeyWithBLOBs要求必须转入id
		itemsCustom.setId(id);
		itemsMapper.updateByPrimaryKeyWithBLOBs(itemsCustom);
	}



}

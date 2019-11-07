package cn.itcast.ssm.mapper;

import java.util.List;

import cn.itcast.ssm.po.ItemsCustom;
import cn.itcast.ssm.po.ItemsQueryVo;
import cn.itcast.ssm.po.UserCustom;
import cn.itcast.ssm.po.UserVO;

public interface UserMapperCustom {
    //用户信息查询列表
	public List<UserCustom> findUserList(UserVO userVO)throws Exception;
}

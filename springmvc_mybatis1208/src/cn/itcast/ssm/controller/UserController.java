package cn.itcast.ssm.controller;

import java.util.List;



import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.itcast.ssm.po.ItemsCustom;
import cn.itcast.ssm.po.UserCustom;
import cn.itcast.ssm.service.ItemsService;
@Controller
@RequestMapping("/usercontroller")
public class UserController {
	@Autowired
	private ItemsService itemsService;//调用业务层接口类

	// 商品查询
	@RequestMapping("/queryUser")
	public ModelAndView queryUser(HttpServletRequest request) throws Exception {


		/*调用service查找 数据库，查询商品列表，将null赋值给业务层接口类的findItemsList方法，
		将结果存储到itemsList列表中，此列表是泛型，商品信息的拓展属性*/
		List<UserCustom> userList = itemsService.findUserList(null);
		
		// 返回ModelAndView
		ModelAndView modelAndView = new ModelAndView();
		// 相当 于request的setAttribut，在jsp页面中通过itemsList取数据
		modelAndView.addObject("userList", userList);

		// 指定视图
		// 下边的路径，如果在视图解析器中配置jsp路径的前缀和jsp路径的后缀，修改为
		// modelAndView.setViewName("/WEB-INF/jsp/items/itemsList.jsp");
		// 上边的路径配置可以不在程序中指定jsp路径的前缀和jsp路径的后缀
		modelAndView.setViewName("user/userList");

		return modelAndView;

	}

}

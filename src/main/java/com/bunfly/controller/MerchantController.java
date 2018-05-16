package com.bunfly.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.bunfly.model.Menu;
import com.bunfly.model.MenuLimit;
import com.bunfly.model.Merchant;
import com.bunfly.model.Order;
import com.bunfly.model.OrderInfo;
import com.bunfly.service.IMerchantService;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("/merchant")
public class MerchantController {
	
	@Resource
	private IMerchantService mers;
	//記錄錯誤登陸此時
	static int i = 0;
	//存放當前登陸者的id
	static int id = 0;
	
	
	public int file(MultipartFile file) throws IllegalStateException, IOException{
		//用时间戳为上传的问价起名
		int lo = (int)new Date().getTime();
		//String path =request.getServletContext().getRealPath("cid");
		String path = "D:\\JEE\\WorkSpace-WEB\\xxxtake-out-master\\src\\main\\webapp\\cid";
		
		String filename = file.getOriginalFilename();
		//取出上传文件的扩展名
		//String ind = filename.substring(filename.lastIndexOf(".")+1);
		String newName = lo+".png";
		File f = new File(path,newName);
		file.transferTo(f);
		return lo;
	}
	//商家注册
	@RequestMapping("/register")
	public String register(MultipartFile file,Merchant mer,ModelMap mm) throws IllegalStateException, IOException{
		//设置必填项
		if("".equals(mer.getPassword())){
			mm.put("info2", "密码不能为空！");
			return "redirect:/merchantRegister.jsp";
		}
		if("".equals(mer.getUsername())){
			mm.put("info", "用户名不能为空！");
			return "/merchantRegister.jsp";
		}
		if("".equals(mer.getCid())){
			mm.put("info", "验证信息不能为空");
			return "/merchantRegister.jsp";
		}
		//查询该用户是否已经注册
		Merchant me = mers.selectByName(mer);
		//可以注册
		if(me==null){
			//对图片的处理以及得到该图片的识别码
			int lo = file(file);
			mer.setMid(0);
			//设置识别码
			mer.setHid(lo);
			//注册
			mers.register(mer);
			Merchant meer = mers.selectByName(mer);
			//注册成功，保留id，并跳转到商家主页
			id=meer.getMid();
			return "redirect:/merchantIndex.jsp";
		}
		//不可以注册
		mm.put("info", "该手机号已注册！");
		return "/merchantRegister.jsp";
		
	}
	
	//商家登陆
	@RequestMapping("/login")
	public String login(Merchant mer,ModelMap mm){
		//限制错误登陆次数，达到三次将跳转到注册界面
		if(i==2){
			i=0;
			return "redirect:/merchantRegister.jsp";
		}
		//用户名和密码验证
		if("".equals(mer.getUsername())){
			mm.put("info", "用户名或密码错误！");
			return "/merchantLogin.jsp";
		}
		Merchant me = mers.selectByName(mer);
		
		if(me==null){
			System.out.println("meisnull");
			mm.put("info", "用户名或密码错误！错误三次跳转至注册界面或找回密码");
			i++;
			
			return "/merchantLogin.jsp";
		}
		//验证成功
		if(mer.getUsername().equals(me.getUsername())&&mer.getPassword().equals(me.getPassword())){
			//登陆成功保留id，并跳转到商家主页
			id=me.getMid();
			return "redirect:/merchantIndex.jsp";
		}
		//验证失败，累加失败次数
		i++;
		
		mm.put("info", "用户名或密码错误！错误三次跳转至注册界面或找回密码");
		return "/merchantLogin.jsp";
	}
	
	//找回密码
	@RequestMapping("/findp")
	public String findP(Merchant mer,ModelMap mm){
		//设置必填项
		if("".equals(mer.getUsername())||"".equals(mer.getCid())){
			mm.put("info", "请输入用户名和验证信息");
			return "/findPs.jsp";
		}
		//根据用户名得到该用户的验证信息
		String pas = mers.findp(mer);
		//判断用户名和验证信息是否匹配
		if("".equals(pas)){
			mm.put("info", "用户名或验证信息不正确！");
			return "/findPs.jsp";
		}
		//返回密码
		mm.put("pas", pas);
		return "/findPs.jsp";
	}
	//登陆后根据商家id要展示的数据
	@RequestMapping("/index")
	public String merchantIndex(ModelMap mm,HttpServletRequest request){
		//根据登陆时保留的id得到登陆的商家
		Merchant mname = mers.selectById(id);
		//查询到该商家的交易总额和交易量
		int allprice = mers.allprice(id);
		int allcount = mers.allcount(id);
		mm.put("allprice", allprice);
		mm.put("allcount", allcount);
		String name = mname.getUsername();
		//创建一个分页对象
		MenuLimit ml = new MenuLimit();
		ml.setId(id);
		
		Integer page = Integer.parseInt(request.getParameter("page")==null||request.getParameter("page")==""? "1" : request.getParameter("page"));
		//向上取整
		ml.setCount((int)Math.ceil((double)mers.count(id)/(double)ml.getPagesize()));
		ml.setPage(page);
		ml.setPages(ml.getPagesize()*(page-1));
		//将当前用户的用户名保存起来
		request.getSession().setAttribute("name", name);
		ml.setList(mers.selectMenu(ml));
		//List<Menu> menu = mers.selectMenu(id,j);
		//判断是否有商品
//		if(menu.isEmpty()){
//			
//			mm.put("list", null);
//			return "/WEB-INF/merchantIndex.jsp";
//		}
		
		//JSONArray json = JSONArray.fromObject(menu);
		mm.put("list", ml);
		return "/WEB-INF/merchantIndex.jsp";
	}
	
	//商家上传商品
	@RequestMapping("/upload")
	public String uploadMenu(Menu menu, ModelMap mm,MultipartFile file) throws IllegalStateException, IOException{
		//设置商品名和价格为必填项
		if("".equals(menu.getPname())||"".equals(menu.getPrice())||0==menu.getKid()){
			mm.put("info", "请填写完整商品信息！");
			return "/WEB-INF/merchantIndex.jsp";
		}
		//对图片的操作
		int lo = file(file);
		menu.setPid(0);
		//设置图片识别码
		menu.setHid(lo);
		Merchant mname = mers.selectById(id);
		//给该商品标记商家
		menu.setMid(mname.getMid());
		mers.upload(menu);
		return "index";
	}
	
	//商家对菜品信息的修改
	@RequestMapping("/updata")
	public String updata(HttpServletRequest Request){
		//得到菜单对象
		Menu menu = new Menu();
		//对菜单对象进行赋值
		menu.setKid(Integer.parseInt(Request.getParameter("kid")==""?0+"":Request.getParameter("kid")));
		menu.setPname(Request.getParameter("pname")==""?null:Request.getParameter("pname"));
		menu.setPrice(Integer.parseInt(Request.getParameter("price")==""?0+"":Request.getParameter("price")));
		menu.setPid(Integer.parseInt(Request.getParameter("pid")));
		mers.updateMenu(menu);
		return "index";
	}
	
	//删除商家菜品
	@RequestMapping("/delete")
	public String delete(int pid){
		//根据菜品id删除
		mers.deleteMenu(pid);
		return "index";
	}
	
	//查询待处理订单并返回json格式的字符串
	@RequestMapping("/order")
	public void order(HttpServletResponse response) throws IOException{
		//得到该商家的全部待处理订单
		List<Order> or = mers.order(id);
		//将得到的数据全部转为json格式
		JSONArray json = JSONArray.fromObject(or);
		//设置编码
		response.setContentType("text/xml; charset=utf-8");
		response.setCharacterEncoding("utf-8");
		//通过输出流将json格式的字符串输出到前端
		PrintWriter out = response.getWriter();
		out.write(json.toString());
		out.flush();
		out.close();
	}
	
	//确认或取消订单，并将该订单加入到数据库，标记是否被接受
	@RequestMapping("/clean")
	public String clean(int pid, int mid, int uid,int affirm,String oid){
		//得到点击的订单
		OrderInfo orderinfo = mers.selectPid(mid, pid, uid);
		//标记订单
		orderinfo.setAffirm(affirm);
		//添加商家留言
		orderinfo.setOid(oid);
		//添加到数据库
		mers.addOrderInfo(orderinfo);
		//从待处理订单中删除该数据
		mers.clean(mid, pid, uid);
		return "index";
	}
}

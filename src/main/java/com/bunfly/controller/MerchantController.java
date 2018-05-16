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
	//ӛ��e�`��ꑴ˕r
	static int i = 0;
	//��Ů�ǰ����ߵ�id
	static int id = 0;
	
	
	public int file(MultipartFile file) throws IllegalStateException, IOException{
		//��ʱ���Ϊ�ϴ����ʼ�����
		int lo = (int)new Date().getTime();
		//String path =request.getServletContext().getRealPath("cid");
		String path = "D:\\JEE\\WorkSpace-WEB\\xxxtake-out-master\\src\\main\\webapp\\cid";
		
		String filename = file.getOriginalFilename();
		//ȡ���ϴ��ļ�����չ��
		//String ind = filename.substring(filename.lastIndexOf(".")+1);
		String newName = lo+".png";
		File f = new File(path,newName);
		file.transferTo(f);
		return lo;
	}
	//�̼�ע��
	@RequestMapping("/register")
	public String register(MultipartFile file,Merchant mer,ModelMap mm) throws IllegalStateException, IOException{
		//���ñ�����
		if("".equals(mer.getPassword())){
			mm.put("info2", "���벻��Ϊ�գ�");
			return "redirect:/merchantRegister.jsp";
		}
		if("".equals(mer.getUsername())){
			mm.put("info", "�û�������Ϊ�գ�");
			return "/merchantRegister.jsp";
		}
		if("".equals(mer.getCid())){
			mm.put("info", "��֤��Ϣ����Ϊ��");
			return "/merchantRegister.jsp";
		}
		//��ѯ���û��Ƿ��Ѿ�ע��
		Merchant me = mers.selectByName(mer);
		//����ע��
		if(me==null){
			//��ͼƬ�Ĵ����Լ��õ���ͼƬ��ʶ����
			int lo = file(file);
			mer.setMid(0);
			//����ʶ����
			mer.setHid(lo);
			//ע��
			mers.register(mer);
			Merchant meer = mers.selectByName(mer);
			//ע��ɹ�������id������ת���̼���ҳ
			id=meer.getMid();
			return "redirect:/merchantIndex.jsp";
		}
		//������ע��
		mm.put("info", "���ֻ�����ע�ᣡ");
		return "/merchantRegister.jsp";
		
	}
	
	//�̼ҵ�½
	@RequestMapping("/login")
	public String login(Merchant mer,ModelMap mm){
		//���ƴ����½�������ﵽ���ν���ת��ע�����
		if(i==2){
			i=0;
			return "redirect:/merchantRegister.jsp";
		}
		//�û�����������֤
		if("".equals(mer.getUsername())){
			mm.put("info", "�û������������");
			return "/merchantLogin.jsp";
		}
		Merchant me = mers.selectByName(mer);
		
		if(me==null){
			System.out.println("meisnull");
			mm.put("info", "�û�����������󣡴���������ת��ע�������һ�����");
			i++;
			
			return "/merchantLogin.jsp";
		}
		//��֤�ɹ�
		if(mer.getUsername().equals(me.getUsername())&&mer.getPassword().equals(me.getPassword())){
			//��½�ɹ�����id������ת���̼���ҳ
			id=me.getMid();
			return "redirect:/merchantIndex.jsp";
		}
		//��֤ʧ�ܣ��ۼ�ʧ�ܴ���
		i++;
		
		mm.put("info", "�û�����������󣡴���������ת��ע�������һ�����");
		return "/merchantLogin.jsp";
	}
	
	//�һ�����
	@RequestMapping("/findp")
	public String findP(Merchant mer,ModelMap mm){
		//���ñ�����
		if("".equals(mer.getUsername())||"".equals(mer.getCid())){
			mm.put("info", "�������û�������֤��Ϣ");
			return "/findPs.jsp";
		}
		//�����û����õ����û�����֤��Ϣ
		String pas = mers.findp(mer);
		//�ж��û�������֤��Ϣ�Ƿ�ƥ��
		if("".equals(pas)){
			mm.put("info", "�û�������֤��Ϣ����ȷ��");
			return "/findPs.jsp";
		}
		//��������
		mm.put("pas", pas);
		return "/findPs.jsp";
	}
	//��½������̼�idҪչʾ������
	@RequestMapping("/index")
	public String merchantIndex(ModelMap mm,HttpServletRequest request){
		//���ݵ�½ʱ������id�õ���½���̼�
		Merchant mname = mers.selectById(id);
		//��ѯ�����̼ҵĽ����ܶ�ͽ�����
		int allprice = mers.allprice(id);
		int allcount = mers.allcount(id);
		mm.put("allprice", allprice);
		mm.put("allcount", allcount);
		String name = mname.getUsername();
		//����һ����ҳ����
		MenuLimit ml = new MenuLimit();
		ml.setId(id);
		
		Integer page = Integer.parseInt(request.getParameter("page")==null||request.getParameter("page")==""? "1" : request.getParameter("page"));
		//����ȡ��
		ml.setCount((int)Math.ceil((double)mers.count(id)/(double)ml.getPagesize()));
		ml.setPage(page);
		ml.setPages(ml.getPagesize()*(page-1));
		//����ǰ�û����û�����������
		request.getSession().setAttribute("name", name);
		ml.setList(mers.selectMenu(ml));
		//List<Menu> menu = mers.selectMenu(id,j);
		//�ж��Ƿ�����Ʒ
//		if(menu.isEmpty()){
//			
//			mm.put("list", null);
//			return "/WEB-INF/merchantIndex.jsp";
//		}
		
		//JSONArray json = JSONArray.fromObject(menu);
		mm.put("list", ml);
		return "/WEB-INF/merchantIndex.jsp";
	}
	
	//�̼��ϴ���Ʒ
	@RequestMapping("/upload")
	public String uploadMenu(Menu menu, ModelMap mm,MultipartFile file) throws IllegalStateException, IOException{
		//������Ʒ���ͼ۸�Ϊ������
		if("".equals(menu.getPname())||"".equals(menu.getPrice())||0==menu.getKid()){
			mm.put("info", "����д������Ʒ��Ϣ��");
			return "/WEB-INF/merchantIndex.jsp";
		}
		//��ͼƬ�Ĳ���
		int lo = file(file);
		menu.setPid(0);
		//����ͼƬʶ����
		menu.setHid(lo);
		Merchant mname = mers.selectById(id);
		//������Ʒ����̼�
		menu.setMid(mname.getMid());
		mers.upload(menu);
		return "index";
	}
	
	//�̼ҶԲ�Ʒ��Ϣ���޸�
	@RequestMapping("/updata")
	public String updata(HttpServletRequest Request){
		//�õ��˵�����
		Menu menu = new Menu();
		//�Բ˵�������и�ֵ
		menu.setKid(Integer.parseInt(Request.getParameter("kid")==""?0+"":Request.getParameter("kid")));
		menu.setPname(Request.getParameter("pname")==""?null:Request.getParameter("pname"));
		menu.setPrice(Integer.parseInt(Request.getParameter("price")==""?0+"":Request.getParameter("price")));
		menu.setPid(Integer.parseInt(Request.getParameter("pid")));
		mers.updateMenu(menu);
		return "index";
	}
	
	//ɾ���̼Ҳ�Ʒ
	@RequestMapping("/delete")
	public String delete(int pid){
		//���ݲ�Ʒidɾ��
		mers.deleteMenu(pid);
		return "index";
	}
	
	//��ѯ��������������json��ʽ���ַ���
	@RequestMapping("/order")
	public void order(HttpServletResponse response) throws IOException{
		//�õ����̼ҵ�ȫ����������
		List<Order> or = mers.order(id);
		//���õ�������ȫ��תΪjson��ʽ
		JSONArray json = JSONArray.fromObject(or);
		//���ñ���
		response.setContentType("text/xml; charset=utf-8");
		response.setCharacterEncoding("utf-8");
		//ͨ���������json��ʽ���ַ��������ǰ��
		PrintWriter out = response.getWriter();
		out.write(json.toString());
		out.flush();
		out.close();
	}
	
	//ȷ�ϻ�ȡ�������������ö������뵽���ݿ⣬����Ƿ񱻽���
	@RequestMapping("/clean")
	public String clean(int pid, int mid, int uid,int affirm,String oid){
		//�õ�����Ķ���
		OrderInfo orderinfo = mers.selectPid(mid, pid, uid);
		//��Ƕ���
		orderinfo.setAffirm(affirm);
		//����̼�����
		orderinfo.setOid(oid);
		//��ӵ����ݿ�
		mers.addOrderInfo(orderinfo);
		//�Ӵ���������ɾ��������
		mers.clean(mid, pid, uid);
		return "index";
	}
}

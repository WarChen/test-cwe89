package com.sam.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sam.bean.DB;
import com.sam.bean.Saile;

/**
 * @author tanjian
 *
 */
public class saileservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");//设置编码格式
		response.setCharacterEncoding("UTF-8");
		String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
		HttpSession session = request.getSession(true);//创建一个session
		
		String type = request.getParameter("type");
		if(type==null){type="select";}
		if(type.equals("del")){//删除
			String id = request.getParameter("id");
			try {
				Saile.del(DB.getConn(), Integer.parseInt(id));//调用删除的方法
				session.removeAttribute("listsaile");
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(type.equals("select") || type.equals("add") || type.equals("update")){//查询，添加
			String sailid = request.getParameter("sailid");if(sailid==null){sailid="0";}
			String endTime = request.getParameter("endTime");if(endTime==null){endTime="";}
			String finishsail = request.getParameter("finishsail");if(finishsail==null){finishsail="";}
			String leftsail = request.getParameter("leftsail");if(leftsail==null){leftsail="";}
			String sumsail = request.getParameter("sumsail");if(sumsail==null){sumsail="";}
			String sailName = request.getParameter("sailName");if(sailName==null){sailName="";}
			String startTime = request.getParameter("startTime");if(startTime==null){startTime="";}
			
			Saile n=new Saile();
			n.setSailid(Integer.parseInt(sailid));
			n.setEndTime(endTime);
			n.setFinishsail(finishsail);
			n.setLeftsail(leftsail);
			n.setSailName(sailName);
			n.setStartTime(startTime);
			n.setSumsail(sumsail);
			session.setAttribute("saile", n);
			
			try {
				if(type.equals("select")){//查询
					List<Saile> list =Saile.find(DB.getConn(), n);//调用删除的方法
					session.setAttribute("listsaile", list);
				}else if(type.equals("add")){//添加
					Saile.add(DB.getConn(), n);//调用删除的方法
				}else if(type.equals("update")){//修改
					Saile.update(DB.getConn(), n);//调用删除的方法
					session.removeAttribute("listsaile");
				}
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		response.sendRedirect(basePath+"index.jsp");//下面是得到路径返回集合页面
	}

}

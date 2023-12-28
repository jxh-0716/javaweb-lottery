package com.servlet;

import java.util.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class judge
 */
public class judge extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public judge() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        doPost(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.setContentType("text/html;charset=utf-8");
        Set<Integer> cp = new TreeSet<Integer>();
        PrintWriter out = response.getWriter();
        try {
            // 产生随机数
            Random rand = new Random();
            while (cp.size() < 7) {
                cp.add(rand.nextInt(30) + 1);// 生成[1,31)区间的随机整数
            }
            // 接收表单数据(要类型转换)
            String num1 = (String) request.getParameter("num1");
            String num2 = (String) request.getParameter("num2");
            String num3 = (String) request.getParameter("num3");
            String num4 = (String) request.getParameter("num4");
            String num5 = (String) request.getParameter("num5");
            String num6 = (String) request.getParameter("num6");
            String num7 = (String) request.getParameter("num7");
            // 数据处理
            // 表单填写不完整(输入不合法)
            if (num1 == "" || num2 == "" || num3 == "" || num4 == "" || num5 == "" || num6 == "" || num7 == "") {
                out.println("请将表格填写完整");
            } else {
                TreeSet<String> hs = new TreeSet<String>();
                hs.add(num1);
                hs.add(num2);
                hs.add(num3);
                hs.add(num4);
                hs.add(num5);
                hs.add(num6);
                hs.add(num7);
                if (hs.size() < 7)// 输入的数据有相同的(输入不合法)
                {
                    out.println("请输入七个不同的数！");
                } else// 输入合法
                {
                    // 把String转回int
                    Integer inum1 = Integer.parseInt(num1);
                    Integer inum2 = Integer.parseInt(num2);
                    Integer inum3 = Integer.parseInt(num3);
                    Integer inum4 = Integer.parseInt(num4);
                    Integer inum5 = Integer.parseInt(num5);
                    Integer inum6 = Integer.parseInt(num6);
                    Integer inum7 = Integer.parseInt(num7);
                    Integer[] is = new Integer[7];
                    is[0] = inum1;
                    is[1] = inum2;
                    is[2] = inum3;
                    is[3] = inum4;
                    is[4] = inum5;
                    is[5] = inum6;
                    is[6] = inum7;
                    // 统计匹配(中奖)个数
                    int count = 0;
                    for (int i = 0; i < 7; i++) {
                        if (cp.contains(is[i]))
                            count++;
                    }
                    // 输出处理
                    out.println("中奖号码是：");
                    out.print(cp.toString() + "<br>");
                    if (count == 7) {
                        out.print("恭喜你中了一等奖<br>");
                    } else if (count == 6) {
                        out.print("恭喜你中了二等奖<br>");
                    } else if (count == 5) {
                        out.print("恭喜你中了三等奖<br>");
                    } else {
                        out.print("很遗憾你没有中奖<br>");
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}
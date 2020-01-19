package com.ff.po;
public class ClazzStu {
	private int clazzid;
	private String clazzname;
	private int stuid;
	private String stuname;
	private String stusex;
	
	public ClazzStu() {
		super();
	}
	public ClazzStu(int clazzid, String clazzname, int stuid, String stuname, String stusex) {
		super();
		this.clazzid = clazzid;
		this.clazzname = clazzname;
		this.stuid = stuid;
		this.stuname = stuname;
		this.stusex = stusex;
	}
	@Override
	public String toString() {
		return "ClazzStu [clazzid=" + clazzid + ", clazzname=" + clazzname + ", stuid=" + stuid + ", stuname=" + stuname
				+ ", stusex=" + stusex + "]";
	}
	public int getClazzid() {
		return clazzid;
	}
	public void setClazzid(int clazzid) {
		this.clazzid = clazzid;
	}
	public String getClazzname() {
		return clazzname;
	}
	public void setClazzname(String clazzname) {
		this.clazzname = clazzname;
	}
	public int getStuid() {
		return stuid;
	}
	public void setStuid(int stuid) {
		this.stuid = stuid;
	}
	public String getStuname() {
		return stuname;
	}
	public void setStuname(String stuname) {
		this.stuname = stuname;
	}
	public String getStusex() {
		return stusex;
	}
	public void setStusex(String stusex) {
		this.stusex = stusex;
	}
	
}

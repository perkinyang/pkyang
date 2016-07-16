#!/usr/bin/python
#coding:utf-8
import requests
import re
import time
import sys  
import os
import codecs
# import MySQLdb
import mysql.connector
from bs4 import BeautifulSoup as bsp
from requests.adapters import HTTPAdapter
from requests.packages.urllib3.util import Retry
import sqlite3
import datetime
from datetime import datetime, timedelta

reload(sys)                        
sys.setdefaultencoding('utf-8')

#tablename="four_double_zeor_number"
tablename="jbb_number"

def get_totalpage(typeparam) :
	bspurl = 'http://number.sungoin.cn/number/template/agents.do?param=findXuanHao'+typeparam;
	s = requests.Session();
	s.mount("http://number.sungoin.cn",HTTPAdapter(
    	max_retries=Retry(total=10, status_forcelist=[500, 503])
    ));
	response=s.get(bspurl);
	soup = bsp(response.content,"html.parser");
	s = soup.find_all('script');
	patt = 'val\("[0-9]+"\)';
	re_pat=re.compile(patt);
	ll = s[2].text.replace('\n',"");
	search_ret=re_pat.search(ll);
	if search_ret : 
		return int(search_ret.group().replace('val("','').replace('")',''));

def hanle_request(typeparam,pageNo) :
	arr = [];
	bspurl = 'http://number.sungoin.cn/number/template/agents.do?param=findXuanHao&type='+typeparam+"&pageNo="+str(pageNo)+"&pageSize=80";
	# bspurl = 'http://number.sungoin.cn/number/template/agents.do?param=findXuanHao&type=无规则&pageNo="+str(pageNo)+"&pageSize=80‘;
	print bspurl
	s = requests.Session();
	# s.mount(bspurl,HTTPAdapter(max_retries=10));
	s.mount("http://number.sungoin.cn",HTTPAdapter(
    	max_retries=Retry(total=10, status_forcelist=[500, 503])
    ));
	response=s.get(bspurl);
	# response = s.get(bspurl);
	soup = bsp(response.content,"html.parser");
	tds = soup.find_all('td',attrs={"width": "110px"});
	for j in range(0,len(tds)) : 
		td = tds[j];
		s = typeparam+","+td.text.strip()+","+td.find_next_sibling().text.strip();
		# arr.append(s)	
		levelparam=get_level(td.find_next_sibling().text.strip(),td.text.strip(),typeparam);
		(level,selfrule)=levelparam.split(":");
		update_sql_lite(td.text.strip(),level,selfrule,typeparam);
		# fcsv.write(s.decode("utf-8")+"\n")

def update_sql_lite(number,level,selfrule,out_type) :
	dbconnection = sqlite3.connect(os.getcwd()+os.sep+"sdemo.db");
	cu = dbconnection.cursor();
	tablerecord = cu.execute("select * from sqlite_master where type = 'table' and name='four_hunder_number'");
	if len(tablerecord.fetchall())==0:
		cu.execute('create table four_hunder_number (number_id varchar(16) primary key,level varchar(16),self_rule varchar(16),out_type varchar(16),is_sync int,gmt_create datetime,gmt_modify datetime)')
	else :
		selectnumber = cu.execute("select * from four_hunder_number where number_id = '%s'" % number);
		if len(selectnumber.fetchall()) == 1:
			# print 'exists:' + str(number)
			cu.execute("update four_hunder_number set gmt_modify = datetime('now') where number_id = ?",(number,));
		else :
			cu.execute("insert into four_hunder_number values(?,?,?,?,?,datetime('now'),datetime('now'))",(number,level,selfrule,out_type,0));
	dbconnection.commit(); 
	dbconnection.close(); 

def get_level(rule,number,inner) : 
	fuck = number.replace("-","");
	s="NORULE"
	slen=len(fuck);
	last1 = fuck[slen-1:slen];
	last2 = fuck[slen-2:slen-1];
	last3 = fuck[slen-3:slen-2];
	last4 = fuck[slen-4:slen-3];
	last5 = fuck[slen-5:slen-4];
	last6 = fuck[slen-6:slen-5];
	last7 = fuck[slen-7:slen-6];
	last8 = fuck[slen-8:slen-7];
	if(rule=="AAAB"or rule=="ABBA"or rule=="ABAA"or inner=="end88") :
		s="A";
		if(inner=="end88"):
			self=inner;
		else :
			self=rule;
		
	if(inner=="end00" or inner=="end66" or inner=="end99") :
		s="B";
		self=inner;

	if(rule=="ABC" or rule=="AABA") :
		s="B";
		self=rule;


	if(number.find("400000")  !=-1 or number.find("400111")  !=-1 or number.find("400222") !=-1  or number.find("400333")  !=-1 or number.find("400444")  !=-1 or number.find("400555")  !=-1 or number.find("400666")  !=-1 or number.find("400777")  !=-1 or number.find("400888")  !=-1 or number.find("400999")  !=-1 ) :
		s="B";
		self="400AAA****";

	if(re.match("400[0-9]00",number)):
		s="B";
		self="400*00****"; 
	if(inner=="end11" or inner=="end22" or inner=="end33" or inner=="end44" or inner=="end55" or inner=="end77") :
		s="C";
		self=inner;

	if(int(int(last3))-int(int(last2))==1 and int(int(last2))-int(int(last1))==1) :
		s="C";
		self="CBA";
	 
	if(rule=="ABBB" or rule=="AABB" or rule=="ABAB" or rule=="AABCC") :
		s="SUPER";
		self=rule;

	if(int(last7)-int(last6)==1 and int(last6)-int(last5)==1 and int(last5)-int(last4)==1 and int(last4)-int(last3)==1 and int(last3)-int(last2)==1 and int(last2)-int(last1)==1) :
		s="TOP";
		self="FEDCBA";
	 
	if(int(last7)-int(last6)==-1 and int(last6)-int(last5)==-1 and int(last5)-int(last4)==-1 and int(last4)-int(last3)==-1 and int(last3)-int(last2)==-1 and int(last2)-int(last1)==-1) :
		s="TOP";
		self="ABCDEF";
	 
	if(int(last5)-int(last4) ==1  and int(last4)-int(last3)==1 and int(last3)-int(last2)==1 and int(last2)-int(last1)==1) :
		s="TOP";
		self="DCBA";
	 
	if(int(last5)-int(last4)==-1 and int(last4)-int(last3)==-1 and int(last3)-int(last2)==-1 and int(last2)-int(last1)==-1) :
		s="TOP";
		self="ABCD";
	 
	if(int(last8)-int(last7)==-1 and int(last7)-int(last6)==-1 and int(last6)-int(last5)==-1) :
		s="TOP";
		self="400ABC";

	if(int(last8)>int(last7) and int(last7)>int(last6) and int(last6)>int(last5)) :
		s="TOP";
		self="400CBA";

	if(rule=="AAAAA" or rule=="AAABBB" or rule=="AAAA" or rule=="AABBCC" or rule=="ABCD" or rule=="ABABAB" or rule=="ABCABC" or rule=="ABCABC") :
		s="TOP";
		self=rule;
	return s+":"+self
	
def import_mysql_db() :
	threeDayAgo = (datetime.now() - timedelta(days = 3))
	threeDayAgoTime = threeDayAgo.strftime("%Y-%m-%d %H:%M:%S")
	#建立和mysql数据库的连接
	# mysqlconn = mysql.connector.connect(host="127.0.0.1",port='3306',user="root",password="tanghongliang",database="accountdb")
	#3307
	mysqlconn=mysql.connector.connect(host="139.196.21.15",port='3306',user="root",password="123456",database="jbb")
	#获取游标
	mysqlcurs = mysqlconn.cursor()
	#执行SQL,创建一个数据库
	# curs.execute("create database pythondb")
	#选择连接哪个数据库
	# mysqlconn.select_db('accountdb')
	sqliteconn = sqlite3.connect(os.getcwd()+os.sep+"sdemo.db");
	sqlitecu = sqliteconn.cursor();
	tablerecord = sqlitecu.execute("select * from sqlite_master where type = 'table' and name ='four_hunder_number'");
	if len(tablerecord.fetchall())==0:
		print "table no exists"
		return
	else :
		#一把捞完所有的
		selectnumber = sqlitecu.execute("select * from four_hunder_number where is_sync = 0");
		allnumber = selectnumber.fetchall();
		for oneline in allnumber:
			number=oneline[0]
			# print number;
			mysqldbresult = mysqlcurs.execute("select * from "+str(tablename)+ " where number = %s", (number,));
			dblen=len(mysqlcurs.fetchall());
			if dblen==0:
				mysqlcurs.execute("insert into "+str(tablename)+ " (id,number,display_number,type,level,status,original,out_type,createTime,updateTime) values(null,%s,%s,%s,%s,1,1,%s,NOW(),NOW())",(oneline[0],oneline[0],oneline[2],oneline[1],oneline[3]))
				sqlitecu.execute("update four_hunder_number set is_sync = 1")
			#执行SQL,创建一个表
			# curs.execute("create table test(id int,message varchar(50))")
			#插入一条记录
			# value = [1,"davehe"]
			# mysqlcurs.execute("insert into test values(%s,%s)",value)
			#插入多条记录
			# values = []
			# for i in range(20):
			    # values.append((i,'hello mysqldb' + str(i)))
			#curs.executemany("insert into test values(%s,%s)",values)
			#提交修改			
		noexistnumber = sqlitecu.execute("select * from four_hunder_number where gmt_modify < (?)",(threeDayAgoTime,)) ;
		allnoexistnumber = noexistnumber.fetchall();
		for oneline in allnoexistnumber:
			#删除mysql里边的数据
			mysqlcurs.execute("update " + str(tablename) + " set status=0,updateTime=NOW() where number = %s", (oneline[0],));
			sqlitecu.execute("update four_hunder_number set is_sync = 1")
		sqliteconn.commit();
		mysqlconn.commit()
		#关闭游标连接,释放资源
		mysqlcurs.close()
		#关闭连接
		mysqlconn.close()
		sqlitecu.close()
		sqliteconn.close()


arr = [];
types= [];
bspurl = 'http://number.sungoin.cn/number/template/agents.do?param=findXuanHao';
response = requests.get(bspurl);
soup = bsp(response.content,"html.parser");

numertypes = soup.find_all('div',attrs={"class":"guize_tit"});
# print len(numertypes)
for m in range(0,len(numertypes)) :
	numbertype=numertypes[m];
	aLinks=numbertype.find_next_sibling().find_all('a');
	for h in range(0,len(aLinks)) :
		link = aLinks[h];
		typeparam = link['href'].replace("javascript:sub('","").replace("')","");
		if not typeparam.startswith('end'):
			continue;
		types.append(typeparam);
		total_page=get_totalpage("&type="+typeparam)
		for p in range(1,total_page):
			hanle_request(typeparam,p);
			time.sleep(1);
		time.sleep(2);
import_mysql_db();









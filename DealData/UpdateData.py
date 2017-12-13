# -*- coding:utf-8 -*-
import pyodbc
import datetime
import time
import tushare as ts
import sys
import csv
import thread
reload(sys)                      # reload 才能调用 setdefaultencoding 方法  
sys.setdefaultencoding('utf-8')  # 设置 'utf-8' 


def Timer():
	# 设置一下开始时间，要大于当前时间
    sched_time = datetime.datetime(2017, 11, 22, 21, 50, 30)
    #间隔时间
    timedelta=datetime.timedelta(minutes=1)
    #取当下时间
    now = datetime.datetime.now()
    #判断是否开始时间已错过,如果结果为负数，则提示错误
    if str(sched_time-now)[0]=='-':
        print ('开始时间已经错过，请重新调整开始时间')
    else:
        while True:
            now = str(datetime.datetime.now())[:-7]
            if now==str(sched_time):
                print (sched_time)
                sched_time=str(datetime.datetime.now()+timedelta)[:-7]
                print (sched_time)
                # t = threading.Thread(target=DealData())
                # t.start()
                thread.start_new_thread(DealData,())
            time.sleep(1)
            print (now)


def DealData():
    start_time = datetime.datetime.now()
    data = ts.get_today_all()
    data.to_csv('temp.csv')
    inTime = GetTime()
    csvfile = open('temp.csv', 'rb')
    reader = csv.reader(csvfile)
    inTime = GetTime()
    
    conn = pyodbc.connect('DRIVER=/Users/liyuan/TimesTen/tt1122/lib/libttclient.so;TTC_SERVER=10.60.42.201;TCP_Port=53393;TTC_SERVER_DSN=my_1122;UID=sjh;PWD=sjh')
    cursor = conn.cursor()
    next(reader,None)
    for line in reader:
        if line[1][0] == '0' or line[1][0] == '6':
            sql = 'INSERT INTO DATA_REAL_TIME VALUES(SEQ_DATA_REAL_TIME.NEXTVAL,'
            # code
            sql += "'" + line[1] + "',"
            # TRADING_DAY
            sql += "TO_DATE('" + inTime + "','YYYY-MM-DD HH24:MI:SS'),"
            # OPEN_VALUE
            sql += line[5] + ","
            # CLOSE_VALUE
            sql += line[4] + ","
            # HIGH_VALUE
            sql += line[6] + ","
            # LOW_VALUE
            sql += line[7] + ","
            # VOLUME_VALUE
            sql += line[9] + ");"
    
            cursor.execute(sql)
    
    cursor.execute("Commit;")   
    print (datetime.datetime.now() - start_time)

def GetTime():    
    time = datetime.datetime.now()
    s_time = str(time)

    nPos = s_time.index('.')
    s_time = s_time[:nPos]
    return s_time

DealData()

# 这里开始
# Timer()
# 分工
- YQYjin
1. registeruser
2. getCreditCardData
3. addcreditcard
4. deletecreditcard
5. updateemail
6. booking
7. cancelbooking
8. generateticket
9. arrival_report
10. checkin_report
11. delete_booking
12. checkinroom
13. modify_price
14. getrewardreport
15. getincomereport
16. getcheckinreport
- cynlogin
1. user_login
2. employee_login
3. administrators_login
4. payment 
5. getemail  
6. getbookings
7. show_booking
8. getprice : 完成
9. backup

# 数据库更新
- bookings表添加了
  ```
    roomno int,
    base_price decimal(10,2),
    total_price decimal(10,2)
  ```
- 添加了rooms表
  ```sql
  create table rooms(
	id INT primary KEY auto_increment,
    status tinyint);
  ```
cynlogin 除了payment其他全部完成
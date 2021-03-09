package com.doanducdat.nvgcomponent
/* :%y+
1. tạo 3 fragment
2. tạo nav_graph, set up điểu hướng các fragment
3. gắn nav_graph vào thẻ FragmentContainerView
4. từ FragmentContainerView tạo ra NavController trong mainActivity*/

/* BottomNvgBar
* 1.tạo bottom_menu chứa (gồm 3 menu ứng với 3 fragment và tên id trùng vs tên fragment) và main_menu
* <BottomNavigationView> chứa bottom_menu(3item)
* <toolbar> chứa main_menu(1 item)
* setup cần thiết trong manactivity
* */

/*
truyền data = safeArgsi từ Frag 1 -> frag 2
1.tạo thẻ <argument trong nav_graph trong Frag2 để nhận
-với object, default value là null chỉ cần type = "link package" và name
vd User thì pakage com.doanducdat.nvgcomponent.User
2. rebuild projet để java(generate) dc build ra các class ứng với thẻ argument
* */
/*
deep link -> tạo 1 fargment deeplink gắn vào bottmNvgView
fragment deeplink nhận bundle của thẻ argument + push notification(click notification ->truyền bundle -> mở fragment chính nó + nhận bundle )
deeplink: thẻ url <deepLink app:uri="www.unknown.com/{argDeepLink}"/>
set up manifest <nav-graph android:value="@navigation/nav_graph"/>

* */
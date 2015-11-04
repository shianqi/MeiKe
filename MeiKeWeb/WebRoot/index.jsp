<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>AJAX with Struts 2 using AngularJS</title>
<script type="text/javascript" src="js/angular.min.js"></script>
<script type="text/javascript" src="http://libs.baidu.com/jquery/1.9.0/jquery.min.js"></script>
<script src="http://webapi.amap.com/maps?v=1.3&key=yourkey" type="text/javascript"></script>
<script type="text/javascript" src="http://webapi.amap.com/maps?v=1.3&key=e0ebd4d3aa03af7354a601561f14770b"></script>
	<script type="text/javascript">
		//地图初始化
		var map = new AMap.Map("mapContainer", {
			resizeEnable: true,
	    	//二维地图显示视口
			view: new AMap.View2D({
				//地图中心点
				center:new AMap.LngLat(116.397428,39.90923),
				//地图显示的缩放级别
				zoom:13 
			})
	    });
		//获取用户所在城市信息
		function showCityInfo() { 
			//加载城市查询插件
			var cityname = "";
			AMap.service(["AMap.CitySearch"], function() {
				//实例化城市查询类
				var citysearch = new AMap.CitySearch();
				//自动获取用户IP，返回当前城市
				citysearch.getLocalCity(function(status, result){
					if(status === 'complete' && result.info === 'OK'){
						if(result && result.city && result.bounds) {
							var cityinfo = result.city;
							var citybounds = result.bounds;
							alert("您当前所在城市：" + cityinfo + "");
							//地图显示当前城市
							cityname = cityinfo;
							map.setBounds(citybounds);
						}
					}else{
						alert("您当前所在城市：" + result.info + "");
						cityname = result.info;
					}
					
				});
				
			});
		}
	</script>
<script>
var transform = function(data){
    return $.param(data);
};
var configpost={
    headers: { 'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'},
    transformRequest: transform
  };
  
var url="login.action";
var data = { username:"18847163389",password:"123456"};
var app = angular.module('myApp', []);



function MyController($scope, $http) {
$scope.getDataFromServer = function() {
  $http.post(url,data,configpost).success(
    function(data, status, headers, config) {
      $scope.user = data;
    }).error(function(data, status, headers, config) {
        // called asynchronously if an error occurs
        // or server returns response with an error status.
  });
};
};
</script>
</head>
<body>
<div data-ng-app="myApp">
  <div data-ng-controller="MyController">
    <button data-ng-click="getDataFromServer()">
    Fetch data from server
    </button>
    <p>username : {{user.usersName}}</p>
    <p>email : {{user.email}}</p>
    <p>phoneNum : {{user.phoneNumber}}</p>
    <p>name : {{user.name}}</p>
    <p>password : {{user.password}}</p>
    <button onclick="showCityInfo()">show city</button>
  </div>
  <form method="post" action="login.action">
  	<input type="text" name="username">
  	<input type="password" name="password">
  	<input type="submit">
  		
  </form>
</div>
<a href="search.action?keyWord=英">123</a>
</body>
</html>
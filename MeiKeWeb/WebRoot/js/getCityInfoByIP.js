/**
 * 
 */

<script type="text/javascript" src="http://webapi.amap.com/maps?v=1.3&key=e0ebd4d3aa03af7354a601561f14770b"></script>
	<script type="text/javascript">
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
					//alert("您当前所在城市：" + cityinfo + "");
					//地图显示当前城市
					cityname = cityinfo;
				}
			}else{
				//alert("您当前所在城市：" + result.info + "");
				cityname =  result.info;
			}
		});
	});
	return cityname;
}
	</script>

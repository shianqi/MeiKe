var URL1="http://183.175.14.98:8080/MeiKeWeb/";
var URL2="&callback=JSON_CALLBACK";
var URL3="?callback=JSON_CALLBACK";



function autoTime(){
  localStorage.WaitTime--;
  if(localStorage.WaitTime<=0)
  {
    $('#verificationClick').removeClass('disabled');
    $('#verificationClick').html("获取验证码") ;
  }else{
    if($('#verificationClick').text()=="获取验证码")
      return;
    $('#verificationClick').addClass('disabled');
    $('#verificationClick').html("获取验证码("+localStorage.WaitTime+")") ;
    setTimeout("autoTime()",1000);
  }
}


angular.module('starter.services', [])


    .factory('Websites', function ($q, $http) {
      return {
        all: function ($scope) {
          var d = $q.defer();
          var promise = d.promise;

          $http.jsonp(URL1+"getUserInfo.action"+URL3)
              .success(function (getdata) {
                $scope.UserData = getdata;
                d.resolve(getdata);
              })
              .error(function (error) {
                d.reject(error);
              });
          promise.success = function (fn) {
            promise.then(fn);
            return promise;
          }
          promise.error = function (fn) {
            promise.then(null, fn);
            return promise;
          }

          return d.promise;
        },
        allTestSpeed: function ($scope) {
          var d = $q.defer();
          var promise = d.promise;

          $http.jsonp("http://api.shequshangdian.com/website/GetAllSitesTestSpeed?userId=" + localStorage.userid + "&signToken=" + localStorage.signtoken + "&callback=JSON_CALLBACK")
              .success(function (data) {
                $scope.testspeeddata = data;
                d.resolve(data);
              })
              .error(function (error) {
                d.reject(error);
              });
          promise.success = function (fn) {
            promise.then(fn);
            return promise;
          }
          promise.error = function (fn) {
            promise.then(null, fn);
            return promise;
          }

          return d.promise;
        },
        allSearchEngine: function ($scope) {
          var d = $q.defer();
          var promise = d.promise;

          $http.jsonp("http://api.shequshangdian.com/website/GetAllSitesSearchEngine?userId=" + localStorage.userid + "&signToken=" + localStorage.signtoken + "&callback=JSON_CALLBACK")
              .success(function (data) {
                $scope.websitesearchengine = data;
                d.resolve(data);
              })
              .error(function (error) {
                d.reject(error);
              });
          promise.success = function (fn) {
            promise.then(fn);
            return promise;
          }
          promise.error = function (fn) {
            promise.then(null, fn);
            return promise;
          }

          return d.promise;
        },
        add: function ($scope) {
          //add new website
          var d = $q.defer();
          var promise = d.promise;

          $http.jsonp("http://api.shequshangdian.com/website/AddWebsite?userId=" + localStorage.userid + "&signToken=" + localStorage.signtoken + "&url=" + $scope.data.siteurl + "&name=" + $scope.data.sitename + "&callback=JSON_CALLBACK")
              .success(function (data) {
                d.resolve(data);
              })
              .error(function (error) {
                d.reject(error);
              });

          promise.success = function (fn) {
            promise.then(fn);
            return promise;
          }
          promise.error = function (fn) {
            promise.then(null, fn);
            return promise;
          }

          return d.promise;
        },
        remove: function (allsites, site) {
          //执行数据库的删除
          var deferred = $q.defer();
          var promise = deferred.promise;
          //ajax请求
          $http.jsonp("http://api.shequshangdian.com/website/DeleteWebsite?userId=" + localStorage.userid + "&signToken=" + localStorage.signtoken + "&siteId=" + site.SiteId + "&callback=JSON_CALLBACK")
              .success(function (response) {
                //UI删除
                allsites.splice(allsites.indexOf(site), 1);
              });

          promise.success = function (fn) {
            promise.then(fn);
            return promise;
          }
          promise.error = function (fn) {
            promise.then(null, fn);
            return promise;
          }
        }
      };
    })
    .factory('SearchService',function($http){
          var cityname='';
          AMap.service(["AMap.CitySearch"], function() {
            //实例化城市查询类
            var citysearch = new AMap.CitySearch();
            //自动获取用户IP，返回当前城市
            citysearch.getLocalCity(function(status, result){
              if(status === 'complete' && result.info === 'OK'){
                if(result && result.city && result.bounds) {
                  var cityinfo = result.city;
                  var citybounds = result.bounds;
                  cityname=cityinfo;
                  //地图显示当前城市
                }
              }else{
                cityname=result.info;
              }
            });
          });
      var items=''
      return {
        searchResult: function (kw) {
          $http.jsonp(URL1+"search.action?keyWord="+kw+"&city="+cityname+URL2)
              .success(function (response){
                 items = response;
              })
          return items;
        },
        get : function(ClassId,ClassType){
          for (var i =0 ; i<items.length;i++ ){
            if(items[i].id === parseInt(ClassId)){
              return items[i];
            }
          }
          return null;
        }
      }
})


    .service('LoginService', function ($q, $http) {

      return {
        loginUser: function (name, pw) {
          var deferred = $q.defer();
          var promise = deferred.promise;


//================================================================

          //var dataOBJ = deferred.promise;
          //alert(dataOBJ);
          ////user是一个对象，这里的dataOBJ为该对象的复制
          ////alert(JSON.stringify(dataOBJ));
          ////此方法可以将js对象变成JSON
          //var transform = function (data) {
          //  return $.param(data);
          //};
          //var configpost = {
          //  headers: {'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'},
          //  transformRequest: transform
          //};
          //var url = "http://10.0.1.112:8080/MeiKeWeb/login.action";
          //var data = {username:name, password: pw};
          //var app = angular.module('myApp', []);
          //$http.post(url, data, configpost).success(
          //    function (data, status, headers, config) {
          //      $scope.person = data;
          //      alert("用户："+data.username+"登陆成功");
          //    }).error(function (data, status, headers, config) {
          //
          //      // called asynchronously if an error occurs
          //      // or server returns response with an error status.
          //    });
//================================================================================


          //var loginResult = new Object();
          //ajax请求
          //
          // alert("http://10.0.1.112:8080/MeiKeWeb/login.action?name="+name+"&password="+pw);
          $http.jsonp(URL1+"login.action?username="+name+"&password="+pw+URL2)
              .success(function (response) {
                if (response.loginStatus == 1){
                  localStorage.userid = response.usersId;
                  deferred.resolve('Welcome ' + name + '!');
                } else {
                  deferred.reject('Wrong credentials.');
                }
              });


          promise.success = function (fn) {
            promise.then(fn);
            return promise;
          }
          promise.error = function (fn) {
            promise.then(null, fn);
            return promise;
          }
          return promise;
        },


        Verification: function ($scope,phone) {

          var deferred = $q.defer();
          var promise = deferred.promise;
          //ajax请求
          $http.jsonp(URL1+"getCheckCode.action?phoneNum=" + phone  + URL2)
            //*******************************************
              .success(function (response) {
                if (response.status == 1) {
                  localStorage.WaitTime=90;
                  $('#verificationClick').html("获取验证码(90)")
                  $('#verificationClick').addClass('disabled');
                  autoTime();


                  deferred.resolve('register successfully');
                } else {
                  if(response.time!=-1)
                  {
                    $('#verificationClick').html("处理中...")
                      localStorage.WaitTime=response.time;
                      autoTime();
                  }
                  localStorage.result=response.result;
                  deferred.reject('Wrong register info.');
                }
              });
          promise.success = function (fn) {
            promise.then(fn);
            return promise;
          }
          promise.error = function (fn) {
            promise.then(null, fn);
            return promise;
          }
          return promise;
        },


        register: function (phone,verification, name, password) {
          var deferred = $q.defer();
          var promise = deferred.promise;
          //ajax请求
          $http.jsonp(URL1+"register.action?usersName=" + name + "&password=" + password + "&phoneNumber=" + phone+"&checkCode=" + verification + URL2)
              //*******************************************
              .success(function (response) {
                if (response.status == 1) {
                  deferred.resolve('register successfully');
                } else {
                  deferred.reject('Wrong register info.');
                }
              });
          promise.success = function (fn) {
            promise.then(fn);
            return promise;
          }
          promise.error = function (fn) {
            promise.then(null, fn);
            return promise;
          }
          return promise;
        },

        resetpassword: function (email) {
          var deferred = $q.defer();
          var promise = deferred.promise;
          //ajax请求
          $http.jsonp("http://api.shequshangdian.com/account/resetpassword?email=" + email + "&callback=JSON_CALLBACK")
              .success(function (response) {
                if (response == 1) {
                  deferred.resolve('reset password successfully');
                } else {
                  deferred.reject('Wrong request');
                }
              });
          promise.success = function (fn) {
            promise.then(fn);
            return promise;
          }
          promise.error = function (fn) {
            promise.then(null, fn);
            return promise;
          }
          return promise;
        }
      }
    });


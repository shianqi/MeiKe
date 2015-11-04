localStorage.WaitTime=90;

angular.module('starter.controllers', [])


    .controller('DashCtrl', function($scope, $ionicModal, $ionicPopover, $timeout, $http,$ionicHistory) {
        // Form data for the login modal
        $http.jsonp(URL1+"slidebox.action?"+URL2)
            .success(function(response){
                $scope.slidebox=response;
            })
        $scope.items = [];
        var base=0;

        // Set Ink
        ionic.material.ink.displayEffect();
        <!--刷新函数-->
        $scope.doRefresh = function() {
            // Stop the ion-refresher from spinning
            $ionicHistory.clearCache();
            $ionicHistory.clearHistory();
            $scope.$broadcast("scroll.refreshComplete");
        };
        <!--专项搜索-->
        $scope.Searchtype2 = function(){
            $http.jsonp(URL1+"searchByType2.action?"+URL2)
                .success(function(response){
                    $scope.items = response ;
                })
        }
        $scope.Searchtype3 = function(){
            $http.jsonp(URL1+"searchByType3.action?"+URL2)
                .success(function(response){
                    $scope.items = response ;
                })
        }
    })

//.controller('SearchCtrl', function($scope, $ionicModal, $ionicPopover, $timeout, $http) {
//    $scope.StartSearch  = function(Search) {
//        var dataOBJ = angular.copy(Search);
//
//        var transform = function (data) {
//            return $.param(data);
//        };
//        var configpost = {
//            headers: {'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'},
//            transformRequest: transform
//        };
//        var url = "searchAction";
//        var data = {keyWord: dataOBJ.keyWord};
//        var app = angular.module('myApp', []);
//        $http.post(url, data, configpost).success(
//            function (data, status, headers, config) {
//                $scope.person = data;
//                alert("用户："+data.username+"登陆成功");
//            }).error(function (data, status, headers, config) {
//
//                // called asynchronously if an error occurs
//                // or server returns response with an error status.
//            });
//        alert(dataOBJ.keyWord);
//    }
//    $scope.load_more = function(){
//        $timeout(function(){},500);
//    };
//
//    // Set Motion
//    ionic.material.motion.fadeSlideInRight();
//    // Set Ink
//    ionic.material.ink.displayEffect();
//    // Form data for the login modal
//})
    .controller('SearchCtrl', function($scope, $ionicModal, $ionicPopover, $timeout, $http,SearchService) {

        $scope.StartSearch  = function(Search) {
            $scope.items = SearchService.searchResult(Search)
            //    $scope.items = SearchService.searchResult($scope.Search)
        };

        // Set Motion
        ionic.material.motion.fadeSlideInRight();
        // Set Ink
        ionic.material.ink.displayEffect();
        // Form data for the login modal
    })
.controller('MeCtrl', function($scope,$http,LoginService, $ionicPopup, $state, Websites, $ionicLoading, $window, $ionicPlatform) {
      // Set Motion




        $scope.getVerification = function () {
            var phone = $scope.data.tel;
            if (checkMail(phone)) {
                LoginService.Verification($scope,phone).success(function (data) {

                }).error(function (data) {
                    var alertPopup = $ionicPopup.alert({
                        title: '手机号错误',
                        template: localStorage.result
                    });
                });
            }
            else {
                if (phone == undefined || phone == '') {
                    var alertPopup = $ionicPopup.alert({
                        title: '用户名不合法',
                        template: '请确认用户名不能为空！'
                    });
                }else{
                    var alertPopup = $ionicPopup.alert({
                        title: '手机号错误',
                        template: localStorage.result
                });
                }
            }
        }


        $scope.data = {};
        $scope.getdata = {};

        if (localStorage.haslogin == 1) {
            $ionicLoading.show({
                template: '数据加载中...'
            });

            Websites.all($scope).success(function (getdata) {
                $ionicLoading.hide();
                $("#notLogin").hide();
                $("#hasLogon").show();

            }).error(function (getdata) {
                //添加失败
                $ionicLoading.hide();
            });
        }
        else {
            $("#hasLogon").hide();
            $("#notLogin").show();
        }

        $scope.register = function () {
            //注册功能
            //检测用户输入

            //判断空的输入
            var phone = $scope.data.tel;
            var verification = $scope.data.verification;
            var name = $scope.data.username;
            var password = $scope.data.password;
            var passwordconfirm = $scope.data.passwordconfirm;
            if (checkMail(phone)) {
                //检查密码长度和两次密码是否一致
                if (name == undefined || name == '') {
                    var alertPopup = $ionicPopup.alert({
                        title: '用户名不合法',
                        template: '请确认用户名不能为空！'
                    });
                }
                else if (password.length < 6) {
                    var alertPopup = $ionicPopup.alert({
                        title: '密码长度不合格',
                        template: '请确认密码长度不低于六位！'
                    });
                }
                else {
                    if (password != passwordconfirm) {
                        var alertPopup = $ionicPopup.alert({
                            title: '两次密码不一致',
                            template: '请确认两次输入的密码一致！'
                        });
                    }
                    else {
                        //提交api，进行注册功能
                        LoginService.register(phone,verification , name,password).success(function (data) {
                            //注册成功，提示一下用户
                            var alertPopup = $ionicPopup.alert({
                                title: '注册成功',
                                template: '恭喜您注册成功，快快登录体验美课吧！'
                            });
                            alertPopup.then(function (res) {
                                //用户点击确认登录后跳转
                                $state.go("tab.Me");
                            });
                        });
                    }
                }
            }
            else {
                var alertPopup = $ionicPopup.alert({
                    title: '手机号码错误',
                    template: '请检查您填写手机号码是否正确！'
                });
            }
        };

        var checkMail = function (szMail) {
            var szReg = /^([0-9_-])/;
            var bChk = szReg.test(szMail);
            return bChk;
        }

        $scope.logout = function () {
            localStorage.haslogin = 0;
            $state.go($state.current);
            $("#hasLogon").hide();
            $("#notLogin").show();
            $scope.data.username = "";
            $scope.data.password = "";
        }


        $scope.login = function () {
            LoginService.loginUser($scope.data.username, $scope.data.password).success(function (data) {
                //登录成功
                localStorage.haslogin = 1;
                //$window.location.reload(true);
                $ionicLoading.show({
                    template: '数据加载中...'
                });

                Websites.all($scope).success(function (data) {
                    $ionicLoading.hide();
                    $("#notLogin").hide();
                    $("#hasLogon").show();

                }).error(function (data) {
                    //添加失败
                    $ionicLoading.hide();
                });

            }).error(function (data) {
                localStorage.haslogin = 0
                var alertPopup = $ionicPopup.alert({
                    title: '登录失败',
                    template: '请检查您填写的登陆信息！'
                });
            });
        }

        $scope.goregister = function () {
            $state.go('register');
        }

        $scope.gotoaccount = function () {
            $state.go("tab.Me");
        }

        $scope.forget = function () {
            //进行API提交后，发送邮件，发送成功后，进行alert提醒
            $state.go('resetpassword');
        }



      ionic.material.motion.fadeSlideInRight();
     // $scope.greeting="";


      $scope.init  = function(user) {
        //此init方法为点击按钮调用函数
        var dataOBJ = angular.copy(user);
        //user是一个对象，这里的dataOBJ为该对象的复制
        //alert(JSON.stringify(dataOBJ));
        //此方法可以将js对象变成JSON
        var transform = function (data) {
          return $.param(data);
        };
        var configpost = {
          headers: {'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'},
          transformRequest: transform
        };
        var url = "angularAction";
        var data = {username: dataOBJ.username, password: dataOBJ.password};
        var app = angular.module('myApp', []);
        $http.post(url, data, configpost).success(
            function (data, status, headers, config) {
              $scope.person = data;
            }).error(function (data, status, headers, config) {

              // called asynchronously if an error occurs
              // or server returns response with an error status.
            });
      }
      ionic.material.ink.displayEffect();
    })

.controller('AccountCtrl', function($scope) {

  $scope.settings = {
    enableFriends: true,
    alert:("rth")
  };
      // Set Motion
      ionic.material.motion.fadeSlideInRight();

      // Set Ink
      ionic.material.ink.displayEffect();
})
.controller("freshCtrl",function($scope){

})
    .controller('ClassCtrl',function($scope,$stateParams,SearchService){
       $scope.item = SearchService.get($stateParams.ClassId);
    })
    .controller('newsCtrl', function($scope, $stateParams, $timeout) {
      $scope.$parent.showHeader();
      $scope.$parent.clearFabs();
      $scope.isExpanded = true;
      $scope.$parent.setExpanded(true);
      $scope.$parent.setHeaderFab('right');

      $timeout(function() {
        ionic.material.motion.fadeSlideIn({
          selector: '.animate-fade-slide-in .item'
        });
      }, 200);

      // Activate ink for controller
      ionic.material.ink.displayEffect();
    });



// Ionic Starter App

// angular.module is a global place for creating, registering and retrieving Angular modules
// 'starter' is the name of this angular module example (also set in a <body> attribute in index.html)
// the 2nd parameter is an array of 'requires'
// 'starter.services' is found in services.js
// 'starter.controllers' is found in controllers.js
angular.module('starter', ['ionic', 'starter.controllers', 'starter.services','ionMdInput','ngCordova'])

    .run(function ($cordovaNetwork) {


        document.addEventListener("deviceready", function () {

            //var type = $cordovaNetwork.getNetwork()
            ////
            //var isOnline = $cordovaNetwork.isOnline()
            ////
            //var isOffline = $cordovaNetwork.isOffline()

            // listen for Online event
            $rootScope.$on('$cordovaNetwork:online', function (event, networkState) {
                var onlineState = networkState;
                console.log("device online...");
            })

            // listen for Offline event
            $rootScope.$on('$cordovaNetwork:offline', function (event, networkState) {
                var offlineState = networkState;
                //提醒用户的网络异常
                $ionicLoading.show({
                    template: '网络异常，不能连接到服务器！'
                });
            })

        }, false);
    })

    .config(function($stateProvider, $urlRouterProvider,$ionicConfigProvider) {

      $ionicConfigProvider.platform.ios.tabs.style('standard');
      $ionicConfigProvider.platform.ios.tabs.position('bottom');
      $ionicConfigProvider.platform.android.tabs.style('standard');
      $ionicConfigProvider.platform.android.tabs.position('standard');

      $ionicConfigProvider.platform.ios.navBar.alignTitle('center');
      $ionicConfigProvider.platform.android.navBar.alignTitle('left');

      $ionicConfigProvider.platform.ios.backButton.previousTitleText('').icon('ion-ios-arrow-thin-left');
      $ionicConfigProvider.platform.android.backButton.previousTitleText('').icon('ion-android-arrow-back');

      $ionicConfigProvider.platform.ios.views.transition('ios');
      $ionicConfigProvider.platform.android.views.transition('android');


      // Ionic uses AngularUI Router which uses the concept of states
      // Learn more here: https://github.com/angular-ui/ui-router
      // Set up the various states which the app can be in.
      // Each state's controller can be found in controllers.js
      $stateProvider


        // setup an abstract state for the tabs directive
          .state('tab', {
            url: "/tab",
            abstract: true,
            templateUrl: "templates/tabs.html"
          })

        // Each tab has its own nav history stack:

          .state('tab.dash', {
            url: '/dash',
              cach:false,
            views: {
              'tab-dash': {
                  cache: false,
                templateUrl: 'templates/tab-dash.html',
                controller: 'DashCtrl'
              }
            }
          })
          .state('tab.news', {
              url: '/news',
              views: {
                  'menuContent': {
                      templateUrl: 'templates/tab-news.html',
                      controller: 'newsCtrl'
                  },
                  'fabContent': {
                      template: '<button id="fab-activity" class="button button-fab button-fab-top-right expanded button-energized-900 flap"><i class="icon ion-paper-airplane"></i></button>',
                      controller: function ($timeout) {
                          $timeout(function () {
                              document.getElementById('fab-activity').classList.toggle('on');
                          }, 200);
                      }
                  }
              }
          })
          .state('tab.Me', {
            url: '/Me',
            views: {
              'tab-Me': {
                  cache: false,
                  templateUrl: 'templates/tab-Me.html',
                  controller: 'MeCtrl'
              }
            }
          })

          .state('resetpassword', {
              url: '/tab/account/resetpassword',
              cache: false,
              templateUrl: 'templates/resetpassword.html',
              controller: 'MeCtrl'
          })

          .state('register', {
              url: '/register',
              cache: false,
              templateUrl: 'templates/register.html',
              controller: 'MeCtrl'
          })

          .state("search",{
              url: '/search',
              cache: false,
              templateUrl: 'templates/tab-search.html',
              controller: 'SearchCtrl'

          })

          .state('class',{
              url:'/search/:ClassId',
              templateUrl:'templates/tab-class.html',
              controller:'ClassCtrl'
          })
          .state('tab.account', {
            url: '/account',
            views: {
              'tab-account': {
                templateUrl: 'templates/tab-account.html',
                controller: 'AccountCtrl'
              }
            }
          });

      // if none of the above states are matched, use this as the fallback
      $urlRouterProvider.otherwise('/tab/dash');

    });



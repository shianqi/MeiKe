<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AJAX with Struts 2 using AngularJS</title>
<script type="text/javascript" src="js/angular.min.js"></script>
<script>
var app = angular.module('myApp', []);
function MyController($scope, $http) {
$scope.getDataFromServer = function() {
  $http.get("angularAction").success(
    function(data, status, headers, config) {
      $scope.person = data;
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
    <p>First Name : {{person.firstName}}</p>
    <p>Last Name : {{person.lastName}}</p>
  </div>
</div>
</body>
</html>
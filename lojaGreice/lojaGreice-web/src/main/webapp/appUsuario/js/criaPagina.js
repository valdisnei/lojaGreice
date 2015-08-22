'use strict';

/* Controllers */


var app = angular.module('ngdemo');


app.controller('criaPaginaController', ['$scope', '$http', function ($scope, $http) {
	
	$scope.page.setTitle(" valdis App");
	
	var menuList = this;
	$scope.menu = [];
 
    $scope.addMenu = function() {
    	$scope.menu.push({text:$scope.menuText, href_menu:$scope.href_menu});
    	$scope.menuText = '';
    	$scope.href_menu = '';
    };
    
    
    
   


//    $scope.insertMenu =function(){
//
//    	var headers = {
//				'Access-Control-Allow-Origin' : '*',
//				'Access-Control-Allow-Methods' : 'POST, GET, OPTIONS, PUT',
//				'Content-Type': 'application/json',
//				'Accept': 'application/json'};
//    	
//	    $http({
//        url: 'http://localhost:8080/crudWeb/addMenu',
//        method: "POST",
//        headers: headers,
//        data: {
//      			"texto": ""
//      		}}
//		    }).success(function(result) {
//		    	$scope.menu.id=result.id;
//		    	$scope.mensagem=result;
//							
//		    }).error(function(data, status, headers, config) {
//				$scope.mensagem=data.message;
//		    });
//
//    };    
    
  


}]);

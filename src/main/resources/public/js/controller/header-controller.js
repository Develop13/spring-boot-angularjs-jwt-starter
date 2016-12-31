(function(){
	angular.module('HeaderController', []).controller("header-controller", function($scope, $state, User){
		if($state.$current.includes.home) { $scope.login = true; $scope.register = true; }
		else if($state.$current.includes.login) { $scope.login = false; $scope.register = true; }
		else if($state.$current.includes.register) { $scope.login = true; $scope.register = false; }
		else {$scope.login = false; $scope.register = false; $scope.profile = true; }
		
	});
}());

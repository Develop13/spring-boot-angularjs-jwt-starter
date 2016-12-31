(function(){
	angular.module('LoginController', []).controller("login-controller", function($scope, User){
		$scope.login = function (form, credential) {
			if(form.$valid) {
				User.login(credential).success(function(response){
					if(response.status) {
						User.setToken(response.token);
					}
				});
			} else {
				form.email.$setTouched();
				form.password.$setTouched()
			}
		}
	});
}());

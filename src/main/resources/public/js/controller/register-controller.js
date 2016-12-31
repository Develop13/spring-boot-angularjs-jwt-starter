(function(){
	angular.module('RegisterController', []).controller("register-controller", function($timeout, $state, $scope, User){
		
		/* For User Registration */
		
		$scope.register = function (form, user) {
			if(form.$valid) {
				User.register(user).then(function(response){
					if(response.status === 201){
						$scope.successfullyRegistered = true;
						$scope.successfullyRegisteredMessage = 'Heyy! You are now successfully registered. Please Wait ...';
						$timeout(function(){
							$scope.successfullyRegistered = false;
							$state.go('login');
						}, 5000);
					} else {
						invalidRegistration(form);
					}
				});
			} else {
				invalidRegistration(form);
			}
		}
		
		/* For Invalid Registration Errors */
		
		invalidRegistration = function(form) {
			$scope.registrationError = true;
			if(form.$valid) { $scope.registrationErrorMessage = "Oops! Something went wrong. Please try again later."; }
			if(!form.$valid) { $scope.registrationErrorMessage = "Oops! Please fill all data correct and then try again."; }
			$timeout(function(){
				$scope.registrationError = false;
			}, 5000);
			
			form.name.$setTouched();
			form.username.$setTouched();
			form.email.$setTouched();
			form.password.$setTouched();
			form.cnf_password.$setTouched();
		}
		
	});
}());

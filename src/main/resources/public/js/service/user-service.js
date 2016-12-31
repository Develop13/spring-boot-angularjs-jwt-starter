(function(){
	angular.module('UserService', []).factory("User", function($http, $cookies){
		return {
			register : function (user) { return $http.post("/user/save", user); },
			
			login : function(credential) { return $http.post("/user/login", credential); },
			
			setToken : function(token) { $cookies.put("bkAppToken", token); },
			
			unSetToken : function() { $cookies.remove("bkAppToken"); },
			
			checkToken : function() { return $http.get("/user/checkToken", $cookies.get("bkAppToken")); }
		}
	});
}());

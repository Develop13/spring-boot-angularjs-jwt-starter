(function(){
	angular.module('MyStarterApp', [
        'ui.router',
        'ngMessages',
        'ngCookies',
        'UserService',
        'HomeController',
        'HeaderController',
        'LoginController',
        'RegisterController',
        'ProfileController'
        
        ]).config(function($stateProvider, $urlRouterProvider){
		$urlRouterProvider.otherwise('/');
		$stateProvider.state('home', {
            url: '/',
            views : {
	            	'': {
	            		templateUrl: 'views/home.html',
	                    controller: 'home-controller'
	            	},
					'header@home' : {
						templateUrl: 'views/header.html',
						controller: 'header-controller'
					}
            }
            
        });
		$stateProvider.state('login', {
            url: '/login',
            views : {
	            	'': {
	            		templateUrl: 'views/login.html',
	                    controller: 'login-controller'
	            	},
					'header@login' : {
						templateUrl: 'views/header.html',
						controller: 'header-controller'
					}
            }
            
        });
		$stateProvider.state('register', {
            url: '/register', 
            views : {
            		'' : {
            			templateUrl: 'views/register.html',
                        controller: 'register-controller'
            		},
					'header@register' : {
						templateUrl: 'views/header.html',
						controller: 'header-controller'
					}
            }
            
        });
		$stateProvider.state('profile', {
            url: '/profile/:id', 
            views : {
            		'' : {
            			templateUrl: 'views/profile.html',
                        controller: 'profile-controller'
            		},
					'header@profile' : {
						templateUrl: 'views/header.html',
						controller: 'header-controller'
					}
            }
            
        });
	});
}());
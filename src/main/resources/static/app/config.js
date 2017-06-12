angular.module('app')
    .config(function ($routeProvider, $httpProvider) {
        $routeProvider
            .when('/list', {
                templateUrl: 'app/books/list/list.html',
                controller: 'ListController',
                controllerAs: 'listCtrl'
            })
            .when('/details/:id', {
                templateUrl: 'app/books/details/details.html',
                controller: 'DetailsController',
                controllerAs: 'detailsCtrl'
            })
            .when('/new', {
                templateUrl: 'app/books/new/new.html',
                controller: 'NewController',
                controllerAs: 'newCtrl'
            })
            .when('/login', {
                templateUrl: 'app/auth/login.html',
                controller: 'AuthenticationController',
                controllerAs: 'authController'
            })
            .when('/rlist', {
                templateUrl: 'app/rents/list/list.html',
                controller: 'RentlController',
                controllerAs: 'remtlCtrl'
            })
            .when('/rent', {
                templateUrl: 'app/rents/nrent/new.html',
                controller: 'nrentController',
                controllerAs: 'rentCtrl'
            })
            .otherwise({
                redirectTo: '/list'
            });
        $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';
        console.log('config complete')
    });
console.log('after config set');
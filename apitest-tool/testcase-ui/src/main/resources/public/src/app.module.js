

/*var myapp = angular.module("myapp", ['ui.router','app.tapi','ngStorage','app.pronetwork']);*/
var myapp = angular.module("myapp", ['ui.router','ngStorage','app.tapi']);
angular.module('app.tapi', []);

myapp.config(function($stateProvider, $urlRouterProvider) {

    $urlRouterProvider.otherwise('/viewTestCaseList');
    $stateProvider

        .state('login', {
            //  Posts state. This state will contain nested views
            url: '/viewTestCaseList',
            templateUrl: 'src/modules/views/viewTestCaseList.html'
        })
        .state('viewTestSuite', {
            //  Posts state. This state will contain nested views
            url: '/viewTestSuite',
            templateUrl: 'src/modules/views/viewTestCaseList.html'
        })
        .state('viewTestCase', {
            //  Posts state. This state will contain nested views
            url: '/viewTestCase',
            templateUrl: 'src/modules/views/viewTestCaseList.html'
        })
	    .state('createTestSuite', {
	        //  Posts state. This state will contain nested views
	        url: '/createTestSuite',
	        templateUrl: 'src/modules/views/createTestSuite.html'
	    })
	    .state('createTestCase', {
	        //  Posts state. This state will contain nested views
	        url: '/createTestCase',
	        templateUrl: 'src/modules/views/createTestCase.html'
	    });



});



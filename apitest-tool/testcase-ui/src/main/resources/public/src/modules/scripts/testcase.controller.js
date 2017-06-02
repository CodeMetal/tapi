/**
 * Created by bhandr1 on 5/13/2016.
 */


(function () {
    angular.module('app.tapi').controller('TestCaseController',TestCaseController);

    function TestCaseController($scope,TestCaseModel,TestCaseBasicFactory,$sessionStorage,$state){

        init();

        function init() {
            initModels();
           
           
                $scope.testCasesList = [];
            	
            	
                TestCaseBasicFactory.getAllTestCases().then(success,error);
            	function success(response) {
            		$scope.testCasesList = response.data;
                }
                function error(response) {
                	
                }
                
            
        }

        function initModels() {
            
        	
        	$scope.testCaseModel = TestCaseModel.newTestCaseModel();
        }
        function reset() {
        	$scope.name = "";
        	$scope.testCasesList = "";
        }


        
        
        
        $scope.createTestCase = function () {
        	$state.go('createTestCase');
        };
        
       
        
        $scope.saveTestCase = function () {
       	 $scope.testCaseModel.scenarioName = $scope.name;
       	 $scope.testCaseModel.scenarioDescription = $scope.description;
       	$scope.testCaseModel.endPointURI = $scope.endPointURI;
       	$scope.testCaseModel.endPointHost = $scope.endPointHost;
       	$scope.testCaseModel.endPointPort = $scope.endPointPort;
       	$scope.testCaseModel.requestMethod = $scope.requestMethod;
       	$scope.testCaseModel.responseType = $scope.responseType;
       	TestCaseBasicFactory.createTestCaseData($scope.testCaseModel).then(success, error);
            function success(response) {
            	reset();
            	$state.go('viewTestCase');
            }
            function error(response) {
            	reset();
            }
           
           
       };
        
        
        
       
        
      
        
        $scope.testCaseList = function () {
        	
        	$scope.testCasesList = [];
        	
        	
        	TestCaseBasicFactory.getAllTestCases().then(success,error);
        	function success(response) {
        		$scope.testCasesList = response.data;
        		$state.go('viewTestCase');
            }
            function error(response) {
            	
            }
            
        }

        

        

        
    }
    TestCaseController.$inject = ['$scope','TestCaseModel','TestCaseBasicFactory','$sessionStorage','$state'];

})();

